package cn.peyton.plum.core.resolver.data;

import cn.peyton.plum.core.anno.resolver.RequestMultiple;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.config.BeanExpressionContext;
import org.springframework.beans.factory.config.BeanExpressionResolver;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.core.MethodParameter;
import org.springframework.core.ResolvableType;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ValueConstants;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestScope;
import org.springframework.web.method.annotation.ModelFactory;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.method.annotation.ExtendedServletRequestDataBinder;
import org.springframework.web.util.WebUtils;

import java.lang.annotation.Annotation;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <h4></h4>
 * <pre>
 *     implements HandlerMethodArgumentResolver
 * </pre>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.core.resolver.data.
 * @date 2023年12月01日 8:15
 * @version 1.0.0
 * </pre>
 */
public class MyHandlerMethodArgumentResolver  {


    private static final TypeDescriptor STRING_TYPE_DESCRIPTOR = TypeDescriptor.valueOf(String.class);
    private final  boolean annotationNotRequired;
    private final ConfigurableBeanFactory configurableBeanFactory;

    private final BeanExpressionContext expressionContext;
    private final boolean useDefaultResolution;

    private Map<MethodParameter, NamedValueInfo> namedValueInfoCache = new ConcurrentHashMap<MethodParameter, NamedValueInfo>(256);

    public MyHandlerMethodArgumentResolver(ConfigurableBeanFactory beanFactory){
        this.configurableBeanFactory = beanFactory;
        this.expressionContext = (beanFactory != null ? new BeanExpressionContext(beanFactory, new RequestScope()) : null);
        this.annotationNotRequired=true;
        this.useDefaultResolution = false;

    }

    public MyHandlerMethodArgumentResolver(){
        this.annotationNotRequired=true;
        this.useDefaultResolution = false;
        this.configurableBeanFactory = null;
        this.expressionContext = null;

    }

    //@Override
    public boolean supportsParameter(MethodParameter parameter) {
        Class<?> paramType = parameter.getParameterType();
        if (parameter.hasParameterAnnotation(RequestMultiple.class)) {
            return true;
        }  else {
            if (parameter.hasParameterAnnotation(RequestPart.class)) {
                return false;
            }
            else if (MultipartFile.class.equals(paramType) || "javax.servlet.http.Part".equals(paramType.getName())) {
                return true;
            } else
                return this.useDefaultResolution && BeanUtils.isSimpleProperty(paramType);
        }
    }

    //@Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest servletRequest = webRequest.getNativeRequest(HttpServletRequest.class);
        if(servletRequest.getContentType().contains(MediaType.APPLICATION_JSON_VALUE)){
            return new JsonDataResolverUtils().bindRequestParameters(parameter, webRequest);
        }else {
            //表单
            Class<?> parameterType = parameter.getParameterType();
            if (BeanUtils.isSimpleProperty(parameterType)) {
                //如果是Map对象，调用resolveMapArgument方法
                if (Map.class.isAssignableFrom(parameter.getParameterType())) {
                    return resolveMapArgument(parameter,mavContainer,webRequest,binderFactory);
                }
                Class<?> paramType = parameter.getParameterType();
                NamedValueInfo namedValueInfo = getNamedValueInfo(parameter);

                Object arg = resolveName(namedValueInfo.name, parameter, webRequest);
                if (arg == null) {
                    if (namedValueInfo.defaultValue != null) {
                        arg = resolveDefaultValue(namedValueInfo.defaultValue);
                    }
                    else if (namedValueInfo.required && !parameter.getParameterType().getName().equals("java.util.Optional")) {
                        handleMissingValue(namedValueInfo.name, parameter);
                    }
                    arg = handleNullValue(namedValueInfo.name, arg, paramType);
                }
                else if ("".equals(arg) && namedValueInfo.defaultValue != null) {
                    arg = resolveDefaultValue(namedValueInfo.defaultValue);
                }

                if (binderFactory != null) {
                    WebDataBinder binder = binderFactory.createBinder(webRequest, null, namedValueInfo.name);
                    arg = binder.convertIfNecessary(arg, paramType, parameter);
                }
                // todo 解析值后调用
                handleResolvedValue(arg, namedValueInfo.name, parameter, mavContainer, webRequest);

                return arg;
            } else {
                String name = ModelFactory.getNameForParameter(parameter);
                Object attribute = (mavContainer.containsAttribute(name) ?
                        mavContainer.getModel().get(name) : createAttribute(name, parameter, binderFactory, webRequest));

                WebDataBinder binder = binderFactory.createBinder(webRequest, attribute, name);
                if (binder.getTarget() != null) {
                    bindRequestParameters(binder, webRequest);
                    validateIfApplicable(binder, parameter);
                    if (binder.getBindingResult().hasErrors() && isBindExceptionRequired(binder, parameter)) {
                        throw new BindException(binder.getBindingResult());
                    }
                }

                // 在模型的最后添加解析属性和BindingResult
                Map<String, Object> bindingResultModel = binder.getBindingResult().getModel();
                mavContainer.removeAttributes(bindingResultModel);
                mavContainer.addAllAttributes(bindingResultModel);
                return binder.convertIfNecessary(binder.getTarget(), parameter.getParameterType(), parameter);
            }
        }
    }

    /**
     * 解析表单
     */
    public Object resolveMapArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                     NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        Class<?> paramType = parameter.getParameterType();

        Map<String, String[]> parameterMap = webRequest.getParameterMap();
        if (MultiValueMap.class.isAssignableFrom(paramType)) {
            MultiValueMap<String, String> result = new LinkedMultiValueMap<String, String>(parameterMap.size());
            for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
                for (String value : entry.getValue()) {
                    result.add(entry.getKey(), value);
                }
            }
            return result;
        }
        else {
            Map<String, String> result = new LinkedHashMap<String, String>(parameterMap.size());
            for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
                if (entry.getValue().length > 0) {
                    result.put(entry.getKey(), entry.getValue()[0]);
                }
            }
            return result;
        }
    }

    protected Object resolveName(String name, MethodParameter parameter, NativeWebRequest webRequest) throws Exception {
        HttpServletRequest servletRequest = webRequest.getNativeRequest(HttpServletRequest.class);
        MultipartHttpServletRequest multipartRequest =
                WebUtils.getNativeRequest(servletRequest, MultipartHttpServletRequest.class);
        Object arg;

        if (MultipartFile.class.equals(parameter.getParameterType())) {
            assertIsMultipartRequest(servletRequest);
            Assert.notNull(multipartRequest, "预期的MultipartHttpServletRequest：是一个配置的多部分解析器吗");
            arg = multipartRequest.getFile(name);
        }
        else if (isMultipartFileCollection(parameter)) {
            assertIsMultipartRequest(servletRequest);
            Assert.notNull(multipartRequest, "预期的MultipartHttpServletRequest：是一个配置的多部分解析器吗");
            arg = multipartRequest.getFiles(name);
        }
        else if (isMultipartFileArray(parameter)) {
            assertIsMultipartRequest(servletRequest);
            Assert.notNull(multipartRequest, "预期的MultipartHttpServletRequest：是一个配置的多部分解析器吗");
            List<MultipartFile> multipartFiles = multipartRequest.getFiles(name);
            arg = multipartFiles.toArray(new MultipartFile[multipartFiles.size()]);
        }
        else if ("javax.servlet.http.Part".equals(parameter.getParameterType().getName())) {
            assertIsMultipartRequest(servletRequest);
            arg = servletRequest.getPart(name);
        }
        else if (isPartCollection(parameter)) {
            assertIsMultipartRequest(servletRequest);
            arg = new ArrayList<Object>(servletRequest.getParts());
        }
        else if (isPartArray(parameter)) {
            assertIsMultipartRequest(servletRequest);
            arg = RequestPartResolver.resolvePart(servletRequest);
        }
        else {
            arg = null;
            if (multipartRequest != null) {
                List<MultipartFile> files = multipartRequest.getFiles(name);
                if (!files.isEmpty()) {
                    arg = (files.size() == 1 ? files.get(0) : files);
                }
            }
            if (arg == null) {
                String[] paramValues = webRequest.getParameterValues(name);
                if (paramValues != null) {
                    arg = paramValues.length == 1 ? paramValues[0] : paramValues;
                }
            }
        }
        return arg;
    }

    /**
     * 将给定的默认值解析为参数值
     */
    private Object resolveDefaultValue(String defaultValue) {
        if (this.configurableBeanFactory == null) {
            return defaultValue;
        }
        String placeholdersResolved = this.configurableBeanFactory.resolveEmbeddedValue(defaultValue);
        BeanExpressionResolver exprResolver = this.configurableBeanFactory.getBeanExpressionResolver();
        if (exprResolver == null) {
            return defaultValue;
        }
        return exprResolver.evaluate(placeholdersResolved, this.expressionContext);
    }

    protected void handleMissingValue(String name, MethodParameter parameter) throws ServletException {
        throw new MissingServletRequestParameterException(name, parameter.getParameterType().getSimpleName());
    }

    /**
     * A {@code null} results in a {@code false} value for {@code boolean}s or an exception for other primitives.
     */
    private Object handleNullValue(String name, Object value, Class<?> paramType) {
        if (value == null) {
            if (Boolean.TYPE.equals(paramType)) {
                return Boolean.FALSE;
            }
            else if (paramType.isPrimitive()) {
                throw new IllegalStateException("包装器: [" + paramType + "] 可选 ['" + name +
                        "'] 存在，但由于被声明为原始类型，因此无法转换为空值。请考虑将其声明为相应原语类型的");
            }
        }
        return value;
    }

    /**
     * Invoked after a value is resolved.
     * @param arg the resolved argument value
     * @param name the argument name
     * @param parameter the argument parameter type
     * @param mavContainer the {@link ModelAndViewContainer}, which may be {@code null}
     * @param webRequest the current request
     */
    protected void handleResolvedValue(Object arg, String name, MethodParameter parameter,
                                       ModelAndViewContainer mavContainer, NativeWebRequest webRequest) {
        // todo
    }
    /**
     * 扩展点，如果在模型中找找到，则创建模型属性。
     * 默认的实现使用默认的构造函数。
     *
     * @param attributeName 属性的名称
     * @param methodParam   方法参数
     * @param binderFactory 用于创建WebDataBinder实例
     * @param request       当前请求
     * @return  创建的模型属性
     */
    protected Object createAttribute(String attributeName, MethodParameter methodParam,
                                     WebDataBinderFactory binderFactory, NativeWebRequest request) throws Exception {
        //todo
        return BeanUtils.instantiateClass(methodParam.getParameterType());
    }

    /**
     * <pre>
     *     验证模型属性
     *     自定义注释 Valid 开头
     * </pre>
     * @param binder 要使用的数据绑定器
     * @param methodParam 方法参数
     */
    protected void validateIfApplicable(WebDataBinder binder, MethodParameter methodParam) {
        Annotation[] annotations = methodParam.getParameterAnnotations();
        for (Annotation ann : annotations) {
            Validated validatedAnn = AnnotationUtils.getAnnotation(ann, Validated.class);
            if (validatedAnn != null || ann.annotationType().getSimpleName().startsWith("Valid")) {
                Object hints = (validatedAnn != null ? validatedAnn.value() : AnnotationUtils.getValue(ann));
                Object[] validationHints = (hints instanceof Object[] ? (Object[]) hints : new Object[]{hints});
                binder.validate(validationHints);
                break;
            }
        }
    }

    /**
     * 是否会在发生验证错误时引发致命的绑定异常。
     *
     * @param binder 用于执行数据绑定的数据绑定器
     * @param methodParam 方法参数
     * @return
     */
    protected boolean isBindExceptionRequired(WebDataBinder binder, MethodParameter methodParam) {
        int i = methodParam.getParameterIndex();
        Class<?>[] paramTypes = methodParam.getMethod().getParameterTypes();
        boolean hasBindingResult = (paramTypes.length > (i + 1) && Errors.class.isAssignableFrom(paramTypes[i + 1]));
        return !hasBindingResult;
    }


    /**
     *
     * 用于将请求绑定到目标对象的扩展点。
     * @param binder  要用于绑定的数据绑定器实例
     * @param request 当前请求
     */
    protected void bindRequestParameters(WebDataBinder binder, NativeWebRequest request) {
        HttpServletRequest servletRequest = request.getNativeRequest(HttpServletRequest.class);
        ((ExtendedServletRequestDataBinder) binder).bind(servletRequest);
    }


    private void assertIsMultipartRequest(HttpServletRequest request) {
        String contentType = request.getContentType();
        if (contentType == null || !contentType.toLowerCase().startsWith("multipart/")) {
            throw new MultipartException("The current request is not a multipart request");
        }
    }

    private boolean isMultipartFileCollection(MethodParameter parameter) {
        Class<?> collectionType = getCollectionParameterType(parameter);
        return ((collectionType != null) && collectionType.equals(MultipartFile.class));
    }

    private Class<?> getCollectionParameterType(MethodParameter parameter) {
        Class<?> paramType = parameter.getParameterType();
        if (Collection.class.equals(paramType) || List.class.isAssignableFrom(paramType)){
            Class<?> valueType = ResolvableType.forMethodParameter(parameter).asCollection().resolveGeneric();
            if (valueType != null) {
                return valueType;
            }
        }
        return null;
    }


    private boolean isPartCollection(MethodParameter parameter) {
        Class<?> collectionType = getCollectionParameterType(parameter);
        return ((collectionType != null) && "javax.servlet.http.Part".equals(collectionType.getName()));
    }

    private boolean isPartArray(MethodParameter parameter) {
        Class<?> paramType = parameter.getParameterType().getComponentType();
        return ((paramType != null) && "javax.servlet.http.Part".equals(paramType.getName()));
    }

    private boolean isMultipartFileArray(MethodParameter parameter) {
        Class<?> paramType = parameter.getParameterType().getComponentType();
        return ((paramType != null) && MultipartFile.class.equals(paramType));
    }

    private static class RequestPartResolver {

        public static Object resolvePart(HttpServletRequest servletRequest) throws Exception {
            return servletRequest.getParts().toArray(new Part[servletRequest.getParts().size()]);
        }
    }

    //-----------------------------------------------------------------------------------

    /**
     * 获取给定方法参数的命名值
     */
    private NamedValueInfo getNamedValueInfo(MethodParameter parameter) {
        NamedValueInfo namedValueInfo = this.namedValueInfoCache.get(parameter);
        if (namedValueInfo == null) {
            namedValueInfo = createNamedValueInfo(parameter);
            namedValueInfo = updateNamedValueInfo(parameter, namedValueInfo);
            this.namedValueInfoCache.put(parameter, namedValueInfo);
        }
        return namedValueInfo;
    }


    protected NamedValueInfo createNamedValueInfo(MethodParameter parameter) {
        RequestMultiple ann = parameter.getParameterAnnotation(RequestMultiple.class);
        return (ann != null ? new RequestCustomParamNamedValueInfo(ann) : new RequestCustomParamNamedValueInfo());
    }

    /**
     * 根据给定的NamedValueInfo创建一个新的NamedValueInfo，该NamedValueInfo具有经过解析的值
     */
    private NamedValueInfo updateNamedValueInfo(MethodParameter parameter, NamedValueInfo info) {
        String name = info.name;
        if (info.name.length() == 0) {
            name = parameter.getParameterName();
            if (name == null) {
                throw new IllegalArgumentException("参数类型的名称 [" + parameter.getParameterType().getName() +
                        "] 不可用，并且在类文件中也找不到参数名称信息");
            }
        }
        String defaultValue = (ValueConstants.DEFAULT_NONE.equals(info.defaultValue) ? null : info.defaultValue);
        return new NamedValueInfo(name, info.required, defaultValue);
    }


    /**
     * 内部类
     */
    private static class RequestCustomParamNamedValueInfo extends NamedValueInfo {

        public RequestCustomParamNamedValueInfo() {
            super("", false, ValueConstants.DEFAULT_NONE);
        }

        public RequestCustomParamNamedValueInfo(RequestMultiple annotation) {
            super(annotation.value(), annotation.required(), annotation.defaultValue());
        }
    }


    /**
     * 表示有关命名值的信息，包括名称、是否需要该值和默认值。
     */
    protected static class NamedValueInfo {
        private final String name;
        private final boolean required;
        private final String defaultValue;
        public NamedValueInfo(String name, boolean required, String defaultValue) {
            this.name = name;
            this.required = required;
            this.defaultValue = defaultValue;
        }
    }

    static class Props{
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

        public static final String JSONBODY_ATTRIBUTE = "JSON_REQUEST_BODY";
    }



}
