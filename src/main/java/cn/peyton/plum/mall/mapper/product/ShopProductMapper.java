package cn.peyton.plum.mall.mapper.product;

import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.mall.pojo.product.ShopProduct;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <h3> 商品信息 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public interface ShopProductMapper extends IBaseMapper<Long, ShopProduct> {

    /**
     * <h4>批量删除商品{更新is_del为0}</h4>
     * @param ids 商品Id 集合
     * @return 受影响的行数 > 0 成功
     */
    int batchDelete(List<Long> ids);

    /**
     * <h4>批量恢复商品{更新is_del为1}</h4>
     * @param ids 商品Id 集合
     * @return 受影响的行数 > 0 成功
     */
    int batchRestore(List<Long> ids);

    /**
     * <h4>批量上|下架商品{上架 1 | 下架 0}</h4>
     * @param ids 商品Id 集合
     * @param isShow 上架 1 | 下架 0
     * @return 受影响的行数 > 0 成功
     */
    int batchIsShow(List<Long> ids,Integer isShow);

    /**
     * <h4>获取轮播图</h4>
     * @param id 商品Id
     * @return
     */
    ShopProduct selectBySlideshow(Long id);

    /**
     * <h4>获取详情</h4>
     * @param id 商品Id
     * @return
     */
    ShopProduct selectByExplain(Long id);

    /**
     * <h4>判断商品是否存在</h4>
     * @param id 商品Id
     * @return 存在 > 0
     */
    int isProduct(Long id);

    /**
     * <h4>更新规格值</h4>
     * @param id 商品Id
     * @param specType 规格类型 0 单规格 1 多规格
     * @param skus 规格对象集合转成的字符串[规格:[规格值,规格值...],规格:[规格值,规格值...]...]
     * @return
     */
    int updateSpecType(@Param("id") Long id, @Param("specType") Integer specType,@Param("skus") String skus);

    /**
     * <h4>根据 分类Id 查找 对象</h4>
     * @param categoryId 分类Id
     * @return
     */
    List<ShopProduct> selectByIdAndJoin(Integer categoryId);

    /**
     * <h4>更新操作信息</h4>
     * <pre>
     *     操作提示 默认0,0,0[规格|spec, 轮播图|slideshow, 详情|info],0 表示 未操作 1 表示操作过
     * </pre>
     * @param id 主键
     * @param operate 操作字段
     * @return 受影响的行数 > 0 成功
     */
    int updateOperate(Long id, String operate);

    /**
     * <h4>根据Id 查找 操作信息</h4>
     * @param id 商品Id
     * @return 操作信息
     */
    @Select("select operate from tb_shop_product where id =#{id}")
    String selectByOperate(Long id);

    /**
     * <h4>根据 Id 查找 商品对象</h4>
     * <pre>
     *     `id`,`cover`,`name`,`info`,`keyword`,`stock`,`unit_name`,`price`,`vip_price`,`min_price`,
     *     `ot_price`,`cost_price`,`is_show`,`is_check`,`seq`,`operate`
     * </pre>
     * @param id 主键Id
     * @return 商品对象
     */
    ShopProduct selectSimpleById(Long id);
    // ==================================== new create method ==================================== //


}
