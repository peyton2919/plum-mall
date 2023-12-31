package cn.peyton.plum.mall.service.join.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.mall.bo.InvoiceBo;
import cn.peyton.plum.mall.mapper.join.InvoiceMapper;
import cn.peyton.plum.mall.param.join.InvoiceParam;
import cn.peyton.plum.mall.pojo.join.Invoice;
import cn.peyton.plum.mall.service.join.InvoiceService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 发票 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("invoiceService")
public class InvoiceServiceImpl extends AbstractRealizeService<Long, Invoice, InvoiceParam> implements InvoiceService {
    @Resource
    private InvoiceMapper invoiceMapper;

    @Override
    public BaseConvertBo<Invoice, InvoiceParam> initBo() {
        return new InvoiceBo();
    }

    @Override
    public IBaseMapper<Long, Invoice> initMapper() {
        return invoiceMapper;
    }
    public InvoiceServiceImpl() {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }
}
