package cn.peyton.plum.mall.service.product.impl;

import cn.peyton.plum.core.anno.timestamp.AutoWriteTimestamp;
import cn.peyton.plum.core.err.TransactionalException;
import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.RealizeService;
import cn.peyton.plum.core.utils.base.CtrlUtils;
import cn.peyton.plum.mall.bo.ShopSlideshowBo;
import cn.peyton.plum.mall.mapper.product.ShopProductMapper;
import cn.peyton.plum.mall.mapper.product.ShopSlideshowMapper;
import cn.peyton.plum.mall.param.product.ShopSlideshowParam;
import cn.peyton.plum.mall.pojo.product.ShopSlideshow;
import cn.peyton.plum.mall.service.product.ShopSlideshowService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
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
public class ShopSlideshowServiceImpl extends RealizeService<Long, ShopSlideshow, ShopSlideshowParam> implements ShopSlideshowService {
    @Resource
    private ShopSlideshowMapper shopSlideshowMapper;
    @Resource
    private ShopProductMapper shopProductMapper;

    @Override
    public BaseConvertBo<ShopSlideshow, ShopSlideshowParam> bo() {
        return new ShopSlideshowBo();
    }

    @Override
    public IBaseMapper<Long, ShopSlideshow> mapper() {
        return shopSlideshowMapper;
    }

    public ShopSlideshowServiceImpl () {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }

    @Override
    @Transactional(rollbackFor = TransactionalException.class)
    @AutoWriteTimestamp
    public Boolean batchInsertSelective(Long productId, List<ShopSlideshowParam> slideshows,Boolean bool) {
        int res = 0;
        if(!bool){ // 新增才更新 商品信息
            String operate = shopProductMapper.selectByOperate(productId);
            String[] strs = operate.split(",");
            strs[1] = "1";
            shopProductMapper.updateOperate(productId, new CtrlUtils().convertArrToStr(strs));
        }else {
            res= shopSlideshowMapper.batchDelete(productId);
        }
        res = shopSlideshowMapper.batchInsertSelective(bo().reverse(slideshows));

        if (res > 0) {
            clearCache("批量新增规格");
            return true;
        }
        return false;
    }
}
