package cn.peyton.plum.mall.pojo.product;


import java.io.Serializable;

/**
 * <h3> 优惠券会员(关联优惠券与会员) 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public class ShopCouponMember implements Serializable {
    /**
     *
     */
    private Long id;
    /**
     * 优惠券id
     */
    private Long couponId;
    /**
     * 用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)
     */
    private Long shareId;
    /**
     * 用户类型 默认: 0 会员、1 顾客 2 供应商、3 用户 4 员工 5 超级管理员
     */
    private Integer shareType;
    /**
     * 是否已使用 默认: 0未使用 1已使用
     */
    private Integer used;
    /**
     * 是否可用,默认: 1 可用;0 不可用;2 删除;
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Integer createTime;
    /** 优惠券对象 */
    private ShopCoupon shopCoupon;
    //================================== Constructor =======================================//
    public ShopCouponMember() {
        if (null == shopCoupon) {shopCoupon = new ShopCoupon(); }
    }
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
     * @param couponId 优惠券id
     */
    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    /**
     * @return 优惠券id
     */
    public Long getCouponId() {
        return couponId;
    }

    /**
     * @param shareId 用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)
     */
    public void setShareId(Long shareId) {
        this.shareId = shareId;
    }

    /**
     * @return 用户ID(包含 : 会员Id 、 供应商Id 、 员工Id等, 配合share_type一起使用)
     */
    public Long getShareId() {
        return shareId;
    }

    /**
     * @param shareType 用户类型 默认: 0 会员、1 顾客 2 供应商、3 用户 4 员工 5 超级管理员
     */
    public void setShareType(Integer shareType) {
        this.shareType = shareType;
    }

    /**
     * @return 用户类型 默认: 0 会员、1 顾客 2 供应商、3 用户 4 员工 5 超级管理员
     */
    public Integer getShareType() {
        return shareType;
    }

    /**
     * @param used 是否已使用 默认: 0未使用 1已使用
     */
    public void setUsed(Integer used) {
        this.used = used;
    }

    /**
     * @return 是否已使用 默认: 0未使用 1已使用
     */
    public Integer getUsed() {
        return used;
    }

    /**
     * @param status 是否可用,默认: 1 可用;0 不可用;2 删除;
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return 是否可用, 默认: 1 可用;0 不可用;2 删除;
     */
    public Integer getStatus() {
        return status;
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
     * @return 优惠券对象
     */
    public ShopCoupon getShopCoupon() {
        return shopCoupon;
    }

    /**
     * @param shopCoupon 优惠券对象
     */
    public void setShopCoupon(ShopCoupon shopCoupon) {
        this.shopCoupon = shopCoupon;
    }
}
