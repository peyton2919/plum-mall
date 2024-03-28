package cn.peyton.plum.core.inf.service.base;

import java.util.List;

/**
 * <h4>{规范}下拉框列表 服务接口</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.core.inf.service.
 * @date 2023年12月28日 9:45
 * @version 1.0.0
 * </pre>
 */
public interface IDownListService<P> {
    /**
     * <h4>下拉框查找</h4>
     * <pre>
     *     用于下拉框使用
     * </pre>
     * @return 对象集合
     */
    List<P> findByDownList();
}
