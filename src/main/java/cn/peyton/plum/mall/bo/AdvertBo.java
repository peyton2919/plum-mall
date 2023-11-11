package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.AdvertParam;
import cn.peyton.plum.mall.pojo.Advert;

/**
 * <h4>广告信息 数据转换类</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.mall.bo.AdvertBo
 * @date 2023年11月10日 16:42
 * @version 1.0.0
 * </pre>
 */
public class AdvertBo extends BaseConvertBo<Advert, AdvertParam> {
    @Override
    public AdvertParam compat(Advert info) {
        return new AdvertParam().compat(info);
    }

    @Override
    public Advert convert(AdvertParam info) {
        return info.convert();
    }
}
