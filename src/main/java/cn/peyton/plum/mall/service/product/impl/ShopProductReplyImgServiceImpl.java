package cn.peyton.plum.mall.service.product.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.RealizeService;
import cn.peyton.plum.mall.bo.ShopProductReplyImgBo;
import cn.peyton.plum.mall.mapper.product.ShopProductReplyImgMapper;
import cn.peyton.plum.mall.param.product.ShopProductReplyImgParam;
import cn.peyton.plum.mall.pojo.product.ShopProductReplyImg;
import cn.peyton.plum.mall.service.product.ShopProductReplyImgService;
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
@Service("shopProductReplyImgService")
public class ShopProductReplyImgServiceImpl extends RealizeService<Long, ShopProductReplyImg, ShopProductReplyImgParam> implements ShopProductReplyImgService {
    @Resource
    private ShopProductReplyImgMapper shopProductReplyImgMapper;

    @Override
    public BaseConvertBo<ShopProductReplyImg, ShopProductReplyImgParam> bo() {
        return new ShopProductReplyImgBo();
    }

    @Override
    public IBaseMapper<Long, ShopProductReplyImg> mapper() {
        return shopProductReplyImgMapper;
    }

    public ShopProductReplyImgServiceImpl () {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }
}
