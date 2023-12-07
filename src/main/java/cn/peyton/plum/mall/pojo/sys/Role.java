package cn.peyton.plum.mall.pojo.sys;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <h3> 角色 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public class Role implements Serializable {
    /**
     * ID
     */
    private Long id;
    /**
     * 名称
     */
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
    private Integer createTime;
    /**
     * 功能权限
     */
    private String permission;
    /**
     * 更新时间
     */
    private Integer updateTime;
    /**
     * 是否删除: 默认1(1：可用;0已删除)
     */
    private Integer isDel;
    /** 是否启用, 默认 1 启用 0 禁用 */
    private Integer status;
    /** 角色对应的菜单集合 */
    private List<Menu> menus;
    //================================== Constructor =======================================//
    public Role(){
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
    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    /**
     * @return 创建日期
     */
    public Integer getCreateTime() {
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
    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return 更新时间
     */
    public Integer getUpdateTime() {
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
    public List<Menu> getMenus() {
        return menus;
    }

    /**
     * @param menus 角色对应的菜单集合
     */
    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}
