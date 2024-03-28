package cn.peyton.plum.mall.service.product.impl;

import cn.peyton.plum.core.err.TransactionalException;
import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.RealizeService;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.utils.DateUtils;
import cn.peyton.plum.mall.bo.ShopOrderBo;
import cn.peyton.plum.mall.bo.ShopOrderItemBo;
import cn.peyton.plum.mall.mapper.product.ShopCouponMemberMapper;
import cn.peyton.plum.mall.mapper.product.ShopOrderItemMapper;
import cn.peyton.plum.mall.mapper.product.ShopOrderMapper;
import cn.peyton.plum.mall.mapper.product.ShopStockMapper;
import cn.peyton.plum.mall.param.product.ShopOrderParam;
import cn.peyton.plum.mall.pojo.product.ShopOrder;
import cn.peyton.plum.mall.pojo.product.ShopOrderItem;
import cn.peyton.plum.mall.service.product.ShopOrderService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

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
public class ShopOrderServiceImpl extends RealizeService<Long, ShopOrder, ShopOrderParam> implements ShopOrderService {
    @Resource
    private ShopOrderMapper shopOrderMapper;
    @Resource
    private ShopOrderItemMapper shopOrderItemMapper;
    @Resource
    private ShopCouponMemberMapper shopCouponMemberMapper;
    @Resource
    private ShopStockMapper shopStockMapper;

    @Override
    public BaseConvertBo<ShopOrder, ShopOrderParam> bo() {
        return new ShopOrderBo();
    }

    @Override
    public IBaseMapper<Long, ShopOrder> mapper() {
        return shopOrderMapper;
    }

    public ShopOrderServiceImpl() {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }

    @Override
    public Boolean updateIsDel(List<Long> list) {
        if(shopOrderMapper.updateIsDel(list)>0){
            clearCache("删除订单");
            return true;
        }
        return false;
    }

    @Override
    public List<ShopOrderParam> findSimpleByCondition(ShopOrderParam record, Integer start, Integer end) {

        return bo().adapter(shopOrderMapper.selectSimpleByCondition(record.convert(),start,end));
    }

    @Override
    @Transactional(rollbackFor = TransactionalException.class)
    public ShopOrderParam create(ShopOrderParam param) {
        param.setCreateTime(DateUtils.timestampToStrDate(new Date()));
        ShopOrder order = param.convert();
        int res = shopOrderMapper.insertSelective(order);
        if (res < 1) {
            throw new TransactionalException(JSONResult.error(JSONResult.Props.TRANSACTIONAL, "创建订单异常"));
        }
        int size = param.getItems().size();
        for (int i = 0; i < size; i++) {
            param.getItems().get(i).setOId(order.getId());
            param.getItems().get(i).setCreateTime(DateUtils.timestampToStrDate(new Date()));
        }
        List<ShopOrderItem> reverse = new ShopOrderItemBo().reverse(param.getItems());
        res = shopOrderItemMapper.batchInsert(reverse);
        if (res < 1) {
            throw new TransactionalException(JSONResult.error(JSONResult.Props.TRANSACTIONAL, "创建订单项异常"));
        }
        // 更新销售
        for (int i = 0; i < reverse.size(); i++) {
            res = shopStockMapper.updatePayCount(reverse.get(i).getPsdId());
            if (res < 1) {
                throw new TransactionalException(JSONResult.error(JSONResult.Props.TRANSACTIONAL, "创建订单项异常"));
            }
        }

        // 更新 优惠券
        if(null != param.getCouponId()){
            res = shopCouponMemberMapper.upUsed(param.getCouponId(), param.getShareId(), param.getShareType());
            if (res < 1) {
                throw new TransactionalException(JSONResult.error(JSONResult.Props.TRANSACTIONAL, "创建订单项异常"));
            }
        }

        return new ShopOrderParam().compat(order);
    }
}
