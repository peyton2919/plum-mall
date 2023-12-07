package cn.peyton.plum.mall.service.product.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.mall.bo.ShopProductSkuBo;
import cn.peyton.plum.mall.mapper.product.ShopProductSkuMapper;
import cn.peyton.plum.mall.param.product.ShopProductSkuParam;
import cn.peyton.plum.mall.pojo.product.ShopProductSku;
import cn.peyton.plum.mall.service.product.ShopProductSkuService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 商品规格关联 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("shopProductSkuService")
public class ShopProductSkuServiceImpl extends AbstractRealizeService<Long, ShopProductSku, ShopProductSkuParam> implements ShopProductSkuService {
    @Resource
    private ShopProductSkuMapper shopProductSkuMapper;

    @Override
    public BaseConvertBo<ShopProductSku, ShopProductSkuParam> initBo() {
        return new ShopProductSkuBo();
    }

    @Override
    public IBaseMapper<Long, ShopProductSku> initMapper() {
        return shopProductSkuMapper;
    }

    public ShopProductSkuServiceImpl () {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }

    @Override
    public boolean isExisted(ShopProductSkuParam param) {
        return shopProductSkuMapper.isExisted(param.convert()) > 0;
    }
}
