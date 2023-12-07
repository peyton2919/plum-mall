package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.sys.RoleDeptParam;
import cn.peyton.plum.mall.pojo.sys.RoleDept;

/**
 * <h3> 角色部门关联 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月13日 20:53:02
 * @version 1.0.0
 * </pre>
*/
public class RoleDeptBo  extends BaseConvertBo<RoleDept, RoleDeptParam> {

	@Override
	public RoleDeptParam compat(RoleDept info){ 
		return new RoleDeptParam().compat(info);
	}

	@Override
	public RoleDept convert(RoleDeptParam info){ 
		return info.convert(); 
	}
}
