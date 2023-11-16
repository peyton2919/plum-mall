package cn.peyton.plum.mall.pojo;


import java.io.Serializable;
import java.util.List;

/**
 * <h3> 系统用户 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public class User implements Serializable {
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
    private String email;
    /**
     * 状态：1启用、0禁用
     */
    private Integer status;
    /**
     * 密码
     */
    private String password;
    /**
     * 用户名
     */
    private String username;
    /**
     * 部门名称
     */
    private Long deptId;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 岗位名称
     */
    private Long jobId;
    /**
     * 创建日期
     */
    private Integer createTime;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 性别：默认 0{0 保密 1 男 2 女}
     */
    private Integer sex;
    /** 最后登录IP  */
    private String lastIp;
    /** 最后登录时间  */
    private Integer lastLoginTime;
    /**
     * 是否删除: 默认1(1：可用;0已删除)
     */
    private Integer isDel;
    /** 角色对象 */
    private Role role;
    /** 菜单对象集合 */
    private List<Menu> menuList;

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
    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    /**
     * @return 创建日期
     */
    public Integer getCreateTime() {
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
    public void setLastLoginTime(Integer lastLoginTime){
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * @return 最后登录时间
     */
    public Integer getLastLoginTime(){
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

    /***
     * @return 角色对象
     */
    public Role getRole() {
        return role;
    }

    /**
     * @param role 角色对象
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * @return 菜单对象集合
     */
    public List<Menu> getMenuList() {
        return menuList;
    }

    /**
     * @param menuList 菜单对象集合
     */
    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }
}
