package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.MemberLevelParam;
import cn.peyton.plum.mall.pojo.MemberLevel;

/**
 * <h3> 会员等级 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class MemberLevelBo extends BaseConvertBo<MemberLevel, MemberLevelParam> {

    @Override
    public MemberLevelParam compat(MemberLevel info) {
        return new MemberLevelParam().compat(info);
    }

    @Override
    public MemberLevel convert(MemberLevelParam info) {
        return info.convert();
    }
}
