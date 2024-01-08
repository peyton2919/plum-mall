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
import cn.peyton.plum.mall.param.product.ShopSkuParam;
import cn.peyton.plum.mall.service.product.ShopProductSkuService;
import cn.peyton.plum.mall.service.product.ShopSkuService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <h3> 商品规格 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
@RestController
@RequestMapping("/pc/productsku")
public class ShopSkuController extends PcController<ShopSkuParam>
        implements IBasePCController<Long, ShopSkuParam> {

    @Resource
    private ShopSkuService shopSkuService;
    @Resource
    private ShopProductSkuService shopProductSkuService;

    @Override
    public JSONResult<?> list(Query query) {
        return null;
    }

    // 13. 创建规格
    @Token
    @Valid
    @PostMapping("/manager/create")
    @Override
    public JSONResult<?> create(ShopSkuParam record) {
        // 判断 规格名称 ; 在数据库中如果找到相同在返回 , 否则 重新创建一个
        ShopSkuParam res = shopSkuService.findByName(record.getName());
        if (null != res) {
            return JSONResult.success(FIND_DATA, res);
        }
        return baseHandleCreate(record, null, shopSkuService, TIP_SHOP_SKU);
    }

    // record、keyLong、bool
    // 14. 更新 | 创建 规格
    @Token
    @Valid
    @PostMapping("/manager/change")
    public JSONResult<?> chanage(@RequestMultiple FormData<ShopSkuParam> data) {
        ShopSkuParam record = data.getRecord();
        ShopProductSkuParam _param = new ShopProductSkuParam();
        _param.setSkuValueId(record.getId());
        // 设置商品Id
        _param.setProductId(data.getKeyLong());
        // 在当前操作是 更新 shop_product_sku 关联表中查找
        if (data.getBool() && null != record.getId()) {
            if (shopProductSkuService.isExisted(_param)) {
                return JSONResult.fail(MODIFY + JOIN_DATA + MODIFY);
            }
        }
        ShopSkuParam res = shopSkuService.findByName(record.getName());
        if (null != res) {
            return JSONResult.success(FIND_DATA, res);
        }
        ShopSkuParam param = shopSkuService.add(record);
        if(null != param){
            return JSONResult.success((TIP_SHOP_SKU + OPERATE + SUCCESS), param);
        }
        return JSONResult.fail(TIP_SHOP_SKU + OPERATE + FAIL);
    }

    // 15. 删除 规格
    @Token
    @Valid
    @PostMapping("/manager/delete")
    public JSONResult<?> deleteJoin(@NotBlank(message = "规格Id 不能为空;") @Min(value = 1,message = "最小为1")Long skuId,
                                @NotBlank(message = "商品Id 不能为空;") @Min(value = 1,message = "最小为1")Long productId) {

        ShopProductSkuParam _param = new ShopProductSkuParam();
        _param.setSkuId(skuId);
        _param.setProductId(productId);
        if (shopProductSkuService.isExisted(_param)) {
            return JSONResult.fail("删除数据关联其他数据,无法删除;");
        }

        return JSONResult.success("删除数据成功;");
    }

    // 16. 排序规格 排序 参数: 规格对象集合
    @Token
    @Valid
    @PostMapping("/manager/sort")
    public JSONResult<?> sort(@RequestMultiple FormData<ShopSkuParam> data) {
        List<ShopSkuParam> objs = data.getObjs();
        if (null == objs || objs.size() == 0) {
            return JSONResult.fail(NO_DATA + NO_NEED + UPDATE);
        }
        return shopSkuService.batchUpdate(objs) ? JSONResult.success(SORT + OPERATE + SUCCESS) :
                JSONResult.fail(SORT + OPERATE + FAIL);
    }

    // 设置 参数: str 字符串, strs 字符串集合
    // 20. 选中商品规格规则(快捷选择)
    @Token
    @Valid
    @PostMapping("/manager/set")
    public JSONResult<?> set(@RequestMultiple FormData data) {

        if (null == data || null == data.getStr() || "".equals(data.getStr())) {
            return JSONResult.fail(NO_DATA);
        }

        ShopSkuParam res = shopSkuService.set(data.getStr(), data.getStrs());
        if(null == res){
            return JSONResult.fail(DATA+SUBMIT+FAIL);
        }
        return JSONResult.success(res);
    }


    @Override
    public JSONResult<?> edit(ShopSkuParam record) {
        return null;
    }

    @Override
    public JSONResult<?> delete(Long id) {
        return null;
    }
}
