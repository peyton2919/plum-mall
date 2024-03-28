package cn.peyton.plum.mall.vo;

import cn.peyton.plum.mall.param.product.ShopOrderItemParam;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <h4>订单 Vo类</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.mall.vo.
 * @date 2024年02月28日 22:13
 * @version 1.0.0
 * </pre>
 */
public class OrderVo implements Serializable {
    /** 订单Id */
    private Long id;
    /** 订单号 */
    private String orderNo;
    /** 会员Id */
    private Long memberId;
    /** 会员地址Id */
    private Long userAddrId;
    /** 购物车Id */
    private Long cartId;
    /** 订单总数量  */
    private int totalNum;
    /** 订单总金额 */
    private BigDecimal totalPrice;
    /** 运费 */
    private BigDecimal freightPrice;
    /** 实付金额 */
    private BigDecimal payPrice;
    /** 抵扣金额 */
    private BigDecimal deductionPrice;
    /** 优惠券Id */
    private Long couponId;
    /** 优惠金额 */
    private BigDecimal couponPrice;
    /** 备注说明 */
    private String explain;
    /** 订单项 集合 转 字符串 */
    private String list;
    private List<ShopOrderItemParam> items;

    public OrderVo() {
        if (null == items) {
            items = new ArrayList<>();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getUserAddrId() {
        return userAddrId;
    }

    public void setUserAddrId(Long userAddrId) {
        this.userAddrId = userAddrId;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getFreightPrice() {
        return freightPrice;
    }

    public void setFreightPrice(BigDecimal freightPrice) {
        this.freightPrice = freightPrice;
    }

    public BigDecimal getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(BigDecimal payPrice) {
        this.payPrice = payPrice;
    }

    public BigDecimal getDeductionPrice() {
        return deductionPrice;
    }

    public void setDeductionPrice(BigDecimal deductionPrice) {
        this.deductionPrice = deductionPrice;
    }

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public BigDecimal getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(BigDecimal couponPrice) {
        this.couponPrice = couponPrice;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }

    public List<ShopOrderItemParam> getItems() {
        return items;
    }

    public void setItems(List<ShopOrderItemParam> items) {
        this.items = items;
    }
}
