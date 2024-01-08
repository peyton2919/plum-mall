package cn.peyton.plum.mall.controller.pc.manager.product;

import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.inf.controller.IBasePCController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.mall.controller.base.PcController;
import cn.peyton.plum.mall.param.party.MemberParam;
import cn.peyton.plum.mall.param.product.ShopCartParam;
import cn.peyton.plum.mall.service.product.ShopCartService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h3> 购物车 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
@RestController
@RequestMapping("/pc/shopcart")
public class ShopCartController extends PcController<ShopCartParam>
        implements IBasePCController<Long, ShopCartParam> {

    @Resource
    private ShopCartService shopCartService;

    @Override
    public JSONResult<?> list(Query query) {
        return null;
    }

    @Token
    @Valid
    @PostMapping("/manager/create")
    @Override
    public JSONResult<?> create(ShopCartParam record) {
        return baseHandleCreate(assign(record), null, shopCartService, TIP_SHOP_CART);
    }

    @Token
    @Valid
    @PostMapping("/manager/edit")
    @Override
    public JSONResult<?> edit(ShopCartParam record) {
        return baseHandleEdit(assign(record), null, shopCartService, TIP_SHOP_CART,UPDATE);
    }

    @Token
    @Valid
    @PostMapping("/manager/delete")
    @Override
    public JSONResult<?> delete(@NotBlank(message = "购物车 Id 不能为空;") @Min(value = 1,message = "最小为1")Long id) {
        return baseHandle(shopCartService.upDelete(id), TIP_SHOP_CART);
    }

    @Token
    @Valid
    @PostMapping("/manager/single")
    public JSONResult<?> single() {
        MemberParam _param = handleToken(new MemberParam());
        return JSONResult.success(shopCartService.findByShareId(_param.getId(),_param.getUserType()));
    }


    @Override
    protected ShopCartParam assign(ShopCartParam record) {
        MemberParam _param = handleToken(new MemberParam());
        record.setShareId(_param.getId());
        record.setShareType(_param.getUserType());
        return record;
    }
}
