package cn.peyton.plum.mall.controller.pc.manager.sys;

import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.cache.LocalCache;
import cn.peyton.plum.core.cipher.BaseCipher;
import cn.peyton.plum.core.imgs.ImageProcessing;
import cn.peyton.plum.core.inf.controller.IBasePCController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.PageResult;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.core.users.IUser;
import cn.peyton.plum.core.utils.*;
import cn.peyton.plum.core.validator.Regulation;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.*;
import cn.peyton.plum.mall.controller.base.PcController;
import cn.peyton.plum.mall.param.sys.UserParam;
import cn.peyton.plum.mall.param.sys.UserRoleParam;
import cn.peyton.plum.mall.service.sys.RoleService;
import cn.peyton.plum.mall.service.sys.UserRoleService;
import cn.peyton.plum.mall.service.sys.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
@RequestMapping("/pc/user")
public class UserController extends PcController<UserParam>
        implements IBasePCController<Long,UserParam> {
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
    @Resource
    private RoleService roleService;
    @Resource
    private UserRoleService userRoleService;

    // 搜索用户
    @Token
    @Valid
    @Override
    @PostMapping("/manager/search")
    public JSONResult<?> search(Query query){
        UserParam _param = new UserParam();
        _param.setUsername(query.getKeyword());
        return baseFindBykeywordAll(_param, new PageQuery(query.getPageNo()), userService);
    }

    //,@Min(value = 1,message = "ID 不能小于1的数值") Long roleId
    @Token
    @Valid
    @PostMapping("/manager/create")
    @Override
    public JSONResult<?> create(UserParam param) {
        initProps(param);
        if (userService.checkStatus(param.getUsername(), IUser.LOGIN_TYPE_ACCOUNT, STATUS_MINUS)) {
            return JSONResult.fail("该用户名称已经存在,请重新输入。");
        }
        param.setPassword(BaseCipher.encoderMD5(param.getPassword(),KEY_PASSWORD_ENCODER));
        UserParam _result = userService.add(param);
        if (null != _result) {
            UserRoleParam _urp = new UserRoleParam();
            _urp.setRoleId(param.getRoleParam().getId());
            _urp.setShareId(_result.getId());
            _urp.setShareType(IUser.TYPE_USER);
            if (null != userRoleService.add(_urp)) {
                return JSONResult.success("添加管理员成功",_result);
            }
        }
        return JSONResult.fail("添加管理员失败");
    }

    @Token
    @Valid
    @PostMapping("/manager/edit")
    @Override
    public JSONResult<?> edit(UserParam param) {
        initProps(param);
        //判断重名
        String knwon = " where is_del=1 and username=" + param.getUsername() + " and id != " + param.getId();
        if(userService.condition(knwon)){
            return JSONResult.fail("修改的名称重名,请重新输入。");
        }
        param.setPassword(null);
        if (userService.update(param)){
            // 更新角色
            UserRoleParam _urpParam = new UserRoleParam();
            _urpParam.setShareId(param.getId());
            _urpParam.setShareType(IUser.TYPE_USER);
            UserRoleParam _urp = userRoleService.findByThree(_urpParam);
            _urp.setRoleId(param.getRoleParam().getId());
            Boolean _resBool = true;
            //更新
            if (null != _urp) {
                _resBool = userRoleService.update(_urp);
            }else {
                // 添加
                _resBool = userRoleService.add(_urp) != null ? true : false;
            }
            if (_resBool){
                return JSONResult.success("修改管理员成功");
            }
        }
        return JSONResult.fail("修改管理员失败");
    }

    @Token
    @Valid
    @PostMapping("/manager/delete")
    @Override
    public JSONResult<?> delete(@Min(value = 1,message = "ID 不能小于1的数值") Long id) {
        UserParam _param = new UserParam();
        _param.setId(id);
        _param.setIsDel(IS_DEL_0);
        if(userService.update(_param)){
            return JSONResult.success("删除管理员成功");
        }
        return JSONResult.fail("删除管理员失败");
    }

    @PostMapping("/manager/getinfo")
    @Token
    public JSONResult<?> findJoinById(){
        UserParam userParam = handleToken(new UserParam());
        if(null != userParam){
            return JSONResult.success(userService.findJoinById(userParam.getId(),userParam.getUserType()));
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
        param.setLoginType(IUser.LOGIN_TYPE_ACCOUNT);
        if (Regulation.regex(Regulation.REGEX_EMAIL_ALL ,keyword)){
            param.setLoginType(IUser.LOGIN_TYPE_EMAIL);
        } else if ((Regulation.regex(Regulation.REGEX_PHONE, keyword))) {
            param.setLoginType(IUser.LOGIN_TYPE_PHONE);
        }

        // 判断是否可用 ,返回 true 表示应该用户被禁用
        if(userService.checkStatus(keyword,param.getLoginType(),STATUS_0)){
            return JSONResult.fail("该用户已被禁用,请联系管理员。");
        }

        // 根据用户邮箱/手机号/账号 登录 ; 返回 为空表示 应该用户账号密码不正确 ;
        String _tmpp = BaseCipher.encoderMD5(password, KEY_PASSWORD_ENCODER);
        UserParam _param = userService.login(keyword,_tmpp
                , param.getLoginType());
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
        _param.setUserType(IUser.TYPE_USER);
        _param.setLoginType( param.getLoginType());
        _param.setPassword(null);
        UserParam _tokenUser = _param;
        _tokenUser.setMenus(null);
        _tokenUser.setRoleParam(null);

        _param.setToken(saveToken(_param));

        return JSONResult.success(("用户" + _param.getUsername() + "登录成功"), _param);
    }

    // 用户退出
    @PostMapping("/manager/logout")
    public JSONResult<UserParam> logout() {
        if(verifyToken()){
            return JSONResult.success("退出成功");
        }
        return JSONResult.fail("非法 Token");
    }

    // 修改用户密码
    @Valid
    @Token
    @PostMapping("/manager/uppassword")
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
        UserParam _upParam = new UserParam();
        _upParam.setId(_userParam.getId());
        String _tmpOldPwd = BaseCipher.encoderMD5(oldPassword, KEY_PASSWORD_ENCODER);

        if(!userService.isPassword(_upParam.getId(),_tmpOldPwd)){
            return JSONResult.fail("旧密码输入不正确");
        }
        if (!newPassword.equals(confirmPassword)) {
            return JSONResult.fail("确认密码输入有误,请重新输入。");
        }
        String newPwd = BaseCipher.encoderMD5(newPassword, KEY_PASSWORD_ENCODER);
        if (_tmpOldPwd.equals(newPwd)) {
            return JSONResult.fail("新密码与旧密码相同,不需要修改。");
        }

        _upParam.setPassword(newPwd);
        return (userService.update(_upParam))? JSONResult.success("密码更新成功")
                : JSONResult.fail("密码更新失败。");
    }


    // 发送验证码
    @PostMapping("/manager/sendcode")
    @Valid
    public JSONResult<?> sendCode(
            @NotBlank(message = "手机号码不能为空!")
            @Phone
            String phone){
        // 判断是否可用 ,返回 true 表示应该手机被禁用
        UserParam param = new UserParam();
        //先判断手机号码 是否存在, 不存在就返回false;
        param.setPhone(phone);
        if(!userService.repeat(param)){
            return JSONResult.fail("该手机号码不存在,请注册");
        }

        // 判断是否可用 ,返回 true 表示应该手机被禁用
        param.setStatus(0);
        if(userService.repeat(param)){
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

    @Override
    public JSONResult<?> all(String keyword,@NotBlank(message = "pageNo 不能为空;")
        @Min(value = 1,message = "最小为1") Integer pageNo) {
        return null;
    }

    // 编辑用户头像
    @PostMapping("/manager/edituseravatar")
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
    @PostMapping("/manager/edituser")
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

    @Token
    @PostMapping("/manager/upstatus")
    public JSONResult<?> editUserStatus(@Min(message = "要大于0的数！")long id,
                @Size(min = 0,max = 1) Integer status){
        UserParam _param = new UserParam();
        _param.setId(id);
        _param.setStatus(status);
        if(userService.update(_param)){
            return JSONResult.success("状态更新成功");
        }
        return JSONResult.fail("状态更新失败");
    }

    @Token
    @Valid
    @PostMapping("/manager/allkeyword")
    public JSONResult<?> findAllByKeyword(String keyword, @Min(message = "当前页码要大于0的数！")Integer pageNo) {
        UserParam _param = new UserParam();
        _param.setUsername(keyword);
        PageResult<?> result = userService.findAllByLike(_param, new PageQuery(pageNo));
        if (result.isSuccess){
            result.setExpand(roleService.findBySelect());
            return JSONResult.success("数据加载成功",result);
        }
        return JSONResult.fail(JSONResult.Props.NO_DATA,"没找到数据");
    }

    /**
     * <h4>初始化数据</h4>
     * @param param
     */
    @Override
    public void initProps(UserParam param){
        param.setIsDel(1);
        param.setStatus(1);
        param.setLastIp(null);
        param.setLastLoginTime(null);
    }
}
