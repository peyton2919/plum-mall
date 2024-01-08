package cn.peyton.plum.mall.service.product;

import cn.peyton.plum.core.inf.service.IBaseService;
import cn.peyton.plum.core.inf.service.IStatusService;
import cn.peyton.plum.mall.param.product.ShopCouponParam;
import cn.peyton.plum.mall.pojo.product.ShopCoupon;

import java.math.BigDecimal;

/**
 * <h3> 优惠券 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
public interface ShopCouponService extends IStatusService<Long>, IBaseService<Long, ShopCoupon, ShopCouponParam> {

    /**
     * <h4>判断优惠券是 (是否能使用) || (是否能领取)</h4>
     * <pre>
     *  true 用在优惠券使用时判断当前时间在 开始时间 ~ 结束时间 之中
     *  false 用在用户领取优惠券, 判断他的时间为 只要没结束,就可以领取(注:需有可用的优惠券的数量)
     * </pre>
     * @param id 主键
     * @param useable true 表示判断可使用; false 是否可领取{领取在还没开始之前领取}
     * @return true 可使用
     */
    boolean isUseableAndGet(Long id, Boolean useable, BigDecimal price);

    /**
     * <h4>判断可领取的优惠券数量</h4>
     * @param id 主键
     * @return true 表示 有可用的优惠券
     */
    boolean isReceive(Long id);

    /**
     * <h4>更新优惠券数量</h4>
     * @param id 主键
     * @return true 成功
     */
    Boolean updateUsed(Long id);

    /**
     * <h4>判断当前 优惠券 是否在有效的时间内</h4>
     * @param id 优惠券Id
     * @param currentTime 当前 时间
     * @return 记录 > 0  不允许 修改|删除
     */
    Boolean isEffective(Long id, Integer currentTime);

}
