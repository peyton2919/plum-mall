package cn.peyton.plum.mall.mapper.product;

import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.base.IDeleteService;
import cn.peyton.plum.mall.pojo.product.ShopCategory;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
public interface ShopCategoryMapper extends IDeleteService<Integer>, IBaseMapper<Integer, ShopCategory> {


    /**
     * <h4>根据商品Id 查找 分类</h4>
     * @param productId 商品Id
     * @return 分类列表
     */
    List<ShopCategory> selectByProductId(Long productId);

    /**
     * <h4>树形查找</h4>
     * @return
     */
    List<ShopCategory> selectByTree();

    /**
     * <h4>自身下拉框使用</h4>
     * <pre>
     *     条件为 pid = 0
     * </pre>
     * @return
     */
    List<ShopCategory> selectByInner();

    /**
     * <h4>外部下拉框使用</h4>
     * @return
     */
    List<ShopCategory> selectByOutside();

    /**
     * <h>随机查找分类</h>
     * @param limit 需要返回的记录数
     * @return 集合
     */
    List<ShopCategory> selectAndroidByRand(int limit);

    // ==================================== 注解方式 ==================================== //
    /**
     * <h4>更新推荐</h4>
     * @param id 主键
     * @param isShow 是否推荐  {1为推荐 0 不推荐}
     * @return 受影响的行数 > 0
     */
    @Update("update tb_shop_category set is_show = #{isShow} where id = #{id} and is_del = 1")
    int updateShow(Integer id, Integer isShow);

    /**
     * <h4>更新排序</h4>
     * @param id 主键
     * @param seq 数值
     * @return 受影响的行数 > 0
     */
    @Update("update tb_shop_category set seq = #{seq} where id = #{id} and is_del = 1")
    int updateSeq(Integer id, Short seq);

    /**
     * <h4>删除时判断是否有子类</h4>
     * @param id 分类Id
     * @return 受影响行数 > 0 表示有关联, 不能删除
     */
    @Select("select count(id) from tb_shop_category where pid = #{id}")
    int isChildren(Integer id);

    /**
     * <h4>删除时判断是否有推荐子类</h4>
     * @param id 分类Id
     * @return 受影响行数 > 0 表示有关联, 不能删除
     */
    @Select("select count(id) from tb_shop_category_recommend where category_id = #{id}")
    int isRecommend(Integer id);
}
