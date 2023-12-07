package cn.peyton.plum.core.resolver.method;

import cn.peyton.plum.core.anno.resolver.RequestMultiple;
import cn.peyton.plum.core.utils.LogUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;
import org.springframework.web.servlet.mvc.method.annotation.ServletModelAttributeMethodProcessor;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * <h4>自己定义的参数解析器</h4>
 * <pre>
 *     参数有 RequestMultiple 注解，那么则会使用该类进行处理
 * </pre>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.core.config.base.
 * @date 2023年11月26日 17:25
 * @version 1.0.0
 * </pre>
 */
public class MyHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    /**
     * 解析Content-Type为application/json的默认解析器是RequestResponseBodyMethodProcessor
     */
    private RequestResponseBodyMethodProcessor requestResponseBodyMethodProcessor;
    public static final String JSONBODY_ATTRIBUTE = "JSON_REQUEST_BODY";
    /**
     * 解析Content-Type为application/x-www-form-urlencoded的默认解析器是ServletModelAttributeMethodProcessor
     */
    private ServletModelAttributeMethodProcessor servletModelAttributeMethodProcessor;

    public MyHandlerMethodArgumentResolver(RequestResponseBodyMethodProcessor requestResponseBodyMethodProcessor,
                                           ServletModelAttributeMethodProcessor servletModelAttributeMethodProcessor){
        this.requestResponseBodyMethodProcessor = requestResponseBodyMethodProcessor;
        this.servletModelAttributeMethodProcessor = servletModelAttributeMethodProcessor;
    }

    /**
     * 当参数前有@RequestParam注解时，会使用此 解析器
     * @param parameter the method parameter to check
     * @return 此方法的返回值将决定:是否使用此解析器解析该参数
     */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        //就是判断是否有这个注解
        return parameter.hasParameterAnnotation(RequestMultiple.class);
    }

    /**
     * 解析参数
     * 要解析的方法参数。此参数必须之前传递到必须返回
     * @param mavContainer 当前请求的模型和视图容器
     * @param webRequest 当前请求
     * @param binderFactory 一个用来创建实例的工厂
     * @return
     * @throws Exception
     */
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        final String applicationJson = MediaType.APPLICATION_JSON_VALUE;
        //final String applicationForm = MediaType.APPLICATION_FORM_URLENCODED_VALUE;
        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        Object _obj = null;
        if (null == request) {
            throw new RuntimeException("[MyHandlerMethodArgumentResolver.resolveArgument - 62 行] request 为空");
        }
        //获取参数类型
        Class<?> parameterType = parameter.getParameterType();
        // 获取内容类型
        String contentType = request.getContentType();
        if(contentType.contains(MediaType.APPLICATION_JSON_VALUE)){


        }else {

        }
        // 使用原本的策略类
        return contentType.contains(applicationJson) ? requestResponseBodyMethodProcessor.resolveArgument(parameter, mavContainer, webRequest, binderFactory)
                : servletModelAttributeMethodProcessor.resolveArgument(parameter, mavContainer, webRequest, binderFactory);
    }



    private String getRead(BufferedReader reader) {
        StringBuilder sb = new StringBuilder();
        try {
            char[] buff = new char[1024];
            int len;
            while ((len = reader.read(buff)) != -1) {
                sb.append(buff, 0, len);
            }
        } catch (IOException e) {
            LogUtils.error(e.getMessage());
        }
        return sb.toString();
    }


    @SuppressWarnings("rawtypes")
    public static boolean isBaseType(Class clazz) {
        String name =clazz.getName();
        Set<String> baseTypes = new HashSet<>();
        baseTypes.add("int");
        baseTypes.add("long");
        baseTypes.add("short");
        baseTypes.add("float");
        baseTypes.add("double");
        baseTypes.add("boolean");
        baseTypes.add("char");
        if(baseTypes.contains(name)) {
            return true;
        }else {
            return false;
        }
    }
    @SuppressWarnings("rawtypes")
    public static boolean isBasicDataTypes(Class clazz) {
        Set<Class> classSet = new HashSet<>();
        classSet.add(String.class);
        classSet.add(Integer.class);
        classSet.add(Long.class);
        classSet.add(Short.class);
        classSet.add(Float.class);
        classSet.add(Double.class);
        classSet.add(Boolean.class);
        classSet.add(Character.class);
        return classSet.contains(clazz);
    }
}
