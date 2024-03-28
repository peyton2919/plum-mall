package cn.peyton.plum.mall.service.join;

import cn.peyton.plum.core.inf.service.base.IRealizeService;
import cn.peyton.plum.mall.param.join.ShopArrearPoolParam;
import cn.peyton.plum.mall.pojo.join.ShopArrearPool;

import java.math.BigDecimal;

/**
 * <h3> 欠款汇总 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年01月30日 11:33:43
 * @version 1.0.0
 * </pre>
*/
public interface ShopArrearPoolService extends IRealizeService<Long, ShopArrearPool, ShopArrearPoolParam> {


    /**
     * <h4>计算总欠款余额</h4>
     * @return 总欠金额
     */
    BigDecimal calcBalance();
}
