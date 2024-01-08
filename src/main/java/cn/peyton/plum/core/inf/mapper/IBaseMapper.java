package cn.peyton.plum.core.inf.mapper;

import cn.peyton.plum.core.page.PageQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <h4>Mapper 基础类</h4>
 * <pre>
 *     基础类定义以下 9 个方法:
 *     1. int insertSelective(T record); 插入 T对象[根据属性是否有值 插入]
 *          @return 受影响的行数;大于 0  表示插入成功
 *     2. int updateSelective(T record); 更新 对象[根据属性是否有值 更新]
 *          @return 受影响的行数;大于 0  表示更新成功
 *     3. int deleteByPrimaryKey(K id);  根据 ID 删除 T对象
 *           @return 受影响的行数;大于 0  表示删除成功
 *     4. int isRename(T record);  判断是否重名
 *           @return 大于 0 表示重名
 *     5. T selectByPrimaryKey(K id);  根据 ID 查找 T对象
 *          @return 对象
 *     6. List<T> selectByLiekAndObj(@Param("record") T record,@Param("page") PageQuery page);  分页查询(全部或关键字模糊查找)
 *          @return 对象集合
 *     7. List<T> selectByObj(@Param("record")T record, @Param("page") PageQuery page);  根据对象条件查找
 *          @return 对象集合
 *     8. int countByLike(T record);  查找全部数量(模糊Like查找)
 *          @return 总条数
 *     9. int count(T record);   查找全部数量
 *          @return 总条数
 *  =======================================================================================================
 *  以下用的是注解方式:
 *    1. int updateDeleteStatus(String tableName, K id); 更新删除 {`is_del` = 0}
 *          @return 受影响的行数 > 0  表示删除成功
 *    2. int updateStatus(String tableName, K id,Integer status);
 *          @return 受影响的行数 > 0  表示更新状态成功
 * </pre>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.core.inf.mapper.IBaseMapper
 * @date 2023年10月27日 11:06
 * @version 1.0.0
 * </pre>
 */
@Mapper
public interface IBaseMapper<K, T> {

    /**
     * <h4>插入 T对象[根据属性是否有值 插入]</h4>
     *
     * @param record 权限对象
     * @return 受影响的行数；
     */
    int insertSelective(T record);

    /**
     * <h4>更新 对象[根据属性是否有值 更新]</h4>
     *
     * @param record 权限对象
     * @return 受影响的行数
     */
    int updateSelective(T record);

    /**
     * <h4>根据 ID 删除 T对象</h4>
     *
     * @param id 对象ID
     * @return 受影响的行数
     */
    int deleteByPrimaryKey(K id);

    /**
     * <h4>判断是否重复,也可以做些其他判断</h4>
     * <pre>
     *     1. 判断是否重名,输入对象里的属性值其他为空, 返回大于 0 表示重名;
     *     2. 判断状态是否可用, 唯一的关键字(字段不重复的属性)、状态码(禁用的状态码) 返回大于 0 表示 被禁用(不可用);
     *     3. 其他可用...
     * </pre>
     *
     * @param record 对象
     * @return 大于0 表示 重名
     */
    int repeat(T record);

    /**
     * <h4>根据 ID 查找 T对象</h4>
     *
     * @param id 对象ID
     * @return 对象
     */
    T selectByPrimaryKey(K id);

    /**
     * <h4>分页查询(全部或关键字模糊查找)</h4>
     *
     * @param record 关键字, 当 record = null 时为全部查询
     * @param page   分页对象
     * @return 对象集合
     */
    List<T> selectByLikeAndObj(@Param("record") T record, @Param("page") PageQuery page);

    /**
     * <h4>根据对象条件查找</h4>
     *
     * @param record 对象
     * @param page   分页对象
     * @return 对象集合
     */
    List<T> selectByObj(@Param("record") T record, @Param("page") PageQuery page);

    /**
     * <h4>查找全部数量(模糊Like查找)</h4>
     *
     * @param record 关键字, record = null 时为全部查询
     * @return 总条数
     */
    int countByLike(T record);

    /**
     * <h4>查找全部数量</h4>
     *
     * @param record 关键字, record = null 时为全部查询
     * @return 总条数
     */
    int count(T record);

    // 以下是注解方式

    /**
     * <h4>删除记录 {更新is_del = 0}</h4>
     *
     * @param id 会员Id
     * @return 受影响的行数 > 0 成功
     */
    @Update("update ${tableName} set is_del = 0 where id = #{id}")
    int updateDeleteStatus(String tableName, K id);

    /**
     * <h4>删除记录 {更新is_del = 0}</h4>
     *
     * @param id 主键Id
     * @param status 状态值
     * @return 受影响的行数 > 0 成功
     */
    @Update("update ${tableName} set status = #{status} where id = #{id}")
    int updateStatus(String tableName, K id,Integer status);
}
