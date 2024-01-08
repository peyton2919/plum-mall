package cn.peyton.plum.mall.mapper.product;

import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.mall.pojo.product.ShopStorageDetail;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <h3> 商品入库明细 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年12月29日 20:47:02
 * @version 1.0.0
 * </pre>
*/
public interface ShopStorageDetailMapper extends IBaseMapper<Long, ShopStorageDetail> {

    /**
     * <h>计算入库总和</h>
     * @param stockId  库存Id
     * @return 总入库数量
     */
    @Select("SELECT count(quantity) FROM tb_shop_storage_detail where stock_id = #{stockId}")
    Integer storageTotal(Long stockId);

    /**
     * <h4>获取当前对象的数量</h4>
     * @param id 入库主键
     * @return 数量
     */
    @Select("SELECT quantity FROM tb_shop_storage_detail where id = #{id}")
    Integer selectQuantityById(Long id);

    /**
     * <h4>根据库存Id 查找入库明细</h4>
     * @param stockId 库存Id
     * @param page 分页对象
     * @param startTime 查找开始时间
     * @param endTime 查找结束时间
     * @return 入库明细对象集合
     */
    List<ShopStorageDetail> selectByStockId(Long stockId, PageQuery page, Integer startTime, Integer endTime);

    /**
     * <h4>根据库存Id 查找总入库量</h4>
     * @param stockId 库存Id
     * @param startTime 查找开始时间
     * @param endTime   查找结束时间
     * @return 总条数
     */
    int countByStockId(Long stockId, Integer startTime, Integer endTime);
}
