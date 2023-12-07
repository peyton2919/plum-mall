package cn.peyton.plum.mall.service.product.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.mall.bo.ShopSkuValueBo;
import cn.peyton.plum.mall.mapper.product.ShopSkuValueMapper;
import cn.peyton.plum.mall.param.product.ShopSkuValueParam;
import cn.peyton.plum.mall.pojo.product.ShopSkuValue;
import cn.peyton.plum.mall.service.product.ShopSkuValueService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public ShopSkuValueServiceImpl () {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }

    @Override
    public ShopSkuValueParam findBySkuIdAndValue(Long skuId, String skuValue) {
        ShopSkuValue res = shopSkuValueMapper.selectBySkuIdAndValue(skuId, skuValue);
        return (res == null) ? null : new ShopSkuValueBo().compat(res);
    }

    @Override
    public Boolean batchCreate(List<ShopSkuValueParam> list) {
        Boolean res = shopSkuValueMapper.batchInsert(new ShopSkuValueBo().reverse(list)) > 0;
        if(res){
            if(enabledCache){
                System.out.println("规格值集合插入操作,清空缓存;");
                removeCache();
            }
            return true;
        }
        return false;
    }

    @Override
    public Boolean isShopSku(Long skuId) {
        return shopSkuValueMapper.isShopSku(skuId) > 0;
    }
}
