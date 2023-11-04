package cn.peyton.plum.mall.param;


import cn.peyton.plum.mall.pojo.ShopCart;

import java.io.Serializable;
/**
 * <h3> 购物车 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
public class ShopCartParam implements Serializable {
	/** 购物车表ID  */
	private Long id;
	/** 用户ID  */
	private Long memberId;
	/** 类型： 默认product  */
	private String type;
	/** 商品ID  */
	private Long productId;
	/** 商品属性  */
	private String productAttrUnique;
	/** 商品数量  */
	private Integer cartNum;
	/** 0 = 未购买 1 = 已购买  */
	private Integer isPay;
	/** 是否删除: 默认1(1：可用;0已删除)  */
	private Integer isDel;
	/** 是否为立即购买,默认0 未立即购买 1购买  */
	private Integer isNew;
	/** 拼团id  */
	private Long combinationId;
	/** 秒杀产品ID  */
	private Long seckillId;
	/** 砍价id  */
	private Long bargainId;
	/** 添加时间  */
	private Integer createTime;
	/** 更新时间  */
	private Integer updateTime;

	//================================== Constructor =======================================//

	//================================== Method =======================================//


	//================================== PREFIX_GET AND PREFIX_SET =======================================//

	/** 
	 * @param id 购物车表ID 
	 */ 
	public void setId(Long id){
		this.id = id;
	}

	/** 
	 * @return 购物车表ID 
	 */ 
	public Long getId(){
		return id;
	}

	/** 
	 * @param memberId 用户ID 
	 */ 
	public void setMemberId(Long memberId){
		this.memberId = memberId;
	}

	/** 
	 * @return 用户ID 
	 */ 
	public Long getMemberId(){
		return memberId;
	}

	/** 
	 * @param type 类型： 默认product 
	 */ 
	public void setType(String type){
		this.type = type;
	}

	/** 
	 * @return 类型： 默认product 
	 */ 
	public String getType(){
		return type;
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
	 * @param productAttrUnique 商品属性 
	 */ 
	public void setProductAttrUnique(String productAttrUnique){
		this.productAttrUnique = productAttrUnique;
	}

	/** 
	 * @return 商品属性 
	 */ 
	public String getProductAttrUnique(){
		return productAttrUnique;
	}

	/** 
	 * @param cartNum 商品数量 
	 */ 
	public void setCartNum(Integer cartNum){
		this.cartNum = cartNum;
	}

	/** 
	 * @return 商品数量 
	 */ 
	public Integer getCartNum(){
		return cartNum;
	}

	/** 
	 * @param isPay 0 = 未购买 1 = 已购买 
	 */ 
	public void setIsPay(Integer isPay){
		this.isPay = isPay;
	}

	/** 
	 * @return 0 = 未购买 1 = 已购买 
	 */ 
	public Integer getIsPay(){
		return isPay;
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
	 * @param isNew 是否为立即购买,默认0 未立即购买 1购买 
	 */ 
	public void setIsNew(Integer isNew){
		this.isNew = isNew;
	}

	/** 
	 * @return 是否为立即购买,默认0 未立即购买 1购买 
	 */ 
	public Integer getIsNew(){
		return isNew;
	}

	/** 
	 * @param combinationId 拼团id 
	 */ 
	public void setCombinationId(Long combinationId){
		this.combinationId = combinationId;
	}

	/** 
	 * @return 拼团id 
	 */ 
	public Long getCombinationId(){
		return combinationId;
	}

	/** 
	 * @param seckillId 秒杀产品ID 
	 */ 
	public void setSeckillId(Long seckillId){
		this.seckillId = seckillId;
	}

	/** 
	 * @return 秒杀产品ID 
	 */ 
	public Long getSeckillId(){
		return seckillId;
	}

	/** 
	 * @param bargainId 砍价id 
	 */ 
	public void setBargainId(Long bargainId){
		this.bargainId = bargainId;
	}

	/** 
	 * @return 砍价id 
	 */ 
	public Long getBargainId(){
		return bargainId;
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
	 * @param updateTime 更新时间 
	 */ 
	public void setUpdateTime(Integer updateTime){
		this.updateTime = updateTime;
	}

	/** 
	 * @return 更新时间 
	 */ 
	public Integer getUpdateTime(){
		return updateTime;
	}

	/**
	 * <h4>对象转成ShopCart对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,memberId,type,productId,productAttrUnique,cartNum,isPay,isDel,isNew,combinationId,seckillId,bargainId,createTime,updateTime]
	 * </pre>
	 */
	public ShopCart convert(){
		ShopCart shopCart = new ShopCart(); 
		shopCart.setId(id);
		shopCart.setMemberId(memberId);
		shopCart.setType(type);
		shopCart.setProductId(productId);
		shopCart.setProductAttrUnique(productAttrUnique);
		shopCart.setCartNum(cartNum);
		shopCart.setIsPay(isPay);
		shopCart.setIsDel(isDel);
		shopCart.setIsNew(isNew);
		shopCart.setCombinationId(combinationId);
		shopCart.setSeckillId(seckillId);
		shopCart.setBargainId(bargainId);
		shopCart.setCreateTime(createTime);
		shopCart.setUpdateTime(updateTime);
		return shopCart;
	} 
	/**
	 * <h4>ShopCart对象转成ShopCartParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,memberId,type,productId,productAttrUnique,cartNum,isPay,isDel,isNew,combinationId,seckillId,bargainId,createTime,updateTime]
	 * </pre>
	 */
	public ShopCartParam compat(ShopCart shopCart){ 
		if(null == shopCart){
			return new ShopCartParam();
		}
		this.setId(shopCart.getId());
		this.setMemberId(shopCart.getMemberId());
		this.setType(shopCart.getType());
		this.setProductId(shopCart.getProductId());
		this.setProductAttrUnique(shopCart.getProductAttrUnique());
		this.setCartNum(shopCart.getCartNum());
		this.setIsPay(shopCart.getIsPay());
		this.setIsDel(shopCart.getIsDel());
		this.setIsNew(shopCart.getIsNew());
		this.setCombinationId(shopCart.getCombinationId());
		this.setSeckillId(shopCart.getSeckillId());
		this.setBargainId(shopCart.getBargainId());
		this.setCreateTime(shopCart.getCreateTime());
		this.setUpdateTime(shopCart.getUpdateTime());
		return this;
	} 
}
