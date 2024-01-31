package cn.peyton.plum.mall.pojo.party;


import java.io.Serializable;
/**
 * <h3> 通讯录分组 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年01月11日 20:51:40
 * @version 1.0.0
 * </pre>
*/
public class ContactGroup implements Serializable {
	/**   */
	private Integer id;
	/** 分组名称  */
	private String name;
	/**
	 * 排序取值范围0~9999，默认为0; 按大到小排序
	 */
	private Short seq;

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
	 * @param name 分组名称 
	 */ 
	public void setName(String name){
		this.name = name;
	}

	/** 
	 * @return 分组名称 
	 */ 
	public String getName(){
		return name;
	}


	/**
	 * @return 排序取值范围0~9999，默认为0; 按大到小排序
	 */
	public Short getSeq() {
		return seq;
	}

	/**
	 * @param seq 排序取值范围0~9999，默认为0; 按大到小排序
	 */
	public void setSeq(Short seq) {
		this.seq = seq;
	}

}
