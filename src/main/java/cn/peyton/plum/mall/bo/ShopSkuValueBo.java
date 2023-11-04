package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.ShopSkuValueParam;
import cn.peyton.plum.mall.pojo.ShopSkuValue;

/**
 * <h4></h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.mall.bo.ShopSkuValueBo
 * @date 2023年11月04日 9:00
 * @version 1.0.0
 * </pre>
 */
public class ShopSkuValueBo extends BaseConvertBo<ShopSkuValue, ShopSkuValueParam> {
    @Override
    public ShopSkuValueParam compat(ShopSkuValue info) {
        return new ShopSkuValueParam().compat(info);
    }

    @Override
    public ShopSkuValue convert(ShopSkuValueParam info) {
        return info.convert();
    }
}
