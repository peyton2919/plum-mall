package cn.peyton.plum.mall.mapper;

import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.mall.pojo.Role;
import io.lettuce.core.dynamic.annotation.Param;

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

    /**
     * <h4>根据用户Id和类型,查找角色对象</h4>
     * @param shareId
     * @param shareType
     * @return
     */
    Role selectByShareIdAndType(@Param("shareId") Long shareId, @Param("shareType") Integer shareType);



    // ==================================== new create method ==================================== //


}
