package cn.peyton.plum.mall.pojo;

import java.math.BigDecimal;

import java.io.Serializable;
/**
 * <h3> 用户提现 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
public class MemberExtract implements Serializable {
	/**   */
	private Long id;
	/** 会员ID  */
	private Long memberId;
	/** 名称  */
	private String realName;
	/** 提现类型: 默认： bank {bank=银行卡 alipay=支付宝 wx=微信}  */
	private String extractType;
	/** 银行卡  */
	private String bankCode;
	/** 开户地址  */
	private String bankAddress;
	/** 支付宝账号  */
	private String alipayCode;
	/** 提现金额  */
	private BigDecimal extractPrice;
	/** 备注  */
	private String mark;
	/** 账目  */
	private BigDecimal balance;
	/** 无效原因  */
	private String failMsg;
	/** 无效发生的时间  */
	private Integer failTime;
	/** -1 未通过 0 审核中 1 已提现  */
	private Integer status;
	/** 微信号  */
	private String wechat;
	/** 是否删除: 默认1(1：可用;0已删除)  */
	private Integer isDel;
	/** 添加时间  */
	private Integer createTime;
	/**   */
	private Integer updateTime;

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
	 * @param memberId 会员ID 
	 */ 
	public void setMemberId(Long memberId){
		this.memberId = memberId;
	}

	/** 
	 * @return 会员ID 
	 */ 
	public Long getMemberId(){
		return memberId;
	}

	/** 
	 * @param realName 名称 
	 */ 
	public void setRealName(String realName){
		this.realName = realName;
	}

	/** 
	 * @return 名称 
	 */ 
	public String getRealName(){
		return realName;
	}

	/** 
	 * @param extractType 提现类型: 默认： bank {bank=银行卡 alipay=支付宝 wx=微信} 
	 */ 
	public void setExtractType(String extractType){
		this.extractType = extractType;
	}

	/** 
	 * @return 提现类型: 默认： bank {bank=银行卡 alipay=支付宝 wx=微信} 
	 */ 
	public String getExtractType(){
		return extractType;
	}

	/** 
	 * @param bankCode 银行卡 
	 */ 
	public void setBankCode(String bankCode){
		this.bankCode = bankCode;
	}

	/** 
	 * @return 银行卡 
	 */ 
	public String getBankCode(){
		return bankCode;
	}

	/** 
	 * @param bankAddress 开户地址 
	 */ 
	public void setBankAddress(String bankAddress){
		this.bankAddress = bankAddress;
	}

	/** 
	 * @return 开户地址 
	 */ 
	public String getBankAddress(){
		return bankAddress;
	}

	/** 
	 * @param alipayCode 支付宝账号 
	 */ 
	public void setAlipayCode(String alipayCode){
		this.alipayCode = alipayCode;
	}

	/** 
	 * @return 支付宝账号 
	 */ 
	public String getAlipayCode(){
		return alipayCode;
	}

	/** 
	 * @param extractPrice 提现金额 
	 */ 
	public void setExtractPrice(BigDecimal extractPrice){
		this.extractPrice = extractPrice;
	}

	/** 
	 * @return 提现金额 
	 */ 
	public BigDecimal getExtractPrice(){
		return extractPrice;
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
	 * @param balance 账目 
	 */ 
	public void setBalance(BigDecimal balance){
		this.balance = balance;
	}

	/** 
	 * @return 账目 
	 */ 
	public BigDecimal getBalance(){
		return balance;
	}

	/** 
	 * @param failMsg 无效原因 
	 */ 
	public void setFailMsg(String failMsg){
		this.failMsg = failMsg;
	}

	/** 
	 * @return 无效原因 
	 */ 
	public String getFailMsg(){
		return failMsg;
	}

	/** 
	 * @param failTime 无效发生的时间 
	 */ 
	public void setFailTime(Integer failTime){
		this.failTime = failTime;
	}

	/** 
	 * @return 无效发生的时间 
	 */ 
	public Integer getFailTime(){
		return failTime;
	}

	/** 
	 * @param status -1 未通过 0 审核中 1 已提现 
	 */ 
	public void setStatus(Integer status){
		this.status = status;
	}

	/** 
	 * @return -1 未通过 0 审核中 1 已提现 
	 */ 
	public Integer getStatus(){
		return status;
	}

	/** 
	 * @param wechat 微信号 
	 */ 
	public void setWechat(String wechat){
		this.wechat = wechat;
	}

	/** 
	 * @return 微信号 
	 */ 
	public String getWechat(){
		return wechat;
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
	 * @param updateTime  
	 */ 
	public void setUpdateTime(Integer updateTime){
		this.updateTime = updateTime;
	}

	/** 
	 * @return  
	 */ 
	public Integer getUpdateTime(){
		return updateTime;
	}

}
