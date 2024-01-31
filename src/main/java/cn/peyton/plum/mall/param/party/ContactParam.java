package cn.peyton.plum.mall.param.party;


import cn.peyton.plum.core.utils.DateUtils;
import cn.peyton.plum.core.validator.constraints.Datetime;
import cn.peyton.plum.core.validator.constraints.Length;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.mall.bo.ContactGroupBo;
import cn.peyton.plum.mall.pojo.party.Contact;

import java.io.Serializable;
/**
 * <h3> 通讯录 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年01月11日 20:51:29
 * @version 1.0.0
 * </pre>
*/
public class ContactParam implements Serializable {
	/**   */
	private Integer id;
	/** 联系人  */
	@NotBlank(message = "名称不能为空")
	@Length(min=2,max = 40)
	private String name;
	/** 电话号码多用`,`隔开  */
	@NotBlank(message = "电话|手机号码不能为空")
	@Length(min=2,max = 500)
	private String phone;
	/** 说明备注  */
	private String explain;
	/** 分组Id  */
	private Integer groupId;
	/** 创建时间  */
	@Datetime
	private String createTime;

	/** 分组对象 */
	private ContactGroupParam contactGroup;

	//================================== Constructor =======================================//
	public ContactParam(){
		if (null == contactGroup) { contactGroup = new ContactGroupParam(); }
	}
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
	 * @param name 联系人 
	 */ 
	public void setName(String name){
		this.name = name;
	}

	/** 
	 * @return 联系人 
	 */ 
	public String getName(){
		return name;
	}

	/** 
	 * @param phone 电话号码多用`,`隔开 
	 */ 
	public void setPhone(String phone){
		this.phone = phone;
	}

	/** 
	 * @return 电话号码多用`,`隔开 
	 */ 
	public String getPhone(){
		return phone;
	}

	/** 
	 * @param explain 说明备注 
	 */ 
	public void setExplain(String explain){
		this.explain = explain;
	}

	/** 
	 * @return 说明备注 
	 */ 
	public String getExplain(){
		return explain;
	}

	/** 
	 * @param groupId 分组Id 
	 */ 
	public void setGroupId(Integer groupId){
		this.groupId = groupId;
	}

	/** 
	 * @return 分组Id 
	 */ 
	public Integer getGroupId(){
		return groupId;
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
	 * @return 分组对象
	 */
	public ContactGroupParam getContactGroup() {
		return contactGroup;
	}

	/**
	 * @param contactGroup 分组对象
	 */
	public void setContactGroup(ContactGroupParam contactGroup) {
		this.contactGroup = contactGroup;
	}

	/**
	 * <h4>对象转成Contact对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,name,phone,explain,groupId,createTime]
	 * </pre>
	 */
	public Contact convert(){ 
		Contact contact = new Contact();
		contact.setId(id);
		contact.setName(name);
		contact.setPhone(phone);
		contact.setExplain(explain);
		contact.setGroupId(groupId);
		contact.setCreateTime(DateUtils.dateToTimestamp(createTime));
		contact.setContactGroup(contactGroup.convert());
		return contact;
	} 
	/**
	 * <h4>Contact对象转成ContactParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,name,phone,explain,groupId,createTime]
	 * </pre>
	 */
	public ContactParam compat(Contact contact){ 
		if(null == contact){
			return new ContactParam();
		}
		this.setId(contact.getId());
		this.setName(contact.getName());
		this.setPhone(contact.getPhone());
		this.setExplain(contact.getExplain());
		this.setGroupId(contact.getGroupId());
		this.setCreateTime(DateUtils.timestampToStrDate(contact.getCreateTime()));
		this.setContactGroup(new ContactGroupBo().compat(contact.getContactGroup()));
		return this;
	} 
}
