package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.join.ShippingTemplatesRegionParam;
import cn.peyton.plum.mall.pojo.join.ShippingTemplatesRegion;

/**
 * <h3> 运费地区模板 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class ShippingTemplatesRegionBo extends BaseConvertBo<ShippingTemplatesRegion, ShippingTemplatesRegionParam> {

    @Override
    public ShippingTemplatesRegionParam compat(ShippingTemplatesRegion info) {
        return new ShippingTemplatesRegionParam().compat(info);
    }

    @Override
    public ShippingTemplatesRegion convert(ShippingTemplatesRegionParam info) {
        return info.convert();
    }
}
