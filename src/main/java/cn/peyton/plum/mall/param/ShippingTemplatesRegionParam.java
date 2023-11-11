package cn.peyton.plum.mall.param;

import cn.peyton.plum.mall.pojo.ShippingTemplatesRegion;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <h3> 运费地区模板 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:24
 * @version 1.0.0
 * </pre>
 */
public class ShippingTemplatesRegionParam implements Serializable {
    /**
     * 编号
     */
    private Integer id;
    /**
     * 省ID
     */
    private Integer provinceId;
    /**
     * 模板ID
     */
    private Integer tempId;
    /**
     * 城市ID
     */
    private Integer cityId;
    /**
     * 首件
     */
    private BigDecimal first;
    /**
     * 首件运费
     */
    private BigDecimal firstPrice;
    /**
     * 续件
     */
    private BigDecimal continues;
    /**
     * 续件运费
     */
    private BigDecimal continuePrice;
    /**
     * 计费方式; 默认 0 件数 1 重量
     */
    private Integer calcType;
    /**
     * 分组唯一值
     */
    private String uniqid;

    //================================== Constructor =======================================//

    //================================== Method =======================================//


    //================================== PREFIX_GET AND PREFIX_SET =======================================//

    /**
     * @param id 编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 编号
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param provinceId 省ID
     */
    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    /**
     * @return 省ID
     */
    public Integer getProvinceId() {
        return provinceId;
    }

    /**
     * @param tempId 模板ID
     */
    public void setTempId(Integer tempId) {
        this.tempId = tempId;
    }

    /**
     * @return 模板ID
     */
    public Integer getTempId() {
        return tempId;
    }

    /**
     * @param cityId 城市ID
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     * @return 城市ID
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     * @param first 首件
     */
    public void setFirst(BigDecimal first) {
        this.first = first;
    }

    /**
     * @return 首件
     */
    public BigDecimal getFirst() {
        return first;
    }

    /**
     * @param firstPrice 首件运费
     */
    public void setFirstPrice(BigDecimal firstPrice) {
        this.firstPrice = firstPrice;
    }

    /**
     * @return 首件运费
     */
    public BigDecimal getFirstPrice() {
        return firstPrice;
    }

    /**
     * @param continues 续件
     */
    public void setContinues(BigDecimal continues) {
        this.continues = continues;
    }

    /**
     * @return 续件
     */
    public BigDecimal getContinues() {
        return continues;
    }

    /**
     * @param continuePrice 续件运费
     */
    public void setContinuePrice(BigDecimal continuePrice) {
        this.continuePrice = continuePrice;
    }

    /**
     * @return 续件运费
     */
    public BigDecimal getContinuePrice() {
        return continuePrice;
    }

    /**
     * @param calcType 计费方式; 默认 0 件数 1 重量
     */
    public void setCalcType(Integer calcType) {
        this.calcType = calcType;
    }

    /**
     * @return 计费方式; 默认 0 件数 1 重量
     */
    public Integer getCalcType() {
        return calcType;
    }

    /**
     * @param uniqid 分组唯一值
     */
    public void setUniqid(String uniqid) {
        this.uniqid = uniqid;
    }

    /**
     * @return 分组唯一值
     */
    public String getUniqid() {
        return uniqid;
    }

    /**
     * <h4>对象转成ShippingTemplatesRegion对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,provinceId,tempId,cityId,first,firstPrice,continues,continuePrice,calcType,uniqid]
     * </pre>
     */
    public ShippingTemplatesRegion convert() {
        ShippingTemplatesRegion shippingTemplatesRegion = new ShippingTemplatesRegion();
        shippingTemplatesRegion.setId(id);
        shippingTemplatesRegion.setProvinceId(provinceId);
        shippingTemplatesRegion.setTempId(tempId);
        shippingTemplatesRegion.setCityId(cityId);
        shippingTemplatesRegion.setFirst(first);
        shippingTemplatesRegion.setFirstPrice(firstPrice);
        shippingTemplatesRegion.setContinues(continues);
        shippingTemplatesRegion.setContinuePrice(continuePrice);
        shippingTemplatesRegion.setCalcType(calcType);
        shippingTemplatesRegion.setUniqid(uniqid);
        return shippingTemplatesRegion;
    }

    /**
     * <h4>ShippingTemplatesRegion对象转成ShippingTemplatesRegionParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,provinceId,tempId,cityId,first,firstPrice,continues,continuePrice,calcType,uniqid]
     * </pre>
     */
    public ShippingTemplatesRegionParam compat(ShippingTemplatesRegion shippingTemplatesRegion) {
        if (null == shippingTemplatesRegion) {
            return new ShippingTemplatesRegionParam();
        }
        this.setId(shippingTemplatesRegion.getId());
        this.setProvinceId(shippingTemplatesRegion.getProvinceId());
        this.setTempId(shippingTemplatesRegion.getTempId());
        this.setCityId(shippingTemplatesRegion.getCityId());
        this.setFirst(shippingTemplatesRegion.getFirst());
        this.setFirstPrice(shippingTemplatesRegion.getFirstPrice());
        this.setContinues(shippingTemplatesRegion.getContinues());
        this.setContinuePrice(shippingTemplatesRegion.getContinuePrice());
        this.setCalcType(shippingTemplatesRegion.getCalcType());
        this.setUniqid(shippingTemplatesRegion.getUniqid());
        return this;
    }
}
