package cn.peyton.plum.mall.controller.pc.manager.join;

import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.inf.controller.IController;
import cn.peyton.plum.core.inf.controller.RealizeController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.mall.param.join.InvoiceParam;
import cn.peyton.plum.mall.service.join.InvoiceService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h3> 发票 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
@RestController
@RequestMapping("/pc/invoice")
public class InvoiceController extends RealizeController
        implements IController<Long, InvoiceParam> {
    @Resource
    private InvoiceService invoiceService;

    @Token
    @Valid
    @PostMapping("/manager/search")
    @Override
    public JSONResult<?> list(Query query) {
        InvoiceParam _param = new InvoiceParam();
        _param.setName(query.getKeyword());
        return page(_param, new PageQuery(query.getPageNo()), invoiceService,true);
    }

    @Token
    @Valid
    @PostMapping("/manager/create")
    @Override
    public JSONResult<?> create(InvoiceParam record) {
        InvoiceParam _param = new InvoiceParam();
        _param.setName(record.getName());
        return handle(record, _param, false, invoiceService, TIP_INVOICE,CREATE);
    }

    @Token
    @Valid
    @PostMapping("/manager/edit")
    @Override
    public JSONResult<?> edit(InvoiceParam record) {
        InvoiceParam _param = new InvoiceParam();
        _param.setName(record.getName());
        _param.setId(record.getId());
        return handle(record, _param, true, invoiceService, TIP_INVOICE, UPDATE);
    }

    @Token
    @Valid
    @PostMapping("/manager/delete")
    @Override
    public JSONResult<?> delete(@NotBlank(message = "发票 Id 不能为空;") @Min(value = 1,message = "最小为1")Long id) {

        return delete(id, invoiceService, TIP_INVOICE);
    }

    // 下拉框
    @Token
    @PostMapping("/manager/down")
    public JSONResult<?> down(){
        return JSONResult.success(invoiceService.findByDownList());
    }
}
