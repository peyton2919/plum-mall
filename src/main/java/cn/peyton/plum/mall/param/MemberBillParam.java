package cn.peyton.plum.mall.param;

import cn.peyton.plum.mall.pojo.MemberBill;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * <h3> 会员账单表 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
public class MemberBillParam implements Serializable {
	/** 用户账单id  */
	private Long id;
	/** 会员uid  */
	private Long memberId;
	/** 关联id  */
	private String linkId;
	/** 0 = 支出 1 = 获得  */
	private Integer pm;
	/** 账单标题  */
	private String title;
	/** 明细种类  */
	private String category;
	/** 明细类型  */
	private String type;
	/** 明细数字  */
	private BigDecimal number;
	/** 剩余  */
	private BigDecimal balance;
	/** 备注  */
	private String mark;
	/** 0 = 带确定 1 = 有效 -1 = 无效  */
	private Integer status;
	/** 是否删除: 默认1(1：可用;0已删除)  */
	private Integer isDel;
	/** 添加时间  */
	private Integer createTime;
	/** 更新时间  */
	private Integer updateTime;

	//================================== Constructor =======================================//

	//================================== Method =======================================//


	//================================== PREFIX_GET AND PREFIX_SET =======================================//

	/** 
	 * @param id 用户账单id 
	 */ 
	public void setId(Long id){
		this.id = id;
	}

	/** 
	 * @return 用户账单id 
	 */ 
	public Long getId(){
		return id;
	}

	/** 
	 * @param memberId 会员uid 
	 */ 
	public void setMemberId(Long memberId){
		this.memberId = memberId;
	}

	/** 
	 * @return 会员uid 
	 */ 
	public Long getMemberId(){
		return memberId;
	}

	/** 
	 * @param linkId 关联id 
	 */ 
	public void setLinkId(String linkId){
		this.linkId = linkId;
	}

	/** 
	 * @return 关联id 
	 */ 
	public String getLinkId(){
		return linkId;
	}

	/** 
	 * @param pm 0 = 支出 1 = 获得 
	 */ 
	public void setPm(Integer pm){
		this.pm = pm;
	}

	/** 
	 * @return 0 = 支出 1 = 获得 
	 */ 
	public Integer getPm(){
		return pm;
	}

	/** 
	 * @param title 账单标题 
	 */ 
	public void setTitle(String title){
		this.title = title;
	}

	/** 
	 * @return 账单标题 
	 */ 
	public String getTitle(){
		return title;
	}

	/** 
	 * @param category 明细种类 
	 */ 
	public void setCategory(String category){
		this.category = category;
	}

	/** 
	 * @return 明细种类 
	 */ 
	public String getCategory(){
		return category;
	}

	/** 
	 * @param type 明细类型 
	 */ 
	public void setType(String type){
		this.type = type;
	}

	/** 
	 * @return 明细类型 
	 */ 
	public String getType(){
		return type;
	}

	/** 
	 * @param number 明细数字 
	 */ 
	public void setNumber(BigDecimal number){
		this.number = number;
	}

	/** 
	 * @return 明细数字 
	 */ 
	public BigDecimal getNumber(){
		return number;
	}

	/** 
	 * @param balance 剩余 
	 */ 
	public void setBalance(BigDecimal balance){
		this.balance = balance;
	}

	/** 
	 * @return 剩余 
	 */ 
	public BigDecimal getBalance(){
		return balance;
	}

	/** 
	 * @param mark 备注 
	 */ 
	public void setMark(String mark){
		this.mark = mark;
	}

	/** 
	 * @return 备注 
	 */ 
	public String getMark(){
		return mark;
	}

	/** 
	 * @param status 0 = 带确定 1 = 有效 -1 = 无效 
	 */ 
	public void setStatus(Integer status){
		this.status = status;
	}

	/** 
	 * @return 0 = 带确定 1 = 有效 -1 = 无效 
	 */ 
	public Integer getStatus(){
		return status;
	}

	/** 
	 * @param isDel 是否删除: 默认1(1：可用;0已删除) 
	 */ 
	public void setIsDel(Integer isDel){
		this.isDel = isDel;
	}

	/** 
	 * @return 是否删除: 默认1(1：可用;0已删除) 
	 */ 
	public Integer getIsDel(){
		return isDel;
	}

	/** 
	 * @param createTime 添加时间 
	 */ 
	public void setCreateTime(Integer createTime){
		this.createTime = createTime;
	}

	/** 
	 * @return 添加时间 
	 */ 
	public Integer getCreateTime(){
		return createTime;
	}

	/** 
	 * @param updateTime 更新时间 
	 */ 
	public void setUpdateTime(Integer updateTime){
		this.updateTime = updateTime;
	}

	/** 
	 * @return 更新时间 
	 */ 
	public Integer getUpdateTime(){
		return updateTime;
	}

	/**
	 * <h4>对象转成MemberBill对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,memberId,linkId,pm,title,category,type,number,balance,mark,status,isDel,createTime,updateTime]
	 * </pre>
	 */
	public MemberBill convert(){
		MemberBill memberBill = new MemberBill(); 
		memberBill.setId(id);
		memberBill.setMemberId(memberId);
		memberBill.setLinkId(linkId);
		memberBill.setPm(pm);
		memberBill.setTitle(title);
		memberBill.setCategory(category);
		memberBill.setType(type);
		memberBill.setNumber(number);
		memberBill.setBalance(balance);
		memberBill.setMark(mark);
		memberBill.setStatus(status);
		memberBill.setIsDel(isDel);
		memberBill.setCreateTime(createTime);
		memberBill.setUpdateTime(updateTime);
		return memberBill;
	} 
	/**
	 * <h4>MemberBill对象转成MemberBillParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,memberId,linkId,pm,title,category,type,number,balance,mark,status,isDel,createTime,updateTime]
	 * </pre>
	 */
	public MemberBillParam compat(MemberBill memberBill){ 
		if(null == memberBill){
			return new MemberBillParam();
		}
		this.setId(memberBill.getId());
		this.setMemberId(memberBill.getMemberId());
		this.setLinkId(memberBill.getLinkId());
		this.setPm(memberBill.getPm());
		this.setTitle(memberBill.getTitle());
		this.setCategory(memberBill.getCategory());
		this.setType(memberBill.getType());
		this.setNumber(memberBill.getNumber());
		this.setBalance(memberBill.getBalance());
		this.setMark(memberBill.getMark());
		this.setStatus(memberBill.getStatus());
		this.setIsDel(memberBill.getIsDel());
		this.setCreateTime(memberBill.getCreateTime());
		this.setUpdateTime(memberBill.getUpdateTime());
		return this;
	} 
}
