package cn.peyton.plum.mall.mapper.product;

import cn.peyton.plum.core.inf.mapper.IBaseMapper;
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
}
