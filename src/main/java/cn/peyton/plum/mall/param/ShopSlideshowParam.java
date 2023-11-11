package cn.peyton.plum.mall.param;


import cn.peyton.plum.mall.pojo.ShopSlideshow;

import java.io.Serializable;

/**
 * <h3> 商品轮播图 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:24
 * @version 1.0.0
 * </pre>
 */
public class ShopSlideshowParam implements Serializable {
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

    /**
     * <h4>对象转成ShopSlideshow对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,productId,src,url,createTime]
     * </pre>
     */
    public ShopSlideshow convert() {
        ShopSlideshow shopSlideshow = new ShopSlideshow();
        shopSlideshow.setId(id);
        shopSlideshow.setProductId(productId);
        shopSlideshow.setSrc(src);
        shopSlideshow.setUrl(url);
        shopSlideshow.setCreateTime(createTime);
        return shopSlideshow;
    }

    /**
     * <h4>ShopSlideshow对象转成ShopSlideshowParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,productId,src,url,createTime]
     * </pre>
     */
    public ShopSlideshowParam compat(ShopSlideshow shopSlideshow) {
        if (null == shopSlideshow) {
            return new ShopSlideshowParam();
        }
        this.setId(shopSlideshow.getId());
        this.setProductId(shopSlideshow.getProductId());
        this.setSrc(shopSlideshow.getSrc());
        this.setUrl(shopSlideshow.getUrl());
        this.setCreateTime(shopSlideshow.getCreateTime());
        return this;
    }
}
