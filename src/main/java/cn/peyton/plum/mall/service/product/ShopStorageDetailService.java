package cn.peyton.plum.mall.service.product;

import cn.peyton.plum.core.inf.service.base.IRealizeService;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.PageResult;
import cn.peyton.plum.mall.param.product.ShopStorageDetailParam;
import cn.peyton.plum.mall.pojo.product.ShopStorageDetail;

/**
 * <h3> 商品入库明细 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年12月29日 20:47:02
 * @version 1.0.0
 * </pre>
*/
public interface ShopStorageDetailService extends IRealizeService<Long, ShopStorageDetail, ShopStorageDetailParam> {


    /**
     * <h>计算入库总和</h>
     * @param stockId  库存Id
     * @return 总入库数量
     */
    Integer storageTotal(Long stockId);

    /**
     * <h4>根据库存Id 查找入库明细</h4>
     * @param stockId 库存Id
     * @param page 分页对象
     * @param startTime 查找开始时间
     * @param endTime 查找结束时间
     * @return 入库明细对象集合
     */
    PageResult<ShopStorageDetailParam> findByStockId(Long stockId, PageQuery page, Integer startTime, Integer endTime);

    /**
     * <h4>新增入库信息</h4>
     * <pre>
     *  1. 判断 商品规格明细 是否有库存
     *  2. 新增 入库对象
     *  3. 更新 库存对象 库存总量
     * </pre>
     * @param psdId 商品规格明细Id
     * @param quantity 商品数量
     * @return true 成功
     */
    Boolean joinCreate(Long psdId, Integer quantity);

    /**
     * <h4>新增入库信息</h4>
     *
     * @param id       入库主键
     * @param psdId    商品规格明细Id
     * @param stockId  库存主键
     * @param quantity 商品数量
     * @return true 成功
     */
    Boolean joinEdit(Long id, Long psdId, Long stockId, Integer quantity);

}
