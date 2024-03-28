package cn.peyton.plum.mall.service.party.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.RealizeService;
import cn.peyton.plum.mall.bo.MemberLevelBo;
import cn.peyton.plum.mall.mapper.party.MemberLevelMapper;
import cn.peyton.plum.mall.param.party.MemberLevelParam;
import cn.peyton.plum.mall.pojo.party.MemberLevel;
import cn.peyton.plum.mall.service.party.MemberLevelService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h3> 会员等级 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("memberLevelService")
public class MemberLevelServiceImpl extends RealizeService<Integer, MemberLevel, MemberLevelParam> implements MemberLevelService {
    @Resource
    private MemberLevelMapper memberLevelMapper;

    @Override
    public BaseConvertBo<MemberLevel, MemberLevelParam> bo() {
        return new MemberLevelBo();
    }

    @Override
    public IBaseMapper<Integer, MemberLevel> mapper() {
        return memberLevelMapper;
    }

    public MemberLevelServiceImpl() {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }

    @Override
    public List<MemberLevelParam> findByDownList() {
        String key = keyPrefix + "_202312251930";
        Object objs = getCache(key);
        if (null == objs) {
            List<MemberLevelParam> res = bo().adapter(memberLevelMapper.selectByDownList());
            saveCache(key, res);
            return res;
        }
        return (List<MemberLevelParam>) objs;
    }
}
