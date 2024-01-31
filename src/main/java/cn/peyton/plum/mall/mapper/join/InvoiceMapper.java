package cn.peyton.plum.mall.mapper.join;

import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.mall.pojo.join.Invoice;

import java.util.List;

/**
 * <h3> 发票 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public interface InvoiceMapper extends IBaseMapper<Long, Invoice> {
    /**
     * <h4>发票 下拉框</h4>
     * @return 集合
     */
    List<Invoice>  selectByDownList();
    // ==================================== new create method ==================================== //


}
