package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.sys.UserParam;
import cn.peyton.plum.mall.pojo.sys.User;

/**
 * <h3> 系统用户 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class UserBo extends BaseConvertBo<User, UserParam> {

    @Override
    public UserParam compat(User info) {
        return new UserParam().compat(info);
    }

    @Override
    public User convert(UserParam info) {
        return info.convert();
    }
}
