package cn.peyton.plum.mall.controller.pc.manager.product;

import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.inf.controller.IBasePCController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.mall.controller.base.PcController;
import cn.peyton.plum.mall.param.product.ShopCouponParam;
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
public class ShopCouponController extends PcController<ShopCouponParam>
        implements IBasePCController<Long, ShopCouponParam> {
    String TIP_NAME = "优惠券";

    @Resource
    private ShopCouponService shopCouponService;

    @Token
    @Valid
    @PostMapping("/manager/all")
    @Override
    public JSONResult<?> all(String keyword,
                 @NotBlank(message = "页码数不能为空;") @Min(message = "当前页码要大于0的数!")Integer pageNo) {
        PageQuery _page = new PageQuery(pageNo,"seq");
        ShopCouponParam _param = new ShopCouponParam();
        _param.setName(keyword);
        return baseFindBykeywordAll(_param,_page,shopCouponService);
    }

    @Token
    @Valid
    @PostMapping("/manager/search")
    @Override
    public JSONResult<?> search(Query query) {
        ShopCouponParam _param = new ShopCouponParam();
        _param.setName(query.getKeyword());
        return baseFindBykeywordAll(_param,new PageQuery(query.getPageNo(),"seq"),shopCouponService);
    }

    @Token
    @Valid
    @PostMapping("/manager/create")
    @Override
    public JSONResult<?> create(ShopCouponParam record) {
        ShopCouponParam _repeat = new ShopCouponParam();
        _repeat.setName(record.getName());
        return baseCreate(record, _repeat, shopCouponService, TIP_NAME);
    }

    @Token
    @Valid
    @PostMapping("/manager/edit")
    @Override
    public JSONResult<?> edit(ShopCouponParam record) {
        ShopCouponParam _repeat = new ShopCouponParam();
        _repeat.setName(record.getName());
        _repeat.setId(record.getId());
        return baseEdit(record, _repeat, shopCouponService, TIP_NAME);
    }

    @Token
    @Valid
    @PostMapping("/manager/upstatus")
    public JSONResult<?> updateStatus(@NotBlank(message = "Id不能为空;") @Min(message = "Id大于0的数!")Long id) {
        ShopCouponParam _repeat = new ShopCouponParam();
        _repeat.setStatus(STATUS_0);
        _repeat.setId(id);
        if (shopCouponService.update(_repeat)) {
            return JSONResult.success( "状态修改成功;");
        }
        return JSONResult.fail("状态修改失败;");
    }

    @Token
    @Valid
    @PostMapping("/manager/delete")
    @Override
    public JSONResult<?> delete(@NotBlank(message = "Id不能为空;") @Min(value = 1,message = "Id大于0的数!")Long id) {
        return baseDelete(id,shopCouponService,TIP_NAME);
    }

}
