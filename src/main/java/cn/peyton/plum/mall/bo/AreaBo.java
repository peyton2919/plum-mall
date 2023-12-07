package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.sys.AreaParam;
import cn.peyton.plum.mall.pojo.sys.Area;

/**
 * <h4>区域 数据转换类</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.mall.bo.AreaBo
 * @date 2023年11月10日 16:49
 * @version 1.0.0
 * </pre>
 */
public class AreaBo extends BaseConvertBo<Area, AreaParam> {
    @Override
    public AreaParam compat(Area info) {
        return new AreaParam().compat(info);
    }

    @Override
    public Area convert(AreaParam info) {
        return info.convert();
    }
}
