package cn.peyton.plum.mall.pojo;


import java.io.Serializable;
/**
 * <h3> 商品规格表 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
public class ShopSku implements Serializable {
	/**   */
	private Long id;
	/** 规格名称  */
	private String name;
	/** 商品属性卡片属性类型 0无 1颜色 2图片 默认: 0  */
	private Integer skuType;
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
	 * @param name 规格名称 
	 */ 
	public void setName(String name){
		this.name = name;
	}

	/** 
	 * @return 规格名称 
	 */ 
	public String getName(){
		return name;
	}

	/** 
	 * @param skuType 商品属性卡片属性类型 0无 1颜色 2图片 默认: 0 
	 */ 
	public void setSkuType(Integer skuType){
		this.skuType = skuType;
	}

	/** 
	 * @return 商品属性卡片属性类型 0无 1颜色 2图片 默认: 0 
	 */ 
	public Integer getSkuType(){
		return skuType;
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