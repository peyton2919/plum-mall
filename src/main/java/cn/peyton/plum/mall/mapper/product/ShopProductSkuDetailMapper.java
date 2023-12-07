package cn.peyton.plum.mall.mapper.product;

import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.mall.pojo.product.ShopProductSkuDetail;

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
     * <h4>根据商品Id 查找商品规格列表</h4>
     * @param productId
     * @return
     */
    List<ShopProductSkuDetail> selectByProductId(Long productId);

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

    // ==================================== new create method ==================================== //


}
