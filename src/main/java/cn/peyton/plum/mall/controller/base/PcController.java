package cn.peyton.plum.mall.controller.base;

import cn.peyton.plum.core.utils.HttpServletRequestUtils;
import cn.peyton.plum.core.utils.TokenUtils;
import org.springframework.stereotype.Controller;

/**
 * <h4>manager</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.mall.controller.base.
 * @date 2023年11月11日 18:56
 * @version 1.0.0
 * </pre>
 */
@Controller
public class PcController<P> implements IBaseController{
    /** Token 过期时间 1 天 */
    protected long expireTime = 24 * 60 * 60 * 1000L;

    /**
     * <h4>保存 Token</h4>
     * @param record 要保存的对象
     * @return 对象转换成加密后的字符串
     */
    protected String saveToken(P record) {
        return new TokenUtils<P>().sign(KEY_TOKEN, record, expireTime);
    }

    /**
     * <h4>获取 Token</h4>
     * @param record 保存token内的对象
     * @return null 表示 非法 token
     * @param <P>
     */
    protected <P> P handleToken(P record){
        String _tokenValue = HttpServletRequestUtils.getRequest().getHeader(ACCESS_TOKEN);
        if (null != _tokenValue){
            return new TokenUtils<P>().getObject(KEY_TOKEN, _tokenValue, record);
        }
        return null;
    }

    /**
     * <h4>验证 Token 是否合法</h4>
     * @return 返回 true 表示 没被篡改 ; false 表示 被篡改过;
     * @param <P>
     */
    protected <P> Boolean verifyToken(){
        String _tokenValue = HttpServletRequestUtils.getRequest().getHeader(ACCESS_TOKEN);
        if (null != _tokenValue){
            return new TokenUtils<P>().verify(_tokenValue);
        }
        return false;
    }

}
