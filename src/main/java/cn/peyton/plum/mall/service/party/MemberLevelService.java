package cn.peyton.plum.mall.service.party;

import cn.peyton.plum.core.inf.service.base.IRealizeService;
import cn.peyton.plum.mall.param.party.MemberLevelParam;
import cn.peyton.plum.mall.pojo.party.MemberLevel;

import java.util.List;

/**
 * <h3> 会员等级 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
public interface MemberLevelService extends IRealizeService<Integer, MemberLevel, MemberLevelParam> {
    /**
     * <h4>根据会员类型查找</h4>
     * @return 会员类型集合
     */
    List<MemberLevelParam> findByDownList();

}
