package cn.peyton.plum.core.users;

import java.io.Serializable;

/**
 * <h3>基础 用户类 .</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 14:55
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public abstract class BaseUser implements IUser, Serializable {

    /** 主键Id */
    private Long id;
    /** 最后登录IP  */
    private String lastIp;
    /** 最后登录时间  */
    private String lastLoginTime;
    /** token 值 */
    private String token;

    /**
     * 用户登录类型
     */
    private String loginType;
    /**
     * 获取用户类型 默认: 0 会员、1 顾客 2 供应商、3 用户 4 员工 5 超级管理员
     */
    private Integer userType;

    /**
     * <h4>设置用户类型[强制子类实现]</h4>
     *
     * @return
     */
    protected abstract Integer userType();

    /**
     * <h4>获取用户类型 默认: 0 会员、1 顾客 2 供应商、3 用户 4 员工 5 超级管理员</h4>
     *
     * @return
     */
    public Integer getUserType() {
        return this.userType();
    }

    /**
     * @param userType 用户类型 默认: 0 会员、1 顾客 2 供应商、3 用户 4 员工 5 超级管理员
     */
    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    /**
     * <h4>设置用户登录类型</h4>
     *
     * @param loginType
     */
    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    /**
     * <h4>获取用户登录类型</h4>
     *
     * @return
     */
    public String getLoginType() {
        return this.loginType;
    }

    /**
     * @return token 值
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token token 值
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return 主键Id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id 主键Id
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @param lastIp 最后登录IP
     */
    public void setLastIp(String lastIp){
        this.lastIp = lastIp;
    }

    /**
     * @return 最后登录IP
     */
    public String getLastIp(){
        return lastIp;
    }

    /**
     * @param lastLoginTime 最后登录时间
     */
    public void setLastLoginTime(String lastLoginTime){
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * @return 最后登录时间
     */
    public String getLastLoginTime(){
        return lastLoginTime;
    }
}
