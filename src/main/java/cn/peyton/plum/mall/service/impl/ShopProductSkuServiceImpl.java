package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractAppRealizeService;
import cn.peyton.plum.mall.bo.ShopProductSkuBo;
import cn.peyton.plum.mall.mapper.ShopProductSkuMapper;
import cn.peyton.plum.mall.param.ShopProductSkuParam;
import cn.peyton.plum.mall.pojo.ShopProductSku;
import cn.peyton.plum.mall.service.ShopProductSkuService;
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
public class ShopProductSkuServiceImpl extends AbstractAppRealizeService<Long, ShopProductSku, ShopProductSkuParam> implements ShopProductSkuService {
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

}
