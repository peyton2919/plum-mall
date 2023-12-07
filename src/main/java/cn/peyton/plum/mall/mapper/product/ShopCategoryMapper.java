package cn.peyton.plum.mall.mapper.product;

import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.mall.pojo.product.ShopCategory;

import java.util.List;

/**
 * <h3> 商品分类 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public interface ShopCategoryMapper extends IBaseMapper<Integer, ShopCategory> {

    /**
     * <h4>根据商品Id 查找 分类</h4>
     * @param productId 商品Id
     * @return 分类列表
     */
    List<ShopCategory> selectByProductId(Long productId);

    /**
     * <h4>更新推荐</h4>
     * @param id 主键
     * @param isShow 是否推荐  {1为推荐 0 不推荐}
     * @return 受影响的行数 > 0
     */
    int updateShow(Integer id, Integer isShow);

    /**
     * <h4>删除 更新 is_del = 0 </h4>
     * @param id 主键
     * @return 受影响的行数 > 0
     */
    int updateDelete(Integer id);

    // ==================================== new create method ==================================== //


}
