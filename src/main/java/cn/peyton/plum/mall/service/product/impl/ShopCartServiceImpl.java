package cn.peyton.plum.mall.service.product.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.core.utils.LogUtils;
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
    private String TABLE_NAME = "tb_shop_cart";
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

    @Override
    public Boolean upDelete(Long id) {
        int res = shopCartMapper.updateDeleteStatus(TABLE_NAME, id);
        if (res > 0) {
            if (enabledCache) {
                LogUtils.info("购物车删除操作清空缓存");
                removeCache();
            }
            return true;
        }
        return false;
    }

    @Override
    public ShopCartParam findByShareId(Long shareId, Integer shareType) {
        String key = keyPrefix + "_" + shareId + "_" + shareType;
        if (enabledCache) {
            Object obj = cache.get(key);
            if (null != obj) {
                System.out.println("从缓存中获取到值, key=" + key);
                return (ShopCartParam) obj;
            }
        }
        ShopCart result = shopCartMapper.selectByShareId(shareId, shareType);
        if (null != result) {
            ShopCartParam param = initBo().compat(result);
            if (enabledCache) {
                System.out.println("获取到的数据存入缓存,key=" + key);
                cache.put(key,param);
            }
            return param;
        }
        return new ShopCartParam();
    }
}
