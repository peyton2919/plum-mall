package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.product.ShopOrderItemParam;
import cn.peyton.plum.mall.pojo.product.ShopOrderItem;

/**
 * <h3> 订单--项 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class ShopOrderItemBo extends BaseConvertBo<ShopOrderItem, ShopOrderItemParam> {

    @Override
    public ShopOrderItemParam compat(ShopOrderItem info) {
        return new ShopOrderItemParam().compat(info);
    }

    @Override
    public ShopOrderItem convert(ShopOrderItemParam info) {
        return info.convert();
    }
}
