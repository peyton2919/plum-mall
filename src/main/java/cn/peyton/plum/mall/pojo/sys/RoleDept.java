package cn.peyton.plum.mall.pojo.sys;


import java.io.Serializable;
/**
 * <h3> 角色部门关联 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月13日 20:53:02
 * @version 1.0.0
 * </pre>
*/
public class RoleDept implements Serializable {
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

}
