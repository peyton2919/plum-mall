package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.product.ShopSkuParam;
import cn.peyton.plum.mall.pojo.product.ShopSku;

/**
 * <h3> 商品规格 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class ShopSkuBo extends BaseConvertBo<ShopSku, ShopSkuParam> {

    @Override
    public ShopSkuParam compat(ShopSku info) {
        return new ShopSkuParam().compat(info);
    }

    @Override
    public ShopSku convert(ShopSkuParam info) {
        return info.convert();
    }
}
