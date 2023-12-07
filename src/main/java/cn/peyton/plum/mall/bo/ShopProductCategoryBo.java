package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.product.ShopProductCategoryParam;
import cn.peyton.plum.mall.pojo.product.ShopProductCategory;

/**
 * <h3> 商品与商品分类关联 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class ShopProductCategoryBo extends BaseConvertBo<ShopProductCategory, ShopProductCategoryParam> {

    @Override
    public ShopProductCategoryParam compat(ShopProductCategory info) {
        return new ShopProductCategoryParam().compat(info);
    }

    @Override
    public ShopProductCategory convert(ShopProductCategoryParam info) {
        return info.convert();
    }
}
