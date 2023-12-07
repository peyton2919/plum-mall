package cn.peyton.plum.mall.mapper.sys;

import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.mall.pojo.sys.RoleMenu;

import java.util.List;

/**
 * <h3> 角色菜单关联 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月13日 20:53:15
 * @version 1.0.0
 * </pre>
*/
public interface RoleMenuMapper extends IBaseMapper<Long,RoleMenu> {

    /**
     * <h4>根据角色Id集合 查找 菜单Id集合</h4>
     * @param roleIdList
     * @return
     */
    List<Long> selectMenuIdByRoleIdList(List<Long> roleIdList);

    /**
     * <h4>根据角色ID 删除 角色菜单集</h4>
     * @param roleId
     */
    int deleteMenuByRoleId(Long roleId);

    /**
     * <h4>批量添加 角色菜单集合</h4>
     * @param roleMenuList
     */
    int batchAdd(List<RoleMenu> roleMenuList);

    /**
     * <h4>根据 权限ID 获取 角色ID集合</h4>
     * @param menuId 菜单Id
     * @return 角色ID集合
     */
    List<Long> selectRoleIdListByMenuId(Long menuId);
}
