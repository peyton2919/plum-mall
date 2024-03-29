package cn.peyton.plum.core.err;

import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.json.JsonMapper;
import cn.peyton.plum.core.utils.HttpServletResponseUtils;
import cn.peyton.plum.core.utils.LogUtils;

import java.io.IOException;

/**
 * <h3>验证参数 异常类</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 15:12
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public class ParamException extends RuntimeException {

    public ParamException() {
        super();
    }

    public ParamException(String message) {
        super(message);
    }

    public ParamException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParamException(Throwable cause) {
        super(cause);
    }

    /**
     * <h4>验证异常 PrintWriter 写出信息</h4>
     *
     * @param jsonResult jsonResult 对象{封装的数据}
     */
    public ParamException(JSONResult jsonResult) {
        HttpServletResponseUtils.returnJson(JsonMapper.toJSon(jsonResult));
    }

    /**
     * <h4>异常构造</h4>
     *
     * @param result 要返回的包装好的JSON数据
     * @param url    链接地址 如: /err 或 /app/add
     */
    public ParamException(JSONResult result, String url) {
        try {
            StringBuilder _sb = new StringBuilder();
            if (null != url) {
                _sb.append(url);
                if (null != result) {
                    _sb.append("?result=" + result);
                }
                HttpServletResponseUtils.getResponse().sendRedirect(_sb.toString());
            } else {
                HttpServletResponseUtils.returnJson(JsonMapper.toJSon(result));
            }
        } catch (IOException e) {
            LogUtils.error(e.getMessage());
        }
    }

}
