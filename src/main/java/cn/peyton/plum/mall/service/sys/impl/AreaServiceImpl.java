package cn.peyton.plum.mall.service.sys.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.mall.bo.AreaBo;
import cn.peyton.plum.mall.mapper.sys.AreaMapper;
import cn.peyton.plum.mall.param.sys.AreaParam;
import cn.peyton.plum.mall.pojo.sys.Area;
import cn.peyton.plum.mall.service.sys.AreaService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


/**
 * <h3> 全部区域 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
@Service("areaService")
public class AreaServiceImpl extends AbstractRealizeService<Long, Area, AreaParam>
        implements AreaService {
    @Resource
    private AreaMapper areaMapper;

    @Override
    public BaseConvertBo<Area, AreaParam> initBo() {
        return new AreaBo();
    }

    @Override
    public IBaseMapper<Long, Area> initMapper() {
        return areaMapper;
    }

    public AreaServiceImpl () {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }
}
