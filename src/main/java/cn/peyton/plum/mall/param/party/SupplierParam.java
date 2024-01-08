package cn.peyton.plum.mall.param.party;


import cn.peyton.plum.core.anno.img.ImageHostPath;
import cn.peyton.plum.core.users.BaseUser;
import cn.peyton.plum.core.users.IUser;
import cn.peyton.plum.core.utils.DateUtils;
import cn.peyton.plum.core.validator.constraints.*;
import cn.peyton.plum.mall.bo.SupplierInfoBo;
import cn.peyton.plum.mall.pojo.party.Supplier;

import java.io.Serializable;

/**
 * <h3> 供应商信息 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:24
 * @version 1.0.0
 * </pre>
 */
@ImageHostPath(name = "avatar")
public class SupplierParam extends BaseUser implements Serializable {
    /**
     * 名称
     */
    @NotBlank(message = "用户名不能为空")
    @Length(min=3,max = 40)
    private String username;
    /**
     * 登录名
     */
    @NotBlank(message = "登录名不能为空")
    @Length(min=3,max = 40)
    private String loginName;
    /**
     * 头像地址
     */
    @Length(min = 0,max = 245)
    private String avatar;
    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    @Length(min=6,max = 40)
    private String password;
    /** 确认密码 */
    @Alike(fieldName = "password")
    private String confirmPwd;

    /**
     * 手机
     */
    @Phone
    private String phone;
    /**
     * 登录次数,每登录一次加1
     */
    private Integer loc;
    /** 状态：默认: 1启用、0禁用 */
    private Integer status;
    /** 邮箱 */
    @Email
    private String email;

    /**
     * 加密串
     */
    private String encrypted;

    /**
     * 创建时间
     */
    private String createTime;
    /** 供应商基础信息 对象 */
    private SupplierInfoParam supplierInfo;

    //================================== Constructor =======================================//
    public SupplierParam() {
        if (null == supplierInfo) {supplierInfo = new SupplierInfoParam();}
    }
    //================================== Method =======================================//


    //================================== PREFIX_GET AND PREFIX_SET =======================================//

    /**
     * @param username 名称
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return 名称
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param loginName 登录名
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * @return 登录名
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * @param avatar 头像地址
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * @return 头像地址
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return 确认密码
     */
    public String getConfirmPwd() {
        return confirmPwd;
    }

    /**
     * @param confirmPwd  确认密码
     */
    public void setConfirmPwd(String confirmPwd) {
        this.confirmPwd = confirmPwd;
    }
    /**
     * @param phone 手机
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return 手机
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param loc 登录次数,每登录一次加1
     */
    public void setLoc(Integer loc) {
        this.loc = loc;
    }

    /**
     * @return 登录次数, 每登录一次加1
     */
    public Integer getLoc() {
        return loc;
    }

    /**
     * @return 状态：默认: 1启用、0禁用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status 状态：默认: 1启用、0禁用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param encrypted 加密串
     */
    public void setEncrypted(String encrypted) {
        this.encrypted = encrypted;
    }

    /**
     * @return 加密串
     */
    public String getEncrypted() {
        return encrypted;
    }

    /**
     * @param createTime 创建时间
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * @return 创建时间
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * @return 供应商基础信息 对象
     */
    public SupplierInfoParam getSupplierInfo() {
        return supplierInfo;
    }

    /**
     * @param supplierInfo 供应商基础信息 对象
     */
    public void setSupplierInfo(SupplierInfoParam supplierInfo) {
        this.supplierInfo = supplierInfo;
    }


    /**
     * <h4>对象转成Supplier对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,name,loginName,avatar,pwd,phone,loc,isDel,encrypted,lastIp,createTime]
     * </pre>
     */
    public Supplier convert() {
        Supplier supplier = new Supplier();
        supplier.setId(getId());
        supplier.setUsername(username);
        supplier.setLoginName(loginName);
        supplier.setAvatar(avatar);
        supplier.setPassword(password);
        supplier.setPhone(phone);
        supplier.setLoc(loc);
        supplier.setEncrypted(encrypted);
        supplier.setLastIp(getLastIp());
        supplier.setStatus(status);
        supplier.setEmail(email);
        supplier.setLastLoginTime(DateUtils.dateToTimestamp(getLastLoginTime()));
        supplier.setCreateTime(DateUtils.dateToTimestamp(createTime));
        supplier.setSupplierInfo(supplierInfo.convert());
        return supplier;
    }

    /**
     * <h4>Supplier对象转成SupplierParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,name,loginName,avatar,pwd,phone,loc,isDel,encrypted,lastIp,createTime]
     * </pre>
     */
    public SupplierParam compat(Supplier supplier) {
        if (null == supplier) {
            return new SupplierParam();
        }
        this.setId(supplier.getId());
        this.setUsername(supplier.getUsername());
        this.setLoginName(supplier.getLoginName());
        this.setAvatar(supplier.getAvatar());
        this.setPassword(supplier.getPassword());
        this.setPhone(supplier.getPhone());
        this.setLoc(supplier.getLoc());
        this.setEncrypted(supplier.getEncrypted());
        this.setLastIp(supplier.getLastIp());
        this.setStatus(supplier.getStatus());
        this.setEmail(supplier.getEmail());
        this.setLastLoginTime(DateUtils.timestampToStrDate(supplier.getLastLoginTime()));
        this.setCreateTime(DateUtils.timestampToStrDate(supplier.getCreateTime()));
        this.setSupplierInfo(new SupplierInfoBo().compat(supplier.getSupplierInfo()));
        return this;
    }

    @Override
    protected Integer userType() {
        return IUser.TYPE_SUPPLIER;
    }
}
