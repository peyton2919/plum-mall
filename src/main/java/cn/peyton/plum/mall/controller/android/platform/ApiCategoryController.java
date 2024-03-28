package cn.peyton.plum.mall.controller.android.platform;

import cn.peyton.plum.core.inf.controller.RealizeController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.mall.service.product.ShopCategoryService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h4>商品分类 API controller</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.mall.controller.android.platform.
 * @date 2024年01月25日 21:58
 * @version 1.0.0
 * </pre>
 */
@RestController
@RequestMapping("/api/category")
public class ApiCategoryController extends RealizeController {

    @Resource
    private ShopCategoryService shopCategoryService;

    @PostMapping("/commonuse")
    public JSONResult<?> commonUse() {

        return list(shopCategoryService.findAndroidByRand(8), null);
    }


}
