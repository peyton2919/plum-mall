package cn.peyton.plum.mall.service.join.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.RealizeService;
import cn.peyton.plum.mall.bo.BrandBo;
import cn.peyton.plum.mall.mapper.join.BrandMapper;
import cn.peyton.plum.mall.param.join.BrandParam;
import cn.peyton.plum.mall.pojo.join.Brand;
import cn.peyton.plum.mall.service.join.BrandService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

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
public class BrandServiceImpl extends RealizeService<Long, Brand, BrandParam>
        implements BrandService {

    private String TABLE_NAME = "tb_brand";
    @Resource
    private BrandMapper brandMapper;

    @Override
    public BaseConvertBo<Brand, BrandParam> bo() {
        return new BrandBo();
    }

    @Override
    public IBaseMapper<Long, Brand> mapper() {
        return brandMapper;
    }

    public BrandServiceImpl() {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }

    @Override
    public Boolean upDelete(Long id) {
        int res = brandMapper.updateDeleteStatus(TABLE_NAME, id);
        if (res > 0) {
            clearCache("品牌删除");
            return true;
        }
        return false;
    }

    @Override
    public List<BrandParam> findByDownList() {
        String key = keyPrefix + "_202312251339";

        if (null == getCache(key)) {
            List<BrandParam> res = bo().adapter(brandMapper.selectByDownList());
            saveCache(key, res);
            return res;
        }
        return (List<BrandParam>) getCache(key);

    }

    @Override
    public List<BrandParam> findAndroidRandom(Integer limit) {
        return bo().adapter(brandMapper.selectAndroidRandom(limit));
    }
}
