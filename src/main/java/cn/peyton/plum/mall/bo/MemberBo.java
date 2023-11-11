package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.MemberParam;
import cn.peyton.plum.mall.pojo.Member;

/**
 * <h3> 会员 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class MemberBo extends BaseConvertBo<Member, MemberParam> {

    @Override
    public MemberParam compat(Member info) {
        return new MemberParam().compat(info);
    }

    @Override
    public Member convert(MemberParam info) {
        return info.convert();
    }
}
