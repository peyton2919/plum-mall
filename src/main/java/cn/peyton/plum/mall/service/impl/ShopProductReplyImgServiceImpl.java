package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractAppRealizeService;
import cn.peyton.plum.mall.bo.ShopProductReplyImgBo;
import cn.peyton.plum.mall.mapper.ShopProductReplyImgMapper;
import cn.peyton.plum.mall.param.ShopProductReplyImgParam;
import cn.peyton.plum.mall.pojo.ShopProductReplyImg;
import cn.peyton.plum.mall.service.ShopProductReplyImgService;
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
public class ShopProductReplyImgServiceImpl extends AbstractAppRealizeService<Long, ShopProductReplyImg, ShopProductReplyImgParam> implements ShopProductReplyImgService {
    @Resource
    private ShopProductReplyImgMapper shopProductReplyImgMapper;

    @Override
    public BaseConvertBo<ShopProductReplyImg, ShopProductReplyImgParam> initBo() {
        return new ShopProductReplyImgBo();
    }

    @Override
    public IBaseMapper<Long, ShopProductReplyImg> initMapper() {
        return shopProductReplyImgMapper;
    }

}
