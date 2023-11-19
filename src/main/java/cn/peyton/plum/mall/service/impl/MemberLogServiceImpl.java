package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.mall.bo.MemberLogBo;
import cn.peyton.plum.mall.mapper.MemberLogMapper;
import cn.peyton.plum.mall.param.MemberLogParam;
import cn.peyton.plum.mall.pojo.MemberLog;
import cn.peyton.plum.mall.service.MemberLogService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 会员日志 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("memberLogService")
public class MemberLogServiceImpl extends AbstractRealizeService<Long, MemberLog, MemberLogParam> implements MemberLogService {
    @Resource
    private MemberLogMapper memberLogMapper;

    @Override
    public BaseConvertBo<MemberLog, MemberLogParam> initBo() {
        return new MemberLogBo();
    }

    @Override
    public IBaseMapper<Long, MemberLog> initMapper() {
        return memberLogMapper;
    }

}
