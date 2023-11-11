package cn.peyton.plum.mall.mapper;

import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.mall.pojo.User;

/**
 * <h3> 系统用户 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public interface UserMapper extends IBaseMapper<Long, User> {

    /**
     * <h4>判断用户是否被禁用</h4>
     * @param keyword 用户名称
     * @param type 类型 account:表示 用户名称 ; phone: 表示 用户手机
     * @param status 状态 0 表示 禁用 ; 1 表示 可用 ; status = -1时表示 不查找 status 字段
     * @return 0 表示 没查到数据行 ; 大于 0 表示 有查到数据行;
     */
    int checkStatus(String keyword, String type,Integer status);


    /**
     * <h4>用户账户/手机/邮箱 登录 </h4>
     *
     * @param keyword 用户名
     * @param password 密码
     * @param loginType 登录类型
     * @return 用户对象
     */
    User login(String keyword, String password, String loginType);
    // ==================================== new create method ==================================== //


}
