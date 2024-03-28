package cn.peyton.plum.mall.service.sys.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.RealizeService;
import cn.peyton.plum.mall.bo.UserLogBo;
import cn.peyton.plum.mall.mapper.sys.UserLogMapper;
import cn.peyton.plum.mall.param.sys.UserLogParam;
import cn.peyton.plum.mall.pojo.sys.UserLog;
import cn.peyton.plum.mall.service.sys.UserLogService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 用户日志 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("userLogService")
public class UserLogServiceImpl extends RealizeService<Long, UserLog, UserLogParam> implements UserLogService {
    @Resource
    private UserLogMapper userLogMapper;

    @Override
    public BaseConvertBo<UserLog, UserLogParam> bo() {
        return new UserLogBo();
    }

    @Override
    public IBaseMapper<Long, UserLog> mapper() {
        return userLogMapper;
    }

    public UserLogServiceImpl() {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }
}
