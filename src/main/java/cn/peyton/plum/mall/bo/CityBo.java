package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.sys.CityParam;
import cn.peyton.plum.mall.pojo.sys.City;

/**
 * <h4></h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.mall.bo.CityBo
 * @date 2023年11月10日 17:05
 * @version 1.0.0
 * </pre>
 */
public class CityBo extends BaseConvertBo<City, CityParam> {
    @Override
    public CityParam compat(City info) {
        return new CityParam().compat(info);
    }

    @Override
    public City convert(CityParam info) {
        return info.convert();
    }
}
