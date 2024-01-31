package cn.peyton.plum.mall.pojo.app;


import java.io.Serializable;
/**
 * <h3> App 分类 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年01月20日 09:24:43
 * @version 1.0.0
 * </pre>
*/
public class AppCategory implements Serializable {
	/**   */
	private Integer id;
	/** 名称  */
	private String name;
	/** 排序取值范围0~9999，默认为0; 按大到小排序  */
	private Short seq;
	/** 状态：1启用、0禁用  */
	private Integer status;
	/** 模板名称{index,special},根据模板获取不同的数据  */
	private String template;
	/** 类型 默认 0 首页导航分类  */
	private Integer genre;
	/** 创建时间  */
	private Integer createTime;

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
	 * @param name 名称 
	 */ 
	public void setName(String name){
		this.name = name;
	}

	/** 
	 * @return 名称 
	 */ 
	public String getName(){
		return name;
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
	 * @param template 模板名称{index,special},根据模板获取不同的数据 
	 */ 
	public void setTemplate(String template){
		this.template = template;
	}

	/** 
	 * @return 模板名称{index,special},根据模板获取不同的数据 
	 */ 
	public String getTemplate(){
		return template;
	}

	/** 
	 * @param genre 类型 默认 0 首页导航分类 
	 */ 
	public void setGenre(Integer genre){
		this.genre = genre;
	}

	/** 
	 * @return 类型 默认 0 首页导航分类 
	 */ 
	public Integer getGenre(){
		return genre;
	}

	/** 
	 * @param createTime 创建时间 
	 */ 
	public void setCreateTime(Integer createTime){
		this.createTime = createTime;
	}

	/** 
	 * @return 创建时间 
	 */ 
	public Integer getCreateTime(){
		return createTime;
	}

}
