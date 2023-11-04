package cn.peyton.plum.mall.pojo;


import java.io.Serializable;
/**
 * <h3> 用户日志 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
public class UserLog implements Serializable {
	/**   */
	private Long id;
	/** 会员编号  */
	private Long userId;
	/** 旧值  */
	private String oldValue;
	/** 新值  */
	private String newValue;
	/** 最后一次更新者的ip地址  */
	private String operateIp;
	/** 创建时间  */
	private Integer createTime;
	/** 当前是否复原过，默认 0：没有，1：复原过  */
	private Integer status;

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
	 * @param userId 会员编号 
	 */ 
	public void setUserId(Long userId){
		this.userId = userId;
	}

	/** 
	 * @return 会员编号 
	 */ 
	public Long getUserId(){
		return userId;
	}

	/** 
	 * @param oldValue 旧值 
	 */ 
	public void setOldValue(String oldValue){
		this.oldValue = oldValue;
	}

	/** 
	 * @return 旧值 
	 */ 
	public String getOldValue(){
		return oldValue;
	}

	/** 
	 * @param newValue 新值 
	 */ 
	public void setNewValue(String newValue){
		this.newValue = newValue;
	}

	/** 
	 * @return 新值 
	 */ 
	public String getNewValue(){
		return newValue;
	}

	/** 
	 * @param operateIp 最后一次更新者的ip地址 
	 */ 
	public void setOperateIp(String operateIp){
		this.operateIp = operateIp;
	}

	/** 
	 * @return 最后一次更新者的ip地址 
	 */ 
	public String getOperateIp(){
		return operateIp;
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
	 * @param status 当前是否复原过，默认 0：没有，1：复原过 
	 */ 
	public void setStatus(Integer status){
		this.status = status;
	}

	/** 
	 * @return 当前是否复原过，默认 0：没有，1：复原过 
	 */ 
	public Integer getStatus(){
		return status;
	}

}
