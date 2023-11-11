package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.LogParam;
import cn.peyton.plum.mall.pojo.Log;

/**
 * <h3> 日志信息 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class LogBo extends BaseConvertBo<Log, LogParam> {

    @Override
    public LogParam compat(Log info) {
        return new LogParam().compat(info);
    }

    @Override
    public Log convert(LogParam info) {
        return info.convert();
    }
}
