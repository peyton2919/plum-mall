package cn.peyton.plum.mall.service.join.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.core.utils.LogUtils;
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
public class BrandServiceImpl extends AbstractRealizeService<Long, Brand, BrandParam>
        implements BrandService {
    private String TABLE_NAME = "tb_brand";
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

    @Override
    public Boolean upDelete(Long id) {
        int res = brandMapper.updateDeleteStatus(TABLE_NAME, id);
        if (res > 0) {
            if (enabledCache) {
                LogUtils.info("品牌删除操作清空缓存");
                removeCache();
            }
            return true;
        }
        return false;
    }

    @Override
    public List<BrandParam> findByDownList() {
        String key = keyPrefix + "_202312251339";
        if (enabledCache) {
            Object obj = cache.get(key);
            if (null != obj) {
                System.out.printf("从缓存获取到对象: key= %s;\n", key);
                return (List<BrandParam>) obj;
            }
        }
        List<BrandParam> res = initBo().adapter(brandMapper.selectByDownList());
        if (null != res && enabledCache) {
            LogUtils.info(key);
            cache.put(key, res);
        }
        return res;
    }

}
