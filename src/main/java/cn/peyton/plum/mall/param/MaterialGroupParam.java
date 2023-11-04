package cn.peyton.plum.mall.param;


import cn.peyton.plum.mall.pojo.MaterialGroup;

import java.io.Serializable;
/**
 * <h3> 素材分组 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
public class MaterialGroupParam implements Serializable {
	/** ID  */
	private Long id;
	/** 创建者ID  */
	private Long createId;
	/** 分组名  */
	private String name;
	/** 创建者类型:默认 0 {0: 员工, 1: 供应商, 2: 管理员, 3: 会员}  */
	private Integer createType;
	/** 创建时间  */
	private Integer createTime;

	//================================== Constructor =======================================//

	//================================== Method =======================================//


	//================================== PREFIX_GET AND PREFIX_SET =======================================//

	/** 
	 * @param id ID 
	 */ 
	public void setId(Long id){
		this.id = id;
	}

	/** 
	 * @return ID 
	 */ 
	public Long getId(){
		return id;
	}

	/** 
	 * @param createId 创建者ID 
	 */ 
	public void setCreateId(Long createId){
		this.createId = createId;
	}

	/** 
	 * @return 创建者ID 
	 */ 
	public Long getCreateId(){
		return createId;
	}

	/** 
	 * @param name 分组名 
	 */ 
	public void setName(String name){
		this.name = name;
	}

	/** 
	 * @return 分组名 
	 */ 
	public String getName(){
		return name;
	}

	/** 
	 * @param createType 创建者类型:默认 0 {0: 员工, 1: 供应商, 2: 管理员, 3: 会员} 
	 */ 
	public void setCreateType(Integer createType){
		this.createType = createType;
	}

	/** 
	 * @return 创建者类型:默认 0 {0: 员工, 1: 供应商, 2: 管理员, 3: 会员} 
	 */ 
	public Integer getCreateType(){
		return createType;
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
	 * <h4>对象转成MaterialGroup对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,createId,name,createType,createTime]
	 * </pre>
	 */
	public MaterialGroup convert(){
		MaterialGroup materialGroup = new MaterialGroup(); 
		materialGroup.setId(id);
		materialGroup.setCreateId(createId);
		materialGroup.setName(name);
		materialGroup.setCreateType(createType);
		materialGroup.setCreateTime(createTime);
		return materialGroup;
	} 
	/**
	 * <h4>MaterialGroup对象转成MaterialGroupParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,createId,name,createType,createTime]
	 * </pre>
	 */
	public MaterialGroupParam compat(MaterialGroup materialGroup){ 
		if(null == materialGroup){
			return new MaterialGroupParam();
		}
		this.setId(materialGroup.getId());
		this.setCreateId(materialGroup.getCreateId());
		this.setName(materialGroup.getName());
		this.setCreateType(materialGroup.getCreateType());
		this.setCreateTime(materialGroup.getCreateTime());
		return this;
	} 
}
