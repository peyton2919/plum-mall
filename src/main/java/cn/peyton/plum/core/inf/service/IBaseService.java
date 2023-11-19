package cn.peyton.plum.core.inf.service;

import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.PageResult;

import java.util.List;

/**
 * <h4>Service 基础类</h4>
 * <pre>
 *     基础类定义以下 9 个方法:
 *     1. P add(P record); 插入 P对象[根据属性是否有值 插入]
 *          @return 添加成功返回带 ID 对象, 否则返回 null
 *     2. Boolean update(P record); 更新 对象[根据属性是否有值 更新]
 *          @return true 表示 成功, 否则 取 false
 *     3. Boolean delete(K id);  根据 ID 删除 T对象
 *           @return true 表示 成功, 否则 取 false
 *     4. Boolean isRename(P record);  判断是否重名
 *           @return true 表示 重名, 否则 取 false
 *     5. P findById(K id);  根据 ID 查找 T对象
 *          @return 对象
 *     6. List<P> findByLikeAndObj(P record, PageQuery page);
 *          @return 对象集合
 *     7. List<P> findByObj(P record,PageQuery page);
 *          @return 对象集合
 *     8. Integer countByLike(P record);  查找全部数量(模糊Like查找)
 *          @return 总条数
 *     9. Integer count(P record);   查找全部数量
 *          @return 总条数
 * </pre>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.core.inf.service.IService
 * @date 2023年11月04日 9:48
 * @version 1.0.0
 * </pre>
 */
public interface IBaseService<K, T, P> {
    /**
     * <h4>插入 T对象[根据属性是否有值 插入]</h4>
     *
     * @param record 权限对象
     * @return 添加成功返回带 ID 对象, 否则返回 null
     */
    P add(P record);

    /**
     * <h4>更新 对象[根据属性是否有值 更新]</h4>
     *
     * @param record 权限对象
     * @return true 表示 成功, 否则 取 false
     */
    Boolean update(P record);

    /**
     * <h4>根据 ID 删除 T对象</h4>
     *
     * @param id 对象ID
     * @return true 表示 成功, 否则 取 false
     */
    Boolean delete(K id);

    /**
     * <h4>判断是否重名</h4>
     *
     * @param record 对象
     * @return true 表示 重名, 否则 取 false
     */
    Boolean isRename(P record);

    /**
     * <h4>根据 ID 查找 P对象</h4>
     *
     * @param id 对象ID
     * @return 对象
     */
    P findById(K id);

    /**
     * <h4>分页查询(全部或关键字模糊查找)</h4>
     *
     * @param record 关键字, 当 record = null 时为全部查询
     * @param page   分页对象
     * @return 对象集合
     */
    List<P> findByLikeAndObj(P record, PageQuery page);

    /**
     * <h4>分页查询(全部或关键字模糊查找)</h4>
     *
     * @param record 关键字, 当 record = null 时为全部查询
     * @param page   分页对象
     * @return 对象集合
     */
    PageResult<?> findAllByLike(P record, PageQuery page);
    /**
     * <h4>根据对象条件查找</h4>
     *
     * @param record 对象
     * @param page   分页对象
     * @return 对象集合
     */
    List<P> findByObj(P record, PageQuery page);

    /**
     * <h4>分页查询(全部或关键字模糊查找)</h4>
     *
     * @param record 关键字, 当 record = null 时为全部查询
     * @param page   分页对象
     * @return 对象集合
     */
    PageResult<?> findAll(P record, PageQuery page);
    /**
     * <h4>查找全部数量(模糊Like查找)</h4>
     *
     * @param record 关键字, record = null 时为全部查询
     * @return 总条数
     */
    Integer countByLike(P record);

    /**
     * <h4>查找全部数量</h4>
     *
     * @param record 关键字, 当keyword = null 时为全部查询
     * @return 总条数
     */
    Integer count(P record);
}
