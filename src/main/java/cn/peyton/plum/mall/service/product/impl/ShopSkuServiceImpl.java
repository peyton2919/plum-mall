package cn.peyton.plum.mall.service.product.impl;

import cn.peyton.plum.core.err.GlobalException;
import cn.peyton.plum.core.err.ValidationException;
import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.RealizeService;
import cn.peyton.plum.mall.bo.ShopSkuBo;
import cn.peyton.plum.mall.mapper.product.ShopProductSkuJoinMapper;
import cn.peyton.plum.mall.mapper.product.ShopSkuMapper;
import cn.peyton.plum.mall.mapper.product.ShopSkuValueMapper;
import cn.peyton.plum.mall.param.product.ShopSkuParam;
import cn.peyton.plum.mall.pojo.product.ShopProductSkuJoin;
import cn.peyton.plum.mall.pojo.product.ShopSku;
import cn.peyton.plum.mall.pojo.product.ShopSkuValue;
import cn.peyton.plum.mall.service.product.ShopSkuService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3> 商品规格 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("shopSkuService")
public class ShopSkuServiceImpl extends RealizeService<Long, ShopSku, ShopSkuParam> implements ShopSkuService {
    @Resource
    private ShopSkuMapper shopSkuMapper;
    @Resource
    private ShopProductSkuJoinMapper shopProductSkuJoinMapper;
    @Resource
    private ShopSkuValueMapper shopSkuValueMapper;

    @Override
    public BaseConvertBo<ShopSku, ShopSkuParam> bo() {
        return new ShopSkuBo();
    }

    @Override
    public IBaseMapper<Long, ShopSku> mapper() {
        return shopSkuMapper;
    }

    public ShopSkuServiceImpl () {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }

    @Override
    public ShopSkuParam findByName(String name) {
        ShopSku shopSku = shopSkuMapper.selectByName(name);
        return (null != shopSku) ? new ShopSkuBo().compat(shopSku) : null;
    }

    @Override
    @Transactional(rollbackFor = {ValidationException.class, GlobalException.class, RuntimeException.class, Exception.class},
            propagation = Propagation.REQUIRED)
    public ShopSkuParam createJoinProduct(Long productId, ShopSkuParam record) {
        // 添加 商品规格
        ShopSku shopSku = record.convert();
        int res = 0;
        if (shopSkuMapper.insertSelective(shopSku) > 0) {
            // 添加 商品与规格 关联关系
            ShopProductSkuJoin join = new ShopProductSkuJoin();
            join.setProductId(productId);
            join.setSkuId(shopSku.getId());
            res = shopProductSkuJoinMapper.insertSelective(join);
            if (res > 0) {
                clearCache("新增规格");
                return new ShopSkuBo().compat(shopSku);
            }
        }
        return null;
    }

    @Override
    public Boolean joinDelete(Long productId, Long skuId,StringBuffer tip) {
        // 需要先判断 规格 下有没有关联的 规格值
        if (shopSkuValueMapper.isShopSku(skuId) > 0) {
            tip.append("规格与规格值存在关联,不能删除,如需删除,先删除相应的规格值;");
            return false;
        }
        // 删除 shopSku 与 shopProduct 关联表
        int res = shopProductSkuJoinMapper.deleteByProductIdAndSkuId(productId, skuId);
        // 删除 规格
        res = shopSkuMapper.deleteByPrimaryKey(skuId);
        if (res > 0) {
            clearCache("删除规格");
            tip.append("数据删除成功");
            return true;
        }
        tip.append("未知的失败");
        return false;
    }

    @Override
    public Boolean batchUpdate(List<ShopSkuParam> skus) {
        int res = shopSkuMapper.batchUpdate(new ShopSkuBo().reverse(skus));
        if (res > 0) {
            clearCache("更新规格");
            return true;
        }
        return false;
    }

    @Override
    public ShopSkuParam set(String name, List<String> strs) {

        ShopSku _shopSku = shopSkuMapper.selectByName(name);
        if (null == _shopSku) { // 新增
            ShopSku _record = new ShopSku();
            _record.setName(name);
            if(shopSkuMapper.insertSelective(_record) >0){
                if (insertSSV(_record, strs)) {
                    remove();
                    return new ShopSkuBo().compat(_record);
                }
            }
        }else {
            List<ShopSkuValue> _resList = new ArrayList<>();
            List<ShopSkuValue> _insert = new ArrayList<>();
            ShopSkuValue _tmp = null;
            if (null != _shopSku.getShopSkuValues() && _shopSku.getShopSkuValues().size() > 0) {
                for (Object _str : strs) { // 两层循环 判断 从数据库获取的 规格值 集合
                    Boolean _continue = true;
                    for (ShopSkuValue _ssv : _shopSku.getShopSkuValues()) {  // 前台 提交上来的 规格值 集合
                        if (_ssv.getSkuValue().equals(_str)) { // 在数据库获取的规格值 等于 前端提交过来的规格值相等 则把这个对象添加到 返回前端的集合中 _resList
                            _resList.add(_ssv);
                            _continue = false;
                            break;
                        }
                    }
                    if (_continue) { // 否则就添加到 插入数据库集合中
                        _tmp = new ShopSkuValue();
                        _tmp.setSkuId(_shopSku.getId());
                        _tmp.setSkuValue(_str.toString());
                        _insert.add(_tmp);
                    }
                }
                _shopSku.setShopSkuValues(new ArrayList<>());
                _shopSku.getShopSkuValues().addAll(_resList);
                if(_insert.size()>0){
                    shopSkuValueMapper.batchInsert(_insert) ;
                    _shopSku.getShopSkuValues().addAll(_insert);
                }
                remove();
                return new ShopSkuBo().compat(_shopSku);
            }else {
                if (insertSSV(_shopSku, strs)) {
                    remove();
                    return new ShopSkuBo().compat(_shopSku);
                }
            }
        }
        return null;
    }

    /**
     * <h4>获取 规格值 集合</h4>
     * @param _param
     * @param strs
     * @return
     */
    private Boolean insertSSV(ShopSku _param, List<String> strs) {
        List<ShopSkuValue> _skuValues = new ArrayList<>();
        ShopSkuValue _ssv = null;
        if (null != strs && strs.size() > 0) {
            for (int i = 0; i < strs.size(); i++) {
                _ssv = new ShopSkuValue();
                _ssv.setSkuId(_param.getId());
                _ssv.setSkuValue(strs.get(i).toString());
                _skuValues.add(_ssv);
            }
            Boolean _bool = shopSkuValueMapper.batchInsert(_skuValues) > 0;
            if (_bool) {
                _param.setShopSkuValues(_skuValues);
                return true;
            }
        }
        return false;
    }

    /**
     * <h4>清空缓存</h4>
     */
    private void remove(){

        if(enabledCache){
            System.out.println("添加操作数据,清空缓存;");
            removeCache();
        }
    }
}
