package cn.peyton.plum.mall.pojo.product;


import java.io.Serializable;
/**
 * <h3> 商品规格关联 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年12月06日 22:33:06
 * @version 1.0.0
 * </pre>
*/
public class ShopProductSku implements Serializable {
	/**   */
	private Long id;
	/** 规格Id  */
	private Long skuId;
	/** 规格值Id  */
	private Long skuValueId;
	/** 商品Id  */
	private Long productId;

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
	 * @param skuId 规格Id 
	 */ 
	public void setSkuId(Long skuId){
		this.skuId = skuId;
	}

	/** 
	 * @return 规格Id 
	 */ 
	public Long getSkuId(){
		return skuId;
	}

	/** 
	 * @param skuValueId 规格值Id 
	 */ 
	public void setSkuValueId(Long skuValueId){
		this.skuValueId = skuValueId;
	}

	/** 
	 * @return 规格值Id 
	 */ 
	public Long getSkuValueId(){
		return skuValueId;
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

}
