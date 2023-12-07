package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.join.BrandParam;
import cn.peyton.plum.mall.pojo.join.Brand;

/**
 * <h4>品牌 数据转换类</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.mall.bo.BrandBo
 * @date 2023年11月10日 17:03
 * @version 1.0.0
 * </pre>
 */
public class BrandBo extends BaseConvertBo<Brand, BrandParam> {
    @Override
    public BrandParam compat(Brand info) {
        return new BrandParam().compat(info);
    }

    @Override
    public Brand convert(BrandParam info) {
        return info.convert();
    }
}
