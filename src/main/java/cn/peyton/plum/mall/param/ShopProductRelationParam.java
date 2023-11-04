package cn.peyton.plum.mall.param;


import cn.peyton.plum.mall.pojo.ShopProductRelation;

import java.io.Serializable;
/**
 * <h3> 商品点赞和收藏 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
public class ShopProductRelationParam implements Serializable {
	/**   */
	private Long id;
	/** 会员ID  */
	private Long memberId;
	/** 商品ID  */
	private Long productId;
	/** 类型(收藏(collect）、点赞(like))  */
	private String type;
	/** 某种类型的商品(普通商品、秒杀商品)  */
	private String category;
	/** 添加时间  */
	private Integer createTime;
	/** 是否删除: 默认1(1：可用;0已删除)  */
	private Boolean isDel;

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
	 * @param memberId 会员ID 
	 */ 
	public void setMemberId(Long memberId){
		this.memberId = memberId;
	}

	/** 
	 * @return 会员ID 
	 */ 
	public Long getMemberId(){
		return memberId;
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
	 * @param type 类型(收藏(collect）、点赞(like)) 
	 */ 
	public void setType(String type){
		this.type = type;
	}

	/** 
	 * @return 类型(收藏(collect）、点赞(like)) 
	 */ 
	public String getType(){
		return type;
	}

	/** 
	 * @param category 某种类型的商品(普通商品、秒杀商品) 
	 */ 
	public void setCategory(String category){
		this.category = category;
	}

	/** 
	 * @return 某种类型的商品(普通商品、秒杀商品) 
	 */ 
	public String getCategory(){
		return category;
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
	 * <h4>对象转成ShopProductRelation对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,memberId,productId,type,category,createTime,isDel]
	 * </pre>
	 */
	public ShopProductRelation convert(){
		ShopProductRelation shopProductRelation = new ShopProductRelation(); 
		shopProductRelation.setId(id);
		shopProductRelation.setMemberId(memberId);
		shopProductRelation.setProductId(productId);
		shopProductRelation.setType(type);
		shopProductRelation.setCategory(category);
		shopProductRelation.setCreateTime(createTime);
		shopProductRelation.setIsDel(isDel);
		return shopProductRelation;
	} 
	/**
	 * <h4>ShopProductRelation对象转成ShopProductRelationParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,memberId,productId,type,category,createTime,isDel]
	 * </pre>
	 */
	public ShopProductRelationParam compat(ShopProductRelation shopProductRelation){ 
		if(null == shopProductRelation){
			return new ShopProductRelationParam();
		}
		this.setId(shopProductRelation.getId());
		this.setMemberId(shopProductRelation.getMemberId());
		this.setProductId(shopProductRelation.getProductId());
		this.setType(shopProductRelation.getType());
		this.setCategory(shopProductRelation.getCategory());
		this.setCreateTime(shopProductRelation.getCreateTime());
		this.setIsDel(shopProductRelation.getIsDel());
		return this;
	} 
}
