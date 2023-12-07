package cn.peyton.plum.mall.service.product;

import cn.peyton.plum.core.inf.service.IBaseService;
import cn.peyton.plum.mall.param.product.ShopProductSkuParam;
import cn.peyton.plum.mall.pojo.product.ShopProductSku;

/**
 * <h3> 商品规格关联 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
public interface ShopProductSkuService extends IBaseService<Long, ShopProductSku, ShopProductSkuParam> {

    /**
     * <h4>判断是否存在 skuValue </h4>
     * @param param 对象
     * @return 存在 true
     */
    boolean isExisted(ShopProductSkuParam param);

}
