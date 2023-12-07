package cn.peyton.plum.mall.mapper.product;

import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.mall.pojo.product.ShopProduct;
import org.apache.ibatis.annotations.Param;

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

    // ==================================== new create method ==================================== //


}
