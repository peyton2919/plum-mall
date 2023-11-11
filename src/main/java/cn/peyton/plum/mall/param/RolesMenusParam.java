package cn.peyton.plum.mall.param;


import cn.peyton.plum.mall.pojo.RolesMenus;

import java.io.Serializable;

/**
 * <h3> 角色菜单关联 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:24
 * @version 1.0.0
 * </pre>
 */
public class RolesMenusParam implements Serializable {
    /**
     *
     */
    private Long id;
    /**
     * 菜单ID
     */
    private Long menuId;
    /**
     * 角色ID
     */
    private Long roleId;

    //================================== Constructor =======================================//

    //================================== Method =======================================//


    //================================== PREFIX_GET AND PREFIX_SET =======================================//

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * @param menuId 菜单ID
     */
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    /**
     * @return 菜单ID
     */
    public Long getMenuId() {
        return menuId;
    }

    /**
     * @param roleId 角色ID
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * @return 角色ID
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * <h4>对象转成RolesMenus对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,menuId,roleId]
     * </pre>
     */
    public RolesMenus convert() {
        RolesMenus rolesMenus = new RolesMenus();
        rolesMenus.setId(id);
        rolesMenus.setMenuId(menuId);
        rolesMenus.setRoleId(roleId);
        return rolesMenus;
    }

    /**
     * <h4>RolesMenus对象转成RolesMenusParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,menuId,roleId]
     * </pre>
     */
    public RolesMenusParam compat(RolesMenus rolesMenus) {
        if (null == rolesMenus) {
            return new RolesMenusParam();
        }
        this.setId(rolesMenus.getId());
        this.setMenuId(rolesMenus.getMenuId());
        this.setRoleId(rolesMenus.getRoleId());
        return this;
    }
}
