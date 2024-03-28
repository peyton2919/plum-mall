package cn.peyton.plum.mall.service.product.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.RealizeService;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.mall.bo.ShopCouponMemberBo;
import cn.peyton.plum.mall.mapper.product.ShopCouponMemberMapper;
import cn.peyton.plum.mall.param.product.ShopCouponMemberParam;
import cn.peyton.plum.mall.pojo.product.ShopCouponMember;
import cn.peyton.plum.mall.service.product.ShopCouponMemberService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * <h3> 优惠券会员(关联优惠券与会员) Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("shopCouponMemberService")
public class ShopCouponMemberServiceImpl extends RealizeService<Long, ShopCouponMember, ShopCouponMemberParam> implements ShopCouponMemberService {
    @Resource
    private ShopCouponMemberMapper shopCouponMemberMapper;

    @Override
    public BaseConvertBo<ShopCouponMember, ShopCouponMemberParam> bo() {
        return new ShopCouponMemberBo();
    }

    @Override
    public IBaseMapper<Long, ShopCouponMember> mapper() {
        return shopCouponMemberMapper;
    }

    public ShopCouponMemberServiceImpl () {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }

    @Override
    public List<ShopCouponMemberParam> findByUseableOrAll(Long shareId, Integer shareType, BigDecimal price, Integer currentTime, PageQuery page) {
        // 特殊: 不做缓存处理
        return bo().adapter(shopCouponMemberMapper.selectByUseableOrAll(shareId, shareType, price, currentTime, page));
    }

    @Override
    public Boolean isJoinCoupon(Long couponId) {
        return shopCouponMemberMapper.isJoinCoupon(couponId) > 0;
    }

    @Override
    public Boolean isUsed(Long couponId, Long shareId, Integer shareType) {
        return shopCouponMemberMapper.isUsed(couponId, shareId, shareType) > 0;
    }

    @Override
    public Boolean upUsed(Long couponId, Long shareId, Integer shareType) {
        int res = shopCouponMemberMapper.upUsed(couponId, shareId, shareType);
        if (res > 0) {
            clearCache("更新优惠券使用状态");
            return true;
        }
        return false;
    }
}
