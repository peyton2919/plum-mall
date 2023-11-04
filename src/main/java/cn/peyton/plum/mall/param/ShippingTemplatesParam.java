package cn.peyton.plum.mall.param;


import cn.peyton.plum.mall.pojo.ShippingTemplates;

import java.io.Serializable;
/**
 * <h3> 运费模板表 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
public class ShippingTemplatesParam implements Serializable {
	/** 模板ID  */
	private Integer id;
	/** 模板名称  */
	private String name;
	/** 计费方式  */
	private Integer type;
	/** 地域以及费用  */
	private String regionInfo;
	/** 指定包邮开关  */
	private Integer appoint;
	/** 指定包邮内容  */
	private String appointInfo;
	/** 添加时间  */
	private Integer createTime;
	/** 更新时间  */
	private Integer updateTime;
	/** 是否删除: 默认1(1：可用;0已删除)  */
	private Boolean isDel;
	/** 排序，默认为0; 按大到小排序  */
	private Integer seq;

	//================================== Constructor =======================================//

	//================================== Method =======================================//


	//================================== PREFIX_GET AND PREFIX_SET =======================================//

	/** 
	 * @param id 模板ID 
	 */ 
	public void setId(Integer id){
		this.id = id;
	}

	/** 
	 * @return 模板ID 
	 */ 
	public Integer getId(){
		return id;
	}

	/** 
	 * @param name 模板名称 
	 */ 
	public void setName(String name){
		this.name = name;
	}

	/** 
	 * @return 模板名称 
	 */ 
	public String getName(){
		return name;
	}

	/** 
	 * @param type 计费方式 
	 */ 
	public void setType(Integer type){
		this.type = type;
	}

	/** 
	 * @return 计费方式 
	 */ 
	public Integer getType(){
		return type;
	}

	/** 
	 * @param regionInfo 地域以及费用 
	 */ 
	public void setRegionInfo(String regionInfo){
		this.regionInfo = regionInfo;
	}

	/** 
	 * @return 地域以及费用 
	 */ 
	public String getRegionInfo(){
		return regionInfo;
	}

	/** 
	 * @param appoint 指定包邮开关 
	 */ 
	public void setAppoint(Integer appoint){
		this.appoint = appoint;
	}

	/** 
	 * @return 指定包邮开关 
	 */ 
	public Integer getAppoint(){
		return appoint;
	}

	/** 
	 * @param appointInfo 指定包邮内容 
	 */ 
	public void setAppointInfo(String appointInfo){
		this.appointInfo = appointInfo;
	}

	/** 
	 * @return 指定包邮内容 
	 */ 
	public String getAppointInfo(){
		return appointInfo;
	}

	/** 
	 * @param createTime 添加时间 
	 */ 
	public void setCreateTime(Integer createTime){
		this.createTime = createTime;
	}

	/** 
	 * @return 添加时间 
	 */ 
	public Integer getCreateTime(){
		return createTime;
	}

	/** 
	 * @param updateTime 更新时间 
	 */ 
	public void setUpdateTime(Integer updateTime){
		this.updateTime = updateTime;
	}

	/** 
	 * @return 更新时间 
	 */ 
	public Integer getUpdateTime(){
		return updateTime;
	}

	/** 
	 * @param isDel 是否删除: 默认1(1：可用;0已删除) 
	 */ 
	public void setIsDel(Boolean isDel){
		this.isDel = isDel;
	}

	/** 
	 * @return 是否删除: 默认1(1：可用;0已删除) 
	 */ 
	public Boolean getIsDel(){
		return isDel;
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
	 * <h4>对象转成ShippingTemplates对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,name,type,regionInfo,appoint,appointInfo,createTime,updateTime,isDel,seq]
	 * </pre>
	 */
	public ShippingTemplates convert(){
		ShippingTemplates shippingTemplates = new ShippingTemplates(); 
		shippingTemplates.setId(id);
		shippingTemplates.setName(name);
		shippingTemplates.setType(type);
		shippingTemplates.setRegionInfo(regionInfo);
		shippingTemplates.setAppoint(appoint);
		shippingTemplates.setAppointInfo(appointInfo);
		shippingTemplates.setCreateTime(createTime);
		shippingTemplates.setUpdateTime(updateTime);
		shippingTemplates.setIsDel(isDel);
		shippingTemplates.setSeq(seq);
		return shippingTemplates;
	} 
	/**
	 * <h4>ShippingTemplates对象转成ShippingTemplatesParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,name,type,regionInfo,appoint,appointInfo,createTime,updateTime,isDel,seq]
	 * </pre>
	 */
	public ShippingTemplatesParam compat(ShippingTemplates shippingTemplates){ 
		if(null == shippingTemplates){
			return new ShippingTemplatesParam();
		}
		this.setId(shippingTemplates.getId());
		this.setName(shippingTemplates.getName());
		this.setType(shippingTemplates.getType());
		this.setRegionInfo(shippingTemplates.getRegionInfo());
		this.setAppoint(shippingTemplates.getAppoint());
		this.setAppointInfo(shippingTemplates.getAppointInfo());
		this.setCreateTime(shippingTemplates.getCreateTime());
		this.setUpdateTime(shippingTemplates.getUpdateTime());
		this.setIsDel(shippingTemplates.getIsDel());
		this.setSeq(shippingTemplates.getSeq());
		return this;
	} 
}
