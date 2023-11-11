package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.ShopCategoryParam;
import cn.peyton.plum.mall.pojo.ShopCategory;

/**
 * <h3> 商品分类 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class ShopCategoryBo extends BaseConvertBo<ShopCategory, ShopCategoryParam> {

    @Override
    public ShopCategoryParam compat(ShopCategory info) {
        return new ShopCategoryParam().compat(info);
    }

    @Override
    public ShopCategory convert(ShopCategoryParam info) {
        return info.convert();
    }
}
