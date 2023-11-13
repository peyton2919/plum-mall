package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractAppRealizeService;
import cn.peyton.plum.mall.bo.RoleMenuBo;
import cn.peyton.plum.mall.mapper.RoleMenuMapper;
import cn.peyton.plum.mall.param.RoleMenuParam;
import cn.peyton.plum.mall.pojo.RoleMenu;
import cn.peyton.plum.mall.service.RoleMenuService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

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
public class RoleMenuServiceImpl extends AbstractAppRealizeService<Long, RoleMenu, RoleMenuParam> implements RoleMenuService {
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

}
