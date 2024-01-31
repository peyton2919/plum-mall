package cn.peyton.plum.mall.controller.android.platform;

import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.core.validator.constraints.Size;
import cn.peyton.plum.mall.controller.base.AndroidController;
import cn.peyton.plum.mall.controller.base.ITipMessages;
import cn.peyton.plum.mall.dto.AdvertDto;
import cn.peyton.plum.mall.service.app.AppCategoryService;
import cn.peyton.plum.mall.service.app.AppNavService;
import cn.peyton.plum.mall.service.product.ShopProductService;
import cn.peyton.plum.mall.service.pub.AdvertService;
import cn.peyton.plum.mall.vo.IndexVo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * <h4></h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.mall.controller.android.
 * @date 2024年01月19日 20:32
 * @version 1.0.0
 * </pre>
 */
@RestController
@RequestMapping("/api/index")
public class ApiIndexController extends AndroidController {

    @Resource
    private AppCategoryService appCategoryService;
    @Resource
    private AppNavService appNavService;
    @Resource
    private AdvertService advertService;
    @Resource
    private ShopProductService shopProductService;

    @Valid
    @PostMapping("/list")
    public JSONResult<?> list(@NotBlank(message = "id不能为空;") Integer id,
              @NotBlank(message = "页码 不能为空;") @Min(value = 1,message = "最小为1")Integer pageNo) {
        IndexVo vo = new IndexVo();
        //vo.setCategories(appCategoryService.findByTabBars());
        //if (null == vo.getCategories() || vo.getCategories().size() == 0) {
        //    return JSONResult.fail(ITipMessages.ERROR);
        //}

        vo.setSwipers(advertService.findBySwiperAndNav(2,3));
        vo.setOneAdv(advertService.findByOne());
        vo.setThreeAdvs(AdvertDto.filter(advertService.findByThree()));
        vo.setNavs(advertService.findBySwiperAndNav(3,10));

        // 2. data
        //    id type {swiper,threeAdv,oneAdv,nav,list} data[]
        vo.setShopProducts(shopProductService.findAndroidByList(new PageQuery(pageNo),convert(id)));

        return JSONResult.success(vo);
    }

    //@Valid
    @GetMapping("/home")
    public JSONResult<?> index() {
        IndexVo vo = new IndexVo();
        vo.setCategories(appCategoryService.findByTabBars());
        if (null == vo.getCategories() || vo.getCategories().size() == 0) {
            return JSONResult.fail(ITipMessages.ERROR);
        }
        vo.setSwipers(advertService.findBySwiperAndNav(2,3));
        vo.setOneAdv(advertService.findByOne());
        vo.setThreeAdvs(AdvertDto.filter(advertService.findByThree()));
        vo.setNavs(advertService.findBySwiperAndNav(3,10));

        vo.setShopProducts(shopProductService.findAndroidByList(new PageQuery(1),"is_good"));
        return JSONResult.success(vo);
    }

    @Valid
    @PostMapping("/load")
    public JSONResult<?> load(@NotBlank(message = "id不能为空;") @Size(min = 0,max = 2) Integer id,
                  @NotBlank(message = "页码 不能为空;") @Min(value = 1,message = "最小为1")Integer pageNo) {
        return JSONResult.success(shopProductService.findAndroidByList(new PageQuery(pageNo),convert(id)));
    }

    /**
     * <h4>tabbars类型转换</h4>
     * @param index 索引
     * @return
     */
    private String convert(int index) {
        if (index == 1) {
            return "is_good";
        }
        if (index == 2) {
            return "is_hot";
        }
        if (index == 3) {
            return "is_new";
        }
        return null;
    }
}
