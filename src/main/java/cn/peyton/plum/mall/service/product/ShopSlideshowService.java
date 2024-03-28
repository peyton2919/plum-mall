package cn.peyton.plum.mall.service.product;

import cn.peyton.plum.core.inf.service.base.IRealizeService;
import cn.peyton.plum.mall.param.product.ShopSlideshowParam;
import cn.peyton.plum.mall.pojo.product.ShopSlideshow;

import java.util.List;

/**
 * <h3> 商品轮播图 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:53
 * @version 1.0.0
 * </pre>
 */
public interface ShopSlideshowService extends IRealizeService<Long, ShopSlideshow, ShopSlideshowParam> {

    /**
     * <h4>批量添加轮播图</h4>
     * @param productId 商品Id
     * @param slideshows 轮播图对象
     * @param bool 新增 false | 更新 true
     * @return true 表示 成功
     */
    Boolean batchInsertSelective(Long productId,List<ShopSlideshowParam> slideshows,Boolean bool);
}
