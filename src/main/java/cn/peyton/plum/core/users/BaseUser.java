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
public abstract class BaseUser<K, T> implements IUser, Serializable {

    /** token 值 */
    private String token;
    /**
     * 用户登录类型
     */
    private String loginType;
    /**
     * 用户类型
     */
    private Integer userType;

    /**
     * <h4>设置用户类型[强制子类实现]</h4>
     *
     * @return
     */
    protected abstract Integer userType();

    /**
     * <h4>获取用户类型</h4>
     *
     * @return
     */
    public Integer getUserType() {
        return this.userType();
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
}
