package cn.peyton.plum.mall.pojo.join;

import cn.peyton.plum.mall.pojo.party.Member;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <h3> 欠款信息 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年02月06日 22:33:31
 * @version 1.0.0
 * </pre>
*/
public class ShopArrears implements Serializable {
	/**   */
	private Long id;
	/** 订单Id  */
	private Long oid;
	/** 还款Id  */
	private Long repId;
	/** 欠款金额  */
	private BigDecimal money;
	/** 付款状态 默认 0 未清 1 已清  */
	private Integer status;
	/** 客户Id  */
	private Long memberId;
	/** 备注  */
	private String remark;
	/** 欠款时间  */
	private Integer createTime;
	/** 会员对象 */
	private Member member;

	/** 还款集合 */
	private List<ShopRepayment> shopRepayments;


	//================================== Constructor =======================================//
	public ShopArrears(){
		if (null == member) {member = new Member();}
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
	 * @return 还款集合
	 */
	public List<ShopRepayment> getShopRepayments() {
		return shopRepayments;
	}

	/**
	 * @param shopRepayments 还款集合
	 */
	public void setShopRepayments(List<ShopRepayment> shopRepayments) {
		this.shopRepayments = shopRepayments;
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
