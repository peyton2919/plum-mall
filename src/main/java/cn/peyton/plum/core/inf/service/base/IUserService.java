package cn.peyton.plum.core.inf.service.base;

/**
 * <h4>{规范}用户相关 服务接口</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.core.inf.service.
 * @date 2023年12月25日 21:35
 * @version 1.0.0
 * </pre>
 */
public interface IUserService<P> {

    /**
     * <h4>判断用户是否被禁用</h4>
     * @param keyword 用户名称
     * @param type 类型 account:表示 用户名称 ; phone: 表示 用户手机; email 表示 邮箱
     * @param status 条件 0  {状态 0 表示 禁用 ; 1 表示 可用}
     * @return true 表示 该用记被禁用 ;
     */
    boolean checkStatus(String keyword, String type,Integer status);

    /**
     * <h4>用户账户/手机/邮箱 登录 </h4>
     *
     * @param keyword 用户名
     * @param password 密码
     * @param loginType 登录类型
     * @return 用户对象
     */
    P login(String keyword, String password, String loginType);

    /**
     * <h4>判断密码</h4>
     * @param id 主键
     * @param password 密码
     * @return 密码正确 返回 true
     */
    Boolean isPassword(Long id, String password);

    /**
     * <h4>更新最后登录信息</h4>
     * <pre>
     *     更新 lastIp, lastLoginTime, id
     *     并更新 累计数 +1
     * </pre>
     * @param user 对象
     * @return 返回 true 成功
     */
    Boolean  updateLastLogin(P user);

    /**
     * <h4>更新密码</h4>
     * @param id 主键
     * @param pwd 密码{加密后}
     * @return 返回 true 成功
     */
    Boolean updatePassword(Long id, String pwd);

    /**
     * <h4>判断手机</h4>
     * <pre>
     *     select status from table where phone = ?
     * </pre>
     * @param phone 手机号码
     * @return 返回 status null 手机号不存在  1 启用 0 禁用
     */
    Integer isPhone(String phone);

    /**
     * <h4>更新头像</h4>
     * @param id 主键
     * @param avatar 头像
     * @return 返回 true 成功
     */
    Boolean updateAvatar(Long id, String avatar);
}
