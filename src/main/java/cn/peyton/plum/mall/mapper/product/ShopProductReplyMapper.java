package cn.peyton.plum.mall.mapper.product;

import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.mall.pojo.product.ShopProductReply;

/**
 * <h3> 商品评论 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public interface ShopProductReplyMapper extends IBaseMapper<Long, ShopProductReply> {
    /**
     * <h4>删除 对象 {更新 is_del=0}</h4>
     * @param id 主键
     * @return 受影响的行数 > 0 成功
     */
    int updateIsDel(Long id);

    // ==================================== new create method ==================================== //


}
