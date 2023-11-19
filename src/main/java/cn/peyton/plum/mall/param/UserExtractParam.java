package cn.peyton.plum.mall.param;

import cn.peyton.plum.mall.pojo.UserExtract;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <h3> 用户提现 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:24
 * @version 1.0.0
 * </pre>
 */
public class UserExtractParam implements Serializable {
    /**
     *
     */
    private Long id;
    /**
     * 用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)
     */
    private Long shaerId;
    /**
     * 用户类型 默认: 0 会员、1 顾客 2 供应商、3 用户 4 员工 5 超级管理员
     */
    private Integer shaerType;
    /**
     * 真实姓名名称
     */
    private String realName;
    /**
     * 提现类型: 默认： bank {bank=银行卡 alipay=支付宝 wx=微信}
     */
    private String extractType;
    /**
     * 银行卡
     */
    private String bankCode;
    /**
     * 开户地址
     */
    private String bankAddress;
    /**
     * 支付宝账号
     */
    private String alipayCode;
    /**
     * 提现金额
     */
    private BigDecimal extractPrice;
    /**
     * 说明
     */
    private String explain;
    /**
     * 账目
     */
    private BigDecimal balance;
    /**
     * 无效原因
     */
    private String failMsg;
    /**
     * 无效发生的时间
     */
    private Integer failTime;
    /**
     * -1 未通过 0 审核中 1 已提现
     */
    private Integer status;
    /**
     * 微信号
     */
    private String wechat;
    /**
     * 是否删除: 默认1(1：可用;0已删除)
     */
    private Integer isDel;
    /**
     * 添加时间
     */
    private Integer createTime;
    /**
     *
     */
    private Integer updateTime;

    //================================== Constructor =======================================//

    //================================== Method =======================================//


    //================================== PREFIX_GET AND PREFIX_SET =======================================//

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * @param shaerId 用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)
     */
    public void setShaerId(Long shaerId) {
        this.shaerId = shaerId;
    }

    /**
     * @return 用户ID(包含 : 会员Id 、 供应商Id 、 员工Id等, 配合share_type一起使用)
     */
    public Long getShaerId() {
        return shaerId;
    }

    /**
     * @param shaerType 用户类型 默认: 0 会员、1 顾客 2 供应商、3 用户 4 员工 5 超级管理员
     */
    public void setShaerType(Integer shaerType) {
        this.shaerType = shaerType;
    }

    /**
     * @return 用户类型 默认: 0 会员、1 顾客 2 供应商、3 用户 4 员工 5 超级管理员
     */
    public Integer getShaerType() {
        return shaerType;
    }

    /**
     * @param realName 真实姓名名称
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * @return 真实姓名名称
     */
    public String getRealName() {
        return realName;
    }

    /**
     * @param extractType 提现类型: 默认： bank {bank=银行卡 alipay=支付宝 wx=微信}
     */
    public void setExtractType(String extractType) {
        this.extractType = extractType;
    }

    /**
     * @return 提现类型: 默认： bank {bank=银行卡 alipay=支付宝 wx=微信}
     */
    public String getExtractType() {
        return extractType;
    }

    /**
     * @param bankCode 银行卡
     */
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    /**
     * @return 银行卡
     */
    public String getBankCode() {
        return bankCode;
    }

    /**
     * @param bankAddress 开户地址
     */
    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }

    /**
     * @return 开户地址
     */
    public String getBankAddress() {
        return bankAddress;
    }

    /**
     * @param alipayCode 支付宝账号
     */
    public void setAlipayCode(String alipayCode) {
        this.alipayCode = alipayCode;
    }

    /**
     * @return 支付宝账号
     */
    public String getAlipayCode() {
        return alipayCode;
    }

    /**
     * @param extractPrice 提现金额
     */
    public void setExtractPrice(BigDecimal extractPrice) {
        this.extractPrice = extractPrice;
    }

    /**
     * @return 提现金额
     */
    public BigDecimal getExtractPrice() {
        return extractPrice;
    }

    /**
     * @param explain 说明
     */
    public void setExplain(String explain) {
        this.explain = explain;
    }

    /**
     * @return 说明
     */
    public String getExplain() {
        return explain;
    }

    /**
     * @param balance 账目
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * @return 账目
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * @param failMsg 无效原因
     */
    public void setFailMsg(String failMsg) {
        this.failMsg = failMsg;
    }

    /**
     * @return 无效原因
     */
    public String getFailMsg() {
        return failMsg;
    }

    /**
     * @param failTime 无效发生的时间
     */
    public void setFailTime(Integer failTime) {
        this.failTime = failTime;
    }

    /**
     * @return 无效发生的时间
     */
    public Integer getFailTime() {
        return failTime;
    }

    /**
     * @param status -1 未通过 0 审核中 1 已提现
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return -1 未通过 0 审核中 1 已提现
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param wechat 微信号
     */
    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    /**
     * @return 微信号
     */
    public String getWechat() {
        return wechat;
    }

    /**
     * @param isDel 是否删除: 默认1(1：可用;0已删除)
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    /**
     * @return 是否删除: 默认1(1：可用;0已删除)
     */
    public Integer getIsDel() {
        return isDel;
    }

    /**
     * @param createTime 添加时间
     */
    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    /**
     * @return 添加时间
     */
    public Integer getCreateTime() {
        return createTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return
     */
    public Integer getUpdateTime() {
        return updateTime;
    }

    /**
     * <h4>对象转成MemberExtract对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,shaerId,shaerType,realName,extractType,bankCode,bankAddress,alipayCode,extractPrice,explain,balance,failMsg,failTime,status,wechat,isDel,createTime,updateTime]
     * </pre>
     */
    public UserExtract convert() {
        UserExtract userExtract = new UserExtract();
        userExtract.setId(id);
        userExtract.setShaerId(shaerId);
        userExtract.setShaerType(shaerType);
        userExtract.setRealName(realName);
        userExtract.setExtractType(extractType);
        userExtract.setBankCode(bankCode);
        userExtract.setBankAddress(bankAddress);
        userExtract.setAlipayCode(alipayCode);
        userExtract.setExtractPrice(extractPrice);
        userExtract.setExplain(explain);
        userExtract.setBalance(balance);
        userExtract.setFailMsg(failMsg);
        userExtract.setFailTime(failTime);
        userExtract.setStatus(status);
        userExtract.setWechat(wechat);
        userExtract.setIsDel(isDel);
        userExtract.setCreateTime(createTime);
        userExtract.setUpdateTime(updateTime);
        return userExtract;
    }

    /**
     * <h4>MemberExtract对象转成MemberExtractParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,shaerId,shaerType,realName,extractType,bankCode,bankAddress,alipayCode,extractPrice,explain,balance,failMsg,failTime,status,wechat,isDel,createTime,updateTime]
     * </pre>
     */
    public UserExtractParam compat(UserExtract userExtract) {
        if (null == userExtract) {
            return new UserExtractParam();
        }
        this.setId(userExtract.getId());
        this.setShaerId(userExtract.getShaerId());
        this.setShaerType(userExtract.getShaerType());
        this.setRealName(userExtract.getRealName());
        this.setExtractType(userExtract.getExtractType());
        this.setBankCode(userExtract.getBankCode());
        this.setBankAddress(userExtract.getBankAddress());
        this.setAlipayCode(userExtract.getAlipayCode());
        this.setExtractPrice(userExtract.getExtractPrice());
        this.setExplain(userExtract.getExplain());
        this.setBalance(userExtract.getBalance());
        this.setFailMsg(userExtract.getFailMsg());
        this.setFailTime(userExtract.getFailTime());
        this.setStatus(userExtract.getStatus());
        this.setWechat(userExtract.getWechat());
        this.setIsDel(userExtract.getIsDel());
        this.setCreateTime(userExtract.getCreateTime());
        this.setUpdateTime(userExtract.getUpdateTime());
        return this;
    }
}
