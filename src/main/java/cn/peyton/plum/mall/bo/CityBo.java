package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.sys.CityParam;
import cn.peyton.plum.mall.pojo.sys.City;

/**
 * <h3> 城市表 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年12月27日 09:58:27
 * @version 1.0.0
 * </pre>
*/
public class CityBo  extends BaseConvertBo<City, CityParam> {

	@Override
	public CityParam compat(City info){ 
		return new CityParam().compat(info); 
	}

	@Override
	public City convert(CityParam info){ 
		return info.convert(); 
	}
}
