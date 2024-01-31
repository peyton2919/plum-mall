package cn.peyton.plum.mall.mapper.product;

import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.mall.pojo.product.ShopProductSkuDetail;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <h3> 商品规格详细 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public interface ShopProductSkuDetailMapper extends IBaseMapper<Long, ShopProductSkuDetail> {

    /**
     * <h4>批量添加 规格明细对象</h4>
     * @param list 规格明细对象集合
     * @return 受影响的行数 > 0 成功
     */
    int batchInsert(List<ShopProductSkuDetail> list);
    /**
     * <h4>批量更新 规格明细对象</h4>
     * @param list 规格明细对象集合
     * @return 受影响的行数 > 0 成功
     */
    int batchUpdate(List<ShopProductSkuDetail> list);

    /**
     * <h4>根据Id 简单查找对象</h4>
     * <pre>
     *     查找对象:
     *     `id`,`product_id`,`skus`,`stock`,`min_stock`,`sales`,`cover`,`unique_code`,`bar_code`,`integral`,`min_price`,`price`,
     * 		    `vip_price`,`ot_price`,`cost_price`,`weight`,`volume`
     * </pre>
     * @param id 主键Id
     * @return 商品规格详细对象
     */
    ShopProductSkuDetail selectSimpleById(Long id);

    /**
     * <h4>根据商品Id 查找商品规格列表{后端}</h4>
     * @param productId 商品Id
     * @return 商品规格详细对象集合
     */
    List<ShopProductSkuDetail> selectByProductId(Long productId);

    /**
     * <h4>更新仓库信息</h4>
     * @param id 商品规格明细Id
     * @param warehouseId 仓库Id
     * @param warehouseExplain 仓库说明
     * @return 受影响行数 > 0 成功
     */
    int updateWarehouse(Long id, Integer warehouseId,String warehouseExplain);

    // ==================================== 注解方式 ==================================== //

    /**
     * <h4>根据 仓库Id 查找 </h4>
     * @param warehouseId 会员等级Id
     * @return 返回 > 0 表示 商品规格详细与仓库有关联
     */
    @Select("select count(id) from tb_shop_product_sku_detail where warehouse_id = #{warehouseId}")
    int isWarehouse(Integer warehouseId);

    /**
     * <h4>更新库存Id</h4>
     * @param id
     * @param stockId 库存Id
     * @return 受影响行数 > 0 成功
     */
    @Update("update tb_shop_product_sku_detail set stock_id = #{stockId} where id = #{id}")
    int updateStockId(Long id, Long stockId);

    /**
     * <h4>判断Id 是否存在</h4>
     * @param id 商品规格明细Id
     * @return 记录数 > 0 表示 存在
     */
    @Select("select count(id) from tb_shop_product_sku_detail where id = #{id}")
    int existId(Long id);
}
