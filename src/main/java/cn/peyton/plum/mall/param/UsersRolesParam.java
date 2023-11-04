package cn.peyton.plum.mall.param;


import cn.peyton.plum.mall.pojo.UsersRoles;

import java.io.Serializable;
/**
 * <h3> 用户角色关联 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
public class UsersRolesParam implements Serializable {
	/** 用户ID  */
	private Long userId;
	/** 角色ID  */
	private Long roleId;
	/**   */
	private Long id;

	//================================== Constructor =======================================//

	//================================== Method =======================================//


	//================================== PREFIX_GET AND PREFIX_SET =======================================//

	/** 
	 * @param userId 用户ID 
	 */ 
	public void setUserId(Long userId){
		this.userId = userId;
	}

	/** 
	 * @return 用户ID 
	 */ 
	public Long getUserId(){
		return userId;
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
	 * <h4>对象转成UsersRoles对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [userId,roleId,id]
	 * </pre>
	 */
	public UsersRoles convert(){ 
		UsersRoles usersRoles = new UsersRoles();
		usersRoles.setUserId(userId);
		usersRoles.setRoleId(roleId);
		usersRoles.setId(id);
		return usersRoles;
	} 
	/**
	 * <h4>UsersRoles对象转成UsersRolesParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [userId,roleId,id]
	 * </pre>
	 */
	public UsersRolesParam compat(UsersRoles usersRoles){ 
		if(null == usersRoles){
			return new UsersRolesParam();
		}
		this.setUserId(usersRoles.getUserId());
		this.setRoleId(usersRoles.getRoleId());
		this.setId(usersRoles.getId());
		return this;
	} 
}
