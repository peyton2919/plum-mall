package cn.peyton.plum.mall.pojo;


import java.io.Serializable;
/**
 * <h3> 商品点赞和收藏 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
public class ShopProductRelation implements Serializable {
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

}
