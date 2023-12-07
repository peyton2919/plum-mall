package cn.peyton.plum.mall.service.sys.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.mall.bo.LogBo;
import cn.peyton.plum.mall.mapper.sys.LogMapper;
import cn.peyton.plum.mall.param.sys.LogParam;
import cn.peyton.plum.mall.pojo.sys.Log;
import cn.peyton.plum.mall.service.sys.LogService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 日志信息 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("logService")
public class LogServiceImpl extends AbstractRealizeService<Long, Log, LogParam> implements LogService {
    @Resource
    private LogMapper logMapper;

    @Override
    public BaseConvertBo<Log, LogParam> initBo() {
        return new LogBo();
    }

    @Override
    public IBaseMapper<Long, Log> initMapper() {
        return logMapper;
    }

    public LogServiceImpl () {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }
}
