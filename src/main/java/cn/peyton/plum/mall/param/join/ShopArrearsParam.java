package cn.peyton.plum.mall.param.join;

import cn.peyton.plum.core.utils.DateUtils;
import cn.peyton.plum.core.validator.constraints.*;
import cn.peyton.plum.mall.bo.MemberBo;
import cn.peyton.plum.mall.param.party.MemberParam;
import cn.peyton.plum.mall.pojo.join.ShopArrears;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * <h3> 欠款信息 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年01月16日 21:12:27
 * @version 1.0.0
 * </pre>
*/
public class ShopArrearsParam implements Serializable {
	/**   */
	private Long id;
	/** 订单Id  */
	private Long oid;
	/** 欠款金额  */
	@NotBlank(message = "欠款金额不能为空")
	@MinDecimal(value = 0.01,message = "最小欠款金额不能为0")
	private BigDecimal debt;
	/** 还款金额  */
	@NotBlank(message = "还款金额不能为空")
	@MinDecimal(value = 0.01,message = "最小还款金额不能为0")
	private BigDecimal repayDebt;
	/** 实际付款金额  */
	private BigDecimal actualPayment;
	/** 付款状态 默认 0 未清 1 已清  */
	@Size(min = 0,max = 1)
	private Integer status;
	/**
	 * 欠还多种对充;默认 0 不启用 1 欠1还N 2 欠N还N 3 欠N还1
	 */
	@Size(min = 0, max = 3)
	private Integer isMulti;
	/** 还款方式: 0 微信 1 支付宝 2 转账 3 现金 4 其他  */
	@Size(min = 0, max = 4)
	private Integer repayType;
	/** 客户Id  */
	@NotBlank(message = "会员Id不能为空")
	@Min(value = 1,message = "最小值为1")
	private Long memberId;
	/** 关联欠款与还款对象集合(JSON格式)  */
	private String correlation;
	/** 备注  */
	@Length(min = 0,max = 255)
	private String remark;
	/** 备用  */
	@Length(min = 0,max = 100)
	private String reserve;
	/** 欠款时间  */
	@Datetime
	@Past
	private String createTime;
	/** 还款时间  */
	@Datetime
	@Past
	private String updateTime;
	/** 会员对象*/
	private MemberParam member;
	//================================== Constructor =======================================//
	public ShopArrearsParam(){
		if (null == member) {member = new MemberParam();}
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
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}

	/** 
	 * @return 欠款时间 
	 */ 
	public String getCreateTime(){
		return createTime;
	}

	/** 
	 * @param updateTime 还款时间 
	 */ 
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}

	/** 
	 * @return 还款时间 
	 */ 
	public String getUpdateTime(){
		return updateTime;
	}
	/**
	 * @return 会员对象
	 */
	public MemberParam getMember() {
		return member;
	}

	/**
	 * @param member 会员对象
	 */
	public void setMember(MemberParam member) {
		this.member = member;
	}

	/**
	 * <h4>对象转成ShopArrears对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,debt,repayDebt,actualPayment,status,isMulti,repayType,memberId,correlation,remark,reserve,createTime,updateTime]
	 * </pre>
	 */
	public ShopArrears convert(){
		ShopArrears shopArrears = new ShopArrears(); 
		shopArrears.setId(id);
		shopArrears.setOid(oid);
		shopArrears.setDebt(debt);
		shopArrears.setRepayDebt(repayDebt);
		shopArrears.setActualPayment(actualPayment);
		shopArrears.setStatus(status);
		shopArrears.setIsMulti(isMulti);
		shopArrears.setRepayType(repayType);
		shopArrears.setMemberId(memberId);
		shopArrears.setCorrelation(correlation);
		shopArrears.setRemark(remark);
		shopArrears.setReserve(reserve);
		shopArrears.setCreateTime(DateUtils.dateToTimestamp(createTime));
		shopArrears.setUpdateTime(DateUtils.dateToTimestamp(updateTime));
		shopArrears.setMember(member.convert());
		return shopArrears;
	} 
	/**
	 * <h4>ShopArrears对象转成ShopArrearsParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,debt,repayDebt,actualPayment,status,isMulti,repayType,memberId,correlation,remark,reserve,createTime,updateTime]
	 * </pre>
	 */
	public ShopArrearsParam compat(ShopArrears shopArrears){ 
		if(null == shopArrears){
			return new ShopArrearsParam();
		}
		this.setId(shopArrears.getId());
		this.setOid(shopArrears.getOid());
		this.setDebt(shopArrears.getDebt());
		this.setRepayDebt(shopArrears.getRepayDebt());
		this.setActualPayment(shopArrears.getActualPayment());
		this.setStatus(shopArrears.getStatus());
		this.setIsMulti(shopArrears.getIsMulti());
		this.setRepayType(shopArrears.getRepayType());
		this.setMemberId(shopArrears.getMemberId());
		this.setCorrelation(shopArrears.getCorrelation());
		this.setRemark(shopArrears.getRemark());
		this.setReserve(shopArrears.getReserve());
		this.setCreateTime(DateUtils.timestampToStrDate(shopArrears.getCreateTime()));
		this.setUpdateTime(DateUtils.timestampToStrDate(shopArrears.getUpdateTime()));
		this.setMember(new MemberBo().compat(shopArrears.getMember()));
		return this;
	} 
}
