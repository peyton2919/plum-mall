package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.ShopSlideshowParam;
import cn.peyton.plum.mall.pojo.ShopSlideshow;

/**
 * <h3> 商品轮播图 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class ShopSlideshowBo extends BaseConvertBo<ShopSlideshow, ShopSlideshowParam> {

    @Override
    public ShopSlideshowParam compat(ShopSlideshow info) {
        return new ShopSlideshowParam().compat(info);
    }

    @Override
    public ShopSlideshow convert(ShopSlideshowParam info) {
        return info.convert();
    }
}
