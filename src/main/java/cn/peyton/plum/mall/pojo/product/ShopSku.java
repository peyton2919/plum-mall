package cn.peyton.plum.mall.pojo.product;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <h3> 商品规格 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public class ShopSku implements Serializable {
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
    /** 规格值 集合 */
    private List<ShopSkuValue> shopSkuValues;

    //================================== Constructor =======================================//
    public ShopSku() {
        if (null == shopSkuValues) { shopSkuValues = new ArrayList<>(); }
    }
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
     * @return 规格值 集合
     */
    public List<ShopSkuValue> getShopSkuValues() {
        return shopSkuValues;
    }

    /**
     * @param shopSkuValues 规格值 集合
     */
    public void setShopSkuValues(List<ShopSkuValue> shopSkuValues) {
        this.shopSkuValues = shopSkuValues;
    }


}
