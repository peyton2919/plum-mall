package cn.peyton.plum.mall.service.sys.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.mall.bo.AreaAllBo;
import cn.peyton.plum.mall.param.sys.AreaAllParam;
import cn.peyton.plum.mall.pojo.sys.AreaAll;
import cn.peyton.plum.mall.service.sys.AreaAllService;
import cn.peyton.plum.mall.mapper.sys.AreaAllMapper;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;

/**
 * <h3> 城市 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
@Service("areaAllService")
public class AreaAllServiceImpl extends AbstractRealizeService<Integer, AreaAll, AreaAllParam>
        implements AreaAllService {
    @Resource
    private AreaAllMapper areaAllMapper;

    @Override
    public BaseConvertBo<AreaAll, AreaAllParam> initBo() {
        return new AreaAllBo();
    }

    @Override
    public IBaseMapper<Integer, AreaAll> initMapper() {
        return areaAllMapper;
    }

    public AreaAllServiceImpl () {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }
}
