package cn.peyton.plum.mall.mapper.product;

import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.mall.pojo.product.ShopCart;
import org.apache.ibatis.annotations.Update;

/**
 * <h3> 购物车 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public interface ShopCartMapper extends IBaseMapper<Long, ShopCart> {

    /**
     * <h4>根据shareId 查找</h4>
     * @param shareId 用户ID
     * @param shareType 用户类型
     * @return 对象
     */
    ShopCart selectByShareId(Long shareId, Integer shareType);

    /**
     * <h4>更新购物车</h4>
     * @param shareId 用户主键
     * @param shareType 用户类型
     * @param expand 扩展信息
     * @return 受影响的行数 > 0 成功
     */
    @Update("update tb_shop_cart set expand = #{expand} where `share_id` = #{shareId} and `share_type` = #{shareType} and `is_del` = 1")
    int updateCart(Long shareId,Integer shareType,String expand);

    // ==================================== new create method ==================================== //


}
