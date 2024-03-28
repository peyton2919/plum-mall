package cn.peyton.plum.mall.mapper.product;

import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.mall.pojo.product.ShopCoupon;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;
import java.util.List;

/**
 * <h3> 优惠券 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public interface ShopCouponMapper extends IBaseMapper<Long, ShopCoupon> {

    /**
     * <h4>判断优惠券是 (是否能使用) || (是否能领取)</h4>
     * <pre>
     *  true 用在优惠券使用时判断当前时间在 开始时间 ~ 结束时间 之中
     *  false 用在用户领取优惠券, 判断他的时间为 只要没结束,就可以领取(注:需有可用的优惠券的数量)
     * </pre>
     *
     * @param id          主键
     * @param useable     true 表示判断可使用; false 是否可领取{领取在还没开始之前领取}
     * @param currentTime 当前时间
     * @param price       当前金额 当useable 为 true时可用
     * @return 受影响的行数 > 0 可使用
     */
    int isUseableAndGet(Long id, Boolean useable, Integer currentTime, BigDecimal price);

    /**
     * <h>根据 Id 查找 优惠券对象</h>
     * @param id 主键
     * @return 优惠券对象
     */
    ShopCoupon selectByFKId(Long id);

    /**
     * <h4>获取可用的优惠券</h4>
     * <pre>
     *     条件 (status<3) and (total - used) > 0
     *           and end_time >= #{currentTime}
     * </pre>
     * @param currentTime
     * @return
     */
    List<ShopCoupon> selectByUsable(Integer currentTime);

    /**
     * <h4>获取当前可用优惠券</h4>
     * @param memberId 用户主键
     * @param total 金额
     * @param status 优惠券是否生效:默认 1 {0未开始 1生效 2领取中 3 已失效 4 已结束 删除}
     * @param used 是否已使用 默认: 0未使用 1已使用
     * @param currentDatetime 当前时间
     * @param condition 条件 （与 memberId 相连）
     * @param page 分页对象
     * @return
     */
    List<ShopCoupon> selectCurrentUsableCoupon(Long memberId, BigDecimal total, Integer status, Integer used, Integer currentDatetime,String condition, PageQuery page);

    /**
     * <h4>根据用户Id 查找可用的优惠卷</h4>
     * @param memberId 用户Id
     * @param page 分页
     * @return 对象
     */
    List<ShopCoupon> selectUsableCouponByMemberId(Long memberId, PageQuery page);

    /**
     * <h4>根据用户Id 查找 失效优惠卷</h4>
     * @param memberId 用户Id
     * @param status 优惠券状态: 0未开始 1生效 2领取中 3 已失效 4 已结束 删除
     * @param page 分页
     * @return 对象
     */
    List<ShopCoupon> selectUnusableCouponByMemberId(Long memberId, Integer status, PageQuery page);

    /**
     * <h4>根据用户Id 查找 已使用的优惠卷</h4>
     * @param memberId 用户Id
     * @param page 分页
     * @return 对象
     */
    List<ShopCoupon> selectUseCouponByMemberId(Long memberId, PageQuery page);
    // ==================================== new create method ==================================== //


    /**
     * <h4>判断可领取的优惠券数量</h4>
     * @param id 主键
     * @return 受影响的行数 > 0 表示 有可用的优惠券
     */
    @Select("select count(id) from tb_shop_coupon where id = #{id} and status < 3 and (total-used) > 0")
    int isReceive(Long id);

    /**
     * <h4>更新优惠券数量</h4>
     * @param id 主键
     * @return 受影响的行数 > 0 成功
     */
    @Update("update tb_shop_coupon set used = used +1 where id = #{id} and status < 3")
    int updateUsed(Long id);

    /**
     * <h4>判断当前 优惠券 是否在有效的时间内</h4>
     * @param id 优惠券Id
     * @param currentTime 当前 时间
     * @return 记录 > 0  不允许 修改|删除
     */
    @Select("SELECT COUNT(id) from tb_shop_coupon where id=#{id} and #{currentTime} > start_time and #{currentTime} < end_time")
    int isEffective(Long id, Integer currentTime);

    /**
     * <h4>获取当前可用的优惠券</h4>
     * @param memberId 用户主键
     * @param total 当前金额
     * @param status 状态
     * @param used 是否可用
     * @param currentDatetime 当前时间
     * @return
     */
    @Select("SELECT count(sc.id) from tb_shop_coupon sc,tb_shop_coupon_member scm where sc.id = scm.coupon_id and share_id = #{memberId} " +
            "and share_type= 0 and scm.status = #{status} and scm.used=#{used} and sc.min_price <= #{total} " +
            "and sc.start_time <= #{currentDatetime} and sc.end_time >=#{currentDatetime}")
    int selectCurrentUsableCouponCount(Long memberId, BigDecimal total, int status, int used, int currentDatetime);


}
