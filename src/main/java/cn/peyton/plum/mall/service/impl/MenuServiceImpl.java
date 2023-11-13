package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractAppRealizeService;
import cn.peyton.plum.mall.bo.MenuBo;
import cn.peyton.plum.mall.mapper.MenuMapper;
import cn.peyton.plum.mall.param.MenuParam;
import cn.peyton.plum.mall.pojo.Menu;
import cn.peyton.plum.mall.service.MenuService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3> 菜单 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("menuService")
public class MenuServiceImpl extends AbstractAppRealizeService<Long, Menu, MenuParam> implements MenuService {
    @Resource
    private MenuMapper menuMapper;

    @Override
    public BaseConvertBo<Menu, MenuParam> initBo() {
        return new MenuBo();
    }

    @Override
    public IBaseMapper<Long, Menu> initMapper() {
        return menuMapper;
    }

    @Override
    public List<MenuParam> findMenuListByShareIdAndType(Long shareId, Integer shareType) {
        List<Menu> menus = menuMapper.selectMenuListByShareIdAndType(shareId,shareType);

        return initBo().adapter(getChildren(menus));
    }

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
