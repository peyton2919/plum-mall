package cn.peyton.plum.mall.service.product;

import cn.peyton.plum.core.inf.service.base.IDeleteService;
import cn.peyton.plum.core.inf.service.base.IRealizeService;
import cn.peyton.plum.mall.param.product.ShopCartParam;
import cn.peyton.plum.mall.pojo.product.ShopCart;

/**
 * <h3> 购物车 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
public interface ShopCartService extends IDeleteService<Long>, IRealizeService<Long, ShopCart, ShopCartParam> {

    /**
     * <h4>根据shareId 查找</h4>
     * @param shareId 用户ID
     * @param shareType 用户类型
     * @return 对象
     */
    ShopCartParam findByShareId(Long shareId, Integer shareType);

    /**
     * <h4>更新购物车</h4>
     * @param shareId 用户主键
     * @param shareType 用户类型
     * @param expand 扩展信息
     * @return 受影响的行数 > 0 成功
     */
    Boolean updateCart(Long shareId,Integer shareType,String expand);
}
