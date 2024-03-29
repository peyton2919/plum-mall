package cn.peyton.plum.mall.vo;

import cn.peyton.plum.core.validator.constraints.Datetime;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.core.validator.constraints.Size;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <h4>欠款 vo 类</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.mall.param.query.
 * @date 2024年01月17日 9:32
 * @version 1.0.0
 * </pre>
 */
public class ArrearVo implements Serializable {

    /** 会员主键 */
    private Long memberId;
    /** 订单主键 */
    private Long oid;
    /**
     * 状态 默认 0 未清 1 已清
     */
    @Size(min = 0, max = 1)
    private Integer status=0;
    /**
     * 还款方式: 0 微信 1 支付宝 2 转账 3 现金 4 其他
     */
    @Size(min = -1, max = 4)
    private Integer repayType;
    /** 金额 */
    private BigDecimal money;
    /** 查询金额范围:最小金额 */
    private BigDecimal minMoney;
    /** 查询金额范围:最大金额 */
    private BigDecimal maxMoney;
    /** 实际付款金额 */
    private BigDecimal actualPayment;
    /** 时间 */
    @Datetime
    private String time;
    /** 查找时段{ 1天 7天 1个月 6个月 1年 } */
    private String timeInterval;
    /** 查找方向 {欠款 arrear | 还款 repay} */
    private String mode;
    /** 当前页码 */
    @NotBlank(message = "页码不能为空")
    @Min(value = 1,message = "页码最小值为1")
    private Integer pageNo;

    /** 每页记录条数 */
    @Min(value = 1,message = "页码最小值为1")
    private Integer limit;
    /** 开始时间 */
    private String startTime;
    /** 结束时间 */
    private String endTime;

    /**
     * @return 会员主键
     */
    public Long getMemberId() {
        return memberId;
    }

    /**
     * @param memberId 会员主键
     */
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    /**
     * @return 订单主键
     */
    public Long getOid() {
        return oid;
    }

    /**
     * @param oid 订单主键
     */
    public void setOid(Long oid) {
        this.oid = oid;
    }

    /**
     * @return 状态 默认 0 未清 1 已清
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status 状态 默认 0 未清 1 已清
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return 还款方式: 0 微信 1 支付宝 2 转账 3 现金 4 其他
     */
    public Integer getRepayType() {
        return repayType;
    }

    /**
     * @param repayType 还款方式: 0 微信 1 支付宝 2 转账 3 现金 4 其他
     */
    public void setRepayType(Integer repayType) {
        this.repayType = repayType;
    }

    /**
     * @return 欠款金额
     */
    public BigDecimal getMoney() {
        return money;
    }

    /**
     * @param money 欠款金额
     */
    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    /**
     * @return 查询金额范围:最小金额
     */
    public BigDecimal getMinMoney() {
        return minMoney;
    }

    /**
     * @param minMoney 查询金额范围:最小金额
     */
    public void setMinMoney(BigDecimal minMoney) {
        this.minMoney = minMoney;
    }

    /**
     * @return 查询金额范围:最大金额
     */
    public BigDecimal getMaxMoney() {
        return maxMoney;
    }

    /**
     * @param maxMoney 查询金额范围:最大金额
     */
    public void setMaxMoney(BigDecimal maxMoney) {
        this.maxMoney = maxMoney;
    }
    /**
     * @return 实际付款金额
     */
    public BigDecimal getActualPayment() {
        return actualPayment;
    }

    /**
     * @param actualPayment 实际付款金额
     */
    public void setActualPayment(BigDecimal actualPayment) {
        this.actualPayment = actualPayment;
    }

    /**
     * @return 时间
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time 时间
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return 查找时段{ 1天 7天 1个月 6个月 1年 }
     */
    public String getTimeInterval() {
        return timeInterval;
    }

    /**
     * @param timeInterval 查找时段{ 1天 7天 1个月 6个月 1年 }
     */
    public void setTimeInterval(String timeInterval) {
        this.timeInterval = timeInterval;
    }

    /**
     * @return 查找方向 {欠款时间create_time | 还款时间update_time}
     */
    public String getMode() {
        return mode;
    }

    /**
     * @param mode 查找方向 {欠款时间create_time | 还款时间update_time}
     */
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * @return 当前页码
     */
    public Integer getPageNo() {
        return pageNo;
    }

    /**
     * @param pageNo 当前页码
     */
    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * @return 每页记录条数
     */
    public Integer getLimit() {
        return limit;
    }

    /**
     * @param limit 每页记录条数
     */
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    /**
     * @return 开始时间
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * @param startTime 开始时间
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * @return 结束时间
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * @param endTime 结束时间
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
