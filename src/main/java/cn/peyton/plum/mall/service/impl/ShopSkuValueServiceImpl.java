package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.mall.bo.ShopSkuValueBo;
import cn.peyton.plum.mall.mapper.ShopSkuValueMapper;
import cn.peyton.plum.mall.param.ShopSkuValueParam;
import cn.peyton.plum.mall.pojo.ShopSkuValue;
import cn.peyton.plum.mall.service.ShopSkuValueService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 商品规格 值 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("shopSkuValueService")
public class ShopSkuValueServiceImpl extends AbstractRealizeService<Long, ShopSkuValue, ShopSkuValueParam> implements ShopSkuValueService {
    @Resource
    private ShopSkuValueMapper shopSkuValueMapper;

    @Override
    public BaseConvertBo<ShopSkuValue, ShopSkuValueParam> initBo() {
        return new ShopSkuValueBo();
    }

    @Override
    public IBaseMapper<Long, ShopSkuValue> initMapper() {
        return shopSkuValueMapper;
    }

}
