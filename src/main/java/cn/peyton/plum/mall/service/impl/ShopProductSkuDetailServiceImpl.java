package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractAppRealizeService;
import cn.peyton.plum.mall.bo.ShopProductSkuDetailBo;
import cn.peyton.plum.mall.mapper.ShopProductSkuDetailMapper;
import cn.peyton.plum.mall.param.ShopProductSkuDetailParam;
import cn.peyton.plum.mall.pojo.ShopProductSkuDetail;
import cn.peyton.plum.mall.service.ShopProductSkuDetailService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 商品规格详细 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("shopProductSkuDetailService")
public class ShopProductSkuDetailServiceImpl extends AbstractAppRealizeService<Long, ShopProductSkuDetail, ShopProductSkuDetailParam> implements ShopProductSkuDetailService {
    @Resource
    private ShopProductSkuDetailMapper shopProductSkuDetailMapper;

    @Override
    public BaseConvertBo<ShopProductSkuDetail, ShopProductSkuDetailParam> initBo() {
        return new ShopProductSkuDetailBo();
    }

    @Override
    public IBaseMapper<Long, ShopProductSkuDetail> initMapper() {
        return shopProductSkuDetailMapper;
    }

}
