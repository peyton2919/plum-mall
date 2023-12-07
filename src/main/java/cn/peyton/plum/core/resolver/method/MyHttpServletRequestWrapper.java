package cn.peyton.plum.core.resolver.method;

import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

import java.io.*;
import java.nio.charset.Charset;

/**
 * <h4>自定义的HttpServletRequest，保证可以重复获取到流数据</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.core.config.base.
 * @date 2023年11月26日 18:27
 * @version 1.0.0
 * </pre>
 */
public class MyHttpServletRequestWrapper extends HttpServletRequestWrapper {
    private final byte[] body;

    public MyHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
        //在读取流之前获取一次这个parameterMap,否则读取流后无法再解析出数据,
        // 原因是org.apache.catalina.connector.Request里面有usingInputStream 和 usingReader两个全局变量记录流是否被读取过
        //org.apache.catalina.connector.Request里面的parseParameters方法就是用来解析请求参数(Parse request parameters.)
        //在解析参数之前会有一个判断,如果流被读取过 则不再解析请求参数 //
        // if (usingInputStream || usingReader) { 这是源码里面的判断
        //                success = true;
        //                return;
        //            }
        //如果先请求过一次后,那么org.apache.catalina.util.ParameterMap里面会有一个locked状态,如果读过一次之后 会变成锁定状态 那么后面再读都是读取解析过后的map
        //    /**
        //     * The current lock state of this parameter map.
        //     */
        //    private boolean locked = false;
        request.getParameterMap();
        body = ReadAsChars(request).getBytes(Charset.forName("UTF-8"));
    }
    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {

        final ByteArrayInputStream bais = new ByteArrayInputStream(body);

        return new ServletInputStream() {

            @Override
            public int read() throws IOException {
                return bais.read();
            }

            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }
        };
    }

    /**
     * 解析流
     * @param request
     * @return
     */
    public static String ReadAsChars(ServletRequest request)
    {
        InputStream is = null;
        StringBuilder sb = new StringBuilder();
        try
        {
            is = request.getInputStream();

            byte[] b = new byte[4096];
            for (int n; (n = is.read(b)) != -1;)
            {
                sb.append(new String(b, 0, n));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (null != is)
            {
                try
                {
                    is.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }
}
