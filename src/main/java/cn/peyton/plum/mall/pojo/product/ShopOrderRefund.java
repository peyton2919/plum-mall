package cn.peyton.plum.mall.pojo.product;

import java.math.BigDecimal;

import java.io.Serializable;

/**
 * <h3> 订单退款 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public class ShopOrderRefund implements Serializable {
    /**
     *
     */
    private Long id;
    /**
     * 退款图片{json格式}
     */
    private String imgs;
    /**
     * 退款用户说明
     */
    private String explain;
    /**
     * 退款原因
     */
    private String reason;
    /**
     * 不退款理由{json格式}
     */
    private String noReason;
    /**
     * 退款金额
     */
    private BigDecimal refundPrice;
    /**
     * 创建时间
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
     * @param imgs 退款图片{json格式}
     */
    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    /**
     * @return 退款图片{json格式}
     */
    public String getImgs() {
        return imgs;
    }

    /**
     * @param explain 退款用户说明
     */
    public void setExplain(String explain) {
        this.explain = explain;
    }

    /**
     * @return 退款用户说明
     */
    public String getExplain() {
        return explain;
    }

    /**
     * @param reason 退款原因
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * @return 退款原因
     */
    public String getReason() {
        return reason;
    }

    /**
     * @param noReason 不退款理由{json格式}
     */
    public void setNoReason(String noReason) {
        this.noReason = noReason;
    }

    /**
     * @return 不退款理由{json格式}
     */
    public String getNoReason() {
        return noReason;
    }

    /**
     * @param refundPrice 退款金额
     */
    public void setRefundPrice(BigDecimal refundPrice) {
        this.refundPrice = refundPrice;
    }

    /**
     * @return 退款金额
     */
    public BigDecimal getRefundPrice() {
        return refundPrice;
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
