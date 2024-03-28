package cn.peyton.plum.mall.pojo.join;

import cn.peyton.plum.mall.pojo.party.Member;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * <h3> 还款信息 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年02月06日 22:33:46
 * @version 1.0.0
 * </pre>
*/
public class ShopRepayment implements Serializable {
	/**   */
	private Long id;
	/** 欠款Id  */
	private Long arrearId;
	/** 还款金额  */
	private BigDecimal money;
	/** 实际付款金额  */
	private BigDecimal actualPayment;
	/** 付款状态 默认 0 未清 1 已清  */
	private Integer status;
	/** 还款方式: 0 微信 1 支付宝 2 转账 3 现金 4 其他  */
	private Integer repayType;
	/** 客户Id  */
	private Long memberId;
	/** 关联欠款与还款对象集合(JSON格式)  */
	private String obj;
	/** 备注  */
	private String remark;
	/** 欠款时间  */
	private Integer createTime;
	/** 会员对象 */
	private Member member;

	//================================== Constructor =======================================//
	public ShopRepayment(){
		if (null == member) {
			member = new Member();
		}
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
	 * @param arrearId 欠款Id 
	 */ 
	public void setArrearId(Long arrearId){
		this.arrearId = arrearId;
	}

	/** 
	 * @return 欠款Id 
	 */ 
	public Long getArrearId(){
		return arrearId;
	}

	/** 
	 * @param money 还款金额
	 */ 
	public void setMoney(BigDecimal money){
		this.money = money;
	}

	/** 
	 * @return 还款金额 
	 */ 
	public BigDecimal getMoney(){
		return money;
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
	 * @param obj 关联欠款与还款对象集合(JSON格式) 
	 */ 
	public void setObj(String obj){
		this.obj = obj;
	}

	/** 
	 * @return 关联欠款与还款对象集合(JSON格式) 
	 */ 
	public String getObj(){
		return obj;
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
