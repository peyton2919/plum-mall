package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.pub.WechatCacheParam;
import cn.peyton.plum.mall.pojo.pub.WechatCache;

/**
 * <h3> 微信缓存 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class WechatCacheBo extends BaseConvertBo<WechatCache, WechatCacheParam> {

    @Override
    public WechatCacheParam compat(WechatCache info) {
        return new WechatCacheParam().compat(info);
    }

    @Override
    public WechatCache convert(WechatCacheParam info) {
        return info.convert();
    }
}
