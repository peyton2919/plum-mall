package cn.peyton.plum.mall.controller;

import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.cache.LocalCache;
import cn.peyton.plum.core.cipher.BaseCipher;
import cn.peyton.plum.core.imgs.ImageProcessing;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.users.IUser;
import cn.peyton.plum.core.utils.*;
import cn.peyton.plum.core.validator.Regulation;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.Length;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.core.validator.constraints.Phone;
import cn.peyton.plum.mall.controller.base.PcController;
import cn.peyton.plum.mall.param.UserParam;
import cn.peyton.plum.mall.service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * <h3> 系统用户 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
@RestController
@RequestMapping("/pc/manager/user")
@CrossOrigin(origins = "*")
public class UserController extends PcController<UserParam> {
    /** 验证码 在缓存中的时间 */
    public final static String KEY_PHONE_CODE_CACHE_TIME = "PHONE_TIME_2203262148";
    /** session中的 验证码 key */
    public final static String KEY_SESSION_PHONE_CODE = "SESSION_PHONE_CODE_220323";
    /** session中的 手机号码 key */
    public final static String KEY_SESSION_PHONE = "SESSION_PHONE_220324";

    /** MD5 加密 key */
    private final static String KEY_PASSWORD_ENCODER = "userControllerPassword";

    @Resource
    private UserService userService;

    // 发送验证码
    @PostMapping("/sendcode")
    @Valid
    public JSONResult<?> sendCode(
            @NotBlank(message = "手机号码不能为空!")
            @Phone
            String phone){
        // 判断是否可用 ,返回 true 表示应该手机被禁用
        UserParam param = new UserParam();
        //先判断手机号码 是否存在, 不存在就返回false;
        param.setPhone(phone);
        if(!userService.isRename(param)){
            return JSONResult.fail("该手机号码不存在,请注册");
        }

        // 判断是否可用 ,返回 true 表示应该手机被禁用
        param.setStatus(0);
        if(userService.isRename(param)){
            return JSONResult.fail("该手机号码被禁用,请联系管理员");
        }

        // 判断是否已经提交过
        LocalCache cache = LocalCache.getInstance();
        Object _objTime = cache.get(KEY_PHONE_CODE_CACHE_TIME);
        long _currTime = System.currentTimeMillis();
        if (null != _objTime) {
            long _oldTime = Long.parseLong(_objTime.toString());
            // 判断时间为 60秒
            if ((_currTime / 1000) - (_oldTime / 1000) <= 60) {

                return JSONResult.fail("[校验] 发送验证码太快了。");
            }
        }
        cache.put(KEY_PHONE_CODE_CACHE_TIME, _currTime);

        //生产 随机数
        StringBuffer code = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            int r = (int) (Math.random() * 10);
            code.append(r);
        }
        HttpSession session = HttpServletRequestUtils.getSession();
        session.setAttribute(KEY_SESSION_PHONE_CODE, code);
        session.setAttribute(KEY_SESSION_PHONE, phone);

        //todo 后期更新 阿里大于
        //AliSMSUtil.sendCode(phone, code.toString());

        //发送验证逻辑
        return JSONResult.success(MessageUtils.createSMSTemplate(code + ""));
    }

    // 用户注册UserParam userParam
    @GetMapping("/reg")
    @Valid(single = false)
    public JSONResult<?> reg(){
        //if (userService.checkStatus(userParam.getUsername(), IUser.LOGIN_TYPE_ACCOUNT, STATUS_MINUS)) {
        //    return JSONResult.fail("该用户名称已经存在,请重新输入。");
        //}else if (userService.checkStatus(userParam.getPhone(), IUser.LOGIN_TYPE_PHONE, STATUS_MINUS)){
        //    return JSONResult.fail("该手机号码已经存在,请重新输入。");
        //} else if (userService.checkStatus(userParam.getEmail(), IUser.LOGIN_TYPE_EMAIL, STATUS_MINUS)) {
        //    return JSONResult.fail("该邮箱号已经存在,请重新输入。");
        //}
        UserParam userParam = new UserParam();
        userParam.setEmail("9602588@qq.com");
        userParam.setPassword("123456");
        userParam.setUsername("tom1");
        userParam.setPhone("13500001234");
        userParam.setNickName("tom1");
        // 密码加密
        userParam.setPassword(BaseCipher.encoderMD5(userParam.getPassword(),KEY_PASSWORD_ENCODER));
        UserParam _param = userService.reg(userParam);
        return (null != _param)?JSONResult.success(_param):JSONResult.fail("注册失败,请联系管理员。");
    }

    @PostMapping("/getinfo")
    @Token
    public JSONResult<?> findJoinById(){
        UserParam userParam = handleToken(new UserParam());
        if(null != userParam){
            return JSONResult.success(userService.findJoinById(userParam.getId(),2));
        }
        return JSONResult.fail("获取用户信息失败!!!");
    }



    // 用户账户登录"content-type":"application/x-www-form-urlencoded;charset=utf-8"
    @PostMapping("/login")
    @Valid
    public JSONResult<?> login(@NotBlank(message = "用户名不能为空！") String keyword,
                                       @NotBlank(message = "密码不能为空！") String password,
                    HttpServletRequest request) {
        UserParam param = new UserParam();
        String _loginType = IUser.LOGIN_TYPE_ACCOUNT;
        if (Regulation.regex(Regulation.REGEX_EMAIL_ALL ,keyword)){
            _loginType = IUser.LOGIN_TYPE_EMAIL;
        } else if ((Regulation.regex(Regulation.REGEX_PHONE, keyword))) {
            _loginType = IUser.LOGIN_TYPE_PHONE;
        }

        // 判断是否可用 ,返回 true 表示应该用户被禁用
        if(userService.checkStatus(keyword,param.getLoginType(),STATUS_0)){
            return JSONResult.fail("该用户已被禁用,请联系管理员。");
        }

        // 根据用户邮箱/手机号/账号 登录 ; 返回 为空表示 应该用户账号密码不正确 ;
        String _tmpp = BaseCipher.encoderMD5(password, KEY_PASSWORD_ENCODER);
        UserParam _param = userService.login(keyword,_tmpp
                , _loginType);
        if(null == _param){
            return JSONResult.fail("用户名称或密码错误。");
        }
        // 更新最后登录 IP
        UserParam _uIp = new UserParam();
        _uIp.setId(_param.getId());
        _uIp.setLastIp(IpUtils.getRemoteIp(request));
        _uIp.setLastLoginTime(DateUtils.timestampToStrDate(new Date()));
        if(!userService.update(_uIp)){
            return JSONResult.fail("用户登录异常,请联系管理员。");
        }
        _param.setLoginType(_loginType);
        _param.setToken(saveToken(_param));
        return JSONResult.success(_param);
    }

    // 用户退出
    @PostMapping("/logout")
    public JSONResult<UserParam> logout() {
        if(verifyToken()){
            return JSONResult.success("退出成功");
        }
        return JSONResult.fail("非法 Token");
    }
    // 搜索用户
    @PostMapping("/search")
    @Valid
    public JSONResult<?> search(@NotBlank(message = "搜索字段不能为空！")String keyword,
                                @Min(message = "要大于0的数！")Integer pageNo){
        UserParam _param = new UserParam();
        _param.setUsername(keyword);
        return JSONResult.success(userService.findByLikeAndObj(_param, new PageQuery(pageNo)));
    }
    // 编辑用户头像
    @PostMapping("/edituseravatar")
    @Token
    public JSONResult<?> editAvatar(MultipartFile file, HttpServletRequest request) {
        UserParam _param = handleToken(new UserParam());
        if (null == file) {
            return JSONResult.fail("上传文件不能为空");
        }
        String _path = null;
        boolean _ub = true;
        try {
            _path = ImageProcessing.execute(file.getInputStream(), file.getOriginalFilename(),
                    PATH_IMG_AVATAR, null);
            UserParam _tmpParam = new UserParam();
            _tmpParam.setId(_param.getId());
            _tmpParam.setAvatar(PATH_IMG_AVATAR_SIMPLE + _path);

            if (userService.update(_tmpParam)) {
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
    // 编辑用户资料
    @Token
    @Valid
    @PostMapping("/edituser")
    public JSONResult<?> editUser(UserParam param) {
        // 从 token 获取 对象
        UserParam userParam = handleToken(param);
        // todo
        if(!userParam.getUsername().equals(param.getUsername())){
            if (userService.checkStatus(userParam.getUsername(), IUser.LOGIN_TYPE_ACCOUNT, STATUS_MINUS)) {
                return JSONResult.fail("该用户名称已经存在,请重新输入。");
            }
        }else if (!userParam.getPhone().equals(param.getPhone())){
            if (userService.checkStatus(userParam.getPhone(), IUser.LOGIN_TYPE_PHONE, STATUS_MINUS)){
                return JSONResult.fail("该手机号码已经存在,请重新输入。");
            }
        }else if(!userParam.getEmail().equals(param.getEmail())){
            if (userService.checkStatus(userParam.getEmail(), IUser.LOGIN_TYPE_EMAIL, STATUS_MINUS)) {
                return JSONResult.fail("该邮箱号已经存在,请重新输入。");
            }
        }
        param.setId(userParam.getId());
        param.setIsDel(null);
        param.setCreateTime(null);
        param.setPassword(null);
        param.setStatus(null);
        return (userService.update(param)) ? JSONResult.success("更新成功", param)
                : JSONResult.fail("注册失败,请联系管理员。");
    }

    // 修改用户密码
    @Valid
    @Token
    @PostMapping("/uppassword")
    public JSONResult<UserParam> editPassword(
          @NotBlank(message = "旧密码不能为空！")
          @Length(min = 6,max = 30,message = "密码长度为6~30的字符!")
          String oldPassword,
          @NotBlank(message = "新密码不能为空！")
          @Length(min = 6,max = 30,message = "密码长度为6~30的字符!")
          String newPassword,
          @NotBlank(message = "确认密码不能为空！")String confirmPassword) {
        // 从 token 获取 对象
        UserParam _userParam = handleToken(new UserParam());
        UserParam _tmpParam = new UserParam();
        _tmpParam.setId(_userParam.getId());
        _tmpParam.setPassword(BaseCipher.encoderMD5(oldPassword,KEY_PASSWORD_ENCODER));
        String _opTmp = _tmpParam.getPassword();

        // todo
        if(!userService.isRename(_tmpParam)){
            return JSONResult.fail("旧密码输入不正确");
        }
        if (!newPassword.equals(confirmPassword)) {
            return JSONResult.fail("确认密码输入有误,请重新输入。");
        }
        String newPwd = BaseCipher.encoderMD5(newPassword, KEY_PASSWORD_ENCODER);
        if (_opTmp.equals(newPwd)) {
            return JSONResult.fail("新密码与旧密码相同,不需要修改。");
        }
        UserParam _upPw = new UserParam();
        _upPw.setId(_userParam.getId());
        _upPw.setPassword(newPwd);
        return (userService.update(_upPw))? JSONResult.success("密码更新成功")
                : JSONResult.fail("密码更新失败。");
    }

}
