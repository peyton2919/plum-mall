package cn.peyton.plum.mall.service.party.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.mall.bo.MemberBo;
import cn.peyton.plum.mall.mapper.party.MemberMapper;
import cn.peyton.plum.mall.param.party.MemberParam;
import cn.peyton.plum.mall.pojo.party.Member;
import cn.peyton.plum.mall.service.party.MemberService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 会员 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("memberService")
public class MemberServiceImpl extends AbstractRealizeService<Long, Member, MemberParam> implements MemberService {
    @Resource
    private MemberMapper memberMapper;

    @Override
    public BaseConvertBo<Member, MemberParam> initBo() {
        return new MemberBo();
    }

    @Override
    public IBaseMapper<Long, Member> initMapper() {
        return memberMapper;
    }

    public MemberServiceImpl() {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }
}