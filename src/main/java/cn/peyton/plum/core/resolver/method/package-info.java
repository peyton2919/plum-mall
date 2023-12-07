/**
 * <h4>自己定义的参数解析器</h4>
 * <pre>
 *   1. RequestForm 注解;
 *   2. MyHandlerMethodArgumentResolver 自己定义的参数解析器； 标记 RequestForm 注解后,程序执行;
 *   3. ConfigArgumentResolvers 配置自定义策略类;
 *   4. MyHttpServletRequestWrapper 自定义的HttpServletRequest，保证可以重复获取到流数据;
 *   5. HttpServletRequestReplacedFilter 替换掉原本的Request对象，使用自定义的;
 * </pre>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.core.config.base.
 * @date 2023年11月26日 18:31
 * @version 1.0.0
 * </pre>
 */
package cn.peyton.plum.core.resolver.method;
/**
 * 解析Content-Type为application/json的默认解析器是RequestResponseBodyMethodProcessor
 *  private RequestResponseBodyMethodProcessor requestResponseBodyMethodProcessor;
 *
 *  解析Content-Type为application/x-www-form-urlencoded的默认解析器是ServletModelAttributeMethodProcessor
 *  private ServletModelAttributeMethodProcessor servletModelAttributeMethodProcessor;
 */