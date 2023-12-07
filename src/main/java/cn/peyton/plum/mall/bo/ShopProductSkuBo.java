package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.product.ShopProductSkuParam;
import cn.peyton.plum.mall.pojo.product.ShopProductSku;

/**
 * <h3> 商品规格关联 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class ShopProductSkuBo extends BaseConvertBo<ShopProductSku, ShopProductSkuParam> {

    @Override
    public ShopProductSkuParam compat(ShopProductSku info) {
        return new ShopProductSkuParam().compat(info);
    }

    @Override
    public ShopProductSku convert(ShopProductSkuParam info) {
        return info.convert();
    }
}
