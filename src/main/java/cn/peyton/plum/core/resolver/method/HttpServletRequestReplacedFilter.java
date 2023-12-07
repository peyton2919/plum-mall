package cn.peyton.plum.core.resolver.method;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * <h4>替换掉原本的Request对象，使用自定义的</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.core.config.base.
 * @date 2023年11月26日 18:29
 * @version 1.0.0
 * </pre>
 */
@Component
public class HttpServletRequestReplacedFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ServletRequest requestWrapper = null;
        if(request instanceof HttpServletRequest) {
            requestWrapper = new MyHttpServletRequestWrapper((HttpServletRequest) request);
        }
        if(null == requestWrapper) {
            chain.doFilter(request, response);
        } else {
            chain.doFilter(requestWrapper, response);
        }
    }
}
