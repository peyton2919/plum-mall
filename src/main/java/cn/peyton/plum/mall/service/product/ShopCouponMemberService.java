package cn.peyton.plum.mall.service.product;

import cn.peyton.plum.core.inf.service.base.IRealizeService;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.mall.param.product.ShopCouponMemberParam;
import cn.peyton.plum.mall.pojo.product.ShopCouponMember;

import java.math.BigDecimal;
import java.util.List;

/**
 * <h3> 优惠券会员(关联优惠券与会员) Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
public interface ShopCouponMemberService extends IRealizeService<Long, ShopCouponMember, ShopCouponMemberParam> {

    /**
     * <h4>当前用户所有优惠券</h4>
     * <pre>
     *     当 price 有值时, 获取可用的优惠券:
     *      条件 {scm.share_id = #{shareId},scm.share_type = #{shareType}, and end_time &lt;= #{currentTime}
     *          #{price} &gt; sc.min_price, #{currentTime} &gt; sc.start_time, sc.status &lt; 3, scm.status = 1,scm.used = 0}
     *     当 price 无值时, 获取所有优惠券:(含过期、不可用,已使用)
     *       条件 {scm.share_id = #{shareId},scm.share_type = #{shareType}, and end_time &lt;= #{currentTime}}
     * </pre>
     * @param shareId 用户Id
     * @param shareType 用户类型
     * @param price 当前单价
     * @param currentTime 当前时间
     * @param page 当前 price 有值时, page = null
     * @return 优惠券会员对象集合
     */
    List<ShopCouponMemberParam> findByUseableOrAll(Long shareId, Integer shareType, BigDecimal price, Integer currentTime, PageQuery page);

    /**
     * <h4>判断是否关联优惠券</h4>
     * @param couponId 优惠券Id
     * @return true 表示 有关联(不能编辑|删除)
     */
    Boolean isJoinCoupon(Long couponId);

    /**
     * <h4>判断当前优惠券是否可用</h4>
     * <pre>
     *     判断条件:
     *     status = 1  used = 0
     * </pre>
     * @param couponId 优惠券Id
     * @param shareId 用户Id
     * @param shareType 用户类型
     * @return true 表示可用
     */
    Boolean isUsed(Long couponId,Long shareId,Integer shareType);

    /**
     * <h4>更新已使用状态</h4>
     * @param couponId 优惠券Id
     * @param shareId 用户Id
     * @param shareType 用户类型
     * @return true 表示更新成功
     */
    Boolean upUsed(Long couponId, Long shareId, Integer shareType);
}
