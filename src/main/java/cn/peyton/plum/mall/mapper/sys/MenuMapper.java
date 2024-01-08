package cn.peyton.plum.mall.mapper.sys;

import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.mall.pojo.sys.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <h3> 菜单 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public interface MenuMapper extends IBaseMapper<Long, Menu> {
    /**
     * <h4>根据用户Id及类型查找菜单对象集合</h4>
     * @param shareId 用户Id
     * @param shareType 用户类型
     * @return
     */
    List<Menu> selectMenuListByShareIdAndType(@Param("shareId") Long shareId, @Param("shareType") Integer shareType);

    /**
     * <h4>超级管理员的权限</h4>
     * <pre>
     *     条件 status = 1 所有权限
     * </pre>
     * @return
     */
    List<Menu> selectMenuListBySuperAdmin();

    /**
     * SELECT * from sys_menu LEFT JOIN sys_role_menu on sys_menu.id = sys_role_menu.menu_id
     * where sys_role_menu.role_id in(select role_id FROM sys_user_role where share_id=1 and share_type=2)
     */
    // ==================================== new create method ==================================== //

    /**
     * <h4>菜单树型查找</h4>
     * @return
     */
    List<Menu> selectByTree();

    /**
     * <h4>根据角色Id 查找</h4>
     * @return
     */
    List<Menu> selectByRoleId(Long roleId);

}
