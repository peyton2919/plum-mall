package cn.peyton.plum.mall.controller.pc.manager.product;

import cn.peyton.plum.core.anno.resolver.RequestMultiple;
import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.inf.controller.IBasePCController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.FormData;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.mall.controller.base.PcController;
import cn.peyton.plum.mall.param.product.ShopSlideshowParam;
import cn.peyton.plum.mall.service.product.ShopSlideshowService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <h3> 商品轮播图 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
@RestController
@RequestMapping("/pc/productslideshow")
public class ShopSlideshowController extends PcController<ShopSlideshowParam>
        implements IBasePCController<Long,ShopSlideshowParam> {

    @Resource
    private ShopSlideshowService shopSlideshowService;

    //  10. 轮播图
    @Token
    @Valid
    @PostMapping("/manager/create")
    public JSONResult<?> slideshow(@RequestMultiple FormData<ShopSlideshowParam> data) {
        if (null == data) { return JSONResult.fail(NO_DATA);}
        if (null == data.getKeyLong() || data.getKeyLong() < 1) {return JSONResult.fail(TIP_PRODUCT + TIP_ID + null);}
        if (null == data.getObjs() || data.getObjs().size() < 1) { return JSONResult.fail(NO_DATA);}
        if (null == data.getBool()) { return JSONResult.fail(PARAM+NULL);}
        List<ShopSlideshowParam> objs = data.getObjs();
        for (int i = 0; i < objs.size(); i++) {
            objs.get(i).setSrc(convertImgPath(objs.get(i).getSrc()));
            objs.get(i).setUrl(convertImgPath(objs.get(i).getUrl()));
        }

        return baseHandle(shopSlideshowService.batchInsertSelective(data.getKeyLong(), objs, data.getBool()), BATCH, OPERATE);
    }

    @Override
    public JSONResult<?> list(Query query) {
        return null;
    }

    @Override
    public JSONResult<?> create(ShopSlideshowParam record) {
        return null;
    }

    @Override
    public JSONResult<?> edit(ShopSlideshowParam record) {
        return null;
    }

    @Override
    public JSONResult<?> delete(Long id) {
        return null;
    }
}
