package cn.peyton.plum.core.validator.strategy.design;

import cn.peyton.plum.core.utils.LogUtils;
import cn.peyton.plum.core.utils.StrUtils;
import cn.peyton.plum.core.validator.constraints.Decimal;
import cn.peyton.plum.core.validator.strategy.AbstractValidator;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * <h3>注解的元素的大小必须在指定的范围内 策略类</h3>
 * <pre>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2018/11/16 16:05
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @version 1.0.0
 * </pre>
 */
public class DecimalStrategy extends AbstractValidator {

    @Override
    public void compare(Annotation annotation, String name, String type, Object value, Map<String, String> map) {
        Decimal decimal = (Decimal) annotation;
        message = decimal.message();
        double min = decimal.min();
        double max = decimal.max();
        if (min > max) {
            map.put(name, "设置值错误,max值 要大于 min值");
            return;
        }
        if (StrUtils.isEmpty(value)) {
            if (existDecimal(type)) {
                map.put(name, "数据类型不正确");
                return;
            }
            try {
                double va = Double.valueOf(value.toString());

                if (va < min || va > max) {
                    if ("".equals(message)) {
                        message = "[校验错误: 取值范围为 " + min + " ~ " + max + " 之间]";
                    }
                    map.put(name, message);
                }
            } catch (Exception e) {
                map.put(name, "数据转换异常了!");
                LogUtils.error(e.getMessage());
            }

        }
    }
}
