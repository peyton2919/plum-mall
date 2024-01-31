package cn.peyton.plum.mall.controller.android.platform;

import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.mall.controller.base.AndroidController;
import cn.peyton.plum.mall.param.join.BrandParam;
import cn.peyton.plum.mall.param.pub.AdvertParam;
import cn.peyton.plum.mall.service.join.BrandService;
import cn.peyton.plum.mall.service.product.ShopCategoryService;
import cn.peyton.plum.mall.service.pub.AdvertService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h4></h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.mall.controller.android.platform.
 * @date 2024年01月26日 9:54
 * @version 1.0.0
 * </pre>
 */
@RestController
@RequestMapping("/api/search")
public class ApiSearchController extends AndroidController {

    @Resource
    private AdvertService advertService;
    @Resource
    private ShopCategoryService shopCategoryService;
    @Resource
    private BrandService brandService;

    @GetMapping("/load")
    public JSONResult<?> load(){
        Map<String, Object> map = new HashMap<>();
        AdvertParam advert = advertService.findByOne();
        advert.setSrc(getSiteRootPath(advert.getSrc()));
        map.put("advert",advert);
        map.put("category", shopCategoryService.findAndroidByRand(8));
        List<BrandParam> brands = brandService.findAndroidRandom(10);
        for (int i = 0; i < brands.size(); i++) {
            brands.get(i).setLogo(convertImgPath( brands.get(i).getLogo()));
        }
        map.put("brand", brands);
        return handelMulti(map, null);
    }
}
