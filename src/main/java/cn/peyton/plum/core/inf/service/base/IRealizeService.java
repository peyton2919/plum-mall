package cn.peyton.plum.core.inf.service.base;

import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.PageResult;

import java.util.List;

/**
 * <h4></h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.core.inf.service.
 * @date 2024年03月27日 21:18
 * @version 1.0.0
 * </pre>
 */
public interface IRealizeService<K, T, P> {

    /**
     * <h4>插入 T对象[根据属性是否有值 插入]</h4>
     *
     * @param record 权限对象
     * @return 添加成功返回带 ID 对象, 否则返回 null
     */
    P insert(P record);

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
     * <h4>判断是否重复</h4>
     *
     * @param record 对象
     * @return true 表示 重复, 否则 取 false
     */
    Boolean repeat(P record);

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
     * @param isLike true like 查找
     * @return 对象集合
     */
    List<P> list(P record, PageQuery page, boolean isLike);

    /**
     * <h4>分页查询(全部或关键字模糊查找)</h4>
     *
     * @param record 关键字, 当 record = null 时为全部查询
     * @param page   分页对象
     * @param key    缓存区分key{用在扩展查找}
     * @param isLike true like 查找
     * @return 对象集合
     */
    List<P> list(P record, PageQuery page,String key, boolean isLike);

    /**
     * <h4>分页查询(全部或关键字模糊查找)</h4>
     *
     * @param record 关键字, 当 record = null 时为全部查询
     * @param page   分页对象
     * @param isLike true like 查找
     * @return 对象集合
     */
    PageResult<?> page(P record, PageQuery page, boolean isLike);

    /**
     * <h4>分页查询(全部或关键字模糊查找)</h4>
     *
     * @param record 关键字, 当 record = null 时为全部查询
     * @param page   分页对象
     * @param key    缓存区分key{用在扩展查找}
     * @param isLike true like 查找
     * @return 对象集合
     */
    PageResult<?> page(P record, PageQuery page, String key, boolean isLike);

    /**
     * <h4>查找全部数量</h4>
     *
     * @param record 关键字, 当keyword = null 时为全部查询
     * @param isLike true 为 like 查找
     * @return 总条数
     */
    int count(P record, boolean isLike);
}
