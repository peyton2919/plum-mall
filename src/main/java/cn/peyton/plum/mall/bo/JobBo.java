package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.JobParam;
import cn.peyton.plum.mall.pojo.Job;

/**
 * <h3> 岗位 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class JobBo extends BaseConvertBo<Job, JobParam> {

    @Override
    public JobParam compat(Job info) {
        return new JobParam().compat(info);
    }

    @Override
    public Job convert(JobParam info) {
        return info.convert();
    }
}
