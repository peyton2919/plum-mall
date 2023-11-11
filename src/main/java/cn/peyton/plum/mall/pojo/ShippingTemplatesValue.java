package cn.peyton.plum.mall.pojo;

import java.math.BigDecimal;

import java.io.Serializable;

/**
 * <h3> 运费 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public class ShippingTemplatesValue implements Serializable {
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

}
