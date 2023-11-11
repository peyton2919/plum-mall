package cn.peyton.plum.mall.service;

import cn.peyton.plum.core.inf.service.IBaseService;
import cn.peyton.plum.mall.param.UserParam;
import cn.peyton.plum.mall.pojo.User;

/**
 * <h3> 系统用户 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
public interface UserService extends IBaseService<Long, User, UserParam> {

    /**
     * <h4>用户注册</h4>
     * @param param 用户传参对象
     * @return 用户传参对象
     */
    UserParam reg(UserParam param);
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
    UserParam login(String keyword, String password, String loginType);

}
