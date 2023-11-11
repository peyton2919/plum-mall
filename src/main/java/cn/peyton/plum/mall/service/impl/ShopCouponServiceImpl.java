package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractAppRealizeService;
import cn.peyton.plum.mall.bo.ShopCouponBo;
import cn.peyton.plum.mall.mapper.ShopCouponMapper;
import cn.peyton.plum.mall.param.ShopCouponParam;
import cn.peyton.plum.mall.pojo.ShopCoupon;
import cn.peyton.plum.mall.service.ShopCouponService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 优惠券 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("shopCouponService")
public class ShopCouponServiceImpl extends AbstractAppRealizeService<Long, ShopCoupon, ShopCouponParam> implements ShopCouponService {
    @Resource
    private ShopCouponMapper shopCouponMapper;

    @Override
    public BaseConvertBo<ShopCoupon, ShopCouponParam> initBo() {
        return new ShopCouponBo();
    }

    @Override
    public IBaseMapper<Long, ShopCoupon> initMapper() {
        return shopCouponMapper;
    }

}
