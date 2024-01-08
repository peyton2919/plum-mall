package cn.peyton.plum.mall.controller.pc.manager.product;

import cn.peyton.plum.core.anno.resolver.RequestMultiple;
import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.inf.controller.IBasePCController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.core.utils.DateUtils;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.mall.controller.base.ITipMessages;
import cn.peyton.plum.mall.controller.base.PcController;
import cn.peyton.plum.mall.param.party.MemberParam;
import cn.peyton.plum.mall.param.product.ShopCouponMemberParam;
import cn.peyton.plum.mall.service.product.ShopCouponMemberService;
import cn.peyton.plum.mall.service.product.ShopCouponService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * <h3> 优惠券会员(关联优惠券与会员) Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
@RestController
@RequestMapping("/pc/couponmember")
public class ShopCouponMemberController extends PcController<ShopCouponMemberParam>
        implements IBasePCController<Long, ShopCouponMemberParam> {

    @Resource
    private ShopCouponMemberService shopCouponMemberService;
    @Resource
    private ShopCouponService shopCouponService;

    @Override
    public JSONResult<?> list(@RequestMultiple Query<ShopCouponMemberParam> query) {

        return null;
    }

    @Override
    public JSONResult<?> create(ShopCouponMemberParam record) {
        MemberParam _param = handleToken(new MemberParam());
        return null;
    }

    // 领取 优惠券（）
    @Token
    @Valid
    @PostMapping("/manager/receive")
    public JSONResult<?> receive(@NotBlank(message = "优惠券 Id 不能为空;") @Min(value = 1,message = "最小为1")Long couponId) {

        MemberParam _user = handleToken(new MemberParam());
        ShopCouponMemberParam _param = new ShopCouponMemberParam();
        _param.setShareId(_user.getId());
        _param.setShareType(_user.getUserType());
        _param.setCouponId(couponId);

        // 判断是否领过应优惠券
        if (shopCouponMemberService.repeat(_param)) {
            return JSONResult.fail(RECEIVE + TIP_SHOP_COPON);
        }
        // 判断可用的优惠券数量
        if(!shopCouponService.isReceive(couponId)){
            return JSONResult.fail(TIP_SHOP_COPON + GET_FINISHED);
        }
        // 判断 优惠券 是否能领取
        if (!shopCouponService.isUseableAndGet(couponId,false,null)) {
            return JSONResult.fail(TIP_SHOP_COPON + ITipMessages.DISABLED);
        }
        return baseHandleCreate(_param,null,shopCouponMemberService,TIP_SHOP_COPON,RECEIVE);
    }

    // 使用 优惠券
    @Token
    @Valid
    @PostMapping("/manager/employ")
    public JSONResult<?> employ(@NotBlank(message = "优惠券 Id 不能为空;") @Min(value = 1,message = "最小为1")Long couponId, BigDecimal price) {
        // 判断 优惠券 是否能领取
        if (!shopCouponService.isUseableAndGet(couponId,true,price)) {
            return JSONResult.fail(TIP_SHOP_COPON + ITipMessages.DISABLED);
        }
        MemberParam _user = handleToken(new MemberParam());
        if (!shopCouponMemberService.isUsed(couponId, _user.getId(), _user.getUserType())) {
            return JSONResult.fail(TIP_SHOP_COPON + ITipMessages.DISABLED);
        }
        // todo 使用成功 更新 关联表 used = 1
        //
        return JSONResult.success();
    }

    // 当前 用户可用的优惠券 当price 有值 时，条件查找 ; 无值时分页查找
    @Token
    @Valid
    @PostMapping("/manager/useable")
    public JSONResult<?> getUseable(BigDecimal price,Integer pageNo) {
        if (null == price) {
            if (null == pageNo || pageNo < 1) {
                return JSONResult.fail(ERROR);
            }
        }
        MemberParam _user = handleToken(new MemberParam());
        return JSONResult.success(shopCouponMemberService.findByUseableOrAll(_user.getId(), _user.getUserType(), price, DateUtils.dateToTimestamp(),
                (null != price && price.doubleValue() > 0) ? null : new PageQuery(pageNo)));
    }

    @Override
    public JSONResult<?> edit(ShopCouponMemberParam record) {
        return null;
    }

    @Override
    public JSONResult<?> delete(Long id) {
        return null;
    }
}
