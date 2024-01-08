package cn.peyton.plum.mall.pojo.product;

import cn.peyton.plum.mall.pojo.party.Member;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <h3> 订单 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public class ShopOrder implements Serializable {
    /**
     * 订单ID
     */
    private Long id;
    /**
     * 订单号
     */
    private String orderNo;
    /**
     * 额外订单号
     */
    private String extendOrderNo;
    /**
     * 用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)
     */
    private Long shareId;
    /**
     * 用户类型 默认: 0 会员、1 顾客 2 供应商、3 用户 4 员工 5 超级管理员
     */
    private Integer shareType;
    /**
     * 备注
     */
    private String explain;
    /**
     * 是否关闭 默认 0 开,1 为关闭, 后端用定时器处理, 关闭后 商品数量返原
     */
    private Integer closed;
    /**
     * 购物车id
     */
    private Long cartId;
    /**
     * 运费金额
     */
    private BigDecimal freightPrice;
    /**
     * 订单商品总数
     */
    private Integer totalNum;
    /**
     * 订单总价
     */
    private BigDecimal totalPrice;
    /**
     * 邮费
     */
    private BigDecimal totalPostage;
    /**
     * 实际支付金额
     */
    private BigDecimal payPrice;
    /**
     * 支付邮费
     */
    private BigDecimal payPostage;
    /**
     * 抵扣金额
     */
    private BigDecimal deductionPrice;
    /**
     * 优惠券id
     */
    private Long couponId;
    /**
     * 优惠券金额
     */
    private BigDecimal couponPrice;
    /**
     * 支付状态,默认0 未支付 1已支付
     */
    private Integer paid;
    /**
     * 支付时间
     */
    private Integer payTime;
    /**
     * 支付类型: 默认：bank {bank=银行卡 alipay=支付宝 wx=微信 cash=现金}
     */
    private String payType;
    /**
     * 创建时间
     */
    private Integer createTime;
    /**
     * 更新时间
     */
    private Integer updateTime;
    /**
     * 订单状态（-1 : 申请退款 -2 : 退货成功 0：待发货；1：待收货；2：已收货；3：已完成；-1：已退款）
     */
    private Integer status;
    /**
     * 0 未退款 1 申请中 2 已退款
     */
    private Integer refundStatus;
    /**
     * 退款Id
     */
    private Long refundId;
    /**
     * 消费赚取积分
     */
    private Integer gainIntegral;
    /**
     * 使用积分
     */
    private Integer useIntegral;
    /**
     * 实际支付积分
     */
    private Integer payIntegral;
    /**
     * 给用户退了多少积分
     */
    private Integer backIntegral;
    /**
     * 是否删除,默认: 1 可用;0 已删除
     */
    private Integer isDel;
    /**
     * 管理员备注
     */
    private String adminRemark;
    /**
     * 拼团Id, 默认 0 不是拼团
     */
    private Long pinkId;
    /**
     * 秒杀产品Id, 默认 0 不是秒杀产品
     */
    private Long seckillId;
    /**
     * 砍价Id, 默认 0 不是砍价产品
     */
    private Long bargainId;
    /**
     * 核销码
     */
    private String verifyCode;
    /**
     * 门店id
     */
    private Long shopId;
    /**
     * 配送方式 1=快递 ，2=门店自提
     */
    private Integer shippingType;
    /**
     * 订单快递数据json格式:{company:"快递公司",no:"NO12345",time:"",name:"",phone:"",address:""}
     */
    private String shipData;
    /**
     * 订单快递状态
     */
    private String shipStatus;
    /** 退款对象 */
    private ShopOrderRefund orderRefund;

    /**
     * 订单项的集合
     */
    private List<ShopOrderItem> items;
    /** 买家对象 */
    private Member member;

    //================================== Constructor =======================================//
    public ShopOrder() {
        if (null == member) {member = new Member();}
        if(null== items){ items = new ArrayList<>(); }
        if(null== orderRefund){ orderRefund = new ShopOrderRefund(); }
    }
    //================================== Method =======================================//


    //================================== PREFIX_GET AND PREFIX_SET =======================================//

    /**
     * @param id 订单ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return 订单ID
     */
    public Long getId() {
        return id;
    }

    /**
     * @param orderNo 订单号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * @return 订单号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * @param extendOrderNo 额外订单号
     */
    public void setExtendOrderNo(String extendOrderNo) {
        this.extendOrderNo = extendOrderNo;
    }

    /**
     * @return 额外订单号
     */
    public String getExtendOrderNo() {
        return extendOrderNo;
    }

    /**
     * @param shareId 用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)
     */
    public void setShareId(Long shareId) {
        this.shareId = shareId;
    }

    /**
     * @return 用户ID(包含 : 会员Id 、 供应商Id 、 员工Id等, 配合share_type一起使用)
     */
    public Long getShareId() {
        return shareId;
    }

    /**
     * @param shareType 用户类型 默认: 0 会员、1 顾客 2 供应商、3 用户 4 员工 5 超级管理员
     */
    public void setShareType(Integer shareType) {
        this.shareType = shareType;
    }

    /**
     * @return 用户类型 默认: 0 会员、1 顾客 2 供应商、3 用户 4 员工 5 超级管理员
     */
    public Integer getShareType() {
        return shareType;
    }

    /**
     * @param explain 备注
     */
    public void setExplain(String explain) {
        this.explain = explain;
    }

    /**
     * @return 备注
     */
    public String getExplain() {
        return explain;
    }

    /**
     * @param closed 是否关闭 默认 0 开,1 为关闭, 后端用定时器处理, 关闭后 商品数量返原
     */
    public void setClosed(Integer closed) {
        this.closed = closed;
    }

    /**
     * @return 是否关闭 默认 0 开,1 为关闭, 后端用定时器处理, 关闭后 商品数量返原
     */
    public Integer getClosed() {
        return closed;
    }

    /**
     * @param cartId 购物车id
     */
    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    /**
     * @return 购物车id
     */
    public Long getCartId() {
        return cartId;
    }

    /**
     * @param freightPrice 运费金额
     */
    public void setFreightPrice(BigDecimal freightPrice) {
        this.freightPrice = freightPrice;
    }

    /**
     * @return 运费金额
     */
    public BigDecimal getFreightPrice() {
        return freightPrice;
    }

    /**
     * @param totalNum 订单商品总数
     */
    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    /**
     * @return 订单商品总数
     */
    public Integer getTotalNum() {
        return totalNum;
    }

    /**
     * @param totalPrice 订单总价
     */
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * @return 订单总价
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    /**
     * @param totalPostage 邮费
     */
    public void setTotalPostage(BigDecimal totalPostage) {
        this.totalPostage = totalPostage;
    }

    /**
     * @return 邮费
     */
    public BigDecimal getTotalPostage() {
        return totalPostage;
    }

    /**
     * @param payPrice 实际支付金额
     */
    public void setPayPrice(BigDecimal payPrice) {
        this.payPrice = payPrice;
    }

    /**
     * @return 实际支付金额
     */
    public BigDecimal getPayPrice() {
        return payPrice;
    }

    /**
     * @param payPostage 支付邮费
     */
    public void setPayPostage(BigDecimal payPostage) {
        this.payPostage = payPostage;
    }

    /**
     * @return 支付邮费
     */
    public BigDecimal getPayPostage() {
        return payPostage;
    }

    /**
     * @param deductionPrice 抵扣金额
     */
    public void setDeductionPrice(BigDecimal deductionPrice) {
        this.deductionPrice = deductionPrice;
    }

    /**
     * @return 抵扣金额
     */
    public BigDecimal getDeductionPrice() {
        return deductionPrice;
    }

    /**
     * @param couponId 优惠券id
     */
    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    /**
     * @return 优惠券id
     */
    public Long getCouponId() {
        return couponId;
    }

    /**
     * @param couponPrice 优惠券金额
     */
    public void setCouponPrice(BigDecimal couponPrice) {
        this.couponPrice = couponPrice;
    }

    /**
     * @return 优惠券金额
     */
    public BigDecimal getCouponPrice() {
        return couponPrice;
    }

    /**
     * @param paid 支付状态,默认0 未支付 1已支付
     */
    public void setPaid(Integer paid) {
        this.paid = paid;
    }

    /**
     * @return 支付状态, 默认0 未支付 1已支付
     */
    public Integer getPaid() {
        return paid;
    }

    /**
     * @param payTime 支付时间
     */
    public void setPayTime(Integer payTime) {
        this.payTime = payTime;
    }

    /**
     * @return 支付时间
     */
    public Integer getPayTime() {
        return payTime;
    }

    /**
     * @param payType 支付类型: 默认：bank {bank=银行卡 alipay=支付宝 wx=微信 cash=现金}
     */
    public void setPayType(String payType) {
        this.payType = payType;
    }

    /**
     * @return 支付类型: 默认：bank {bank=银行卡 alipay=支付宝 wx=微信 cash=现金}
     */
    public String getPayType() {
        return payType;
    }

    /**
     * @param createTime 创建时间
     */
    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    /**
     * @return 创建时间
     */
    public Integer getCreateTime() {
        return createTime;
    }

    /**
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return 更新时间
     */
    public Integer getUpdateTime() {
        return updateTime;
    }

    /**
     * @param status 订单状态（-1 : 申请退款 -2 : 退货成功 0：待发货；1：待收货；2：已收货；3：已完成；-1：已退款）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return 订单状态（-1 : 申请退款 -2 : 退货成功 0：待发货；1：待收货；2：已收货；3：已完成；-1：已退款）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param refundStatus 0 未退款 1 已申请,等待审核 2 退款中 3 退款成功 4 退款失败
     */
    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }

    /**
     * @return 0 未退款 1 已申请,等待审核 2 退款中 3 退款成功 4 退款失败
     */
    public Integer getRefundStatus() {
        return refundStatus;
    }

    /**
     * @param refundId 退款Id
     */
    public void setRefundId(Long refundId) {
        this.refundId = refundId;
    }

    /**
     * @return 退款Id
     */
    public Long getRefundId() {
        return refundId;
    }

    /**
     * @param gainIntegral 消费赚取积分
     */
    public void setGainIntegral(Integer gainIntegral) {
        this.gainIntegral = gainIntegral;
    }

    /**
     * @return 消费赚取积分
     */
    public Integer getGainIntegral() {
        return gainIntegral;
    }

    /**
     * @param useIntegral 使用积分
     */
    public void setUseIntegral(Integer useIntegral) {
        this.useIntegral = useIntegral;
    }

    /**
     * @return 使用积分
     */
    public Integer getUseIntegral() {
        return useIntegral;
    }

    /**
     * @param payIntegral 实际支付积分
     */
    public void setPayIntegral(Integer payIntegral) {
        this.payIntegral = payIntegral;
    }

    /**
     * @return 实际支付积分
     */
    public Integer getPayIntegral() {
        return payIntegral;
    }

    /**
     * @param backIntegral 给用户退了多少积分
     */
    public void setBackIntegral(Integer backIntegral) {
        this.backIntegral = backIntegral;
    }

    /**
     * @return 给用户退了多少积分
     */
    public Integer getBackIntegral() {
        return backIntegral;
    }

    /**
     * @param isDel 是否删除,默认: 1 可用;0 已删除
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    /**
     * @return 是否删除, 默认: 1 可用;0 已删除
     */
    public Integer getIsDel() {
        return isDel;
    }

    /**
     * @param adminRemark 管理员备注
     */
    public void setAdminRemark(String adminRemark) {
        this.adminRemark = adminRemark;
    }

    /**
     * @return 管理员备注
     */
    public String getAdminRemark() {
        return adminRemark;
    }

    /**
     * @param pinkId 拼团Id, 默认 0 不是拼团
     */
    public void setPinkId(Long pinkId) {
        this.pinkId = pinkId;
    }

    /**
     * @return 拼团Id, 默认 0 不是拼团
     */
    public Long getPinkId() {
        return pinkId;
    }

    /**
     * @param seckillId 秒杀产品Id, 默认 0 不是秒杀产品
     */
    public void setSeckillId(Long seckillId) {
        this.seckillId = seckillId;
    }

    /**
     * @return 秒杀产品Id, 默认 0 不是秒杀产品
     */
    public Long getSeckillId() {
        return seckillId;
    }

    /**
     * @param bargainId 砍价Id, 默认 0 不是砍价产品
     */
    public void setBargainId(Long bargainId) {
        this.bargainId = bargainId;
    }

    /**
     * @return 砍价Id, 默认 0 不是砍价产品
     */
    public Long getBargainId() {
        return bargainId;
    }

    /**
     * @param verifyCode 核销码
     */
    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    /**
     * @return 核销码
     */
    public String getVerifyCode() {
        return verifyCode;
    }

    /**
     * @param shopId 门店id
     */
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    /**
     * @return 门店id
     */
    public Long getShopId() {
        return shopId;
    }

    /**
     * @param shippingType 配送方式 1=快递 ，2=门店自提
     */
    public void setShippingType(Integer shippingType) {
        this.shippingType = shippingType;
    }

    /**
     * @return 配送方式 1=快递 ，2=门店自提
     */
    public Integer getShippingType() {
        return shippingType;
    }

    /**
     * @param shipData 订单快递数据json格式:{company:"快递公司",no:"NO12345",time:"",name:"",phone:"",address:""}
     */
    public void setShipData(String shipData) {
        this.shipData = shipData;
    }

    /**
     * @return 订单快递数据json格式:{company:"快递公司",no:"NO12345",time:"",name:"",phone:"",address:""}
     */
    public String getShipData() {
        return shipData;
    }

    /**
     * @param shipStatus 订单快递状态
     */
    public void setShipStatus(String shipStatus) {
        this.shipStatus = shipStatus;
    }

    /**
     * @return 订单快递状态
     */
    public String getShipStatus() {
        return shipStatus;
    }

    /**
     * @return 订单项的集合
     */
    public List<ShopOrderItem> getItems() {
        return items;
    }

    /**
     * @param items 订单项的集合
     */
    public void setItems(List<ShopOrderItem> items) {
        this.items = items;
    }


    /**
     * @return 买家对象
     */
    public Member getMember() {
        return member;
    }

    /**
     * @param member 买家对象
     */
    public void setMember(Member member) {
        this.member = member;
    }

    /**
     * @return 退款对象
     */
    public ShopOrderRefund getOrderRefund() {
        return orderRefund;
    }

    /**
     * @param orderRefund 退款对象
     */
    public void setOrderRefund(ShopOrderRefund orderRefund) {
        this.orderRefund = orderRefund;
    }


}
