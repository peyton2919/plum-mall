package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.mall.bo.UserAddressBo;
import cn.peyton.plum.mall.mapper.UserAddressMapper;
import cn.peyton.plum.mall.param.UserAddressParam;
import cn.peyton.plum.mall.pojo.UserAddress;
import cn.peyton.plum.mall.service.UserAddressService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

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
public class UserAddressServiceImpl extends AbstractRealizeService<Long, UserAddress, UserAddressParam> implements UserAddressService {
    @Resource
    private UserAddressMapper userAddressMapper;

    @Override
    public BaseConvertBo<UserAddress, UserAddressParam> initBo() {
        return new UserAddressBo();
    }

    @Override
    public IBaseMapper<Long, UserAddress> initMapper() {
        return userAddressMapper;
    }

}
