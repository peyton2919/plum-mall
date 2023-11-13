package cn.peyton.plum.mall.param;


import cn.peyton.plum.mall.pojo.UserRole;

import java.io.Serializable;
/**
 * <h3> 用户角色关联 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月13日 20:52:43
 * @version 1.0.0
 * </pre>
*/
public class UserRoleParam implements Serializable {
	/**   */
	private Long id;
	/** 用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)  */
	private Long shareId;
	/** 用户类型 ,默认 2 员工、 0 会员、1 供应商  */
	private Integer shareType;
	/** 角色ID  */
	private Long roleId;

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
	 * @param shareId 用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用) 
	 */ 
	public void setShareId(Long shareId){
		this.shareId = shareId;
	}

	/** 
	 * @return 用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用) 
	 */ 
	public Long getShareId(){
		return shareId;
	}

	/** 
	 * @param shareType 用户类型 ,默认 2 员工、 0 会员、1 供应商 
	 */ 
	public void setShareType(Integer shareType){
		this.shareType = shareType;
	}

	/** 
	 * @return 用户类型 ,默认 2 员工、 0 会员、1 供应商 
	 */ 
	public Integer getShareType(){
		return shareType;
	}

	/** 
	 * @param roleId 角色ID 
	 */ 
	public void setRoleId(Long roleId){
		this.roleId = roleId;
	}

	/** 
	 * @return 角色ID 
	 */ 
	public Long getRoleId(){
		return roleId;
	}

	/**
	 * <h4>对象转成UserRole对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,shareId,shareType,roleId]
	 * </pre>
	 */
	public UserRole convert(){
		UserRole userRole = new UserRole(); 
		userRole.setId(id);
		userRole.setShareId(shareId);
		userRole.setShareType(shareType);
		userRole.setRoleId(roleId);
		return userRole;
	} 
	/**
	 * <h4>UserRole对象转成UserRoleParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,shareId,shareType,roleId]
	 * </pre>
	 */
	public UserRoleParam compat(UserRole userRole){ 
		if(null == userRole){
			return new UserRoleParam();
		}
		this.setId(userRole.getId());
		this.setShareId(userRole.getShareId());
		this.setShareType(userRole.getShareType());
		this.setRoleId(userRole.getRoleId());
		return this;
	} 
}
