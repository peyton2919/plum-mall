package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.RoleMenuParam;
import cn.peyton.plum.mall.pojo.RoleMenu;

/**
 * <h3> 角色菜单关联 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月13日 20:53:15
 * @version 1.0.0
 * </pre>
*/
public class RoleMenuBo  extends BaseConvertBo<RoleMenu, RoleMenuParam> {

	@Override
	public RoleMenuParam compat(RoleMenu info){ 
		return new RoleMenuParam().compat(info); 
	}

	@Override
	public RoleMenu convert(RoleMenuParam info){ 
		return info.convert(); 
	}
}
