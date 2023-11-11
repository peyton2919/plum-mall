package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.DistrictParam;
import cn.peyton.plum.mall.pojo.District;

/**
 * <h3> 行政区 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class DistrictBo extends BaseConvertBo<District, DistrictParam> {

    @Override
    public DistrictParam compat(District info) {
        return new DistrictParam().compat(info);
    }

    @Override
    public District convert(DistrictParam info) {
        return info.convert();
    }
}
