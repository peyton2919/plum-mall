package cn.peyton.plum.mall.param.sys;


import cn.peyton.plum.core.utils.DateUtils;
import cn.peyton.plum.core.validator.constraints.Length;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.core.validator.constraints.Size;
import cn.peyton.plum.mall.bo.MenuBo;
import cn.peyton.plum.mall.pojo.sys.Role;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <h3> 角色 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:24
 * @version 1.0.0
 * </pre>
 */
public class RoleParam implements Serializable {
    /**
     * ID
     */
    private Long id;
    /**
     * 名称
     */
    @NotBlank(message = "角色名称不能为空")
    @Length(min = 3,max = 40)
    private String name;
    /**
     * 备注
     */
    private String remark;
    /**
     * 数据权限
     */
    private String dataScope;
    /**
     * 角色级别
     */
    private Integer level;
    /**
     * 创建日期
     */
    private String createTime;
    /**
     * 功能权限
     */
    private String permission;
    /**
     * 更新时间
     */
    private String updateTime;
    /**
     * 是否删除: 默认1(1：可用;0已删除)
     */
    private Integer isDel;
    /** 是否启用, 默认 1 启用 0 禁用 */
    @Size(min = 0,max = 1)
    private Integer status;
    /** 角色对应的菜单集合 */
    private List<MenuParam> menus;

    //================================== Constructor =======================================//
    public RoleParam(){
        if (null == menus) {
            menus = new ArrayList<>();
        }
    }
    //================================== Method =======================================//


    //================================== PREFIX_GET AND PREFIX_SET =======================================//

    /**
     * @param id ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return ID
     */
    public Long getId() {
        return id;
    }

    /**
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return 名称
     */
    public String getName() {
        return name;
    }

    /**
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param dataScope 数据权限
     */
    public void setDataScope(String dataScope) {
        this.dataScope = dataScope;
    }

    /**
     * @return 数据权限
     */
    public String getDataScope() {
        return dataScope;
    }

    /**
     * @param level 角色级别
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * @return 角色级别
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * @param createTime 创建日期
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * @return 创建日期
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * @param permission 功能权限
     */
    public void setPermission(String permission) {
        this.permission = permission;
    }

    /**
     * @return 功能权限
     */
    public String getPermission() {
        return permission;
    }

    /**
     * @param updateTime 更新时间
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return 更新时间
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * @param isDel 是否删除: 默认1(1：可用;0已删除)
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    /**
     * @return 是否删除: 默认1(1：可用;0已删除)
     */
    public Integer getIsDel() {
        return isDel;
    }
    /**
     * @return 是否启用, 默认 1 启用 0 禁用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status 是否启用, 默认 1 启用 0 禁用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return 角色对应的菜单集合
     */
    public List<MenuParam> getMenus() {
        return menus;
    }

    /**
     * @param menus 角色对应的菜单集合
     */
    public void setMenus(List<MenuParam> menus) {
        this.menus = menus;
    }

    /**
     * <h4>对象转成Role对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,name,remark,dataScope,level,createTime,permission,updateTime,isDel]
     * </pre>
     */
    public Role convert() {
        Role role = new Role();
        if(null == this){
            return null;
        }
        role.setId(id);
        role.setName(name);
        role.setRemark(remark);
        role.setDataScope(dataScope);
        role.setLevel(level);
        role.setCreateTime(DateUtils.dateToTimestamp(createTime));
        role.setPermission(permission);
        role.setUpdateTime(DateUtils.dateToTimestamp(updateTime));
        role.setIsDel(isDel);
        role.setStatus(status);
        role.setMenus(new MenuBo().reverse(menus));
        return role;
    }

    /**
     * <h4>Role对象转成RoleParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,name,remark,dataScope,level,createTime,permission,updateTime,isDel]
     * </pre>
     */
    public RoleParam compat(Role role) {
        if (null == role) {
            return new RoleParam();
        }
        this.setId(role.getId());
        this.setName(role.getName());
        this.setRemark(role.getRemark());
        this.setDataScope(role.getDataScope());
        this.setLevel(role.getLevel());
        this.setCreateTime(DateUtils.timestampToStrDate(role.getCreateTime()));
        this.setPermission(role.getPermission());
        this.setUpdateTime(DateUtils.timestampToStrDate(role.getUpdateTime()));
        this.setIsDel(role.getIsDel());
        this.setStatus(role.getStatus());
        this.setMenus(new MenuBo().adapter(role.getMenus()));
        return this;
    }
}
