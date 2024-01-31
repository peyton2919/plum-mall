package cn.peyton.plum.mall.pojo.join;

import cn.peyton.plum.mall.pojo.party.Member;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * <h3> 欠款信息 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年01月16日 21:12:27
 * @version 1.0.0
 * </pre>
*/
public class ShopArrears implements Serializable {
	/**   */
	private Long id;
	/** 订单Id  */
	private Long oid;
	/** 欠款金额  */
	private BigDecimal debt;
	/** 还款金额  */
	private BigDecimal repayDebt;
	/** 实际付款金额  */
	private BigDecimal actualPayment;
	/** 付款状态 默认 0 未清 1 已清  */
	private Integer status;
	/** 欠还多种对充;默认 0 不启用 1 欠1还N 2 欠N还N 3 欠N还1  */
	private Integer isMulti;
	/** 还款方式: 0 微信 1 支付宝 2 转账 3 现金 4 其他  */
	private Integer repayType;
	/** 客户Id  */
	private Long memberId;
	/** 关联欠款与还款对象集合(JSON格式)  */
	private String correlation;
	/** 备注  */
	private String remark;
	/** 备用  */
	private String reserve;
	/** 欠款时间  */
	private Integer createTime;
	/** 还款时间  */
	private Integer updateTime;
	/** 会员对象*/
	private Member member;

	//================================== Constructor =======================================//
	public ShopArrears(){
		if (null == member) {member = new Member();}
	}
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
	 * @return 订单Id
	 */
	public Long getOid() {
		return oid;
	}

	/**
	 * @param oid 订单Id
	 */
	public void setOid(Long oid) {
		this.oid = oid;
	}

	/** 
	 * @param debt 欠款金额 
	 */ 
	public void setDebt(BigDecimal debt){
		this.debt = debt;
	}

	/** 
	 * @return 欠款金额 
	 */ 
	public BigDecimal getDebt(){
		return debt;
	}

	/** 
	 * @param repayDebt 还款金额 
	 */ 
	public void setRepayDebt(BigDecimal repayDebt){
		this.repayDebt = repayDebt;
	}

	/** 
	 * @return 还款金额 
	 */ 
	public BigDecimal getRepayDebt(){
		return repayDebt;
	}

	/** 
	 * @param actualPayment 实际付款金额 
	 */ 
	public void setActualPayment(BigDecimal actualPayment){
		this.actualPayment = actualPayment;
	}

	/** 
	 * @return 实际付款金额 
	 */ 
	public BigDecimal getActualPayment(){
		return actualPayment;
	}

	/** 
	 * @param status 付款状态 默认 0 未清 1 已清 
	 */ 
	public void setStatus(Integer status){
		this.status = status;
	}

	/** 
	 * @return 付款状态 默认 0 未清 1 已清 
	 */ 
	public Integer getStatus(){
		return status;
	}

	/** 
	 * @param isMulti 欠还多种对充;默认 0 不启用 1 欠1还N 2 欠N还N 3 欠N还1 
	 */ 
	public void setIsMulti(Integer isMulti){
		this.isMulti = isMulti;
	}

	/** 
	 * @return 欠还多种对充;默认 0 不启用 1 欠1还N 2 欠N还N 3 欠N还1 
	 */ 
	public Integer getIsMulti(){
		return isMulti;
	}

	/** 
	 * @param repayType 还款方式: 0 微信 1 支付宝 2 转账 3 现金 4 其他 
	 */ 
	public void setRepayType(Integer repayType){
		this.repayType = repayType;
	}

	/** 
	 * @return 还款方式: 0 微信 1 支付宝 2 转账 3 现金 4 其他 
	 */ 
	public Integer getRepayType(){
		return repayType;
	}

	/** 
	 * @param memberId 客户Id 
	 */ 
	public void setMemberId(Long memberId){
		this.memberId = memberId;
	}

	/** 
	 * @return 客户Id 
	 */ 
	public Long getMemberId(){
		return memberId;
	}

	/** 
	 * @param correlation 关联欠款与还款对象集合(JSON格式) 
	 */ 
	public void setCorrelation(String correlation){
		this.correlation = correlation;
	}

	/** 
	 * @return 关联欠款与还款对象集合(JSON格式) 
	 */ 
	public String getCorrelation(){
		return correlation;
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
	 * @param reserve 备用 
	 */ 
	public void setReserve(String reserve){
		this.reserve = reserve;
	}

	/** 
	 * @return 备用 
	 */ 
	public String getReserve(){
		return reserve;
	}

	/** 
	 * @param createTime 欠款时间 
	 */ 
	public void setCreateTime(Integer createTime){
		this.createTime = createTime;
	}

	/** 
	 * @return 欠款时间 
	 */ 
	public Integer getCreateTime(){
		return createTime;
	}

	/** 
	 * @param updateTime 还款时间 
	 */ 
	public void setUpdateTime(Integer updateTime){
		this.updateTime = updateTime;
	}

	/** 
	 * @return 还款时间 
	 */ 
	public Integer getUpdateTime(){
		return updateTime;
	}

	/**
	 * @return 会员对象
	 */
	public Member getMember() {
		return member;
	}

	/**
	 * @param member 会员对象
	 */
	public void setMember(Member member) {
		this.member = member;
	}

}
