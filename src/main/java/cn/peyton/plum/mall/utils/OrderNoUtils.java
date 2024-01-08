package cn.peyton.plum.mall.utils;

import java.io.Serializable;
import java.util.Random;

/**
 * <h4>订单号工具类</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.mall.utils.
 * @date 2023年12月29日 16:12
 * @version 1.0.0
 * </pre>
 */
public class OrderNoUtils implements Serializable {
    /**
     * <h4>创建订单号</h4>
     * @param prefix 前缀,可以为空
     * @return 28位字符串(不含前缀)
     */
    public static String create(String prefix) {
        StringBuffer sb = new StringBuffer();
        if (null != prefix) {
            sb.append(prefix + "-");
        }
        String _tC = System.currentTimeMillis() + "";
        char[] chars = _tC.toCharArray();
        Random random = null;
        for (int i = 1; i <= chars.length; i++) {
            sb.append(chars[i-1]);
            if (i % 4 == 0) {
                random = new Random();
                sb.append(random.nextInt(10) + "-");
            }
        }
        for (int i = 0; i < 8; i++) {
            random = new Random();
            sb.append(random.nextInt(10));
            if (i==3){
                sb.append( "-");
            }
        }
        return sb.toString();
    }
}
