package cn.peyton.plum.mall.mapper;

import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.mall.pojo.Material;

/**
 * <h3> 素材库 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public interface MaterialMapper extends IBaseMapper<Long, Material> {

    // ==================================== new create method ==================================== //
    /**
     * <h4>判断有没有关联分组</h4>
     * @param groupId 分组Id
     * @return 受影响的行数 有关联 大于 0
     */
    int joinGroup(Long groupId);

}
