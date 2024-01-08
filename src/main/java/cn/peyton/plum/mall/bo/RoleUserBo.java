package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.sys.RoleUserParam;
import cn.peyton.plum.mall.pojo.sys.RoleUser;

/**
 * <h3> 用户角色关联 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月13日 20:52:43
 * @version 1.0.0
 * </pre>
*/
public class RoleUserBo extends BaseConvertBo<RoleUser, RoleUserParam> {

	@Override
	public RoleUserParam compat(RoleUser info){
		return new RoleUserParam().compat(info);
	}

	@Override
	public RoleUser convert(RoleUserParam info){
		return info.convert(); 
	}
}
