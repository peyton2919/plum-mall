package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.mall.bo.WechatCacheBo;
import cn.peyton.plum.mall.mapper.WechatCacheMapper;
import cn.peyton.plum.mall.param.WechatCacheParam;
import cn.peyton.plum.mall.pojo.WechatCache;
import cn.peyton.plum.mall.service.WechatCacheService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 微信缓存 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:53
 * @version 1.0.0
 * </pre>
 */
@Service("wechatCacheService")
public class WechatCacheServiceImpl extends AbstractRealizeService<String, WechatCache, WechatCacheParam> implements WechatCacheService {
    @Resource
    private WechatCacheMapper wechatCacheMapper;

    @Override
    public BaseConvertBo<WechatCache, WechatCacheParam> initBo() {
        return new WechatCacheBo();
    }

    @Override
    public IBaseMapper<String, WechatCache> initMapper() {
        return wechatCacheMapper;
    }

}
