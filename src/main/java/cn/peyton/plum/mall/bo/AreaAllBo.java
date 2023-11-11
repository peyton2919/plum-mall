package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.AreaAllParam;
import cn.peyton.plum.mall.pojo.AreaAll;

/**
 * <h4>全部地区 数据转换类</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.mall.bo. AreaAllBo
 * @date 2023年11月10日 16:46
 * @version 1.0.0
 * </pre>
 */
public class AreaAllBo extends BaseConvertBo<AreaAll, AreaAllParam> {
    @Override
    public AreaAllParam compat(AreaAll info) {
        return new AreaAllParam().compat(info);
    }

    @Override
    public AreaAll convert(AreaAllParam info) {
        return info.convert();
    }
}
