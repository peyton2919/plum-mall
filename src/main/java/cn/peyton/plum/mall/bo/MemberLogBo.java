package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.MemberLogParam;
import cn.peyton.plum.mall.pojo.MemberLog;

/**
 * <h3> 会员日志 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class MemberLogBo extends BaseConvertBo<MemberLog, MemberLogParam> {

    @Override
    public MemberLogParam compat(MemberLog info) {
        return new MemberLogParam().compat(info);
    }

    @Override
    public MemberLog convert(MemberLogParam info) {
        return info.convert();
    }
}
