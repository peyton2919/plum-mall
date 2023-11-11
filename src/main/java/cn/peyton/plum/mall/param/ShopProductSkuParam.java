package cn.peyton.plum.mall.param;


import cn.peyton.plum.mall.pojo.ShopProductSku;

import java.io.Serializable;

/**
 * <h3> 商品规格关联 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:24
 * @version 1.0.0
 * </pre>
 */
public class ShopProductSkuParam implements Serializable {
    /**
     *
     */
    private Long id;
    /**
     * 商品Id
     */
    private Long productId;
    /**
     * 规格Id
     */
    private Long skuId;
    /**
     * 商品规格Id
     */
    private Long productSkuId;

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
     * @param skuId 规格Id
     */
    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    /**
     * @return 规格Id
     */
    public Long getSkuId() {
        return skuId;
    }

    /**
     * @param productSkuId 商品规格Id
     */
    public void setProductSkuId(Long productSkuId) {
        this.productSkuId = productSkuId;
    }

    /**
     * @return 商品规格Id
     */
    public Long getProductSkuId() {
        return productSkuId;
    }

    /**
     * <h4>对象转成ShopProductSku对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,productId,skuId,productSkuId]
     * </pre>
     */
    public ShopProductSku convert() {
        ShopProductSku shopProductSku = new ShopProductSku();
        shopProductSku.setId(id);
        shopProductSku.setProductId(productId);
        shopProductSku.setSkuId(skuId);
        shopProductSku.setProductSkuId(productSkuId);
        return shopProductSku;
    }

    /**
     * <h4>ShopProductSku对象转成ShopProductSkuParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,productId,skuId,productSkuId]
     * </pre>
     */
    public ShopProductSkuParam compat(ShopProductSku shopProductSku) {
        if (null == shopProductSku) {
            return new ShopProductSkuParam();
        }
        this.setId(shopProductSku.getId());
        this.setProductId(shopProductSku.getProductId());
        this.setSkuId(shopProductSku.getSkuId());
        this.setProductSkuId(shopProductSku.getProductSkuId());
        return this;
    }
}
