package cn.peyton.plum.mall.mapper.join;

import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.mall.pojo.join.WarehouseInfo;

import java.util.List;

/**
 * <h3> 仓库信息 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public interface WarehouseInfoMapper extends IBaseMapper<Integer, WarehouseInfo> {

    /**
     * <h4>下拉框查找</h4>
     * <pre>
     *     `id`,`logo`,`name`,`area`
     *     用于下拉框使用
     * </pre>
     * @return 仓库对象集合
     */
    List<WarehouseInfo> selectByDownList();

    // ==================================== new create method ==================================== //


}
