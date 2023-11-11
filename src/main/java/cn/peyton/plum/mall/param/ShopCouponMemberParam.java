package cn.peyton.plum.mall.param;


import cn.peyton.plum.mall.pojo.ShopCouponMember;

import java.io.Serializable;

/**
 * <h3> 优惠券会员(关联优惠券与会员) 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:24
 * @version 1.0.0
 * </pre>
 */
public class ShopCouponMemberParam implements Serializable {
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
     * 用户类型 ,默认 0 会员、1 供应商、2 员工
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
     * @param shareType 用户类型 ,默认 0 会员、1 供应商、2 员工
     */
    public void setShareType(Integer shareType) {
        this.shareType = shareType;
    }

    /**
     * @return 用户类型 ,默认 0 会员、1 供应商、2 员工
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
     * <h4>对象转成ShopCouponMember对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,couponId,shareId,shareType,used,status,createTime]
     * </pre>
     */
    public ShopCouponMember convert() {
        ShopCouponMember shopCouponMember = new ShopCouponMember();
        shopCouponMember.setId(id);
        shopCouponMember.setCouponId(couponId);
        shopCouponMember.setShareId(shareId);
        shopCouponMember.setShareType(shareType);
        shopCouponMember.setUsed(used);
        shopCouponMember.setStatus(status);
        shopCouponMember.setCreateTime(createTime);
        return shopCouponMember;
    }

    /**
     * <h4>ShopCouponMember对象转成ShopCouponMemberParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,couponId,shareId,shareType,used,status,createTime]
     * </pre>
     */
    public ShopCouponMemberParam compat(ShopCouponMember shopCouponMember) {
        if (null == shopCouponMember) {
            return new ShopCouponMemberParam();
        }
        this.setId(shopCouponMember.getId());
        this.setCouponId(shopCouponMember.getCouponId());
        this.setShareId(shopCouponMember.getShareId());
        this.setShareType(shopCouponMember.getShareType());
        this.setUsed(shopCouponMember.getUsed());
        this.setStatus(shopCouponMember.getStatus());
        this.setCreateTime(shopCouponMember.getCreateTime());
        return this;
    }
}
