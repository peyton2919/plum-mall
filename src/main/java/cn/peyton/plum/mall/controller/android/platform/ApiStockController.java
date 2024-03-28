package cn.peyton.plum.mall.controller.android.platform;

import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.inf.controller.RealizeController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.mall.service.product.ShopStockService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <h4>库存 API controller类</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.mall.controller.android.platform.
 * @date 2024年03月03日 14:48
 * @version 1.0.0
 * </pre>
 */
@RestController
@RequestMapping("/api/stock")
public class ApiStockController extends RealizeController {

    @Resource
    private ShopStockService shopStockService;

    @Token
    @PostMapping("/currentlist")
    public JSONResult<?> currentList(@NotBlank(message = "参数不能为空") String splices){
        String[] ids = splices.split(",");
        List<Long> longs = new ArrayList<>();
        if (null != ids) {
            for (int i = 0; i < ids.length; i++) {
                longs.add(Long.parseLong(ids[i]));
            }
        }
        return list(shopStockService.findByIds(longs),null);
    }
}
