package cn.peyton.plum.mall.param.product;

import cn.peyton.plum.core.utils.DateUtils;
import cn.peyton.plum.core.validator.constraints.Length;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.core.validator.constraints.Size;
import cn.peyton.plum.mall.pojo.product.ShopCoupon;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <h3> 优惠券 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:24
 * @version 1.0.0
 * </pre>
 */
public class ShopCouponParam implements Serializable {
    /**
     *
     */
    private Long id;
    /**
     * 优惠券名称
     */
    @NotBlank(message = "优惠券名称不能为空")
    @Length(min = 2,max = 40)
    private String name;
    /**
     * 类型, 默认: 0 固定金额 1 百分比(与value配合使用)
     */
    @Size(min = 0,max = 1)
    private Integer type;
    /**
     * 折扣值，根据 type 不同 含义不同
     */
    @Min(message = "金额不能小于0")
    private BigDecimal value;
    /**
     * 备注
     */
    @Length(min = 1,max = 250)
    private String remark;
    /**
     * 总数
     */
    @Min(value = 1,message = "最小数量不能小于1")
    private Integer total;
    /**
     * 已使用数量
     */
    private Integer used;
    /**
     * 最低价格
     */
    @Min(message = "金额不能小于0")
    private BigDecimal minPrice;
    /**
     * 最低价格
     */
    private BigDecimal maxPrice;
    /**
     * 开始时间
     */
    private String startTime;
    /**
     * 结束时间
     */
    private String endTime;
    /**
     * 优惠券是否生效:默认 1 {0不生效 1生效 2删除}
     */
    @Size(min = 0,max = 2)
    private Integer status;
    /**
     * 排序取值范围0~9999，默认为0; 按大到小排序
     */
    @Size(min = 0,max = 9999)
    private Short seq;
    /**
     * 创建时间
     */
    private String createTime;

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
     * @param name 优惠券名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return 优惠券名称
     */
    public String getName() {
        return name;
    }

    /**
     * @param type 类型, 默认: 0 固定金额 1 百分比(与value配合使用)
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @return 类型, 默认: 0 固定金额 1 百分比(与value配合使用)
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param value 折扣值，根据 type 不同 含义不同
     */
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    /**
     * @return 折扣值，根据 type 不同 含义不同
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param total 总数
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * @return 总数
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * @param used 已使用数量
     */
    public void setUsed(Integer used) {
        this.used = used;
    }

    /**
     * @return 已使用数量
     */
    public Integer getUsed() {
        return used;
    }

    /**
     * @param minPrice 最低价格
     */
    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    /**
     * @return 最低价格
     */
    public BigDecimal getMinPrice() {
        return minPrice;
    }

    /**
     * @param maxPrice 最低价格
     */
    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    /**
     * @return 最低价格
     */
    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    /**
     * @param startTime 开始时间
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * @return 开始时间
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * @param endTime 结束时间
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * @return 结束时间
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * @param status 优惠券是否生效:默认 1 {0不生效 1生效 2删除}
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return 优惠券是否生效:默认 1 {0不生效 1生效 2删除}
     */
    public Integer getStatus() {
        return status;
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
     * <h4>对象转成ShopCoupon对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,name,type,value,remark,total,used,minPrice,maxPrice,startTime,endTime,status,seq,createTime]
     * </pre>
     */
    public ShopCoupon convert() {
        ShopCoupon shopCoupon = new ShopCoupon();
        shopCoupon.setId(id);
        shopCoupon.setName(name);
        shopCoupon.setType(type);
        shopCoupon.setValue(value);
        shopCoupon.setRemark(remark);
        shopCoupon.setTotal(total);
        shopCoupon.setUsed(used);
        shopCoupon.setMinPrice(minPrice);
        shopCoupon.setMaxPrice(maxPrice);
        shopCoupon.setStartTime(DateUtils.dateToTimestamp(startTime));
        shopCoupon.setEndTime(DateUtils.dateToTimestamp(endTime));
        shopCoupon.setStatus(status);
        shopCoupon.setSeq(seq);
        shopCoupon.setCreateTime(DateUtils.dateToTimestamp(createTime));
        return shopCoupon;
    }

    /**
     * <h4>ShopCoupon对象转成ShopCouponParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,name,type,value,remark,total,used,minPrice,maxPrice,startTime,endTime,status,seq,createTime]
     * </pre>
     */
    public ShopCouponParam compat(ShopCoupon shopCoupon) {
        if (null == shopCoupon) {
            return new ShopCouponParam();
        }
        this.setId(shopCoupon.getId());
        this.setName(shopCoupon.getName());
        this.setType(shopCoupon.getType());
        this.setValue(shopCoupon.getValue());
        this.setRemark(shopCoupon.getRemark());
        this.setTotal(shopCoupon.getTotal());
        this.setUsed(shopCoupon.getUsed());
        this.setMinPrice(shopCoupon.getMinPrice());
        this.setMaxPrice(shopCoupon.getMaxPrice());
        this.setStartTime(DateUtils.timestampToStrDate(shopCoupon.getStartTime()));
        this.setEndTime(DateUtils.timestampToStrDate(shopCoupon.getEndTime()));
        this.setStatus(shopCoupon.getStatus());
        this.setSeq(shopCoupon.getSeq());
        this.setCreateTime(DateUtils.timestampToStrDate(shopCoupon.getCreateTime()));
        return this;
    }
}
