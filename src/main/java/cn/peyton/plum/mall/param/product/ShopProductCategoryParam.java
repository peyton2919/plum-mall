package cn.peyton.plum.mall.param.product;


import cn.peyton.plum.mall.pojo.product.ShopProductCategory;

import java.io.Serializable;

/**
 * <h3> 商品与商品分类关联 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:24
 * @version 1.0.0
 * </pre>
 */
public class ShopProductCategoryParam implements Serializable {
    /**
     *
     */
    private Long id;
    /**
     * 商品分类Id
     */
    private Integer categoryId;
    /**
     * 商品Id
     */
    private Long productId;

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
     * @param categoryId 商品分类Id
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return 商品分类Id
     */
    public Integer getCategoryId() {
        return categoryId;
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
     * <h4>对象转成ShopProductCategory对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,categoryId,productId]
     * </pre>
     */
    public ShopProductCategory convert() {
        ShopProductCategory shopProductCategory = new ShopProductCategory();
        shopProductCategory.setId(id);
        shopProductCategory.setCategoryId(categoryId);
        shopProductCategory.setProductId(productId);
        return shopProductCategory;
    }

    /**
     * <h4>ShopProductCategory对象转成ShopProductCategoryParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,categoryId,productId]
     * </pre>
     */
    public ShopProductCategoryParam compat(ShopProductCategory shopProductCategory) {
        if (null == shopProductCategory) {
            return new ShopProductCategoryParam();
        }
        this.setId(shopProductCategory.getId());
        this.setCategoryId(shopProductCategory.getCategoryId());
        this.setProductId(shopProductCategory.getProductId());
        return this;
    }
}
