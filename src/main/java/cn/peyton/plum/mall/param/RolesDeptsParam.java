package cn.peyton.plum.mall.param;


import cn.peyton.plum.mall.pojo.RolesDepts;

import java.io.Serializable;
/**
 * <h3> 角色部门关联 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
public class RolesDeptsParam implements Serializable {
	/**   */
	private Long roleId;
	/**   */
	private Integer deptId;
	/**   */
	private Long id;

	//================================== Constructor =======================================//

	//================================== Method =======================================//


	//================================== PREFIX_GET AND PREFIX_SET =======================================//

	/** 
	 * @param roleId  
	 */ 
	public void setRoleId(Long roleId){
		this.roleId = roleId;
	}

	/** 
	 * @return  
	 */ 
	public Long getRoleId(){
		return roleId;
	}

	/** 
	 * @param deptId  
	 */ 
	public void setDeptId(Integer deptId){
		this.deptId = deptId;
	}

	/** 
	 * @return  
	 */ 
	public Integer getDeptId(){
		return deptId;
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
	 * <h4>对象转成RolesDepts对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [roleId,deptId,id]
	 * </pre>
	 */
	public RolesDepts convert(){
		RolesDepts rolesDepts = new RolesDepts(); 
		rolesDepts.setRoleId(roleId);
		rolesDepts.setDeptId(deptId);
		rolesDepts.setId(id);
		return rolesDepts;
	} 
	/**
	 * <h4>RolesDepts对象转成RolesDeptsParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [roleId,deptId,id]
	 * </pre>
	 */
	public RolesDeptsParam compat(RolesDepts rolesDepts){ 
		if(null == rolesDepts){
			return new RolesDeptsParam();
		}
		this.setRoleId(rolesDepts.getRoleId());
		this.setDeptId(rolesDepts.getDeptId());
		this.setId(rolesDepts.getId());
		return this;
	} 
}
