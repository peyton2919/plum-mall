package cn.peyton.plum.mall.controller.pc.manager.party;

import cn.peyton.plum.core.anno.resolver.RequestMultiple;
import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.inf.controller.IController;
import cn.peyton.plum.core.inf.controller.RealizeController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.FormData;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.NotBlank;
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
public class SupplierInfoController extends RealizeController
        implements IController<Long, SupplierInfoParam> {

    @Resource
    private SupplierInfoService supplierInfoService;

    @Override
    public JSONResult<?> list(Query query) {
        return null;
    }

    @Override
    public JSONResult<?> create(SupplierInfoParam record) {
        SupplierParam _param = getToken(new SupplierParam());

        return handle(supplierInfoService.createJoin(record, _param.getId()), TIP_SUPPLIER_INFO, CREATE);
    }

    @Token
    @Valid
    @PostMapping("/manager/create")
    public JSONResult<?> joinCreate(@RequestMultiple FormData<SupplierInfoParam> data) {
        Long supplierId = data.getKeyLong();
        if (supplierId < 1) {
            return JSONResult.fail(ERROR);
        }

        return handle(supplierInfoService.createJoin(data.getRecord(), supplierId), TIP_SUPPLIER_INFO, CREATE);
    }

    @Token
    @Valid
    @PostMapping("/manager/edit")
    @Override
    public JSONResult<?> edit(SupplierInfoParam record) {

        return handle(record, null,true, supplierInfoService, TIP_SUPPLIER_INFO,UPDATE);
    }

    @Token
    @Valid
    @PostMapping("/manager/delete")
    @Override
    public JSONResult<?> delete(@NotBlank(message = "id 不能为空") @Min(value = 1, message = "最小值为1") Long id) {

        return delete(id, supplierInfoService, TIP_SUPPLIER_INFO);
    }

    @Token
    @PostMapping("/manager/one")
    public JSONResult<?> one(@NotBlank(message = "id 不能为空") @Min(value = 1, message = "最小值为1") Long id) {
        return JSONResult.success(supplierInfoService.findById(id));
    }
}
