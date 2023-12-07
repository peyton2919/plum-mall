package cn.peyton.plum.core.resolver.data;

import cn.peyton.plum.core.anno.resolver.RequestMultiple;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.io.IOUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;

import java.io.IOException;
import java.lang.reflect.Field;

/**
 * <h4></h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.core.resolver.data.
 * @date 2023年12月01日 8:45
 * @version 1.0.0
 * </pre>
 */
public class JsonDataResolverUtils {

    public Object bindRequestParameters(MethodParameter parameter, NativeWebRequest webRequest) throws InstantiationException, IllegalAccessException {
        HttpServletRequest servletRequest = webRequest.getNativeRequest(HttpServletRequest.class);
        String jsonBody = (String) webRequest.getAttribute(MyHandlerMethodArgumentResolver.Props.JSONBODY_ATTRIBUTE, NativeWebRequest.SCOPE_REQUEST);
        // 没有就从请求中读取
        if (jsonBody == null) {
            try {
                jsonBody = IOUtils.toString(servletRequest.getReader());
                webRequest.setAttribute(MyHandlerMethodArgumentResolver.Props.JSONBODY_ATTRIBUTE, jsonBody, NativeWebRequest.SCOPE_REQUEST);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        JSONObject jsonObject = JSON.parseObject(jsonBody);


        // 根据@RequestMultiple注解value作为json解析的key
        RequestMultiple requestMultiple = parameter.getParameterAnnotation(RequestMultiple.class);
        //注解的value是JSON的key
        String key = requestMultiple.value();
        Object value = null;
        // 如果@RequestMultiple注解没有设置value，则取参数名FrameworkServlet作为json解析的key
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(key)) {
            value = jsonObject.get(key);
            // 如果设置了value但是解析不到，报错
            if (value == null) {
                if(requestMultiple.required()) {
                    throw new IllegalArgumentException(String.format("[JsonDataResolverUtils.bindRequestParameters] -- [所需参数 [%s] 不存在]", key));
                }else {
                    //如果是基本类型，直接给默认值，如果不是，继续做解析
                    Class<?> parameterType = parameter.getParameterType();
                    if (MyHandlerMethodArgumentResolver.Props.isBasicDataTypes(parameterType)||
                            MyHandlerMethodArgumentResolver.Props.isBaseType(parameterType)) {
                        value = requestMultiple.defaultValue();
                    }
                }
            }
        }else {
            // 注解为设置value则用参数名当做json的key
            key = parameter.getParameterName();
            if(jsonObject!=null) {
                value = jsonObject.get(key);
            }
            if (value == null) {
                if(requestMultiple.required()) {
                    throw new IllegalArgumentException(String.format("[JsonDataResolverUtils.bindRequestParameters] -- [所需参数 [%s] 不存在]", key));
                }else {
                    //如果是基本类型，直接给默认值，如果不是，继续做解析
                    Class<?> parameterType = parameter.getParameterType();
                    if (MyHandlerMethodArgumentResolver.Props.isBasicDataTypes(parameterType)||
                            MyHandlerMethodArgumentResolver.Props.isBaseType(parameterType)) {
                        value = requestMultiple.defaultValue();
                    }
                }
            }
        }
        Class<?> parameterType = parameter.getParameterType();
        // 通过注解的value或者参数名解析，能拿到value进行解析
        if (value != null) {
            if (MyHandlerMethodArgumentResolver.Props.isBasicDataTypes(parameterType)) {
                return value;
            }
            return JSON.parseObject(value.toString(), parameterType);
        }

        // 解析不到则将整个json串解析为当前参数类型
        if (MyHandlerMethodArgumentResolver.Props.isBasicDataTypes(parameterType)) {
            if (requestMultiple.required()) {
                throw new IllegalArgumentException(String.format("[JsonDataResolverUtils.bindRequestParameters] -- [所需参数 [%s] 不存在]", key));
            } else {
                return null;
            }
        }

        Object result = parameterType.newInstance();
        // 非基本类型，不允许解析所有字段，返回null
        if (!requestMultiple.parseAllFields()) {
            // 如果是必传参数抛异常
            if (requestMultiple.required()) {
                throw new IllegalArgumentException(String.format("[JsonDataResolverUtils.bindRequestParameters] -- [所需参数 [%s] 不存在]", key));
            }
            // 否则返回空对象
            return result;
        }
        // 非基本类型，允许解析，将外层属性解析
        result = JSON.parseObject(jsonObject.toString(), parameterType);
        // 如果非必要参数直接返回，否则如果没有一个属性有值则报错
        if (!requestMultiple.required()) {
            return result;
        }else{
            boolean haveValue = false;
            Field[] declaredFields = parameterType.getDeclaredFields();
            for(Field field : declaredFields){
                field.setAccessible(true);
                if(field.get(result) != null){
                    haveValue = true;
                    break;
                }
            }
            if(!haveValue){
                throw new IllegalArgumentException(String.format("[JsonDataResolverUtils.bindRequestParameters] -- [所需参数 [%s] 不存在]", key));
            }
            return result;
        }
    }
}
