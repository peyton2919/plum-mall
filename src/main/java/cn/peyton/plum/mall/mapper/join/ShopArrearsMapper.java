package cn.peyton.plum.mall.mapper.join;


import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.mall.pojo.join.ShopArrears;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * <h3> 欠款信息 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年01月16日 21:12:27
 * @version 1.0.0
 * </pre>
*/
public interface ShopArrearsMapper extends IBaseMapper<Long, ShopArrears> {

    /**
     * <h4>多条件查找</h4>
     * @param memberId 客户Id
     * @param status 状态 0 未清 1 已清
     * @param repayType 还款方式: 0 微信 1 支付宝 2 转账 3 现金 4 其他
     * @param debt 欠款金额
     * @param actualPayment 实际付款金额
     * @param page 分页
     * @param timeInterval 查找时段{ 今天(1天) 7天 1个月 6个月 1年 }
     * @param mode 查找方向 {欠款时间create_time | 还款时间update_time}
     * @return 集合
     */
    List<ShopArrears> selectMulti(Long memberId, Integer status,Integer repayType, BigDecimal debt, BigDecimal actualPayment, PageQuery page, String timeInterval, String mode);

    /**
     * <h4>根据会员Id 查找欠款</h4>
     * @param memberId 会员Id
     * @param status 状态 0 未还 1 还清
     * @return 集合
     */
    List<ShopArrears> selectByMemberId(long memberId,Integer status);

    /**
     * <h4>条件查找总记录数</h4>
     * @param memberId 客户Id
     * @param status 状态 0 未清 1 已清
     * @param repayType 还款方式: 0 微信 1 支付宝 2 转账 3 现金 4 其他
     * @param debt 欠款金额
     * @param actualPayment 实际付款金额
     * @param page 分页
     * @param timeInterval 查找时段{ 今天(1天) 7天 1个月 6个月 1年 }
     * @param mode 查找方向 {欠款时间create_time | 还款时间update_time}
     * @return 记录数
     */
    int countMulti(Long memberId, Integer status,Integer repayType, BigDecimal debt, BigDecimal actualPayment, PageQuery page, String timeInterval, String mode);

    @Select("select sum(debt) as total,sum(repay_debt) as payCount from tb_shop_arrears where member_id=#{memberId} and status = 0")
    Map<String, BigDecimal> calcArrears(Long memberId);

    public interface Props {
        /**  今天 */
        String TODAY = "today";
        /** 7天  */
        String WEEK = "week";
        /** 1个月  */
        String MONTH = "month";
        /** 3个月  */
        String QUARTER = "quarter";
        /** 6个月  */
        String HALF_YEAR = "half_year";
        /** 1年 */
        String YEAR = "year";
        /** 欠款时间 */
        String CREATE_TIME = "create_time";
        /** 还款时间  */
        String UPDATE_TIME = "update_time";
    }
}
