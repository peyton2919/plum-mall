package cn.peyton.plum.mall.controller.pc.manager.sys;

import cn.peyton.plum.core.anno.resolver.RequestMultiple;
import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.cipher.BaseCipher;
import cn.peyton.plum.core.inf.controller.IBasePCController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.PageResult;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.core.users.IUser;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.*;
import cn.peyton.plum.mall.controller.base.UserOperationController;
import cn.peyton.plum.mall.param.sys.UserParam;
import cn.peyton.plum.mall.param.sys.RoleUserParam;
import cn.peyton.plum.mall.service.sys.RoleService;
import cn.peyton.plum.mall.service.sys.RoleUserService;
import cn.peyton.plum.mall.service.sys.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
public class UserController extends UserOperationController
        implements IBasePCController<Long,UserParam> {
    /** 验证码 在缓存中的时间 */
    public final static String KEY_PHONE_CODE_CACHE_TIME = "USER_PHONE_TIME_2203262148";
    /** session中的 验证码 key */
    public final static String KEY_SESSION_PHONE_CODE = "USER_SESSION_PHONE_CODE_220323";
    /** session中的 手机号码 key */
    public final static String KEY_SESSION_PHONE = "USER_SESSION_PHONE_220324";

    /** MD5 加密 key */
    private final static String KEY_PASSWORD_ENCODER = "userControllerPassword202312120011";

    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;
    @Resource
    private RoleUserService roleUserService;

    // 搜索用户
    @Token
    @Valid
    @Override
    @PostMapping("/manager/search")
    public JSONResult<?> list(Query query){
        UserParam _param = new UserParam();
        _param.setUsername(query.getKeyword());
        return baseHandleList(_param, new PageQuery(query.getPageNo()), userService,roleService.findBySelect());
    }

    //,@Min(value = 1,message = "ID 不能小于1的数值") Long roleId
    @Token
    @Valid(ignore = {"roleParam","menus","ruleNames","id","loc","createTime"})
    @PostMapping("/manager/create")
    @Override
    public JSONResult<?> create(@RequestMultiple UserParam param) {
        initProps(param);
        if (null == param.getRoleParam().getId()) {
            return JSONResult.fail("该选择所属角色。");
        }
        if (userService.checkStatus(param.getUsername(), IUser.LOGIN_TYPE_ACCOUNT, STATUS_MINUS)) {
            return JSONResult.fail("该用户名称已经存在,请重新输入。");
        }
        param.setPassword(BaseCipher.encoderMD5(param.getPassword(),KEY_PASSWORD_ENCODER));
        UserParam _result = userService.add(param);
        if (null != _result) {
            RoleUserParam _urp = new RoleUserParam();
            _urp.setRoleId(param.getRoleParam().getId());
            _urp.setShareId(_result.getId());
            _urp.setShareType(IUser.TYPE_USER);
            if (null != roleUserService.add(_urp)) {
                return JSONResult.success("添加管理员成功",_result);
            }
        }
        return JSONResult.fail("添加管理员失败");
    }

    @Token
    @Valid(ignore = {"roleParam","menus","ruleNames","id","loc","createTime","password","confirmPwd"})
    @PostMapping("/manager/edit")
    @Override
    public JSONResult<?> edit(@RequestMultiple UserParam param) {
        initProps(param);
        if (null == param.getRoleParam().getId()) {
            return JSONResult.fail("该选择所属角色。");
        }
        //判断重名
        if(userService.repeat(param)){
            return JSONResult.fail("修改的名称重名,请重新输入。");
        }
        param.setPassword(null);
        if (userService.update(param)){
            // 更新角色
            RoleUserParam _urpParam = new RoleUserParam();
            _urpParam.setShareId(param.getId());
            _urpParam.setShareType(IUser.TYPE_USER);
            RoleUserParam _urp = roleUserService.findByThree(_urpParam);
            _urpParam.setRoleId(param.getRoleParam().getId());
            Boolean _resBool = true;
            //更新
            if (null != _urp) {
                _urpParam.setId(_urp.getId());
                _resBool = roleUserService.update(_urpParam);
            }else {
                // 添加
                _resBool = roleUserService.add(_urpParam) != null ? true : false;
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
        // todo 超级管员不能删除
        if (roleUserService.isSuperAdmin(id, IUser.TYPE_USER)) {
            return JSONResult.fail("该用户为超级管理员,不能被删除;");
        }
        _param.setId(id);
        if(userService.update(_param)){
            return JSONResult.success("删除管理员成功");
        }
        return JSONResult.fail("删除管理员失败");
    }

    // 用户登录后获取信息
    @PostMapping("/manager/getinfo")
    @Token
    public JSONResult<?> findJoinById(){
        UserParam userParam = handleToken(new UserParam());
        if(null != userParam){
            return JSONResult.success(userService.findJoinById(userParam.getId(),userParam.getUserType()));
        }
        return JSONResult.fail("获取用户信息失败!!!");
    }

    @Valid
    @PostMapping("/login")
    public JSONResult<?> login(@NotBlank(message = "用户名不能为空！") String keyword,
                               @NotBlank(message = "密码不能为空！") String password,
                               HttpServletRequest request) {

        return super.login(keyword, password, new UserParam(), KEY_PASSWORD_ENCODER, IUser.TYPE_USER, userService, request);
    }

    // 用户退出
    @Token
    @PostMapping("/manager/logout")
    public JSONResult<?> logout() {

        return super.logout();
    }

    // 修改用户密码
    @Valid
    @Token
    @PostMapping("/manager/uppassword")
    public JSONResult<?> editPassword(
            @NotBlank(message = "旧密码不能为空！")
            @Length(min = 6,max = 30,message = "密码长度为6~30的字符!")
            String oldPassword,
            @NotBlank(message = "新密码不能为空！")
            @Length(min = 6,max = 30,message = "密码长度为6~30的字符!")
            String newPassword,
            @NotBlank(message = "确认密码不能为空！")String confirmPassword) {
        // 从 token 获取 对象
        UserParam _user = handleToken(new UserParam());

        return super.editPassword(_user.getId(),oldPassword,newPassword,confirmPassword,KEY_PASSWORD_ENCODER,userService);
    }


    // 发送验证码
    @Token
    @Valid
    @PostMapping("/manager/sendcode")
    public JSONResult<?> sendCode(
            @NotBlank(message = "手机号码不能为空!") @Phone String phone){

        return super.sendCode(phone,KEY_PHONE_CODE_CACHE_TIME,KEY_SESSION_PHONE_CODE,KEY_SESSION_PHONE,userService);
    }


    // 编辑用户头像
    @PostMapping("/manager/edituseravatar")
    @Token
    public JSONResult<?> editAvatar(MultipartFile file) {
        UserParam _user = handleToken(new UserParam());

        return super.editAvatar(file,_user.getId(),userService);
    }


    @Token
    @PostMapping("/manager/upstatus")
    public JSONResult<?> editUserStatus(@NotBlank(message = "用户 ID 不能为空;")@Min(message = "要大于0的数！")long id,
                @Size(min = 0,max = 1) Integer status){
        // todo 超级管员不能删除
        if (roleUserService.isSuperAdmin(id, IUser.TYPE_USER)) {
            return JSONResult.fail("该用户为超级管理员,不能被删除;");
        }
        if(userService.upStatus(id,status)){
            return JSONResult.success("状态更新成功");
        }
        return JSONResult.fail("状态更新失败");
    }

    // 编辑用户资料
    @Token
    @Valid
    @PostMapping("/manager/edituser")
    public JSONResult<?> editUser(@RequestMultiple UserParam param) {
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
        param.setCreateTime(null);
        param.setPassword(null);
        param.setStatus(null);
        return (userService.update(param)) ? JSONResult.success("更新成功", param)
                : JSONResult.fail("注册失败,请联系管理员。");
    }


    @Token
    @Valid
    @PostMapping("/manager/allkeyword")
    public JSONResult<?> findAllByKeyword(String keyword, @Min(message = "当前页码要大于0的数！")Integer pageNo) {
        UserParam _param = new UserParam();
        _param.setUsername(keyword);
        PageResult<?> result = userService.likeByPage(_param, new PageQuery(pageNo));
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
    public void initProps(UserParam param){
        param.setStatus(1);
        param.setLastIp(null);
        param.setLastLoginTime(null);
    }
}
