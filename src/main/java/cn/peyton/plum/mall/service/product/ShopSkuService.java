package cn.peyton.plum.mall.service.product;

import cn.peyton.plum.core.inf.service.base.IRealizeService;
import cn.peyton.plum.mall.param.product.ShopSkuParam;
import cn.peyton.plum.mall.pojo.product.ShopSku;

import java.util.List;

/**
 * <h3> 商品规格 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
public interface ShopSkuService extends IRealizeService<Long, ShopSku, ShopSkuParam> {

    /**
     * <h4>根据名称查找</h4>
     * @param name
     * @return
     */
    ShopSkuParam findByName(String name);

    /**
     * <h4>联合添加对象</h4>
     * @param productId 商品Id
     * @param record 商品规格对象
     * @return 成功 true
     */
    ShopSkuParam createJoinProduct(Long productId, ShopSkuParam record);

    /**
     * <h4>联合删除 对象</h4>
     * <pre>
     *     1.需要先判断 规格 下有没有关联的 规格值
     *     2.删除 shopSku 与 shopProduct 关联表
     *     3.删除 规格
     * </pre>
     * @param productId 商品Id
     * @param skuId 规格Id
     * @param tip
     * @return 成功 true
     */
    Boolean joinDelete(Long productId, Long skuId,StringBuffer tip);
    /**
     * <h4>批量更新排序值</h4>
     * @param skus
     * @return
     */
    Boolean batchUpdate(List<ShopSkuParam> skus);

    /**
     * <h4>从规格规则中获取</h4>
     * @param name 规格名称
     * @param strs 规格值名称集合
     * @return
     */
    ShopSkuParam set(String name, List<String> strs);
}
