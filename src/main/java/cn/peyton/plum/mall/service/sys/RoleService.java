package cn.peyton.plum.mall.service.sys;

import cn.peyton.plum.core.inf.service.base.IRealizeService;
import cn.peyton.plum.mall.param.sys.RoleParam;
import cn.peyton.plum.mall.pojo.sys.Role;

import java.util.List;

/**
 * <h3> 角色 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
public interface RoleService extends IRealizeService<Long, Role, RoleParam> {

    /**
     * <h4>下拦框选择列表</h4>
     * @return 对象集合 {id,name}
     */
    List<RoleParam> findBySelect();
    
}
