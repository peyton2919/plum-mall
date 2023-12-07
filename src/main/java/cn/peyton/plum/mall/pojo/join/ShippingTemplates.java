package cn.peyton.plum.mall.pojo.join;


import java.io.Serializable;

/**
 * <h3> 运费模板 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public class ShippingTemplates implements Serializable {
    /**
     * 模板ID
     */
    private Integer id;
    /**
     * 模板名称
     */
    private String name;
    /**
     * 计费方式; 默认 0 件数 1 重量
     */
    private Integer calcType;
    /**
     * 地域以及费用
     */
    private String regionInfo;
    /**
     * 指定包邮开关
     */
    private Integer appoint;
    /**
     * 指定包邮内容
     */
    private String appointInfo;
    /**
     * 是否删除: 默认1(1：可用;0已删除)
     */
    private Boolean isDel;
    /**
     * 排序取值范围0~9999，默认为0; 按大到小排序
     */
    private Short seq;
    /**
     * 添加时间
     */
    private Integer createTime;
    /**
     * 更新时间
     */
    private Integer updateTime;

    //================================== Constructor =======================================//

    //================================== Method =======================================//


    //================================== PREFIX_GET AND PREFIX_SET =======================================//

    /**
     * @param id 模板ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 模板ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param name 模板名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return 模板名称
     */
    public String getName() {
        return name;
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
     * @param regionInfo 地域以及费用
     */
    public void setRegionInfo(String regionInfo) {
        this.regionInfo = regionInfo;
    }

    /**
     * @return 地域以及费用
     */
    public String getRegionInfo() {
        return regionInfo;
    }

    /**
     * @param appoint 指定包邮开关
     */
    public void setAppoint(Integer appoint) {
        this.appoint = appoint;
    }

    /**
     * @return 指定包邮开关
     */
    public Integer getAppoint() {
        return appoint;
    }

    /**
     * @param appointInfo 指定包邮内容
     */
    public void setAppointInfo(String appointInfo) {
        this.appointInfo = appointInfo;
    }

    /**
     * @return 指定包邮内容
     */
    public String getAppointInfo() {
        return appointInfo;
    }

    /**
     * @param isDel 是否删除: 默认1(1：可用;0已删除)
     */
    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }

    /**
     * @return 是否删除: 默认1(1：可用;0已删除)
     */
    public Boolean getIsDel() {
        return isDel;
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
     * @param createTime 添加时间
     */
    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    /**
     * @return 添加时间
     */
    public Integer getCreateTime() {
        return createTime;
    }

    /**
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return 更新时间
     */
    public Integer getUpdateTime() {
        return updateTime;
    }

}
