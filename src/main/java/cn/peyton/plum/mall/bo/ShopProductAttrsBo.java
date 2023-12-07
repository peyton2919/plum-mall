package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.product.ShopProductAttrsParam;
import cn.peyton.plum.mall.pojo.product.ShopProductAttrs;

/**
 * <h3> 商品属性关联 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class ShopProductAttrsBo extends BaseConvertBo<ShopProductAttrs, ShopProductAttrsParam> {

    @Override
    public ShopProductAttrsParam compat(ShopProductAttrs info) {
        return new ShopProductAttrsParam().compat(info);
    }

    @Override
    public ShopProductAttrs convert(ShopProductAttrsParam info) {
        return info.convert();
    }
}
