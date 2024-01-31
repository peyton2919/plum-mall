package cn.peyton.plum.mall.pojo.party;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <h3> 会员 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public class Member implements Serializable {
    /**
     *
     */
    private Long id;
    /**
     * 会员级别
     */
    //private Integer levelId;
    private MemberLevel memberLevel;
    /**
     * 会员名称
     */
    private String username;
    /**
     * 会员密码
     */
    private String password;
    /**
     * 会员头像
     */
    private String avatar;
    /**
     * 会员昵称
     */
    private String nickname;
    /**
     * 会员手机
     */
    private String phone;
    /**
     * 会员邮箱
     */
    private String email;
    /**
     * 是否启用, 默认 1 启用 0 禁用
     */
    private Integer status;
    /**
     * 最后登录IP
     */
    private String lastIp;
    /**
     * 每登录一次加1
     */
    private Integer loc;
    /** 积分 */
    private Integer integral;

    /**
     * 最后登录时间
     */
    private Integer lastLoginTime;
    /**
     * 性别：默认 0{0 保密 1 男 2 女}
     */
    private Integer sex;
    /**
     * 生日
     */
    private String birthday;
    /**
     * 加密串
     */
    private String encrypted;
    /**
     * 是否删除: 默认1(1：可用;0已删除)
     */
    private Integer isDel;
    /**
     * 创建时间
     */
    private Integer createTime;
    /** 用户地址 */
    private List<UserAddress> userAddresses;
    /** 用户账单  */
    //private UserBill bill;
    /** 用户提现  */
    //private UserExtract extract;
    /** 第三方用户绑定信息  */
    private List<ShareBind> shareBinds;

    //================================== Constructor =======================================//
    public Member(){
        if (null == memberLevel) {memberLevel = new MemberLevel();}
        if (null == userAddresses) { userAddresses = new ArrayList<>();}
        //if (null == bill) {bill = new UserBill();}
        //if (null == extract) {extract = new UserExtract();}
        if (null == shareBinds) { shareBinds = new ArrayList<>();}
    }
    //================================== Method =======================================//


    //================================== PREFIX_GET AND PREFIX_SET =======================================//

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * @param memberLevel 会员级别
     */
    public void setMemberLevel(MemberLevel memberLevel) {
        this.memberLevel = memberLevel;
    }

    /**
     * @return 会员级别
     */
    public MemberLevel getMemberLevel() {
        return memberLevel;
    }

    /**
     * @param username 会员名称
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return 会员名称
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param password 会员密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return 会员密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param avatar 会员头像
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * @return 会员头像
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * @param nickname 会员昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return 会员昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param phone 会员手机
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return 会员手机
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param email 会员邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return 会员邮箱
     */
    public String getEmail() {
        return email;
    }
    /**
     * @param status 是否删除: 默认1(1：可用;0已删除)
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return 是否删除: 默认1(1：可用;0已删除)
     */
    public Integer getStatus() {
        return status;
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
     * @param loc 每登录一次加1
     */
    public void setLoc(Integer loc) {
        this.loc = loc;
    }

    /**
     * @return 每登录一次加1
     */
    public Integer getLoc() {
        return loc;
    }

    /**
     * @param lastLoginTime 最后登录时间
     */
    public void setLastLoginTime(Integer lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * @return 最后登录时间
     */
    public Integer getLastLoginTime() {
        return lastLoginTime;
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
     * @param birthday 生日
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * @return 生日
     */
    public String getBirthday() {
        return birthday;
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

    /**
     * @return 积分
     */
    public Integer getIntegral() {
        return integral;
    }

    /**
     * @param integral 积分
     */
    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    /**
     * @return 用户地址
     */
    public List<UserAddress> getUserAddresses() {
        return userAddresses;
    }

    /**
     * @param userAddresses 用户地址
     */
    public void setUserAddresses(List<UserAddress> userAddresses) {
        this.userAddresses = userAddresses;
    }

    /**
     * @return 用户账单
     */
    //public UserBill getBill() {
    //    return bill;
    //}

    /**
     * @param bill 用户账单
     */
    //public void setBill(UserBill bill) {
    //    this.bill = bill;
    //}

    /**
     * @return 用户提现
     */
    //public UserExtract getExtract() {
    //    return extract;
    //}

    /**
     * @param extract 用户提现
     */
    //public void setExtract(UserExtract extract) {
    //    this.extract = extract;
    //}

    /**
     * @return 第三方用户绑定信息
     */
    public List<ShareBind> getShareBinds() {
        return shareBinds;
    }

    /**
     * @param shareBinds 第三方用户绑定信息
     */
    public void setShareBinds(List<ShareBind> shareBinds) {
        this.shareBinds = shareBinds;
    }

}
