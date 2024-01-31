package cn.peyton.plum.mall.pojo.join;

import cn.peyton.plum.mall.pojo.party.Member;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * <h3> 欠款汇总 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年01月30日 11:33:43
 * @version 1.0.0
 * </pre>
*/
public class ShopArrearPool implements Serializable {
	/**   */
	private Long id;
	/** 会员Id  */
	private Long memberId;
	/** 累计欠款金额  */
	private BigDecimal total;
	/** 欠款余额  */
	private BigDecimal balance;
	/** 付款状态 默认 0 未清 1 已清  */
	private Integer status;
	/** 备注|说明  */
	private String explain;
	/** 创建时间  */
	private Integer createTime;
	/** 会员对象 */
	private Member member;

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

	//================================== Constructor =======================================//
	public ShopArrearPool() {
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
	 * @param memberId 会员Id 
	 */ 
	public void setMemberId(Long memberId){
		this.memberId = memberId;
	}

	/** 
	 * @return 会员Id 
	 */ 
	public Long getMemberId(){
		return memberId;
	}

	/** 
	 * @param total 累计欠款金额 
	 */ 
	public void setTotal(BigDecimal total){
		this.total = total;
	}

	/** 
	 * @return 累计欠款金额 
	 */ 
	public BigDecimal getTotal(){
		return total;
	}

	/** 
	 * @param balance 欠款余额 
	 */ 
	public void setBalance(BigDecimal balance){
		this.balance = balance;
	}

	/** 
	 * @return 欠款余额 
	 */ 
	public BigDecimal getBalance(){
		return balance;
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
	 * @param explain 备注|说明 
	 */ 
	public void setExplain(String explain){
		this.explain = explain;
	}

	/** 
	 * @return 备注|说明 
	 */ 
	public String getExplain(){
		return explain;
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
