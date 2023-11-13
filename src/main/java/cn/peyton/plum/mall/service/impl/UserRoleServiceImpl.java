package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractAppRealizeService;
import cn.peyton.plum.mall.bo.UserRoleBo;
import cn.peyton.plum.mall.mapper.UserRoleMapper;
import cn.peyton.plum.mall.param.UserRoleParam;
import cn.peyton.plum.mall.pojo.UserRole;
import cn.peyton.plum.mall.service.UserRoleService;
import jakarta.annotation.Resource;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;

/**
 * <h3> 用户角色关联 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("userRoleService")
public class UserRoleServiceImpl extends AbstractAppRealizeService<Long, UserRole, UserRoleParam> implements UserRoleService {
    @Resource
    @Transient
    private UserRoleMapper userRoleMapper;

    @Override
    public BaseConvertBo<UserRole, UserRoleParam> initBo() {
        return new UserRoleBo();
    }

    @Override
    public IBaseMapper<Long, UserRole> initMapper() {
        return userRoleMapper;
    }

}
