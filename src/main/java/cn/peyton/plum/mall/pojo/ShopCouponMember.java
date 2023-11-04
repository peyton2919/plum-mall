package cn.peyton.plum.mall.pojo;


import java.io.Serializable;
/**
 * <h3> 优惠券会员(关联优惠券与会员) 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
public class ShopCouponMember implements Serializable {
	/**   */
	private Long id;
	/** 优惠券id  */
	private Long couponId;
	/** 会员id  */
	private Long memberId;
	/** 是否已使用 0未使用 1已使用  */
	private Integer used;
	/** 是否可用,1：可用;0:不可用;2:删除;  */
	private Integer status;
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
	 * @param couponId 优惠券id 
	 */ 
	public void setCouponId(Long couponId){
		this.couponId = couponId;
	}

	/** 
	 * @return 优惠券id 
	 */ 
	public Long getCouponId(){
		return couponId;
	}

	/** 
	 * @param memberId 会员id 
	 */ 
	public void setMemberId(Long memberId){
		this.memberId = memberId;
	}

	/** 
	 * @return 会员id 
	 */ 
	public Long getMemberId(){
		return memberId;
	}

	/** 
	 * @param used 是否已使用 0未使用 1已使用 
	 */ 
	public void setUsed(Integer used){
		this.used = used;
	}

	/** 
	 * @return 是否已使用 0未使用 1已使用 
	 */ 
	public Integer getUsed(){
		return used;
	}

	/** 
	 * @param status 是否可用,1：可用;0:不可用;2:删除; 
	 */ 
	public void setStatus(Integer status){
		this.status = status;
	}

	/** 
	 * @return 是否可用,1：可用;0:不可用;2:删除; 
	 */ 
	public Integer getStatus(){
		return status;
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
