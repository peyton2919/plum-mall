package cn.peyton.plum.core.inf.controller;

import cn.peyton.plum.core.utils.HttpServletRequestUtils;
import cn.peyton.plum.core.utils.TokenUtils;

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

    /** Token 过期时间 30 天 */
    protected long expireTime = 30 * 24 * 60 * 60 * 1000L;

    /** 用来存储和获取 Token 的 key */
    protected String KEY_TOKEN = "GETTOKENKEYVALUE20231111";
    /** 用来存储和获取 Token 的 key */
    protected String KEY_TOKEN_ANDROID = "GETTOKENKEYVALUE2024202401250919ANDROID";
    /** Token 存放在 header 头部的 key,要与前端约定好 */
    protected String ACCESS_TOKEN = "token";


    /**
     * <h4>保存 Token</h4>
     *
     * @param record 要保存的对象
     * @return 对象转换成加密后的字符串
     */
    protected <P> String saveToken(P record) {
        return new TokenUtils<P>().sign(KEY_TOKEN, record, expireTime);
    }

    /**
     * <h4>获取 Token</h4>
     *
     * @param record 保存token内的对象
     * @return null 表示 非法 token
     */
    protected <P> P getToken(P record) {
        String _tokenValue = HttpServletRequestUtils.getRequest().getHeader(ACCESS_TOKEN);
        if (null != _tokenValue) {
            return new TokenUtils<P>().getObject(KEY_TOKEN, _tokenValue, record);
        }
        return null;
    }

    /**
     * <h4>验证 Token 是否合法</h4>
     * @param <P>
     * @return 返回 true 表示 没被篡改 ; false 表示 被篡改过;
     */
    protected <P> Boolean verifyToken() {
        String _tokenValue = HttpServletRequestUtils.getRequest().getHeader(ACCESS_TOKEN);
        if (null != _tokenValue) {
            return new TokenUtils<P>().verify(_tokenValue);
        }
        return false;
    }

    /**
     * <h4>获取网站根目录</h4>
     * @param simplePath
     * @return
     */
    protected String getSiteRootPath(String simplePath) {
        return HttpServletRequestUtils.getSiteRootPath() + simplePath;
    }

}
