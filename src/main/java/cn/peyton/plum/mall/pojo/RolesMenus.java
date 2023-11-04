package cn.peyton.plum.mall.pojo;


import java.io.Serializable;
/**
 * <h3> 角色菜单关联 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
public class RolesMenus implements Serializable {
	/** 菜单ID  */
	private Long menuId;
	/** 角色ID  */
	private Long roleId;
	/**   */
	private Long id;

	//================================== Constructor =======================================//

	//================================== Method =======================================//


	//================================== PREFIX_GET AND PREFIX_SET =======================================//

	/** 
	 * @param menuId 菜单ID 
	 */ 
	public void setMenuId(Long menuId){
		this.menuId = menuId;
	}

	/** 
	 * @return 菜单ID 
	 */ 
	public Long getMenuId(){
		return menuId;
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

}
