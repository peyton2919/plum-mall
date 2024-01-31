package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.pojo.app.AppCategory;

/**
 * <h3> App 分类 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年01月19日 22:43:53
 * @version 1.0.0
 * </pre>
*/
public class AppCategoryBo  extends BaseConvertBo<AppCategory, cn.peyton.plum.mall.param.app.AppCategoryParam> {

	@Override
	public cn.peyton.plum.mall.param.app.AppCategoryParam compat(AppCategory info){
		return new cn.peyton.plum.mall.param.app.AppCategoryParam().compat(info);
	}

	@Override
	public AppCategory convert(cn.peyton.plum.mall.param.app.AppCategoryParam info){
		return info.convert(); 
	}
}
