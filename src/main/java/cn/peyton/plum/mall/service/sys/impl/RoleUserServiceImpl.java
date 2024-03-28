package cn.peyton.plum.mall.service.sys.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.RealizeService;
import cn.peyton.plum.core.utils.StrUtils;
import cn.peyton.plum.mall.bo.RoleUserBo;
import cn.peyton.plum.mall.mapper.sys.RoleUserMapper;
import cn.peyton.plum.mall.param.sys.RoleUserParam;
import cn.peyton.plum.mall.pojo.sys.RoleUser;
import cn.peyton.plum.mall.service.sys.RoleUserService;
import jakarta.annotation.Resource;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h3> 用户角色关联 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("roleUserService")
public class RoleUserServiceImpl extends RealizeService<Long, RoleUser, RoleUserParam> implements RoleUserService {
    @Resource
    @Transient
    private RoleUserMapper roleUserMapper;

    @Override
    public BaseConvertBo<RoleUser, RoleUserParam> bo() {
        return new RoleUserBo();
    }

    @Override
    public IBaseMapper<Long, RoleUser> mapper() {
        return roleUserMapper;
    }

    public RoleUserServiceImpl(){
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }

    @Override
    public List<Long> findRoleIdListByUserId(Long shareId, Integer shareType) {
        String key = keyPrefix + "_findRoleIdListByUserId_" + shareId + "_" + shareType;
        Object objs = getCache(key);
        if (null == objs) {
            List<Long> result = roleUserMapper.selecRoleIdListByUserId(shareId, shareType);
            saveCache(key, result);
            return result;
        }
        return (List<Long>) objs;
    }

    @Override
    public List<Long> findUserIdListByRoleId(Long roleId, Integer shareType) {
        String key = keyPrefix + "_findUserIdListByRoleId_" + roleId + "_" + shareType;
        Object objs = getCache(key);
        if (null == objs) {
            List<Long> result = roleUserMapper.selctUserIdListByRoleId(roleId, shareType);
            saveCache(key, result);
            return result;
        }
        return (List<Long>) objs;
    }

    @Override
    public Boolean deleteUserByRoleId(Long roleId, Integer shareType) {
        int result = roleUserMapper.deleteUserByRoleId(roleId, shareType);
        if (result > 0) {
            clearCache("删除用户角色");
            return true;
        }
        return false;
    }

    @Override
    public Boolean batchAdd(List<RoleUser> roleUserList) {
        int result = roleUserMapper.batchAdd(roleUserList);
        if (result > 0 ) {
            clearCache("批量新增用户角色");
            return true;
        }
        return false;
    }

    @Override
    public List<Long> findUserIdListByRoleIdList(List<Integer> roleIdList, Integer shareType) {
        String key = keyPrefix + "_findUserIdListByRoleIdList_" + StrUtils.join(roleIdList,null) + "_" + shareType;
        Object objs = getCache(key);
        if (null == objs) {
            List<Long> result = roleUserMapper.selectUserIdListByRoleIdList(roleIdList, shareType);
            saveCache(key, result);
            return result;
        }
        return (List<Long>) objs;
    }

    @Override
    public RoleUserParam findByThree(RoleUserParam record) {
        StringBuffer sb = new StringBuffer();
        keywords(record,sb);
        String key = keyPrefix + "_findByThree_" + sb;
        Object obj = getCache(key);
        if (null == obj) {
            RoleUser roleUser = roleUserMapper.selectByThree(bo().convert(record));

            RoleUserParam result = (null == roleUser) ? null : bo().compat(roleUser);
            saveCache(key, result);
            return result;
        }
        return (RoleUserParam) obj;

    }

    @Override
    public Boolean isSuperAdmin(Long shareId, int shareType) {
        return roleUserMapper.isSuperAdmin(shareId, shareType) > 0;
    }
}
