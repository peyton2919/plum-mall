package cn.peyton.plum.mall.service.party.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.mall.bo.UserCommissionBillBo;
import cn.peyton.plum.mall.mapper.party.UserCommissionBillMapper;
import cn.peyton.plum.mall.param.party.UserCommissionBillParam;
import cn.peyton.plum.mall.pojo.party.UserCommissionBill;
import cn.peyton.plum.mall.service.party.UserCommissionBillService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 用户分佣账单{用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)} Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:53
 * @version 1.0.0
 * </pre>
 */
@Service("userCommissionBillService")
public class UserCommissionBillServiceImpl extends AbstractRealizeService<Long, UserCommissionBill, UserCommissionBillParam> implements UserCommissionBillService {
    @Resource
    private UserCommissionBillMapper userCommissionBillMapper;

    @Override
    public BaseConvertBo<UserCommissionBill, UserCommissionBillParam> initBo() {
        return new UserCommissionBillBo();
    }

    @Override
    public IBaseMapper<Long, UserCommissionBill> initMapper() {
        return userCommissionBillMapper;
    }

    public UserCommissionBillServiceImpl() {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }
}
