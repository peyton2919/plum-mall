package cn.peyton.plum.mall.param.join;

import cn.peyton.plum.core.utils.DateUtils;
import cn.peyton.plum.core.validator.constraints.*;
import cn.peyton.plum.mall.bo.MemberBo;
import cn.peyton.plum.mall.bo.ShopRepaymentBo;
import cn.peyton.plum.mall.param.party.MemberParam;
import cn.peyton.plum.mall.pojo.join.ShopArrears;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <h3> 欠款信息 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年02月06日 22:33:31
 * @version 1.0.0
 * </pre>
*/
public class ShopArrearsParam implements Serializable {
	/**   */
	private Long id;
	/** 订单Id  */
	private Long oid;
	/** 还款Id  */
	private Long repId;
	/** 欠款金额  */
	@NotBlank(message = "欠款金额不能为空")
	@MinDecimal(value = 0.01,message = "最小欠款金额不能为0")
	private BigDecimal money;
	/** 付款状态 默认 0 未清 1 已清  */
	@Size(min = 0,max = 1)
	private Integer status;
	/** 客户Id  */
	@NotBlank(message = "会员Id不能为空")
	@Min(value = 1,message = "最小值为1")
	private Long memberId;
	/** 备注  */
	@Length(min = 0,max = 255)
	private String remark;
	/** 欠款时间  */
	@Datetime
	@Past
	private String createTime;
	/** 会员对象 */
	private MemberParam member;
	/** 还款集合 */
	private List<ShopRepaymentParam> shopRepayments;


	//================================== Constructor =======================================//
	public ShopArrearsParam(){
		if (null == member) {member = new MemberParam();}
		if (null == shopRepayments) { shopRepayments = new ArrayList<>();}
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
	 * @param oid 订单Id 
	 */ 
	public void setOid(Long oid){
		this.oid = oid;
	}

	/** 
	 * @return 订单Id 
	 */ 
	public Long getOid(){
		return oid;
	}

	/** 
	 * @param repId 还款Id 
	 */ 
	public void setRepId(Long repId){
		this.repId = repId;
	}

	/** 
	 * @return 还款Id 
	 */ 
	public Long getRepId(){
		return repId;
	}

	/** 
	 * @param money 欠款金额 
	 */ 
	public void setMoney(BigDecimal money){
		this.money = money;
	}

	/** 
	 * @return 欠款金额 
	 */ 
	public BigDecimal getMoney(){
		return money;
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
	 * @return 还款集合
	 */
	public List<ShopRepaymentParam> getShopRepayments() {
		return shopRepayments;
	}

	/**
	 * @param shopRepayments 还款集合
	 */
	public void setShopRepayments(List<ShopRepaymentParam> shopRepayments) {
		this.shopRepayments = shopRepayments;
	}

	/**
	 * <h4>对象转成ShopArrears对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,oid,repId,money,status,memberId,remark,createTime]
	 * </pre>
	 */
	public ShopArrears convert(){ 
		ShopArrears shopArrears = new ShopArrears();
		shopArrears.setId(id);
		shopArrears.setOid(oid);
		shopArrears.setRepId(repId);
		shopArrears.setMoney(money);
		shopArrears.setStatus(status);
		shopArrears.setMemberId(memberId);
		shopArrears.setRemark(remark);
		shopArrears.setCreateTime(DateUtils.dateToTimestamp(createTime));
		shopArrears.setMember(member.convert());
		shopArrears.setShopRepayments(new ShopRepaymentBo().reverse(shopRepayments));
		return shopArrears;
	} 
	/**
	 * <h4>ShopArrears对象转成ShopArrearsParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,oid,repId,money,status,memberId,remark,createTime]
	 * </pre>
	 */
	public ShopArrearsParam compat(ShopArrears shopArrears){ 
		if(null == shopArrears){
			return new ShopArrearsParam();
		}
		this.setId(shopArrears.getId());
		this.setOid(shopArrears.getOid());
		this.setRepId(shopArrears.getRepId());
		this.setMoney(shopArrears.getMoney());
		this.setStatus(shopArrears.getStatus());
		this.setMemberId(shopArrears.getMemberId());
		this.setRemark(shopArrears.getRemark());
		this.setCreateTime(DateUtils.timestampToStrDate(shopArrears.getCreateTime()));
		this.setMember(new MemberBo().compat(shopArrears.getMember()));
		this.setShopRepayments(new ShopRepaymentBo().adapter(shopArrears.getShopRepayments()));
		return this;
	} 
}
