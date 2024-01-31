package cn.peyton.plum.mall.controller.pc.manager.join;

import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.inf.controller.IBasePCController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.mall.controller.base.PcController;
import cn.peyton.plum.mall.param.join.WarehouseInfoParam;
import cn.peyton.plum.mall.service.join.WarehouseInfoService;
import cn.peyton.plum.mall.service.product.ShopProductSkuDetailService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h3> 仓库信息 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
@RestController
@RequestMapping("/pc/warehouse")
public class WarehouseInfoController extends PcController<WarehouseInfoParam>
        implements IBasePCController<Integer, WarehouseInfoParam> {

    @Resource
    private WarehouseInfoService warehouseInfoService;
    @Resource
    private ShopProductSkuDetailService shopProductSkuDetailService;

    // 名称 或 空 查找
    @Token
    @Valid
    @PostMapping("/manager/search")
    @Override
    public JSONResult<?> list(Query query) {
        WarehouseInfoParam _param = new WarehouseInfoParam();
        _param.setName(query.getKeyword());
        // 其他处理判断
        return baseHandleList(_param, new PageQuery(query.getPageNo()), warehouseInfoService,null);
    }

    @Token
    @Valid
    @PostMapping("/manager/create")
    @Override
    public JSONResult<?> create(WarehouseInfoParam record) {
        WarehouseInfoParam _repeat = new WarehouseInfoParam();
        _repeat.setName(record.getName());
        return baseHandleCreate(record, _repeat, warehouseInfoService, TIP_WAREHOUSE);
    }

    @Token
    @Valid
    @PostMapping("/manager/edit")
    @Override
    public JSONResult<?> edit(WarehouseInfoParam record) {
        // 判断
        if (shopProductSkuDetailService.isWarehouse(record.getId())) {
            return JSONResult.fail("仓库关联商品信息,无法编辑;如需要编辑先清空相应的数据");
        }
        WarehouseInfoParam _repeat = new WarehouseInfoParam();
        _repeat.setId(record.getId());
        _repeat.setName(record.getName());
        return baseHandleEdit(record, _repeat, warehouseInfoService, TIP_WAREHOUSE,UPDATE);
    }

    @Token
    @Valid
    @PostMapping("/manager/delete")
    @Override
    public JSONResult<?> delete(@NotBlank(message = "仓库 ID 不能为空;") @Min(value = 1,message = "最小值为1")Integer id) {
        // 判断
        if (shopProductSkuDetailService.isWarehouse(id)) {
            return JSONResult.fail("仓库关联商品信息,无法删除;如需要删除先清除相应的数据");
        }
        return baseHandleDelete(id,warehouseInfoService,TIP_WAREHOUSE);
    }

    // 下拉框
    @Token
    @PostMapping("/manager/down")
    public JSONResult<?> down(){
        return JSONResult.success(warehouseInfoService.findByDownList());
    }
}
