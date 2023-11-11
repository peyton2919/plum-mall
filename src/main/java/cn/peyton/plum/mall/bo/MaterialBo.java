package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.MaterialParam;
import cn.peyton.plum.mall.pojo.Material;

/**
 * <h3> 素材库 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class MaterialBo extends BaseConvertBo<Material, MaterialParam> {

    @Override
    public MaterialParam compat(Material info) {
        return new MaterialParam().compat(info);
    }

    @Override
    public Material convert(MaterialParam info) {
        return info.convert();
    }
}
