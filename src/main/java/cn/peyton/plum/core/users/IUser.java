package cn.peyton.plum.core.users;

/**
 * <h3>用户 基础接口</h3>
 * <pre>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2018/11/16 15:35
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @version 1.0.0
 * </pre>
 */
public interface IUser {
    /**
     * 超级管理员 类型 数值
     */
    Integer TYPE_ADMIN = 999;
    /*** 员工 类型 数值 */
    Integer TYPE_EMPLOYEE = 998;
    /**
     * 供应商 类型 数值
     */
    Integer TYPE_SUPPLIER = 988;
    /**
     * 顾客 类型 数值
     */
    Integer TYPE_CUSTOMER = 987;
    /**
     * 会员 类型 数值
     */
    Integer TYPE_MEMBER = 986;
    /**
     * 用户 类型 数值
     */
    Integer TYPE_USER = 985;

    /**
     * 账号 登录 类型 数值
     */
    String LOGIN_TYPE_ACCOUNT = "account";
    /**
     * 手机 登录 类型 数值
     */
    String LOGIN_TYPE_PHONE = "phone";
    /**
     * 邮箱 登录 类型 数值
     */
    String LOGIN_TYPE_EMAIL = "email";
    /**
     * 微信 登录 类型 数值
     */
    String LOGIN_TYPE_WEIXIN = "weixin";
    /**
     * 支付宝 登录 类型 数值
     */
    String LOGIN_TYPE_ZHIFUBAO = "zhifubao";
    /**
     * 新浪微博 登录 类型 数值
     */
    String LOGIN_TYPE_XINLANGWEIBO = "xinlangweibo";
    /**
     * 百度 登录 类型 数值
     */
    String LOGIN_TYPE_BAIDU = "baidu";


}
