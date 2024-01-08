package cn.peyton.plum.mall.param.product;

import cn.peyton.plum.core.anno.img.ImageHostPath;
import cn.peyton.plum.core.utils.DateUtils;
import cn.peyton.plum.mall.pojo.product.ShopOrderRefund;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <h3> 订单退款 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:24
 * @version 1.0.0
 * </pre>
 */
@ImageHostPath(name = "imgs")
public class ShopOrderRefundParam implements Serializable {
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
    private String createTime;
    /**
     * 更新时间
     */
    private String updateTime;

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
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * @return 创建时间
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * @param updateTime 更新时间
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return 更新时间
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * <h4>对象转成ShopOrderRefund对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,imgs,explain,reason,noReason,refundPrice,createTime,updateTime]
     * </pre>
     */
    public ShopOrderRefund convert() {
        ShopOrderRefund shopOrderRefund = new ShopOrderRefund();
        shopOrderRefund.setId(id);
        shopOrderRefund.setImgs(imgs);
        shopOrderRefund.setExplain(explain);
        shopOrderRefund.setReason(reason);
        shopOrderRefund.setNoReason(noReason);
        shopOrderRefund.setRefundPrice(refundPrice);
        shopOrderRefund.setCreateTime(DateUtils.dateToTimestamp(createTime));
        shopOrderRefund.setUpdateTime(DateUtils.dateToTimestamp(updateTime));
        return shopOrderRefund;
    }

    /**
     * <h4>ShopOrderRefund对象转成ShopOrderRefundParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,imgs,explain,reason,noReason,refundPrice,createTime,updateTime]
     * </pre>
     */
    public ShopOrderRefundParam compat(ShopOrderRefund shopOrderRefund) {
        if (null == shopOrderRefund) {
            return new ShopOrderRefundParam();
        }
        this.setId(shopOrderRefund.getId());
        this.setImgs(shopOrderRefund.getImgs());
        this.setExplain(shopOrderRefund.getExplain());
        this.setReason(shopOrderRefund.getReason());
        this.setNoReason(shopOrderRefund.getNoReason());
        this.setRefundPrice(shopOrderRefund.getRefundPrice());
        this.setCreateTime(DateUtils.timestampToStrDate(shopOrderRefund.getCreateTime()));
        this.setUpdateTime(DateUtils.timestampToStrDate(shopOrderRefund.getUpdateTime()));
        return this;
    }
}
