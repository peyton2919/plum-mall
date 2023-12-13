package cn.peyton.plum.mall.service.product;

import cn.peyton.plum.core.inf.service.IBaseService;
import cn.peyton.plum.mall.param.product.ShopCategoryParam;
import cn.peyton.plum.mall.pojo.product.ShopCategory;

import java.util.List;

/**
 * <h3> 商品分类 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
public interface ShopCategoryService extends IBaseService<Integer, ShopCategory, ShopCategoryParam> {
    /**
     * <h4>下拉框查找</h4>
     * @return
     */
    List<ShopCategoryParam> findByOutside();

    /**
     * <h4>下拉框查找</h4>
     * @return
     */
    List<ShopCategoryParam> findByInner();

    /**
     * <h4>更新推荐</h4>
     * @param id 主键
     * @param isShow 是否推荐  {1为推荐 0 不推荐}
     * @return 成功 true
     */
    Boolean updateShow(Integer id, Integer isShow);

    /**
     * <h4>删除 更新 is_del = 0 </h4>
     * @param id 主键
     * @return 受影响的行数 > 0
     */
    Boolean updateDelete(Integer id);

    /**
     * <h4>菜单树型查找</h4>
     * @return
     */
    List<ShopCategoryParam> findByTree();

}
