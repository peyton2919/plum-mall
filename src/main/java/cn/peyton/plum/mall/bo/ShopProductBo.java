package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.product.ShopProductParam;
import cn.peyton.plum.mall.pojo.product.ShopProduct;

/**
 * <h3> 商品信息 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class ShopProductBo extends BaseConvertBo<ShopProduct, ShopProductParam> {

    @Override
    public ShopProductParam compat(ShopProduct info) {
        return new ShopProductParam().compat(info);
    }

    @Override
    public ShopProduct convert(ShopProductParam info) {
        return info.convert();
    }
}
