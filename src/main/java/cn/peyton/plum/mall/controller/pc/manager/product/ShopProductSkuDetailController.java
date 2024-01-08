package cn.peyton.plum.mall.controller.pc.manager.product;

import cn.peyton.plum.core.anno.resolver.RequestMultiple;
import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.inf.controller.IBasePCController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.FormData;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.mall.controller.base.PcController;
import cn.peyton.plum.mall.param.product.ShopProductSkuDetailParam;
import cn.peyton.plum.mall.service.product.ShopProductService;
import cn.peyton.plum.mall.service.product.ShopProductSkuDetailService;
import jakarta.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <h3> 商品规格详细 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
@RestController
@RequestMapping("/pc/productskudetail")
public class ShopProductSkuDetailController extends PcController<ShopProductSkuDetailParam>
        implements IBasePCController<Long,ShopProductSkuDetailParam> {

    @Resource
    private ShopProductSkuDetailService shopProductSkuDetailService;
    @Resource
    private ShopProductService shopProductService;

    // 11. 单规格 specType, skus 添加|更新 MODEL判断{MODEL=true 更新 | MODEL=false 新增}
    @Token
    @Valid
    @PostMapping("/manager/single")
    public JSONResult<?> single(@RequestMultiple FormData<ShopProductSkuDetailParam> data) {
        // todo 单规格逻辑处理
        //String operate = shopProductService.findByOperate(product.getId());
        //String[] strs = toArr(operate);
        //strs[0] = "1";
        //product.setOperate(toStr(strs));
        //return baseEdit(convert(product),null,shopProductService,"单规格设置");
        if (null == data || null == data.getRecord() || null == data.getStr() || null == data.getBool()) {
            return JSONResult.fail(MSG);
        }
        data.getRecord().setCover(convertImgPath(data.getRecord().getCover()));
        return baseHandle(shopProductSkuDetailService.joinCreateAndEdit(data.getRecord(), data.getStr(), data.getBool()),
                TIP_PRODUCT,SPEC_SINGLE,OPERATE);
    }

    // 12. 多规格 添加|更新 MODEL判断{MODEL=true 更新 | MODEL=false 新增}
    // 参数: ShopProductSkuDetailParam集合、skus{规格集合转成字符串}、bool{更新|新增}
    @Token
    @Valid
    @PostMapping("/manager/multi")
    @Transactional
    public JSONResult<?> multi(@RequestMultiple FormData<ShopProductSkuDetailParam> data) {
        // 多规格逻辑处理
        if (null == data || null == data.getObjs() || null == data.getStr()) {
            return JSONResult.fail(MSG);
        }
        List<ShopProductSkuDetailParam> objs = data.getObjs();
        for (int i = 0; i < objs.size(); i++) {
            objs.get(i).setCover(convertImgPath(objs.get(i).getCover()));
        }

        if (shopProductSkuDetailService.joinMultiCrateAndEdit(objs, data.getStr(), data.getBool())) {
            return JSONResult.success(BATCH + OPERATE + TIP_PRODUCT + SPEC_MULTI + SUCCESS);
        }
        return JSONResult.fail(BATCH + OPERATE + TIP_PRODUCT + SPEC_MULTI + FAIL);
    }


    // 更新仓库
    @Token
    @Valid
    @PostMapping("/manager/upwarehouse")
    public JSONResult<?> upWarehouse(Long id, Integer warehouseId,String explain) {

        return baseHandle(shopProductSkuDetailService.updateWarehouse(id,warehouseId,explain),TIP_WAREHOUSE,UPDATE);
    }

    @Override
    public JSONResult<?> list(Query query) {
        return null;
    }

    @Override
    public JSONResult<?> create(ShopProductSkuDetailParam record) {
        return null;
    }

    @Override
    public JSONResult<?> edit(ShopProductSkuDetailParam record) {
        return null;
    }

    @Override
    public JSONResult<?> delete(Long id) {
        return null;
    }

    @Token
    @Valid
    @PostMapping("/manager/one")
    public JSONResult<?> one(@NotBlank(message = "商品 Id 不能为空;") @Min(value = 1,message = "最小为1")Long id) {

        return JSONResult.success(shopProductSkuDetailService.findByProductId(id));
    }
}
