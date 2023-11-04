package cn.peyton.plum.mall.param;

import cn.peyton.plum.mall.pojo.ShippingTemplatesFree;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * <h3> 运费免费模板表 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
public class ShippingTemplatesFreeParam implements Serializable {
	/** 编号  */
	private Integer id;
	/** 省ID  */
	private Integer provinceId;
	/** 模板ID  */
	private Integer tempId;
	/** 城市ID  */
	private Integer cityId;
	/** 包邮件数  */
	private BigDecimal number;
	/** 包邮金额  */
	private BigDecimal price;
	/** 计费方式  */
	private Integer type;
	/** 分组唯一值  */
	private String uniqid;

	//================================== Constructor =======================================//

	//================================== Method =======================================//


	//================================== PREFIX_GET AND PREFIX_SET =======================================//

	/** 
	 * @param id 编号 
	 */ 
	public void setId(Integer id){
		this.id = id;
	}

	/** 
	 * @return 编号 
	 */ 
	public Integer getId(){
		return id;
	}

	/** 
	 * @param provinceId 省ID 
	 */ 
	public void setProvinceId(Integer provinceId){
		this.provinceId = provinceId;
	}

	/** 
	 * @return 省ID 
	 */ 
	public Integer getProvinceId(){
		return provinceId;
	}

	/** 
	 * @param tempId 模板ID 
	 */ 
	public void setTempId(Integer tempId){
		this.tempId = tempId;
	}

	/** 
	 * @return 模板ID 
	 */ 
	public Integer getTempId(){
		return tempId;
	}

	/** 
	 * @param cityId 城市ID 
	 */ 
	public void setCityId(Integer cityId){
		this.cityId = cityId;
	}

	/** 
	 * @return 城市ID 
	 */ 
	public Integer getCityId(){
		return cityId;
	}

	/** 
	 * @param number 包邮件数 
	 */ 
	public void setNumber(BigDecimal number){
		this.number = number;
	}

	/** 
	 * @return 包邮件数 
	 */ 
	public BigDecimal getNumber(){
		return number;
	}

	/** 
	 * @param price 包邮金额 
	 */ 
	public void setPrice(BigDecimal price){
		this.price = price;
	}

	/** 
	 * @return 包邮金额 
	 */ 
	public BigDecimal getPrice(){
		return price;
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
	 * @param uniqid 分组唯一值 
	 */ 
	public void setUniqid(String uniqid){
		this.uniqid = uniqid;
	}

	/** 
	 * @return 分组唯一值 
	 */ 
	public String getUniqid(){
		return uniqid;
	}

	/**
	 * <h4>对象转成ShippingTemplatesFree对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,provinceId,tempId,cityId,number,price,type,uniqid]
	 * </pre>
	 */
	public ShippingTemplatesFree convert(){
		ShippingTemplatesFree shippingTemplatesFree = new ShippingTemplatesFree(); 
		shippingTemplatesFree.setId(id);
		shippingTemplatesFree.setProvinceId(provinceId);
		shippingTemplatesFree.setTempId(tempId);
		shippingTemplatesFree.setCityId(cityId);
		shippingTemplatesFree.setNumber(number);
		shippingTemplatesFree.setPrice(price);
		shippingTemplatesFree.setType(type);
		shippingTemplatesFree.setUniqid(uniqid);
		return shippingTemplatesFree;
	} 
	/**
	 * <h4>ShippingTemplatesFree对象转成ShippingTemplatesFreeParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,provinceId,tempId,cityId,number,price,type,uniqid]
	 * </pre>
	 */
	public ShippingTemplatesFreeParam compat(ShippingTemplatesFree shippingTemplatesFree){ 
		if(null == shippingTemplatesFree){
			return new ShippingTemplatesFreeParam();
		}
		this.setId(shippingTemplatesFree.getId());
		this.setProvinceId(shippingTemplatesFree.getProvinceId());
		this.setTempId(shippingTemplatesFree.getTempId());
		this.setCityId(shippingTemplatesFree.getCityId());
		this.setNumber(shippingTemplatesFree.getNumber());
		this.setPrice(shippingTemplatesFree.getPrice());
		this.setType(shippingTemplatesFree.getType());
		this.setUniqid(shippingTemplatesFree.getUniqid());
		return this;
	} 
}
