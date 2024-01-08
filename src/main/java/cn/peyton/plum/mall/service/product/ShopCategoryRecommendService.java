package cn.peyton.plum.mall.service.product;

import cn.peyton.plum.core.inf.service.IBaseService;
import cn.peyton.plum.mall.param.product.ShopCategoryRecommendParam;
import cn.peyton.plum.mall.pojo.product.ShopCategoryRecommend;

import java.util.List;

/**
 * <h3> 商品分类推荐 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年12月09日 19:33:21
 * @version 1.0.0
 * </pre>
*/
public interface ShopCategoryRecommendService extends IBaseService<Long, ShopCategoryRecommend, ShopCategoryRecommendParam> {

    /**
     * <h4>根据商品分类Id 查找</h4>
     * @param categoryId 分类Id
     * @return
     */
    ShopCategoryRecommendParam findByCategoryId(Integer categoryId);

    /**
     * <h4>批量插入</h4>
     * @param list  商品分类推荐 对象集合
     * @return 受影响行数 > 0 成功
     */
    Boolean batchCreate(List<ShopCategoryRecommendParam> list);

    /**
     * <h4>删除分类推荐</h4>
     * @param productId 商品主键
     * @param categoryId 分类主键
     * @return true 成功
     */
    Boolean deleteByJoinId(Long productId, Integer categoryId);
}
