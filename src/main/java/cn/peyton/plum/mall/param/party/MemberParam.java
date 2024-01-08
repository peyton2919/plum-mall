package cn.peyton.plum.mall.param.party;

import cn.peyton.plum.core.anno.img.ImageHostPath;
import cn.peyton.plum.core.users.BaseUser;
import cn.peyton.plum.core.users.IUser;
import cn.peyton.plum.core.utils.DateUtils;
import cn.peyton.plum.core.validator.constraints.*;
import cn.peyton.plum.mall.bo.MemberLevelBo;
import cn.peyton.plum.mall.bo.ShareBindBo;
import cn.peyton.plum.mall.bo.UserAddressBo;
import cn.peyton.plum.mall.pojo.party.Member;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <h3> 会员 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:24
 * @version 1.0.0
 * </pre>
 */
@ImageHostPath(name = "avatar")
public class MemberParam extends BaseUser implements Serializable {

    /**
     * 会员级别
     */
    private MemberLevelParam memberLevel;
    /**
     * 会员名称
     */
    @NotBlank(message = "用户名称不能为空")
    @Length(min = 2,max = 40)
    private String username;
    /**
     * 会员密码
     */
    @NotBlank(message = "密码不能为空")
    @Length(min = 6,max = 40)
    private String password;
    /** 确认密码 */
    @Alike(fieldName = "pwd")
    private String confirmPwd;
    /**
     * 会员头像
     */
    @Length(max = 250)
    private String avatar;

    /**
     * 会员昵称
     */
    @Length(min = 2,max = 40)
    private String nickname;

    /**
     * 会员手机
     */
    @Phone
    private String phone;
    /**
     * 会员邮箱
     */
    @Email
    @Length(max = 150)
    private String email;
    /**
     * 是否启用, 默认 1 启用 0 禁用
     */
    @Size(min = 0,max = 1)
    private Integer status;
    /**
     * 每登录一次加1
     */
    private Integer loc;
    /**
     * 性别：默认 0{0 保密 1 男 2 女}
     */
    @Size(min=0,max = 2)
    private Integer sex;
    /**
     * 生日
     */
    @Date
    @Past
    private String birthday;
    /**
     * 加密串
     */
    private String encrypted;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 用户地址
     */
    private List<UserAddressParam> userAddresses;
    /** 用户账单  */
    //private UserBillParam bill;
    /** 用户提现  */
    //private UserExtractParam extract;
    /** 第三方用户绑定信息  */
    private List<ShareBindParam> shareBinds;


    //================================== Constructor =======================================//
    public MemberParam() {
        if (null == memberLevel) {memberLevel = new MemberLevelParam();}
        if (null == userAddresses) {
            userAddresses = new ArrayList<>();}
        //if (null == bill) {bill = new UserBillParam();}
        //if (null == extract) {extract = new UserExtractParam();}
        if (null == shareBinds) {shareBinds = new ArrayList<>();}
    }
    //================================== Method =======================================//


    //================================== PREFIX_GET AND PREFIX_SET =======================================//

    /**
     * @return 会员级别
     */
    public MemberLevelParam getMemberLevel() {
        return memberLevel;
    }
    /**
     * @param memberLevel 会员级别
     */
    public void setMemberLevel(MemberLevelParam memberLevel) {
        this.memberLevel = memberLevel;
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
     * @param createTime 创建时间
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }


    /**
     * @return 用户地址
     */
    public List<UserAddressParam> getUserAddresses() {
        return userAddresses;
    }

    /**
     * @param userAddresses 用户地址
     */
    public void setUserAddresses(List<UserAddressParam> userAddresses) {
        this.userAddresses = userAddresses;
    }

    /**
     * @return 用户账单
     */
    //public UserBillParam getBill() {
    //    return bill;
    //}

    /**
     * @param bill 用户账单
     */
    //public void setBill(UserBillParam bill) {
    //    this.bill = bill;
    //}

    /**
     * @return 用户提现
     */
    //public UserExtractParam getExtract() {
    //    return extract;
    //}

    /**
     * @param extract 用户提现
     */
    //public void setExtract(UserExtractParam extract) {
    //    this.extract = extract;
    //}

    /**
     * @return 第三方用户绑定信息
     */
    public List<ShareBindParam> getShareBinds() {
        return shareBinds;
    }

    /**
     * @param shareBinds 第三方用户绑定信息
     */
    public void setShareBinds(List<ShareBindParam> shareBinds) {
        this.shareBinds = shareBinds;
    }

    /**
     * @return 创建时间
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * <h4>对象转成Member对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,levelId,username,pwd,avatar,nickname,phone,email,lastIp,loc,lastLoginTime,sex,birthday,encrypted,createTime]
     * </pre>
     */
    public Member convert() {
        Member member = new Member();
        member.setId(getId());
        member.setMemberLevel(memberLevel.convert());
        member.setUsername(username);
        member.setPassword(password);
        member.setAvatar(avatar);
        member.setNickname(nickname);
        member.setPhone(phone);
        member.setEmail(email);
        member.setStatus(status);
        member.setLastIp(getLastIp());
        member.setLoc(loc);
        member.setLastLoginTime(DateUtils.dateToTimestamp(getLastLoginTime()));
        member.setSex(sex);
        member.setBirthday(birthday);
        member.setEncrypted(encrypted);
        member.setCreateTime(DateUtils.dateToTimestamp(createTime));
        member.setUserAddresses(new UserAddressBo().reverse(userAddresses));
        //member.setBill(bill.convert());
        //member.setExtract(extract.convert());
        member.setShareBinds(new ShareBindBo().reverse(shareBinds));
        return member;
    }

    /**
     * <h4>Member对象转成MemberParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,levelId,username,pwd,avatar,nickname,phone,email,lastIp,loc,lastLoginTime,sex,birthday,encrypted,createTime]
     * </pre>
     */
    public MemberParam compat(Member member) {
        if (null == member) {
            return new MemberParam();
        }
        this.setId(member.getId());
        this.setMemberLevel(new MemberLevelBo().compat(member.getMemberLevel()));
        this.setUsername(member.getUsername());
        this.setPassword(member.getPassword());
        this.setAvatar(member.getAvatar());
        this.setNickname(member.getNickname());
        this.setPhone(member.getPhone());
        this.setEmail(member.getEmail());
        this.setStatus(member.getStatus());
        this.setLastIp(member.getLastIp());
        this.setLoc(member.getLoc());
        this.setLastLoginTime(DateUtils.timestampToStrDate(member.getLastLoginTime()));
        this.setSex(member.getSex());
        this.setBirthday(member.getBirthday());
        this.setEncrypted(member.getEncrypted());
        this.setCreateTime(DateUtils.timestampToStrDate(member.getCreateTime()));
        this.setUserAddresses(new UserAddressBo().adapter(member.getUserAddresses()));
        //this.setBill(new UserBillBo().compat(member.getBill()));
        //this.setExtract(new UserExtractBo().compat(member.getExtract()));
        this.setShareBinds(new ShareBindBo().adapter(member.getShareBinds()));
        return this;
    }

    @Override
    protected Integer userType() {
        return IUser.TYPE_MEMBER;
    }
}
