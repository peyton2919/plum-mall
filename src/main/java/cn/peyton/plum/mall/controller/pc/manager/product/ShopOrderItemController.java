package cn.peyton.plum.mall.controller.pc.manager.product;

import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.inf.controller.IController;
import cn.peyton.plum.core.inf.controller.RealizeController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.core.utils.base.CtrlUtils;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.mall.param.product.ShopOrderItemParam;
import cn.peyton.plum.mall.service.product.ShopOrderItemService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h3> 订单--项 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
@RestController
@RequestMapping("/pc/orderitem")
public class ShopOrderItemController extends RealizeController
        implements IController<Long, ShopOrderItemParam> {

    @Resource
    private ShopOrderItemService shopOrderItemService;

    @Override
    public JSONResult<?> list(Query<ShopOrderItemParam> query) {
        return null;
    }

    @Override
    public JSONResult<?> create(ShopOrderItemParam record) {
        return null;
    }

    @Override
    public JSONResult<?> edit(ShopOrderItemParam record) {
        return null;
    }

    @Override
    public JSONResult<?> delete(Long id) {
        return null;
    }

    @Token
    @Valid
    @PostMapping("/manager/sell")
    public JSONResult<?> sell(@NotBlank(message = "商品规格明细 Id 不能为空;") @Min(value = 1,message = "最小为1")Long psdId,
                              @NotBlank(message = "页码不能为空;") @Min(value = 1,message = "最小为1")Integer pageNo, String between) {


        int[] times = new CtrlUtils().convertStrToBetweenIntArray(between);

        return page(shopOrderItemService.findByStockId(psdId, new PageQuery(pageNo), times[0], times[1]), null);
    }
}
