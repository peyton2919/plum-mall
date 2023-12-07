package cn.peyton.plum.mall.service.sys.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.core.utils.StrUtils;
import cn.peyton.plum.mall.bo.UserRoleBo;
import cn.peyton.plum.mall.mapper.sys.UserRoleMapper;
import cn.peyton.plum.mall.param.sys.UserRoleParam;
import cn.peyton.plum.mall.pojo.sys.UserRole;
import cn.peyton.plum.mall.service.sys.UserRoleService;
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
@Service("userRoleService")
public class UserRoleServiceImpl extends AbstractRealizeService<Long, UserRole, UserRoleParam> implements UserRoleService {
    @Resource
    @Transient
    private UserRoleMapper userRoleMapper;

    @Override
    public BaseConvertBo<UserRole, UserRoleParam> initBo() {
        return new UserRoleBo();
    }

    @Override
    public IBaseMapper<Long, UserRole> initMapper() {
        return userRoleMapper;
    }

    public UserRoleServiceImpl(){
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }

    @Override
    public List<Long> findRoleIdListByUserId(Long shareId, Integer shareType) {
        String key = keyPrefix + "_findRoleIdListByUserId_" + shareId + "_" + shareType;
        if (enabledCache){
            Object obj = cache.get(key);
            if (null != obj) {
                System.out.printf("从缓存获取到对象: key= %s;\n",key);
                return (List<Long>) obj;
            }
        }
        List<Long> result = userRoleMapper.selecRoleIdListByUserId(shareId, shareType);
        if (result.size() > 0 && enabledCache) {
            System.out.printf("添加对象到缓存: key= %s;\n",key);
            cache.put(key, result);
        }
        return result;
    }

    @Override
    public List<Long> findUserIdListByRoleId(Long roleId, Integer shareType) {
        String key = keyPrefix + "_findUserIdListByRoleId_" + roleId + "_" + shareType;
        if (enabledCache){
            Object obj = cache.get(key);
            if (null != obj) {
                System.out.printf("从缓存获取到对象: key= %s;\n",key);
                return (List<Long>) obj;
            }
        }
        List<Long> result = userRoleMapper.selctUserIdListByRoleId(roleId, shareType);
        if (result.size() > 0 && enabledCache) {
            System.out.printf("添加对象到缓存: key= %s;\n",key);
            cache.put(key, result);
        }
        return result;
    }

    @Override
    public Boolean deleteUserByRoleId(Long roleId, Integer shareType) {
        int result = userRoleMapper.deleteUserByRoleId(roleId, shareType);
        if (result > 0 && enabledCache) {
            System.out.println("删除对象操作,清空缓存");
            removeCache();
            return true;
        }
        return false;
    }

    @Override
    public Boolean batchAdd(List<UserRole> userRoleList) {
        int result = userRoleMapper.batchAdd(userRoleList);
        if (result > 0 && enabledCache) {
            System.out.println("删除对象操作,清空缓存");
            removeCache();
            return true;
        }
        return false;
    }

    @Override
    public List<Long> findUserIdListByRoleIdList(List<Integer> roleIdList, Integer shareType) {
        String key = keyPrefix + "_findUserIdListByRoleIdList_" + StrUtils.join(roleIdList,null) + "_" + shareType;
        if (enabledCache){
            Object obj = cache.get(key);
            if (null != obj) {
                System.out.printf("从缓存获取到对象: key= %s;\n",key);
                return (List<Long>) obj;
            }
        }
        List<Long> result = userRoleMapper.selectUserIdListByRoleIdList(roleIdList, shareType);
        if (result.size() > 0 && enabledCache) {
            System.out.printf("添加对象到缓存: key= %s;\n",key);
            cache.put(key, result);
        }
        return result;
    }

    @Override
    public UserRoleParam findByThree(UserRoleParam record) {
        String key = keyPrefix + "_findByThree_" + getKeySuffix(record);
        if (enabledCache){
            Object obj = cache.get(key);
            if (null != obj) {
                System.out.printf("从缓存获取到对象: key= %s;\n",key);
                return (UserRoleParam) obj;
            }
        }
        UserRoleParam result = initBo().compat(userRoleMapper.selectByThree(initBo().convert(record)));
        if (null != result && enabledCache) {
            System.out.printf("添加对象到缓存: key= %s;\n", key);
            cache.put(key, result);
        }
        return result;
    }
}
