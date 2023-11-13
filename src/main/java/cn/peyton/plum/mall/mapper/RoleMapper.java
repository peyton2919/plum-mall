package cn.peyton.plum.mall.mapper;

import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.mall.pojo.Role;

import java.util.List;

/**
 * <h3> 角色 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public interface RoleMapper extends IBaseMapper<Long, Role> {

    /**
     * <h4>根据角色ID集合 获取 角色对象集合</h4>
     * @param idList
     * @return
     */
    List<Role> selectByIdList(List<Long> idList);



    // ==================================== new create method ==================================== //


}
