package cn.peyton.plum.mall.param.product;


import cn.peyton.plum.mall.pojo.product.ShopProductSku;

import java.io.Serializable;
/**
 * <h3> 商品规格关联 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年12月06日 22:33:06
 * @version 1.0.0
 * </pre>
*/
public class ShopProductSkuParam implements Serializable {
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

	/**
	 * <h4>对象转成ShopProductSku对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,skuId,skuValueId,productId]
	 * </pre>
	 */
	public ShopProductSku convert(){ 
		ShopProductSku shopProductSku = new ShopProductSku();
		shopProductSku.setId(id);
		shopProductSku.setSkuId(skuId);
		shopProductSku.setSkuValueId(skuValueId);
		shopProductSku.setProductId(productId);
		return shopProductSku;
	} 
	/**
	 * <h4>ShopProductSku对象转成ShopProductSkuParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,skuId,skuValueId,productId]
	 * </pre>
	 */
	public ShopProductSkuParam compat(ShopProductSku shopProductSku){ 
		if(null == shopProductSku){
			return new ShopProductSkuParam();
		}
		this.setId(shopProductSku.getId());
		this.setSkuId(shopProductSku.getSkuId());
		this.setSkuValueId(shopProductSku.getSkuValueId());
		this.setProductId(shopProductSku.getProductId());
		return this;
	} 
}
