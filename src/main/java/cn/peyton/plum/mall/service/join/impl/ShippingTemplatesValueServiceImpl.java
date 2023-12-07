package cn.peyton.plum.mall.service.join.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.mall.bo.ShippingTemplatesValueBo;
import cn.peyton.plum.mall.mapper.join.ShippingTemplatesValueMapper;
import cn.peyton.plum.mall.param.join.ShippingTemplatesValueParam;
import cn.peyton.plum.mall.pojo.join.ShippingTemplatesValue;
import cn.peyton.plum.mall.service.join.ShippingTemplatesValueService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 运费 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("shippingTemplatesValueService")
public class ShippingTemplatesValueServiceImpl extends AbstractRealizeService<Integer, ShippingTemplatesValue, ShippingTemplatesValueParam> implements ShippingTemplatesValueService {
    @Resource
    private ShippingTemplatesValueMapper shippingTemplatesValueMapper;

    @Override
    public BaseConvertBo<ShippingTemplatesValue, ShippingTemplatesValueParam> initBo() {
        return new ShippingTemplatesValueBo();
    }

    @Override
    public IBaseMapper<Integer, ShippingTemplatesValue> initMapper() {
        return shippingTemplatesValueMapper;
    }
    public ShippingTemplatesValueServiceImpl() {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }
}
