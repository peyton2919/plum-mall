package cn.peyton.plum.mall.service.product;

import cn.peyton.plum.core.inf.service.base.IRealizeService;
import cn.peyton.plum.mall.param.product.ShopSkuValueParam;
import cn.peyton.plum.mall.pojo.product.ShopSkuValue;

import java.util.List;

/**
 * <h3> 商品规格 值 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
public interface ShopSkuValueService extends IRealizeService<Long, ShopSkuValue, ShopSkuValueParam> {

    /**
     * <h4>根据 规格Id 和 规格值 查找 规格值对象</h4>
     * @param skuId 规格Id
     * @param skuValue 规格值
     * @return 没找到为空,否则 为 ShopSkuValueParam 对象
     */
    ShopSkuValueParam findBySkuIdAndValue(Long skuId,String skuValue);


    /**
     * <h4>批量添加</h4>
     * @param list 规格值对象集合
     * @return 返回受影响的行数 > 0 成功
     */
    Boolean batchCreate(List<ShopSkuValueParam> list);

    /**
     * <h4>根据 规格Id 判断 有没有存在规格值</h4>
     * @param skuId 规格Id
     * @return 存在 true
     */
    Boolean isShopSku(Long skuId);
}
