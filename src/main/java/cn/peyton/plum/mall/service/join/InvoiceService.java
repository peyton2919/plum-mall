package cn.peyton.plum.mall.service.join;

import cn.peyton.plum.core.inf.service.IBaseService;
import cn.peyton.plum.mall.param.join.InvoiceParam;
import cn.peyton.plum.mall.pojo.join.Invoice;

/**
 * <h3> 发票 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
public interface InvoiceService extends IBaseService<Long, Invoice, InvoiceParam> {
    /**
     *  <h4>删除</h4>
     * @param id 对象ID
     * @return
     */
    Boolean upDelete(Long id);
}
