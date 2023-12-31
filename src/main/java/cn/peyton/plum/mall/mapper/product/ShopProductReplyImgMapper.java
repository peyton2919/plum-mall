package cn.peyton.plum.mall.mapper.product;

import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.mall.pojo.product.ShopProductReplyImg;

import java.util.List;

/**
 * <h3> 商品评论 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public interface ShopProductReplyImgMapper extends IBaseMapper<Long, ShopProductReplyImg> {
    /**
     * <h4>根据评论Id 查找 对象集合</h4>
     * @param replyId
     * @return
     */
    List<ShopProductReplyImg> selectByReplyId(Long replyId);
    // ==================================== new create method ==================================== //


}
