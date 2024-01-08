package cn.peyton.plum.mall.mapper.product;

import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.mall.pojo.product.ShopCouponMember;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;
import java.util.List;

/**
 * <h3> 优惠券会员(关联优惠券与会员) Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public interface ShopCouponMemberMapper extends IBaseMapper<Long, ShopCouponMember> {

    /**
     * <h4>查找 当前 用户 可用的优惠券</h4>
     * @param shareId 用户主键
     * @param shareType 用户类型
     * @return 优惠券会员对象集合
     */
    List<ShopCouponMember> selectUsedByShareIdAndType(Long shareId, Integer shareType);

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
    List<ShopCouponMember> selectByUseableOrAll(Long shareId, Integer shareType, BigDecimal price, Integer currentTime, PageQuery page);

    /**
     * <h4>判断是否关联优惠券</h4>
     * @param couponId 优惠券Id
     * @return 返回的条数 > 0 表示 有关联(不能编辑|删除)
     */
    @Select("select count(id) from tb_shop_coupon_member where coupon_id = #{couponId}")
    int isJoinCoupon(Long couponId);

    /**
     * <h4>判断当前优惠券是否可用</h4>
     * <pre>
     *     判断条件:
     *     status = 1  used = 0
     * </pre>
     * @param couponId 优惠券Id
     * @param shareId 用户Id
     * @param shareType 用户类型
     * @return 受影响的行数 > 0 表示可用
     */
    @Select("select count(id) from tb_shop_coupon_member where status = 1 and coupon_id = #{couponId}" +
            " and share_id = #{shareId} and share_type = #{shareType} and used = 0")
    int isUsed(Long couponId,Long shareId,Integer shareType);

    /**
     * <h4>更新已使用状态</h4>
     * @param couponId 优惠券Id
     * @param shareId 用户Id
     * @param shareType 用户类型
     * @return 受影响的行数 > 0 表示更新成功
     */
    @Update("update tb_shop_coupon_member set used = 1,status = 0 where coupon_id = #{couponId}" +
            " and share_id = #{shareId} and share_type = #{shareType} ")
    int upUsed(Long couponId, Long shareId, Integer shareType);

    // ==================================== new create method ==================================== //


}
