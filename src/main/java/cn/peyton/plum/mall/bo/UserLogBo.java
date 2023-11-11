package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.UserLogParam;
import cn.peyton.plum.mall.pojo.UserLog;

/**
 * <h3> 用户日志 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class UserLogBo extends BaseConvertBo<UserLog, UserLogParam> {

    @Override
    public UserLogParam compat(UserLog info) {
        return new UserLogParam().compat(info);
    }

    @Override
    public UserLog convert(UserLogParam info) {
        return info.convert();
    }
}
