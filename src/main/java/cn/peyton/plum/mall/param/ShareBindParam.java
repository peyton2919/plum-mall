package cn.peyton.plum.mall.param;


import cn.peyton.plum.mall.pojo.ShareBind;

import java.io.Serializable;
/**
 * <h3> 第三方用户绑定信息 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
public class ShareBindParam implements Serializable {
	/** 编号  */
	private Long id;
	/** 类型{sinaweibo、qq、weixin等}与open_id配合使用  */
	private String openType;
	/** 开放编号  */
	private String openId;
	/** 绑定用户类型{员工、会员、供应商等}与share_id配合使用  */
	private String shareType;
	/** 绑定用户编号{员工、会员、供应商等}  */
	private Long shareId;
	/** 昵称  */
	private String nickName;
	/** 头像地址  */
	private String avatarUrl;
	/** 说明  */
	private String explain;
	/** 创建时间  */
	private Integer createTime;

	//================================== Constructor =======================================//

	//================================== Method =======================================//


	//================================== PREFIX_GET AND PREFIX_SET =======================================//

	/** 
	 * @param id 编号 
	 */ 
	public void setId(Long id){
		this.id = id;
	}

	/** 
	 * @return 编号 
	 */ 
	public Long getId(){
		return id;
	}

	/** 
	 * @param openType 类型{sinaweibo、qq、weixin等}与open_id配合使用 
	 */ 
	public void setOpenType(String openType){
		this.openType = openType;
	}

	/** 
	 * @return 类型{sinaweibo、qq、weixin等}与open_id配合使用 
	 */ 
	public String getOpenType(){
		return openType;
	}

	/** 
	 * @param openId 开放编号 
	 */ 
	public void setOpenId(String openId){
		this.openId = openId;
	}

	/** 
	 * @return 开放编号 
	 */ 
	public String getOpenId(){
		return openId;
	}

	/** 
	 * @param shareType 绑定用户类型{员工、会员、供应商等}与share_id配合使用 
	 */ 
	public void setShareType(String shareType){
		this.shareType = shareType;
	}

	/** 
	 * @return 绑定用户类型{员工、会员、供应商等}与share_id配合使用 
	 */ 
	public String getShareType(){
		return shareType;
	}

	/** 
	 * @param shareId 绑定用户编号{员工、会员、供应商等} 
	 */ 
	public void setShareId(Long shareId){
		this.shareId = shareId;
	}

	/** 
	 * @return 绑定用户编号{员工、会员、供应商等} 
	 */ 
	public Long getShareId(){
		return shareId;
	}

	/** 
	 * @param nickName 昵称 
	 */ 
	public void setNickName(String nickName){
		this.nickName = nickName;
	}

	/** 
	 * @return 昵称 
	 */ 
	public String getNickName(){
		return nickName;
	}

	/** 
	 * @param avatarUrl 头像地址 
	 */ 
	public void setAvatarUrl(String avatarUrl){
		this.avatarUrl = avatarUrl;
	}

	/** 
	 * @return 头像地址 
	 */ 
	public String getAvatarUrl(){
		return avatarUrl;
	}

	/** 
	 * @param explain 说明 
	 */ 
	public void setExplain(String explain){
		this.explain = explain;
	}

	/** 
	 * @return 说明 
	 */ 
	public String getExplain(){
		return explain;
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
	 * <h4>对象转成ShareBind对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,openType,openId,shareType,shareId,nickName,avatarUrl,explain,createTime]
	 * </pre>
	 */
	public ShareBind convert(){
		ShareBind shareBind = new ShareBind(); 
		shareBind.setId(id);
		shareBind.setOpenType(openType);
		shareBind.setOpenId(openId);
		shareBind.setShareType(shareType);
		shareBind.setShareId(shareId);
		shareBind.setNickName(nickName);
		shareBind.setAvatarUrl(avatarUrl);
		shareBind.setExplain(explain);
		shareBind.setCreateTime(createTime);
		return shareBind;
	} 
	/**
	 * <h4>ShareBind对象转成ShareBindParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,openType,openId,shareType,shareId,nickName,avatarUrl,explain,createTime]
	 * </pre>
	 */
	public ShareBindParam compat(ShareBind shareBind){ 
		if(null == shareBind){
			return new ShareBindParam();
		}
		this.setId(shareBind.getId());
		this.setOpenType(shareBind.getOpenType());
		this.setOpenId(shareBind.getOpenId());
		this.setShareType(shareBind.getShareType());
		this.setShareId(shareBind.getShareId());
		this.setNickName(shareBind.getNickName());
		this.setAvatarUrl(shareBind.getAvatarUrl());
		this.setExplain(shareBind.getExplain());
		this.setCreateTime(shareBind.getCreateTime());
		return this;
	} 
}
