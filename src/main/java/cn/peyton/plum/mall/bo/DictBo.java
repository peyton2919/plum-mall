package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.sys.DictParam;
import cn.peyton.plum.mall.pojo.sys.Dict;

/**
 * <h4></h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.mall.bo.DictBo
 * @date 2023年11月11日 9:53
 * @version 1.0.0
 * </pre>
 */
public class DictBo extends BaseConvertBo<Dict, DictParam> {
    @Override
    public DictParam compat(Dict info) {
        return new DictParam().compat(info);
    }

    @Override
    public Dict convert(DictParam info) {
        return info.convert();
    }
}
