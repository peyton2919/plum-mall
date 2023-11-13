package cn.peyton.plum.mall.param;


import cn.peyton.plum.mall.pojo.RoleDept;

import java.io.Serializable;
/**
 * <h3> 角色部门关联 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月13日 20:53:02
 * @version 1.0.0
 * </pre>
*/
public class RoleDeptParam implements Serializable {
	/**   */
	private Long id;
	/**   */
	private Long roleId;
	/**   */
	private Integer deptId;

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
	 * <h4>对象转成RoleDept对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,roleId,deptId]
	 * </pre>
	 */
	public RoleDept convert(){
		RoleDept roleDept = new RoleDept(); 
		roleDept.setId(id);
		roleDept.setRoleId(roleId);
		roleDept.setDeptId(deptId);
		return roleDept;
	} 
	/**
	 * <h4>RoleDept对象转成RoleDeptParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,roleId,deptId]
	 * </pre>
	 */
	public RoleDeptParam compat(RoleDept roleDept){ 
		if(null == roleDept){
			return new RoleDeptParam();
		}
		this.setId(roleDept.getId());
		this.setRoleId(roleDept.getRoleId());
		this.setDeptId(roleDept.getDeptId());
		return this;
	} 
}
