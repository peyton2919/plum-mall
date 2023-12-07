package cn.peyton.plum.mall.service.product.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.mall.bo.ShopCartBo;
import cn.peyton.plum.mall.mapper.product.ShopCartMapper;
import cn.peyton.plum.mall.param.product.ShopCartParam;
import cn.peyton.plum.mall.pojo.product.ShopCart;
import cn.peyton.plum.mall.service.product.ShopCartService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 购物车 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("shopCartService")
public class ShopCartServiceImpl extends AbstractRealizeService<Long, ShopCart, ShopCartParam> implements ShopCartService {
    @Resource
    private ShopCartMapper shopCartMapper;

    @Override
    public BaseConvertBo<ShopCart, ShopCartParam> initBo() {
        return new ShopCartBo();
    }

    @Override
    public IBaseMapper<Long, ShopCart> initMapper() {
        return shopCartMapper;
    }

    public ShopCartServiceImpl() {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }
}
