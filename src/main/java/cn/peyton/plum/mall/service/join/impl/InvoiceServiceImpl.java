package cn.peyton.plum.mall.service.join.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.RealizeService;
import cn.peyton.plum.mall.bo.InvoiceBo;
import cn.peyton.plum.mall.mapper.join.InvoiceMapper;
import cn.peyton.plum.mall.param.join.InvoiceParam;
import cn.peyton.plum.mall.pojo.join.Invoice;
import cn.peyton.plum.mall.service.join.InvoiceService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

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
public class InvoiceServiceImpl extends RealizeService<Long, Invoice, InvoiceParam> implements InvoiceService {
    @Resource
    private InvoiceMapper invoiceMapper;
    private String TABLE_NAME = "sys_invoice";

    @Override
    public BaseConvertBo<Invoice, InvoiceParam> bo() {
        return new InvoiceBo();
    }

    @Override
    public IBaseMapper<Long, Invoice> mapper() {
        return invoiceMapper;
    }
    public InvoiceServiceImpl() {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }

    @Override
    public Boolean upDelete(Long id) {
        int res = invoiceMapper.updateDeleteStatus(TABLE_NAME,id);
        if (res > 0) {
            clearCache("发票删除");
            return true;
        }
        return false;
    }

    @Override
    public List<InvoiceParam> findByDownList() {
        String key = keyPrefix + "_find_down_202401102038";

        Object res = getCache(key);
        if (null == res) {
            List<InvoiceParam> result = bo().adapter(invoiceMapper.selectByDownList());
            saveCache(key, result);
            return result;
        }
        return (List<InvoiceParam>) res;
    }

}
