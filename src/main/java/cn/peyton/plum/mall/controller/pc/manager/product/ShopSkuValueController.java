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
import cn.peyton.plum.mall.param.product.ShopProductSkuParam;
import cn.peyton.plum.mall.param.product.ShopSkuValueParam;
import cn.peyton.plum.mall.service.product.ShopProductSkuService;
import cn.peyton.plum.mall.service.product.ShopSkuValueService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h3> 商品规格 值 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
@RestController
@RequestMapping("/pc/productskuvalue")
public class ShopSkuValueController extends PcController<ShopSkuValueParam>
        implements IBasePCController<Long, ShopSkuValueParam> {
    String TIP_NAME = "规格值";

    @Resource
    private ShopSkuValueService shopSkuValueService;
    @Resource
    private ShopProductSkuService shopProductSkuService;

    // 17. 创建 规格值
    @Token
    @Valid
    @PostMapping("/manager/create")
    @Override
    public JSONResult<?> create(ShopSkuValueParam record) {
        ShopSkuValueParam res = shopSkuValueService.findBySkuIdAndValue(record.getSkuId(), record.getSkuValue());
        if(null != res){
            return JSONResult.success(FIND_DATA, res);
        }
        return baseHandleCreate(record, null, shopSkuValueService, TIP_SHOP_SKU_VALUE);
    }

    // keyLong,record,bool
    // 18. 更新 规格值
    @Token
    @Valid
    @PostMapping("/manager/edit")
    public JSONResult<?> chanage(@RequestMultiple FormData<ShopSkuValueParam> data) {
        //todo ShopSkuValueParam record
        ShopSkuValueParam record = data.getRecord();
        ShopProductSkuParam _param = new ShopProductSkuParam();
        _param.setSkuValueId(record.getId());
        _param.setProductId(data.getKeyLong());
        // 在当前操作是 更新 shop_product_sku 关联表中查找
        if(data.getBool() && null != record.getId()){
            if (shopProductSkuService.isExisted(_param)) {
                return JSONResult.fail(MODIFY + JOIN_DATA + MODIFY);
            }
        }
        ShopSkuValueParam res = shopSkuValueService.findBySkuIdAndValue(record.getSkuId(), record.getSkuValue());
        if(null != res){
            return JSONResult.success("查找相应数据;", res);
        }
        return baseHandleCreate(record, null, shopSkuValueService, TIP_SHOP_SKU_VALUE);
    }
    // 商品Id、规格值Id
    //  19. 删除 规格值
    @Token
    @Valid
    @PostMapping("/manager/delete")
    public JSONResult<?> deleteJoin(@NotBlank(message = "规格值Id 不能为空;") @Min(value = 1,message = "最小为1") Long skuValueId,
                                    @NotBlank(message = "商品Id 不能为空;") @Min(value = 1,message = "最小为1") Long productId) {
        ShopProductSkuParam _param = new ShopProductSkuParam();
        _param.setSkuValueId(skuValueId);
        _param.setProductId(productId);
        if (shopProductSkuService.isExisted(_param)) {
            return JSONResult.fail(DELETE + JOIN_DATA + DELETE);
        }
        //return baseDelete(id,shopSkuValueService,TIP_NAME);
        return JSONResult.success(DATA + DELETE + SUCCESS);
    }


    @Override
    public JSONResult<?> delete(Long id) {
        return null;
    }

    @Override
    public JSONResult<?> edit(ShopSkuValueParam record) {
        return null;
    }


    @Override
    public JSONResult<?> list(Query query) {
        return null;
    }
}
