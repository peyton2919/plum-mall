package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.ProvinceParam;
import cn.peyton.plum.mall.pojo.Province;

/**
 * <h3> 省份 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class ProvinceBo extends BaseConvertBo<Province, ProvinceParam> {

    @Override
    public ProvinceParam compat(Province info) {
        return new ProvinceParam().compat(info);
    }

    @Override
    public Province convert(ProvinceParam info) {
        return info.convert();
    }
}
