package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.product.ShopSkuValueParam;
import cn.peyton.plum.mall.pojo.product.ShopSkuValue;

/**
 * <h3> 商品规格 值 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
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
