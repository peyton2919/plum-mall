package cn.peyton.plum.mall.service.product.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.utils.DateUtils;
import cn.peyton.plum.core.utils.LogUtils;
import cn.peyton.plum.mall.bo.ShopProductReplyBo;
import cn.peyton.plum.mall.mapper.product.ShopProductReplyMapper;
import cn.peyton.plum.mall.param.product.ShopProductReplyParam;
import cn.peyton.plum.mall.pojo.product.ShopProductReply;
import cn.peyton.plum.mall.service.product.ShopProductReplyService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class ShopProductReplyServiceImpl extends AbstractRealizeService<Long, ShopProductReply, ShopProductReplyParam> implements ShopProductReplyService {
    @Resource
    private ShopProductReplyMapper shopProductReplyMapper;

    @Override
    public BaseConvertBo<ShopProductReply, ShopProductReplyParam> initBo() {
        return new ShopProductReplyBo();
    }

    @Override
    public IBaseMapper<Long, ShopProductReply> initMapper() {
        return shopProductReplyMapper;
    }

    public ShopProductReplyServiceImpl () {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }

    @Override
    public Boolean updateIsDel(Long id) {
        if (shopProductReplyMapper.updateIsDel(id) > 0) {
            if (enabledCache) {
                System.out.println("删除操作,清空缓存");
                removeCache();
            }
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateReview(Long id, String content) {
        if (shopProductReplyMapper.updateReview(id, content, DateUtils.dateToTimestamp(new Date())) > 0) {
            if (enabledCache) {
                System.out.println("更新操作,清空缓存");
                removeCache();
            }
            return true;
        }
        return false;
    }

    @Override
    public List<ShopProductReplyParam> findByProductId(Long productId, PageQuery page,String tab) {
        String key = keyPrefix + tab + productId + createKey(null, page, false);
        if (enabledCache) {
            Object obj = cache.get(key);
            if (null != obj) {
                System.out.println("从缓存中获取数据; key =" + key);
                return (List<ShopProductReplyParam>) obj;
            }
        }
        List<ShopProductReply> result = shopProductReplyMapper.selectByProductId(productId, page,tab);
        if (null != result) {
            List<ShopProductReplyParam> adapter = initBo().adapter(result);
            if (enabledCache) {
                LogUtils.info("查找到数据,添加到缓存; key=",key);
                System.out.println("查找到数据,添加到缓存; key=" + key);
                cache.put(key,adapter);
            }
            return adapter;
        }
        return new ArrayList<>();
    }

    @Override
    public int countByProductId(Long productId) {
        return shopProductReplyMapper.countByProductId(productId);
    }
}
