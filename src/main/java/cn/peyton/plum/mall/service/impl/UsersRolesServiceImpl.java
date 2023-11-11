package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractAppRealizeService;
import cn.peyton.plum.mall.bo.UsersRolesBo;
import cn.peyton.plum.mall.mapper.UsersRolesMapper;
import cn.peyton.plum.mall.param.UsersRolesParam;
import cn.peyton.plum.mall.pojo.UsersRoles;
import cn.peyton.plum.mall.service.UsersRolesService;
import jakarta.annotation.Resource;
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
@Service("usersRolesService")
public class UsersRolesServiceImpl extends AbstractAppRealizeService<Long, UsersRoles, UsersRolesParam> implements UsersRolesService {
    @Resource
    private UsersRolesMapper usersRolesMapper;

    @Override
    public BaseConvertBo<UsersRoles, UsersRolesParam> initBo() {
        return new UsersRolesBo();
    }

    @Override
    public IBaseMapper<Long, UsersRoles> initMapper() {
        return usersRolesMapper;
    }

}
