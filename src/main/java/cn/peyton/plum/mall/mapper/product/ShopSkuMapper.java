package cn.peyton.plum.mall.mapper.product;

import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.mall.pojo.product.ShopSku;

import java.util.List;

/**
 * <h3> 商品规格 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public interface ShopSkuMapper extends IBaseMapper<Long, ShopSku> {


    /**
     * <h4>根据 商品Id 查找 </h4>
     * @param productId
     * @return
     */
    List<ShopSku> selectByProductId(Long productId);

    /**
     * <h4>根据名称查找</h4>
     * @param name
     * @return
     */
    ShopSku selectByName(String name);

    /**
     * <h4>批量更新排序值</h4>
     * @param skus
     * @return
     */
    int batchUpdate(List<ShopSku> skus);
    // ==================================== new create method ==================================== //


}
