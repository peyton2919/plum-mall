package cn.peyton.plum.mall.param.product;


import cn.peyton.plum.mall.pojo.product.ShopProductReplyImg;

import java.io.Serializable;
/**
 * <h3> 商品评论 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年12月13日 16:12:19
 * @version 1.0.0
 * </pre>
*/
public class ShopProductReplyImgParam implements Serializable {
	/** 评论Id  */
	private Long id;
	/** 产品Id  */
	private Long productReplyId;
	/** 图片地址  */
	private String src;
	/** 是否显示, 默认: 1 显示, 0 不显示  */
	private Integer isShow;

	//================================== Constructor =======================================//

	//================================== Method =======================================//


	//================================== PREFIX_GET AND PREFIX_SET =======================================//

	/** 
	 * @param id 评论Id 
	 */ 
	public void setId(Long id){
		this.id = id;
	}

	/** 
	 * @return 评论Id 
	 */ 
	public Long getId(){
		return id;
	}

	/** 
	 * @param productReplyId 产品Id 
	 */ 
	public void setProductReplyId(Long productReplyId){
		this.productReplyId = productReplyId;
	}

	/** 
	 * @return 产品Id 
	 */ 
	public Long getProductReplyId(){
		return productReplyId;
	}

	/** 
	 * @param src 图片地址 
	 */ 
	public void setSrc(String src){
		this.src = src;
	}

	/** 
	 * @return 图片地址 
	 */ 
	public String getSrc(){
		return src;
	}

	/** 
	 * @param isShow 是否显示, 默认: 1 显示, 0 不显示 
	 */ 
	public void setIsShow(Integer isShow){
		this.isShow = isShow;
	}

	/** 
	 * @return 是否显示, 默认: 1 显示, 0 不显示 
	 */ 
	public Integer getIsShow(){
		return isShow;
	}

	/**
	 * <h4>对象转成ShopProductReplyImg对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,productReplyId,src,isShow]
	 * </pre>
	 */
	public ShopProductReplyImg convert(){
		ShopProductReplyImg shopProductReplyImg = new ShopProductReplyImg(); 
		shopProductReplyImg.setId(id);
		shopProductReplyImg.setProductReplyId(productReplyId);
		shopProductReplyImg.setSrc(src);
		shopProductReplyImg.setIsShow(isShow);
		return shopProductReplyImg;
	} 
	/**
	 * <h4>ShopProductReplyImg对象转成ShopProductReplyImgParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,productReplyId,src,isShow]
	 * </pre>
	 */
	public ShopProductReplyImgParam compat(ShopProductReplyImg shopProductReplyImg){ 
		if(null == shopProductReplyImg){
			return new ShopProductReplyImgParam();
		}
		this.setId(shopProductReplyImg.getId());
		this.setProductReplyId(shopProductReplyImg.getProductReplyId());
		this.setSrc(shopProductReplyImg.getSrc());
		this.setIsShow(shopProductReplyImg.getIsShow());
		return this;
	} 
}
