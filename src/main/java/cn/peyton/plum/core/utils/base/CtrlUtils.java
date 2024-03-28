package cn.peyton.plum.core.utils.base;

import cn.peyton.plum.core.utils.DateUtils;
import cn.peyton.plum.core.utils.HttpServletRequestUtils;

import java.io.Serializable;

/**
 * <h4>controller 工具类</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.core.utils.base.
 * @date 2024年03月27日 23:57
 * @version 1.0.0
 * </pre>
 */
public final class CtrlUtils implements Serializable {

    /**
     * <h4>图片完整路径 转成 简单路径{储放在数据库}</h4>
     * <pre>
     *     替换网站图片根路径
     * </pre>
     * @param path 完整图片地址
     * @return 转换成以 `/images...` 开头字符串
     */
    public String convertImgPath(String path) {
        return (null != path && (!"".equals(path))) ? path.replace(HttpServletRequestUtils.getSiteRootPath(), "") : "";
    }

    /**
     * <h>字符串转成时间格式</h>
     * <pre>
     *     用在时间之间的查找
     *     字符串格式为{"2022-01-01 12:12:00,2022-01-08 15:00:00"} 或 {"2022-01-01 12:12:00"}
     * </pre>
     * @param str
     * @return
     */
    public int[] convertStrToBetweenIntArray(String str) {
        int[] times = new int[2];
        if (null != str && !"".equals(str)) {
            String[] strs = str.split(",");
            try {
                for (int i = 0; i < strs.length; i++) {
                    if (i == 2) { break;}
                    times[i] = DateUtils.dateToTimestamp(strs[i]);
                }
            } catch (Exception e) {

            }
        }
        return times;
    }

    // ----------------------------------------- 数组 转 字符串 | 字符串 转数组  ----------------------------------------- //

    /**
     * <h4>字符串转数组</h4>
     * @param arrs 字符串
     * @return
     */
    public String[] convertStrToArr(String arrs) {
        return arrs.split(",");
    }

    /**
     * <h4>字符串转数组</h4>
     * @param arrs 字符串
     * @param operate 分隔符
     * @return
     */
    public String[] convertStrToArr(String arrs,String operate) {
        return arrs.split(operate);
    }

    /**
     * <h4>数组转字符串</h4>
     * @param arrs 数组
     * @return
     */
    public String convertArrToStr(String[] arrs) {
        return convertArrToStr(arrs, ",");
    }

    /**
     * <h4>数组转字符串</h4>
     * @param arrs 数组
     * @param operate 分隔符
     * @return
     */
    public String convertArrToStr(String[] arrs,String operate) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arrs.length; i++) {
            sb.append(arrs[i]);
            if ((arrs.length - 1 != i)) {
                sb.append(operate);
            }
        }
        return sb.toString();
    }

    // ----------------------------------------- 数组 转 字符串 | 字符串 转数组  ----------------------------------------- //

}
