package cn.peyton.plum.mall.pojo.product;


import java.io.Serializable;
/**
 * <h3> 商品规格联系{用来关联商品与规格;辅助作用} 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年12月01日 15:52:45
 * @version 1.0.0
 * </pre>
*/
public class ShopProductSkuJoin implements Serializable {
	/**   */
	private Long id;
	/** 商品Id  */
	private Long productId;
	/** 规格值Id  */
	private Long skuId;

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
	 * @param productId 商品Id 
	 */ 
	public void setProductId(Long productId){
		this.productId = productId;
	}

	/** 
	 * @return 商品Id 
	 */ 
	public Long getProductId(){
		return productId;
	}

	/** 
	 * @param skuId 规格值Id 
	 */ 
	public void setSkuId(Long skuId){
		this.skuId = skuId;
	}

	/** 
	 * @return 规格值Id 
	 */ 
	public Long getSkuId(){
		return skuId;
	}

}
