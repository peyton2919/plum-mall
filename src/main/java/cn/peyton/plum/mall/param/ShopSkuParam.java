package cn.peyton.plum.mall.param;


import cn.peyton.plum.mall.pojo.ShopSku;

import java.io.Serializable;

/**
 * <h3> 商品规格 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:24
 * @version 1.0.0
 * </pre>
 */
public class ShopSkuParam implements Serializable {
    /**
     *
     */
    private Long id;
    /**
     * 规格名称
     */
    private String name;
    /**
     * 商品属性卡片属性类型 0无 1颜色 2图片 默认: 0
     */
    private Integer skuType;
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
     * @param name 规格名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return 规格名称
     */
    public String getName() {
        return name;
    }

    /**
     * @param skuType 商品属性卡片属性类型 0无 1颜色 2图片 默认: 0
     */
    public void setSkuType(Integer skuType) {
        this.skuType = skuType;
    }

    /**
     * @return 商品属性卡片属性类型 0无 1颜色 2图片 默认: 0
     */
    public Integer getSkuType() {
        return skuType;
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
     * <h4>对象转成ShopSku对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,name,skuType,seq]
     * </pre>
     */
    public ShopSku convert() {
        ShopSku shopSku = new ShopSku();
        shopSku.setId(id);
        shopSku.setName(name);
        shopSku.setSkuType(skuType);
        shopSku.setSeq(seq);
        return shopSku;
    }

    /**
     * <h4>ShopSku对象转成ShopSkuParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,name,skuType,seq]
     * </pre>
     */
    public ShopSkuParam compat(ShopSku shopSku) {
        if (null == shopSku) {
            return new ShopSkuParam();
        }
        this.setId(shopSku.getId());
        this.setName(shopSku.getName());
        this.setSkuType(shopSku.getSkuType());
        this.setSeq(shopSku.getSeq());
        return this;
    }
}
