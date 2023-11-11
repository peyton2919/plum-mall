package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.ShippingTemplatesValueParam;
import cn.peyton.plum.mall.pojo.ShippingTemplatesValue;

/**
 * <h3> 运费 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class ShippingTemplatesValueBo extends BaseConvertBo<ShippingTemplatesValue, ShippingTemplatesValueParam> {

    @Override
    public ShippingTemplatesValueParam compat(ShippingTemplatesValue info) {
        return new ShippingTemplatesValueParam().compat(info);
    }

    @Override
    public ShippingTemplatesValue convert(ShippingTemplatesValueParam info) {
        return info.convert();
    }
}
