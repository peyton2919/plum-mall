package cn.peyton.plum.mall.service.sys;

import cn.peyton.plum.core.inf.service.base.IRealizeService;
import cn.peyton.plum.mall.param.sys.RoleMenuParam;
import cn.peyton.plum.mall.pojo.sys.RoleMenu;

import java.util.List;

/**
 * <h3> 角色菜单关联 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
public interface RoleMenuService extends IRealizeService<Long, RoleMenu, RoleMenuParam> {

    /**
     * <h4>批量添加 角色菜单集合</h4>
     * @param roleMenuParamList
     */
    Boolean batchAdd(List<RoleMenuParam> roleMenuParamList);

}
