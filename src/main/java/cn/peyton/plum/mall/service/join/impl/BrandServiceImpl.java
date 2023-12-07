package cn.peyton.plum.mall.service.join.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.mall.bo.BrandBo;
import cn.peyton.plum.mall.param.join.BrandParam;
import cn.peyton.plum.mall.pojo.join.Brand;
import cn.peyton.plum.mall.service.join.BrandService;
import cn.peyton.plum.mall.mapper.join.BrandMapper;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;

/**
 * <h3> 品牌 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
@Service("brandService")
public class BrandServiceImpl extends AbstractRealizeService<Long, Brand, BrandParam>
        implements BrandService {
    @Resource
    private BrandMapper brandMapper;

    @Override
    public BaseConvertBo<Brand, BrandParam> initBo() {
        return new BrandBo();
    }

    @Override
    public IBaseMapper<Long, Brand> initMapper() {
        return brandMapper;
    }

    public BrandServiceImpl() {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }
}
