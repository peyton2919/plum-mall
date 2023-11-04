package cn.peyton.plum.mall.pojo;

import java.math.BigDecimal;

import java.io.Serializable;
/**
 * <h3> 优惠券 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
public class ShopCoupon implements Serializable {
	/**   */
	private Long id;
	/** 优惠券名称  */
	private String name;
	/** 类型：固定金额/百分比折扣 0固定金额 1百分比  */
	private Integer type;
	/** 折扣值，根据不同类型含义不同  */
	private BigDecimal value;
	/** 总数  */
	private Integer total;
	/** 已使用数量  */
	private Integer used;
	/** 最低价格  */
	private BigDecimal minPrice;
	/** 优惠券是否生效:默认 1 {0不生效 1生效 2删除}  */
	private Integer status;
	/** 排序: 数值越大越靠前  */
	private Integer seq;
	/** 备注  */
	private String remark;
	/** 开始时间  */
	private Integer startTime;
	/** 结束时间  */
	private Integer endTime;
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
	 * @param name 优惠券名称 
	 */ 
	public void setName(String name){
		this.name = name;
	}

	/** 
	 * @return 优惠券名称 
	 */ 
	public String getName(){
		return name;
	}

	/** 
	 * @param type 类型：固定金额/百分比折扣 0固定金额 1百分比 
	 */ 
	public void setType(Integer type){
		this.type = type;
	}

	/** 
	 * @return 类型：固定金额/百分比折扣 0固定金额 1百分比 
	 */ 
	public Integer getType(){
		return type;
	}

	/** 
	 * @param value 折扣值，根据不同类型含义不同 
	 */ 
	public void setValue(BigDecimal value){
		this.value = value;
	}

	/** 
	 * @return 折扣值，根据不同类型含义不同 
	 */ 
	public BigDecimal getValue(){
		return value;
	}

	/** 
	 * @param total 总数 
	 */ 
	public void setTotal(Integer total){
		this.total = total;
	}

	/** 
	 * @return 总数 
	 */ 
	public Integer getTotal(){
		return total;
	}

	/** 
	 * @param used 已使用数量 
	 */ 
	public void setUsed(Integer used){
		this.used = used;
	}

	/** 
	 * @return 已使用数量 
	 */ 
	public Integer getUsed(){
		return used;
	}

	/** 
	 * @param minPrice 最低价格 
	 */ 
	public void setMinPrice(BigDecimal minPrice){
		this.minPrice = minPrice;
	}

	/** 
	 * @return 最低价格 
	 */ 
	public BigDecimal getMinPrice(){
		return minPrice;
	}

	/** 
	 * @param status 优惠券是否生效:默认 1 {0不生效 1生效 2删除} 
	 */ 
	public void setStatus(Integer status){
		this.status = status;
	}

	/** 
	 * @return 优惠券是否生效:默认 1 {0不生效 1生效 2删除} 
	 */ 
	public Integer getStatus(){
		return status;
	}

	/** 
	 * @param seq 排序: 数值越大越靠前 
	 */ 
	public void setSeq(Integer seq){
		this.seq = seq;
	}

	/** 
	 * @return 排序: 数值越大越靠前 
	 */ 
	public Integer getSeq(){
		return seq;
	}

	/** 
	 * @param remark 备注 
	 */ 
	public void setRemark(String remark){
		this.remark = remark;
	}

	/** 
	 * @return 备注 
	 */ 
	public String getRemark(){
		return remark;
	}

	/** 
	 * @param startTime 开始时间 
	 */ 
	public void setStartTime(Integer startTime){
		this.startTime = startTime;
	}

	/** 
	 * @return 开始时间 
	 */ 
	public Integer getStartTime(){
		return startTime;
	}

	/** 
	 * @param endTime 结束时间 
	 */ 
	public void setEndTime(Integer endTime){
		this.endTime = endTime;
	}

	/** 
	 * @return 结束时间 
	 */ 
	public Integer getEndTime(){
		return endTime;
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
