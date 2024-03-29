package cn.peyton.plum.mall.service.pub.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.RealizeService;
import cn.peyton.plum.mall.bo.AdvertBo;
import cn.peyton.plum.mall.mapper.pub.AdvertMapper;
import cn.peyton.plum.mall.param.pub.AdvertParam;
import cn.peyton.plum.mall.pojo.pub.Advert;
import cn.peyton.plum.mall.service.pub.AdvertService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h3> 广告信息 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
@Service("advertService")
public class AdvertServiceImpl extends RealizeService<Long, Advert, AdvertParam>
        implements AdvertService {
    private String TABLE_NAME = "tb_advert";

    @Resource
    private AdvertMapper advertMapper;

    @Override
    public BaseConvertBo<Advert, AdvertParam> bo() {
        return new AdvertBo();
    }

    @Override
    public IBaseMapper<Long, Advert> mapper() {
        return advertMapper;
    }

    public AdvertServiceImpl () {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }

    @Override
    public Boolean upDelete(Long id) {
        int res = advertMapper.updateDeleteStatus(TABLE_NAME,id);
        if (res > 0) {
            clearCache("删除广告");
            return true;
        }
        return false;
    }

    @Override
    public AdvertParam findByOne() {
        Advert advert = advertMapper.selectByOne();
        if (null != advert) {
           return bo().compat(advert);
        }
        return null;
    }

    @Override
    public List<AdvertParam> findByThree() {
        List<Advert> adverts = advertMapper.selectByThree();
        if (null != adverts && adverts.size() > 0) {
            return bo().adapter(adverts);
        }
        return null;
    }

    @Override
    public List<AdvertParam> findBySwiperAndNav(Integer imgType, Integer limit) {
        List<Advert> adverts = advertMapper.selectBySwiperAndNav(imgType, limit);
        if (null != adverts && adverts.size() > 0) {
            return bo().adapter(adverts);
        }
        return null;
    }
}
