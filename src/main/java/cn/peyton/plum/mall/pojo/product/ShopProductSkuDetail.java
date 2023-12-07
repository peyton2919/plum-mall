package cn.peyton.plum.mall.pojo.product;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <h3> 商品规格详细 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public class ShopProductSkuDetail implements Serializable {
    /**
     * 编号 { 对应 psd_id }
     */
    private Long id;
    /**
     * 商品Id
     */
    private Long productId;
    /**
     * 商品属性索引值 (attr_value|attr_value[|....])
     */
    private String skus;
    /**
     * 属性对应的库存,默认0
     */
    private Integer stock;
    /** 库存预警(默认0 不提示 >0 低于设置值 提示) */
    private Integer minStock;

    /**
     * 销量,默认0
     */
    private Integer sales;
    /**
     * 封面图片
     */
    private String cover;
    /**
     * 唯一值
     */
    private String uniqueCode;
    /**
     * 商品条码
     */
    private String barCode;
    /**
     * 需要多少积分兑换
     */
    private Integer integral;
    /**  最低价格 */
    private BigDecimal minPrice;

    /**
     * 商品价格(批发)
     */
    private BigDecimal price;
    /**
     * 会员价格
     */
    private BigDecimal vipPrice;
    /**
     * 市场价格
     */
    private BigDecimal otPrice;
    /**
     * 成本价格
     */
    private BigDecimal costPrice;
    /**
     * 重量
     */
    private BigDecimal weight;
    /**
     * 体积
     */
    private BigDecimal volume;
    /**
     * 一级返佣
     */
    private BigDecimal brokerage;
    /**
     * 二级返佣
     */
    private BigDecimal brokerageTwo;
    /**
     * 拼团价格
     */
    private BigDecimal pinkPrice;
    /**
     * 拼团库存
     */
    private Integer pinkStock;
    /**
     * 砍价价格
     */
    private BigDecimal bargainPrice;
    /**
     * 砍价库存
     */
    private Integer bargainStock;
    /**
     * 秒杀价格
     */
    private BigDecimal seckillPrice;
    /**
     * 秒杀库存
     */
    private Integer seckillStock;
    /**
     * 仓库Id
     */
    private Integer warehouseId;
    /**
     * 仓库说明
     */
    private String warehouseExplain;

    //================================== Constructor =======================================//

    //================================== Method =======================================//


    //================================== PREFIX_GET AND PREFIX_SET =======================================//

    /**
     * @param id 编号 { 对应 psd_id }
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return 编号 { 对应 psd_id }
     */
    public Long getId() {
        return id;
    }

    /**
     * @param productId 商品Id
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * @return 商品Id
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * @param skus 商品属性索引值 (attr_value|attr_value[|....])
     */
    public void setSkus(String skus) {
        this.skus = skus;
    }

    /**
     * @return 商品属性索引值 (attr_value|attr_value[|....])
     */
    public String getSkus() {
        return skus;
    }

    /**
     * @param stock 属性对应的库存,默认0
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * @return 属性对应的库存, 默认0
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * @return 库存预警(默认0 不提示 >0 低于设置值 提示)
     */
    public Integer getMinStock() {
        return minStock;
    }

    /**
     * @param minStock 库存预警(默认0 不提示 >0 低于设置值 提示)
     */
    public void setMinStock(Integer minStock) {
        this.minStock = minStock;
    }

    /**
     * @param sales 销量,默认0
     */
    public void setSales(Integer sales) {
        this.sales = sales;
    }

    /**
     * @return 销量, 默认0
     */
    public Integer getSales() {
        return sales;
    }

    /**
     * @param cover 封面图片
     */
    public void setCover(String cover) {
        this.cover = cover;
    }

    /**
     * @return 封面图片
     */
    public String getCover() {
        return cover;
    }

    /**
     * @param uniqueCode 唯一值
     */
    public void setUniqueCode(String uniqueCode) {
        this.uniqueCode = uniqueCode;
    }

    /**
     * @return 唯一值
     */
    public String getUniqueCode() {
        return uniqueCode;
    }

    /**
     * @param barCode 商品条码
     */
    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    /**
     * @return 商品条码
     */
    public String getBarCode() {
        return barCode;
    }

    /**
     * @param integral 需要多少积分兑换
     */
    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    /**
     * @return 需要多少积分兑换
     */
    public Integer getIntegral() {
        return integral;
    }

    /**
     * @return 最低价格
     */
    public BigDecimal getMinPrice() {
        return minPrice;
    }

    /**
     * @param minPrice 最低价格
     */
    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }
    /**
     * @param price 商品价格(批发)
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * @return 商品价格(批发)
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param vipPrice 会员价格
     */
    public void setVipPrice(BigDecimal vipPrice) {
        this.vipPrice = vipPrice;
    }

    /**
     * @return 会员价格
     */
    public BigDecimal getVipPrice() {
        return vipPrice;
    }

    /**
     * @param otPrice 市场价格
     */
    public void setOtPrice(BigDecimal otPrice) {
        this.otPrice = otPrice;
    }

    /**
     * @return 市场价格
     */
    public BigDecimal getOtPrice() {
        return otPrice;
    }

    /**
     * @param costPrice 成本价格
     */
    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    /**
     * @return 成本价格
     */
    public BigDecimal getCostPrice() {
        return costPrice;
    }

    /**
     * @param weight 重量
     */
    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    /**
     * @return 重量
     */
    public BigDecimal getWeight() {
        return weight;
    }

    /**
     * @param volume 体积
     */
    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    /**
     * @return 体积
     */
    public BigDecimal getVolume() {
        return volume;
    }

    /**
     * @param brokerage 一级返佣
     */
    public void setBrokerage(BigDecimal brokerage) {
        this.brokerage = brokerage;
    }

    /**
     * @return 一级返佣
     */
    public BigDecimal getBrokerage() {
        return brokerage;
    }

    /**
     * @param brokerageTwo 二级返佣
     */
    public void setBrokerageTwo(BigDecimal brokerageTwo) {
        this.brokerageTwo = brokerageTwo;
    }

    /**
     * @return 二级返佣
     */
    public BigDecimal getBrokerageTwo() {
        return brokerageTwo;
    }

    /**
     * @param pinkPrice 拼团价格
     */
    public void setPinkPrice(BigDecimal pinkPrice) {
        this.pinkPrice = pinkPrice;
    }

    /**
     * @return 拼团价格
     */
    public BigDecimal getPinkPrice() {
        return pinkPrice;
    }

    /**
     * @param pinkStock 拼团库存
     */
    public void setPinkStock(Integer pinkStock) {
        this.pinkStock = pinkStock;
    }

    /**
     * @return 拼团库存
     */
    public Integer getPinkStock() {
        return pinkStock;
    }

    /**
     * @param bargainPrice 砍价价格
     */
    public void setBargainPrice(BigDecimal bargainPrice) {
        this.bargainPrice = bargainPrice;
    }

    /**
     * @return 砍价价格
     */
    public BigDecimal getBargainPrice() {
        return bargainPrice;
    }

    /**
     * @param bargainStock 砍价库存
     */
    public void setBargainStock(Integer bargainStock) {
        this.bargainStock = bargainStock;
    }

    /**
     * @return 砍价库存
     */
    public Integer getBargainStock() {
        return bargainStock;
    }

    /**
     * @param seckillPrice 秒杀价格
     */
    public void setSeckillPrice(BigDecimal seckillPrice) {
        this.seckillPrice = seckillPrice;
    }

    /**
     * @return 秒杀价格
     */
    public BigDecimal getSeckillPrice() {
        return seckillPrice;
    }

    /**
     * @param seckillStock 秒杀库存
     */
    public void setSeckillStock(Integer seckillStock) {
        this.seckillStock = seckillStock;
    }

    /**
     * @return 秒杀库存
     */
    public Integer getSeckillStock() {
        return seckillStock;
    }

    /**
     * @param warehouseId 仓库Id
     */
    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    /**
     * @return 仓库Id
     */
    public Integer getWarehouseId() {
        return warehouseId;
    }

    /**
     * @param warehouseExplain 仓库说明
     */
    public void setWarehouseExplain(String warehouseExplain) {
        this.warehouseExplain = warehouseExplain;
    }

    /**
     * @return 仓库说明
     */
    public String getWarehouseExplain() {
        return warehouseExplain;
    }

}
