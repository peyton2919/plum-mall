package cn.peyton.plum.mall.controller.pc.manager.party;

import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.cipher.BaseCipher;
import cn.peyton.plum.core.inf.controller.IController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.core.users.IUser;
import cn.peyton.plum.core.utils.base.CtrlUtils;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.*;
import cn.peyton.plum.mall.controller.base.UserOperationController;
import cn.peyton.plum.mall.param.party.SupplierParam;
import cn.peyton.plum.mall.service.party.SupplierService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * <h3> 供应商信息 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
@RestController
@RequestMapping("/pc/supplier")
public class SupplierController extends UserOperationController
        implements IController<Long, SupplierParam> {

    /** 验证码 在缓存中的时间 */
    public final static String KEY_PHONE_CODE_CACHE_TIME = "SUP_PHONE_TIME_202312261602";
    /** session中的 验证码 key */
    public final static String KEY_SESSION_PHONE_CODE = "SUP_SESSION_PHONE_CODE_202312261602";
    /** session中的 手机号码 key */
    public final static String KEY_SESSION_PHONE = "SUP_SESSION_PHONE_202312261602";


    @Resource
    private SupplierService supplierService;

    // ComplexValue {username loginName phone email}
    @Token
    @Valid
    @PostMapping("/manager/search")
    @Override
    public JSONResult<?> list(Query query) {

        SupplierParam _param = new SupplierParam();
        _param.setUsername(query.getKeyword());
        return page(_param, new PageQuery(query.getPageNo()), supplierService,true);
    }

    @Token
    @Valid(ignore = {"supplierInfo","lastIp","loc","lastLoginTime","createTime"})
    @PostMapping("/manager/create")
    @Override
    public JSONResult<?> create(SupplierParam record) {
        SupplierParam _repeat = new SupplierParam();
        _repeat.setLoginName(record.getLoginName());
        _repeat.setPhone(record.getPhone());
        _repeat.setEmail(record.getEmail());
        record.setAvatar(new CtrlUtils().convertImgPath(record.getAvatar()));
        record.setPassword(BaseCipher.encoderMD5(record.getPassword(), KEY_SUPPLIERS_PASSWORD_ENCODER));
        return handle(record, _repeat,false, supplierService, TIP_SUPPLIER,CREATE);
    }

    @Token
    @Valid(ignore = {"password","confirmPwd","supplierInfo","lastIp","loc","lastLoginTime","createTime"})
    @PostMapping("/manager/edit")
    @Override
    public JSONResult<?> edit(SupplierParam record) {
        SupplierParam _repeat = new SupplierParam();
        _repeat.setId(record.getId());
        _repeat.setLoginName(record.getLoginName());
        _repeat.setPhone(record.getPhone());
        _repeat.setEmail(record.getEmail());
        record.setAvatar(new CtrlUtils().convertImgPath(record.getAvatar()));
        return handle(record, _repeat, true, supplierService, TIP_SUPPLIER, UPDATE);
    }
    @Token
    @Valid
    @PostMapping("/manager/delete")
    @Override
    public JSONResult<?> delete(@NotBlank(message = "Id 不能为空;")
                                    @Min(value = 1,message = "最小为1")Long id) {

        return handle(supplierService.upDelete(id), TIP_SUPPLIER, DELETE);
    }

    @Token
    @PostMapping("/manager/upstatus")
    @Valid
    public JSONResult<?> updateStatus(@NotBlank(message = "Id 不能为空;")
                                      @Min(value = 1,message = "最小为1")Long id,
                                      @NotBlank(message = "status 不能为空;")@Size(min = 0,max = 1) Integer status) {

        return handle(supplierService.upStatus(id, status), TIP_SUPPLIER, STATUS, UPDATE);
    }

    @Token
    @PostMapping("/manager/down")
    public JSONResult<?> down(){
        return JSONResult.success(supplierService.findByDownList());
    }


    @Valid
    @PostMapping("/login")
    public JSONResult<?> login(@NotBlank(message = "用户名不能为空！") String keyword,
                               @NotBlank(message = "密码不能为空！") String password,
                               HttpServletRequest request) {

        return super.login(keyword, password, new SupplierParam(), KEY_SUPPLIERS_PASSWORD_ENCODER, IUser.TYPE_USER, supplierService, request);
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
        SupplierParam _param = getToken(new SupplierParam());

        return super.editPassword(_param.getId(), oldPassword, newPassword, confirmPassword, KEY_SUPPLIERS_PASSWORD_ENCODER, supplierService);
    }


    // 发送验证码
    @Token
    @Valid
    @PostMapping("/manager/sendcode")
    public JSONResult<?> sendCode(
            @NotBlank(message = "手机号码不能为空!") @Phone String phone){

        return super.sendCode(phone, KEY_PHONE_CODE_CACHE_TIME, KEY_SESSION_PHONE_CODE, KEY_SESSION_PHONE, supplierService);
    }


    // 编辑用户头像
    @PostMapping("/manager/edituseravatar")
    @Token
    public JSONResult<?> editAvatar(MultipartFile file) {
        SupplierParam _param = getToken(new SupplierParam());

        return super.editAvatar(file, _param.getId(), supplierService);
    }


}
