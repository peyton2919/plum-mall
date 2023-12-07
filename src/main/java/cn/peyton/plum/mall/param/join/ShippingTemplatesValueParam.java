package cn.peyton.plum.mall.param.join;

import cn.peyton.plum.mall.pojo.join.ShippingTemplatesValue;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <h3> 运费 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:24
 * @version 1.0.0
 * </pre>
 */
public class ShippingTemplatesValueParam implements Serializable {
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
     * 包邮件数
     */
    private BigDecimal num;
    /**
     * 包邮金额
     */
    private BigDecimal price;
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
     * @param num 包邮件数
     */
    public void setNum(BigDecimal num) {
        this.num = num;
    }

    /**
     * @return 包邮件数
     */
    public BigDecimal getNum() {
        return num;
    }

    /**
     * @param price 包邮金额
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * @return 包邮金额
     */
    public BigDecimal getPrice() {
        return price;
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
     * <h4>对象转成ShippingTemplatesValue对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,provinceId,tempId,cityId,num,price,calcType,uniqid]
     * </pre>
     */
    public ShippingTemplatesValue convert() {
        ShippingTemplatesValue shippingTemplatesValue = new ShippingTemplatesValue();
        shippingTemplatesValue.setId(id);
        shippingTemplatesValue.setProvinceId(provinceId);
        shippingTemplatesValue.setTempId(tempId);
        shippingTemplatesValue.setCityId(cityId);
        shippingTemplatesValue.setNum(num);
        shippingTemplatesValue.setPrice(price);
        shippingTemplatesValue.setCalcType(calcType);
        shippingTemplatesValue.setUniqid(uniqid);
        return shippingTemplatesValue;
    }

    /**
     * <h4>ShippingTemplatesValue对象转成ShippingTemplatesValueParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,provinceId,tempId,cityId,num,price,calcType,uniqid]
     * </pre>
     */
    public ShippingTemplatesValueParam compat(ShippingTemplatesValue shippingTemplatesValue) {
        if (null == shippingTemplatesValue) {
            return new ShippingTemplatesValueParam();
        }
        this.setId(shippingTemplatesValue.getId());
        this.setProvinceId(shippingTemplatesValue.getProvinceId());
        this.setTempId(shippingTemplatesValue.getTempId());
        this.setCityId(shippingTemplatesValue.getCityId());
        this.setNum(shippingTemplatesValue.getNum());
        this.setPrice(shippingTemplatesValue.getPrice());
        this.setCalcType(shippingTemplatesValue.getCalcType());
        this.setUniqid(shippingTemplatesValue.getUniqid());
        return this;
    }
}
