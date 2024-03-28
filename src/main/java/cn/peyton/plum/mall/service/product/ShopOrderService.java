package cn.peyton.plum.mall.service.product;

import cn.peyton.plum.core.inf.service.base.IRealizeService;
import cn.peyton.plum.mall.param.product.ShopOrderParam;
import cn.peyton.plum.mall.pojo.product.ShopOrder;

import java.util.List;

/**
 * <h3> 订单 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
public interface ShopOrderService extends IRealizeService<Long, ShopOrder, ShopOrderParam> {

    /**
     * <h4>批量删除 {更新 is_del =0}</h4>
     * @param list Id集合
     * @return 受影响的行数 > 0 成功
     */
    Boolean updateIsDel(List<Long> list);

    /**
     * <h4>根据 条件查找</h4>
     * <pre>
     *     nopay: paid = 0;
     *     noship: status = 0;
     *     shiped: status = 1;
     *     received: status = 2;
     *     finish: status = 3;
     *     closed: status = 9;
     *     refunding: status = -1;
     * </pre>
     * @param record 对象
     * @param start 开始时间 int 类型
     * @param end 结束时间 int 类型
     * @return
     */
    List<ShopOrderParam> findSimpleByCondition(ShopOrderParam record, Integer start, Integer end);

    /**
     * <h4>创建订单</h4>
     * @param param 订单对象
     * @return true 成功
     */
    ShopOrderParam create(ShopOrderParam param);
}
