package cn.peyton.plum.mall.service.product.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.mall.bo.ShopProductSkuDetailBo;
import cn.peyton.plum.mall.mapper.product.ShopProductMapper;
import cn.peyton.plum.mall.mapper.product.ShopProductSkuDetailMapper;
import cn.peyton.plum.mall.mapper.product.ShopProductSkuMapper;
import cn.peyton.plum.mall.param.product.ShopProductSkuDetailParam;
import cn.peyton.plum.mall.pojo.product.ShopProductSku;
import cn.peyton.plum.mall.pojo.product.ShopProductSkuDetail;
import cn.peyton.plum.mall.pojo.product.ShopSkuValue;
import cn.peyton.plum.mall.service.product.ShopProductSkuDetailService;
import com.alibaba.fastjson.JSON;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class ShopProductSkuDetailServiceImpl extends AbstractRealizeService<Long, ShopProductSkuDetail, ShopProductSkuDetailParam> implements ShopProductSkuDetailService {
    @Resource
    private ShopProductSkuDetailMapper shopProductSkuDetailMapper;
    @Resource
    private ShopProductMapper shopProductMapper;
    @Resource
    private ShopProductSkuMapper shopProductSkuMapper;

    @Override
    public BaseConvertBo<ShopProductSkuDetail, ShopProductSkuDetailParam> initBo() {
        return new ShopProductSkuDetailBo();
    }

    @Override
    public IBaseMapper<Long, ShopProductSkuDetail> initMapper() {
        return shopProductSkuDetailMapper;
    }

    public ShopProductSkuDetailServiceImpl () {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }

    @Override
    @Transactional
    public Boolean batchCreate(List<ShopProductSkuDetailParam> list, String skus) {
        // 更新 商品规格 和 skus(shopSkus集合) spceType = 1
        int res = shopProductMapper.updateSpecType(list.get(0).getProductId(), MULTI_SKU, skus);
        // 批量创建 商品规格明细
        List<ShopProductSkuDetail> _params = initBo().reverse(list);
        // 调用创建方法
        return create(_params);
    }

    @Override
    @Transactional
    public Boolean batchEdit(List<ShopProductSkuDetailParam> list, String skus) {
        // 更新 商品规格 和 skus(shopSkus集合) spceType = 1
        int res = shopProductMapper.updateSpecType(list.get(0).getProductId(), MULTI_SKU, skus);
        List<ShopProductSkuDetail> _params = initBo().reverse(list);
        List<ShopProductSkuDetail> _insert = new ArrayList<>();
        List<ShopProductSkuDetail> _update = new ArrayList<>();
        // 拆分 新增|更新
        for (ShopProductSkuDetail _param : _params) {
            if (null == _param.getId()) {
                _insert.add(_param);
            }else {
                _update.add(_param);
            }
        }
        // 更新
        res = shopProductSkuDetailMapper.batchUpdate(_update);
        if (res > 0) {
            // 插入 集合与关联表
            if (_insert.size() > 0) {
                return create(_insert);
            }
            return true;
        }
        return false;
    }

    /**
     * <h4>创建 规格明细对象集合</h4>
     * @param _params 规格明细对象集合
     * @return
     */
    @Transactional
    public boolean create(List<ShopProductSkuDetail> _params){
        int res = shopProductSkuDetailMapper.batchInsert(_params);
        if (res > 0) {
            // 成功之后 需要添加 shop_product_sku 表中添加相应的数据 用来防删除
            // ShopProductSkuDetailParam 对象 skus属性就存着 shopSkuValue 对象 可用的属性{id,skuId}
            List<ShopProductSku> _shopProductSkus = new ArrayList<>();
            ShopProductSku _sps = null;
            for (ShopProductSkuDetail _param : _params) {
                //ShopSkuValue _ssv = JSON.parseObject(_param.getSkus(), ShopSkuValue.class);
                //List<ShopSkuValue> _ssvList = JSON.parseArray(_param.getSkus(), new Reference());
                List<ShopSkuValue> _ssvList = JSON.parseArray(_param.getSkus(), ShopSkuValue.class);
                if (null != _ssvList && _ssvList.size() > 0) {
                    for (ShopSkuValue _ssv : _ssvList) {
                        _sps = new ShopProductSku();
                        _sps.setProductId(_param.getProductId());
                        _sps.setSkuValueId(_ssv.getId());
                        _sps.setSkuId(_ssv.getSkuId());
                        _shopProductSkus.add(_sps);
                    }
                }
            }
            // 批量添加 shop_product_sku 表
            if (_shopProductSkus.size() > 0) {
                shopProductSkuMapper.batchInsert(removeDuplicate(_shopProductSkus));
            }

            // 清空缓存
            if (enabledCache) {
                System.out.println("批量添加操作,清空缓存!");
                removeCache();
            }
            return true;
        }
        return false;
    }
    /**
     * 多规格
     */
    int MULTI_SKU = 1;

    // 删除ArrayList中重复元素，保持顺序
    @Transactional
    public List<ShopProductSku> removeDuplicate(List<ShopProductSku> list){
        Map<String, ShopProductSku> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            ShopProductSku sku = list.get(i);
            map.put(sku.getSkuId() + "_" + sku.getSkuValueId() + "_" + sku.getProductId(), sku);
        }
        List<ShopProductSku> list1 = new ArrayList<>();

        for (String key : map.keySet()) {
            list1.add(map.get(key));
        }

        return list1;
    }

}
