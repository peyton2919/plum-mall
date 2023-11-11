package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.ShopOrderParam;
import cn.peyton.plum.mall.pojo.ShopOrder;

/**
 * <h3> 订单 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class ShopOrderBo extends BaseConvertBo<ShopOrder, ShopOrderParam> {

    @Override
    public ShopOrderParam compat(ShopOrder info) {
        return new ShopOrderParam().compat(info);
    }

    @Override
    public ShopOrder convert(ShopOrderParam info) {
        return info.convert();
    }
}
