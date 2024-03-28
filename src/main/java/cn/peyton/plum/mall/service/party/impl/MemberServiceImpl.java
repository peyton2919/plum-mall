package cn.peyton.plum.mall.service.party.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.RealizeService;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.PageResult;
import cn.peyton.plum.core.page.PageResultAdapter;
import cn.peyton.plum.mall.bo.MemberBo;
import cn.peyton.plum.mall.mapper.party.MemberMapper;
import cn.peyton.plum.mall.param.party.MemberParam;
import cn.peyton.plum.mall.pojo.party.Member;
import cn.peyton.plum.mall.service.party.MemberService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

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
public class MemberServiceImpl extends RealizeService<Long, Member, MemberParam> implements MemberService {
    @Resource
    private MemberMapper memberMapper;
    /** 当前记录 表名 */
    private String TABLE_NAME = "tb_member";

    @Override
    public BaseConvertBo<Member, MemberParam> bo() {
        return new MemberBo();
    }

    @Override
    public IBaseMapper<Long, Member> mapper() {
        return memberMapper;
    }

    public MemberServiceImpl() {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }

    @Override
    public Boolean isMemberLevel(Integer levelId) {
        return memberMapper.isMemberLevel(levelId) > 0;
    }

    @Override
    public Boolean upDelete(Long id) {
        if (memberMapper.updateDeleteStatus(TABLE_NAME, id) > 0) {
            clearCache("删除");
            return true;
        }
        return false;
    }

    @Override
    public PageResult<?> search(MemberParam record, PageQuery page) {
        String key = keywords(record,page,true);
        //List<MemberLevelParam> memberLevelParams = null;
        Object objs = getCache(key);
        if (null == objs) {
            PageResult<?> result = PageResultAdapter.adaptByLike(mapper(), page, bo().convert(record), bo());
            saveCache(key, result, result.isSuccess);
            return result;
        }
        return (PageResult<?>) objs;

    }

    @Override
    public List<MemberParam> findByDownList() {
        String key = keyPrefix + "_202312251921";

        Object objs = getCache(key);
        if (null == objs) {
            List<MemberParam> result = bo().adapter(memberMapper.selectByDownList());
            saveCache(key, result);
            return result;
        }
        return (List<MemberParam>) objs;
    }
    @Override
    public Boolean upStatus(Long id, Integer status) {
        int res = memberMapper.upStatus(id, status);
        if (res > 0) {
            clearCache("更新状态");
            return true;
        }
        return false;
    }

    @Override
    public boolean checkStatus(String keyword, String type, Integer status) {

        return memberMapper.checkStatus(TABLE_NAME,keyword, type, status) > 0;
    }

    @Override
    public MemberParam login(String keyword, String password, String loginType) {
        Member member = memberMapper.login(keyword, password, loginType);
        return (null == member) ? null : new MemberParam().compat(member);
    }


    @Override
    public Boolean isPassword(Long id, String password) {
        return memberMapper.isPassword(TABLE_NAME, id, password) > 0;
    }

    @Override
    public  Boolean updateLastLogin(MemberParam param) {
        int res = memberMapper.updateLastLogin(TABLE_NAME, param.convert());
        if (res > 0) {
            clearCache("更新最后登录");
            return true;
        }
        return false;
    }

    @Override
    public Boolean updatePassword(Long id, String pwd) {
        int res = memberMapper.updatePassword(TABLE_NAME, id, pwd);
        if (res > 0) {
            clearCache("更新密码");
            return true;
        }
        return false;
    }

    @Override
    public Integer isPhone(String phone) {
        return memberMapper.isPhone(TABLE_NAME, phone);
    }

    @Override
    public Boolean updateAvatar(Long id, String avatar) {
        int res = memberMapper.updateAvatar(TABLE_NAME, id, avatar);
        if (res > 0) {
            clearCache("更新头像");
            return true;
        }
        return false;
    }
}
