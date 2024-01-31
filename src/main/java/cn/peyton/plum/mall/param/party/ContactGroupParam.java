package cn.peyton.plum.mall.param.party;


import cn.peyton.plum.core.validator.constraints.Length;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.mall.pojo.party.ContactGroup;

import java.io.Serializable;
/**
 * <h3> 通讯录分组 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年01月11日 20:51:40
 * @version 1.0.0
 * </pre>
*/
public class ContactGroupParam implements Serializable {
	/**   */
	private Integer id;
	/** 分组名称  */
	@NotBlank(message = "分组名称不能为空")
	@Length(min=2,max = 28)
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

	/**
	 * <h4>对象转成ContactGroup对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,name]
	 * </pre>
	 */
	public ContactGroup convert(){ 
		ContactGroup contactGroup = new ContactGroup();
		contactGroup.setId(id);
		contactGroup.setName(name);
		contactGroup.setSeq(seq);
		return contactGroup;
	} 
	/**
	 * <h4>ContactGroup对象转成ContactGroupParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,name]
	 * </pre>
	 */
	public ContactGroupParam compat(ContactGroup contactGroup){ 
		if(null == contactGroup){
			return new ContactGroupParam();
		}
		this.setId(contactGroup.getId());
		this.setName(contactGroup.getName());
		this.setSeq(contactGroup.getSeq());
		return this;
	} 
}
