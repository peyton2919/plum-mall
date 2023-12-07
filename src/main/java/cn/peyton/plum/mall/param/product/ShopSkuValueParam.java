package cn.peyton.plum.mall.param.product;


import cn.peyton.plum.core.validator.constraints.Length;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.core.validator.constraints.Size;
import cn.peyton.plum.mall.pojo.product.ShopSkuValue;

import java.io.Serializable;

/**
 * <h3> 商品规格 值 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:24
 * @version 1.0.0
 * </pre>
 */
public class ShopSkuValueParam implements Serializable {
    /**
     *
     */
    private Long id;
    /**
     * 商品规格Id
     */
    @Min(value = 1,message = "最小值为1")
    private Long skuId;
    /**
     * 商品属性参数
     */
    @NotBlank(message = "名称不能为空!")
    @Length(min = 1, max = 40)
    private String skuValue;
    /**
     * 排序取值范围0~9999，默认为0; 按大到小排序
     */
    @Size(min = 0,max = 9999)
    private Short seq;
    /** 商品规格对象 */
    //public ShopSkuParam shopSkuParam;

    //================================== Constructor =======================================//
    //public ShopSkuValueParam() {
    //    if (null == shopSkuParam) { shopSkuParam = new ShopSkuParam();}
    //}
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
     * @param skuId 商品规格Id
     */
    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    /**
     * @return 商品规格Id
     */
    public Long getSkuId() {
        return skuId;
    }

    /**
     * @param skuValue 商品属性参数
     */
    public void setSkuValue(String skuValue) {
        this.skuValue = skuValue;
    }

    /**
     * @return 商品属性参数
     */
    public String getSkuValue() {
        return skuValue;
    }

    /**
     * @param seq 排序取值范围0~9999，默认为0; 按大到小排序
     */
    public void setSeq(Short seq) {
        this.seq = seq;
    }

    /**
     * @return 排序取值范围0~9999，默认为0; 按大到小排序
     */
    public Short getSeq() {
        return seq;
    }

    /**
     * @return 商品规格对象
     */
    //public ShopSkuParam getShopSkuParam() {
    //    return shopSkuParam;
    //}

    /**
     * @param shopSkuParam 商品规格对象
     */
    //public void setShopSkuParam(ShopSkuParam shopSkuParam) {
    //    this.shopSkuParam = shopSkuParam;
    //}

    /**
     * <h4>对象转成ShopSkuValue对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,skuId,skuValue,seq]
     * </pre>
     */
    public ShopSkuValue convert() {
        ShopSkuValue shopSkuValue = new ShopSkuValue();
        shopSkuValue.setId(id);
        shopSkuValue.setSkuId(skuId);
        shopSkuValue.setSkuValue(skuValue);
        shopSkuValue.setSeq(seq);
        //shopSkuValue.setShopSku(new ShopSkuBo().convert(shopSkuParam));
        return shopSkuValue;
    }

    /**
     * <h4>ShopSkuValue对象转成ShopSkuValueParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,skuId,skuValue,seq]
     * </pre>
     */
    public ShopSkuValueParam compat(ShopSkuValue shopSkuValue) {
        if (null == shopSkuValue) {
            return new ShopSkuValueParam();
        }
        this.setId(shopSkuValue.getId());
        this.setSkuId(shopSkuValue.getSkuId());
        this.setSkuValue(shopSkuValue.getSkuValue());
        this.setSeq(shopSkuValue.getSeq());
        //this.setShopSkuParam(new ShopSkuBo().compat(shopSkuValue.getShopSku()));
        return this;
    }
}
