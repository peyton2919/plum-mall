package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.ShopProductReplyParam;
import cn.peyton.plum.mall.pojo.ShopProductReply;

/**
 * <h3> 商品评论 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class ShopProductReplyBo extends BaseConvertBo<ShopProductReply, ShopProductReplyParam> {

    @Override
    public ShopProductReplyParam compat(ShopProductReply info) {
        return new ShopProductReplyParam().compat(info);
    }

    @Override
    public ShopProductReply convert(ShopProductReplyParam info) {
        return info.convert();
    }
}
