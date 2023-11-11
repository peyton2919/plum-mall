package cn.peyton.plum.mall.pojo;


import java.io.Serializable;

/**
 * <h3> 商品规格关联 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public class ShopProductSku implements Serializable {
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

}
