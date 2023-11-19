package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.mall.bo.RoleBo;
import cn.peyton.plum.mall.mapper.RoleMapper;
import cn.peyton.plum.mall.param.RoleParam;
import cn.peyton.plum.mall.pojo.Role;
import cn.peyton.plum.mall.service.RoleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 角色 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("roleService")
public class RoleServiceImpl extends AbstractRealizeService<Long, Role, RoleParam> implements RoleService {
    @Resource
    private RoleMapper roleMapper;

    @Override
    public BaseConvertBo<Role, RoleParam> initBo() {
        return new RoleBo();
    }

    @Override
    public IBaseMapper<Long, Role> initMapper() {
        return roleMapper;
    }

}
