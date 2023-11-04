package cn.peyton.plum.mall.param;


import cn.peyton.plum.mall.pojo.Dict;

import java.io.Serializable;
/**
 * <h3> 数据字典 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
public class DictParam implements Serializable {
	/**   */
	private Long id;
	/** 字典名称  */
	private String name;
	/** 描述  */
	private String explain;

	//================================== Constructor =======================================//

	//================================== Method =======================================//


	//================================== PREFIX_GET AND PREFIX_SET =======================================//

	/** 
	 * @param id  
	 */ 
	public void setId(Long id){
		this.id = id;
	}

	/** 
	 * @return  
	 */ 
	public Long getId(){
		return id;
	}

	/** 
	 * @param name 字典名称 
	 */ 
	public void setName(String name){
		this.name = name;
	}

	/** 
	 * @return 字典名称 
	 */ 
	public String getName(){
		return name;
	}

	/** 
	 * @param explain 描述 
	 */ 
	public void setExplain(String explain){
		this.explain = explain;
	}

	/** 
	 * @return 描述 
	 */ 
	public String getExplain(){
		return explain;
	}

	/**
	 * <h4>对象转成Dict对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,name,explain]
	 * </pre>
	 */
	public Dict convert(){
		Dict dict = new Dict(); 
		dict.setId(id);
		dict.setName(name);
		dict.setExplain(explain);
		return dict;
	} 
	/**
	 * <h4>Dict对象转成DictParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,name,explain]
	 * </pre>
	 */
	public DictParam compat(Dict dict){ 
		if(null == dict){
			return new DictParam();
		}
		this.setId(dict.getId());
		this.setName(dict.getName());
		this.setExplain(dict.getExplain());
		return this;
	} 
}
