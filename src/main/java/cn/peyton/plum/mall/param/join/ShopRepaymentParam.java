package cn.peyton.plum.mall.param.join;

import cn.peyton.plum.core.utils.DateUtils;
import cn.peyton.plum.core.validator.constraints.*;
import cn.peyton.plum.mall.bo.MemberBo;
import cn.peyton.plum.mall.param.party.MemberParam;
import cn.peyton.plum.mall.pojo.join.ShopRepayment;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * <h3> 还款信息 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年02月06日 22:33:46
 * @version 1.0.0
 * </pre>
*/
public class ShopRepaymentParam implements Serializable {
	/**   */
	private Long id;
	/** 欠款Id  */
	@NotBlank(message = "欠款Id不能为空!")
	@Min(value = 1,message = "最小值为1")
	private Long arrearId;
	/** 还款金额  */
	@NotBlank(message = "还款金额不能为空")
	@MinDecimal(value = 0.01,message = "最小还款金额不能为0")
	private BigDecimal money;
	/** 实际付款金额  */
	private BigDecimal actualPayment;
	/** 付款状态 默认 0 未清 1 已清  */
	@Size(min = 0,max = 1)
	private Integer status;
	/** 还款方式: 0 微信 1 支付宝 2 转账 3 现金 4 其他  */
	@Size(min = 0, max = 4)
	private Integer repayType;
	/** 客户Id  */
	@NotBlank(message = "会员Id不能为空")
	@Min(value = 1,message = "最小值为1")
	private Long memberId;
	/** 关联欠款与还款对象集合(JSON格式)  */
	private String obj;
	/** 备注  */
	@Length(min = 0,max = 255)
	private String remark;
	/** 欠款时间  */
	@Datetime
	@Past
	private String createTime;
	/** 会员对象 */
	private MemberParam member;

	//================================== Constructor =======================================//
	public ShopRepaymentParam(){
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
	 * <h4>对象转成ShopRepayment对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,arrearId,momey,actualPayment,status,repayType,memberId,obj,remark,createTime]
	 * </pre>
	 */
	public ShopRepayment convert(){
		ShopRepayment shopRepayment = new ShopRepayment(); 
		shopRepayment.setId(id);
		shopRepayment.setArrearId(arrearId);
		shopRepayment.setMoney(money);
		shopRepayment.setActualPayment(actualPayment);
		shopRepayment.setStatus(status);
		shopRepayment.setRepayType(repayType);
		shopRepayment.setMemberId(memberId);
		shopRepayment.setObj(obj);
		shopRepayment.setRemark(remark);
		shopRepayment.setMember(member.convert());
		shopRepayment.setCreateTime(DateUtils.dateToTimestamp(createTime));
		return shopRepayment;
	} 
	/**
	 * <h4>ShopRepayment对象转成ShopRepaymentParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,arrearId,momey,actualPayment,status,repayType,memberId,obj,remark,createTime]
	 * </pre>
	 */
	public ShopRepaymentParam compat(ShopRepayment shopRepayment){ 
		if(null == shopRepayment){
			return new ShopRepaymentParam();
		}
		this.setId(shopRepayment.getId());
		this.setArrearId(shopRepayment.getArrearId());
		this.setMoney(shopRepayment.getMoney());
		this.setActualPayment(shopRepayment.getActualPayment());
		this.setStatus(shopRepayment.getStatus());
		this.setRepayType(shopRepayment.getRepayType());
		this.setMemberId(shopRepayment.getMemberId());
		this.setObj(shopRepayment.getObj());
		this.setRemark(shopRepayment.getRemark());
		this.setMember(new MemberBo().compat(shopRepayment.getMember()));
		this.setCreateTime(DateUtils.timestampToStrDate(shopRepayment.getCreateTime()));
		return this;
	} 
}
