package cn.peyton.plum.mall.service.product;

import cn.peyton.plum.core.inf.service.IBaseService;
import cn.peyton.plum.mall.param.product.ShopProductSkuDetailParam;
import cn.peyton.plum.mall.pojo.product.ShopProductSkuDetail;

import java.util.List;

/**
 * <h3> 商品规格详细 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
public interface ShopProductSkuDetailService extends IBaseService<Long, ShopProductSkuDetail, ShopProductSkuDetailParam> {


    /**
     * <h4>批量添加 规格明细对象</h4>
     * @param list 规格明细对象集合
     * @param skus 规格对象集合转成的字符串[规格:[规格值,规格值...],规格:[规格值,规格值...]...]
     * @return 受影响的行数 > 0 成功
     */
    Boolean batchCreate(List<ShopProductSkuDetailParam> list, String skus);

    /**
     * <h4>批量更新 规格明细对象</h4>
     * @param list 规格明细对象集合
     * @param skus 规格对象集合转成的字符串[规格:[规格值,规格值...],规格:[规格值,规格值...]...]
     * @return 受影响的行数 > 0 成功
     */
    Boolean batchEdit(List<ShopProductSkuDetailParam> list, String skus);
}
