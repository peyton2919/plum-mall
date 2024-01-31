package cn.peyton.plum.mall.service.product;

import cn.peyton.plum.core.inf.service.IBaseService;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.mall.dto.ProductDto;
import cn.peyton.plum.mall.param.product.ShopProductParam;
import cn.peyton.plum.mall.pojo.product.ShopProduct;

import java.math.BigDecimal;
import java.util.List;

/**
 * <h3> 商品信息 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
public interface ShopProductService extends IBaseService<Long, ShopProduct, ShopProductParam> {


    /**
     * <h4>根据 分类Id 查找 对象</h4>
     * @param categoryId 分类Id
     * @return
     */
    List<ShopProductParam> findByIdAndJoin(Integer categoryId);

    /**
     * <h4>批量删除商品{更新is_del为0}</h4>
     * @param ids 商品Id 集合
     * @return true 成功
     */
    Boolean batchDelete(List<Long> ids);

    /**
     * <h4>批量彻底 删除商品</h4>
     * @param ids 商品Id 集合
     * @return true 成功
     */
    Boolean destroy(List<Long> ids);

    /**
     * <h4>批量恢复商品{更新is_del为1}</h4>
     * @param ids 商品Id 集合
     * @return 受影响的行数 > 0 成功
     */
    Boolean batchRestore(List<Long> ids);

    /**
     * <h4>批量上|下架商品{上架 1 | 下架 0}</h4>
     * @param ids 商品Id 集合
     * @param isShow 上架 1 | 下架 0
     * @return 受影响的行数 > 0 成功
     */
    Boolean batchIsShow(List<Long> ids,Integer isShow);

    /**
     * <h4>获取轮播图</h4>
     * @param id 商品Id
     * @return
     */
    ShopProductParam selectBySlideshow(Long id);

    /**
     * <h4>获取详情</h4>
     * @param id 商品Id
     * @return
     */
    ShopProductParam selectByExplain(Long id);

    /**
     * <h4>判断商品是否存在</h4>
     * @param id 商品Id
     * @return 存在 > 0
     */
    Boolean isProduct(Long id);

    /**
     * <h4>更新规格值</h4>
     * @param id 商品Id
     * @param specType 规格类型 0 单规格 1 多规格
     * @param skus 规格对象集合转成的字符串[规格:[规格值,规格值...],规格:[规格值,规格值...]...]
     * @return
     */
    Boolean updateSpecType(Long id, Integer specType,String skus);

    /**
     * <h4>更新 商品详情</h4>
     * @param record 商品对象
     * @return 成功 true
     */
    Boolean updateExplain(ShopProductParam record);

    /**
     * <h4>添加、并添加更新分类</h4>
     * @param record 商品对象
     * @return 成功 true
     */
    Boolean createAndBatchCategories(ShopProductParam record);
    /**
     * <h4>更新、并批量更新分类</h4>
     * @param record 商品对象
     * @return 成功 true
     */
    Boolean updateAndBatchCategories(ShopProductParam record);

    /**
     * <h4>根据商品Id 查找 操作信息</h4>
     * @param id 商品Id
     * @return 操作信息
     */
    String findByOperate(Long id);

    /**
     * <h4>更新操作信息</h4>
     * @param id 商品Id
     * @param operate 操作信息
     * @return true 成功
     */
    Boolean updateOperate(Long id, String operate);

    /**
     * <h4>更新审核状态</h4>
     * @param id  商品Id
     * @return true 成功
     */
    Boolean updateCheck(Long id);

    /**
     * <h4>更新商品最低价</h4>
     * @param id 商品Id
     * @param minPrice 商品最低价格
     * @param price 商品市场价格
     * @return true 成功
     */
    Boolean updatePrice(Long id, BigDecimal minPrice, BigDecimal price);

    /***  ------------- android ------------   */

    /**
     * <h4>android分页查找</h4>
     * @param page 分页对象
     * @param type 类型 {推荐 is_good, 热门 is_hot, 新品 is_new}
     * @return 对象集合
     */
    List<ShopProductParam> findAndroidByList(PageQuery page, String type);

    /**
     * <h4>获取商品的好评率</h4>
     * @param id 主键
     * @return
     */
    BigDecimal findProductByGoodRate(Long id);

    /**
     * <h4>多条件查找{android}</h4>
     * @param product 商品条件对t
     * @param page 分页对象
     * @return 集合
     */
    List<ShopProductParam> findAndroidByMulti(ProductDto product, PageQuery page);
}
