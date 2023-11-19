package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.mall.bo.ShopCouponMemberBo;
import cn.peyton.plum.mall.mapper.ShopCouponMemberMapper;
import cn.peyton.plum.mall.param.ShopCouponMemberParam;
import cn.peyton.plum.mall.pojo.ShopCouponMember;
import cn.peyton.plum.mall.service.ShopCouponMemberService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

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
public class ShopCouponMemberServiceImpl extends AbstractRealizeService<Long, ShopCouponMember, ShopCouponMemberParam> implements ShopCouponMemberService {
    @Resource
    private ShopCouponMemberMapper shopCouponMemberMapper;

    @Override
    public BaseConvertBo<ShopCouponMember, ShopCouponMemberParam> initBo() {
        return new ShopCouponMemberBo();
    }

    @Override
    public IBaseMapper<Long, ShopCouponMember> initMapper() {
        return shopCouponMemberMapper;
    }

}
