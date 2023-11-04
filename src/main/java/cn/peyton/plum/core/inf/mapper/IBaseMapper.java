package cn.peyton.plum.core.inf.mapper;

import cn.peyton.plum.core.page.PageQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <h4></h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.core.inf.mapper.IBaseMapper
 * @date 2023年10月27日 11:06
 * @version 1.0.0
 * </pre>
 */
@Mapper
public interface IBaseMapper<K , T> {

    /**
     * <h4>插入 T对象[根据属性是否有值 插入]</h4>
     * @param record 权限对象
     * @return 受影响的行数
     */
    int insertSelective(T record);

    /**
     * <h4>更新 对象[根据属性是否有值 更新]</h4>
     * @param record 权限对象
     * @return 受影响的行数
     */
    int updateByPrimaryKeySelective(T record);

    /**
     * <h4>更新状态</h4>
     * @param id 主键
     * @param status 状态值
     * @return 受影响行数
     */
    int upStatus(@Param("id") K id, @Param("status") Integer status);

    /**
     * <h4>根据 ID 删除 T对象</h4>
     * @param id 对象ID
     * @return 受影响的行数
     */
    int deleteByPrimaryKey(K id);

    /**
     * <h4>判断是否重名</h4>
     * @param record 对象
     * @return 大于0 表示 重名
     */
    int isRename(T record);

    /**
     * <h4>根据 ID 查找 T对象</h4>
     * @param id 对象ID
     * @return 对象
     */
    T selectByPrimaryKey(K id);

    /**
     * <h4>分页查询(全部或关键字模糊查找)</h4>
     * @param keyword 关键字, 当keyword = null 时为全部查询
     * @param page 分页对象
     * @return 对象集合
     */
    List<T> selectByAllOrKeyword(@Param("keyword") String keyword,@Param("page") PageQuery page);

    /**
     * <h4>根据对象条件查找</h4>
     * @param record 对象
     * @param page 分页对象
     * @return 对象集合
     */
    List<T> selectByObj(T record, @Param("page") PageQuery page);

    /**
     * <h4>查找全部数量(全部或关键字模糊查找)</h4>
     * @param keyword 关键字, 当keyword = null 时为全部查询
     * @return 总条数
     */
    int count(@Param("keyword") String keyword);
}
