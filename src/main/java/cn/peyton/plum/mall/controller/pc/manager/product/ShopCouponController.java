package cn.peyton.plum.mall.controller.pc.manager.product;

import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.inf.controller.IController;
import cn.peyton.plum.core.inf.controller.RealizeController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.core.utils.DateUtils;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.core.validator.constraints.Size;
import cn.peyton.plum.mall.param.product.ShopCouponParam;
import cn.peyton.plum.mall.service.product.ShopCouponMemberService;
import cn.peyton.plum.mall.service.product.ShopCouponService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h3> 优惠券 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
@RestController
@RequestMapping("/pc/coupon")
public class ShopCouponController extends RealizeController
        implements IController<Long, ShopCouponParam> {


    @Resource
    private ShopCouponService shopCouponService;
    @Resource
    private ShopCouponMemberService shopCouponMemberService;

    @Token
    @Valid
    @PostMapping("/manager/all")
    public JSONResult<?> all(String keyword,
                 @NotBlank(message = "页码数不能为空;") @Min(message = "当前页码要大于0的数!")Integer pageNo) {
        ShopCouponParam _param = new ShopCouponParam();
        _param.setName(keyword);
        return page(_param,new PageQuery(pageNo,ORDER_BY_FILED),shopCouponService,true);
    }

    // keyword
    @Token
    @Valid
    @PostMapping("/manager/search")
    @Override
    public JSONResult<?> list(Query query) {
        ShopCouponParam _param = new ShopCouponParam();
        _param.setName(query.getKeyword());
        return page(_param,new PageQuery(query.getPageNo(),ORDER_BY_FILED),shopCouponService,true);
    }

    @Token
    @Valid
    @PostMapping("/manager/create")
    @Override
    public JSONResult<?> create(ShopCouponParam record) {
        ShopCouponParam _repeat = new ShopCouponParam();
        _repeat.setName(record.getName());
        return handle(record, _repeat,false, shopCouponService, TIP_SHOP_COPON,CREATE);
    }

    @Token
    @Valid
    @PostMapping("/manager/edit")
    @Override
    public JSONResult<?> edit(ShopCouponParam record) {
        if (shopCouponMemberService.isJoinCoupon(record.getId())) {
            return JSONResult.fail("优惠券已被领取, 不能修改;");
        }
        if (shopCouponService.isEffective(record.getId(), DateUtils.dateToTimestamp())) {
            return JSONResult.fail("优惠券在使用期间, 不能修改;");
        }
        ShopCouponParam _repeat = new ShopCouponParam();
        _repeat.setName(record.getName());
        _repeat.setId(record.getId());
        return handle(record, _repeat, true, shopCouponService, TIP_SHOP_COPON, UPDATE);
    }

    @Token
    @Valid
    @PostMapping("/manager/upstatus")
    public JSONResult<?> updateStatus(@NotBlank(message = "Id不能为空;") @Min(message = "Id最小值为1")Long id,
        @NotBlank(message="状态码不能为空") @Size(min = 0,max = 3) Integer status) {
        //if (shopCouponMemberService.isJoinCoupon(id)) {
        //    return JSONResult.fail("优惠券已被领取, 状态不能修改;");
        //}
        //if (shopCouponService.isEffective(id, DateUtils.dateToTimestamp())) {
        //    return JSONResult.fail("优惠券在使用期间, 状态不能修改;");
        //}
        return handle(shopCouponService.upStatus(id, status), TIP_SHOP_COPON, STATUS, MODIFY);
    }

    @Token
    @Valid
    @PostMapping("/manager/delete")
    @Override
    public JSONResult<?> delete(@NotBlank(message = "优惠券Id不能为空;") @Min(value = 1,message = "Id大于0的数!")Long id) {
        if (shopCouponMemberService.isJoinCoupon(id)) {
            return JSONResult.fail("优惠券已被领取, 不能删除;");
        }
        if (shopCouponService.isEffective(id, DateUtils.dateToTimestamp())) {
            return JSONResult.fail("优惠券在使用期间, 不能删除;");
        }
        return handle(shopCouponService.upStatus(id,STATUS_4), TIP_SHOP_COPON,DELETE);
    }

}
