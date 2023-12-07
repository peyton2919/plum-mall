package cn.peyton.plum.mall.service.sys.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.mall.bo.CityBo;
import cn.peyton.plum.mall.param.sys.CityParam;
import cn.peyton.plum.mall.pojo.sys.City;
import cn.peyton.plum.mall.service.sys.CityService;
import cn.peyton.plum.mall.mapper.sys.CityMapper;
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
@Service("cityService")
public class CityServiceImpl extends AbstractRealizeService<Integer, City, CityParam>
        implements CityService {
    @Resource
    private CityMapper cityMapper;

    @Override
    public BaseConvertBo<City, CityParam> initBo() {
        return new CityBo();
    }

    @Override
    public IBaseMapper<Integer, City> initMapper() {
        return cityMapper;
    }

    public CityServiceImpl () {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }
}
