package cn.peyton.plum.mall.service.party.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.RealizeService;
import cn.peyton.plum.mall.bo.ShareBindBo;
import cn.peyton.plum.mall.mapper.party.ShareBindMapper;
import cn.peyton.plum.mall.param.party.ShareBindParam;
import cn.peyton.plum.mall.pojo.party.ShareBind;
import cn.peyton.plum.mall.service.party.ShareBindService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 第三方用户绑定信息{用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)} Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("shareBindService")
public class ShareBindServiceImpl extends RealizeService<Long, ShareBind, ShareBindParam> implements ShareBindService {
    @Resource
    private ShareBindMapper shareBindMapper;

    @Override
    public BaseConvertBo<ShareBind, ShareBindParam> bo() {
        return new ShareBindBo();
    }

    @Override
    public IBaseMapper<Long, ShareBind> mapper() {
        return shareBindMapper;
    }

    public ShareBindServiceImpl() {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }
}
