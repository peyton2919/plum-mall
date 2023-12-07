package cn.peyton.plum.mall.param.sys;


import cn.peyton.plum.mall.pojo.sys.RoleMenu;

import java.io.Serializable;
/**
 * <h3> 角色菜单关联 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月13日 20:53:15
 * @version 1.0.0
 * </pre>
*/
public class RoleMenuParam implements Serializable {
	/**   */
	private Long id;
	/** 菜单ID  */
	private Long menuId;
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
	 * <h4>对象转成RoleMenu对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,menuId,roleId]
	 * </pre>
	 */
	public RoleMenu convert(){
		RoleMenu roleMenu = new RoleMenu(); 
		roleMenu.setId(id);
		roleMenu.setMenuId(menuId);
		roleMenu.setRoleId(roleId);
		return roleMenu;
	} 
	/**
	 * <h4>RoleMenu对象转成RoleMenuParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,menuId,roleId]
	 * </pre>
	 */
	public RoleMenuParam compat(RoleMenu roleMenu){ 
		if(null == roleMenu){
			return new RoleMenuParam();
		}
		this.setId(roleMenu.getId());
		this.setMenuId(roleMenu.getMenuId());
		this.setRoleId(roleMenu.getRoleId());
		return this;
	} 
}
