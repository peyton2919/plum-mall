package cn.peyton.plum.mall.service.product.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.RealizeService;
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
public class ShopCartServiceImpl extends RealizeService<Long, ShopCart, ShopCartParam> implements ShopCartService {
    private String TABLE_NAME = "tb_shop_cart";
    @Resource
    private ShopCartMapper shopCartMapper;

    @Override
    public BaseConvertBo<ShopCart, ShopCartParam> bo() {
        return new ShopCartBo();
    }

    @Override
    public IBaseMapper<Long, ShopCart> mapper() {
        return shopCartMapper;
    }

    public ShopCartServiceImpl() {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }

    @Override
    public Boolean upDelete(Long id) {
        int res = shopCartMapper.updateDeleteStatus(TABLE_NAME, id);
        if (res > 0) {
            clearCache("删除购物车");
            return true;
        }
        return false;
    }

    @Override
    public ShopCartParam findByShareId(Long shareId, Integer shareType) {
        String key = keyPrefix + "_" + shareId + "_" + shareType;
        Object obj = getCache(key);
        if (null == obj) {
            ShopCartParam param = bo().compat(shopCartMapper.selectByShareId(shareId, shareType));
            saveCache(key,param);
            return param;
        }
        return (ShopCartParam) obj;
    }

    @Override
    public Boolean updateCart(Long shareId, Integer shareType, String expand) {
        int result = shopCartMapper.updateCart(shareId, shareType, expand);
        if (result > 0) {
            clearCache("更新购物车");
            return true;
        }
        return false;
    }
}
