package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.sys.DeptParam;
import cn.peyton.plum.mall.pojo.sys.Dept;

/**
 * <h4></h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.mall.bo.DeptBo
 * @date 2023年11月11日 9:51
 * @version 1.0.0
 * </pre>
 */
public class DeptBo extends BaseConvertBo<Dept, DeptParam> {
    @Override
    public DeptParam compat(Dept info) {
        return new DeptParam().compat(info);
    }

    @Override
    public Dept convert(DeptParam info) {
        return info.convert();
    }
}
