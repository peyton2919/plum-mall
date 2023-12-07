package cn.peyton.plum.mall.mapper.product;

import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.mall.pojo.product.ShopSlideshow;

import java.util.List;

/**
 * <h3> 商品轮播图 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public interface ShopSlideshowMapper extends IBaseMapper<Long, ShopSlideshow> {
    /**
     * <h4>批量添加轮播图</h4>
     * @param slideshows 轮播图对象
     * @return 大于>0 表示 成功
     */
    int batchInsertSelective(List<ShopSlideshow> slideshows);

    /**
     * <h4>根据商品Id 查找 集合</h4>
     * @param productId 商品Id
     * @return
     */
    List<ShopSlideshow> selectByProductId(Long productId);

    /**
     * <h4>根据商品Id 删除轮播图</h4>
     * @param productId
     * @return
     */
    int batchDelete(Long productId);
    // ==================================== new create method ==================================== //


}
