package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.UserDistributionParam;
import cn.peyton.plum.mall.pojo.UserDistribution;

/**
 * <h3> 用户分销关联(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用) 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
public class UserDistributionBo extends BaseConvertBo<UserDistribution, UserDistributionParam> {

    @Override
    public UserDistributionParam compat(UserDistribution info) {
        return new UserDistributionParam().compat(info);
    }

    @Override
    public UserDistribution convert(UserDistributionParam info) {
        return info.convert();
    }
}
