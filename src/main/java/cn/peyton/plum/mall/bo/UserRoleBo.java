package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.UserRoleParam;
import cn.peyton.plum.mall.pojo.UserRole;

/**
 * <h3> 用户角色关联 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月13日 20:52:43
 * @version 1.0.0
 * </pre>
*/
public class UserRoleBo  extends BaseConvertBo<UserRole, UserRoleParam> {

	@Override
	public UserRoleParam compat(UserRole info){
		return new UserRoleParam().compat(info); 
	}

	@Override
	public UserRole convert(UserRoleParam info){ 
		return info.convert(); 
	}
}
