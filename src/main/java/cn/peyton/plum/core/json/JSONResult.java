package cn.peyton.plum.core.json;

import cn.peyton.plum.core.page.ResponseStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * <h3>自定义响应数据数据结构,保证序列化json时，如果是null对象，key也会消失</h3>
 * <pre>
 *     主要用到 3 个字段:
 *          code:   状态码, 用来标识成功还是失败;
 *          msg:    消息, 返回时带回的消息;
 *          data:    返回后带回的数据；
 *
 *      需要扩展用到以下 3 个字段:
 *          expand:     需要带回的扩展数据;
 *          errorCode:  扩展的异常状态码;
 *          httpStatusCode:     需要带回的 response 带的状态码; 默认为 `-1`
 * </pre>
 *
 * <pre>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date: 2021/10/31 23:36
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @version 1.0.0
 * </pre>
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public final class JSONResult<T> implements Serializable {

    //private final static Integer SUCCESS = 200;
    //private final static Integer FAIL = 600;
    //private final static Integer ERROR = 700;

    /**
     * <pre>
     *     自定义的状态码
     *  状态码: 200 成功, 700 失败 , 800 异常
     * </pre>
     */
    private Integer code;
    /**
     * 消息
     */
    private String msg = "数据请求成功;";
    /**
     * 成功时要返回的数据
     */
    private T data;
    /**
     * 扩展数据
     */
    private Object expand;
    /**
     * 异常错误码 (定制扩展异常码)
     */
    private Integer errorCode;
    /**
     * response 带的状态码
     */
    private Integer httpStatusCode = -1;



    // ====================================== external method begin ====================================== //

    /**
     * <h4>成功</h4>
     *
     * @param <T> 申明泛型数据类型
     * @return JSONResult对象
     */
    public static <T> JSONResult<T> success() {
        return new JSONResult<T>(Props.SUCCESS, null, null, null, null, null);
    }

    /**
     * <h4>成功</h4>
     *
     * @param msg 消息
     * @param <T> 申明泛型数据类型
     * @return JSONResult对象
     */
    public static <T> JSONResult<T> success(String msg) {
        return new JSONResult<T>(Props.SUCCESS, msg, null, null, null, null);
    }

    /**
     * <h4>成功</h4>
     *
     * @param data 成功时要返回的数据
     * @param <T>  申明泛型数据类型
     * @return JSONResult对象
     */
    public static <T> JSONResult<T> success(T data) {
        return new JSONResult<T>(Props.SUCCESS, null, data, null, null, null);
    }

    /**
     * <h4>成功</h4>
     *
     * @param msg  消息
     * @param data 成功时要返回的数据
     * @param <T>  申明泛型数据类型
     * @return JSONResult对象
     */
    public static <T> JSONResult<T> success(String msg, T data) {
        return new JSONResult<T>(Props.SUCCESS, msg, data, null, null, null);
    }

    /**
     * <h4>成功{带回扩展数据}</h4>
     *
     * @param expand 扩展数据
     * @param msg    消息
     * @return JSONResult对象
     */
    public static <T> JSONResult<T> success(String msg, T data, Object expand) {
        return new JSONResult(Props.SUCCESS, msg, data, expand, null, null);
    }

    /**
     * <h4>成功{带回扩展数据}| 带回错误码</h4>
     * @param msg 消息
     * @param data 成功时要返回的数据
     * @param expand 扩展数据
     * @param errorCode 自定义状态码
     * @return JSONResult对象
     * @param <T>
     */
    public static <T> JSONResult<T> success(String msg, T data, Object expand,int errorCode) {
        return new JSONResult(Props.SUCCESS, msg, data, expand, errorCode, null);
    }

    // -----------------------------------------> fail begin <-----------------------------------------

    /**
     * <h4>错误</h4>
     *
     * @param msg 消息
     * @param <T> 申明泛型数据类型
     * @return JSONResult对象
     */
    public static <T> JSONResult<T> fail(String msg) {
        return new JSONResult<T>
                (Props.FAIL, msg, null, null, null, null);
    }

    /**
     * <h4>错误</h4>
     *
     * @param code 状态码
     * @param msg  消息
     * @param <T>  申明泛型数据类型
     * @return JSONResult对象
     */
    public static <T> JSONResult<T> fail(Integer code, String msg) {
        return new JSONResult<T>(code, msg, null, null, code, null);
    }

    /**
     * <h4>错误</h4>
     *
     * @param rs 状态码对象
     * @return JSONResult对象
     */
    public static <T> JSONResult fail(ResponseStatus rs) {
        return new JSONResult<T>(Props.FAIL, rs.getMsg(), null, null, rs.getCode(), null);
    }

    /**
     * <h4>错误</h4>
     *
     * @param rs   状态码对象
     * @param data 错误后要带回的数据
     * @return JSONResult对象
     */
    public static <T> JSONResult fail(ResponseStatus rs, T data) {
        return new JSONResult<T>(Props.FAIL, rs.getMsg(), data, null, rs.getCode(), null);
    }

    /**
     * <h4>错误</h4>
     *
     * @param code 状态码
     * @param data 错误后要带回的数据
     * @return JSONResult对象
     */
    public static <T> JSONResult fail(Integer code, T data) {
        return new JSONResult<T>(Props.FAIL, null, data, null, code, null);
    }

    /**
     * <h4>错误</h4>
     * @param expand         扩展自定对象
     * @param msg            消息
     * @param errorCode      自定义状态码
     * @param <T>            T 对象
     * @return JSONResult对象
     */
    public static <T> JSONResult<T> fail(Object expand, String msg, Integer errorCode) {
        return new JSONResult<T>(Props.FAIL, msg, null, expand, errorCode, null);
    }

    /**
     * <h4>错误</h4>
     *
     * @param code 状态码
     * @param msg  消息
     * @param data 错误后要带回的数据
     * @return JSONResult对象
     */
    public static <T> JSONResult fail(Integer code, String msg, T data) {
        return new JSONResult<T>(Props.FAIL, msg, data, null, code, null);
    }

    /**
     * <h4>错误</h4>
     *
     * @param code           状态码
     * @param msg            消息
     * @param data           错误后要带回的数据
     * @param httpStatusCode response 状态码
     * @return JSONResult对象
     */
    public static <T> JSONResult fail(Integer code, String msg, T data, Integer httpStatusCode) {
        return new JSONResult<T>(Props.FAIL, msg, data, null, code, httpStatusCode);
    }

    /**
     * <h4>错误</h4>
     *
     * @param msg            消息
     * @param data           错误后要带回的数据
     * @param errorCode      自定义状态码
     * @param expand         扩展自定对象
     * @param httpStatusCode response 状态码
     * @param <T>            T 对象
     * @return JSONResult对象
     */
    public static <T> JSONResult<T> fail(String msg, T data, Integer errorCode, Object expand, Integer httpStatusCode) {
        return new JSONResult<T>(Props.FAIL, msg, data, expand, errorCode, httpStatusCode);
    }

    // -----------------------------------------> fail end <-----------------------------------------

    // -----------------------------------------> error begin <-----------------------------------------

    /**
     * <h4>异常</h4>
     *
     * @param msg 消息
     * @param <T> 申明泛型数据类型
     * @return JSONResult对象
     */
    public static <T> JSONResult<T> error(String msg) {
        return new JSONResult<T>(Props.ERROR, msg, null, null, null, null);
    }

    /**
     * <h4>异常</h4>
     *
     * @param code 状态码
     * @param msg  消息
     * @param <T>  申明泛型数据类型
     * @return JSONResult对象
     */
    public static <T> JSONResult<T> error(Integer code, String msg) {
        return new JSONResult<T>(Props.ERROR, msg, null, null, code, null);
    }

    /**
     * <h4>异常</h4>
     *
     * @param rs   状态码对象
     * @param data 错误后要带回的数据
     * @return JSONResult对象
     */
    public static <T> JSONResult error(ResponseStatus rs, T data) {
        return new JSONResult<T>(Props.ERROR, rs.getMsg(), data, null, rs.getCode(), null);
    }

    /**
     * <h4>异常</h4>
     *
     * @param code 状态码
     * @param data 错误后要带回的数据
     * @return JSONResult对象
     */
    public static <T> JSONResult error(Integer code, T data) {
        return new JSONResult<T>(Props.ERROR, null, data, null, code, null);
    }

    /**
     * <h4>异常</h4>
     *
     * @param code 状态码
     * @param msg  消息
     * @param data 错误后要带回的数据
     * @return JSONResult对象
     */
    public static <T> JSONResult error(Integer code, String msg, T data) {
        return new JSONResult<T>(Props.ERROR, msg, data, null, code, null);
    }

    /**
     * <h4>异常</h4>
     *
     * @param msg            消息
     * @param data           错误后要带回的数据
     * @param errorCode      自定义状态码
     * @param expand         扩展自定对象
     * @param httpStatusCode response 状态码
     * @param <T>            T 对象
     * @return JSONResult对象
     */
    public static <T> JSONResult<T> error(String msg, T data, Integer errorCode, Object expand, Integer httpStatusCode) {
        return new JSONResult<T>(Props.ERROR, msg, data, expand, errorCode, httpStatusCode);
    }
    // -----------------------------------------> error end <-----------------------------------------

    // ====================================== external method end ====================================== //

    // ====================================== Get and Set begin ====================================== //

    /**
     * @return 自定义状态码: 200 成功, 700 失败 , 800 异常
     */
    public Integer getCode() {
        return code;
    }

    /**
     * @return 消息
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @return 成功时要返回的数据
     */
    public T getData() {
        return data;
    }

    /**
     * @param code 自定义 状态码: 200 成功, 700 失败 , 800 异常
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * @param msg 消息
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @param data 成功时要返回的数据
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * @return 扩展数据
     */
    public Object getExpand() {
        return expand;
    }

    /**
     * @param expand 扩展数据
     */
    public void setExpand(Object expand) {
        this.expand = expand;
    }

    /**
     * @return 异常错误码
     */
    public Integer getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode 异常错误码
     */
    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * @return response 带的状态码
     */
    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }

    /**
     * @param httpStatusCode response 带的状态码
     */
    public void setHttpStatusCode(Integer httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    // ====================================== Get and Set end ====================================== //

    // ====================================== private constructor begin ====================================== //

    /**
     * 构造函数
     */
    public JSONResult() {
    }

    /**
     * 构造函数
     */
    private JSONResult(Integer code, String msg, T data,
                       Object expand, Integer errorCode, Integer httpStatusCode) {
        this.code = code;
        if (null != data) {
            this.data = data;
        }
        if (null != msg) {
            this.msg = msg;
        }
        if (null != errorCode) {
            this.errorCode = errorCode;
        }
        if (null != expand) {
            this.expand = expand;
        }
        if (null != httpStatusCode) {
            this.httpStatusCode = httpStatusCode;
        }
    }

    /**
     * <h4>判断是否成功</h4>
     *
     * @return 成功true
     */
    @JsonIgnore //使之不在json序列化结果当中
    public boolean isSuccess() {
        return this.code == Props.SUCCESS;
    }

    /**
     * <h4>数据封装到Map</h4>
     *
     * @return Map<String, Object>对象
     */
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("code", code);
        result.put("msg", msg);
        result.put("data", data);
        result.put("expand", expand);
        result.put("errorCode", errorCode);
        result.put("httpStatusCode", httpStatusCode);
        return result;
    }

    // ====================================== private constructor end ====================================== //
    public interface Props{
        /** 成功码 200 */
        int SUCCESS = 200;
        /** 通用错误码 600 */
        int FAIL = 600;
        /** 没找到数据 601 */
        int NO_DATA = 601;
        /** 参数错误 602 */
        int PARAMETER = 602;
        /** 验证错误 603 */
        int VALIDATE = 603;
        /** 拦截器错误 604 */
        int INTERCEPTOR = 604;
        /** 请求的资源找不到 605 */
        int NOT_FOUND = 605;
        /** 无权限访问 606  */
        int FORBIDDEN = 606;
        /** 你已经退出登录 608  */
        int DROP_OUT = 607;
        /** 需要登录 608  */
        int NEED_LOGIN = 608;
        /** 请勿重复操作 609  */
        int NOT_REPEAT_OPERATION = 609;
        /** 绑定类型冲突 610  */
        int BINDING_TYPE_CONFLICT = 610;
        /** 请求的数据格式不符 611  */
        int BAD_REQUEST = 611;
        /** 事务异常 612  */
        int TRANSACTIONAL = 612;

        /** 异常 900 */
        int ERROR = 900;
        /** 未知异常 */
        int UNKNOWN = 901;

        /** 非法token 801 */
        int TOKEN_ILLEGAL = 801;
        /** token 过期 802 */
        int TOKEN_EXPIRE = 802;

    }
}
