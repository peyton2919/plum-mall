package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.UsersRolesParam;
import cn.peyton.plum.mall.pojo.UsersRoles;

/**
 * <h3> 用户角色关联 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class UsersRolesBo extends BaseConvertBo<UsersRoles, UsersRolesParam> {

    @Override
    public UsersRolesParam compat(UsersRoles info) {
        return new UsersRolesParam().compat(info);
    }

    @Override
    public UsersRoles convert(UsersRolesParam info) {
        return info.convert();
    }
}
