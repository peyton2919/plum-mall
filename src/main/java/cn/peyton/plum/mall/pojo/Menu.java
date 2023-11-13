package cn.peyton.plum.mall.pojo;


import java.io.Serializable;
import java.util.List;

/**
 * <h3> 菜单 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月12日 16:54:56
 * @version 1.0.0
 * </pre>
*/
public class Menu implements Serializable {
	/** ID  */
	private Long id;
	/** 上级菜单ID  */
	private Long pid;
	/** 菜单名称  */
	private String name;
	/** 是否是菜单，默认 0否 1是  */
	private Integer isMenu;
	/** 后端规则，由后端提供的接口别名（menu为0时必填）  */
	private String condition;
	/** 前台路由注册路径  */
	private String frontPath;
	/** 路由动作  */
	private String routerMethod;
	/** 排序取值范围0~9999，默认为0; 按大到小排序  */
	private Short seq;
	/** 图标  */
	private String icon;
	/** 是否启用, 默认 1 启用 0 禁用  */
	private Integer status;
	/** 是否外链,默认0没有外链接,1外链接  */
	private Integer iFrame;
	/** 类型: 默认 0 {0 文字1 图片2 按钮3 ICON}  */
	private Integer menuType;
	/** 链接地址  */
	private String path;
	/** 权限  */
	private String permission;
	/** 是否缓存; 默认 0不缓存, 1缓存  */
	private Integer cache;
	/** 是否隐藏; 默认0不隐藏, 1隐藏  */
	private Integer hidden;
	/** 组件  */
	private String component;
	/** 组件名称  */
	private String componentName;
	/** 创建日期  */
	private Integer createTime;
	/** 子菜单集合 */
	private List<Menu> children;

	//================================== Constructor =======================================//

	//================================== Method =======================================//


	//================================== PREFIX_GET AND PREFIX_SET =======================================//

	/** 
	 * @param id ID 
	 */ 
	public void setId(Long id){
		this.id = id;
	}

	/** 
	 * @return ID 
	 */ 
	public Long getId(){
		return id;
	}

	/** 
	 * @param pid 上级菜单ID 
	 */ 
	public void setPid(Long pid){
		this.pid = pid;
	}

	/** 
	 * @return 上级菜单ID 
	 */ 
	public Long getPid(){
		return pid;
	}

	/** 
	 * @param name 菜单名称 
	 */ 
	public void setName(String name){
		this.name = name;
	}

	/** 
	 * @return 菜单名称 
	 */ 
	public String getName(){
		return name;
	}

	/** 
	 * @param isMenu 是否是菜单，默认 0否 1是 
	 */ 
	public void setIsMenu(Integer isMenu){
		this.isMenu = isMenu;
	}

	/** 
	 * @return 是否是菜单，默认 0否 1是 
	 */ 
	public Integer getIsMenu(){
		return isMenu;
	}

	/** 
	 * @param condition 后端规则，由后端提供的接口别名（menu为0时必填） 
	 */ 
	public void setCondition(String condition){
		this.condition = condition;
	}

	/** 
	 * @return 后端规则，由后端提供的接口别名（menu为0时必填） 
	 */ 
	public String getCondition(){
		return condition;
	}

	/** 
	 * @param frontPath 前台路由注册路径 
	 */ 
	public void setFrontPath(String frontPath){
		this.frontPath = frontPath;
	}

	/** 
	 * @return 前台路由注册路径 
	 */ 
	public String getFrontPath(){
		return frontPath;
	}

	/** 
	 * @param routerMethod 路由动作 
	 */ 
	public void setRouterMethod(String routerMethod){
		this.routerMethod = routerMethod;
	}

	/** 
	 * @return 路由动作 
	 */ 
	public String getRouterMethod(){
		return routerMethod;
	}

	/** 
	 * @param seq 排序取值范围0~9999，默认为0; 按大到小排序 
	 */ 
	public void setSeq(Short seq){
		this.seq = seq;
	}

	/** 
	 * @return 排序取值范围0~9999，默认为0; 按大到小排序 
	 */ 
	public Short getSeq(){
		return seq;
	}

	/** 
	 * @param icon 图标 
	 */ 
	public void setIcon(String icon){
		this.icon = icon;
	}

	/** 
	 * @return 图标 
	 */ 
	public String getIcon(){
		return icon;
	}

	/** 
	 * @param status 是否启用, 默认 1 启用 0 禁用 
	 */ 
	public void setStatus(Integer status){
		this.status = status;
	}

	/** 
	 * @return 是否启用, 默认 1 启用 0 禁用 
	 */ 
	public Integer getStatus(){
		return status;
	}

	/** 
	 * @param iFrame 是否外链,默认0没有外链接,1外链接 
	 */ 
	public void setIFrame(Integer iFrame){
		this.iFrame = iFrame;
	}

	/** 
	 * @return 是否外链,默认0没有外链接,1外链接 
	 */ 
	public Integer getIFrame(){
		return iFrame;
	}

	/** 
	 * @param menuType 类型: 默认 0 {0 文字1 图片2 按钮3 ICON} 
	 */ 
	public void setMenuType(Integer menuType){
		this.menuType = menuType;
	}

	/** 
	 * @return 类型: 默认 0 {0 文字1 图片2 按钮3 ICON} 
	 */ 
	public Integer getMenuType(){
		return menuType;
	}

	/** 
	 * @param path 链接地址 
	 */ 
	public void setPath(String path){
		this.path = path;
	}

	/** 
	 * @return 链接地址 
	 */ 
	public String getPath(){
		return path;
	}

	/** 
	 * @param permission 权限 
	 */ 
	public void setPermission(String permission){
		this.permission = permission;
	}

	/** 
	 * @return 权限 
	 */ 
	public String getPermission(){
		return permission;
	}

	/** 
	 * @param cache 是否缓存; 默认 0不缓存, 1缓存 
	 */ 
	public void setCache(Integer cache){
		this.cache = cache;
	}

	/** 
	 * @return 是否缓存; 默认 0不缓存, 1缓存 
	 */ 
	public Integer getCache(){
		return cache;
	}

	/** 
	 * @param hidden 是否隐藏; 默认0不隐藏, 1隐藏 
	 */ 
	public void setHidden(Integer hidden){
		this.hidden = hidden;
	}

	/** 
	 * @return 是否隐藏; 默认0不隐藏, 1隐藏 
	 */ 
	public Integer getHidden(){
		return hidden;
	}

	/** 
	 * @param component 组件 
	 */ 
	public void setComponent(String component){
		this.component = component;
	}

	/** 
	 * @return 组件 
	 */ 
	public String getComponent(){
		return component;
	}

	/** 
	 * @param componentName 组件名称 
	 */ 
	public void setComponentName(String componentName){
		this.componentName = componentName;
	}

	/** 
	 * @return 组件名称 
	 */ 
	public String getComponentName(){
		return componentName;
	}

	/** 
	 * @param createTime 创建日期 
	 */ 
	public void setCreateTime(Integer createTime){
		this.createTime = createTime;
	}

	/** 
	 * @return 创建日期 
	 */ 
	public Integer getCreateTime(){
		return createTime;
	}

	/**
	 * @return 子菜单集合
	 */
	public List<Menu> getChildren() {
		return children;
	}

	/**
	 * @param children 子菜单集合
	 */
	public void setChildren(List<Menu> children) {
		this.children = children;
	}
}
