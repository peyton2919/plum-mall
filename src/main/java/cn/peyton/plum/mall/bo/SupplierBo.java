package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.party.SupplierParam;
import cn.peyton.plum.mall.pojo.party.Supplier;

/**
 * <h3> 供应商信息 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class SupplierBo extends BaseConvertBo<Supplier, SupplierParam> {

    @Override
    public SupplierParam compat(Supplier info) {
        return new SupplierParam().compat(info);
    }

    @Override
    public Supplier convert(SupplierParam info) {
        return info.convert();
    }
}
