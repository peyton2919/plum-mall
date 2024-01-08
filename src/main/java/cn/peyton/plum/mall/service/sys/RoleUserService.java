package cn.peyton.plum.mall.service.sys;

import cn.peyton.plum.core.inf.service.IBaseService;
import cn.peyton.plum.mall.param.sys.RoleUserParam;
import cn.peyton.plum.mall.pojo.sys.RoleUser;

import java.util.List;

/**
 * <h3> 用户角色关联 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
public interface RoleUserService extends IBaseService<Long, RoleUser, RoleUserParam> {

    /**
     * <h4>根据用户ID和类型 查找 角色ID集合</h4>
     * @param shareId 用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)
     * @param shareType 用户类型 ,默认 2 员工、 0 会员、1 供应商
     * @return
     */
    List<Long> findRoleIdListByUserId(Long shareId, Integer shareType);

    /**
     * <h4>根据角色ID 查找 用户ID</h4>
     * @param roleId 角色ID
     * @param shareType 用户类型 ,默认 2 员工、 0 会员、1 供应商
     * @return 用户ID集合
     */
    List<Long> findUserIdListByRoleId(Long roleId,Integer shareType);

    /**
     * <h4>根据 角色ID 删除用户信息</h4>
     * @param roleId 角色ID
     * @param shareType 用户类型 ,默认 2 员工、 0 会员、1 供应商
     * @return  删除成功 为 true
     */
    Boolean deleteUserByRoleId(Long roleId,Integer shareType);

    /**
     * <h4>批量添加 用户角色对象</h4>
     * @param roleUserList 用户角色对象集合
     * @return  添加成功 为 true
     */
    Boolean batchAdd(List<RoleUser> roleUserList);

    /**
     * <h4>根据角色ID集合 查找 用户ID</h4>
     * @param roleIdList 角色ID集合
     * @param shareType 用户类型 ,默认 2 员工、 0 会员、1 供应商
     * @return 用户ID集合
     */
    List<Long> findUserIdListByRoleIdList(List<Integer> roleIdList,Integer shareType);

    /**
     * <h4>根据用户Id、角色Id及用户类型 查找一条信息</h4>
     * @param record 用户角色对象
     * @return
     */
    RoleUserParam findByThree(RoleUserParam record);

    /**
     * <h4>是否是超级管理员</h4>
     * @param shareId 用户Id
     * @param shareType 用户类型
     * @return true 表示为超级管理员
     */
    Boolean isSuperAdmin(Long shareId, int shareType);

}
