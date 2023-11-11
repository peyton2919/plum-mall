package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.MenuParam;
import cn.peyton.plum.mall.pojo.Menu;

/**
 * <h3> 菜单 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class MenuBo extends BaseConvertBo<Menu, MenuParam> {

    @Override
    public MenuParam compat(Menu info) {
        return new MenuParam().compat(info);
    }

    @Override
    public Menu convert(MenuParam info) {
        return info.convert();
    }
}
