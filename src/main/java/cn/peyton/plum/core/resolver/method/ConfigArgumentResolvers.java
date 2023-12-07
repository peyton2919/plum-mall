package cn.peyton.plum.core.resolver.method;

import cn.peyton.plum.core.utils.LogUtils;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;
import org.springframework.web.servlet.mvc.method.annotation.ServletModelAttributeMethodProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 * <h4>配置自定义策略类</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.core.config.base.
 * @date 2023年11月26日 18:02
 * @version 1.0.0
 * </pre>
 */
@Configuration
public class ConfigArgumentResolvers {
    private final RequestMappingHandlerAdapter requestMappingHandlerAdapter;

    public ConfigArgumentResolvers(RequestMappingHandlerAdapter adapter) {
        this.requestMappingHandlerAdapter = adapter;
    }

    /**
     * <h4>springBoot启动的时候执行</h4>
     */
    @PostConstruct
    private void addArgumentResolvers() {
        // 获取到框架定义好的参数解析集合
        List<HandlerMethodArgumentResolver> argumentResolvers = requestMappingHandlerAdapter.getArgumentResolvers();

        MyHandlerMethodArgumentResolver myHandlerMethodArgumentResolver = getMyHandlerMethodArgumentResolver(argumentResolvers);
        // ha.getArgumentResolvers()获取到的是不可变的集合,所以我们需要新建一个集合来放置参数解析器
        List<HandlerMethodArgumentResolver> myArgumentResolvers =
                new ArrayList<>(argumentResolvers.size() + 1);
        //这里有一个注意点就是自定义的处理器需要放在RequestParamMethodArgumentResolver前面
        //为什么呢?因为如果放在它后面的话,那么它已经处理掉了,就到不了我们自己定义的策略里面去了
        //所以直接把自定义的策略放在第一个,稳妥!
        // 将自定义的解析器，放置在第一个； 并保留原来的解析器
        myArgumentResolvers.add(myHandlerMethodArgumentResolver);
        myArgumentResolvers.addAll(argumentResolvers);
        //再把新的集合设置进去
        requestMappingHandlerAdapter.setArgumentResolvers(myArgumentResolvers);
    }

    /**
     * <h4>获取MyHandlerMethodArgumentResolver实例</h4>
     * @param argumentResolvers
     * @return
     */
    private MyHandlerMethodArgumentResolver getMyHandlerMethodArgumentResolver(
            List<HandlerMethodArgumentResolver> argumentResolvers) {
        // 原本处理RequestParam的类
        //RequestParamMethodArgumentResolver resolver = null;
        // 解析Content-Type为application/json的默认解析器
        RequestResponseBodyMethodProcessor requestResponseBodyMethodProcessor = null;
        // 解析Content-Type为application/x-www-form-urlencoded的默认解析器
        ServletModelAttributeMethodProcessor servletModelAttributeMethodProcessor = null;

        if (null == argumentResolvers) {
            LogUtils.error("[ConfigArgumentResolvers.getMyHandlerMethodArgumentResolver - 69 行]: argumentResolvers 为空");
            throw new RuntimeException("[ConfigArgumentResolvers.getMyHandlerMethodArgumentResolver - 70 行]: argumentResolvers 为空");
        }
        for (HandlerMethodArgumentResolver argumentResolver : argumentResolvers) {
            if (requestResponseBodyMethodProcessor != null && servletModelAttributeMethodProcessor != null) {
                break;
            }
            if (argumentResolver instanceof RequestResponseBodyMethodProcessor) {
                requestResponseBodyMethodProcessor = (RequestResponseBodyMethodProcessor)argumentResolver;
                continue;
            }
            if (argumentResolver instanceof ServletModelAttributeMethodProcessor) {
                servletModelAttributeMethodProcessor = (ServletModelAttributeMethodProcessor)argumentResolver;
            }
        }
        if (requestResponseBodyMethodProcessor == null || servletModelAttributeMethodProcessor == null) {
            throw new RuntimeException("RequestParamMethodArgumentResolver not be null!");
        }
        //实例化自定义参数解析器
        return new MyHandlerMethodArgumentResolver(requestResponseBodyMethodProcessor,
                servletModelAttributeMethodProcessor);
    }

}
