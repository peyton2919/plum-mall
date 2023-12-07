package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.sys.RoleParam;
import cn.peyton.plum.mall.pojo.sys.Role;

/**
 * <h3> 角色 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class RoleBo extends BaseConvertBo<Role, RoleParam> {

    @Override
    public RoleParam compat(Role info) {
        return new RoleParam().compat(info);
    }

    @Override
    public Role convert(RoleParam info) {
        return info.convert();
    }
}
