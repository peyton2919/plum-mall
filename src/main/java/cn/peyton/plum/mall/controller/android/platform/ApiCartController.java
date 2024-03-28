package cn.peyton.plum.mall.controller.android.platform;

import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.inf.controller.RealizeController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.utils.DateUtils;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.mall.param.party.MemberParam;
import cn.peyton.plum.mall.param.product.ShopCartParam;
import cn.peyton.plum.mall.service.product.ShopCartService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * <h4>购物车 API controller类</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.mall.controller.android.platform.
 * @date 2024年02月12日 11:46
 * @version 1.0.0
 * </pre>
 */
@RestController
@RequestMapping("/api/cart")
public class ApiCartController extends RealizeController {

    @Resource
    private ShopCartService shopCartService;

    @Token
    @GetMapping("/currentlist")
    public JSONResult<?> currentList(){
        MemberParam member = (MemberParam) getToken(new MemberParam());
        return one(shopCartService.findByShareId(member.getId(), member.getUserType()), null);
    }

    @Token
    @Valid
    @PostMapping("/create")
    public JSONResult<?> create(@NotBlank(message = "详细数据不能为空!!!") String expand) {
        MemberParam member = (MemberParam) getToken(new MemberParam());
        ShopCartParam record = shopCartService.findByShareId(member.getId(), member.getUserType());

        if (null == record) {//新增
            record = new ShopCartParam();
            record.setExpand(expand);
            record.setShareId(member.getId());
            record.setShareType(member.getUserType());
            record.setCreateTime(DateUtils.timestampToStrDate(new Date()));
            return handle(record, null, false, shopCartService, TIP_SHOP_CART, CREATE);
        }
        record.setExpand(expand);
        record.setUpdateTime(DateUtils.timestampToStrDate(new Date()));
        return handle(record, null, true, shopCartService, TIP_SHOP_CART, UPDATE);
    }

    @Token
    @Valid
    @PostMapping("/updatecart")
    public JSONResult<?> updateCart(String expand){
        MemberParam member = (MemberParam) getToken(new MemberParam());
        return handle(shopCartService.updateCart(member.getId(), member.getUserType(), expand), null, TIP_SHOP_CART, UPDATE);
    }

    @Token
    @Valid
    @GetMapping("/edit")
    public JSONResult<?> edit(ShopCartParam record) {
        return handle(record, null, true, shopCartService, TIP_SHOP_CART, UPDATE);
    }

    @Token
    @Valid
    @PostMapping("/delete")
    public JSONResult delete(@NotBlank(message = "Id 不能为空;") @Min(value = 1,message = "最小值为1")Long id) {
        return delete(id, shopCartService, TIP_SHOP_CART);
    }
}
