package cn.peyton.plum.mall.pojo;


import java.io.Serializable;

/**
 * <h3> 分销设置 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public class DistributionSetting implements Serializable {
    /**
     *
     */
    private Long id;
    /**
     * 分销启用:0禁用1启用
     */
    private Integer status;
    /**
     * 一级返佣比例
     */
    private Integer firstRebate;
    /**
     * 二级返佣比例
     */
    private Integer secondRebate;
    /**
     * 分销海报图
     */
    private String spreadBanners;
    /**
     * 自购返佣:0否1是
     */
    private Boolean brokerage;
    /**
     * 结算时间（单位：天）
     */
    private Short settlementDays;
    /**
     * 佣金到账方式:hand手动,wx微信
     */
    private String brokerageMethod;

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
     * @param status 分销启用:0禁用1启用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return 分销启用:0禁用1启用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param firstRebate 一级返佣比例
     */
    public void setFirstRebate(Integer firstRebate) {
        this.firstRebate = firstRebate;
    }

    /**
     * @return 一级返佣比例
     */
    public Integer getFirstRebate() {
        return firstRebate;
    }

    /**
     * @param secondRebate 二级返佣比例
     */
    public void setSecondRebate(Integer secondRebate) {
        this.secondRebate = secondRebate;
    }

    /**
     * @return 二级返佣比例
     */
    public Integer getSecondRebate() {
        return secondRebate;
    }

    /**
     * @param spreadBanners 分销海报图
     */
    public void setSpreadBanners(String spreadBanners) {
        this.spreadBanners = spreadBanners;
    }

    /**
     * @return 分销海报图
     */
    public String getSpreadBanners() {
        return spreadBanners;
    }

    /**
     * @param brokerage 自购返佣:0否1是
     */
    public void setBrokerage(Boolean brokerage) {
        this.brokerage = brokerage;
    }

    /**
     * @return 自购返佣:0否1是
     */
    public Boolean getBrokerage() {
        return brokerage;
    }

    /**
     * @param settlementDays 结算时间（单位：天）
     */
    public void setSettlementDays(Short settlementDays) {
        this.settlementDays = settlementDays;
    }

    /**
     * @return 结算时间（单位：天）
     */
    public Short getSettlementDays() {
        return settlementDays;
    }

    /**
     * @param brokerageMethod 佣金到账方式:hand手动,wx微信
     */
    public void setBrokerageMethod(String brokerageMethod) {
        this.brokerageMethod = brokerageMethod;
    }

    /**
     * @return 佣金到账方式:hand手动,wx微信
     */
    public String getBrokerageMethod() {
        return brokerageMethod;
    }

}
