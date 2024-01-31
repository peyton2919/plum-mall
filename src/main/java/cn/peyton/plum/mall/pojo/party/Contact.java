package cn.peyton.plum.mall.pojo.party;


import java.io.Serializable;
/**
 * <h3> 通讯录 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年01月11日 20:51:29
 * @version 1.0.0
 * </pre>
*/
public class Contact implements Serializable {
	/**   */
	private Integer id;
	/** 联系人  */
	private String name;
	/** 电话号码多用`,`隔开  */
	private String phone;
	/** 说明备注  */
	private String explain;
	/** 分组Id  */
	private Integer groupId;
	/** 创建时间  */
	private Integer createTime;
	/** 分组对象 */
	private ContactGroup contactGroup;

	//================================== Constructor =======================================//
	public Contact(){
		if (null == contactGroup) { contactGroup = new ContactGroup(); }
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
	public void setCreateTime(Integer createTime){
		this.createTime = createTime;
	}

	/** 
	 * @return 创建时间 
	 */ 
	public Integer getCreateTime(){
		return createTime;
	}

	/**
	 * @return 分组对象
	 */
	public ContactGroup getContactGroup() {
		return contactGroup;
	}

	/**
	 * @param contactGroup 分组对象
	 */
	public void setContactGroup(ContactGroup contactGroup) {
		this.contactGroup = contactGroup;
	}

}
