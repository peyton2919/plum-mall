package cn.peyton.plum.mall.pojo;


import java.io.Serializable;
/**
 * <h3> 供应商基础信息 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
public class SupplierInfo implements Serializable {
	/** 编号  */
	private Long id;
	/** 供应商ID  */
	private Long supId;
	/** 地址  */
	private String add;
	/** 邮箱  */
	private String email;
	/** 电话  */
	private String tel;
	/** QQ号  */
	private String qq;
	/** 传真  */
	private String fax;
	/** 性别：默认 0{0 保密 1 男 2 女}  */
	private Integer sex;
	/** 生日  */
	private String birthday;
	/** 说明  */
	private String explain;
	/** 外接网址  */
	private String webSite;
	/** 连接外网标识码  */
	private String webCode;

	//================================== Constructor =======================================//

	//================================== Method =======================================//


	//================================== PREFIX_GET AND PREFIX_SET =======================================//

	/** 
	 * @param id 编号 
	 */ 
	public void setId(Long id){
		this.id = id;
	}

	/** 
	 * @return 编号 
	 */ 
	public Long getId(){
		return id;
	}

	/** 
	 * @param supId 供应商ID 
	 */ 
	public void setSupId(Long supId){
		this.supId = supId;
	}

	/** 
	 * @return 供应商ID 
	 */ 
	public Long getSupId(){
		return supId;
	}

	/** 
	 * @param add 地址 
	 */ 
	public void setAdd(String add){
		this.add = add;
	}

	/** 
	 * @return 地址 
	 */ 
	public String getAdd(){
		return add;
	}

	/** 
	 * @param email 邮箱 
	 */ 
	public void setEmail(String email){
		this.email = email;
	}

	/** 
	 * @return 邮箱 
	 */ 
	public String getEmail(){
		return email;
	}

	/** 
	 * @param tel 电话 
	 */ 
	public void setTel(String tel){
		this.tel = tel;
	}

	/** 
	 * @return 电话 
	 */ 
	public String getTel(){
		return tel;
	}

	/** 
	 * @param qq QQ号 
	 */ 
	public void setQq(String qq){
		this.qq = qq;
	}

	/** 
	 * @return QQ号 
	 */ 
	public String getQq(){
		return qq;
	}

	/** 
	 * @param fax 传真 
	 */ 
	public void setFax(String fax){
		this.fax = fax;
	}

	/** 
	 * @return 传真 
	 */ 
	public String getFax(){
		return fax;
	}

	/** 
	 * @param sex 性别：默认 0{0 保密 1 男 2 女} 
	 */ 
	public void setSex(Integer sex){
		this.sex = sex;
	}

	/** 
	 * @return 性别：默认 0{0 保密 1 男 2 女} 
	 */ 
	public Integer getSex(){
		return sex;
	}

	/** 
	 * @param birthday 生日 
	 */ 
	public void setBirthday(String birthday){
		this.birthday = birthday;
	}

	/** 
	 * @return 生日 
	 */ 
	public String getBirthday(){
		return birthday;
	}

	/** 
	 * @param explain 说明 
	 */ 
	public void setExplain(String explain){
		this.explain = explain;
	}

	/** 
	 * @return 说明 
	 */ 
	public String getExplain(){
		return explain;
	}

	/** 
	 * @param webSite 外接网址 
	 */ 
	public void setWebSite(String webSite){
		this.webSite = webSite;
	}

	/** 
	 * @return 外接网址 
	 */ 
	public String getWebSite(){
		return webSite;
	}

	/** 
	 * @param webCode 连接外网标识码 
	 */ 
	public void setWebCode(String webCode){
		this.webCode = webCode;
	}

	/** 
	 * @return 连接外网标识码 
	 */ 
	public String getWebCode(){
		return webCode;
	}

}
