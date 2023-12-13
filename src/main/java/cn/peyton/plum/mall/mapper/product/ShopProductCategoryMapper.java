package cn.peyton.plum.mall.mapper.product;

import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.mall.pojo.product.ShopProductCategory;

import java.util.List;

/**
 * <h3> 商品与商品分类关联 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public interface ShopProductCategoryMapper extends IBaseMapper<Long, ShopProductCategory> {
    /**
     * <h4>批量添加</h4>
     * @param list  商品与商品分类关联对象集合
     * @return 受影响的行数 > 0 成功
     */
    int batchInsert(List<ShopProductCategory> list);

    /**
     * <h4>批量更新</h4>
     * @param list 商品与商品分类关联对象集合
     * @return 受影响的行数 > 0 成功
     */
    int batchUpdate(List<ShopProductCategory> list);

    /**
     * <h4>根据商品Id 删除</h4>
     * @param productId 商品Id
     * @return 受影响的行数 > 0 成功
     */
    int deleteByProductId(Long productId);

    /**
     * <h4>根据 商品Id 查找对象集合</h4>
     * @param productId 商品Id
     * @return 商品与商品分类关联对象集合
     */
    List<ShopProductCategory> selectByProductId(Long productId);
    // ==================================== new create method ==================================== //


}
