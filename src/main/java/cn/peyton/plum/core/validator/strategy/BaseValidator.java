package cn.peyton.plum.core.validator.strategy;

import cn.peyton.plum.core.utils.LogUtils;
import cn.peyton.plum.core.validator.constraints.Alike;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <h3>验证 类</h3>
 * <pre>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2018/11/16 16:11
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @version 1.0.0
 * </pre>
 */
@Slf4j
public final class BaseValidator implements Serializable {
    /**
     * 验证工厂对象
     */
    private ValidatorFactory factory = null;
    /**
     * 判断有没有返回错误信息 有为true
     */
    public boolean ERROR = false;

    /**
     * <h4>私有构造函数</h4>
     */
    private BaseValidator() {
    }

    /**
     * <h4>获取 基础验证 对象</h4>
     *
     * @return
     */
    public static BaseValidator getInstance() {
        return Internal.INSTANCE;
    }


    /**
     * <h4>验证全部错误</h4>
     *
     * @param obj 对象
     * @return 全部错误信息
     */
    public Map<String, String> validate(Object obj) {
        ERROR = false;
        return _validate(obj,null, false);
    }

    /**
     * <h4>验证全部错误</h4>
     *
     * @param obj 对象
     * @param ignores 排除验证的属性名称
     * @return 全部错误信息
     */
    public Map<String, String> validate(Object obj,String[] ignores) {
        ERROR = false;
        return _validate(obj,ignores, false);
    }

    /**
     * <h4>属性  验证错误</h4>
     * <pre>
     *     false表示对象全部字段, true表示单个字段[有一个错误信息就返回]
     * </pre>
     *
     * @param errMap      错误集合
     * @param annotations 注解集合
     * @param name        属性名称
     * @param type        字段类型
     * @param value       值
     * @param single      false表示对象全部字段, true表示单个字段[有一个错误信息就返回]
     */
    public void validate(Map<String, String> errMap, Annotation[] annotations,
                         String name, String type, Object value,
                         boolean single) {
        ERROR = false;
        _validate(errMap, annotations, name, type, value, single);
    }

    /**
     * <h4>属性 验证单一错误</h4>
     *
     * @param errMap      错误集合
     * @param annotations 注解集合
     * @param name        属性名称
     * @param type        字段类型
     * @param value       值
     * @return
     */
    public void validate(Map<String, String> errMap, Annotation[] annotations,
                         String name, String type, Object value) {
        ERROR = false;
        _validate(errMap, annotations, name, type, value, true);
    }

    /**
     * <h4>验证单一错误</h4>
     *
     * @param obj 对象
     * @return 单个错误信息
     */
    public Map<String, String> validateProperty(Object obj) {
        ERROR = false;
        return _validate(obj,null, true);
    }

    /**
     * <h4>验证单一错误</h4>
     *
     * @param obj     对象
     * @param ignores 排除验证的属性名称
     * @return 单个错误信息
     */
    public Map<String, String> validateProperty(Object obj, String[] ignores) {

        ERROR = false;
        return _validate(obj, ignores, true);
    }

    /**
     * <h4>验证</h4>
     *
     * @param obj    对象
     * @param single false表示对象全部字段, true表示单个字段[有一个错误信息就返回]
     * @return
     */
    private Map<String, String> _validate(Object obj, String[] ignores, boolean single) {

        Map<String, String> map = new LinkedHashMap<>();
        if (null == obj) {
            map.put("obj", "验证异常: 对象为空");
            return map;
        }
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        if (factory == null) {
            factory = ValidatorFactory.getInstance();
        }
        for (Field field : fields) {
            field.setAccessible(true);
            //判断返回全部还是单个 验证
            if (!map.isEmpty() && single) {
                break;
            }
            try {
                String name = field.getName();
                if(isIgnores(ignores,name)){continue;}
                // 获取 Field 类型名称
                String typeName = field.getType().getTypeName();

                if (typeName.contains("cn.peyton") || typeName.contains("Object")) {
                    Object childObj = field.get(obj);
                    if (null == childObj) continue;
                    objValid(childObj,ignores, map, single);
                } else if (typeName.contains("List")) {
                    List<?> list = (List<?>) field.get(obj);
                    if (null == list || list.size() == 0) continue;
                    for (Object childObj : list) {
                        objValid(childObj,ignores, map, single);

                        if (map.size() > 0) break;
                    }
                } else {
                    //获取字段类型 field.getType().getName();
                    String type = field.getGenericType().toString();
                    Object value = field.get(obj);
                    isValid(field, obj, value, name, type, map, single);
                }
            } catch (Exception e) {
                LogUtils.error(e.getMessage());
            }
            if (map.size() > 0 && single) {
                break;
            }
        }
        if (!map.isEmpty()) {
            ERROR = true;
        }
        return map;
    }

    /**
     * <h4>判断不需要验证属性名称</h4>
     * @param ignores 忽略属性集合
     * @param fieldName 属性名称
     * @return true 表示不需要验证
     */
    private Boolean isIgnores(String[] ignores, String fieldName) {
        if (null == ignores || ignores.length == 0) {return false;}
        for (int i = 0; i < ignores.length; i++) {
            if(fieldName.equals(ignores[i])){
                return true;
            }
        }
        return false;
    }

    private void objValid(Object childObj,String[] ignores,Map<String,String> map,Boolean single) throws IllegalAccessException {
        Class<?> childClazz = childObj.getClass();
        Field[] childFields = childClazz.getDeclaredFields();
        for (Field childField : childFields) {
            childField.setAccessible(true);
            String _name = childField.getName();
            if(isIgnores(ignores,_name)){continue;}

            String _type = childField.getGenericType().toString();
            Object _obj = childField.get(childObj);
            isValid(childField,childObj,_obj,_name,_type,map,single);
            if (map.size() > 0 && single) {break;}
        }
    }

    private void isValid(Field field,Object obj,Object value,String name,String simpleTypeName,
                         Map<String,String> map,Boolean single){
        Annotation[] annotations = field.getDeclaredAnnotations();
        //判断 注解类型
        for (Annotation annotation : annotations) {

            //调用工厂,返回 map 数据
            factory.valid(annotation, name, simpleTypeName, (annotation instanceof Alike ? obj : value), map);
            if (!map.isEmpty() && single) {
                break;
            }
        }
    }

    /**
     * <h4>属性  验证错误</h4>
     * <pre>
     *     false表示对象全部字段, true表示单个字段[有一个错误信息就返回]
     * </pre>
     *
     * @param errMap      错误集合
     * @param annotations 注解集合
     * @param name        属性名称
     * @param type        字段类型
     * @param value       值
     * @param single      false表示对象全部字段, true表示单个字段[有一个错误信息就返回]
     */
    private void _validate(Map<String, String> errMap, Annotation[] annotations,
                           String name, String type, Object value,
                           boolean single) {
        if (factory == null) {
            factory = ValidatorFactory.getInstance();
        }

        //判断 注解类型
        for (Annotation annotation : annotations) {
            //调用工厂,返回 map 数据
            factory.valid(annotation, name, type, value, errMap);
            if (!errMap.isEmpty() && single) {
                break;
            }
        }
        if (!errMap.isEmpty()) {
            ERROR = true;
        }
    }

    /**
     * <h3>内部类, 单例模式</h3>
     */
    private static class Internal {
        private static BaseValidator INSTANCE = new BaseValidator();
    }

}
