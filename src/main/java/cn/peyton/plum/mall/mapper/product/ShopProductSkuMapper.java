package cn.peyton.plum.mall.mapper.product;

import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.mall.pojo.product.ShopProductSku;

import java.util.List;

/**
 * <h3> 商品规格关联 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年12月06日 20:54:33
 * @version 1.0.0
 * </pre>
*/
public interface ShopProductSkuMapper extends IBaseMapper<Long, ShopProductSku> {

    /**
     * <h4>判断是否存在 skuValue </h4>
     * @param shopProductSku 对象
     * @return 存在 > 0
     */
    int isExisted(ShopProductSku shopProductSku);

    /**
     * <h4>批量添加</h4>
     * @param list 明细-规格-规格值 集合
     * @return 存在 > 0
     */
    int batchInsert(List<ShopProductSku> list);
}
