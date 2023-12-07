package cn.peyton.plum.mall.service.product.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.mall.bo.ShopProductReplyBo;
import cn.peyton.plum.mall.mapper.product.ShopProductReplyMapper;
import cn.peyton.plum.mall.param.product.ShopProductReplyParam;
import cn.peyton.plum.mall.pojo.product.ShopProductReply;
import cn.peyton.plum.mall.service.product.ShopProductReplyService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

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
}
