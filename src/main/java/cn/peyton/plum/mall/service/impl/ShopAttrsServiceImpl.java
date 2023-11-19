package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.mall.bo.ShopAttrsBo;
import cn.peyton.plum.mall.mapper.ShopAttrsMapper;
import cn.peyton.plum.mall.param.ShopAttrsParam;
import cn.peyton.plum.mall.pojo.ShopAttrs;
import cn.peyton.plum.mall.service.ShopAttrsService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 商品属性 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("shopAttrsService")
public class ShopAttrsServiceImpl extends AbstractRealizeService<Long, ShopAttrs, ShopAttrsParam> implements ShopAttrsService {
    @Resource
    private ShopAttrsMapper shopAttrsMapper;

    @Override
    public BaseConvertBo<ShopAttrs, ShopAttrsParam> initBo() {
        return new ShopAttrsBo();
    }

    @Override
    public IBaseMapper<Long, ShopAttrs> initMapper() {
        return shopAttrsMapper;
    }

}
