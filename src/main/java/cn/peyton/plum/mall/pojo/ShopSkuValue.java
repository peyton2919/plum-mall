package cn.peyton.plum.mall.pojo;


import java.io.Serializable;
/**
 * <h3> 商品规格 值表 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
public class ShopSkuValue implements Serializable {
	/**   */
	private Long id;
	/** 商品规格Id  */
	private Long skuId;
	/** 商品属性参数  */
	private String skuValue;
	/** 排序，默认为0; 按大到小排序  */
	private Integer seq;

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
	 * @param skuId 商品规格Id 
	 */ 
	public void setSkuId(Long skuId){
		this.skuId = skuId;
	}

	/** 
	 * @return 商品规格Id 
	 */ 
	public Long getSkuId(){
		return skuId;
	}

	/** 
	 * @param skuValue 商品属性参数 
	 */ 
	public void setSkuValue(String skuValue){
		this.skuValue = skuValue;
	}

	/** 
	 * @return 商品属性参数 
	 */ 
	public String getSkuValue(){
		return skuValue;
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

}
