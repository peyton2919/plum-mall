package cn.peyton.plum.core.validator.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * <h3>被注解的元素必须是一个将来的日期</h3>
 * <pre>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2018/11/16 16:05
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @version 1.0.0
 * </pre>
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
public @interface Future {
    /**
     * @return 错误信息提示
     */
    String message() default "日期必需是将来的日期!";

    /**
     * <h4>格式 [yyyy/MM/dd]</h4>
     * @return 时间格式
     */
    String format() default "yyyy/MM/dd";
}
