package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.ShopProductSkuDetailParam;
import cn.peyton.plum.mall.pojo.ShopProductSkuDetail;

/**
 * <h3> 商品规格详细 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class ShopProductSkuDetailBo extends BaseConvertBo<ShopProductSkuDetail, ShopProductSkuDetailParam> {

    @Override
    public ShopProductSkuDetailParam compat(ShopProductSkuDetail info) {
        return new ShopProductSkuDetailParam().compat(info);
    }

    @Override
    public ShopProductSkuDetail convert(ShopProductSkuDetailParam info) {
        return info.convert();
    }
}
