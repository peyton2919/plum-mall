package cn.peyton.plum.core.validator.strategy.design;

import cn.peyton.plum.core.utils.StrUtils;
import cn.peyton.plum.core.validator.constraints.NotNull;
import cn.peyton.plum.core.validator.strategy.AbstractValidator;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * <h3>注解的元素必须不为 null 策略类</h3>
 * <pre>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2018/11/16 16:05
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @version 1.0.0
 * </pre>
 */
public class NotNullStrategy extends AbstractValidator {

    @Override
    public void compare(Annotation annotation, String name, String type, Object value, Map<String, String> map) {
        NotNull notNull = (NotNull) annotation;
        message = notNull.message();
        if (!StrUtils.isNull(value)) {
            map.put(name, message);
        }
    }
}
