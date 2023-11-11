package cn.peyton.plum.mall.pojo;


import java.io.Serializable;

/**
 * <h3> 商品轮播图 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public class ShopSlideshow implements Serializable {
    /**
     *
     */
    private Long id;
    /**
     * 商品Id
     */
    private Long productId;
    /**
     * 轮播图地址
     */
    private String src;
    /**
     * 轮播图链接地址(超链接跳转)
     */
    private String url;
    /**
     * 创建时间
     */
    private Integer createTime;

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
     * @param src 轮播图地址
     */
    public void setSrc(String src) {
        this.src = src;
    }

    /**
     * @return 轮播图地址
     */
    public String getSrc() {
        return src;
    }

    /**
     * @param url 轮播图链接地址(超链接跳转)
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return 轮播图链接地址(超链接跳转)
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param createTime 创建时间
     */
    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    /**
     * @return 创建时间
     */
    public Integer getCreateTime() {
        return createTime;
    }

}
