package cn.peyton.plum.mall.service.sys.impl;

import cn.peyton.plum.core.err.GlobalException;
import cn.peyton.plum.core.err.ValidationException;
import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.mall.bo.RoleMenuBo;
import cn.peyton.plum.mall.mapper.sys.RoleMenuMapper;
import cn.peyton.plum.mall.param.sys.RoleMenuParam;
import cn.peyton.plum.mall.pojo.sys.RoleMenu;
import cn.peyton.plum.mall.service.sys.RoleMenuService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <h3> 角色菜单关联 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("roleMenuService")
public class RoleMenuServiceImpl extends AbstractRealizeService<Long, RoleMenu, RoleMenuParam> implements RoleMenuService {
    @Resource
    private RoleMenuMapper roleMenuMapper;

    @Override
    public BaseConvertBo<RoleMenu, RoleMenuParam> initBo() {
        return new RoleMenuBo();
    }

    @Override
    public IBaseMapper<Long, RoleMenu> initMapper() {
        return roleMenuMapper;
    }

    public RoleMenuServiceImpl() {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }

    @Override
    @Transactional(rollbackFor = {ValidationException.class, GlobalException.class, RuntimeException.class, Exception.class},
            propagation = Propagation.REQUIRED)
    public Boolean batchAdd(List<RoleMenuParam> roleMenuParamList) {
        roleMenuMapper.deleteMenuByRoleId(roleMenuParamList.get(0).getRoleId());
        Integer res = roleMenuMapper.batchAdd(new RoleMenuBo().reverse(roleMenuParamList));
        if(res>0){
            if (enabledCache){
                System.out.printf("更新数据操作,清空缓存;\n");
                removeCache();
            }
            return true;
        }
        return false;
    }

}
