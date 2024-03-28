package cn.peyton.plum.mall.service.party.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.RealizeService;
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
public class UserAddressServiceImpl extends RealizeService<Long, UserAddress, UserAddressParam> implements UserAddressService {
    @Resource
    private UserAddressMapper userAddressMapper;

    @Override
    public BaseConvertBo<UserAddress, UserAddressParam> bo() {
        return new UserAddressBo();
    }

    @Override
    public IBaseMapper<Long, UserAddress> mapper() {
        return userAddressMapper;
    }

    public UserAddressServiceImpl() {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }

    @Override
    public List<UserAddressParam> findByShareId(Long shareId, Integer shareType) {
        String key = keyPrefix + "_" + shareId + "_" + shareType;
        Object objs = getCache(key);
        if (null == objs) {
            List<UserAddressParam> result = bo().adapter(userAddressMapper.selectByShareId(shareId, shareType));
            saveCache(key, result);
            return result;
        }
        return (List<UserAddressParam>) objs;
    }

    @Override
    public boolean upLastUsedTime(Long id, Integer lastUsedTime) {
        int res = userAddressMapper.upLastUsedTime(id, lastUsedTime);
        if (res > 0) {
            clearCache("更新用户地址最后时间");
            return true;
        }
        return false;
    }

    @Override
    public List<UserAddressParam> findAndroidByShareId(Long shareId, Integer shareType, PageQuery page) {
        String key = keyPrefix + shareId + shareType + keywords(null, page, false);
        Object objs = getCache(key);
        if (null == objs) {
            List<UserAddressParam> adapter = bo().adapter(userAddressMapper.selectAndroidByShareId(shareId, shareType, page));
            saveCache(key, adapter);
            return adapter;
        }
        return (List<UserAddressParam>) objs;
    }

    @Override
    public void upLastUsedTimeNullByShareId(Long shareId, int shareType) {
        userAddressMapper.upLastUsedTimeNullByShareId(shareId, shareType);
    }
}
