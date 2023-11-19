package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.mall.bo.ProvinceBo;
import cn.peyton.plum.mall.mapper.ProvinceMapper;
import cn.peyton.plum.mall.param.ProvinceParam;
import cn.peyton.plum.mall.pojo.Province;
import cn.peyton.plum.mall.service.ProvinceService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 省份 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("provinceService")
public class ProvinceServiceImpl extends AbstractRealizeService<Integer, Province, ProvinceParam> implements ProvinceService {
    @Resource
    private ProvinceMapper provinceMapper;

    @Override
    public BaseConvertBo<Province, ProvinceParam> initBo() {
        return new ProvinceBo();
    }

    @Override
    public IBaseMapper<Integer, Province> initMapper() {
        return provinceMapper;
    }

}
