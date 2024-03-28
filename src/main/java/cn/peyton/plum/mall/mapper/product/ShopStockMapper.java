package cn.peyton.plum.mall.mapper.product;


import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.mall.pojo.product.ShopStock;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <h3> 商品库存汇总 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年12月29日 20:46:35
 * @version 1.0.0
 * </pre>
*/
public interface ShopStockMapper extends IBaseMapper<Long, ShopStock> {

    /**
     * <h4>判断该商品是否有创建过库存</h4>
     * @param psdId 商品规格明细Id
     * @return 库存对象 或 空
     */
    ShopStock isExist(Long psdId);

    /**
     * <h4>根据商品明细Id 集合查找</h4>
     * @param ids 商品明细Id集合
     * @return 库存集合
     */
    List<ShopStock> selectByIds(List<Long> ids);

    /**
     * <h4>购买商品时,判断库存商品数量够不够</h4>
     * @param psdId 商品规格明细Id
     * @param num 当前购买商品数量
     * @return  受影响的行数 > 0 可买
     */
    @Select("SELECT COUNT(id) FROM tb_shop_stock where psd_id =#{psdId} and total >= pay_count +#{num}")
    int isDeduction(Long psdId, Integer num);

    /**
     * <h4>更新 库存预警</h4>
     * @param id 库存主键
     * @param minStock 库存预警(默认0 不提示 >0 低于设置值 提示)
     * @return 受影响的行数 > 0 成功
     */
    @Update("update tb_shop_stock set min_stock =#{minStock}  where id=#{id}")
    int updateMinStock(Long id, Integer minStock);

    /**
     * <h4>更新 显示库存信息</h4>
     * @param id 库存主键
     * @param isShow 是否显示 1显示 0隐藏
     * @return 受影响的行数 > 0 成功
     */
    @Update("update tb_shop_stock set is_show =#{isShow}  where id=#{id}")
    int updateIsShow(Long id, Integer isShow);

    /**
     * <h4>更新 总库存</h4>
     * @param id 库存主键
     * @return 受影响的行数 > 0 成功
     */
    @Update("UPDATE tb_shop_stock set total =(select SUM(quantity) FROM tb_shop_storage_detail where stock_id=#{id}) where id = #{id}")
    int updateTotal(Long id);

    /**
     * <h4>更新 总销量</h4>
     *
     * @param psdId 商品规格明细主键
     * @return 受影响的行数 > 0 成功
     */
    @Update("UPDATE tb_shop_stock set pay_count =(select SUM(num-refund_num) FROM tb_shop_order_item  where psd_id=#{psdId}) where psd_id = #{psdId}")
    int updatePayCount(Long psdId);
}
