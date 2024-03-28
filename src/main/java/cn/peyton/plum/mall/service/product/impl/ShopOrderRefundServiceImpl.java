package cn.peyton.plum.mall.service.product.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.RealizeService;
import cn.peyton.plum.mall.bo.ShopOrderRefundBo;
import cn.peyton.plum.mall.mapper.product.ShopOrderRefundMapper;
import cn.peyton.plum.mall.param.product.ShopOrderRefundParam;
import cn.peyton.plum.mall.pojo.product.ShopOrderRefund;
import cn.peyton.plum.mall.service.product.ShopOrderRefundService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 订单退款 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("shopOrderRefundService")
public class ShopOrderRefundServiceImpl extends RealizeService<Long, ShopOrderRefund, ShopOrderRefundParam> implements ShopOrderRefundService {
    @Resource
    private ShopOrderRefundMapper shopOrderRefundMapper;

    @Override
    public BaseConvertBo<ShopOrderRefund, ShopOrderRefundParam> bo() {
        return new ShopOrderRefundBo();
    }

    @Override
    public IBaseMapper<Long, ShopOrderRefund> mapper() {
        return shopOrderRefundMapper;
    }

    public ShopOrderRefundServiceImpl () {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }
}
