package cn.peyton.plum.mall.mapper.product;

import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.mall.pojo.product.ShopOrderItem;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <h3> 订单--项 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public interface ShopOrderItemMapper extends IBaseMapper<Long, ShopOrderItem> {
    /**
     * <h4>根据订单Id 查找 订单项集合</h4>
     * @param orderId 订单Id
     * @return 订单项集合
     */
    List<ShopOrderItem> selectByOrderId(Long orderId);
    /**
     * <h4>根据 商品规格明细Id 查找销售明细</h4>
     * @param psdId 商品规格明细Id
     * @param page 分页对象
     * @param startTime 查找开始时间
     * @param endTime 查找结束时间
     * @return 销售明细对象集合
     */
    List<ShopOrderItem> selectByPsdId(Long psdId, PageQuery page, Integer startTime, Integer endTime);

    /**
     * <h4>根据 商品规格明细Id 查找总销售量</h4>
     * @param psdId     商品规格明细Id
     * @param startTime 查找开始时间
     * @param endTime   查找结束时间
     * @return 总条数
     */
    int countByPsdId(Long psdId, Integer startTime, Integer endTime);

    /**
     * <h4>批量添加</h4>
     * @param items
     * @return
     */
    int batchInsert(List<ShopOrderItem> items);
    // ==================================== new create method ==================================== //

    /**
     * <h>计算销售总和</h>
     * @param psdId  商品规格明细Id
     * @return 总销售数量
     */
    @Select("SELECT count(num) FROM tb_shop_order_item where psd_id = 1 = #{psdId}")
    Integer orderTotal(Long psdId);
}
