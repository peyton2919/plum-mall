package cn.peyton.plum.core.inf.controller;

import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.Query;

/**
 * <h4></h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.core.inf.controller.
 * @date 2023年11月26日 8:16
 * @version 1.0.0
 * </pre>
 */
public interface IBasePCController<K,P> {
    /**
     * <h4>分页|搜索(简单)  查找全部</h4>
     * @param keyword 关键字
     * @param pageNo 分页页码数
     * @return JSONResult 包装的 对象集合
     */
    //JSONResult<?> all(String keyword,Integer pageNo);

    /**
     * <h4>分页搜索 查找全部</h4>
     * @param query 关键字 | 对象
     * @return JSONResult 包装的 对象集合
     */
    JSONResult<?> list(Query<P> query);

    /**
     * <h4>添加对象</h4>
     * @param record 添加对象
     * @return JSONResult 包装的成功与失败
     */
    JSONResult<?> create(P record);

    /**
     * <h4>编辑对象</h4>
     * @param record 编辑对象
     * @return JSONResult 包装的成功与失败
     */
    JSONResult<?> edit(P record);

    /**
     * <h4>删除对象</h4>
     * @param id 主键Id
     * @return JSONResult 包装的成功与失败
     */
    JSONResult<?> delete(K id);

}
