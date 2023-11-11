package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractAppRealizeService;
import cn.peyton.plum.mall.bo.ShopSkuBo;
import cn.peyton.plum.mall.mapper.ShopSkuMapper;
import cn.peyton.plum.mall.param.ShopSkuParam;
import cn.peyton.plum.mall.pojo.ShopSku;
import cn.peyton.plum.mall.service.ShopSkuService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 商品规格 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("shopSkuService")
public class ShopSkuServiceImpl extends AbstractAppRealizeService<Long, ShopSku, ShopSkuParam> implements ShopSkuService {
    @Resource
    private ShopSkuMapper shopSkuMapper;

    @Override
    public BaseConvertBo<ShopSku, ShopSkuParam> initBo() {
        return new ShopSkuBo();
    }

    @Override
    public IBaseMapper<Long, ShopSku> initMapper() {
        return shopSkuMapper;
    }

}
