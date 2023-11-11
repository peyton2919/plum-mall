package cn.peyton.plum.mall.param;


import cn.peyton.plum.mall.pojo.DistributionSetting;

import java.io.Serializable;

/**
 * <h3> 分销设置 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:24
 * @version 1.0.0
 * </pre>
 */
public class DistributionSettingParam implements Serializable {
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

    /**
     * <h4>对象转成DistributionSetting对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,status,firstRebate,secondRebate,spreadBanners,brokerage,settlementDays,brokerageMethod]
     * </pre>
     */
    public DistributionSetting convert() {
        DistributionSetting distributionSetting = new DistributionSetting();
        distributionSetting.setId(id);
        distributionSetting.setStatus(status);
        distributionSetting.setFirstRebate(firstRebate);
        distributionSetting.setSecondRebate(secondRebate);
        distributionSetting.setSpreadBanners(spreadBanners);
        distributionSetting.setBrokerage(brokerage);
        distributionSetting.setSettlementDays(settlementDays);
        distributionSetting.setBrokerageMethod(brokerageMethod);
        return distributionSetting;
    }

    /**
     * <h4>DistributionSetting对象转成DistributionSettingParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,status,firstRebate,secondRebate,spreadBanners,brokerage,settlementDays,brokerageMethod]
     * </pre>
     */
    public DistributionSettingParam compat(DistributionSetting distributionSetting) {
        if (null == distributionSetting) {
            return new DistributionSettingParam();
        }
        this.setId(distributionSetting.getId());
        this.setStatus(distributionSetting.getStatus());
        this.setFirstRebate(distributionSetting.getFirstRebate());
        this.setSecondRebate(distributionSetting.getSecondRebate());
        this.setSpreadBanners(distributionSetting.getSpreadBanners());
        this.setBrokerage(distributionSetting.getBrokerage());
        this.setSettlementDays(distributionSetting.getSettlementDays());
        this.setBrokerageMethod(distributionSetting.getBrokerageMethod());
        return this;
    }
}
