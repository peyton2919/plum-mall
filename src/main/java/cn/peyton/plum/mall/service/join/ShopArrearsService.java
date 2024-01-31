package cn.peyton.plum.mall.service.join;

import cn.peyton.plum.core.inf.service.IBaseService;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.PageResult;
import cn.peyton.plum.mall.param.join.ShopArrearsParam;
import cn.peyton.plum.mall.pojo.join.ShopArrears;

import java.math.BigDecimal;
import java.util.List;

/**
 * <h3> 欠款信息 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年01月16日 21:12:27
 * @version 1.0.0
 * </pre>
*/
public interface ShopArrearsService extends IBaseService<Long, ShopArrears, ShopArrearsParam> {

    /**
     * <h4>多条件查找</h4>
     * @param memberId 客户Id
     * @param status 状态 0 未清 1 已清
     * @param repayType 还款方式: 0 微信 1 支付宝 2 转账 3 现金 4 其他
     * @param debt 欠款金额
     * @param actualPayment 实际付款金额
     * @param page 分页
     * @param timeInterval 查找时段{今天 7天 1个月 6个月 1年}
     * @param mode 查找方向 {欠款时间create_time | 还款时间update_time}
     * @return 集合
     */
    PageResult<ShopArrearsParam> findMulti(Long memberId, Integer status, Integer repayType, BigDecimal debt,
               BigDecimal actualPayment, PageQuery page, String timeInterval, String mode);

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
