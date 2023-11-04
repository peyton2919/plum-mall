package cn.peyton.plum.mall.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * <h3> 订单 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
public class ShopOrder implements Serializable {
	/** 订单ID  */
	private Long id;
	/** 订单号  */
	private String orderId;
	/** 额外订单号  */
	private String extendOrderId;
	/** 会员id  */
	private Long memberId;
	/** 会员姓名  */
	private String memberRealName;
	/** 会员电话  */
	private String memberPhone;
	/** 详细地址  */
	private String memberAddress;
	/** 购物车id  */
	private String cartId;
	/** 运费金额  */
	private BigDecimal freightPrice;
	/** 订单商品总数  */
	private Integer totalNum;
	/** 订单总价  */
	private BigDecimal totalPrice;
	/** 邮费  */
	private BigDecimal totalPostage;
	/** 实际支付金额  */
	private BigDecimal payPrice;
	/** 支付邮费  */
	private BigDecimal payPostage;
	/** 抵扣金额  */
	private BigDecimal deductionPrice;
	/** 优惠券id  */
	private Integer couponId;
	/** 优惠券金额  */
	private BigDecimal couponPrice;
	/** 支付状态,默认0 未支付 1已支付  */
	private Integer paid;
	/** 支付时间  */
	private Integer payTime;
	/** 支付类型: 默认：bank {bank=银行卡 alipay=支付宝 wx=微信 cash=现金}  */
	private String payType;
	/** 创建时间  */
	private Integer createTime;
	/** 更新时间  */
	private Integer updateTime;
	/** 订单状态（-1 : 申请退款 -2 : 退货成功 0：待发货；1：待收货；2：已收货；3：已完成；-1：已退款）  */
	private Integer status;
	/** 0 未退款 1 申请中 2 已退款  */
	private Integer refundStatus;
	/** 退款图片  */
	private String refundReasonWapImg;
	/** 退款用户说明  */
	private String refundReasonWapExplain;
	/** 退款时间  */
	private Integer refundReasonTime;
	/** 前台退款原因  */
	private String refundReasonWap;
	/** 不退款的理由  */
	private String refundReason;
	/** 退款金额  */
	private BigDecimal refundPrice;
	/** 快递公司编号  */
	private String deliverySn;
	/** 快递名称/送货人姓名  */
	private String deliveryName;
	/** 发货类型  */
	private String deliveryType;
	/** 快递单号/手机号  */
	private String deliveryId;
	/** 消费赚取积分  */
	private Integer gainIntegral;
	/** 使用积分  */
	private Integer useIntegral;
	/** 实际支付积分  */
	private Integer payIntegral;
	/** 给用户退了多少积分  */
	private Integer backIntegral;
	/** 备注  */
	private String mark;
	/** 是否删除,默认0（0：可用;1已删除）  */
	private Integer isDel;
	/** 唯一id(md5加密)类似id  */
	private String uniqueCdoe;
	/** 管理员备注  */
	private String remark;
	/** 拼团产品ID, 默认0 不是拼团产品  */
	private Long combinationId;
	/** 拼团ID, 默认0 不是拼团  */
	private Long pinkId;
	/** 成本价  */
	private BigDecimal cost;
	/** 秒杀产品ID, 默认 0 不是秒杀产品  */
	private Long seckillId;
	/** 砍价ID, 默认 0 不是砍价产品  */
	private Long bargainId;
	/** 核销码  */
	private String verifyCode;
	/** 门店id  */
	private Long shopId;
	/** 配送方式 1=快递 ，2=门店自提  */
	private Integer shippingType;

	//================================== Constructor =======================================//

	//================================== Method =======================================//


	//================================== PREFIX_GET AND PREFIX_SET =======================================//

	/** 
	 * @param id 订单ID 
	 */ 
	public void setId(Long id){
		this.id = id;
	}

	/** 
	 * @return 订单ID 
	 */ 
	public Long getId(){
		return id;
	}

	/** 
	 * @param orderId 订单号 
	 */ 
	public void setOrderId(String orderId){
		this.orderId = orderId;
	}

	/** 
	 * @return 订单号 
	 */ 
	public String getOrderId(){
		return orderId;
	}

	/** 
	 * @param extendOrderId 额外订单号 
	 */ 
	public void setExtendOrderId(String extendOrderId){
		this.extendOrderId = extendOrderId;
	}

	/** 
	 * @return 额外订单号 
	 */ 
	public String getExtendOrderId(){
		return extendOrderId;
	}

	/** 
	 * @param memberId 会员id 
	 */ 
	public void setMemberId(Long memberId){
		this.memberId = memberId;
	}

	/** 
	 * @return 会员id 
	 */ 
	public Long getMemberId(){
		return memberId;
	}

	/** 
	 * @param memberRealName 会员姓名 
	 */ 
	public void setMemberRealName(String memberRealName){
		this.memberRealName = memberRealName;
	}

	/** 
	 * @return 会员姓名 
	 */ 
	public String getMemberRealName(){
		return memberRealName;
	}

	/** 
	 * @param memberPhone 会员电话 
	 */ 
	public void setMemberPhone(String memberPhone){
		this.memberPhone = memberPhone;
	}

	/** 
	 * @return 会员电话 
	 */ 
	public String getMemberPhone(){
		return memberPhone;
	}

	/** 
	 * @param memberAddress 详细地址 
	 */ 
	public void setMemberAddress(String memberAddress){
		this.memberAddress = memberAddress;
	}

	/** 
	 * @return 详细地址 
	 */ 
	public String getMemberAddress(){
		return memberAddress;
	}

	/** 
	 * @param cartId 购物车id 
	 */ 
	public void setCartId(String cartId){
		this.cartId = cartId;
	}

	/** 
	 * @return 购物车id 
	 */ 
	public String getCartId(){
		return cartId;
	}

	/** 
	 * @param freightPrice 运费金额 
	 */ 
	public void setFreightPrice(BigDecimal freightPrice){
		this.freightPrice = freightPrice;
	}

	/** 
	 * @return 运费金额 
	 */ 
	public BigDecimal getFreightPrice(){
		return freightPrice;
	}

	/** 
	 * @param totalNum 订单商品总数 
	 */ 
	public void setTotalNum(Integer totalNum){
		this.totalNum = totalNum;
	}

	/** 
	 * @return 订单商品总数 
	 */ 
	public Integer getTotalNum(){
		return totalNum;
	}

	/** 
	 * @param totalPrice 订单总价 
	 */ 
	public void setTotalPrice(BigDecimal totalPrice){
		this.totalPrice = totalPrice;
	}

	/** 
	 * @return 订单总价 
	 */ 
	public BigDecimal getTotalPrice(){
		return totalPrice;
	}

	/** 
	 * @param totalPostage 邮费 
	 */ 
	public void setTotalPostage(BigDecimal totalPostage){
		this.totalPostage = totalPostage;
	}

	/** 
	 * @return 邮费 
	 */ 
	public BigDecimal getTotalPostage(){
		return totalPostage;
	}

	/** 
	 * @param payPrice 实际支付金额 
	 */ 
	public void setPayPrice(BigDecimal payPrice){
		this.payPrice = payPrice;
	}

	/** 
	 * @return 实际支付金额 
	 */ 
	public BigDecimal getPayPrice(){
		return payPrice;
	}

	/** 
	 * @param payPostage 支付邮费 
	 */ 
	public void setPayPostage(BigDecimal payPostage){
		this.payPostage = payPostage;
	}

	/** 
	 * @return 支付邮费 
	 */ 
	public BigDecimal getPayPostage(){
		return payPostage;
	}

	/** 
	 * @param deductionPrice 抵扣金额 
	 */ 
	public void setDeductionPrice(BigDecimal deductionPrice){
		this.deductionPrice = deductionPrice;
	}

	/** 
	 * @return 抵扣金额 
	 */ 
	public BigDecimal getDeductionPrice(){
		return deductionPrice;
	}

	/** 
	 * @param couponId 优惠券id 
	 */ 
	public void setCouponId(Integer couponId){
		this.couponId = couponId;
	}

	/** 
	 * @return 优惠券id 
	 */ 
	public Integer getCouponId(){
		return couponId;
	}

	/** 
	 * @param couponPrice 优惠券金额 
	 */ 
	public void setCouponPrice(BigDecimal couponPrice){
		this.couponPrice = couponPrice;
	}

	/** 
	 * @return 优惠券金额 
	 */ 
	public BigDecimal getCouponPrice(){
		return couponPrice;
	}

	/** 
	 * @param paid 支付状态,默认0 未支付 1已支付 
	 */ 
	public void setPaid(Integer paid){
		this.paid = paid;
	}

	/** 
	 * @return 支付状态,默认0 未支付 1已支付 
	 */ 
	public Integer getPaid(){
		return paid;
	}

	/** 
	 * @param payTime 支付时间 
	 */ 
	public void setPayTime(Integer payTime){
		this.payTime = payTime;
	}

	/** 
	 * @return 支付时间 
	 */ 
	public Integer getPayTime(){
		return payTime;
	}

	/** 
	 * @param payType 支付类型: 默认：bank {bank=银行卡 alipay=支付宝 wx=微信 cash=现金} 
	 */ 
	public void setPayType(String payType){
		this.payType = payType;
	}

	/** 
	 * @return 支付类型: 默认：bank {bank=银行卡 alipay=支付宝 wx=微信 cash=现金} 
	 */ 
	public String getPayType(){
		return payType;
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
	 * @param status 订单状态（-1 : 申请退款 -2 : 退货成功 0：待发货；1：待收货；2：已收货；3：已完成；-1：已退款） 
	 */ 
	public void setStatus(Integer status){
		this.status = status;
	}

	/** 
	 * @return 订单状态（-1 : 申请退款 -2 : 退货成功 0：待发货；1：待收货；2：已收货；3：已完成；-1：已退款） 
	 */ 
	public Integer getStatus(){
		return status;
	}

	/** 
	 * @param refundStatus 0 未退款 1 申请中 2 已退款 
	 */ 
	public void setRefundStatus(Integer refundStatus){
		this.refundStatus = refundStatus;
	}

	/** 
	 * @return 0 未退款 1 申请中 2 已退款 
	 */ 
	public Integer getRefundStatus(){
		return refundStatus;
	}

	/** 
	 * @param refundReasonWapImg 退款图片 
	 */ 
	public void setRefundReasonWapImg(String refundReasonWapImg){
		this.refundReasonWapImg = refundReasonWapImg;
	}

	/** 
	 * @return 退款图片 
	 */ 
	public String getRefundReasonWapImg(){
		return refundReasonWapImg;
	}

	/** 
	 * @param refundReasonWapExplain 退款用户说明 
	 */ 
	public void setRefundReasonWapExplain(String refundReasonWapExplain){
		this.refundReasonWapExplain = refundReasonWapExplain;
	}

	/** 
	 * @return 退款用户说明 
	 */ 
	public String getRefundReasonWapExplain(){
		return refundReasonWapExplain;
	}

	/** 
	 * @param refundReasonTime 退款时间 
	 */ 
	public void setRefundReasonTime(Integer refundReasonTime){
		this.refundReasonTime = refundReasonTime;
	}

	/** 
	 * @return 退款时间 
	 */ 
	public Integer getRefundReasonTime(){
		return refundReasonTime;
	}

	/** 
	 * @param refundReasonWap 前台退款原因 
	 */ 
	public void setRefundReasonWap(String refundReasonWap){
		this.refundReasonWap = refundReasonWap;
	}

	/** 
	 * @return 前台退款原因 
	 */ 
	public String getRefundReasonWap(){
		return refundReasonWap;
	}

	/** 
	 * @param refundReason 不退款的理由 
	 */ 
	public void setRefundReason(String refundReason){
		this.refundReason = refundReason;
	}

	/** 
	 * @return 不退款的理由 
	 */ 
	public String getRefundReason(){
		return refundReason;
	}

	/** 
	 * @param refundPrice 退款金额 
	 */ 
	public void setRefundPrice(BigDecimal refundPrice){
		this.refundPrice = refundPrice;
	}

	/** 
	 * @return 退款金额 
	 */ 
	public BigDecimal getRefundPrice(){
		return refundPrice;
	}

	/** 
	 * @param deliverySn 快递公司编号 
	 */ 
	public void setDeliverySn(String deliverySn){
		this.deliverySn = deliverySn;
	}

	/** 
	 * @return 快递公司编号 
	 */ 
	public String getDeliverySn(){
		return deliverySn;
	}

	/** 
	 * @param deliveryName 快递名称/送货人姓名 
	 */ 
	public void setDeliveryName(String deliveryName){
		this.deliveryName = deliveryName;
	}

	/** 
	 * @return 快递名称/送货人姓名 
	 */ 
	public String getDeliveryName(){
		return deliveryName;
	}

	/** 
	 * @param deliveryType 发货类型 
	 */ 
	public void setDeliveryType(String deliveryType){
		this.deliveryType = deliveryType;
	}

	/** 
	 * @return 发货类型 
	 */ 
	public String getDeliveryType(){
		return deliveryType;
	}

	/** 
	 * @param deliveryId 快递单号/手机号 
	 */ 
	public void setDeliveryId(String deliveryId){
		this.deliveryId = deliveryId;
	}

	/** 
	 * @return 快递单号/手机号 
	 */ 
	public String getDeliveryId(){
		return deliveryId;
	}

	/** 
	 * @param gainIntegral 消费赚取积分 
	 */ 
	public void setGainIntegral(Integer gainIntegral){
		this.gainIntegral = gainIntegral;
	}

	/** 
	 * @return 消费赚取积分 
	 */ 
	public Integer getGainIntegral(){
		return gainIntegral;
	}

	/** 
	 * @param useIntegral 使用积分 
	 */ 
	public void setUseIntegral(Integer useIntegral){
		this.useIntegral = useIntegral;
	}

	/** 
	 * @return 使用积分 
	 */ 
	public Integer getUseIntegral(){
		return useIntegral;
	}

	/** 
	 * @param payIntegral 实际支付积分 
	 */ 
	public void setPayIntegral(Integer payIntegral){
		this.payIntegral = payIntegral;
	}

	/** 
	 * @return 实际支付积分 
	 */ 
	public Integer getPayIntegral(){
		return payIntegral;
	}

	/** 
	 * @param backIntegral 给用户退了多少积分 
	 */ 
	public void setBackIntegral(Integer backIntegral){
		this.backIntegral = backIntegral;
	}

	/** 
	 * @return 给用户退了多少积分 
	 */ 
	public Integer getBackIntegral(){
		return backIntegral;
	}

	/** 
	 * @param mark 备注 
	 */ 
	public void setMark(String mark){
		this.mark = mark;
	}

	/** 
	 * @return 备注 
	 */ 
	public String getMark(){
		return mark;
	}

	/** 
	 * @param isDel 是否删除,默认0（0：可用;1已删除） 
	 */ 
	public void setIsDel(Integer isDel){
		this.isDel = isDel;
	}

	/** 
	 * @return 是否删除,默认0（0：可用;1已删除） 
	 */ 
	public Integer getIsDel(){
		return isDel;
	}

	/** 
	 * @param uniqueCdoe 唯一id(md5加密)类似id 
	 */ 
	public void setUniqueCdoe(String uniqueCdoe){
		this.uniqueCdoe = uniqueCdoe;
	}

	/** 
	 * @return 唯一id(md5加密)类似id 
	 */ 
	public String getUniqueCdoe(){
		return uniqueCdoe;
	}

	/** 
	 * @param remark 管理员备注 
	 */ 
	public void setRemark(String remark){
		this.remark = remark;
	}

	/** 
	 * @return 管理员备注 
	 */ 
	public String getRemark(){
		return remark;
	}

	/** 
	 * @param combinationId 拼团产品ID, 默认0 不是拼团产品 
	 */ 
	public void setCombinationId(Long combinationId){
		this.combinationId = combinationId;
	}

	/** 
	 * @return 拼团产品ID, 默认0 不是拼团产品 
	 */ 
	public Long getCombinationId(){
		return combinationId;
	}

	/** 
	 * @param pinkId 拼团ID, 默认0 不是拼团 
	 */ 
	public void setPinkId(Long pinkId){
		this.pinkId = pinkId;
	}

	/** 
	 * @return 拼团ID, 默认0 不是拼团 
	 */ 
	public Long getPinkId(){
		return pinkId;
	}

	/** 
	 * @param cost 成本价 
	 */ 
	public void setCost(BigDecimal cost){
		this.cost = cost;
	}

	/** 
	 * @return 成本价 
	 */ 
	public BigDecimal getCost(){
		return cost;
	}

	/** 
	 * @param seckillId 秒杀产品ID, 默认 0 不是秒杀产品 
	 */ 
	public void setSeckillId(Long seckillId){
		this.seckillId = seckillId;
	}

	/** 
	 * @return 秒杀产品ID, 默认 0 不是秒杀产品 
	 */ 
	public Long getSeckillId(){
		return seckillId;
	}

	/** 
	 * @param bargainId 砍价ID, 默认 0 不是砍价产品 
	 */ 
	public void setBargainId(Long bargainId){
		this.bargainId = bargainId;
	}

	/** 
	 * @return 砍价ID, 默认 0 不是砍价产品 
	 */ 
	public Long getBargainId(){
		return bargainId;
	}

	/** 
	 * @param verifyCode 核销码 
	 */ 
	public void setVerifyCode(String verifyCode){
		this.verifyCode = verifyCode;
	}

	/** 
	 * @return 核销码 
	 */ 
	public String getVerifyCode(){
		return verifyCode;
	}

	/** 
	 * @param shopId 门店id 
	 */ 
	public void setShopId(Long shopId){
		this.shopId = shopId;
	}

	/** 
	 * @return 门店id 
	 */ 
	public Long getShopId(){
		return shopId;
	}

	/** 
	 * @param shippingType 配送方式 1=快递 ，2=门店自提 
	 */ 
	public void setShippingType(Integer shippingType){
		this.shippingType = shippingType;
	}

	/** 
	 * @return 配送方式 1=快递 ，2=门店自提 
	 */ 
	public Integer getShippingType(){
		return shippingType;
	}

}
