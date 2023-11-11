package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.RolesDeptsParam;
import cn.peyton.plum.mall.pojo.RolesDepts;

/**
 * <h3> 角色部门关联 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class RolesDeptsBo extends BaseConvertBo<RolesDepts, RolesDeptsParam> {

    @Override
    public RolesDeptsParam compat(RolesDepts info) {
        return new RolesDeptsParam().compat(info);
    }

    @Override
    public RolesDepts convert(RolesDeptsParam info) {
        return info.convert();
    }
}
