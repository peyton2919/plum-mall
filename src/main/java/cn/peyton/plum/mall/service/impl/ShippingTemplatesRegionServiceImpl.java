package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractAppRealizeService;
import cn.peyton.plum.mall.bo.ShippingTemplatesRegionBo;
import cn.peyton.plum.mall.mapper.ShippingTemplatesRegionMapper;
import cn.peyton.plum.mall.param.ShippingTemplatesRegionParam;
import cn.peyton.plum.mall.pojo.ShippingTemplatesRegion;
import cn.peyton.plum.mall.service.ShippingTemplatesRegionService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 运费地区模板 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("shippingTemplatesRegionService")
public class ShippingTemplatesRegionServiceImpl extends AbstractAppRealizeService<Integer, ShippingTemplatesRegion, ShippingTemplatesRegionParam> implements ShippingTemplatesRegionService {
    @Resource
    private ShippingTemplatesRegionMapper shippingTemplatesRegionMapper;

    @Override
    public BaseConvertBo<ShippingTemplatesRegion, ShippingTemplatesRegionParam> initBo() {
        return new ShippingTemplatesRegionBo();
    }

    @Override
    public IBaseMapper<Integer, ShippingTemplatesRegion> initMapper() {
        return shippingTemplatesRegionMapper;
    }

}
