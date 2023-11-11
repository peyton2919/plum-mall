package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractAppRealizeService;
import cn.peyton.plum.mall.bo.AdvertBo;
import cn.peyton.plum.mall.param.AdvertParam;
import cn.peyton.plum.mall.pojo.Advert;
import cn.peyton.plum.mall.service.AdvertService;
import cn.peyton.plum.mall.mapper.AdvertMapper;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;

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
public class AdvertServiceImpl extends AbstractAppRealizeService<Long, Advert, AdvertParam>
        implements AdvertService {
    @Resource
    private AdvertMapper advertMapper;

    @Override
    public BaseConvertBo<Advert, AdvertParam> initBo() {
        return new AdvertBo();
    }

    @Override
    public IBaseMapper<Long, Advert> initMapper() {
        return advertMapper;
    }
}
