package cn.peyton.plum.mall.service.product;

import cn.peyton.plum.core.inf.service.IBaseService;
import cn.peyton.plum.mall.param.product.ShopProductSkuDetailParam;
import cn.peyton.plum.mall.pojo.product.ShopProductSkuDetail;

import java.util.List;

/**
 * <h3> 商品规格详细 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
public interface ShopProductSkuDetailService extends IBaseService<Long, ShopProductSkuDetail, ShopProductSkuDetailParam> {

    /**
     * <h4>根据 仓库Id 查找 </h4>
     * @param warehouseId 会员等级Id
     * @return 返回 true 表示 商品规格详细与仓库有关联
     */
    Boolean isWarehouse(Integer warehouseId);

    /**
     * <h4>批量添加 规格明细对象</h4>
     * @param list 规格明细对象集合
     * @param skus 规格对象集合转成的字符串[规格:[规格值,规格值...],规格:[规格值,规格值...]...]
     * @return 受影响的行数 > 0 成功
     */
    Boolean batchCreate(List<ShopProductSkuDetailParam> list, String skus);

    /**
     * <h4>批量更新 规格明细对象</h4>
     * @param list 规格明细对象集合
     * @param skus 规格对象集合转成的字符串[规格:[规格值,规格值...],规格:[规格值,规格值...]...]
     * @return 受影响的行数 > 0 成功
     */
    Boolean batchEdit(List<ShopProductSkuDetailParam> list, String skus);

    /**
     * <h4>创建 单规格明细对象</h4>
     * <pre>
     *     判断 bool true 更新 || false 新增
     * </pre>
     *
     * @param reocrd 规格明细对象
     * @param skus 规格对象集合转成的字符串[规格:[规格值,规格值...],规格:[规格值,规格值...]...]
     * @param bool true 更新 || false 新增
     * @return true 成功
     */
    Boolean joinCreateAndEdit(ShopProductSkuDetailParam reocrd,String skus, Boolean bool);

    /**
     * <h4>创建 多规格明细对象</h4>
     * <pre>
     *     判断 bool true 更新 || false 新增
     * </pre>
     *
     * @param reocrds 规格明细对象集合
     * @param skus 规格对象集合转成的字符串[规格:[规格值,规格值...],规格:[规格值,规格值...]...]
     * @param bool true 更新 || false 新增
     * @return true 成功
     */
    Boolean joinMultiCrateAndEdit(List<ShopProductSkuDetailParam> reocrds,String skus, Boolean bool);

    /**
     * <h4>根据商品Id 查找商品规格列表</h4>
     * @param productId 商品Id
     * @return 商品规格详细对象集合
     */
    List<ShopProductSkuDetailParam> findByProductId(Long productId);

    /**
     * <h4>更新仓库信息</h4>
     * @param id 商品规格明细Id
     * @param warehouseId 仓库Id
     * @param warehouseExplain 仓库说明
     * @return true 成功
     */
    Boolean updateWarehouse(Long id, Integer warehouseId,String warehouseExplain);
}
