package cn.peyton.plum.mall.pojo.app;


import java.io.Serializable;
/**
 * <h3> App 导航 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年01月20日 09:24:55
 * @version 1.0.0
 * </pre>
*/
public class AppNav implements Serializable {
	/**   */
	private Integer id;
	/** 标题  */
	private String title;
	/** icon  */
	private String icon;
	/** 图标地址  */
	private String src;
	/** 点击图标跳转地址  */
	private String url;
	/** 排序取值范围0~9999，默认为0; 按大到小排序  */
	private Short seq;
	/** 状态：1启用、0禁用  */
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

}
