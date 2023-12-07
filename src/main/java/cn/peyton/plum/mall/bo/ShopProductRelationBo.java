package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.product.ShopProductRelationParam;
import cn.peyton.plum.mall.pojo.product.ShopProductRelation;

/**
 * <h3> 商品点赞和收藏 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class ShopProductRelationBo extends BaseConvertBo<ShopProductRelation, ShopProductRelationParam> {

    @Override
    public ShopProductRelationParam compat(ShopProductRelation info) {
        return new ShopProductRelationParam().compat(info);
    }

    @Override
    public ShopProductRelation convert(ShopProductRelationParam info) {
        return info.convert();
    }
}
