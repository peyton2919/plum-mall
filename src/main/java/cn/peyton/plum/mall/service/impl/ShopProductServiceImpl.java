package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractAppRealizeService;
import cn.peyton.plum.mall.bo.ShopProductBo;
import cn.peyton.plum.mall.mapper.ShopProductMapper;
import cn.peyton.plum.mall.param.ShopProductParam;
import cn.peyton.plum.mall.pojo.ShopProduct;
import cn.peyton.plum.mall.service.ShopProductService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 商品信息 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("shopProductService")
public class ShopProductServiceImpl extends AbstractAppRealizeService<Long, ShopProduct, ShopProductParam> implements ShopProductService {
    @Resource
    private ShopProductMapper shopProductMapper;

    @Override
    public BaseConvertBo<ShopProduct, ShopProductParam> initBo() {
        return new ShopProductBo();
    }

    @Override
    public IBaseMapper<Long, ShopProduct> initMapper() {
        return shopProductMapper;
    }

}
