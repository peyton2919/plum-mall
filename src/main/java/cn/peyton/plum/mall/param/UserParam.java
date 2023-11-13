package cn.peyton.plum.mall.param;


import cn.peyton.plum.core.users.BaseUser;
import cn.peyton.plum.core.users.IUser;
import cn.peyton.plum.core.utils.DateUtils;
import cn.peyton.plum.core.validator.constraints.*;
import cn.peyton.plum.mall.pojo.User;

import java.io.Serializable;

/**
 * <h3> 系统用户 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:24
 * @version 1.0.0
 * </pre>
 */
public class UserParam extends BaseUser<Long,UserParam> implements Serializable {
    /**
     * ID
     */
    private Long id;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 邮箱
     */
    @Email
    private String email;
    /**
     * 状态：1启用、0禁用
     */
    private Integer status;
    /**
     * 密码
     */
    @NotBlank(message = "用户密码不能为空！")
    @Length(min = 6,max=30,message = "用户密码长度为6~30个字符！")
    private String password;
    /** 确认密码  */
    @NotBlank(message = "确认密码不能为空！")
    @Alike(fieldName = "password")
    private String confirmPwd;
    /**
     * 用户名
     */
    @NotBlank(message = "用户名称不能为空！")
    @Length(min = 4,max=40,message = "用户名称长度为4~40个字符！")
    private String username;
    /**
     * 部门名称
     */
    private Long deptId;
    /**
     * 手机号码
     */
    @Phone
    private String phone;
    /**
     * 岗位名称
     */
    private Long jobId;
    /**
     * 创建日期
     */
    private String createTime;
    /**
     * 昵称
     */
    @NotBlank(message = "用户昵称不能为空！")
    @Length(min = 4,max=40,message = "用户昵称长度为4~40个字符！")
    private String nickName;
    /**
     * 性别：默认 0{0 保密 1 男 2 女}
     */
    private Integer sex;
    /** 最后登录IP  */
    private String lastIp;
    /** 最后登录时间  */
    private String lastLoginTime;
    /**
     * 是否删除: 默认1(1：可用;0已删除)
     */
    private Integer isDel;

    //================================== Constructor =======================================//

    //================================== Method =======================================//


    //================================== PREFIX_GET AND PREFIX_SET =======================================//

    /**
     * @param id ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return ID
     */
    public Long getId() {
        return id;
    }

    /**
     * @param avatar 头像
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * @return 头像
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param status 状态：1启用、0禁用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return 状态：1启用、0禁用
     */
    public Integer getStatus() {
        return status;
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
     * @param confirmPwd 确认密码
     */
    public void setConfirmPwd(String confirmPwd) {
        this.confirmPwd = confirmPwd;
    }

    /**
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param deptId 部门名称
     */
    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    /**
     * @return 部门名称
     */
    public Long getDeptId() {
        return deptId;
    }

    /**
     * @param phone 手机号码
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return 手机号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param jobId 岗位名称
     */
    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    /**
     * @return 岗位名称
     */
    public Long getJobId() {
        return jobId;
    }

    /**
     * @param createTime 创建日期
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * @return 创建日期
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * @param nickName 昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * @return 昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param sex 性别：默认 0{0 保密 1 男 2 女}
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * @return 性别：默认 0{0 保密 1 男 2 女}
     */
    public Integer getSex() {
        return sex;
    }
    /**
     * @param lastIp 最后登录IP
     */
    public void setLastIp(String lastIp){
        this.lastIp = lastIp;
    }

    /**
     * @return 最后登录IP
     */
    public String getLastIp(){
        return lastIp;
    }

    /**
     * @param lastLoginTime 最后登录时间
     */
    public void setLastLoginTime(String lastLoginTime){
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * @return 最后登录时间
     */
    public String getLastLoginTime(){
        return lastLoginTime;
    }

    /**
     * @param isDel 是否删除: 默认1(1：可用;0已删除)
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    /**
     * @return 是否删除: 默认1(1：可用;0已删除)
     */
    public Integer getIsDel() {
        return isDel;
    }

    /**
     * <h4>对象转成User对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,avatar,email,enabled,password,username,deptId,phone,jobId,createTime,nickName,sex,isDel]
     * </pre>
     */
    public User convert() {
        User user = new User();
        user.setId(id);
        user.setAvatar(avatar);
        user.setEmail(email);
        user.setStatus(status);
        user.setPassword(password);
        user.setUsername(username);
        user.setDeptId(deptId);
        user.setPhone(phone);
        user.setJobId(jobId);
        user.setCreateTime(DateUtils.dateToTimestamp(createTime));
        user.setNickName(nickName);
        user.setSex(sex);
        user.setLastIp(lastIp);
        user.setLastLoginTime(DateUtils.dateToTimestamp(lastLoginTime));
        user.setIsDel(isDel);
        return user;
    }

    /**
     * <h4>User对象转成UserParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,avatar,email,enabled,password,username,deptId,phone,jobId,createTime,nickName,sex,isDel]
     * </pre>
     */
    public UserParam compat(User user) {
        if (null == user) {
            return new UserParam();
        }
        this.setId(user.getId());
        this.setAvatar(user.getAvatar());
        this.setEmail(user.getEmail());
        this.setStatus(user.getStatus());
        this.setPassword(user.getPassword());
        this.setUsername(user.getUsername());
        this.setDeptId(user.getDeptId());
        this.setPhone(user.getPhone());
        this.setJobId(user.getJobId());
        this.setCreateTime(DateUtils.timestampToStrDate(user.getCreateTime()));
        this.setNickName(user.getNickName());
        this.setSex(user.getSex());
        this.setLastIp(user.getLastIp());
        this.setLastLoginTime(DateUtils.timestampToStrDate(user.getLastLoginTime()));
        this.setIsDel(user.getIsDel());
        return this;
    }

    @Override
    protected Integer userType() {
        return IUser.TYPE_USER;
    }
}
