package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.join.ShippingTemplatesParam;
import cn.peyton.plum.mall.pojo.join.ShippingTemplates;

/**
 * <h3> 运费模板 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class ShippingTemplatesBo extends BaseConvertBo<ShippingTemplates, ShippingTemplatesParam> {

    @Override
    public ShippingTemplatesParam compat(ShippingTemplates info) {
        return new ShippingTemplatesParam().compat(info);
    }

    @Override
    public ShippingTemplates convert(ShippingTemplatesParam info) {
        return info.convert();
    }
}
