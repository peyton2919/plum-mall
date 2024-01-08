package cn.peyton.plum.core.aop.valid;

import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.utils.HttpServletRequestUtils;
import cn.peyton.plum.core.utils.LogUtils;
import cn.peyton.plum.core.utils.base.Maps;
import cn.peyton.plum.core.validator.Validation;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.strategy.AbstractValidator;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;
import java.util.Map;

/**
 * <h4>表单提交验证 aop 切面类</h4>
 * <pre>
 *     通过 @Valid 注解方式(注释在 controller 层上需要验证的方法上);
 *     配合 ValidationAspect 类 aop 切片使用;
 * </pre>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.children.chatter.aop.valid.ValidationAspect
 * @date 2023年10月08日 10:28
 * @version 1.0.0
 * </pre>
 */
@Aspect
@Component
@Slf4j
public class ValidationAspect {
    final String applicationJson = "application/json";
    final String applicationForm = "application/x-www-form-urlencoded";
    // 继续执行
    Boolean CONTINUE = true;
    /**
     * 切面点
     */
    @Pointcut("@annotation(cn.peyton.plum.core.validator.anno.Valid)")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        // 初始化数据
        MethodSignature _signature = (MethodSignature) point.getSignature();
        Method _method = _signature.getMethod();
        Object[] _args = point.getArgs();
        //获取 是否标记 @Valid 的方法 有 @Valid 注解，需要验证
        Valid _validAnnotation = _method.getAnnotation(Valid.class);
        if (null == _validAnnotation){ return point.proceed(_args);}

        HttpServletRequest _request = HttpServletRequestUtils.getRequest();
        Map<String, String> _errMap = Maps.createLinkHashMap();
        String contentType = _request.getHeader("Content-Type");

        Parameter[] _parameters = _method.getParameters();
        if (null == _parameters && _parameters.length < 1) {return point.proceed(_args);}

        //验证参数 true: 验证单个错误就返回当前错误信息; false: 验证全部完全后返回全部错误信息;
        boolean _single = _validAnnotation.single();

        if (null != contentType && contentType.contains(applicationJson)){
            if (_parameters.length == 1) {
                Parameter _pm = _parameters[0];
                String typeName = _pm.getType().getName();
                String _filedName = _pm.getName();
                Annotation[] _declareds = _pm.getDeclaredAnnotations();
                if(typeName.startsWith("cn.peyton")){// 类型验证
                    _errMap = Validation.valid(_args[0],_validAnnotation.ignore(), _single);
                }else if (AbstractValidator.is(_declareds)&&HttpServletRequestUtils.isBaseType(typeName)){
                    if (null != _declareds && _declareds.length > 0) {
                        // 判断基础类型数据
                        Validation.valid(_errMap, _declareds, _filedName, typeName, _args[0], _single);
                    }
                } else if (typeName.contains("List") || typeName.contains("[]")) {
                    List<?> _ls = (List<?>) _args[0];
                    if (null != _ls && _ls.size() > 0) {
                        for (Object _obj : _ls) {
                            _errMap = Validation.valid(_obj, _validAnnotation.ignore(), _single);
                            //Validation.valid(_errMap, _declareds, _filedName, typeName, _obj, _single);
                            if (_errMap.size() > 0) { break;}
                        }
                    }
                }
            }else {
                for (int i = 0; i < _parameters.length; i++) {
                    //Parameter _pm = _parameters[i];
                    if(null== _args[i]) continue;
                    String typeName = _parameters[i].getType().getName();
                    String _filedName = _parameters[i].getName();
                    Annotation[] _declareds = _parameters[i].getDeclaredAnnotations();
                    if(typeName.startsWith("cn.peyton")){// 类型验证
                        _errMap = Validation.valid(_args[i],_validAnnotation.ignore(), _single);
                    }else if (AbstractValidator.is(_declareds)&&HttpServletRequestUtils.isBaseType(typeName)){
                        if (null != _declareds && _declareds.length > 0) {
                            // 判断基础类型数据
                            Validation.valid(_errMap, _declareds, _filedName, typeName, _args[i], _single);
                        }
                    } else if (typeName.contains("List") || typeName.contains("[]")) {

                        List<?> _ls = (List<?>) _args[i];
                        if (null != _ls && _ls.size() > 0) {
                            for (Object _obj : _ls) {

                                //Validation.valid(_errMap, _declareds, _filedName, typeName, _obj, _single);
                                _errMap = Validation.valid(_obj, _validAnnotation.ignore(), _single);
                                if (_errMap.size() > 0) { break;}
                            }
                        }
                    }
                }
            }

        } else{ // 表单验证逻辑
            // 判断逻辑
            for (Parameter _pm : _parameters) {
                // Java 基础属性验证方法
                String _typeName = _pm.getType().getName();
                //String simpleName = _pm.getType().getSimpleName();
                // 去除不要request,response,session
                if (HttpServletRequestUtils.isExclude(_typeName)) {continue;}
                _errMap = formValidChecked(_pm,_validAnnotation.ignore(),_typeName,_single,_request);
                //_single 为 true 时表示单一验证，有一个验证不通过就直接跳出
                if (_single && _errMap.size() > 0) { break; }
            }
        }
        if (null != _errMap && _errMap.size() > 0) {
            return JSONResult.fail(JSONResult.Props.VALIDATE, _errMap);
        }

        return point.proceed(_args);
    }

    /**
     * <h4>Form 表单验证</h4>
     * @param parameter
     * @param ignores
     * @param typeName
     * @param single
     * @param request
     * @throws Throwable
     */
    private Map<String, String> formValidChecked(Parameter parameter,String[] ignores,String typeName,Boolean single,
                                    HttpServletRequest request) throws Throwable {
        Map<String, String> _errMap = Maps.createLinkHashMap();
        Map<String, String[]> _parameterValueMap = request.getParameterMap();
        if (typeName.contains("cn.peyton")) { // 验证 对象
            //调用赋值方法: HttpServletRequestUtil.voluation，并验证方法: Validation.valid
            _errMap = Validation.valid(HttpServletRequestUtils.voluation(_parameterValueMap, typeName),ignores, single);
        } else {  // list map 数组 基础类型
            Annotation[] _declareds = parameter.getDeclaredAnnotations();
            //判断属性上是否有注解, 有标记注解 为 true
            if (null != _declareds && _declareds.length > 0 && AbstractValidator.is(_declareds)) {
                String _filedName = parameter.getName();
                if (HttpServletRequestUtils.isBaseType(typeName)) {// 验证基础 类型
                    Object[] _ps = _parameterValueMap.get(_filedName);
                    Object _val = null;
                    if (null != _ps && _ps.length > 0) {_val = _ps[0];}
                    Validation.valid(_errMap, _declareds, _filedName, typeName, _val, single);
                } else if (typeName.contains("Map")) {
                    LogUtils.info("Map验证方法没写...");
                    System.out.println("Map验证方法没写...");
                } else if (typeName.contains("[]") || typeName.contains("List")) {
                    Object[] _ps = _parameterValueMap.get(_filedName + "[]");
                    if (null != _ps && _ps.length > 0) {
                        for (Object _obj : _ps) {
                            _errMap = Validation.valid(_obj, ignores, single);
                            //Validation.valid(_errMap, _declareds, _filedName, typeName, _obj, single);
                            if (single && _errMap.size() > 0) { break; }
                        }
                    }
                }
            }
        }
        return _errMap;
    }

    /**
     * <h4>json 验证</h4>
     * @param parameter
     * @param typeName
     * @param single
     * @param errMap
     * @param request
     * @throws Throwable
     */
    private void jsonValidChecked(Parameter parameter, Object[] _args,String typeName,Boolean single, Map<String, String> errMap,
                                  HttpServletRequest request) throws Throwable {


        //
        //String _filedName = parameter.getName();
        //if (typeName.contains("cn.peyton")) { // 验证 对象
        //    //调用赋值方法: HttpServletRequestUtil.voluation，并验证方法: Validation.valid
        //    errMap = Validation.valid(_args[_filedName], single);
        //} else {  // list map 数组 基础类型
        //    Annotation[] _declareds = parameter.getDeclaredAnnotations();
        //    //判断属性上是否有注解, 有标记注解 为 true
        //    if (null != _declareds && _declareds.length > 0 && Validation.is(_declareds)) {
        //
        //        Object _val = null;
        //        if (HttpServletRequestUtils.isBaseType(typeName)) {// 验证基础 类型
        //            Validation.valid(errMap, _declareds, _filedName, typeName, _tmpJsonMap.get(_filedName), single);
        //        } else if (typeName.contains("Map")) {
        //            LogUtils.info("Map验证方法没写...");
        //            System.out.println("Map验证方法没写...");
        //        } else if (typeName.contains("[]") || typeName.contains("List")) {
        //            Collection _ps = (Collection) _tmpJsonMap.get(_filedName);
        //            if (null != _ps) {
        //                for (Object _obj : _ps) {
        //                    Validation.valid(errMap, _declareds, _filedName, typeName, _obj, single);
        //                }
        //            }
        //        }
        //    }
        //}
    }

    /**
     * <h4>表单参数校验</h4>
     * @return
     */
    private Object formFaramChecked(Parameter[] parameters, Map<String,
            String[]> parameterMap, Map<String, String> errMap) throws Throwable {
        // 验证参数合法性(处理普通类型数据Integer,Long,float,Double等)对象不做验证
        for (Parameter _pm : parameters) {
            String _typeName = _pm.getType().getTypeName();
            //判断如果是 对象类型 这个拦截器则暂时不做处理
            if (!HttpServletRequestUtils.isBaseType(_typeName)) {
                continue;
            }
            String _filedName = _pm.getName();
            String[] _ps = parameterMap.get(_filedName);
            if (null == _ps || "".equals(_ps[0]) || "undefined".equals(_ps[0])) {
                Annotation[] _declareds = _pm.getDeclaredAnnotations();
                //判断属性上是否有注解, 有标记注解 为 true
                if (null != _declareds && _declareds.length > 0) {
                    Validation.valid(errMap, _declareds, _filedName, _typeName, (null == _ps ? null : _ps[0]), true);
                }
                if (null != errMap && errMap.size() > 0) {
                    return JSONResult.error(JSONResult.Props.VALIDATE, errMap);
                }
            }
        }
        return null;
    }

    /**
     * <h4>application/json 读取流</h4>
     * @param reader
     * @return
     */
    private String getRead(BufferedReader reader) {
        StringBuilder sb = new StringBuilder();
        try {
            char[] buff = new char[1024];
            int len;
            while ((len = reader.read(buff)) != -1) {
                sb.append(buff, 0, len);
            }
        } catch (IOException e) {
            LogUtils.error(e.getMessage());
        }
        return sb.toString();
    }
}

// 写到页面
//HttpServletResponseTools.returnJson(
//        response, JsonMapper.toJSon(JSONResult.error(HttpStatusCode.get(HttpStatusCode.ERR_VALID.getCode()),_errMap)));
//String _errMsg = "参数名称: [" + _filedName + "]不能为空值;";
// HttpServletResponseTools.returnJson(response
//        , JsonMapper.toJSon(JSONResult.fail(HttpStatusCode.FAIL.getCode(), _errMsg, null, response.getStatus())));
//return JSONResult.fail(ResponseStatus.VALIDATE_FAIL.getCode(), _errMsg, null, _response.getStatus());
