package cn.peyton.plum.mall.controller.base;

import cn.peyton.plum.core.cache.LocalCache;
import cn.peyton.plum.core.cipher.BaseCipher;
import cn.peyton.plum.core.imgs.ImageProcessing;
import cn.peyton.plum.core.inf.controller.RealizeController;
import cn.peyton.plum.core.inf.service.base.IUserService;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.users.BaseUser;
import cn.peyton.plum.core.users.IUser;
import cn.peyton.plum.core.utils.*;
import cn.peyton.plum.core.validator.Regulation;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * <h4>用户公共操作类</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.mall.controller.base.
 * @date 2023年12月25日 21:31
 * @version 1.0.0
 * </pre>
 */
@Controller
public class UserOperationController extends RealizeController {

    // 用户账户登录"content-type":"application/x-www-form-urlencoded;charset=utf-8"
    /**
     * <h>用户登录</h>
     * @param keyword 账号|邮箱|手机
     * @param password 密码
     * @param user 当前对象{new 一个对象}
     * @param key 密码加密 key 值
     * @param userType 当前用户类型 0 会员[member] 1 顾客[customer] 2 供应商[supplier] 3 用户[user] 4 员工[employee] 5 超级管理员[admin]
     * @param service 当前对象 service 层
     * @param request
     * @return
     */
    public JSONResult<?> login(String keyword,String password, BaseUser user,String key,Integer userType, IUserService service,
                                HttpServletRequest request){
        user.setLoginType(IUser.LOGIN_TYPE_ACCOUNT);
        if (Regulation.regex(Regulation.REGEX_EMAIL_ALL ,keyword)){
            user.setLoginType(IUser.LOGIN_TYPE_EMAIL);
        } else if ((Regulation.regex(Regulation.REGEX_PHONE, keyword))) {
            user.setLoginType(IUser.LOGIN_TYPE_PHONE);
        }
        // 判断是否可用 ,返回 true 表示应该用户被禁用
        if(service.checkStatus(keyword,user.getLoginType(),STATUS_0)){
            return JSONResult.fail("该用户已被禁用,请联系管理员。");
        }

        // 根据用户邮箱/手机号/账号 登录 ; 返回 为空表示 应该用户账号密码不正确 ;
        String _tmp = BaseCipher.encoderMD5(password, key);
        BaseUser _param = (BaseUser) service.login(keyword, _tmp, user.getLoginType());
        if(null == _param){
            return JSONResult.fail("用户名称或密码错误。");
        }

        // 更新最后登录 IP
        user.setId(_param.getId());
        user.setLastIp(IpUtils.getRemoteIp(request));
        user.setLastLoginTime(DateUtils.timestampToStrDate(new Date()));
        if(!service.updateLastLogin(user)){
            return JSONResult.fail("用户登录异常,请联系管理员。");
        }
        _param.setUserType(userType);
        _param.setLoginType(user.getLoginType());
        _param.setToken(saveToken(_param));

        return JSONResult.success("用户登录成功", _param);
    }

    // 用户退出
    public JSONResult<?> logout() {
        if(verifyToken()){
            return JSONResult.success("退出成功");
        }
        return JSONResult.fail("非法 Token");
    }

    // 修改用户密码

    /**
     * <h4>修改用户密码</h4>
     * @param id 当前用户主键 Id
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @param confirmPassword 新确认密码
     * @param key 密码加密 key 值
     * @param service 当前对象 service 层
     * @return
     */
    public JSONResult<?> editPassword(Long id, String oldPassword, String newPassword, String confirmPassword,
                                      String key,IUserService service) {

        String _tmpOldPwd = BaseCipher.encoderMD5(oldPassword, key);

        if (!service.isPassword(id, _tmpOldPwd)) {
            return JSONResult.fail("旧密码输入不正确");
        }
        if (!newPassword.equals(confirmPassword)) {
            return JSONResult.fail("确认密码输入有误,请重新输入。");
        }
        String newPwd = BaseCipher.encoderMD5(newPassword, key);
        if (_tmpOldPwd.equals(newPwd)) {
            return JSONResult.fail("新密码与旧密码相同,不需要修改。");
        }

        return (service.updatePassword(id, newPwd)) ? JSONResult.success("密码更新成功")
                : JSONResult.fail("密码更新失败。");
    }

    /**
     * <h4>发送验证码</h4>
     *
     * @param phone       手机号码
     * @param keySaveTime 保存时间 key
     * @param keyCode     验证码 key {存放session}
     * @param keyPhone    手机 key {存放session}
     * @param service     当前对象 service 层
     * @return
     */
    public JSONResult<?> sendCode(String phone, String keySaveTime, String keyCode, String keyPhone, IUserService service) {
        // 获取 当前手机号码用户 状态 null 手机号不存在  1 启用 0 禁用
        Integer status = service.isPhone(phone);
        if (null == status) {
            return JSONResult.fail("该手机号码不存在,请注册");
        } else if (status == 0) {
            return JSONResult.fail("该手机号码被禁用,请联系管理员");
        }

        // 判断是否已经提交过
        LocalCache cache = LocalCache.getInstance();
        Object _objTime = cache.get(keySaveTime);
        long _currTime = System.currentTimeMillis();
        if (null != _objTime) {
            long _oldTime = Long.parseLong(_objTime.toString());
            // 判断时间为 60秒
            if ((_currTime / 1000) - (_oldTime / 1000) <= 60) {

                return JSONResult.fail("[校验] 发送验证码太快了。");
            }
        }
        cache.put(keySaveTime, _currTime);

        //生产 随机数
        StringBuffer code = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            int r = (int) (Math.random() * 10);
            code.append(r);
        }
        HttpSession session = HttpServletRequestUtils.getSession();
        session.setAttribute(keyCode, code);
        session.setAttribute(keyPhone, phone);

        //todo 后期更新 阿里大于
        //AliSMSUtil.sendCode(phone, code.toString());

        //发送验证逻辑
        return JSONResult.success(MessageUtils.createSMSTemplate(code + ""));
    }

    /**
     * <h4>编辑用户头像</h4>
     * @param file
     * @param id
     * @param service
     * @return
     */
    public JSONResult<?> editAvatar(MultipartFile file, Long id, IUserService service) {

        if (null == file) {
            return JSONResult.fail("上传文件不能为空");
        }
        String _path = null;
        boolean _ub = true;
        try {
            _path = ImageProcessing.execute(file.getInputStream(), file.getOriginalFilename(),
                    PATH_IMG_AVATAR, null);

            if (service.updateAvatar(id,PATH_IMG_AVATAR_SIMPLE + _path)) {
                _ub = false;
                return JSONResult.success("头像更新成功");
            }

        } catch (Exception e) {
            LogUtils.error(e.getMessage());
            return JSONResult.fail("文件读取出错了(~^~)");
        }finally {
            //判断
            if(_ub){
                //删除头像
                FileUtils.delFile(PATH_IMG_AVATAR + _path);
            }
        }
        return JSONResult.fail("头像更新失败");
    }
}
