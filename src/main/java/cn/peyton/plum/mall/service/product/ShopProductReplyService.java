package cn.peyton.plum.mall.service.product;

import cn.peyton.plum.core.inf.service.IBaseService;
import cn.peyton.plum.mall.param.product.ShopProductReplyParam;
import cn.peyton.plum.mall.pojo.product.ShopProductReply;

/**
 * <h3> 商品评论 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
public interface ShopProductReplyService extends IBaseService<Long, ShopProductReply, ShopProductReplyParam> {

    /**
     * <h4>删除 对象 {更新 is_del=0}</h4>
     * @param id 主键
     * @return 删除成功 true
     */
    Boolean updateIsDel(Long id);

}
