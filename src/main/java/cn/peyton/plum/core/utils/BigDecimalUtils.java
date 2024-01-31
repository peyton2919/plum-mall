package cn.peyton.plum.core.utils;

import cn.peyton.plum.core.validator.Regulation;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * <h3>BigDecimal 数值工具类</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @project name: plum
 * @class name: cn.peyton.plum.controller.common.BigDecimalUtil.java
 * @create date: 2022-04-12 0:13
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public final class BigDecimalUtils implements Serializable {

    /**
     * BigDecimal 转 字符串 保留二个小数位
     *
     * @param decimal 数值
     * @return 保留二个小数位
     */
    public static String getString(BigDecimal decimal) {
        if (null == decimal) return null;

        return decimal.setScale(2, RoundingMode.HALF_UP).toString();
    }

    /**
     * 字符串 转 BigDecimal 超出返回 0.00
     *
     * @param value 值 格式：(-)1234567890.001
     * @return 保留二个小数位
     */
    public static BigDecimal getDecimal(String value) {
        if (Regulation.regex(Regulation.REGEX_DECIMAL, value)) {
            return BigDecimal.valueOf(Double.parseDouble(value))
                    .setScale(2, RoundingMode.HALF_UP);
        }
        return BigDecimal.valueOf(0.00);
    }

    /**
     * <h4>格式 BigDecimal </h4>
     *
     * @param value BigDecimal 值
     * @return 返回 BigDecimal 小数位二位
     */
    public static BigDecimal format(BigDecimal value) {
        return format(value, null);
    }

    /**
     * <h4>格式 BigDecimal </h4>
     *
     * @param value       BigDecimal 值
     * @param scaleLength 留小数位的长度
     * @return 返回 BigDecimal 小数位scaleLength
     */
    public static BigDecimal format(BigDecimal value, Integer scaleLength) {
        if (null == value || "".equals(value)) return value;
        return value.setScale((null == scaleLength) ? 2 : scaleLength, RoundingMode.HALF_UP);
    }

    /**
     * <h4>判断二个数是否相等</h4>
     * @param num1
     * @param num2
     * @return
     */
    public static boolean exist(BigDecimal num1, BigDecimal num2) {
        if (null != num1 && null != num2) {
            return num1.doubleValue() == num2.doubleValue();
        }
        return false;
    }

    /**
     * <h4>二数相加</h4>
     * @param num1
     * @param num2
     * @return
     */
    public static BigDecimal add(BigDecimal num1, BigDecimal num2) {
        if (null != num1 && null != num2) {
            return num1.add(num2);
        }
        if (null == num1 && null != num2) {
            return num2;
        }
        if (null != num1 && null == num2) {
            return num1;
        }
        return null;
    }

    /**
     * <h4>二数相减</h4>
     * @param minuend 被减数
     * @param sub 减数
     * @return
     */
    public static BigDecimal subtract(BigDecimal minuend, BigDecimal sub) {
        if (null != minuend && null != sub) {
            return minuend.subtract(sub);
        }
        if (null == minuend && null != sub) {
            minuend = new BigDecimal(0);
            return minuend.subtract(sub);
        }
        if (null != minuend && null == sub) {
            return minuend;
        }
        return null;
    }

    /**
     * <h4>二数相乘</h4>
     * @param num1
     * @param num2
     * @return
     */
    public static BigDecimal multiply(BigDecimal num1, BigDecimal num2) {
        if (null != num1 && null != num2) {
            return num1.multiply(num2);
        }
        if (null == num1 && null != num2) {
            return num2;
        }
        if (null != num1 && null == num2) {
            return num1;
        }
        return null;
    }

    /**
     * <h4>二数相乘</h4>
     * @param dividend 被除数
     * @param  divisor 除数
     * @param  scale 小数位
     * @return
     */
    public static BigDecimal divide(BigDecimal  dividend, BigDecimal divisor,int scale) {
        if (null != dividend && null != dividend) {

            return dividend.divide(divisor,scale,BigDecimal.ROUND_HALF_UP);
        }
        return null;
    }

}
