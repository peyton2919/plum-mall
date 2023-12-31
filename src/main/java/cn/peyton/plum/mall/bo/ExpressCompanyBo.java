package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.join.ExpressCompanyParam;
import cn.peyton.plum.mall.pojo.join.ExpressCompany;

/**
 * <h3> 快递公司 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class ExpressCompanyBo extends BaseConvertBo<ExpressCompany, ExpressCompanyParam> {

    @Override
    public ExpressCompanyParam compat(ExpressCompany info) {
        return new ExpressCompanyParam().compat(info);
    }

    @Override
    public ExpressCompany convert(ExpressCompanyParam info) {
        return info.convert();
    }
}
