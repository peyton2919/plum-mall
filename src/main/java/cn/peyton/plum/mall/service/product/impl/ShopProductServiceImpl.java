package cn.peyton.plum.mall.service.product.impl;

import cn.peyton.plum.core.anno.timestamp.AutoWriteTimestamp;
import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.mall.bo.ShopProductBo;
import cn.peyton.plum.mall.dto.ProductDto;
import cn.peyton.plum.mall.mapper.product.ShopProductCategoryMapper;
import cn.peyton.plum.mall.mapper.product.ShopProductMapper;
import cn.peyton.plum.mall.param.product.ShopCategoryParam;
import cn.peyton.plum.mall.param.product.ShopProductParam;
import cn.peyton.plum.mall.pojo.product.ShopProduct;
import cn.peyton.plum.mall.pojo.product.ShopProductCategory;
import cn.peyton.plum.mall.service.product.ShopProductService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
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
    @Resource
    private ShopProductCategoryMapper shopProductCategoryMapper;

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
    public List<ShopProductParam> findByIdAndJoin(Integer categoryId) {
        String key = keyPrefix + "_find_id_join_" + categoryId;
        if (enabledCache) {
            Object obj = cache.get(key);
            if (null != obj) {
                return (List<ShopProductParam>) obj;
            }
        }
        List<ShopProduct> shopProducts = shopProductMapper.selectByIdAndJoin(categoryId);
        if (null != shopProducts) {
            List<ShopProductParam> result = initBo().adapter(shopProducts);
            if (enabledCache) {
                System.out.println("查找数据,添加数据到缓存, key=" + key);
                cache.put(key,result);
            }
            return result;
        }
        return null;
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
    public Boolean destroy(List<Long> ids) {
        if(shopProductMapper.destroy(ids) > 0){
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

    @Transactional
    @AutoWriteTimestamp
    public Boolean createAndBatchCategories(ShopProductParam record) {
        ShopProduct _sp = record.convert();
        int res = shopProductMapper.insertSelective(_sp);
        if (res > 0) {
            List<ShopCategoryParam> categories = record.getCategories();
            if (null != categories && categories.size() > 0) {
                List<ShopProductCategory> _spcs = new ArrayList<>();
                ShopProductCategory _spc= null;
                for (int i = 0; i < categories.size(); i++) {
                    _spc = new ShopProductCategory();
                    _spc.setCategoryId(categories.get(i).getId());
                    _spc.setProductId(_sp.getId());
                    _spcs.add(_spc);
                }
                res = shopProductCategoryMapper.batchInsert(_spcs);
            }
        }
        if (res > 0) {
            if(enabledCache){
                System.out.println("批量添加操作,清空缓存");
                removeCache();
            }
            return true;
        }
        return false;
    }

    @Transactional
    @AutoWriteTimestamp("updateTime")
    public Boolean updateAndBatchCategories(ShopProductParam record) {
        int res = shopProductMapper.updateSelective(initBo().convert(record));
        if (res > 0) {
            List<ShopCategoryParam> categories = record.getCategories();
            List<ShopProductCategory> _delete = new ArrayList<>();
            shopProductCategoryMapper.deleteByProductId(record.getId());
            if (null != categories && categories.size() > 0) {
                List<ShopProductCategory> _insert = new ArrayList<>();
                ShopProductCategory _spc= null;
                for (int i = 0; i < categories.size(); i++) {
                    _spc = new ShopProductCategory();
                    _spc.setCategoryId(categories.get(i).getId());
                    _spc.setProductId(record.getId());
                    _insert.add(_spc);
                }
                res = shopProductCategoryMapper.batchInsert(_insert);
            }
        }
        if (res > 0) {
            if(enabledCache){
                System.out.println("批量更新操作,清空缓存");
                removeCache();
            }
            return true;
        }
        return false;
    }

    @Override
    public String findByOperate(Long id) {
        return shopProductMapper.selectByOperate(id);
    }

    @Override
    public Boolean updateOperate(Long id, String operate) {
        return shopProductMapper.updateOperate(id, operate) > 0;
    }

    @Override
    public Boolean updateExplain(ShopProductParam record) {
        Long productId = record.getId();
        String operate = shopProductMapper.selectByOperate(productId);
        String[] strs = operate.split(",");
        strs[2] = "1";
        ShopProduct _sp = new ShopProduct();
        _sp.setId(productId);
        _sp.setExplain(record.getExplain());
        _sp.setOperate(convertArrToStr(strs));
        if (shopProductMapper.updateSelective(_sp) > 0) {
            if(enabledCache){
                System.out.println("更新操作,清空缓存!");
                removeCache();
            }
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateCheck(Long id) {
        if (shopProductMapper.updateCheck(id) > 0) {
            if(enabledCache){
                System.out.println("更新操作,清空缓存!");
                removeCache();
            }
            return true;
        }
        return false;
    }

    @Override
    public Boolean updatePrice(Long id, BigDecimal minPrice, BigDecimal price) {
        if (shopProductMapper.updatePrice(id, minPrice,price) > 0) {
            if(enabledCache){
                System.out.println("更新操作,清空缓存!");
                removeCache();
            }
            return true;
        }
        return false;
    }

    @Override
    public List<ShopProductParam> findAndroidByList(PageQuery page, String type) {
        //String key = keyPrefix + type + createKey(null, page, false);
        //if (enabledCache) {
        //    Object obj = cache.get(key);
        //    if (null != obj) {
        //        System.out.println("从缓存中获取数据, key = " + key);
        //        return (List<ShopProductParam>) obj;
        //    }
        //}
        List<ShopProduct> result = shopProductMapper.selectAndroidByList(page, type);
        if (null == result) {
            return null;
        }
        return initBo().adapter(result);
    }

    @Override
    public BigDecimal findProductByGoodRate(Long id) {
        return shopProductMapper.selectProductByGoodRate(id);
    }

    @Override
    public List<ShopProductParam> findAndroidByMulti(ProductDto product, PageQuery page) {
        StringBuffer sb = new StringBuffer();
        createKeySuffix(product,sb);
        String key = keyPrefix+ createKey(null, page, true) + sb;
        if (enabledCache) {
            Object obj = cache.get(key);
            if (null != obj) {
                System.out.println("从缓存中获取到数据; key=" + key);
                return (List<ShopProductParam>) obj;
            }
        }
        List<ShopProduct> products = shopProductMapper.selectAndroidByMulti(product, page);
        if (null != products && products.size() > 0) {
            List<ShopProductParam> result = initBo().adapter(products);
            if (enabledCache) {
                System.out.println("查找到数据添加到缓存中; key=" + key);
                cache.put(key,result);
            }
            return result;
        }
        return new ArrayList<>();
        //return initBo().adapter(shopProductMapper.selectAndroidByMulti(keyword, product, page));
    }
}
