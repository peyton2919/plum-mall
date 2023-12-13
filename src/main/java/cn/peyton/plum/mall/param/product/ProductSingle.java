package cn.peyton.plum.mall.param.product;

import cn.peyton.plum.core.validator.constraints.DecimalMin;
import cn.peyton.plum.core.validator.constraints.NotBlank;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <h4>商品单规格类</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.mall.param.product.
 * @date 2023年12月08日 22:31
 * @version 1.0.0
 * </pre>
 */
public class ProductSingle implements Serializable {
    /**
     * 商品Id
     */
    private Long id;
    /**
     * 规格 0单 1多
     */
    private Integer specType;
    /**  最低价格 */
    @NotBlank(message = "最低价格不能为空")
    @DecimalMin(value = 0.01,message = "最低价格不能小于0.01元")
    private BigDecimal minPrice;

    /**
     * 商品价格(批发)
     */
    @NotBlank(message = "批发价格不能为空")
    @DecimalMin(value = 0.01,message = "批发价格不能小于0.01元")
    private BigDecimal price;
    /**
     * 会员价格
     */
    @NotBlank(message = "会员价格不能为空")
    @DecimalMin(value = 0.01,message = "会员价格不能小于0.01元")
    private BigDecimal vipPrice;
    /**
     * 市场价格
     */
    @NotBlank(message = "市场价格不能为空")
    @DecimalMin(value = 0.01,message = "市场价格不能小于0.01元")
    private BigDecimal otPrice;
    /**
     * 成本价格
     */
    @NotBlank(message = "成本价格不能为空")
    @DecimalMin(value = 0.01,message = "成本价格不能小于0.01元")
    private BigDecimal costPrice;
    /**
     * 重量
     */
    @DecimalMin(value = 0,message = "重量数值不能小于0")
    private BigDecimal weight;
    /**
     * 体积
     */
    @DecimalMin(value = 0,message = "重量数值不能小于0")
    private BigDecimal volume;

    /** 操作提示 默认`0,0,0`[规格|spec, 轮播图|slideshow, 详情|info],0 表示 未操作 1 表示操作过 */
    private String operate;

    /**
     * @param id 商品Id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return 商品Id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param specType 规格 0单 1多
     */
    public void setSpecType(Integer specType) {
        this.specType = specType;
    }

    /**
     * @return 规格 0单 1多
     */
    public Integer getSpecType() {
        return specType;
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
     * @return 最低价 {高于 正常要高于 vip 价}
     */
    public BigDecimal getMinPrice() {
        return minPrice;
    }

    /**
     * @param minPrice 最低价 {高于 正常要高于 vip 价}
     */
    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    /**
     * @param otPrice 市场价
     */
    public void setOtPrice(BigDecimal otPrice) {
        this.otPrice = otPrice;
    }

    /**
     * @return 市场价
     */
    public BigDecimal getOtPrice() {
        return otPrice;
    }

    /**
     * @param costPrice 成本价
     */
    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    /**
     * @return 成本价
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
     * @return 操作提示 默认0,0,0[规格|spec, 轮播图|slideshow, 详情|info],0 表示 未操作 1 表示操作过
     */
    public String getOperate() {
        return operate;
    }

    /**
     * @param operate 操作提示 默认0,0,0[规格|spec, 轮播图|slideshow, 详情|info],0 表示 未操作 1 表示操作过
     */
    public void setOperate(String operate) {
        this.operate = operate;
    }
}
