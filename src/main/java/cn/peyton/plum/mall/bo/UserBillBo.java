package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.UserBillParam;
import cn.peyton.plum.mall.pojo.UserBill;

/**
 * <h3> 会员账单{用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)} 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
public class UserBillBo extends BaseConvertBo<UserBill, UserBillParam> {

    @Override
    public UserBillParam compat(UserBill info) {
        return new UserBillParam().compat(info);
    }

    @Override
    public UserBill convert(UserBillParam info) {
        return info.convert();
    }
}
