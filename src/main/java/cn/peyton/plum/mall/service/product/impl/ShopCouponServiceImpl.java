package cn.peyton.plum.mall.service.product.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.RealizeService;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.utils.DateUtils;
import cn.peyton.plum.mall.bo.ShopCouponBo;
import cn.peyton.plum.mall.mapper.product.ShopCouponMapper;
import cn.peyton.plum.mall.param.product.ShopCouponParam;
import cn.peyton.plum.mall.pojo.product.ShopCoupon;
import cn.peyton.plum.mall.service.product.ShopCouponService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

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
public class ShopCouponServiceImpl extends RealizeService<Long, ShopCoupon, ShopCouponParam> implements ShopCouponService {
    private String TABLE_NAME = "tb_shop_coupon";
    @Resource
    private ShopCouponMapper shopCouponMapper;

    @Override
    public BaseConvertBo<ShopCoupon, ShopCouponParam> bo() {
        return new ShopCouponBo();
    }

    @Override
    public IBaseMapper<Long, ShopCoupon> mapper() {
        return shopCouponMapper;
    }

    public ShopCouponServiceImpl() {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }

    @Override
    public boolean isUseableAndGet(Long id, Boolean useable, BigDecimal price) {
        return shopCouponMapper.isUseableAndGet(id, useable, DateUtils.dateToTimestamp(), price) > 0;
    }

    @Override
    public boolean isReceive(Long id) {
        return shopCouponMapper.isReceive(id) > 0;
    }

    @Override
    public Boolean upStatus(Long id, Integer status) {
        int res = shopCouponMapper.updateStatus(TABLE_NAME, id, status);
        if (res > 0) {
            clearCache("更新优惠券状态");
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateUsed(Long id) {
        int res = shopCouponMapper.updateUsed(id);
        if (res > 0) {
            clearCache("更新优惠券使用状态");
            return true;
        }
        return false;
    }

    @Override
    public Boolean isEffective(Long id, Integer currentTime) {
        return shopCouponMapper.isEffective(id, currentTime) > 0;
    }

    @Override
    public int findCurrentUsableCouponCount(Long memberId, BigDecimal total, int status, int used, int currentDatetime) {
        return shopCouponMapper.selectCurrentUsableCouponCount(memberId,total,status,used,currentDatetime);
    }

    @Override
    public List<ShopCouponParam> findCurrentUsableCoupon(Long memberId, BigDecimal total, Integer status, Integer used, Integer currentDatetime, String condition,PageQuery page) {

        List<ShopCoupon> result = shopCouponMapper.selectCurrentUsableCoupon(memberId, total, status, used, currentDatetime,condition, page);
        if (null != result) {
            return bo().adapter(result);
        }
        return null;
    }

    @Override
    public List<ShopCouponParam> findUsableCouponByMemberId(Long memberId, PageQuery page) {
        List<ShopCoupon> result = shopCouponMapper.selectUsableCouponByMemberId(memberId, page);
        if (null != result) {
            return bo().adapter(result);
        }
        return null;
    }

    @Override
    public List<ShopCouponParam> findUnusableCouponByMemberId(Long memberId, Integer status, PageQuery page) {
        List<ShopCoupon> result = shopCouponMapper.selectUnusableCouponByMemberId(memberId,status, page);
        if (null != result) {
            return bo().adapter(result);
        }
        return null;
    }

    @Override
    public List<ShopCouponParam> findUseCouponByMemberId(Long memberId, PageQuery page) {
        List<ShopCoupon> result = shopCouponMapper.selectUseCouponByMemberId(memberId, page);
        if (null != result) {
            return bo().adapter(result);
        }
        return null;
    }
}
