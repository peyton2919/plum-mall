package cn.peyton.plum.mall.service.party.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.PageResult;
import cn.peyton.plum.core.page.PageResultAdapter;
import cn.peyton.plum.mall.bo.MemberBo;
import cn.peyton.plum.mall.mapper.party.MemberMapper;
import cn.peyton.plum.mall.param.party.MemberLevelParam;
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
public class MemberServiceImpl extends AbstractRealizeService<Long, Member, MemberParam> implements MemberService {
    @Resource
    private MemberMapper memberMapper;
    /** 当前记录 表名 */
    private String TABLE_NAME = "tb_member";

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

    @Override
    public Boolean isMemberLevel(Integer levelId) {
        return memberMapper.isMemberLevel(levelId) > 0;
    }

    @Override
    public Boolean upDelete(Long id) {
        if (memberMapper.updateDeleteStatus(TABLE_NAME, id) > 0) {

            if (enabledCache) {
                System.out.println("删除操作, 清空缓存;");
                removeCache();
            }
            return true;
        }
        return false;
    }

    @Override
    public PageResult<?> search(MemberParam record, PageQuery page) {
        String key = createKey(record,page,true);
        List<MemberLevelParam> memberLevelParams = null;
        if(enabledCache){
            Object list = cache.get(key);
            if (null != list) {
                System.out.printf("从缓存获取到对象: key= %s;\n",key);
                return (PageResult<?>)list;
            }
        }
        PageResult<?> result = PageResultAdapter.adaptByLike(initMapper(), page, initBo().convert(record), initBo());
        if (null != result && result.isSuccess && enabledCache) {
            System.out.printf("添加对象到缓存: key= %s;\n",key);
            cache.put(key,result);
        }
        return result;
    }

    @Override
    public List<MemberParam> findByDownList() {
        String key = keyPrefix + "_202312251921";
        if(enabledCache){
            Object list = cache.get(key);
            if (null != list) {
                System.out.printf("从缓存获取到对象: key= %s;\n",key);
                return (List<MemberParam>)list;
            }
        }
        List<MemberParam> result = initBo().adapter(memberMapper.selectByDownList());
        if (null != result && enabledCache) {
            System.out.printf("添加对象到缓存: key= %s;\n",key);
            cache.put(key,result);
        }
        return result;
    }
    @Override
    public Boolean upStatus(Long id, Integer status) {
        int res = memberMapper.upStatus(id, status);
        if (res > 0) {
            if(enabledCache){
                System.out.println("更新状态操作清空缓存");
                removeCache();
            }
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
            if (enabledCache) {
                System.out.println("更新操作,清空缓存");
                removeCache();
            }
            return true;
        }
        return false;
    }

    @Override
    public Boolean updatePassword(Long id, String pwd) {
        int res = memberMapper.updatePassword(TABLE_NAME, id, pwd);
        if (res > 0) {
            if (enabledCache) {
                System.out.println("更新操作,清空缓存");
                removeCache();
            }
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
            if (enabledCache) {
                System.out.println("更新操作,清空缓存");
                removeCache();
            }
            return true;
        }
        return false;
    }
}
