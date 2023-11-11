package cn.peyton.plum.mall.param;


import cn.peyton.plum.mall.pojo.ShopSkuValue;

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
    private Long skuId;
    /**
     * 商品属性参数
     */
    private String skuValue;
    /**
     * 排序取值范围0~9999，默认为0; 按大到小排序
     */
    private Short seq;

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
        return this;
    }
}
