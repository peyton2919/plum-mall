package cn.peyton.plum.mall.param.product;


import cn.peyton.plum.mall.pojo.product.ShopProductAttrs;

import java.io.Serializable;

/**
 * <h3> 商品属性关联 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:24
 * @version 1.0.0
 * </pre>
 */
public class ShopProductAttrsParam implements Serializable {
    /**
     *
     */
    private Long id;
    /**
     * 商品Id
     */
    private Long productId;
    /**
     * 排序取值范围0~9999，默认为0; 按大到小排序
     */
    private Short seq;
    /**
     * 属性值
     */
    private String attrValue;
    /**
     * 商品类型属性名称
     */
    private String attrName;
    /**
     * 商品类型属性icon
     */
    private String attrIcon;
    /**
     * 说明
     */
    private String explain;
    /**
     * 表单提交类型;默认: 0
     */
    private Integer methodType;

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
     * @param attrValue 属性值
     */
    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue;
    }

    /**
     * @return 属性值
     */
    public String getAttrValue() {
        return attrValue;
    }

    /**
     * @param attrName 商品类型属性名称
     */
    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    /**
     * @return 商品类型属性名称
     */
    public String getAttrName() {
        return attrName;
    }

    /**
     * @param attrIcon 商品类型属性icon
     */
    public void setAttrIcon(String attrIcon) {
        this.attrIcon = attrIcon;
    }

    /**
     * @return 商品类型属性icon
     */
    public String getAttrIcon() {
        return attrIcon;
    }

    /**
     * @param explain 说明
     */
    public void setExplain(String explain) {
        this.explain = explain;
    }

    /**
     * @return 说明
     */
    public String getExplain() {
        return explain;
    }

    /**
     * @param methodType 表单提交类型;默认: 0
     */
    public void setMethodType(Integer methodType) {
        this.methodType = methodType;
    }

    /**
     * @return 表单提交类型;默认: 0
     */
    public Integer getMethodType() {
        return methodType;
    }

    /**
     * <h4>对象转成ShopProductAttrs对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,productId,seq,attrValue,attrName,attrIcon,explain,methodType]
     * </pre>
     */
    public ShopProductAttrs convert() {
        ShopProductAttrs shopProductAttrs = new ShopProductAttrs();
        shopProductAttrs.setId(id);
        shopProductAttrs.setProductId(productId);
        shopProductAttrs.setSeq(seq);
        shopProductAttrs.setAttrValue(attrValue);
        shopProductAttrs.setAttrName(attrName);
        shopProductAttrs.setAttrIcon(attrIcon);
        shopProductAttrs.setExplain(explain);
        shopProductAttrs.setMethodType(methodType);
        return shopProductAttrs;
    }

    /**
     * <h4>ShopProductAttrs对象转成ShopProductAttrsParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,productId,attrId,id,productId,seq,attrValue,attrName,attrIcon,explain,methodType]
     * </pre>
     */
    public ShopProductAttrsParam compat(ShopProductAttrs shopProductAttrs) {
        if (null == shopProductAttrs) {
            return new ShopProductAttrsParam();
        }
        this.setId(shopProductAttrs.getId());
        this.setProductId(shopProductAttrs.getProductId());
        this.setSeq(shopProductAttrs.getSeq());
        this.setAttrValue(shopProductAttrs.getAttrValue());
        this.setAttrName(shopProductAttrs.getAttrName());
        this.setAttrIcon(shopProductAttrs.getAttrIcon());
        this.setExplain(shopProductAttrs.getExplain());
        this.setMethodType(shopProductAttrs.getMethodType());
        return this;
    }
}
