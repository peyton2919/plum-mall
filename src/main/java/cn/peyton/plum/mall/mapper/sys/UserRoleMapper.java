package cn.peyton.plum.mall.mapper.sys;

import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.mall.pojo.sys.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <h3> 用户角色关联 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月13日 20:52:44
 * @version 1.0.0
 * </pre>
*/
public interface UserRoleMapper extends IBaseMapper<Long,UserRole> {

    /**
     * <h4>根据用户ID和类型 查找 角色ID集合</h4>
     * @param shareId 用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)
     * @param shareType 用户类型 ,默认 2 员工、 0 会员、1 供应商
     * @return
     */
    List<Long> selecRoleIdListByUserId(@Param("shareId") Long shareId,@Param("shareType") Integer shareType);

    /**
     * <h4>根据角色ID 查找 用户ID</h4>
     * @param roleId 角色ID
     * @param shareType 用户类型 ,默认 2 员工、 0 会员、1 供应商
     * @return 用户ID集合
     */
    List<Long> selctUserIdListByRoleId(@Param("roleId") Long roleId,@Param("shareType") Integer shareType);

    /**
     * <h4>根据 角色ID 删除用户信息</h4>
     * @param roleId 角色ID
     * @param shareType 用户类型 ,默认 2 员工、 0 会员、1 供应商
     */
    int deleteUserByRoleId(@Param("roleId") Long roleId,@Param("shareType") Integer shareType);

    /**
     * <h4>批量添加 用户角色对象</h4>
     * @param userRoleList 用户角色对象集合
     */
    int batchAdd(@Param("userRoleList") List<UserRole> userRoleList);

    /**
     * <h4>根据角色ID集合 查找 用户ID</h4>
     * @param roleIdList 角色ID集合
     * @param shareType 用户类型 ,默认 2 员工、 0 会员、1 供应商
     * @return 用户ID集合
     */
    List<Long> selectUserIdListByRoleIdList(@Param("roleIdList") List<Integer> roleIdList,@Param("shareType") Integer shareType);

    /**
     * <h4>根据用户Id、角色Id及用户类型 查找一条信息</h4>
     * @param record 用户角色对象
     */
    UserRole selectByThree(UserRole record);
}
