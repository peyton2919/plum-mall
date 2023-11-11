package cn.peyton.plum.mall.pojo;


import java.io.Serializable;

/**
 * <h3> 供应商信息 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public class Supplier implements Serializable {
    /**
     * 编号
     */
    private Long id;
    /**
     * 名称
     */
    private String name;
    /**
     * 登录名
     */
    private String loginName;
    /**
     * 头像地址
     */
    private String avatar;
    /**
     * 密码
     */
    private String pwd;
    /**
     * 手机
     */
    private String phone;
    /**
     * 登录次数,每登录一次加1
     */
    private Integer loc;
    /**
     * 是否删除: 默认1(1：可用;0已删除)
     */
    private Integer isDel;
    /**
     * 加密串
     */
    private String encrypted;
    /**
     * 最后登录IP
     */
    private String lastIp;
    /**
     * 创建时间
     */
    private Integer createTime;

    //================================== Constructor =======================================//

    //================================== Method =======================================//


    //================================== PREFIX_GET AND PREFIX_SET =======================================//

    /**
     * @param id 编号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return 编号
     */
    public Long getId() {
        return id;
    }

    /**
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return 名称
     */
    public String getName() {
        return name;
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
     * @param pwd 密码
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * @return 密码
     */
    public String getPwd() {
        return pwd;
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
     * @param lastIp 最后登录IP
     */
    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    /**
     * @return 最后登录IP
     */
    public String getLastIp() {
        return lastIp;
    }

    /**
     * @param createTime 创建时间
     */
    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    /**
     * @return 创建时间
     */
    public Integer getCreateTime() {
        return createTime;
    }

}
