package cn.peyton.plum.mall.mapper.join;

import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.mall.DO.ArrearDo;
import cn.peyton.plum.mall.pojo.join.ShopRepayment;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;
import java.util.List;

/**
 * <h3> 还款信息 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年02月06日 22:33:46
 * @version 1.0.0
 * </pre>
*/
public interface ShopRepaymentMapper extends IBaseMapper<Long, ShopRepayment> {

    /**
     * <h4>批量更新还款信息</h4>
     * @param ids 欠款Id 集合
     * @return 受影响行数
     */
    int batchUpdate(List<Long> ids);

    /**
     * <h4>根据欠款Id 查找对象</h4>
     * @param arrearId 欠款Id
     * @return 集合
     */
    List<ShopRepayment> selectByArrearId(Long arrearId);

    /**
     * <h4>根据会员Id 查找欠款</h4>
     * @param memberId 会员Id
     * @param status 状态 0 未还 1 还清
     * @return 集合
     */
    List<ShopRepayment> selectByMemberId(long memberId, Integer status);

    /**
     * <h4>根据会员Id 计算还款金额</h4>
     * @param memberId 会员Id
     * @param status 付款状态 默认 0 未清 1 已清
     * @return 当前用户还款总额
     */
    @Select("SELECT SUM(money) FROM tb_shop_repayment where member_id=#{memberId} and status= #{status}")
    BigDecimal calcMoney(Long memberId, Integer status);

    /**
     * <h4>计算欠款-还款是否等于0</h4>
     * @param arrearId 欠款Id
     * @return 余额
     */
    @Select("SELECT sa.money-SUM(sr.money) from tb_shop_arrears sa ,tb_shop_repayment sr where sa.id = sr.arrear_id and sa.id=#{arrearId}")
    BigDecimal existStatus(Long arrearId);

    /**
     * <h4>更新还款状态</h4>
     * @param arrearId
     * @return 受影响的行数 > 0 成功
     */
    @Update("UPDATE tb_shop_repayment set `status`=1 where arrear_id=#{arrearId}")
    int upRepaymentStatus(Long arrearId);

    /**
     * <h4>更新JSON字符串</h4>
     * @param id 还款Id
     * @param str JSON字符串
     * @return 受影响的行数 > 0 成功
     */
    @Update("update tb_shop_repayment set obj =#{str} where id=#{id}")
    int upObj(Long id, String str);

    /**
     * <h4>多条件查找</h4>
     * @param arrear 还款对象
     * @param page 分页
     * @return 集合
     */
    List<ShopRepayment> selectMulti(ArrearDo arrear, PageQuery page);

    /**
     * <h4>条件查找总记录数</h4>
     * @param arrear 还款对象
     * @return 记录数
     */
    int countMulti(ArrearDo arrear);

    /**
     * <h4>多条件联合查找</h4>
     * @param arrear 欠款条件对象
     * @param page 分页对象
     * @return 集合
     */
    List<ShopRepayment> selectByJoin(ArrearDo arrear, PageQuery page);

    /**
     * <h4>多条件联合查找 总记录数</h4>
     * @param arrear 欠款条件对象
     * @return 总记录数
     */
    int countJoin(ArrearDo arrear);

}
