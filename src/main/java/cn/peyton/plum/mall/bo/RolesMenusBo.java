package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.RolesMenusParam;
import cn.peyton.plum.mall.pojo.RolesMenus;

/**
 * <h3> 角色菜单关联 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class RolesMenusBo extends BaseConvertBo<RolesMenus, RolesMenusParam> {

    @Override
    public RolesMenusParam compat(RolesMenus info) {
        return new RolesMenusParam().compat(info);
    }

    @Override
    public RolesMenus convert(RolesMenusParam info) {
        return info.convert();
    }
}
