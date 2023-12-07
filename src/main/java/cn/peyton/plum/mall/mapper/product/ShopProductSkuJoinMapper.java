package cn.peyton.plum.mall.mapper.product;

import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.mall.pojo.product.ShopProductSkuJoin;
import org.apache.ibatis.annotations.Param;

/**
 * <h3> 商品规格联系{用来关联商品与规格;辅助作用} Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年12月01日 15:52:45
 * @version 1.0.0
 * </pre>
*/
public interface ShopProductSkuJoinMapper extends IBaseMapper<Long, ShopProductSkuJoin> {

    /**
     * <h4>根据 商品Id 和规格Id 删除</h4>
     * @param productId 商品Id
     * @param skuId 规格Id
     * @return 成功 >0
     */
    int deleteByProductIdAndSkuId(@Param("productId") Long productId, @Param("skuId") Long skuId);
}
