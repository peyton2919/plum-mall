package cn.peyton.plum.mall.service.product;

import cn.peyton.plum.core.inf.service.IBaseService;
import cn.peyton.plum.mall.param.product.ShopStockParam;
import cn.peyton.plum.mall.pojo.product.ShopStock;

/**
 * <h3> 商品库存汇总 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年12月29日 20:46:35
 * @version 1.0.0
 * </pre>
*/
public interface ShopStockService extends IBaseService<Long, ShopStock, cn.peyton.plum.mall.param.product.ShopStockParam> {


    /**
     * <h4>联合编辑</h4>
     * @param record 商品库存对象 含Id
     * @param psdId 商品规格明细Id
     * @param warehouseId 仓库Id
     * @param warehouseExplain 仓库说明
     * @return true 成功
     */
    Boolean joinEdit(ShopStockParam record, Long psdId, Integer warehouseId, String warehouseExplain);

    /**
     * <h4>更新 库存预警</h4>
     * @param id 库存主键
     * @param minStock 库存预警(默认0 不提示 >0 低于设置值 提示)
     * @return true成功
     */
    Boolean updateMinStock(Long id, Integer minStock);

    /**
     * <h4>更新 显示库存信息</h4>
     * @param id 库存主键
     * @param isShow 是否显示 1显示 0隐藏
     * @return true 成功
     */
    Boolean updateIsShow(Long id, Integer isShow);

}
