package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.product.ShopCouponMemberParam;
import cn.peyton.plum.mall.pojo.product.ShopCouponMember;

/**
 * <h3> 优惠券会员(关联优惠券与会员) 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class ShopCouponMemberBo extends BaseConvertBo<ShopCouponMember, ShopCouponMemberParam> {

    @Override
    public ShopCouponMemberParam compat(ShopCouponMember info) {
        return new ShopCouponMemberParam().compat(info);
    }

    @Override
    public ShopCouponMember convert(ShopCouponMemberParam info) {
        return info.convert();
    }
}
