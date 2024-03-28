package cn.peyton.plum.mall.service.product.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.RealizeService;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.utils.DateUtils;
import cn.peyton.plum.mall.bo.ShopProductReplyBo;
import cn.peyton.plum.mall.mapper.product.ShopProductReplyMapper;
import cn.peyton.plum.mall.param.product.ShopProductReplyParam;
import cn.peyton.plum.mall.pojo.product.ShopProductReply;
import cn.peyton.plum.mall.service.product.ShopProductReplyService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <h3> 商品评论 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("shopProductReplyService")
public class ShopProductReplyServiceImpl extends RealizeService<Long, ShopProductReply, ShopProductReplyParam> implements ShopProductReplyService {
    @Resource
    private ShopProductReplyMapper shopProductReplyMapper;

    @Override
    public BaseConvertBo<ShopProductReply, ShopProductReplyParam> bo() {
        return new ShopProductReplyBo();
    }

    @Override
    public IBaseMapper<Long, ShopProductReply> mapper() {
        return shopProductReplyMapper;
    }

    public ShopProductReplyServiceImpl () {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }

    @Override
    public Boolean updateIsDel(Long id) {
        if (shopProductReplyMapper.updateIsDel(id) > 0) {
            clearCache("删除商品批评");
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateReview(Long id, String content) {
        if (shopProductReplyMapper.updateReview(id, content, DateUtils.dateToTimestamp(new Date())) > 0) {
            clearCache("更新商品批评");
            return true;
        }
        return false;
    }

    @Override
    public List<ShopProductReplyParam> findByProductId(Long productId, PageQuery page,String tab) {
        String key = keyPrefix + tab + productId + keywords(null, page, false);
        Object objs = getCache(key);
        if (null == objs) {
            List<ShopProductReplyParam> adapter = bo().adapter(shopProductReplyMapper.selectByProductId(productId, page,tab));
            saveCache(key, adapter);
            return adapter;
        }
        return (List<ShopProductReplyParam>) objs;
    }

    @Override
    public int countByProductId(Long productId) {
        return shopProductReplyMapper.countByProductId(productId);
    }
}
