package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.WarehouseInfoParam;
import cn.peyton.plum.mall.pojo.WarehouseInfo;

/**
 * <h3> 仓库信息 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class WarehouseInfoBo extends BaseConvertBo<WarehouseInfo, WarehouseInfoParam> {

    @Override
    public WarehouseInfoParam compat(WarehouseInfo info) {
        return new WarehouseInfoParam().compat(info);
    }

    @Override
    public WarehouseInfo convert(WarehouseInfoParam info) {
        return info.convert();
    }
}
