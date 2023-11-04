package cn.peyton.plum.mall.pojo;


import java.io.Serializable;
/**
 * <h3> 商品评论 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
public class ShopProductReply implements Serializable {
	/** 评论ID  */
	private Long id;
	/** 会员ID  */
	private Long memberId;
	/** 订单ID  */
	private Long oid;
	/** 唯一id  */
	private String uniqueCode;
	/** 产品id  */
	private Long productId;
	/** 某种商品类型(普通商品、秒杀商品）  */
	private String replyType;
	/** 商品分数（1-10）  */
	private Integer productScore;
	/** 服务分数（1-10）  */
	private Integer serviceScore;
	/** 评论内容  */
	private String comment;
	/** 评论图片  */
	private String pics;
	/** 评论时间  */
	private Integer createTime;
	/** 管理员回复内容  */
	private String merchantReplyContent;
	/** 管理员回复时间  */
	private Integer merchantReplyTime;
	/** 是否删除: 默认1(1：可用;0已删除)  */
	private Integer isDel;
	/** 是否回复, 默认:0 {0 未回复 1 已回复}  */
	private Integer isReply;

	//================================== Constructor =======================================//

	//================================== Method =======================================//


	//================================== PREFIX_GET AND PREFIX_SET =======================================//

	/** 
	 * @param id 评论ID 
	 */ 
	public void setId(Long id){
		this.id = id;
	}

	/** 
	 * @return 评论ID 
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
	 * @param oid 订单ID 
	 */ 
	public void setOid(Long oid){
		this.oid = oid;
	}

	/** 
	 * @return 订单ID 
	 */ 
	public Long getOid(){
		return oid;
	}

	/** 
	 * @param uniqueCode 唯一id 
	 */ 
	public void setUniqueCode(String uniqueCode){
		this.uniqueCode = uniqueCode;
	}

	/** 
	 * @return 唯一id 
	 */ 
	public String getUniqueCode(){
		return uniqueCode;
	}

	/** 
	 * @param productId 产品id 
	 */ 
	public void setProductId(Long productId){
		this.productId = productId;
	}

	/** 
	 * @return 产品id 
	 */ 
	public Long getProductId(){
		return productId;
	}

	/** 
	 * @param replyType 某种商品类型(普通商品、秒杀商品） 
	 */ 
	public void setReplyType(String replyType){
		this.replyType = replyType;
	}

	/** 
	 * @return 某种商品类型(普通商品、秒杀商品） 
	 */ 
	public String getReplyType(){
		return replyType;
	}

	/** 
	 * @param productScore 商品分数（1-10） 
	 */ 
	public void setProductScore(Integer productScore){
		this.productScore = productScore;
	}

	/** 
	 * @return 商品分数（1-10） 
	 */ 
	public Integer getProductScore(){
		return productScore;
	}

	/** 
	 * @param serviceScore 服务分数（1-10） 
	 */ 
	public void setServiceScore(Integer serviceScore){
		this.serviceScore = serviceScore;
	}

	/** 
	 * @return 服务分数（1-10） 
	 */ 
	public Integer getServiceScore(){
		return serviceScore;
	}

	/** 
	 * @param comment 评论内容 
	 */ 
	public void setComment(String comment){
		this.comment = comment;
	}

	/** 
	 * @return 评论内容 
	 */ 
	public String getComment(){
		return comment;
	}

	/** 
	 * @param pics 评论图片 
	 */ 
	public void setPics(String pics){
		this.pics = pics;
	}

	/** 
	 * @return 评论图片 
	 */ 
	public String getPics(){
		return pics;
	}

	/** 
	 * @param createTime 评论时间 
	 */ 
	public void setCreateTime(Integer createTime){
		this.createTime = createTime;
	}

	/** 
	 * @return 评论时间 
	 */ 
	public Integer getCreateTime(){
		return createTime;
	}

	/** 
	 * @param merchantReplyContent 管理员回复内容 
	 */ 
	public void setMerchantReplyContent(String merchantReplyContent){
		this.merchantReplyContent = merchantReplyContent;
	}

	/** 
	 * @return 管理员回复内容 
	 */ 
	public String getMerchantReplyContent(){
		return merchantReplyContent;
	}

	/** 
	 * @param merchantReplyTime 管理员回复时间 
	 */ 
	public void setMerchantReplyTime(Integer merchantReplyTime){
		this.merchantReplyTime = merchantReplyTime;
	}

	/** 
	 * @return 管理员回复时间 
	 */ 
	public Integer getMerchantReplyTime(){
		return merchantReplyTime;
	}

	/** 
	 * @param isDel 是否删除: 默认1(1：可用;0已删除) 
	 */ 
	public void setIsDel(Integer isDel){
		this.isDel = isDel;
	}

	/** 
	 * @return 是否删除: 默认1(1：可用;0已删除) 
	 */ 
	public Integer getIsDel(){
		return isDel;
	}

	/** 
	 * @param isReply 是否回复, 默认:0 {0 未回复 1 已回复} 
	 */ 
	public void setIsReply(Integer isReply){
		this.isReply = isReply;
	}

	/** 
	 * @return 是否回复, 默认:0 {0 未回复 1 已回复} 
	 */ 
	public Integer getIsReply(){
		return isReply;
	}

}
