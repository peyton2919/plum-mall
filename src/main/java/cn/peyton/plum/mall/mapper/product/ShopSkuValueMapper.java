package cn.peyton.plum.mall.mapper.product;

import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.mall.pojo.product.ShopSkuValue;

import java.util.List;

/**
 * <h3> 商品规格 值 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public interface ShopSkuValueMapper extends IBaseMapper<Long, ShopSkuValue> {

    /**
     * <h4>根据sku id 查找</h4>
     *
     * @param skuId
     * @return
     */
    List<ShopSkuValue> selectByShopSkuId(Long skuId);

    /**
     * <h4>根据 规格Id 判断 有没有存在规格值</h4>
     * @param skuId 规格Id
     * @return 存在 > 0
     */
    int isShopSku(Long skuId);

    /**
     * <h4>根据 规格Id 和 规格值 查找 规格值对象</h4>
     * @param skuId 规格Id
     * @param skuValue 规格值
     * @return 没找到为空,否则 为 ShopSkuValue对象
     */
    ShopSkuValue selectBySkuIdAndValue(Long skuId,String skuValue);

    /**
     * <h4>批量添加</h4>
     * @param list 规格值对象集合
     * @return 返回受影响的行数 > 0 成功
     */
    int batchInsert(List<ShopSkuValue> list);
    // ==================================== new create method ==================================== //


}
