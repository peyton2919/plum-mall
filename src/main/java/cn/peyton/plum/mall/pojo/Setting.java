package cn.peyton.plum.mall.pojo;


import java.io.Serializable;

/**
 * <h3> 系统设置 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public class Setting implements Serializable {
    /**
     *
     */
    private Integer id;
    /**
     * 开启注册，0关闭1开启
     */
    private Integer openReg;
    /**
     * 注册方式，username普通phone手机
     */
    private String regMethod;
    /**
     * 密码最小长度;默认6
     */
    private Integer passwordMin;
    /**
     * 强制密码复杂度
     */
    private String passwordEncrypt;
    /**
     * 上传方式
     */
    private String uploadMethod;
    /**
     * 上传配置
     */
    private String uploadConfig;
    /**
     * 是否开启API安全，0否1是
     */
    private Integer apiSafe;
    /**
     * api秘钥
     */
    private String apiSecret;
    /**
     * 自动取消订单，分钟
     */
    private Integer closeOrderMinute;
    /**
     * 自动收货时间，天
     */
    private Integer autoReceivedDay;
    /**
     * 允许申请售后，天
     */
    private Integer afterSaleDay;
    /**
     * 支付宝支付配置
     */
    private String alipay;
    /**
     * 微信支付配置
     */
    private String wxpay;
    /**
     * 物流相关配置
     */
    private String ship;
    /**
     * 系统状态，默认0 系统关闭，1 系统开启
     */
    private Integer status;

    //================================== Constructor =======================================//

    //================================== Method =======================================//


    //================================== PREFIX_GET AND PREFIX_SET =======================================//

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param openReg 开启注册，0关闭1开启
     */
    public void setOpenReg(Integer openReg) {
        this.openReg = openReg;
    }

    /**
     * @return 开启注册，0关闭1开启
     */
    public Integer getOpenReg() {
        return openReg;
    }

    /**
     * @param regMethod 注册方式，username普通phone手机
     */
    public void setRegMethod(String regMethod) {
        this.regMethod = regMethod;
    }

    /**
     * @return 注册方式，username普通phone手机
     */
    public String getRegMethod() {
        return regMethod;
    }

    /**
     * @param passwordMin 密码最小长度;默认6
     */
    public void setPasswordMin(Integer passwordMin) {
        this.passwordMin = passwordMin;
    }

    /**
     * @return 密码最小长度;默认6
     */
    public Integer getPasswordMin() {
        return passwordMin;
    }

    /**
     * @param passwordEncrypt 强制密码复杂度
     */
    public void setPasswordEncrypt(String passwordEncrypt) {
        this.passwordEncrypt = passwordEncrypt;
    }

    /**
     * @return 强制密码复杂度
     */
    public String getPasswordEncrypt() {
        return passwordEncrypt;
    }

    /**
     * @param uploadMethod 上传方式
     */
    public void setUploadMethod(String uploadMethod) {
        this.uploadMethod = uploadMethod;
    }

    /**
     * @return 上传方式
     */
    public String getUploadMethod() {
        return uploadMethod;
    }

    /**
     * @param uploadConfig 上传配置
     */
    public void setUploadConfig(String uploadConfig) {
        this.uploadConfig = uploadConfig;
    }

    /**
     * @return 上传配置
     */
    public String getUploadConfig() {
        return uploadConfig;
    }

    /**
     * @param apiSafe 是否开启API安全，0否1是
     */
    public void setApiSafe(Integer apiSafe) {
        this.apiSafe = apiSafe;
    }

    /**
     * @return 是否开启API安全，0否1是
     */
    public Integer getApiSafe() {
        return apiSafe;
    }

    /**
     * @param apiSecret api秘钥
     */
    public void setApiSecret(String apiSecret) {
        this.apiSecret = apiSecret;
    }

    /**
     * @return api秘钥
     */
    public String getApiSecret() {
        return apiSecret;
    }

    /**
     * @param closeOrderMinute 自动取消订单，分钟
     */
    public void setCloseOrderMinute(Integer closeOrderMinute) {
        this.closeOrderMinute = closeOrderMinute;
    }

    /**
     * @return 自动取消订单，分钟
     */
    public Integer getCloseOrderMinute() {
        return closeOrderMinute;
    }

    /**
     * @param autoReceivedDay 自动收货时间，天
     */
    public void setAutoReceivedDay(Integer autoReceivedDay) {
        this.autoReceivedDay = autoReceivedDay;
    }

    /**
     * @return 自动收货时间，天
     */
    public Integer getAutoReceivedDay() {
        return autoReceivedDay;
    }

    /**
     * @param afterSaleDay 允许申请售后，天
     */
    public void setAfterSaleDay(Integer afterSaleDay) {
        this.afterSaleDay = afterSaleDay;
    }

    /**
     * @return 允许申请售后，天
     */
    public Integer getAfterSaleDay() {
        return afterSaleDay;
    }

    /**
     * @param alipay 支付宝支付配置
     */
    public void setAlipay(String alipay) {
        this.alipay = alipay;
    }

    /**
     * @return 支付宝支付配置
     */
    public String getAlipay() {
        return alipay;
    }

    /**
     * @param wxpay 微信支付配置
     */
    public void setWxpay(String wxpay) {
        this.wxpay = wxpay;
    }

    /**
     * @return 微信支付配置
     */
    public String getWxpay() {
        return wxpay;
    }

    /**
     * @param ship 物流相关配置
     */
    public void setShip(String ship) {
        this.ship = ship;
    }

    /**
     * @return 物流相关配置
     */
    public String getShip() {
        return ship;
    }

    /**
     * @param status 系统状态，默认0 系统关闭，1 系统开启
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return 系统状态，默认0 系统关闭，1 系统开启
     */
    public Integer getStatus() {
        return status;
    }

}
