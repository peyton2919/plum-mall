package cn.peyton.plum.mall.service.join;

import cn.peyton.plum.core.inf.service.IBaseService;
import cn.peyton.plum.mall.param.join.WarehouseInfoParam;
import cn.peyton.plum.mall.pojo.join.WarehouseInfo;

import java.util.List;

/**
 * <h3> 仓库信息 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:53
 * @version 1.0.0
 * </pre>
 */
public interface WarehouseInfoService extends IBaseService<Integer, WarehouseInfo, WarehouseInfoParam> {

    /**
     * <h4>下拉框查找</h4>
     * <pre>
     *     `id`,`logo`,`name`,`area`
     *     用于下拉框使用
     * </pre>
     * @return 仓库对象集合
     */
    List<WarehouseInfoParam> findByDownList();
}
