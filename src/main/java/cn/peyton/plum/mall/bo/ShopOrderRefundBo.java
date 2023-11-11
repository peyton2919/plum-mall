package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.ShopOrderRefundParam;
import cn.peyton.plum.mall.pojo.ShopOrderRefund;

/**
 * <h3> 订单退款 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class ShopOrderRefundBo extends BaseConvertBo<ShopOrderRefund, ShopOrderRefundParam> {

    @Override
    public ShopOrderRefundParam compat(ShopOrderRefund info) {
        return new ShopOrderRefundParam().compat(info);
    }

    @Override
    public ShopOrderRefund convert(ShopOrderRefundParam info) {
        return info.convert();
    }
}
