package cn.peyton.plum.mall.param;


import cn.peyton.plum.mall.pojo.Member;

import java.io.Serializable;
/**
 * <h3> 会员 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
public class MemberParam implements Serializable {
	/**   */
	private Long id;
	/** 会员级别  */
	private Integer memberLevelId;
	/** 会员名称  */
	private String username;
	/** 会员密码  */
	private String password;
	/** 会员头像  */
	private String avatar;
	/** 会员昵称  */
	private String nickname;
	/** 会员手机  */
	private String phone;
	/** 会员邮箱  */
	private String email;
	/** 最后登录IP  */
	private String lastIp;
	/** 每登录一次加1  */
	private Integer loc;
	/** 最后登录时间  */
	private Integer lastLoginTime;
	/** 是否删除: 默认1(1：可用;0已删除)  */
	private Integer isDel;
	/** 性别：默认 0{0 保密 1 男 2 女}  */
	private Integer sex;
	/** 生日  */
	private String birthday;
	/** 创建时间  */
	private Integer createTime;

	//================================== Constructor =======================================//

	//================================== Method =======================================//


	//================================== PREFIX_GET AND PREFIX_SET =======================================//

	/** 
	 * @param id  
	 */ 
	public void setId(Long id){
		this.id = id;
	}

	/** 
	 * @return  
	 */ 
	public Long getId(){
		return id;
	}

	/** 
	 * @param memberLevelId 会员级别 
	 */ 
	public void setMemberLevelId(Integer memberLevelId){
		this.memberLevelId = memberLevelId;
	}

	/** 
	 * @return 会员级别 
	 */ 
	public Integer getMemberLevelId(){
		return memberLevelId;
	}

	/** 
	 * @param username 会员名称 
	 */ 
	public void setUsername(String username){
		this.username = username;
	}

	/** 
	 * @return 会员名称 
	 */ 
	public String getUsername(){
		return username;
	}

	/** 
	 * @param password 会员密码 
	 */ 
	public void setPassword(String password){
		this.password = password;
	}

	/** 
	 * @return 会员密码 
	 */ 
	public String getPassword(){
		return password;
	}

	/** 
	 * @param avatar 会员头像 
	 */ 
	public void setAvatar(String avatar){
		this.avatar = avatar;
	}

	/** 
	 * @return 会员头像 
	 */ 
	public String getAvatar(){
		return avatar;
	}

	/** 
	 * @param nickname 会员昵称 
	 */ 
	public void setNickname(String nickname){
		this.nickname = nickname;
	}

	/** 
	 * @return 会员昵称 
	 */ 
	public String getNickname(){
		return nickname;
	}

	/** 
	 * @param phone 会员手机 
	 */ 
	public void setPhone(String phone){
		this.phone = phone;
	}

	/** 
	 * @return 会员手机 
	 */ 
	public String getPhone(){
		return phone;
	}

	/** 
	 * @param email 会员邮箱 
	 */ 
	public void setEmail(String email){
		this.email = email;
	}

	/** 
	 * @return 会员邮箱 
	 */ 
	public String getEmail(){
		return email;
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
	 * @param loc 每登录一次加1 
	 */ 
	public void setLoc(Integer loc){
		this.loc = loc;
	}

	/** 
	 * @return 每登录一次加1 
	 */ 
	public Integer getLoc(){
		return loc;
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
	public void setIsDel(Integer isDel){
		this.isDel = isDel;
	}

	/** 
	 * @return 是否删除: 默认1(1：可用;0已删除) 
	 */ 
	public Integer getIsDel(){
		return isDel;
	}

	/** 
	 * @param sex 性别：默认 0{0 保密 1 男 2 女} 
	 */ 
	public void setSex(Integer sex){
		this.sex = sex;
	}

	/** 
	 * @return 性别：默认 0{0 保密 1 男 2 女} 
	 */ 
	public Integer getSex(){
		return sex;
	}

	/** 
	 * @param birthday 生日 
	 */ 
	public void setBirthday(String birthday){
		this.birthday = birthday;
	}

	/** 
	 * @return 生日 
	 */ 
	public String getBirthday(){
		return birthday;
	}

	/** 
	 * @param createTime 创建时间 
	 */ 
	public void setCreateTime(Integer createTime){
		this.createTime = createTime;
	}

	/** 
	 * @return 创建时间 
	 */ 
	public Integer getCreateTime(){
		return createTime;
	}

	/**
	 * <h4>对象转成Member对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,memberLevelId,username,password,avatar,nickname,phone,email,lastIp,loc,lastLoginTime,isDel,sex,birthday,createTime]
	 * </pre>
	 */
	public Member convert(){
		Member member = new Member(); 
		member.setId(id);
		member.setMemberLevelId(memberLevelId);
		member.setUsername(username);
		member.setPassword(password);
		member.setAvatar(avatar);
		member.setNickname(nickname);
		member.setPhone(phone);
		member.setEmail(email);
		member.setLastIp(lastIp);
		member.setLoc(loc);
		member.setLastLoginTime(lastLoginTime);
		member.setIsDel(isDel);
		member.setSex(sex);
		member.setBirthday(birthday);
		member.setCreateTime(createTime);
		return member;
	} 
	/**
	 * <h4>Member对象转成MemberParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,memberLevelId,username,password,avatar,nickname,phone,email,lastIp,loc,lastLoginTime,isDel,sex,birthday,createTime]
	 * </pre>
	 */
	public MemberParam compat(Member member){ 
		if(null == member){
			return new MemberParam();
		}
		this.setId(member.getId());
		this.setMemberLevelId(member.getMemberLevelId());
		this.setUsername(member.getUsername());
		this.setPassword(member.getPassword());
		this.setAvatar(member.getAvatar());
		this.setNickname(member.getNickname());
		this.setPhone(member.getPhone());
		this.setEmail(member.getEmail());
		this.setLastIp(member.getLastIp());
		this.setLoc(member.getLoc());
		this.setLastLoginTime(member.getLastLoginTime());
		this.setIsDel(member.getIsDel());
		this.setSex(member.getSex());
		this.setBirthday(member.getBirthday());
		this.setCreateTime(member.getCreateTime());
		return this;
	} 
}
