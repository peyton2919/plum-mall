package cn.peyton.plum.mall.pojo;


import java.io.Serializable;
/**
 * <h3> 岗位 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
public class Job implements Serializable {
	/** ID  */
	private Integer id;
	/** 岗位名称  */
	private String name;
	/** 排序，默认为0; 按大到小排序  */
	private Integer seq;
	/** 部门ID  */
	private Integer deptId;
	/** 创建日期  */
	private Integer createTime;
	/** 是否删除: 默认1(1：可用;0已删除)  */
	private Integer isDel;

	//================================== Constructor =======================================//

	//================================== Method =======================================//


	//================================== PREFIX_GET AND PREFIX_SET =======================================//

	/** 
	 * @param id ID 
	 */ 
	public void setId(Integer id){
		this.id = id;
	}

	/** 
	 * @return ID 
	 */ 
	public Integer getId(){
		return id;
	}

	/** 
	 * @param name 岗位名称 
	 */ 
	public void setName(String name){
		this.name = name;
	}

	/** 
	 * @return 岗位名称 
	 */ 
	public String getName(){
		return name;
	}

	/** 
	 * @param seq 排序，默认为0; 按大到小排序 
	 */ 
	public void setSeq(Integer seq){
		this.seq = seq;
	}

	/** 
	 * @return 排序，默认为0; 按大到小排序 
	 */ 
	public Integer getSeq(){
		return seq;
	}

	/** 
	 * @param deptId 部门ID 
	 */ 
	public void setDeptId(Integer deptId){
		this.deptId = deptId;
	}

	/** 
	 * @return 部门ID 
	 */ 
	public Integer getDeptId(){
		return deptId;
	}

	/** 
	 * @param createTime 创建日期 
	 */ 
	public void setCreateTime(Integer createTime){
		this.createTime = createTime;
	}

	/** 
	 * @return 创建日期 
	 */ 
	public Integer getCreateTime(){
		return createTime;
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

}
