package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.InvoiceParam;
import cn.peyton.plum.mall.pojo.Invoice;

/**
 * <h3> 发票 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class InvoiceBo extends BaseConvertBo<Invoice, InvoiceParam> {

    @Override
    public InvoiceParam compat(Invoice info) {
        return new InvoiceParam().compat(info);
    }

    @Override
    public Invoice convert(InvoiceParam info) {
        return info.convert();
    }
}
