package cn.peyton.plum.mall.service.product;

import cn.peyton.plum.core.inf.service.base.IRealizeService;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.PageResult;
import cn.peyton.plum.mall.param.product.ShopOrderItemParam;
import cn.peyton.plum.mall.pojo.product.ShopOrderItem;

/**
 * <h3> 订单--项 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
public interface ShopOrderItemService extends IRealizeService<Long, ShopOrderItem, ShopOrderItemParam> {

    /**
     * <h4>根据 商品规格明细Id 查找销售明细</h4>
     * @param psdId 商品规格明细Id
     * @param page 分页对象
     * @param startTime 查找开始时间
     * @param endTime 查找结束时间
     * @return 入库明细对象集合
     */
    PageResult<ShopOrderItemParam> findByStockId(Long psdId, PageQuery page, Integer startTime, Integer endTime);

}
