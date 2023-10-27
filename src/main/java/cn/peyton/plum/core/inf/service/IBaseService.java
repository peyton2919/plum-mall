package cn.peyton.plum.core.inf.service;

import cn.peyton.plum.core.page.PageQuery;

import java.util.List;

/**
 * <h4></h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.core.inf.service.IBaseService
 * @date 2023年10月27日 11:11
 * @version 1.0.0
 * </pre>
 */
public interface IBaseService<K, P> {

    /**
     * <h4>添加对象</h4>
     *
     * @param param 对象
     */
    P save(P param);

    /**
     * <h4>更新对象</h4>
     *
     * @param param 对象
     */
//    @Transactional(propagation = Propagation.REQUIRED)
    Boolean update(P param);

    /**
     * <h4>更新状态</h4>
     * @param id 主键
     * @param status 状态值
     * @return 受影响行数
     */
    int upStatus(K id, Integer status);

    /**
     * <h4>根据主键删除对象</h4>
     *
     * @param id 主键
     */
    Boolean delete(K id);

    /**
     * <h4>判断是否重名</h4>
     * @param param 对象
     * @return 大于0 表示 重名
     */
    int isRename(P param);

    /**
     * <h4>根据主键查找对象</h4>
     *
     * @param id 主键
     * @return 对象
     */
    P findById(K id);

    /**
     * <h4>分页查询(或模糊查找)</h4>
     * @param keyword 关键字, 当keyword = null 时为全部查询
     * @param page    分页对象
     * @return 对象集合
     */
    List<P> findByAllOrKeyword(String keyword, PageQuery page);

    /**
     * <h4>分页查询(或模糊查找)</h4>
     * @param param 对象
     * @param page 分页对象
     * @return 对象集合
     */
    List<P> findByObj(P param, PageQuery page);

    /**
     * <h4>查找全部数量</h4>
     * @param keyword 关键字, 当keyword = null 时为全部查询
     * @return 总条数
     */
    int count(String keyword);
}
