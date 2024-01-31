package cn.peyton.plum.mall.mapper.product;

import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.mall.DO.ProductDo;
import cn.peyton.plum.mall.dto.ProductDto;
import cn.peyton.plum.mall.pojo.product.ShopProduct;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;
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
     * <h4>批量彻底 删除商品</h4>
     * @param ids 商品Id 集合
     * @return 受影响的行数 > 0 成功
     */
    int destroy(List<Long> ids);

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
     * <h4>根据 分类Id 查找 对象</h4>
     * @param categoryId 分类Id
     * @return
     */
    List<ShopProduct> selectByIdAndJoin(Integer categoryId);



    /**
     * <h4>根据 Id 查找 商品对象</h4>
     * <pre>
     *     `id`,`cover`,`title`,`info`,`keyword`,`stock`,`unit_title`,`price`,`vip_price`,`min_price`,
     *     `ot_price`,`cost_price`,`is_show`,`is_check`,`seq`,`operate`
     * </pre>
     * @param id 主键Id
     * @return 商品对象
     */
    ShopProduct selectSimpleById(Long id);
    /**
     * <h4>根据 Id 查找 商品对象</h4>
     * <pre>
     *     `id`,`cover`,`title`,`info`,`keyword`,`stock`,`unit_name`
     * </pre>
     * @param id 主键Id
     * @return 商品对象
     */
    ShopProduct selectForeignKeyById(Long id);

    /**
     * <h4>android分页查找</h4>
     * @param page 分页对象
     * @param type 类型 {推荐 is_good, 热门 is_hot, 新品 is_new}
     * @return 对象集合
     */
    List<ShopProduct> selectAndroidByList(PageQuery page,String type);

    /**
     * <h4>热门推荐</h4>
     * @param id 商品Id
     * @return
     */
    List<ShopProduct> selectForeignKeyByList(Long id);

    /**
     * <h4>多条件查找{android}</h4>
     * @param product 商品条件对象
     * @param page 分页对象
     * @return 集合
     */
    List<ShopProduct> selectAndroidByMulti(@Param("product") ProductDto product, @Param("page") PageQuery page);

    /**
     * <h4>批量更新销售量</h4>
     * @param products 商品对象集合
     * @return 受影响行数 > 0 成功
     */
    int batchUpdateSaleCount(List<ProductDo> products);
    // ==================================== 注解方式 ==================================== //

    /**
     * <h4>根据Id 查找 操作信息</h4>
     * @param id 商品Id
     * @return 操作信息
     */
    @Select("select operate from tb_shop_product where id =#{id}")
    String selectByOperate(Long id);

    /**
     * <h4>判断商品是否存在</h4>
     * @param id 商品Id
     * @return 存在 > 0
     */
    @Select("select count(id) from tb_shop_product where id = #{id} and is_del = 1")
    int isProduct(Long id);

    /**
     * <h4>更新操作信息</h4>
     * <pre>
     *     操作提示 默认0,0,0[规格|spec, 轮播图|slideshow, 详情|info],0 表示 未操作 1 表示操作过
     * </pre>
     * @param id 主键
     * @param operate 操作字段
     * @return 受影响的行数 > 0 成功
     */
    @Update("update tb_shop_product set operate = #{operate}  where `id`= #{id} and is_del = 1")
    int updateOperate(Long id, String operate);

    /**
     * <h4>更新规格与操作、信息</h4>
     * <pre>
     *     操作提示 默认0,0,0[规格|spec, 轮播图|slideshow, 详情|info],0 表示 未操作 1 表示操作过
     * </pre>
     * @param id 主键
     * @param operate 操作字段
     * @param specType 规格类型 0 单规格 1 多规格
     * @param skus 规格对象集合转成的字符串[规格:[规格值,规格值...],规格:[规格值,规格值...]...]
     * @return 受影响的行数 > 0 成功
     */
    int updateOperateAndSpecType(Long id, String operate,Integer specType, String skus);


    /**
     * <h4>更新规格值</h4>
     * @param id 商品Id
     * @param specType 规格类型 0 单规格 1 多规格
     * @param skus 规格对象集合转成的字符串[规格:[规格值,规格值...],规格:[规格值,规格值...]...]
     * @return 受影响的行数 > 0 成功
     */
    @Update("update tb_shop_product set spec_type = #{specType},skus=#{skus}  where id= #{id} and is_del = 1")
    int updateSpecType(@Param("id") Long id, @Param("specType") Integer specType, @Param("skus") String skus);

    /**
     * <h4>更新审核状态</h4>
     * @param id  商品Id
     * @return 受影响的行数 > 0 成功
     */
    @Update("update tb_shop_product set is_check = 1 where id= #{id} and is_del = 1")
    int updateCheck(@Param("id") Long id);

    /**
     * <h4>更新商品最低价</h4>
     * @param id 商品Id
     * @param minPrice 商品最低价格
     * @param price 商品市场价格
     * @return 受影响的行数 > 0 成功
     */
    @Update("update tb_shop_product set min_price = #{minPrice},price = #{price} where id= #{id} and is_del = 1")
    int updatePrice(Long id, BigDecimal minPrice, BigDecimal price);

    /**
     * <h4>获取商品的好评率</h4>
     * @param id 主键
     * @return
     */
    @Select("select good_rate from tb_shop_product where id=#{id} and is_del=1")
    BigDecimal selectProductByGoodRate(Long id);

    /**
     * <h4>更新商品好评率</h4>
     * @param id 主键
     * @param goodRate 好评率
     * @return
     */
    @Update("update tb_shop_product set good_rate = #{goodRate} where id= #{id} and is_del=1")
    int updatePrductByGoodRate(Long id, BigDecimal goodRate);
}
