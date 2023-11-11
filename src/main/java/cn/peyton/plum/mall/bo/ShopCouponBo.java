package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.ShopCouponParam;
import cn.peyton.plum.mall.pojo.ShopCoupon;

/**
 * <h3> 优惠券 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class ShopCouponBo extends BaseConvertBo<ShopCoupon, ShopCouponParam> {

    @Override
    public ShopCouponParam compat(ShopCoupon info) {
        return new ShopCouponParam().compat(info);
    }

    @Override
    public ShopCoupon convert(ShopCouponParam info) {
        return info.convert();
    }
}
