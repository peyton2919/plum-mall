package cn.peyton.plum.mall.service.sys.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.mall.bo.MenuBo;
import cn.peyton.plum.mall.mapper.sys.MenuMapper;
import cn.peyton.plum.mall.param.sys.MenuParam;
import cn.peyton.plum.mall.pojo.sys.Menu;
import cn.peyton.plum.mall.service.sys.MenuService;
import cn.peyton.plum.mall.utils.MenuUtils;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

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
public class MenuServiceImpl extends AbstractRealizeService<Long, Menu, MenuParam> implements MenuService {
    private String TABLE_NAME = "sys_menu";

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

    public MenuServiceImpl(){
        // 开启缓存
        enabledCache = true;
        //设置缓存 key 的前缀
        keyPrefix = this.getClass().getName();
    }

    @Override
    public List<MenuParam> findMenuListByShareIdAndType(Long shareId, Integer shareType) {
        List<Menu> menus = menuMapper.selectMenuListByShareIdAndType(shareId,shareType);
        return new MenuBo().adapter(MenuUtils.reorganize(menus));

    }

    @Override
    public List<MenuParam> findByTree() {
        String key = keyPrefix + "_find_tree_all";
        if (enabledCache){
            Object list = cache.get(key);
            if (null != list) {
                System.out.printf("从缓存获取到对象: key= %s;\n",key);
                return (List<MenuParam>)list;
            }
        }
        List<MenuParam> pList = initBo().adapter(MenuUtils.reorganize(menuMapper.selectByTree()));

        if (null != pList && pList.size() > 0 && enabledCache) {
            System.out.printf("添加对象到缓存: key= %s;\n",key);
            cache.put(key,pList);
        }
        return pList;
    }

    @Override
    public Boolean upStatus(Long id, Integer status) {
        int res = menuMapper.updateStatus(TABLE_NAME, id, status);
        if (res > 0) {
            if (enabledCache) {
                System.out.println("更新操作,清空缓存");
                removeCache();
            }
            return true;
        }
        return false;
    }
}
