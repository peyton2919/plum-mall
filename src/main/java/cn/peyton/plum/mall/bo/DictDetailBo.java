package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.sys.DictDetailParam;
import cn.peyton.plum.mall.pojo.sys.DictDetail;

/**
 * <h4></h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.mall.bo.DictDetailBo
 * @date 2023年11月11日 9:54
 * @version 1.0.0
 * </pre>
 */
public class DictDetailBo extends BaseConvertBo<DictDetail, DictDetailParam> {
    @Override
    public DictDetailParam compat(DictDetail info) {
        return new DictDetailParam().compat(info);
    }

    @Override
    public DictDetail convert(DictDetailParam info) {
        return info.convert();
    }
}
