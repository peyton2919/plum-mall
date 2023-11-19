package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.mall.bo.UserBillBo;
import cn.peyton.plum.mall.mapper.UserBillMapper;
import cn.peyton.plum.mall.param.UserBillParam;
import cn.peyton.plum.mall.pojo.UserBill;
import cn.peyton.plum.mall.service.UserBillService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 会员账单{用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)} Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:53
 * @version 1.0.0
 * </pre>
 */
@Service("userBillService")
public class UserBillServiceImpl extends AbstractRealizeService<Long, UserBill, UserBillParam> implements UserBillService {
    @Resource
    private UserBillMapper userBillMapper;

    @Override
    public BaseConvertBo<UserBill, UserBillParam> initBo() {
        return new UserBillBo();
    }

    @Override
    public IBaseMapper<Long, UserBill> initMapper() {
        return userBillMapper;
    }

}
