package cn.peyton.plum.mall.service.party.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.mall.bo.UserAddressBo;
import cn.peyton.plum.mall.mapper.party.UserAddressMapper;
import cn.peyton.plum.mall.param.party.UserAddressParam;
import cn.peyton.plum.mall.pojo.party.UserAddress;
import cn.peyton.plum.mall.service.party.UserAddressService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h3> 用户地址{用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)} Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:53
 * @version 1.0.0
 * </pre>
 */
@Service("userAddressService")
public class UserAddressServiceImpl extends AbstractRealizeService<Long, cn.peyton.plum.mall.pojo.party.UserAddress, UserAddressParam> implements UserAddressService {
    @Resource
    private UserAddressMapper userAddressMapper;

    @Override
    public BaseConvertBo<cn.peyton.plum.mall.pojo.party.UserAddress, UserAddressParam> initBo() {
        return new UserAddressBo();
    }

    @Override
    public IBaseMapper<Long, cn.peyton.plum.mall.pojo.party.UserAddress> initMapper() {
        return userAddressMapper;
    }

    public UserAddressServiceImpl() {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }

    @Override
    public List<UserAddressParam> findByShareId(Long shareId, Integer shareType) {
        String key = keyPrefix + "_" + shareId + "_" + shareType;
        if (enabledCache) {
            Object obj = cache.get(key);
            if (null != obj) {
                System.out.println("从缓存中获取到的数据,KEY = " + key);
                return (List<UserAddressParam>)obj;
            }
        }
        List<UserAddressParam> result = initBo().adapter(userAddressMapper.selectByShareId(shareId, shareType));
        if (null != result && enabledCache) {
            System.out.printf("添加对象到缓存: key= %s;\n",key);
            cache.put(key,result);
        }
        return result;
    }

    @Override
    public boolean upLastUsedTime(Long id, Integer lastUsedTime) {
        int res = userAddressMapper.upLastUsedTime(id, lastUsedTime);
        if (res > 0) {
            if (enabledCache) {
                System.out.println("更新操作清空缓存");
                removeCache();
            }
            return true;
        }
        return false;
    }

    @Override
    public List<UserAddressParam> findAndroidByShareId(Long shareId, Integer shareType, PageQuery page) {
        String key = keyPrefix + shareId + shareType + createKey(null, page, false);
        if (enabledCache) {
            Object obj = cache.get(key);
            if (null != obj) {
                System.out.println("从缓存中获取到数据; key="+key);
                return (List<UserAddressParam>) obj;
            }
        }
        List<UserAddress> userAddresses = userAddressMapper.selectAndroidByShareId(shareId, shareType, page);
        if (null != userAddresses && userAddresses.size() > 0) {
            List<UserAddressParam> result = initBo().adapter(userAddresses);
            if (enabledCache) {
                System.out.println("找到数据添加到缓存; key=" + key);
                cache.put(key, result);
            }
            return result;
        }
        return null;
    }
}
