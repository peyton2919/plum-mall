package cn.peyton.plum.core.anno.resolver;

import org.springframework.web.bind.annotation.ValueConstants;

import java.lang.annotation.*;

/**
 * <h4>参数绑定到web请求参数的注释</h4>
 * <pre>
 *     表单提交获取不到值 时,
 * </pre>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.core.resolver.method.
 * @date 2023年11月26日 22:16
 * @version 1.0.0
 * </pre>
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestMultiple {
    /** 参数名称，默认为""，会以参数名为key */
    String value() default "";
    /** 参数是否是必填的，默认false，可以设置为true */
    boolean required() default false;
    /** 当请求参数值为空或者不存在时用作回退的默认值 */
    String defaultValue() default ValueConstants.DEFAULT_NONE;
    /** 是否解析所有参数，默认为true，主要用作解析json对象的时候是否转为java对象 */
    boolean parseAllFields() default true;
    /***/
    Class<?>[] group() default {};
}

