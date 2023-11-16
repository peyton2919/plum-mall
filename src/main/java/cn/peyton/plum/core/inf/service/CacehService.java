package cn.peyton.plum.core.inf.service;

import cn.peyton.plum.core.cache.LocalCache;

import java.util.List;

/**
 * <h4></h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.core.inf.service.
 * @date 2023年11月16日 9:20
 * @version 1.0.0
 * </pre>
 */
public abstract class CacehService {

    private LocalCache cache = null;

    public CacehService() {
        if (null == cache) {
            cache = LocalCache.getInstance();
        }
    }

    protected <P> P  getOne(String key) {
        return (P)cache.get(key);
    }

    protected <P> void setOne(String key, P p) {
        cache.put(key, p);
    }

    protected <P> List<P> get(String key) {
        return (List<P>)cache.get(key);
    }

    protected void remove(String key) {
        cache.remove(key);
    }
}
