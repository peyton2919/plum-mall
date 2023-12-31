package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.sys.SupplierLogParam;
import cn.peyton.plum.mall.pojo.sys.SupplierLog;

/**
 * <h3> 供应商日志 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class SupplierLogBo extends BaseConvertBo<SupplierLog, SupplierLogParam> {

    @Override
    public SupplierLogParam compat(SupplierLog info) {
        return new SupplierLogParam().compat(info);
    }

    @Override
    public SupplierLog convert(SupplierLogParam info) {
        return info.convert();
    }
}
