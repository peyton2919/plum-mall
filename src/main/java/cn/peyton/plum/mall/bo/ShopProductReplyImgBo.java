package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.product.ShopProductReplyImgParam;
import cn.peyton.plum.mall.pojo.product.ShopProductReplyImg;

/**
 * <h3> 商品评论 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class ShopProductReplyImgBo extends BaseConvertBo<ShopProductReplyImg, ShopProductReplyImgParam> {

    @Override
    public ShopProductReplyImgParam compat(ShopProductReplyImg info) {
        return new ShopProductReplyImgParam().compat(info);
    }

    @Override
    public ShopProductReplyImg convert(ShopProductReplyImgParam info) {
        return info.convert();
    }
}
