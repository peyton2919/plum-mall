package cn.peyton.plum.mall.utils;

import cn.peyton.plum.mall.pojo.Menu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <h4>菜单 工具类</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.mall.utils.
 * @date 2023年11月15日 17:45
 * @version 1.0.0
 * </pre>
 */
public final class MenuUtils implements Serializable {

    /**
     * <h4>整理 菜单栏</h4>
     * @param menuList pojo对象集合
     * @return param对象集合
     */
    public static List<Menu> reorganize(List<Menu> menuList) {
        return new MenuUtils().getChildren(menuList);
    }

    /**
     * <h4>获取根目录</h4>
     * @param menus 菜单集合
     * @return
     */
    private List<Menu> getChildren(List<Menu> menus) {
        List<Menu> result = new ArrayList<>();
        for (Menu menu : menus) {
            // 获取根节点
            if (menu.getPid() == 0) {
                result.add(getChildrens(menu, menus));
            }
        }
        return result;
    }

    /**
     * <h4>递归查找 菜单栏 子类</h4>
     * @param menu 菜单对象
     * @param menus 菜单对象集合
     * @return
     */
    private Menu getChildrens(Menu menu, List<Menu> menus) {
        List<Menu> childNodes = new ArrayList<>();
        for (Menu node : menus) {

            if((node.getPid()+"").equals(menu.getId()+"")){
                childNodes.add(getChildrens(node, menus));
            }
        }
        menu.setChildren(childNodes);
        return menu;
    }
}
