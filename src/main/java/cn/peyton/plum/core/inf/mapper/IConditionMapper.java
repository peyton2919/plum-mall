package cn.peyton.plum.core.inf.mapper;

/**
 * <h4>Mapper 常用条件字段</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.core.inf.
 * @date 2024年03月13日 21:06
 * @version 1.0.0
 * </pre>
 */
public interface IConditionMapper {
    /** 等于 equal */
    String EQ = "eq";
    /** 不等于 not equal */
    String NEQ = "neq";
    /** 小于 less than */
    String LT = "lt";
    /** 大于 greater than */
    String GT = "gt";
    /**
     * 大于等于
     */
    String GEQ = "geq";
    /**
     * 小于等于
     */
    String LEQ = "leq";

    /**
     * 在什么之间
     */
    String BT = "between";
}
