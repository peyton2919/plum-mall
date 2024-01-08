package cn.peyton.plum.mall.service.party.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
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
public class MemberLevelServiceImpl extends AbstractRealizeService<Integer, MemberLevel, MemberLevelParam> implements MemberLevelService {
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

    public MemberLevelServiceImpl() {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }

    @Override
    public List<MemberLevelParam> findByDownList() {
        String key = keyPrefix + "_202312251930";
        if(enabledCache){
            Object list = cache.get(key);
            if (null != list) {
                System.out.printf("从缓存获取到对象: key= %s;\n",key);
                return (List<MemberLevelParam>)list;
            }
        }
        List<MemberLevelParam> pList = initBo().adapter(memberLevelMapper.selectByDownList());
        if (null != pList && pList.size() > 0 && enabledCache) {
            System.out.printf("添加对象到缓存: key= %s;\n",key);
            cache.put(key,pList);
        }
        return pList;
    }
}
