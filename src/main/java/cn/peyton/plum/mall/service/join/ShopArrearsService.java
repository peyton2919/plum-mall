package cn.peyton.plum.mall.service.join;

import cn.peyton.plum.core.inf.service.base.IRealizeService;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.PageResult;
import cn.peyton.plum.mall.param.join.ShopArrearsParam;
import cn.peyton.plum.mall.pojo.join.ShopArrears;
import cn.peyton.plum.mall.vo.ArrearVo;

import java.util.List;

/**
 * <h3> 欠款信息 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年02月06日 22:33:31
 * @version 1.0.0
 * </pre>
*/
public interface ShopArrearsService extends IRealizeService<Long, ShopArrears, ShopArrearsParam> {

    /**
     * <h4>多条件查找</h4>
     * @param vo 欠款对象
     * @param page 分页
     * @return 集合
     */
    PageResult<ShopArrearsParam> findMulti(ArrearVo vo,PageQuery page);

    /**
     * <h4>多条件联合查找</h4>
     * <pre>
     *     memberId,oid,status,money,create_time
     * </pre>
     * @param vo 欠款条件对象
     * @param page 分页对象
     * @return 集合
     */
    PageResult<ShopArrearsParam> findJoin(ArrearVo vo, PageQuery page);

    /**
     * <h4>新增欠款</h4>
     * @param param 欠款明细对象
     * @return
     */
    boolean joinCreate(ShopArrearsParam param);

    /**
     * <h4>根据会员Id 查找欠款</h4>
     * @param memberId 会员Id
     * @param status 状态 0 未还 1 还清
     * @return 集合
     */
    List<ShopArrearsParam> findByMemberId(long memberId, Integer status);


}
