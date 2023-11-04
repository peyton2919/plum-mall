package cn.peyton.plum.mall.param;


import cn.peyton.plum.mall.pojo.ShopProductBanner;

import java.io.Serializable;
/**
 * <h3> 轮播图 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
public class ShopProductBannerParam implements Serializable {
	/**   */
	private Long id;
	/** 商品ID  */
	private Long productId;
	/** 轮播图链接地址  */
	private String url;
	/** 创建时间  */
	private Integer createTime;

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
	 * @param productId 商品ID 
	 */ 
	public void setProductId(Long productId){
		this.productId = productId;
	}

	/** 
	 * @return 商品ID 
	 */ 
	public Long getProductId(){
		return productId;
	}

	/** 
	 * @param url 轮播图链接地址 
	 */ 
	public void setUrl(String url){
		this.url = url;
	}

	/** 
	 * @return 轮播图链接地址 
	 */ 
	public String getUrl(){
		return url;
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
	 * <h4>对象转成ShopProductBanner对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,productId,url,createTime]
	 * </pre>
	 */
	public ShopProductBanner convert(){
		ShopProductBanner shopProductBanner = new ShopProductBanner(); 
		shopProductBanner.setId(id);
		shopProductBanner.setProductId(productId);
		shopProductBanner.setUrl(url);
		shopProductBanner.setCreateTime(createTime);
		return shopProductBanner;
	} 
	/**
	 * <h4>ShopProductBanner对象转成ShopProductBannerParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,productId,url,createTime]
	 * </pre>
	 */
	public ShopProductBannerParam compat(ShopProductBanner shopProductBanner){ 
		if(null == shopProductBanner){
			return new ShopProductBannerParam();
		}
		this.setId(shopProductBanner.getId());
		this.setProductId(shopProductBanner.getProductId());
		this.setUrl(shopProductBanner.getUrl());
		this.setCreateTime(shopProductBanner.getCreateTime());
		return this;
	} 
}
