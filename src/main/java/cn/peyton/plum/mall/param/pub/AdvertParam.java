package cn.peyton.plum.mall.param.pub;


import cn.peyton.plum.mall.pojo.pub.Advert;

import java.io.Serializable;

/**
 * <h3> 广告信息 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:24
 * @version 1.0.0
 * </pre>
 */
public class AdvertParam implements Serializable {
    /**
     * 编号
     */
    private Long id;
    /**
     * 标题: 可用于导航栏
     */
    private String title;
    /**
     * 广告图片地址
     */
    private String src;
    /**
     * 广告图片点击跳转链接
     */
    private String url;
    /**
     * 类型: 0:one 单图; 1:three 三图; 2:swiper: 轮播图; 3:导航：nav;
     */
    private Integer imgType;
    /**
     * 图片位置默认: 0; 类型为三图用：0: 左边: left; 1:上边: up; 2:下边: down;
     */
    private Integer location;
    /**
     * 热度: 值越大越靠前
     */
    private Integer hot;
    /**
     * 点击数,每点击一次加1
     */
    private Integer clickCount;
    /**
     * 是否删除: 默认1(1：可用;0已删除)
     */
    private Integer isDel;
    /**
     * 创建时间
     */
    private Integer createTime;

    //================================== Constructor =======================================//

    //================================== Method =======================================//


    //================================== PREFIX_GET AND PREFIX_SET =======================================//

    /**
     * @param id 编号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return 编号
     */
    public Long getId() {
        return id;
    }

    /**
     * @param title 标题: 可用于导航栏
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return 标题: 可用于导航栏
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param src 广告图片地址
     */
    public void setSrc(String src) {
        this.src = src;
    }

    /**
     * @return 广告图片地址
     */
    public String getSrc() {
        return src;
    }

    /**
     * @param url 广告图片点击跳转链接
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return 广告图片点击跳转链接
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param imgType 类型: 0:one 单图; 1:three 三图; 2:swiper: 轮播图; 3:导航：nav;
     */
    public void setImgType(Integer imgType) {
        this.imgType = imgType;
    }

    /**
     * @return 类型: 0:one 单图; 1:three 三图; 2:swiper: 轮播图; 3:导航：nav;
     */
    public Integer getImgType() {
        return imgType;
    }

    /**
     * @param location 图片位置默认: 0; 类型为三图用：0: 左边: left; 1:上边: up; 2:下边: down;
     */
    public void setLocation(Integer location) {
        this.location = location;
    }

    /**
     * @return 图片位置默认: 0; 类型为三图用：0: 左边: left; 1:上边: up; 2:下边: down;
     */
    public Integer getLocation() {
        return location;
    }

    /**
     * @param hot 热度: 值越大越靠前
     */
    public void setHot(Integer hot) {
        this.hot = hot;
    }

    /**
     * @return 热度: 值越大越靠前
     */
    public Integer getHot() {
        return hot;
    }

    /**
     * @param clickCount 点击数,每点击一次加1
     */
    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    /**
     * @return 点击数, 每点击一次加1
     */
    public Integer getClickCount() {
        return clickCount;
    }

    /**
     * @param isDel 是否删除: 默认1(1：可用;0已删除)
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    /**
     * @return 是否删除: 默认1(1：可用;0已删除)
     */
    public Integer getIsDel() {
        return isDel;
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
     * <h4>对象转成Advert对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,title,src,url,imgType,location,hot,clickCount,isDel,createTime]
     * </pre>
     */
    public Advert convert() {
        Advert advert = new Advert();
        advert.setId(id);
        advert.setTitle(title);
        advert.setSrc(src);
        advert.setUrl(url);
        advert.setImgType(imgType);
        advert.setLocation(location);
        advert.setHot(hot);
        advert.setClickCount(clickCount);
        advert.setIsDel(isDel);
        advert.setCreateTime(createTime);
        return advert;
    }

    /**
     * <h4>Advert对象转成AdvertParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,title,src,url,imgType,location,hot,clickCount,isDel,createTime]
     * </pre>
     */
    public AdvertParam compat(Advert advert) {
        if (null == advert) {
            return new AdvertParam();
        }
        this.setId(advert.getId());
        this.setTitle(advert.getTitle());
        this.setSrc(advert.getSrc());
        this.setUrl(advert.getUrl());
        this.setImgType(advert.getImgType());
        this.setLocation(advert.getLocation());
        this.setHot(advert.getHot());
        this.setClickCount(advert.getClickCount());
        this.setIsDel(advert.getIsDel());
        this.setCreateTime(advert.getCreateTime());
        return this;
    }
}
