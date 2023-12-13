package cn.peyton.plum.mall.mapper.product;


import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.mall.pojo.product.ShopCategoryRecommend;

import java.util.List;

/**
 * <h3> 商品分类推荐 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年12月09日 20:13:39
 * @version 1.0.0
 * </pre>
*/
public interface ShopCategoryRecommendMapper extends IBaseMapper<Long, ShopCategoryRecommend> {

    /**
     * <h4>根据商品分类Id 查找</h4>
     * @param categoryId 分类Id
     * @return
     */
    ShopCategoryRecommend selectByCategoryId(Integer categoryId);

    /**
     * <h4>批量插入</h4>
     * @param list  商品分类推荐 对象集合
     * @return 受影响行数 > 0 成功
     */
    int batchInsert(List<ShopCategoryRecommend> list);
}
