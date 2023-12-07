package cn.peyton.plum.mall.service.sys.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
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

    public RoleServiceImpl() {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }

    @Override
    public List<RoleParam> findBySelect() {
        String key = keyPrefix + "find_select_all";
        if (enabledCache){
            Object list = cache.get(key);
            if (null != list) {
                System.out.printf("从缓存获取到对象: key= %s;\n",key);
                return (List<RoleParam>)list;
            }
        }
        List<RoleParam> pList = initBo().adapter(roleMapper.selectByAll());

        if (null != pList && pList.size() > 0 && enabledCache) {
            System.out.printf("添加对象到缓存: key= %s;\n",key);
            cache.put(key,pList);
        }
        return pList;
    }

}
