package cn.peyton.plum.mall.mapper.sys;

import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.mall.pojo.sys.City;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <h3> 城市表 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年12月27日 09:58:27
 * @version 1.0.0
 * </pre>
*/
public interface CityMapper extends IBaseMapper<Integer,City> {

    /**
     * <h4>菜单树型查找</h4>
     * @return 集合
     */
    List<City> selectByTree();

    /**
     * <h4>根据 pid 查找</h4>
     * @param pid 父级Id
     * @param status 状态 1 可用 0 不可用
     * @return 集合
     */
    List<City> selectByPid(Integer pid,Integer status);

    /**
     * <h4>多级下拉框</h4>
     * @param level 下拉框层级 0 省 1 市 2 县|区
     * @return 集合
     */
    List<City> selectByDown(Integer level);

    /**
     * <4>根据 pid 查找集合</4>
     * <pre>查找 level 1</pre>
     * @param pid 父级Id
     * @return 集合
     */
    List<City> selectLevelByObj1(Integer pid);

    /**
     * <4>根据 pid 查找集合</4>
     * <pre>查找 level 2</pre>
     * @param pid 父级Id
     * @return 集合
     */
    List<City> selectLevelByObj2(Integer pid);

    /**
     * <h4>批量更新</h4>
     * @param ids 主键集合
     * @param status 状态 1 可用 0 禁用
     * @return 受影响的行数 > 0 成功
     */
    int batchUpdate(List<Integer> ids, Integer status);

    /**
     * <h4>批量删除</h4>
     * @param ids 主键集合
     * @return 受影响的行数 > 0 成功
     */
    int batchDelete(List<Integer> ids);

    /**
     * <h4>查找 省级以下所有子类的 Id </h4>
     * @param pid 省级pid
     * @return id集合
     */
    @Select("SELECT id FROM sys_city where (pid in(SELECT id FROM sys_city where pid=#{pid})) or pid=#{pid}")
    List<Integer> selectLevel1(Integer pid);

    /**
     * <h4>查找 市级以下所有子类的 Id </h4>
     * @param pid 省级pid
     * @return id集合
     */
    @Select("select id FROM sys_city where pid= #{pid}")
    List<Integer> selectLevel2(Integer pid);


}
