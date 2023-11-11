package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractAppRealizeService;
import cn.peyton.plum.mall.bo.UserDistributionBo;
import cn.peyton.plum.mall.mapper.UserDistributionMapper;
import cn.peyton.plum.mall.param.UserDistributionParam;
import cn.peyton.plum.mall.pojo.UserDistribution;
import cn.peyton.plum.mall.service.UserDistributionService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 用户分销关联(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用) Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:53
 * @version 1.0.0
 * </pre>
 */
@Service("userDistributionService")
public class UserDistributionServiceImpl extends AbstractAppRealizeService<Long, UserDistribution, UserDistributionParam> implements UserDistributionService {
    @Resource
    private UserDistributionMapper userDistributionMapper;

    @Override
    public BaseConvertBo<UserDistribution, UserDistributionParam> initBo() {
        return new UserDistributionBo();
    }

    @Override
    public IBaseMapper<Long, UserDistribution> initMapper() {
        return userDistributionMapper;
    }

}
