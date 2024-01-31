package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.pojo.app.AppNav;

/**
 * <h3> App 导航 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年01月19日 22:24:37
 * @version 1.0.0
 * </pre>
*/
public class AppNavBo  extends BaseConvertBo<AppNav, cn.peyton.plum.mall.param.app.AppNavParam> {

	@Override
	public cn.peyton.plum.mall.param.app.AppNavParam compat(AppNav info){
		return new cn.peyton.plum.mall.param.app.AppNavParam().compat(info);
	}

	@Override
	public AppNav convert(cn.peyton.plum.mall.param.app.AppNavParam info){
		return info.convert(); 
	}
}
