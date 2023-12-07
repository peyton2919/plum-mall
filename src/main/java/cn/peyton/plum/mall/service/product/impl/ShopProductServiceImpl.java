package cn.peyton.plum.mall.service.product.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.mall.bo.ShopProductBo;
import cn.peyton.plum.mall.mapper.product.ShopProductMapper;
import cn.peyton.plum.mall.param.product.ShopProductParam;
import cn.peyton.plum.mall.pojo.product.ShopProduct;
import cn.peyton.plum.mall.service.product.ShopProductService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h3> 商品信息 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("shopProductService")
public class ShopProductServiceImpl extends AbstractRealizeService<Long, ShopProduct, ShopProductParam> implements ShopProductService {
    @Resource
    private ShopProductMapper shopProductMapper;

    @Override
    public BaseConvertBo<ShopProduct, ShopProductParam> initBo() {
        return new ShopProductBo();
    }

    @Override
    public IBaseMapper<Long, ShopProduct> initMapper() {
        return shopProductMapper;
    }

    public ShopProductServiceImpl() {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }

    @Override
    public Boolean batchDelete(List<Long> ids) {
        if(shopProductMapper.batchDelete(ids) > 0){
            if(enabledCache){
                System.out.println("批量删除操作,清空缓存");
                removeCache();
            }
            return true;
        }
        return false;
    }

    @Override
    public Boolean batchRestore(List<Long> ids) {
        if(shopProductMapper.batchRestore(ids) > 0){
            if(enabledCache){
                System.out.println("批量更新操作,清空缓存");
                removeCache();
            }
            return true;
        }
        return false;
    }

    @Override
    public Boolean batchIsShow(List<Long> ids, Integer isShow) {
        if(shopProductMapper.batchIsShow(ids,isShow) > 0){
            if(enabledCache){
                System.out.println("批量删除操作,清空缓存");
                removeCache();
            }
            return true;
        }
        return false;
    }

    @Override
    public ShopProductParam selectBySlideshow(Long id) {
        String key = keyPrefix +"_select_slideshow_" + id;
        if(enabledCache){
            Object obj = cache.get(key);
            if(null != obj){
                System.out.printf("从缓存获取到对象: key= %s;\n",key);
                return (ShopProductParam) obj;
            }
        }
        ShopProductParam param = initBo().compat(shopProductMapper.selectBySlideshow(id));
        if (null != param && enabledCache) {
            System.out.printf("添加对象到缓存: key= %s;\n",key);
            cache.put(key,param);
        }
        return param;
    }

    @Override
    public ShopProductParam selectByExplain(Long id) {
        String key = keyPrefix +"_select_explain_" + id;
        if(enabledCache){
            Object obj = cache.get(key);
            if(null != obj){
                System.out.printf("从缓存获取到对象: key= %s;\n",key);
                return (ShopProductParam) obj;
            }
        }
        ShopProductParam param = initBo().compat(shopProductMapper.selectByExplain(id));
        if (null != param && enabledCache) {
            System.out.printf("添加对象到缓存: key= %s;\n",key);
            cache.put(key,param);
        }
        return param;
    }

    @Override
    public Boolean isProduct(Long id) {
        return shopProductMapper.isProduct(id) > 0;
    }

    @Override
    public Boolean updateSpecType(Long id, Integer specType, String skus) {

        int res = shopProductMapper.updateSpecType(id, specType, skus);
        if (res > 0) {
            if (enabledCache) {
                System.out.println("更新操作,清空缓存");
                removeCache();
            }
            return true;
        }
        return false;
    }
}
