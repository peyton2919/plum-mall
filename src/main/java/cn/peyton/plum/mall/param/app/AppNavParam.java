package cn.peyton.plum.mall.param.app;


import cn.peyton.plum.core.anno.img.ImageHostPath;
import cn.peyton.plum.core.validator.constraints.Length;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.core.validator.constraints.Size;
import cn.peyton.plum.mall.pojo.app.AppNav;

import java.io.Serializable;
/**
 * <h3> App 导航 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年01月20日 09:24:55
 * @version 1.0.0
 * </pre>
*/
@ImageHostPath(name = "src")
public class AppNavParam implements Serializable {
	/**   */
	private Integer id;
	/** 标题  */
	@NotBlank(message = "标题不能为空")
	private String title;
	/** icon  */
	@Length(min=1,max = 128)
	private String icon;
	/** 图标地址  */
	@Length(min=1,max = 512)
	private String src;
	/** 点击图标跳转地址  */
	@Length(min=1,max = 512)
	private String url;
	/** 排序取值范围0~9999，默认为0; 按大到小排序  */
	@Size(min = 0,max = 9999)
	private Short seq;
	/** 状态：1启用、0禁用  */
	@Size(min = 0,max = 1)
	private Integer status;

	//================================== Constructor =======================================//

	//================================== Method =======================================//


	//================================== PREFIX_GET AND PREFIX_SET =======================================//

	/** 
	 * @param id  
	 */ 
	public void setId(Integer id){
		this.id = id;
	}

	/** 
	 * @return  
	 */ 
	public Integer getId(){
		return id;
	}

	/** 
	 * @param title 标题 
	 */ 
	public void setTitle(String title){
		this.title = title;
	}

	/** 
	 * @return 标题 
	 */ 
	public String getTitle(){
		return title;
	}

	/** 
	 * @param icon icon 
	 */ 
	public void setIcon(String icon){
		this.icon = icon;
	}

	/** 
	 * @return icon 
	 */ 
	public String getIcon(){
		return icon;
	}

	/** 
	 * @param src 图标地址 
	 */ 
	public void setSrc(String src){
		this.src = src;
	}

	/** 
	 * @return 图标地址 
	 */ 
	public String getSrc(){
		return src;
	}

	/** 
	 * @param url 点击图标跳转地址 
	 */ 
	public void setUrl(String url){
		this.url = url;
	}

	/** 
	 * @return 点击图标跳转地址 
	 */ 
	public String getUrl(){
		return url;
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
	 * @param status 状态：1启用、0禁用 
	 */ 
	public void setStatus(Integer status){
		this.status = status;
	}

	/** 
	 * @return 状态：1启用、0禁用 
	 */ 
	public Integer getStatus(){
		return status;
	}

	/**
	 * <h4>对象转成AppNav对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,title,icon,src,url,seq,status]
	 * </pre>
	 */
	public AppNav convert(){
		AppNav appNav = new AppNav();
		appNav.setId(id);
		appNav.setTitle(title);
		appNav.setIcon(icon);
		appNav.setSrc(src);
		appNav.setUrl(url);
		appNav.setSeq(seq);
		appNav.setStatus(status);
		return appNav;
	} 
	/**
	 * <h4>AppNav对象转成AppNavParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,title,icon,src,url,seq,status]
	 * </pre>
	 */
	public AppNavParam compat(AppNav appNav){
		if(null == appNav){
			return new AppNavParam();
		}
		this.setId(appNav.getId());
		this.setTitle(appNav.getTitle());
		this.setIcon(appNav.getIcon());
		this.setSrc(appNav.getSrc());
		this.setUrl(appNav.getUrl());
		this.setSeq(appNav.getSeq());
		this.setStatus(appNav.getStatus());
		return this;
	} 
}
