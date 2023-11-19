package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.mall.bo.ShopSlideshowBo;
import cn.peyton.plum.mall.mapper.ShopSlideshowMapper;
import cn.peyton.plum.mall.param.ShopSlideshowParam;
import cn.peyton.plum.mall.pojo.ShopSlideshow;
import cn.peyton.plum.mall.service.ShopSlideshowService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 商品轮播图 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:53
 * @version 1.0.0
 * </pre>
 */
@Service("shopSlideshowService")
public class ShopSlideshowServiceImpl extends AbstractRealizeService<Long, ShopSlideshow, ShopSlideshowParam> implements ShopSlideshowService {
    @Resource
    private ShopSlideshowMapper shopSlideshowMapper;

    @Override
    public BaseConvertBo<ShopSlideshow, ShopSlideshowParam> initBo() {
        return new ShopSlideshowBo();
    }

    @Override
    public IBaseMapper<Long, ShopSlideshow> initMapper() {
        return shopSlideshowMapper;
    }

}
