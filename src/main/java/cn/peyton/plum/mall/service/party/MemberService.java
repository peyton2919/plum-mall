package cn.peyton.plum.mall.service.party;

import cn.peyton.plum.core.inf.service.base.*;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.PageResult;
import cn.peyton.plum.mall.param.party.MemberParam;
import cn.peyton.plum.mall.pojo.party.Member;

/**
 * <h3> 会员 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
public interface MemberService extends IStatusService<Long>, IDeleteService<Long>, IDownListService<MemberParam>,
        IUserService<MemberParam>, IRealizeService<Long, Member, MemberParam> {

    /**
     * <h4>根据 会员等级Id 查找 </h4>
     * @param levelId 会员等级Id
     * @return 返回 > 0 表示 会员与等级有关联
     */
    Boolean isMemberLevel(Integer levelId);

    /**
     * <h4>条件 查找 对象集合</h4>
     * @param record 条件对象
     * @param page 分页对象
     * @return 对象集合
     */
    PageResult<?> search(MemberParam record, PageQuery page);

}
