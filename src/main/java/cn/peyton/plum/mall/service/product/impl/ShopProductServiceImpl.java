package cn.peyton.plum.mall.service.product.impl;

import cn.peyton.plum.core.anno.timestamp.AutoWriteTimestamp;
import cn.peyton.plum.core.err.TransactionalException;
import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.RealizeService;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.utils.base.CtrlUtils;
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
public class ShopProductServiceImpl extends RealizeService<Long, ShopProduct, ShopProductParam> implements ShopProductService {
    @Resource
    private ShopProductMapper shopProductMapper;
    @Resource
    private ShopProductCategoryMapper shopProductCategoryMapper;

    @Override
    public BaseConvertBo<ShopProduct, ShopProductParam> bo() {
        return new ShopProductBo();
    }

    @Override
    public IBaseMapper<Long, ShopProduct> mapper() {
        return shopProductMapper;
    }

    public ShopProductServiceImpl() {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }

    @Override
    public List<ShopProductParam> findByIdAndJoin(Integer categoryId) {
        String key = keyPrefix + "_find_id_join_" + categoryId;

        Object objs = getCache(key);
        if (null == objs) {
            List<ShopProductParam> adapter = bo().adapter(shopProductMapper.selectByIdAndJoin(categoryId));
            saveCache(key, adapter);
            return adapter;
        }
        return (List<ShopProductParam>) objs;
    }

    @Override
    public Boolean batchDelete(List<Long> ids) {
        if(shopProductMapper.batchDelete(ids) > 0){
            clearCache("批量删除商品");
            return true;
        }
        return false;
    }

    @Override
    public Boolean destroy(List<Long> ids) {
        if(shopProductMapper.destroy(ids) > 0){
            clearCache("批量删除商品");
            return true;
        }
        return false;
    }

    @Override
    public Boolean batchRestore(List<Long> ids) {
        if(shopProductMapper.batchRestore(ids) > 0){
            clearCache("批量更新商品");
            return true;
        }
        return false;
    }

    @Override
    public Boolean batchIsShow(List<Long> ids, Integer isShow) {
        if(shopProductMapper.batchIsShow(ids,isShow) > 0){
            clearCache("批量上|下架商品");
            return true;
        }
        return false;
    }

    @Override
    public ShopProductParam selectBySlideshow(Long id) {
        String key = keyPrefix +"_select_slideshow_" + id;
        Object obj = getCache(key);
        if (null == obj) {
            ShopProductParam param = bo().compat(shopProductMapper.selectBySlideshow(id));
            saveCache(key,param);
            return param;
        }
        return (ShopProductParam) obj;
    }

    @Override
    public ShopProductParam selectByExplain(Long id) {
        String key = keyPrefix +"_select_explain_" + id;
        Object obj = getCache(key);
        if (null == obj) {
            ShopProductParam param = bo().compat(shopProductMapper.selectByExplain(id));
            saveCache(key, param);
            return param;
        }
        return (ShopProductParam) obj;


    }

    @Override
    public Boolean isProduct(Long id) {
        return shopProductMapper.isProduct(id) > 0;
    }

    @Override
    public Boolean updateSpecType(Long id, Integer specType, String skus) {
        int res = shopProductMapper.updateSpecType(id, specType, skus);
        if (res > 0) {
            clearCache("更新商品规格");
            return true;
        }
        return false;
    }

    @Transactional(rollbackFor = TransactionalException.class)
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
            clearCache("批量添加|更新商品分类");
            return true;
        }
        return false;
    }

    @Transactional
    @AutoWriteTimestamp("updateTime")
    public Boolean updateAndBatchCategories(ShopProductParam record) {
        int res = shopProductMapper.updateSelective(bo().convert(record));
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
            clearCache("批量更新商品分类");
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
        _sp.setOperate(new CtrlUtils().convertArrToStr(strs));
        if (shopProductMapper.updateSelective(_sp) > 0) {
            clearCache("批量更新商品详情");
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateCheck(Long id) {
        if (shopProductMapper.updateCheck(id) > 0) {
            clearCache("批量更新商品审核状态");
            return true;
        }
        return false;
    }

    @Override
    public Boolean updatePrice(Long id, BigDecimal minPrice, BigDecimal price) {
        if (shopProductMapper.updatePrice(id, minPrice,price) > 0) {
            clearCache("批量更新商品最低价格");
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
        return bo().adapter(result);
    }

    @Override
    public BigDecimal findProductByGoodRate(Long id) {
        return shopProductMapper.selectProductByGoodRate(id);
    }

    @Override
    public List<ShopProductParam> findAndroidByMulti(ProductDto product, PageQuery page) {
        StringBuffer sb = new StringBuffer();
        keywords(product,sb);
        String key = keyPrefix+ keywords(null, page, true) + sb;
        Object objs = getCache(key);
        if (null == objs) {
            List<ShopProductParam> adapter = bo().adapter(shopProductMapper.selectAndroidByMulti(product, page));
            saveCache(key, adapter);
            return adapter;
        }
        return (List<ShopProductParam>) objs;
    }

    @Override
    public List<ShopProductParam> findForeignKeyByList(Long id) {

        return bo().adapter(shopProductMapper.selectForeignKeyByList(id));
    }
}
