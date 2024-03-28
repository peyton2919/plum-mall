package cn.peyton.plum.mall.service.join.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.RealizeService;
import cn.peyton.plum.mall.bo.ShippingTemplatesBo;
import cn.peyton.plum.mall.mapper.join.ShippingTemplatesMapper;
import cn.peyton.plum.mall.param.join.ShippingTemplatesParam;
import cn.peyton.plum.mall.pojo.join.ShippingTemplates;
import cn.peyton.plum.mall.service.join.ShippingTemplatesService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 运费模板 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("shippingTemplatesService")
public class ShippingTemplatesServiceImpl extends RealizeService<Integer, ShippingTemplates, ShippingTemplatesParam> implements ShippingTemplatesService {
    @Resource
    private ShippingTemplatesMapper shippingTemplatesMapper;

    @Override
    public BaseConvertBo<ShippingTemplates, ShippingTemplatesParam> bo() {
        return new ShippingTemplatesBo();
    }

    @Override
    public IBaseMapper<Integer, ShippingTemplates> mapper() {
        return shippingTemplatesMapper;
    }

    public ShippingTemplatesServiceImpl() {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }
}
