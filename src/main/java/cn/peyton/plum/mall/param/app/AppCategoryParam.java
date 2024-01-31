package cn.peyton.plum.mall.param.app;


import cn.peyton.plum.core.utils.DateUtils;
import cn.peyton.plum.core.validator.constraints.*;
import cn.peyton.plum.mall.pojo.app.AppCategory;

import java.io.Serializable;
/**
 * <h3> App 分类 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年01月20日 09:24:43
 * @version 1.0.0
 * </pre>
*/
public class AppCategoryParam implements Serializable {
	/**   */
	private Integer id;
	/** 名称  */
	@NotBlank(message = "名称不能为空")
	@Length(min = 2,max = 50)
	private String name;
	/** 排序取值范围0~9999，默认为0; 按大到小排序  */
	@Size(min = 0,max = 9999)
	private Short seq;
	/** 状态：1启用、0禁用  */
	@Size(min = 0,max = 1)
	private Integer status;
	/** 模板名称{index,special},根据模板获取不同的数据  */
	@NotBlank(message = "模板名称不能为空")
	@Length(min = 2,max = 50)
	private String template;
	/** 类型 默认 0 首页导航分类  */
	@Min(message = "最小值为0")
	private Integer genre;
	/** 创建时间  */
	@Datetime
	private String createTime;

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
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}

	/** 
	 * @return 创建时间 
	 */ 
	public String getCreateTime(){
		return createTime;
	}

	/**
	 * <h4>对象转成AppCategory对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,name,seq,status,template,genre,createTime]
	 * </pre>
	 */
	public AppCategory convert(){
		AppCategory appCategory = new AppCategory();
		appCategory.setId(id);
		appCategory.setName(name);
		appCategory.setSeq(seq);
		appCategory.setStatus(status);
		appCategory.setTemplate(template);
		appCategory.setGenre(genre);
		appCategory.setCreateTime(DateUtils.dateToTimestamp(createTime));
		return appCategory;
	} 
	/**
	 * <h4>AppCategory对象转成AppCategoryParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,name,seq,status,template,genre,createTime]
	 * </pre>
	 */
	public AppCategoryParam compat(AppCategory appCategory){
		if(null == appCategory){
			return new AppCategoryParam();
		}
		this.setId(appCategory.getId());
		this.setName(appCategory.getName());
		this.setSeq(appCategory.getSeq());
		this.setStatus(appCategory.getStatus());
		this.setTemplate(appCategory.getTemplate());
		this.setGenre(appCategory.getGenre());
		this.setCreateTime(DateUtils.timestampToStrDate(appCategory.getCreateTime()));
		return this;
	} 
}
