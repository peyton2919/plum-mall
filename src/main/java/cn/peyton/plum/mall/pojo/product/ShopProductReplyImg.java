package cn.peyton.plum.mall.pojo.product;


import java.io.Serializable;

/**
 * <h3> 商品评论 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public class ShopProductReplyImg implements Serializable {
    /**
     * 评论Id
     */
    private Long id;
    /**
     * 产品Id
     */
    private Long productId;
    /**
     * 图片地址
     */
    private String src;
    /**
     * 是否显示, 默认: 1 显示, 0 不显示
     */
    private Integer isShow;

    //================================== Constructor =======================================//

    //================================== Method =======================================//


    //================================== PREFIX_GET AND PREFIX_SET =======================================//

    /**
     * @param id 评论Id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return 评论Id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param productId 产品Id
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * @return 产品Id
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * @param src 图片地址
     */
    public void setSrc(String src) {
        this.src = src;
    }

    /**
     * @return 图片地址
     */
    public String getSrc() {
        return src;
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
