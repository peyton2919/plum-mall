package cn.peyton.plum.mall.pojo;


import java.io.Serializable;
/**
 * <h3> 数据字典详情 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
public class DictDetail implements Serializable {
	/**   */
	private Long id;
	/** 字典标签  */
	private String label;
	/** 字典值  */
	private String value;
	/** 排序，默认为0; 按大到小排序  */
	private Integer seq;
	/** 字典id  */
	private Long dictId;
	/** 字典名称  */
	private String dictName;

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
	 * @param label 字典标签 
	 */ 
	public void setLabel(String label){
		this.label = label;
	}

	/** 
	 * @return 字典标签 
	 */ 
	public String getLabel(){
		return label;
	}

	/** 
	 * @param value 字典值 
	 */ 
	public void setValue(String value){
		this.value = value;
	}

	/** 
	 * @return 字典值 
	 */ 
	public String getValue(){
		return value;
	}

	/** 
	 * @param seq 排序，默认为0; 按大到小排序 
	 */ 
	public void setSeq(Integer seq){
		this.seq = seq;
	}

	/** 
	 * @return 排序，默认为0; 按大到小排序 
	 */ 
	public Integer getSeq(){
		return seq;
	}

	/** 
	 * @param dictId 字典id 
	 */ 
	public void setDictId(Long dictId){
		this.dictId = dictId;
	}

	/** 
	 * @return 字典id 
	 */ 
	public Long getDictId(){
		return dictId;
	}

	/** 
	 * @param dictName 字典名称 
	 */ 
	public void setDictName(String dictName){
		this.dictName = dictName;
	}

	/** 
	 * @return 字典名称 
	 */ 
	public String getDictName(){
		return dictName;
	}

}
