package cn.peyton.plum.core.validator.strategy;

import cn.peyton.plum.core.validator.constraints.*;

import java.lang.annotation.Annotation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <h3>注解 验证器 抽象类</h3>
 * <pre>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2018/11/16 16:11
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @version 1.0.0
 * </pre>
 */
public abstract class AbstractValidator implements IValidator {

    private final String BIG_DECIMAL = "class java.math.BigDecimal";
    private final String FLOAT = "class java.lang.Float";
    private final String DOUBLE = "class java.lang.Double";
    private final String STRING = "class java.lang.String";
    private final String _FLOAT = "float";
    private final String _DOUBLE = "double";
    private final String INTEGER = "class java.lang.Integer";
    private final String SHORT = "class java.lang.Short,short";
    private final String INT = "int";
    private final String LONG = "class java.lang.Long,long";


    /**
     * 错误信息
     */
    protected String message;

    /**
     * <h4>正则匹配[多个用','分开]</h4>
     *
     * @param value 值
     * @param rule  正则规则
     * @return 验证没通过 为 true
     */
    protected boolean regex(String value, String rule) {
        String[] splits = value.split(",");
        Pattern pattern;
        Matcher matcher;
        for (String s : splits) {
            pattern = Pattern.compile(rule);
            matcher = pattern.matcher(s.trim());
            if (!matcher.matches()) {
                return true;
            }
        }
        return false;
    }

    /**
     * <h4>判断浮点 数字 类型</h4>
     * <pre>
     *     比对 [BigDecimal , Float , Double , float , double , String]
     * </pre>
     *
     * @param type 数据 类型
     * @return true为不是浮点类型
     */
    protected boolean existDecimal(String type) {
        if (BIG_DECIMAL.contains(type) ||
                FLOAT.contains(type) ||
                DOUBLE.contains(type) ||
                _FLOAT.contains(type) ||
                _DOUBLE.contains(type) ||
                STRING.contains(type)) {
            return false;
        }
        return true;
    }

    /**
     * <h4>判断整型 数字 类型</h4>
     * <pre>
     *     比对 [Integer,Long , int , String]
     * </pre>
     *
     * @param type 数据 类型
     * @return true为不是整型类型
     */
    protected boolean existLong(String type) {
        if (INTEGER.contains(type) ||
                INT.contains(type) ||
                SHORT.contains(type) ||
                LONG.contains(type) ||
                STRING.contains(type)) {
            return false;
        }
        return true;
    }

    /**
     * <h4>时间格式化</h4>
     *
     * @param format
     * @return
     */
    protected SimpleDateFormat getDateFormat(String format) {
        return new SimpleDateFormat(format);
    }

    /**
     * <h4>获取时间 毫秒数</h4>
     *
     * @param value  时间值
     * @param format 时间格式化
     * @return
     * @throws ParseException
     */
    protected long getTimeMillis(String value, String format) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Date date = dateFormat.parse(value);
        return date.getTime();
    }

    /**
     * <h4>判断该注解是否要难证</h4>
     * @param annotations
     * @return true 为要要证
     */
    public static Boolean is(Annotation... annotations) {
        if (null != annotations && annotations.length > 0) {
            for (Annotation an : annotations) {
                if(an instanceof Alike){
                    return true;
                }else if(an instanceof AssertFalse){
                    return true;
                }else if(an instanceof AssertTrue){
                    return true;
                }else if(an instanceof Constants){
                    return true;
                }else if(an instanceof cn.peyton.plum.core.validator.constraints.Date){
                    return true;
                }else if(an instanceof Datetime){
                    return true;
                }else if(an instanceof MaxDecimal){
                    return true;
                }else if(an instanceof MinDecimal){
                    return true;
                }else if(an instanceof Email){
                    return true;
                }else if(an instanceof Future){
                    return true;
                }else if(an instanceof Length){
                    return true;
                }else if(an instanceof Max){
                    return true;
                }else if(an instanceof Min){
                    return true;
                }else if(an instanceof NotBlank){
                    return true;
                }else if(an instanceof NotNull){
                    return true;
                }else if(an instanceof Null){
                    return true;
                }else if(an instanceof Past){
                    return true;
                }else if(an instanceof cn.peyton.plum.core.validator.constraints.Pattern){
                    return true;
                }else if(an instanceof Phone){
                    return true;
                }else if(an instanceof Size){
                    return true;
                }else if(an instanceof Time){
                    return true;
                }else if(an instanceof Telephone){
                    return true;
                }
            }
        }
        return false;
    }

}
