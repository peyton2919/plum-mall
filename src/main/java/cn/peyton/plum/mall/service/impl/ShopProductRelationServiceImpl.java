package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractAppRealizeService;
import cn.peyton.plum.mall.bo.ShopProductRelationBo;
import cn.peyton.plum.mall.mapper.ShopProductRelationMapper;
import cn.peyton.plum.mall.param.ShopProductRelationParam;
import cn.peyton.plum.mall.pojo.ShopProductRelation;
import cn.peyton.plum.mall.service.ShopProductRelationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 商品点赞和收藏 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("shopProductRelationService")
public class ShopProductRelationServiceImpl extends AbstractAppRealizeService<Long, ShopProductRelation, ShopProductRelationParam> implements ShopProductRelationService {
    @Resource
    private ShopProductRelationMapper shopProductRelationMapper;

    @Override
    public BaseConvertBo<ShopProductRelation, ShopProductRelationParam> initBo() {
        return new ShopProductRelationBo();
    }

    @Override
    public IBaseMapper<Long, ShopProductRelation> initMapper() {
        return shopProductRelationMapper;
    }

}
