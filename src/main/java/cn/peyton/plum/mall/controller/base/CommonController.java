package cn.peyton.plum.mall.controller.base;

import cn.peyton.plum.core.utils.DateUtils;
import cn.peyton.plum.core.utils.HttpServletRequestUtils;

/**
 * <h4>公共方法</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.mall.controller.base.
 * @date 2024年01月26日 19:25
 * @version 1.0.0
 * </pre>
 */
public abstract class CommonController {

    /** 会员 MD5 加密 key */
    protected static String KEY_MEMBER_PASSWORD_ENCODER = "member_controller_password_202312112140";
    /** 供应商 MD5 加密 key */
    protected static String KEY_SUPPLIERS_PASSWORD_ENCODER = "suppliers_controller_password_20231226135300";
    /** 用户{管理者} MD5 加密 key */
    protected static String KEY_USER_PASSWORD_ENCODER = "userControllerPassword202312120011";

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
    public Integer[] convertStrToBetweenIntArray(String str) {
        Integer[] times = new Integer[2];
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

    /**
     * <h4>字符串转数组</h4>
     *
     * @param operate 字符串
     * @return
     */
    public String[] convertStrToArr(String operate) {
        return operate.split(",");
    }

    /**
     * <h4>数组转字符串</h4>
     *
     * @param opearate 数组
     * @return
     */
    public String convertArrToStr(String[] opearate) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < opearate.length; i++) {
            sb.append(opearate[i]);
            if ((opearate.length - 1 != i)) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
}
