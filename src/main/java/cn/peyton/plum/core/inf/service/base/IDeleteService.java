package cn.peyton.plum.core.inf.service.base;

/**
 * <h4>{规范} 删除基础类{更新 `is_del` = 0} 服务接口</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.core.inf.service.
 * @date 2023年12月28日 9:08
 * @version 1.0.0
 * </pre>
 */
public interface IDeleteService<K> {

    /**
     *  <h4>删除</h4>
     * @param id 对象ID
     * @return
     */
    Boolean upDelete(K id);
}
