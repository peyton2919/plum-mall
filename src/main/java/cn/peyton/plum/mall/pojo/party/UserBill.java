package cn.peyton.plum.mall.pojo.party;

import java.math.BigDecimal;

import java.io.Serializable;

/**
 * <h3> 会员账单{用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)} 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public class UserBill implements Serializable {
    /**
     * 用户账单id
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
     * 关联id
     */
    private String linkId;
    /**
     * 0 = 支出 1 = 获得
     */
    private Integer pm;
    /**
     * 账单标题
     */
    private String title;
    /**
     * 明细种类
     */
    private String category;
    /**
     * 明细类型(佣金等)
     */
    private String billType;
    /**
     * 明细数字
     */
    private BigDecimal num;
    /**
     * 剩余
     */
    private BigDecimal balance;
    /**
     * 说明
     */
    private String explain;
    /**
     * 0 = 带确定 1 = 有效 -1 = 无效
     */
    private Integer status;
    /**
     * 是否删除: 默认1(1：可用;0已删除)
     */
    private Integer isDel;
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
     * @param id 用户账单id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return 用户账单id
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
     * @param linkId 关联id
     */
    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    /**
     * @return 关联id
     */
    public String getLinkId() {
        return linkId;
    }

    /**
     * @param pm 0 = 支出 1 = 获得
     */
    public void setPm(Integer pm) {
        this.pm = pm;
    }

    /**
     * @return 0 = 支出 1 = 获得
     */
    public Integer getPm() {
        return pm;
    }

    /**
     * @param title 账单标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return 账单标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param category 明细种类
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return 明细种类
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param billType 明细类型(佣金等)
     */
    public void setBillType(String billType) {
        this.billType = billType;
    }

    /**
     * @return 明细类型(佣金等)
     */
    public String getBillType() {
        return billType;
    }

    /**
     * @param num 明细数字
     */
    public void setNum(BigDecimal num) {
        this.num = num;
    }

    /**
     * @return 明细数字
     */
    public BigDecimal getNum() {
        return num;
    }

    /**
     * @param balance 剩余
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * @return 剩余
     */
    public BigDecimal getBalance() {
        return balance;
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
     * @param status 0 = 带确定 1 = 有效 -1 = 无效
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return 0 = 带确定 1 = 有效 -1 = 无效
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param isDel 是否删除: 默认1(1：可用;0已删除)
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    /**
     * @return 是否删除: 默认1(1：可用;0已删除)
     */
    public Integer getIsDel() {
        return isDel;
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
