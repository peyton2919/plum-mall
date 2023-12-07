package cn.peyton.plum.mall.service.product.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.mall.bo.ShopOrderItemBo;
import cn.peyton.plum.mall.mapper.product.ShopOrderItemMapper;
import cn.peyton.plum.mall.param.product.ShopOrderItemParam;
import cn.peyton.plum.mall.pojo.product.ShopOrderItem;
import cn.peyton.plum.mall.service.product.ShopOrderItemService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 订单--项 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("shopOrderItemService")
public class ShopOrderItemServiceImpl extends AbstractRealizeService<Long, ShopOrderItem, ShopOrderItemParam> implements ShopOrderItemService {
    @Resource
    private ShopOrderItemMapper shopOrderItemMapper;

    @Override
    public BaseConvertBo<ShopOrderItem, ShopOrderItemParam> initBo() {
        return new ShopOrderItemBo();
    }

    @Override
    public IBaseMapper<Long, ShopOrderItem> initMapper() {
        return shopOrderItemMapper;
    }

    public ShopOrderItemServiceImpl() {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }
}
