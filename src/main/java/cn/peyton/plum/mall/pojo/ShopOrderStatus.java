package cn.peyton.plum.mall.pojo;


import java.io.Serializable;
/**
 * <h3> 订单操作记录 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
public class ShopOrderStatus implements Serializable {
	/**   */
	private Long id;
	/** 订单id  */
	private Long oid;
	/** 操作类型  */
	private String changeType;
	/** 操作备注  */
	private String changeMessage;
	/** 操作时间  */
	private Integer changeTime;

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
	 * @param oid 订单id 
	 */ 
	public void setOid(Long oid){
		this.oid = oid;
	}

	/** 
	 * @return 订单id 
	 */ 
	public Long getOid(){
		return oid;
	}

	/** 
	 * @param changeType 操作类型 
	 */ 
	public void setChangeType(String changeType){
		this.changeType = changeType;
	}

	/** 
	 * @return 操作类型 
	 */ 
	public String getChangeType(){
		return changeType;
	}

	/** 
	 * @param changeMessage 操作备注 
	 */ 
	public void setChangeMessage(String changeMessage){
		this.changeMessage = changeMessage;
	}

	/** 
	 * @return 操作备注 
	 */ 
	public String getChangeMessage(){
		return changeMessage;
	}

	/** 
	 * @param changeTime 操作时间 
	 */ 
	public void setChangeTime(Integer changeTime){
		this.changeTime = changeTime;
	}

	/** 
	 * @return 操作时间 
	 */ 
	public Integer getChangeTime(){
		return changeTime;
	}

}
