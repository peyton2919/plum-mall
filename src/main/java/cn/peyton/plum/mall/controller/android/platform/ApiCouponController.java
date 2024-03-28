package cn.peyton.plum.mall.controller.android.platform;

import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.inf.controller.ITipMessages;
import cn.peyton.plum.core.inf.controller.RealizeController;
import cn.peyton.plum.core.inf.mapper.IConditionMapper;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.utils.DateUtils;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.mall.param.party.MemberParam;
import cn.peyton.plum.mall.param.product.ShopCouponMemberParam;
import cn.peyton.plum.mall.param.product.ShopCouponParam;
import cn.peyton.plum.mall.service.product.ShopCouponMemberService;
import cn.peyton.plum.mall.service.product.ShopCouponService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * <h4>优惠券 API controller类</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.mall.controller.android.platform.
 * @date 2024年02月26日 10:17
 * @version 1.0.0
 * </pre>
 */
@RestController
@RequestMapping("/api/coupon")
public class ApiCouponController extends RealizeController {

    @Resource
    private ShopCouponService shopCouponService;
    @Resource
    private ShopCouponMemberService shopCouponMemberService;

    // 当前失效的优惠券
    @Token
    @Valid
    @PostMapping("/unusablelist")
    public JSONResult<?> unusableList(@NotBlank(message = "页码 不能为空;") @Min(value = 1,message = "最小为1")Integer pageNo){
        MemberParam member = (MemberParam) getToken(new MemberParam());
        //return handelOne(shopCartService.findByShareId(member.getId(), member.getUserType()), null);
        return list(shopCouponService.findUnusableCouponByMemberId(member.getId(),3,new PageQuery(pageNo)),null);
    }

    @Token
    @Valid
    @PostMapping("/list")
    public JSONResult<?> list(@NotBlank(message = "页码 不能为空;") @Min(value = 1, message = "页码最小值为1") Integer pageNo) {

        MemberParam member = (MemberParam) getToken(new MemberParam());

        return list(shopCouponService.findUsableCouponByMemberId(member.getId(),new PageQuery(pageNo)), null);
    }

    // 获取当前用户可用的优惠券数量
    @Token
    @Valid
    @PostMapping("/currentcount")
    public JSONResult<?> currentCouponCount(BigDecimal total) {
        MemberParam member = (MemberParam) getToken(new MemberParam());
        return JSONResult.success(DATA_LOADING_SUCCESS,
                shopCouponService.findCurrentUsableCouponCount(member.getId(), total,STATUS_1, 0, DateUtils.dateToTimestamp()));
    }

    // isvalid 有二个值 usable 可用| invalid 已失效 | use 已使用
    @Token
    @Valid
    @PostMapping("/currentcoupon")
    public JSONResult<?> currentCoupon(BigDecimal total, @NotBlank(message = "页码 不能为空;") @Min(value = 1,message = "最小为1")Integer pageNo,
                                       @NotBlank(message = "验证参数不能为空;")String isvalid) {
        MemberParam member = (MemberParam) getToken(new MemberParam());
        List<ShopCouponParam> res;
        if("usable".equals(isvalid)){
            res = shopCouponService.findCurrentUsableCoupon(member.getId(), total, ("usable".equals(isvalid) ? 1 : 0),
                    0, DateUtils.dateToTimestamp(), IConditionMapper.EQ, new PageQuery(pageNo));
        }else if("use".equals(isvalid)){
            res = shopCouponService.findUseCouponByMemberId(member.getId(), new PageQuery(pageNo));
        }else {
            res = shopCouponService.findUnusableCouponByMemberId(member.getId(), 3, new PageQuery(pageNo));
        }
        return list(res, null);
    }

    // 领取 优惠券（）
    @Token
    @Valid
    @PostMapping("/receive")
    public JSONResult<?> receive(@NotBlank(message = "优惠券 Id 不能为空;") @Min(value = 1,message = "最小为1")Long couponId) {

        MemberParam member = (MemberParam) getToken(new MemberParam());
        ShopCouponMemberParam _param = new ShopCouponMemberParam();
        _param.setShareId(member.getId());
        _param.setShareType(member.getUserType());
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
        return handle(_param,null,false,shopCouponMemberService,TIP_SHOP_COPON,RECEIVE);
    }

}
