package cn.peyton.plum.mall.pojo;

import java.math.BigDecimal;

import java.io.Serializable;

/**
 * <h3> 订单--项 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public class ShopOrderItem implements Serializable {
    /**
     *
     */
    private Long id;
    /**
     * 订单id
     */
    private Long oId;
    /**
     * 订单号
     */
    private String orderNo;
    /**
     * 购物车id
     */
    private Long cartId;
    /**
     * 商品规格详细Id(shop_product_detail)
     */
    private Long psdId;
    /**
     * 数量
     */
    private Integer num;
    /**
     * 单价
     */
    private BigDecimal price;
    /**
     * 是否能售后, 默认 1 {0不能 1 能}
     */
    private Integer isAfterSales;
    /**
     * 是否显示, 默认: 1 显示, 0 不显示
     */
    private Integer isShow;

    //================================== Constructor =======================================//

    //================================== Method =======================================//


    //================================== PREFIX_GET AND PREFIX_SET =======================================//

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * @param oId 订单id
     */
    public void setOId(Long oId) {
        this.oId = oId;
    }

    /**
     * @return 订单id
     */
    public Long getOId() {
        return oId;
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
     * @param psdId 商品规格详细Id(shop_product_detail)
     */
    public void setPsdId(Long psdId) {
        this.psdId = psdId;
    }

    /**
     * @return 商品规格详细Id(shop_product_detail)
     */
    public Long getPsdId() {
        return psdId;
    }

    /**
     * @param num 数量
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * @return 数量
     */
    public Integer getNum() {
        return num;
    }

    /**
     * @param price 单价
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * @return 单价
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param isAfterSales 是否能售后, 默认 1 {0不能 1 能}
     */
    public void setIsAfterSales(Integer isAfterSales) {
        this.isAfterSales = isAfterSales;
    }

    /**
     * @return 是否能售后, 默认 1 {0不能 1 能}
     */
    public Integer getIsAfterSales() {
        return isAfterSales;
    }

    /**
     * @param isShow 是否显示, 默认: 1 显示, 0 不显示
     */
    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    /**
     * @return 是否显示, 默认: 1 显示, 0 不显示
     */
    public Integer getIsShow() {
        return isShow;
    }

}
