package cn.peyton.plum.mall.pojo;


import java.io.Serializable;
/**
 * <h3> 会员地址 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
public class MemberAddress implements Serializable {
	/**   */
	private Long id;
	/**   */
	private Long memberId;
	/** 省  */
	private String province;
	/** 市  */
	private String city;
	/** 区  */
	private String district;
	/** 具体地址  */
	private String address;
	/** 邮编  */
	private String zip;
	/** 联系人  */
	private String name;
	/** 联系电话  */
	private String phone;
	/** 最后一次使用  */
	private Integer lastUsedTime;
	/** 创建时间  */
	private Integer createTime;

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
	 * @param memberId  
	 */ 
	public void setMemberId(Long memberId){
		this.memberId = memberId;
	}

	/** 
	 * @return  
	 */ 
	public Long getMemberId(){
		return memberId;
	}

	/** 
	 * @param province 省 
	 */ 
	public void setProvince(String province){
		this.province = province;
	}

	/** 
	 * @return 省 
	 */ 
	public String getProvince(){
		return province;
	}

	/** 
	 * @param city 市 
	 */ 
	public void setCity(String city){
		this.city = city;
	}

	/** 
	 * @return 市 
	 */ 
	public String getCity(){
		return city;
	}

	/** 
	 * @param district 区 
	 */ 
	public void setDistrict(String district){
		this.district = district;
	}

	/** 
	 * @return 区 
	 */ 
	public String getDistrict(){
		return district;
	}

	/** 
	 * @param address 具体地址 
	 */ 
	public void setAddress(String address){
		this.address = address;
	}

	/** 
	 * @return 具体地址 
	 */ 
	public String getAddress(){
		return address;
	}

	/** 
	 * @param zip 邮编 
	 */ 
	public void setZip(String zip){
		this.zip = zip;
	}

	/** 
	 * @return 邮编 
	 */ 
	public String getZip(){
		return zip;
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
	 * @param phone 联系电话 
	 */ 
	public void setPhone(String phone){
		this.phone = phone;
	}

	/** 
	 * @return 联系电话 
	 */ 
	public String getPhone(){
		return phone;
	}

	/** 
	 * @param lastUsedTime 最后一次使用 
	 */ 
	public void setLastUsedTime(Integer lastUsedTime){
		this.lastUsedTime = lastUsedTime;
	}

	/** 
	 * @return 最后一次使用 
	 */ 
	public Integer getLastUsedTime(){
		return lastUsedTime;
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
