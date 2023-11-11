package cn.peyton.plum.mall.pojo;


import java.io.Serializable;

/**
 * <h3> 菜单 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public class Menu implements Serializable {
    /**
     * ID
     */
    private Long id;
    /**
     * 是否外链,默认0没有外链接,1外链接
     */
    private Integer iFrame;
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 组件
     */
    private String component;
    /**
     * 上级菜单ID
     */
    private Long pid;
    /**
     * 排序取值范围0~9999，默认为0; 按大到小排序
     */
    private Short seq;
    /**
     * 图标
     */
    private String icon;
    /**
     * 链接地址
     */
    private String path;
    /**
     * 是否缓存; 默认 0不缓存, 1缓存
     */
    private Integer cache;
    /**
     * 是否隐藏; 默认0不隐藏, 1隐藏
     */
    private Integer hidden;
    /**
     * 组件名称
     */
    private String componentName;
    /**
     * 创建日期
     */
    private Integer createTime;
    /**
     * 权限
     */
    private String permission;
    /**
     * 类型: 默认 0 {0 文字1 图片2 按钮3 ICON}
     */
    private Integer type;
    /**
     * 是否删除: 默认1(1：可用;0已删除)
     */
    private Integer isDel;
    /**
     * 操作的路由
     */
    private String router;
    /**
     * 路由动作
     */
    private String routerMethod;

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
     * @param iFrame 是否外链,默认0没有外链接,1外链接
     */
    public void setIFrame(Integer iFrame) {
        this.iFrame = iFrame;
    }

    /**
     * @return 是否外链, 默认0没有外链接, 1外链接
     */
    public Integer getIFrame() {
        return iFrame;
    }

    /**
     * @param name 菜单名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return 菜单名称
     */
    public String getName() {
        return name;
    }

    /**
     * @param component 组件
     */
    public void setComponent(String component) {
        this.component = component;
    }

    /**
     * @return 组件
     */
    public String getComponent() {
        return component;
    }

    /**
     * @param pid 上级菜单ID
     */
    public void setPid(Long pid) {
        this.pid = pid;
    }

    /**
     * @return 上级菜单ID
     */
    public Long getPid() {
        return pid;
    }

    /**
     * @param seq 排序取值范围0~9999，默认为0; 按大到小排序
     */
    public void setSeq(Short seq) {
        this.seq = seq;
    }

    /**
     * @return 排序取值范围0~9999，默认为0; 按大到小排序
     */
    public Short getSeq() {
        return seq;
    }

    /**
     * @param icon 图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * @return 图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @param path 链接地址
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return 链接地址
     */
    public String getPath() {
        return path;
    }

    /**
     * @param cache 是否缓存; 默认 0不缓存, 1缓存
     */
    public void setCache(Integer cache) {
        this.cache = cache;
    }

    /**
     * @return 是否缓存; 默认 0不缓存, 1缓存
     */
    public Integer getCache() {
        return cache;
    }

    /**
     * @param hidden 是否隐藏; 默认0不隐藏, 1隐藏
     */
    public void setHidden(Integer hidden) {
        this.hidden = hidden;
    }

    /**
     * @return 是否隐藏; 默认0不隐藏, 1隐藏
     */
    public Integer getHidden() {
        return hidden;
    }

    /**
     * @param componentName 组件名称
     */
    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    /**
     * @return 组件名称
     */
    public String getComponentName() {
        return componentName;
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
     * @param permission 权限
     */
    public void setPermission(String permission) {
        this.permission = permission;
    }

    /**
     * @return 权限
     */
    public String getPermission() {
        return permission;
    }

    /**
     * @param type 类型: 默认 0 {0 文字1 图片2 按钮3 ICON}
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @return 类型: 默认 0 {0 文字1 图片2 按钮3 ICON}
     */
    public Integer getType() {
        return type;
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
     * @param router 操作的路由
     */
    public void setRouter(String router) {
        this.router = router;
    }

    /**
     * @return 操作的路由
     */
    public String getRouter() {
        return router;
    }

    /**
     * @param routerMethod 路由动作
     */
    public void setRouterMethod(String routerMethod) {
        this.routerMethod = routerMethod;
    }

    /**
     * @return 路由动作
     */
    public String getRouterMethod() {
        return routerMethod;
    }

}
