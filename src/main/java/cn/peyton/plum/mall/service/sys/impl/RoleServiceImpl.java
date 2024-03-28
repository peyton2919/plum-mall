package cn.peyton.plum.mall.service.sys.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.RealizeService;
import cn.peyton.plum.mall.bo.RoleBo;
import cn.peyton.plum.mall.mapper.sys.RoleMapper;
import cn.peyton.plum.mall.param.sys.RoleParam;
import cn.peyton.plum.mall.pojo.sys.Role;
import cn.peyton.plum.mall.service.sys.RoleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

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
public class RoleServiceImpl extends RealizeService<Long, Role, RoleParam> implements RoleService {
    @Resource
    private RoleMapper roleMapper;

    @Override
    public BaseConvertBo<Role, RoleParam> bo() {
        return new RoleBo();
    }

    @Override
    public IBaseMapper<Long, Role> mapper() {
        return roleMapper;
    }

    public RoleServiceImpl() {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }

    @Override
    public List<RoleParam> findBySelect() {
        String key = keyPrefix + "find_select_all";
        Object objs = getCache(key);
        if (null == objs) {
            List<RoleParam> adapter = bo().adapter(roleMapper.selectByAll());
            saveCache(key, adapter);
            return adapter;
        }
        return (List<RoleParam>) objs;


    }

}
