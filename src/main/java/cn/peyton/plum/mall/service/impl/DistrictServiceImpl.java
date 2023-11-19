package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.mall.bo.DistrictBo;
import cn.peyton.plum.mall.mapper.DistrictMapper;
import cn.peyton.plum.mall.param.DistrictParam;
import cn.peyton.plum.mall.pojo.District;
import cn.peyton.plum.mall.service.DistrictService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 行政区 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("districtService")
public class DistrictServiceImpl extends AbstractRealizeService<Integer, District, DistrictParam> implements DistrictService {
    @Resource
    private DistrictMapper districtMapper;

    @Override
    public BaseConvertBo<District, DistrictParam> initBo() {
        return new DistrictBo();
    }

    @Override
    public IBaseMapper<Integer, District> initMapper() {
        return districtMapper;
    }

}
