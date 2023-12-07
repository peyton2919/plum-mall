package cn.peyton.plum.mall.service.product.impl;

import cn.peyton.plum.core.anno.timestamp.AutoWriteTimestamp;
import cn.peyton.plum.core.err.GlobalException;
import cn.peyton.plum.core.err.ValidationException;
import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.mall.bo.ShopSlideshowBo;
import cn.peyton.plum.mall.mapper.product.ShopSlideshowMapper;
import cn.peyton.plum.mall.param.product.ShopSlideshowParam;
import cn.peyton.plum.mall.pojo.product.ShopSlideshow;
import cn.peyton.plum.mall.service.product.ShopSlideshowService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public ShopSlideshowServiceImpl () {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }

    @Override
    @Transactional(rollbackFor = {ValidationException.class, GlobalException.class, RuntimeException.class, Exception.class},
            propagation = Propagation.REQUIRED)
    @AutoWriteTimestamp
    public Boolean batchInsertSelective(Long productId, List<ShopSlideshowParam> slideshows) {
        int res = shopSlideshowMapper.batchDelete(productId);
        res = shopSlideshowMapper.batchInsertSelective(initBo().reverse(slideshows));
        if (res > 0) {
            if (enabledCache) {
                System.out.println("批量添加数据,清空缓存");
                removeCache();
            }
            return true;
        }
        if (res <= 0) {
            throw new GlobalException("[ShopSlideshowServiceImpl-- 65 行] [轮播图批量插入错误!!!]");
        }
        return false;
    }
}
