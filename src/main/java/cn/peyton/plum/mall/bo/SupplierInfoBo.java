package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.party.SupplierInfoParam;
import cn.peyton.plum.mall.pojo.party.SupplierInfo;

/**
 * <h3> 供应商基础信息 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class SupplierInfoBo extends BaseConvertBo<SupplierInfo, SupplierInfoParam> {

    @Override
    public SupplierInfoParam compat(SupplierInfo info) {
        return new SupplierInfoParam().compat(info);
    }

    @Override
    public SupplierInfo convert(SupplierInfoParam info) {
        return info.convert();
    }
}
