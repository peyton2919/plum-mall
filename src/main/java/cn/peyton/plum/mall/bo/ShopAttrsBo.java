package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.ShopAttrsParam;
import cn.peyton.plum.mall.pojo.ShopAttrs;

/**
 * <h3> 商品属性 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class ShopAttrsBo extends BaseConvertBo<ShopAttrs, ShopAttrsParam> {

    @Override
    public ShopAttrsParam compat(ShopAttrs info) {
        return new ShopAttrsParam().compat(info);
    }

    @Override
    public ShopAttrs convert(ShopAttrsParam info) {
        return info.convert();
    }
}
