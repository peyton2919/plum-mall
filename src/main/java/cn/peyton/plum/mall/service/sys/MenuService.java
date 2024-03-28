package cn.peyton.plum.mall.service.sys;

import cn.peyton.plum.core.inf.service.base.IRealizeService;
import cn.peyton.plum.mall.param.sys.MenuParam;
import cn.peyton.plum.mall.pojo.sys.Menu;

import java.util.List;

/**
 * <h3> 菜单 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
public interface MenuService extends IRealizeService<Long, Menu, MenuParam> {

    /**
     * <h4>根据用户Id及类型查找菜单对象集合</h4>
     * @param shareId 用户Id
     * @param shareType 用户类型
     * @return
     */
    List<MenuParam> findMenuListByShareIdAndType(Long shareId, Integer shareType);
    /**
     * <h4>菜单树型查找</h4>
     * @return
     */
    List<MenuParam> findByTree();

    /**
     * <h4>更新状态</h4>
     * @param id 主键
     * @param status 状态 1 可用 0 禁用
     * @return true 成功
     */
    Boolean upStatus(Long id, Integer status);

}
