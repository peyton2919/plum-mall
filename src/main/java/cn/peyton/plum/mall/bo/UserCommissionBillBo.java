package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.UserCommissionBillParam;
import cn.peyton.plum.mall.pojo.UserCommissionBill;

/**
 * <h3> 用户分佣账单{用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)} 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class UserCommissionBillBo extends BaseConvertBo<UserCommissionBill, UserCommissionBillParam> {

    @Override
    public UserCommissionBillParam compat(UserCommissionBill info) {
        return new UserCommissionBillParam().compat(info);
    }

    @Override
    public UserCommissionBill convert(UserCommissionBillParam info) {
        return info.convert();
    }
}
