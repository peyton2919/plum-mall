package cn.peyton.plum.core.inf.service.base;

/**
 * <h4>{规范}更新状态 服务接口</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.core.inf.service.
 * @date 2023年12月28日 9:41
 * @version 1.0.0
 * </pre>
 */
public interface IStatusService<K> {

    /**
     * <h>更新状态</h>
     * @param id 主键Id
     * @param status 状态值
     * @return true 成功
     */
    Boolean upStatus(K id, Integer status);
}
