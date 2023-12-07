package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.product.ShopProductRuleParam;
import cn.peyton.plum.mall.pojo.product.ShopProductRule;

/**
 * <h3> 商品规格--(规则) 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class ShopProductRuleBo extends BaseConvertBo<ShopProductRule, ShopProductRuleParam> {

    @Override
    public ShopProductRuleParam compat(ShopProductRule info) {
        return new ShopProductRuleParam().compat(info);
    }

    @Override
    public ShopProductRule convert(ShopProductRuleParam info) {
        return info.convert();
    }
}
