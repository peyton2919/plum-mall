package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractAppRealizeService;
import cn.peyton.plum.mall.bo.JobBo;
import cn.peyton.plum.mall.mapper.JobMapper;
import cn.peyton.plum.mall.param.JobParam;
import cn.peyton.plum.mall.pojo.Job;
import cn.peyton.plum.mall.service.JobService;
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
public class JobServiceImpl extends AbstractAppRealizeService<Integer, Job, JobParam> implements JobService {
    @Resource
    private JobMapper jobMapper;

    @Override
    public BaseConvertBo<Job, JobParam> initBo() {
        return new JobBo();
    }

    @Override
    public IBaseMapper<Integer, Job> initMapper() {
        return jobMapper;
    }

}
