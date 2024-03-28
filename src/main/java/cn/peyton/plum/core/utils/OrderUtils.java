package cn.peyton.plum.core.utils;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * <h4>订单 工具类</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.core.utils.
 * @date 2024年03月18日 23:06
 * @version 1.0.0
 * </pre>
 */
public class OrderUtils implements Serializable {

    /**
     * <h4>当前时间转字符串</h4>
     * @return 字符串
     */
    public static String conventDate2Str() {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        sb.append(format.format(new Date()));
        for (int i = 0; i < 10; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
}
