package cn.peyton.plum.mall.controller.pc.manager.party;

import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.inf.controller.IBasePCController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.mall.controller.base.PcController;
import cn.peyton.plum.mall.param.party.SupplierInfoParam;
import cn.peyton.plum.mall.param.party.SupplierParam;
import cn.peyton.plum.mall.service.party.SupplierInfoService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h3> 供应商基础信息 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
@RestController
@RequestMapping("/pc/supplierinfo")
public class SupplierInfoController extends PcController<SupplierInfoParam>
        implements IBasePCController<Long, SupplierInfoParam> {

    @Resource
    private SupplierInfoService supplierInfoService;

    @Override
    public JSONResult<?> list(Query query) {
        return null;
    }

    @Token
    @Valid
    @PostMapping("/manager/create")
    @Override
    public JSONResult<?> create(SupplierInfoParam record) {
        SupplierParam _param = handleToken(new SupplierParam());
        if(supplierInfoService.createJoin(record,_param.getId())){
            return JSONResult.success("基础信息添加成功;");
        }
        return JSONResult.fail("基础信息添加失败;");
    }

    @Token
    @Valid
    @PostMapping("/manager/edit")
    @Override
    public JSONResult<?> edit(SupplierInfoParam record) {

        return baseHandleEdit(record, null, supplierInfoService, TIP_SUPPLIER_INFO,UPDATE);
    }

    @Token
    @Valid
    @PostMapping("/manager/delete")
    @Override
    public JSONResult<?> delete(@NotBlank(message = "Id 不能为空;") @Min(value = 1,message = "最小为1")Long id) {
        return baseHandleDelete(id,supplierInfoService, TIP_SUPPLIER_INFO);
    }
}
