package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractAppRealizeService;
import cn.peyton.plum.mall.bo.MemberLevelBo;
import cn.peyton.plum.mall.mapper.MemberLevelMapper;
import cn.peyton.plum.mall.param.MemberLevelParam;
import cn.peyton.plum.mall.pojo.MemberLevel;
import cn.peyton.plum.mall.service.MemberLevelService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

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
public class MemberLevelServiceImpl extends AbstractAppRealizeService<Integer, MemberLevel, MemberLevelParam> implements MemberLevelService {
    @Resource
    private MemberLevelMapper memberLevelMapper;

    @Override
    public BaseConvertBo<MemberLevel, MemberLevelParam> initBo() {
        return new MemberLevelBo();
    }

    @Override
    public IBaseMapper<Integer, MemberLevel> initMapper() {
        return memberLevelMapper;
    }

}
