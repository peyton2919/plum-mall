package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.ShopCartParam;
import cn.peyton.plum.mall.pojo.ShopCart;

/**
 * <h3> 购物车 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class ShopCartBo extends BaseConvertBo<ShopCart, ShopCartParam> {

    @Override
    public ShopCartParam compat(ShopCart info) {
        return new ShopCartParam().compat(info);
    }

    @Override
    public ShopCart convert(ShopCartParam info) {
        return info.convert();
    }
}
