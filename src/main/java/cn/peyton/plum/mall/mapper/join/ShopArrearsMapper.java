package cn.peyton.plum.mall.mapper.join;

import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.mall.DO.ArrearDo;
import cn.peyton.plum.mall.pojo.join.ShopArrears;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;

/**
 * <h3> 欠款信息 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年02月06日 22:33:31
 * @version 1.0.0
 * </pre>
*/
public interface ShopArrearsMapper extends IBaseMapper<Long, ShopArrears> {

    /**
     * <h4>根据会员Id 计算欠款金额</h4>
     * @param memberId 会员Id
     * @param status 欠款状态 默认 0 未清 1 已清
     * @return 当前客户欠款总额
     */
    @Select("SELECT SUM(money) FROM tb_shop_arrears where member_id=#{memberId} and status= #{status}")
    BigDecimal calcMoney(Long memberId, Integer status);

    /**
     * <h4>批量更新欠款信息</h4>
     * @param ids 欠款Id 集合
     * @param repId 还款Id
     * @return 受影响行数
     */
    int batchUpdate(List<Long> ids, Long repId);

    /**
     * <h4>根据会员Id 查找欠款</h4>
     * @param memberId 会员Id
     * @param status 状态 0 未还 1 还清
     * @return 集合
     */
    List<ShopArrears> selectByMemberId(long memberId,Integer status);

    /**
     * <h4>多条件查找</h4>
     * @param arrear 欠款对象
     * @param page 分页
     * @return 集合
     */
    List<ShopArrears> selectMulti(ArrearDo arrear,PageQuery page);
    /**
     * <h4>条件查找总记录数</h4>
     * @param arrear 欠款对象
     * @return 记录数
     */
    int countMulti(ArrearDo arrear);

    /**
     * <h4>多条件联合查找</h4>
     * @param arrear 欠款条件对象
     * @param page 分页对象
     * @return 集合
     */
    List<ShopArrears> selectByJoin(ArrearDo arrear,PageQuery page);

    /**
     * <h4>多条件联合查找 总记录数</h4>
     * @param arrear 欠款条件对象
     * @return 总记录数
     */
    int countJoin(ArrearDo arrear);
}
