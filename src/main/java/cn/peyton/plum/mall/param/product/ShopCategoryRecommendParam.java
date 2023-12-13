package cn.peyton.plum.mall.param.product;


import cn.peyton.plum.mall.bo.ShopProductBo;
import cn.peyton.plum.mall.pojo.product.ShopCategoryRecommend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <h3> 商品分类推荐 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年12月09日 20:13:39
 * @version 1.0.0
 * </pre>
*/
public class ShopCategoryRecommendParam implements Serializable {
	/** Id  */
	private Long id;
	/** 商品Dd  */
	private Long productId;
	/** 商品Dd  */
	private List<ShopProductParam> products;
	/** 分类Id  */
	private Integer categoryId;
	/** 排序取值范围0~9999，默认为0; 按大到小排序  */
	private Short seq;
	/** 添加时间  */
	private Integer createTime;

	//================================== Constructor =======================================//
	public ShopCategoryRecommendParam(){
		if (null == products) { products = new ArrayList<>(); }
	}
	//================================== Method =======================================//


	//================================== PREFIX_GET AND PREFIX_SET =======================================//

	/** 
	 * @param id Id 
	 */ 
	public void setId(Long id){
		this.id = id;
	}

	/** 
	 * @return Id 
	 */ 
	public Long getId(){
		return id;
	}
	/**
	 * @param productId 商品Dd
	 */
	public void setProductId(Long productId){
		this.productId = productId;
	}

	/**
	 * @return 商品Dd
	 */
	public Long getProductId(){
		return productId;
	}


	/**
	 * @return 商品对象集合
	 */
	public List<ShopProductParam> getProducts() {
		return products;
	}

	/**
	 * @param products 商品对象集合
	 */
	public void setProducts(List<ShopProductParam> products) {
		this.products = products;
	}

	/**
	 * @param categoryId 分类Id 
	 */ 
	public void setCategoryId(Integer categoryId){
		this.categoryId = categoryId;
	}

	/** 
	 * @return 分类Id 
	 */ 
	public Integer getCategoryId(){
		return categoryId;
	}

	/** 
	 * @param seq 排序取值范围0~9999，默认为0; 按大到小排序 
	 */ 
	public void setSeq(Short seq){
		this.seq = seq;
	}

	/** 
	 * @return 排序取值范围0~9999，默认为0; 按大到小排序 
	 */ 
	public Short getSeq(){
		return seq;
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
	 * <h4>对象转成ShopCategoryRecommend对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,productId,categoryId,seq,createTime]
	 * </pre>
	 */
	public ShopCategoryRecommend convert(){
		ShopCategoryRecommend shopCategoryRecommend = new ShopCategoryRecommend(); 
		shopCategoryRecommend.setId(id);
		shopCategoryRecommend.setProductId(productId);
		shopCategoryRecommend.setProducts(new ShopProductBo().reverse(products));
		shopCategoryRecommend.setCategoryId(categoryId);
		shopCategoryRecommend.setSeq(seq);
		shopCategoryRecommend.setCreateTime(createTime);
		return shopCategoryRecommend;
	} 
	/**
	 * <h4>ShopCategoryRecommend对象转成ShopCategoryRecommendParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,productId,categoryId,seq,createTime]
	 * </pre>
	 */
	public ShopCategoryRecommendParam compat(ShopCategoryRecommend shopCategoryRecommend){ 
		if(null == shopCategoryRecommend){
			return new ShopCategoryRecommendParam();
		}
		this.setId(shopCategoryRecommend.getId());
		this.setProductId(shopCategoryRecommend.getProductId());
		this.setProducts(new ShopProductBo().adapter(shopCategoryRecommend.getProducts()));
		this.setCategoryId(shopCategoryRecommend.getCategoryId());
		this.setSeq(shopCategoryRecommend.getSeq());
		this.setCreateTime(shopCategoryRecommend.getCreateTime());
		return this;
	} 
}
