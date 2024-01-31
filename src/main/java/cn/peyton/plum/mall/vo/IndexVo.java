package cn.peyton.plum.mall.vo;

import cn.peyton.plum.mall.param.app.AppCategoryParam;
import cn.peyton.plum.mall.param.product.ShopProductParam;
import cn.peyton.plum.mall.param.pub.AdvertParam;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <h4>首页视图 VO类</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.mall.vo.
 * @date 2024年01月19日 22:04
 * @version 1.0.0
 * </pre>
 */
public class IndexVo implements Serializable {

    /** app分类集合 */
    private List<AppCategoryParam> categories;
    /** 广告轮播图集合 */
    private List<AdvertParam> swipers;
    /** 导航栏集合 */
    private List<AdvertParam> navs;
    /** 三图广告 */
    private List<AdvertParam> threeAdvs;
    /** 单图广告 */
    private AdvertParam oneAdv;
    /** 商品集合 */
    private List<ShopProductParam> shopProducts;

    public IndexVo() {
        if (null == categories) {categories = new ArrayList<>();}
        if (null == swipers) {swipers = new ArrayList<>();}
        if (null == navs) {navs = new ArrayList<>();}
        if (null == threeAdvs) {threeAdvs = new ArrayList<>();}
        if (null == oneAdv) {oneAdv = new AdvertParam();}
        if (null == shopProducts) {shopProducts = new ArrayList<>();}
    }

    /**
     * @return app分类集合
     */
    public List<AppCategoryParam> getCategories() {
        return categories;
    }

    /**
     * @param categories app分类集合
     */
    public void setCategories(List<AppCategoryParam> categories) {
        this.categories = categories;
    }

    /**
     * @return 广告轮播图集合
     */
    public List<AdvertParam> getSwipers() {
        return swipers;
    }

    /**
     * @param swipers 广告轮播图集合
     */
    public void setSwipers(List<AdvertParam> swipers) {
        this.swipers = swipers;
    }

    /**
     * @return 导航栏集合
     */
    public List<AdvertParam> getNavs() {
        return navs;
    }

    /**
     * @param navs 导航栏集合
     */
    public void setNavs(List<AdvertParam> navs) {
        this.navs = navs;
    }

    /**
     * @return 三图广告
     */
    public List<AdvertParam> getThreeAdvs() {
        return threeAdvs;
    }

    /**
     * @param threeAdvs 三图广告
     */
    public void setThreeAdvs(List<AdvertParam> threeAdvs) {
        this.threeAdvs = threeAdvs;
    }

    /**
     * @return 单图广告
     */
    public AdvertParam getOneAdv() {
        return oneAdv;
    }

    /**
     * @param oneAdv 单图广告
     */
    public void setOneAdv(AdvertParam oneAdv) {
        this.oneAdv = oneAdv;
    }

    /**
     * @return 商品集合
     */
    public List<ShopProductParam> getShopProducts() {
        return shopProducts;
    }

    /**
     * @param shopProducts 商品集合
     */
    public void setShopProducts(List<ShopProductParam> shopProducts) {
        this.shopProducts = shopProducts;
    }


}
