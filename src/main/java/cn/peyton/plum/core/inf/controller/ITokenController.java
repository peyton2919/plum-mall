package cn.peyton.plum.core.inf.controller;

import cn.peyton.plum.core.utils.HttpServletRequestUtils;
import cn.peyton.plum.core.utils.TokenUtils;

/**
 * <h4>Token controller 操作接口</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.core.inf.controller.
 * @date 2024年02月28日 9:16
 * @version 1.0.0
 * </pre>
 */
public interface ITokenController {
    /**
     * Token 过期时间 7 天
     */
    long defaultExpireTime = 7 * 24 * 60 * 60 * 1000L;
    String defaultKey = "peytoncn20240301fuzhou";
    String ACCESS_TOKEN = "token";

    /**
     * <h4>保存 Token</h4>
     * @param record 要保存的对象
     * @return 对象转换成加密后的字符串
     */
    default <P> String save(P record) {
        return save(record, defaultExpireTime);
    }

    /**
     * <h4>保存 Token</h4>
     * @param record 要保存的对象
     * @param expireTime token 过期时间(单位: 毫秒; 1天 = [1*24*60*60*1000L])
     * @return 对象转换成加密后的字符串
     */
    default <P> String save(P record,long expireTime) {
        return save(record, defaultKey, expireTime);
    }

    /**
     * <h4>保存 Token</h4>
     * @param record 要保存的对象
     * @param key 保存的key名称
     * @return 对象转换成加密后的字符串
     * @param <P>
     */
    default <P> String save(P record, String key) {
        return save(record, key, defaultExpireTime);
    }

    /**
     * <h4>保存 Token</h4>
     * @param record 要保存的对象
     * @param key 保存的key名称
     * @param expireTime  token 过期时间(单位: 毫秒; 1天 = [1*24*60*60*1000L])
     * @return 对象转换成加密后的字符串
     * @param <P>
     */
    default <P> String save(P record, String key, long expireTime) {
        return new TokenUtils<P>().sign(key, record, expireTime);
    }

    /**
     * <h4>获取 Token</h4>
     *
     * @param record 保存token内的对象
     * @param <P>
     * @return null 表示 非法 token
     */
    default  <P> P get(P record) {
        return get(record, defaultKey);
    }

    /**
     * <h4>获取 Token</h4>
     *
     * @param record 保存token内的对象
     * @param key 保存的key名称
     * @param <P>
     * @return null 表示 非法 token
     */
    default <P> P get(P record, String key) {

        String _tokenValue = HttpServletRequestUtils.getRequest().getHeader(ACCESS_TOKEN);
        if (null != _tokenValue) {
            return new TokenUtils<P>().getObject(key, _tokenValue, record);
        }
        return null;
    }

    /**
     * <h4>获取 Token</h4>
     *
     * @param record 保存token内的对象
     * @param key 保存的key名称
     * @param tokenValue token值
     * @param <P>
     * @return null 表示 非法 token
     */
    default <P> P get(P record, String key,String tokenValue) {
        if (null != tokenValue) {
            return new TokenUtils<P>().getObject(key, tokenValue, record);
        }
        return null;
    }

    /**
     * <h4>验证 Token 是否合法</h4>
     *
     * @param <P>
     * @return 返回 true 表示 没被篡改 ; false 表示 被篡改过;
     */
    default  <P> Boolean verify() {
        String _tokenValue = HttpServletRequestUtils.getRequest().getHeader(ACCESS_TOKEN);
        if (null != _tokenValue) {
            return new TokenUtils<P>().verify(_tokenValue);
        }
        return false;
    }
}
