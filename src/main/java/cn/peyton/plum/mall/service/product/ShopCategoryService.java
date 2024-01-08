package cn.peyton.plum.mall.service.product;

import cn.peyton.plum.core.inf.service.IBaseService;
import cn.peyton.plum.core.inf.service.IDeleteService;
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
public interface ShopCategoryService extends IDeleteService<Integer>, IBaseService<Integer, ShopCategory, ShopCategoryParam> {

    /**
     * <h4>删除时判断是否有子类</h4>
     * @param id 分类Id
     * @return true 表示有关联, 不能删除
     */
    Boolean isChildren(Integer id);

    /**
     * <h4>删除时判断是否有推荐子类</h4>
     * @param id 分类Id
     * @return true 表示有关联, 不能删除
     */
    Boolean isRecommend(Integer id);

    /**
     * <h4>更新排序</h4>
     * @param id 主键
     * @param seq 数值
     * @return true 成功
     */
    Boolean updateSeq(Integer id, Short seq);

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
     * <h4>菜单树型查找</h4>
     * @return
     */
    List<ShopCategoryParam> findByTree();

}
