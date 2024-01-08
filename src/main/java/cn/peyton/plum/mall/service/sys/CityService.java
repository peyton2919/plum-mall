package cn.peyton.plum.mall.service.sys;

import cn.peyton.plum.core.inf.service.IBaseService;
import cn.peyton.plum.mall.param.sys.CityParam;
import cn.peyton.plum.mall.pojo.sys.City;

import java.util.List;

/**
 * <h3> 城市 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年12月01日 19:03:49
 * @version 1.0.0
 * </pre>
*/
public interface CityService extends IBaseService<Integer, City, CityParam> {

    /**
     * <h4>菜单树型查找</h4>
     * @return
     */
    List<CityParam> findByTree();

    /**
     * <h4>根据 pid 查找</h4>
     * @param pid 父级Id
     * @param status 状态 1 可用 0 不可用
     * @return
     */
    List<CityParam> findByPid(Integer pid,Integer status);

    /**
     * <h4>更新状态</h4>
     * @param id 主键
     * @param status 状态 1 可用 0 禁用
     * @return true 成功
     */
    Boolean upStatus(Integer id, Integer status);

    /**
     * <h4>多级下拉框</h4>
     * @param level 下拉框层级 0 省 1 市 2 县|区
     * @return 集合
     */
    List<CityParam> findByDown(Integer level);

    /**
     * <h4>查找 省级以下所有子类的 Id </h4>
     * @param pid 省级pid
     * @return id集合
     */
    List<Integer> findLevel1(Integer pid);

    /**
     * <h4>查找 市级以下所有子类的 Id </h4>
     * @param pid 省级pid
     * @return id集合
     */
    List<Integer> findLevel2(Integer pid);

    /**
     * <h4>批量更新</h4>
     * @param ids 主键集合
     * @param status 状态 1 可用 0 禁用
     * @return true 成功
     */
    Boolean batchUpdate(List<Integer> ids, Integer status);

}
