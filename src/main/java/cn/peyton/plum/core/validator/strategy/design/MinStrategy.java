package cn.peyton.plum.core.validator.strategy.design;

import cn.peyton.plum.core.utils.LogUtils;
import cn.peyton.plum.core.utils.StrUtils;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.strategy.AbstractValidator;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * <h3>注解的元素是一个数字，其值必须大于等于指定的最小值 策略类</h3>
 * <pre>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2018/11/16 16:05
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @version 1.0.0
 * </pre>
 */
public class MinStrategy extends AbstractValidator {

    @Override
    public void compare(Annotation annotation, String name, String type, Object value, Map<String, String> map) {
        if (existLong(type)) {
            map.put(name, "数据类型不正确");
            return;
        }
        Min min = (Min) annotation;
        message = min.message();
        Long num = min.value();
        if (StrUtils.isEmpty(value)) {
            try {
                Long va = Long.valueOf(value.toString());
                Long temp = num.longValue();
                if (va < temp) {
                    map.put(name, message);
                }
            } catch (Exception e) {
                map.put(name, "数据转换超限!");
                LogUtils.error(e.getMessage());
            }
        }
    }
}
