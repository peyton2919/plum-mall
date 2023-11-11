package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractAppRealizeService;
import cn.peyton.plum.mall.bo.UserExtractBo;
import cn.peyton.plum.mall.mapper.UserExtractMapper;
import cn.peyton.plum.mall.param.UserExtractParam;
import cn.peyton.plum.mall.pojo.UserExtract;
import cn.peyton.plum.mall.service.UserExtractService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 用户提现 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:53
 * @version 1.0.0
 * </pre>
 */
@Service("userExtractService")
public class UserExtractServiceImpl extends AbstractAppRealizeService<Long, UserExtract, UserExtractParam> implements UserExtractService {
    @Resource
    private UserExtractMapper userExtractMapper;

    @Override
    public BaseConvertBo<UserExtract, UserExtractParam> initBo() {
        return new UserExtractBo();
    }

    @Override
    public IBaseMapper<Long, UserExtract> initMapper() {
        return userExtractMapper;
    }

}
