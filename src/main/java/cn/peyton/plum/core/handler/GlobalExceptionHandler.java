package cn.peyton.plum.core.handler;

/**
 * <h4>全局异常处理</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.children.chatter.handler.GlobalExceptionHandler
 * @date 2023年10月05日 20:20
 * @version 1.0.0
 * </pre>
 */

import cn.peyton.plum.core.err.GlobalException;
import cn.peyton.plum.core.err.ParamException;
import cn.peyton.plum.core.err.ValidationException;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.utils.LogUtils;
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.apache.tomcat.util.http.fileupload.impl.SizeLimitExceededException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;

import javax.xml.transform.TransformerException;

@RestControllerAdvice
public class GlobalExceptionHandler {


    //public <T> JSONResult<T> handleException(Exception e){
    //    return JSONResult.fail(HttpStatusCode.FAIL, e.getMessage());
    //}

    @ExceptionHandler({ValidationException.class, GlobalException.class, TransformerException.class, ParamException.class})
    public JSONResult exceptionHandle(Exception e) {
        return JSONResult.error(JSONResult.Props.ERROR,e.getMessage());
    }

    /**
     * <h4>捕获文件上传异常</h4>
     * @param ex
     * @return
     */
    @ExceptionHandler(MultipartException.class)
    public JSONResult<?> handleBusinessException(MaxUploadSizeExceededException ex){
        String msg;
        if(ex.getCause().getCause() instanceof FileSizeLimitExceededException){
            LogUtils.error(ex.getMessage());
            msg = "单文件大小不得超过3MB";
        } else if (ex.getCause().getCause() instanceof SizeLimitExceededException) {
            LogUtils.error(ex.getMessage());
            msg = "总上传文件大小不得超过20M";
        }else {
            msg = "请检查文件类型及大小是否符合规范";
        }
        return JSONResult.error(msg);
    }
}
