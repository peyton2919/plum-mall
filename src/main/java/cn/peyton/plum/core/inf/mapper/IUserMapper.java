package cn.peyton.plum.core.inf.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * <h4></h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.core.inf.mapper.
 * @date 2023年12月26日 9:22
 * @version 1.0.0
 * </pre>
 */
@Mapper
public interface IUserMapper<IUser> {

    /**
     * <h4>判断用户是否被禁用</h4>
     * @param keyword 用户名称
     * @param type 类型 account:表示 用户名称 ; phone: 表示 用户手机
     * @param status 状态 0 表示 禁用 ; 1 表示 可用 ; status = -1时表示 不查找 status 字段
     * @return 0 表示 没查到数据行 ; 大于 0 表示 有查到数据行;
     */
    int checkStatus(String tableName,String keyword, String type,Integer status);


    /**
     * <h4>用户账户/手机/邮箱 登录 </h4>
     * <pre>
     *     `id`,`avatar`,`email`,`username`,`dept_id`,`phone`,`job_id`,`nick_name`,`sex`
     * </pre>
     * @param keyword 用户名
     * @param password 密码
     * @param loginType 登录类型
     * @return 用户对象
     */
    IUser login(String keyword, String password, String loginType);

    // ==================================== new create method ==================================== //

    /**
     * <h4>判断密码</h4>
     *
     * @param id       主键
     * @param password 密码
     * @return 密码正确 返回 > 0
     */
    @Select("select count(id) from ${tableName} where is_del=1 and id = #{id} and password = #{password}")
    int isPassword(@Param("tableName") String tableName, @Param("id") Long id, @Param("password") String password);

    /**
     * <h4>更新最后登录信息</h4>
     * <pre>
     *     更新 lastIp, lastLoginTime, id
     *     并更新 累计数 +1
     * </pre>
     *
     * @param user 对象
     * @return 返回 true 成功
     */
    @Update("update ${tableName} set last_ip=#{user.lastIp},last_login_time = #{user.lastLoginTime},loc = loc+1 where id=#{user.id} and is_del =1")
    int updateLastLogin(@Param("tableName") String tableName, @Param("user") IUser user);

    /**
     * <h4>更新密码</h4>
     *
     * @param id  主键
     * @param pwd 密码{加密后}
     * @return 返回 true 成功
     */
    @Update(" update ${tableName} set password= #{pwd} where id = #{id}  and is_del=1")
    int updatePassword(@Param("tableName") String tableName, @Param("id") Long id, @Param("pwd") String pwd);

    /**
     * <h4>判断手机</h4>
     * <pre>
     *     select status from table where phone = ?
     * </pre>
     * @param phone 手机号码
     * @return 返回 status null 手机号不存在  1 启用 0 禁用
     */
    @Select("select status from ${tableName}  where is_del=1 and phone = #{phone}")
    Integer isPhone(@Param("tableName") String tableName,String phone);

    /**
     * <h4>更新头像</h4>
     *
     * @param id     主键
     * @param avatar 头像
     * @return 返回 true 成功
     */
    @Update("update ${tableName} set avatar = #{avatar} where id = #{id}")
    int updateAvatar(@Param("tableName") String tableName, @Param("id") Long id, @Param("avatar") String avatar);
}
