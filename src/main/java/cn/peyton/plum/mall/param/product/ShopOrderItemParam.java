package cn.peyton.plum.mall.param.product;

import cn.peyton.plum.core.utils.DateUtils;
import cn.peyton.plum.mall.bo.ShopProductBo;
import cn.peyton.plum.mall.bo.ShopProductSkuDetailBo;
import cn.peyton.plum.mall.pojo.product.ShopOrderItem;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <h3> 订单--项 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:24
 * @version 1.0.0
 * </pre>
 */
public class ShopOrderItemParam implements Serializable {
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
     * 商品规格详细Id(shop_product_detail)
     */
    private Long psdId;

    /** 商品Id */
    private Long productId;

    /** 规格 0单 1多 */
    private Integer specType;
    /**
     * 数量
     */
    private Integer num;
    /** 退回数量 */
    private Integer refundNum;
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
    /** 创建时间 */
    private String createTime;

    /** 商品规格详细对象 */
    private ShopProductSkuDetailParam productSkuDetail;
    /** 商品对象 */
    private ShopProductParam product;

    //================================== Constructor =======================================//
    public ShopOrderItemParam() {
        if (null == product) {product = new ShopProductParam();}
        if (null == productSkuDetail) { productSkuDetail = new ShopProductSkuDetailParam(); }
    }
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
     * @return 商品Id
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * @param productId 商品Id
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * @return 规格 0单 1多
     */
    public Integer getSpecType() {
        return specType;
    }

    /**
     * @param specType 规格 0单 1多
     */
    public void setSpecType(Integer specType) {
        this.specType = specType;
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
     * @return 退回数量
     */
    public Integer getRefundNum() {
        return refundNum;
    }

    /**
     * @param refundNum 退回数量
     */
    public void setRefundNum(Integer refundNum) {
        this.refundNum = refundNum;
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
    /**
     * @return 创建时间
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime 创建时间
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * @return 商品规格详细对象
     */
    public ShopProductSkuDetailParam getProductSkuDetail() {
        return productSkuDetail;
    }

    /**
     * @param productSkuDetail 商品规格详细对象
     */
    public void setProductSkuDetail(ShopProductSkuDetailParam productSkuDetail) {
        this.productSkuDetail = productSkuDetail;
    }
    /**
     * @return 商品对象
     */
    public ShopProductParam getProduct() {
        return product;
    }

    /**
     * @param product 商品对象
     */
    public void setProduct(ShopProductParam product) {
        this.product = product;
    }

    /**
     * <h4>对象转成ShopOrderItem对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,oId,orderNo,cartId,psdId,num,price,isAfterSales,isShow]
     * </pre>
     */
    public ShopOrderItem convert() {
        ShopOrderItem shopOrderItem = new ShopOrderItem();
        shopOrderItem.setId(id);
        shopOrderItem.setOId(oId);
        shopOrderItem.setOrderNo(orderNo);
        shopOrderItem.setPsdId(psdId);
        shopOrderItem.setProductId(productId);
        shopOrderItem.setSpecType(specType);
        shopOrderItem.setNum(num);
        shopOrderItem.setRefundNum(refundNum);
        shopOrderItem.setPrice(price);
        shopOrderItem.setIsAfterSales(isAfterSales);
        shopOrderItem.setIsShow(isShow);
        shopOrderItem.setCreateTime(DateUtils.dateToTimestamp(createTime));
        shopOrderItem.setProductSkuDetail(productSkuDetail.convert());
        shopOrderItem.setProduct(product.convert());
        return shopOrderItem;
    }

    /**
     * <h4>ShopOrderItem对象转成ShopOrderItemParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,oId,orderNo,cartId,psdId,num,price,isAfterSales,isShow]
     * </pre>
     */
    public ShopOrderItemParam compat(ShopOrderItem shopOrderItem) {
        if (null == shopOrderItem) {
            return new ShopOrderItemParam();
        }
        this.setId(shopOrderItem.getId());
        this.setOId(shopOrderItem.getOId());
        this.setOrderNo(shopOrderItem.getOrderNo());
        this.setPsdId(shopOrderItem.getPsdId());
        this.setProductId(shopOrderItem.getProductId());
        this.setSpecType(shopOrderItem.getSpecType());
        this.setNum(shopOrderItem.getNum());
        this.setRefundNum(shopOrderItem.getRefundNum());
        this.setPrice(shopOrderItem.getPrice());
        this.setIsAfterSales(shopOrderItem.getIsAfterSales());
        this.setIsShow(shopOrderItem.getIsShow());
        this.setCreateTime(DateUtils.timestampToStrDate(shopOrderItem.getCreateTime()));
        this.setProductSkuDetail(new ShopProductSkuDetailBo().compat(shopOrderItem.getProductSkuDetail()));
        this.setProduct(new ShopProductBo().compat(shopOrderItem.getProduct()));
        return this;
    }
}
