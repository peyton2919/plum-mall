package cn.peyton.plum.mall.param.join;

import cn.peyton.plum.core.utils.DateUtils;
import cn.peyton.plum.mall.bo.MemberBo;
import cn.peyton.plum.mall.param.party.MemberParam;
import cn.peyton.plum.mall.pojo.join.ShopArrearPool;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * <h3> 欠款汇总 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年01月30日 11:33:43
 * @version 1.0.0
 * </pre>
*/
public class ShopArrearPoolParam implements Serializable {
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
	private String createTime;
	/** 会员对象 */
	private MemberParam member;

	//================================== Constructor =======================================//
	public ShopArrearPoolParam() {
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
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}

	/** 
	 * @return 创建时间 
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
	 * <h4>对象转成ShopArrearPool对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,memberId,total,balance,status,explain,createTime]
	 * </pre>
	 */
	public ShopArrearPool convert(){
		ShopArrearPool shopArrearPool = new ShopArrearPool(); 
		shopArrearPool.setId(id);
		shopArrearPool.setMemberId(memberId);
		shopArrearPool.setTotal(total);
		shopArrearPool.setBalance(balance);
		shopArrearPool.setStatus(status);
		shopArrearPool.setExplain(explain);
		shopArrearPool.setCreateTime(DateUtils.dateToTimestamp(createTime));
		shopArrearPool.setMember(member.convert());
		return shopArrearPool;
	} 
	/**
	 * <h4>ShopArrearPool对象转成ShopArrearPoolParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,memberId,total,balance,status,explain,createTime]
	 * </pre>
	 */
	public ShopArrearPoolParam compat(ShopArrearPool shopArrearPool){ 
		if(null == shopArrearPool){
			return new ShopArrearPoolParam();
		}
		this.setId(shopArrearPool.getId());
		this.setMemberId(shopArrearPool.getMemberId());
		this.setTotal(shopArrearPool.getTotal());
		this.setBalance(shopArrearPool.getBalance());
		this.setStatus(shopArrearPool.getStatus());
		this.setExplain(shopArrearPool.getExplain());
		this.setCreateTime(DateUtils.timestampToStrDate(shopArrearPool.getCreateTime()));
		this.setMember(new MemberBo().compat(shopArrearPool.getMember()));
		return this;
	} 
}
