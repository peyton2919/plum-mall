package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractAppRealizeService;
import cn.peyton.plum.mall.bo.ShopOrderBo;
import cn.peyton.plum.mall.mapper.ShopOrderMapper;
import cn.peyton.plum.mall.param.ShopOrderParam;
import cn.peyton.plum.mall.pojo.ShopOrder;
import cn.peyton.plum.mall.service.ShopOrderService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 订单 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("shopOrderService")
public class ShopOrderServiceImpl extends AbstractAppRealizeService<Long, ShopOrder, ShopOrderParam> implements ShopOrderService {
    @Resource
    private ShopOrderMapper shopOrderMapper;

    @Override
    public BaseConvertBo<ShopOrder, ShopOrderParam> initBo() {
        return new ShopOrderBo();
    }

    @Override
    public IBaseMapper<Long, ShopOrder> initMapper() {
        return shopOrderMapper;
    }

}
