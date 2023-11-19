package cn.peyton.plum.mall.pojo;

import java.math.BigDecimal;

import java.io.Serializable;

/**
 * <h3> 用户分佣账单{用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)} 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public class UserCommissionBill implements Serializable {
    /**
     *
     */
    private Long id;
    /**
     * 用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)
     */
    private Long shaerId;
    /**
     * 用户类型 默认: 0 会员、1 顾客 2 供应商、3 用户 4 员工 5 超级管理员
     */
    private Integer shaerType;
    /**
     * 等级：1一级佣金，2二级佣金
     */
    private Boolean level;
    /**
     * 订单ID
     */
    private Integer orderId;
    /**
     * 佣金
     */
    private BigDecimal commission;
    /**
     * 状态 0冻结中，1生效，-1失效
     */
    private Boolean status;
    /**
     * 说明
     */
    private String explain;
    /**
     * 创建时间
     */
    private Integer createTime;

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
     * @param shaerId 用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)
     */
    public void setShaerId(Long shaerId) {
        this.shaerId = shaerId;
    }

    /**
     * @return 用户ID(包含 : 会员Id 、 供应商Id 、 员工Id等, 配合share_type一起使用)
     */
    public Long getShaerId() {
        return shaerId;
    }

    /**
     * @param shaerType 用户类型 默认: 0 会员、1 顾客 2 供应商、3 用户 4 员工 5 超级管理员
     */
    public void setShaerType(Integer shaerType) {
        this.shaerType = shaerType;
    }

    /**
     * @return 用户类型 默认: 0 会员、1 顾客 2 供应商、3 用户 4 员工 5 超级管理员
     */
    public Integer getShaerType() {
        return shaerType;
    }

    /**
     * @param level 等级：1一级佣金，2二级佣金
     */
    public void setLevel(Boolean level) {
        this.level = level;
    }

    /**
     * @return 等级：1一级佣金，2二级佣金
     */
    public Boolean getLevel() {
        return level;
    }

    /**
     * @param orderId 订单ID
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * @return 订单ID
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * @param commission 佣金
     */
    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    /**
     * @return 佣金
     */
    public BigDecimal getCommission() {
        return commission;
    }

    /**
     * @param status 状态 0冻结中，1生效，-1失效
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * @return 状态 0冻结中，1生效，-1失效
     */
    public Boolean getStatus() {
        return status;
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
     * @param createTime 创建时间
     */
    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    /**
     * @return 创建时间
     */
    public Integer getCreateTime() {
        return createTime;
    }

}
