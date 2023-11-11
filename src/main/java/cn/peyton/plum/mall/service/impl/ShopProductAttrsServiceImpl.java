package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractAppRealizeService;
import cn.peyton.plum.mall.bo.ShopProductAttrsBo;
import cn.peyton.plum.mall.mapper.ShopProductAttrsMapper;
import cn.peyton.plum.mall.param.ShopProductAttrsParam;
import cn.peyton.plum.mall.pojo.ShopProductAttrs;
import cn.peyton.plum.mall.service.ShopProductAttrsService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 商品属性关联 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("shopProductAttrsService")
public class ShopProductAttrsServiceImpl extends AbstractAppRealizeService<Long, ShopProductAttrs, ShopProductAttrsParam> implements ShopProductAttrsService {
    @Resource
    private ShopProductAttrsMapper shopProductAttrsMapper;

    @Override
    public BaseConvertBo<ShopProductAttrs, ShopProductAttrsParam> initBo() {
        return new ShopProductAttrsBo();
    }

    @Override
    public IBaseMapper<Long, ShopProductAttrs> initMapper() {
        return shopProductAttrsMapper;
    }

}
