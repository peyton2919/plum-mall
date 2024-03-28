package cn.peyton.plum.mall.service.sys.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.RealizeService;
import cn.peyton.plum.mall.bo.JobBo;
import cn.peyton.plum.mall.mapper.sys.JobMapper;
import cn.peyton.plum.mall.param.sys.JobParam;
import cn.peyton.plum.mall.pojo.sys.Job;
import cn.peyton.plum.mall.service.sys.JobService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 岗位 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("jobService")
public class JobServiceImpl extends RealizeService<Integer, Job, JobParam> implements JobService {
    @Resource
    private JobMapper jobMapper;

    @Override
    public BaseConvertBo<Job, JobParam> bo() {
        return new JobBo();
    }

    @Override
    public IBaseMapper<Integer, Job> mapper() {
        return jobMapper;
    }

    public JobServiceImpl () {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }
}
