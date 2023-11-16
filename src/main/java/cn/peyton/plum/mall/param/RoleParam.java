package cn.peyton.plum.mall.param;


import cn.peyton.plum.mall.pojo.Role;

import java.io.Serializable;

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

    //================================== Constructor =======================================//

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
        role.setCreateTime(createTime);
        role.setPermission(permission);
        role.setUpdateTime(updateTime);
        role.setIsDel(isDel);
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
        this.setCreateTime(role.getCreateTime());
        this.setPermission(role.getPermission());
        this.setUpdateTime(role.getUpdateTime());
        this.setIsDel(role.getIsDel());
        return this;
    }
}
