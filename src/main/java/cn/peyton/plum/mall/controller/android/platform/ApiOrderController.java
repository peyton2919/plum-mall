package cn.peyton.plum.mall.controller.android.platform;

import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.inf.controller.RealizeController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.utils.OrderUtils;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.mall.param.party.MemberParam;
import cn.peyton.plum.mall.param.product.ShopOrderItemParam;
import cn.peyton.plum.mall.param.product.ShopOrderParam;
import cn.peyton.plum.mall.service.product.ShopOrderService;
import cn.peyton.plum.mall.vo.OrderVo;
import com.alibaba.fastjson2.JSON;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h4>订单 API controller类</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.mall.controller.android.platform.
 * @date 2024年03月18日 20:19
 * @version 1.0.0
 * </pre>
 */
@RestController
@RequestMapping("/api/order")
public class ApiOrderController extends RealizeController {

    @Resource
    private ShopOrderService shopOrderService;

    @Token
    @Valid
    @PostMapping("/create")
    public JSONResult<?> create(OrderVo vo) {
        if (null == vo.getList() || "".equals(vo.getList())) {
            return JSONResult.fail(JSONResult.Props.VALIDATE, "订单项为空数据");
        }
        MemberParam member = (MemberParam) getToken(new MemberParam());

        // 1. 创建订单数据 需要返回{id,orderNo,memberId}
        ShopOrderParam param = new ShopOrderParam();
        param.compat(vo);
        param.setShareId(member.getId());
        param.setShareType(member.getUserType());
        // 生成订单号
        param.setOrderNo(OrderUtils.conventDate2Str());

        param.setItems(JSON.parseArray(vo.getList(), ShopOrderItemParam.class));
        // 2. 创建订单项数据

        //return handle(shopOrderService.create(param),null,"订单");
        return one(shopOrderService.create(param), null);
    }
}
