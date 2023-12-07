package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.pub.ShopCanvasParam;
import cn.peyton.plum.mall.pojo.pub.ShopCanvas;

/**
 * <h3> 画布信息 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class ShopCanvasBo extends BaseConvertBo<ShopCanvas, ShopCanvasParam> {

    @Override
    public ShopCanvasParam compat(ShopCanvas info) {
        return new ShopCanvasParam().compat(info);
    }

    @Override
    public ShopCanvas convert(ShopCanvasParam info) {
        return info.convert();
    }
}
