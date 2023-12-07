package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.party.UserExtractParam;
import cn.peyton.plum.mall.pojo.party.UserExtract;

/**
 * <h3> 用户提现 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
public class UserExtractBo extends BaseConvertBo<UserExtract, UserExtractParam> {

    @Override
    public UserExtractParam compat(UserExtract info) {
        return new UserExtractParam().compat(info);
    }

    @Override
    public UserExtract convert(UserExtractParam info) {
        return info.convert();
    }
}
