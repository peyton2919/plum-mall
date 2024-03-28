package cn.peyton.plum.mall.service.product.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.RealizeService;
import cn.peyton.plum.mall.bo.ShopCategoryBo;
import cn.peyton.plum.mall.mapper.product.ShopCategoryMapper;
import cn.peyton.plum.mall.param.product.ShopCategoryParam;
import cn.peyton.plum.mall.pojo.product.ShopCategory;
import cn.peyton.plum.mall.service.product.ShopCategoryService;
import cn.peyton.plum.mall.utils.CategoryUtils;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h3> 商品分类 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("shopCategoryService")
public class ShopCategoryServiceImpl extends RealizeService<Integer, ShopCategory, ShopCategoryParam> implements ShopCategoryService {
    private String TABEL_NAME = "tb_shop_category";
    @Resource
    private ShopCategoryMapper shopCategoryMapper;

    @Override
    public BaseConvertBo<ShopCategory, ShopCategoryParam> bo() {
        return new ShopCategoryBo();
    }

    @Override
    public IBaseMapper<Integer, ShopCategory> mapper() {
        return shopCategoryMapper;
    }

    public ShopCategoryServiceImpl () {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }

    @Override
    public Boolean isChildren(Integer id) {
        return shopCategoryMapper.isChildren(id) > 0;
    }

    @Override
    public Boolean isRecommend(Integer id) {
        return shopCategoryMapper.isRecommend(id) > 0;
    }

    @Override
    public Boolean updateSeq(Integer id, Short seq) {
        int res = shopCategoryMapper.updateSeq(id, seq);
        if (res > 0) {
            clearCache("更新商品分类排序");
            return true;
        }
        return false;
    }

    @Override
    public List<ShopCategoryParam> findByOutside() {
        String key = keyPrefix + "select_all_2311282020";
        Object objs = getCache(key);
        if (null == objs) {
            List<ShopCategoryParam> adapter = bo().adapter(CategoryUtils.reorganize(shopCategoryMapper.selectByOutside()));
            saveCache(key, adapter);
            return adapter;
        }
        return (List<ShopCategoryParam>) objs;


    }

    @Override
    public List<ShopCategoryParam> findByInner() {
        String key = keyPrefix + "select_all_2312101102";
        Object objs = getCache(key);
        if (null == objs) {
            List<ShopCategoryParam> adapter = bo().adapter(shopCategoryMapper.selectByInner());
            saveCache(key, adapter);
            return adapter;
        }
        return (List<ShopCategoryParam>) objs;
    }

    @Override
    public Boolean updateShow(Integer id, Integer isShow) {
        int res = shopCategoryMapper.updateShow(id, isShow);
        if (res > 0) {
            clearCache("更新商品分类显示");
            return true;
        }
        return false;
    }

    @Override
    public Boolean upDelete(Integer id) {
        int res = shopCategoryMapper.updateDeleteStatus(TABEL_NAME, id);
        if (res > 0) {
            if(enabledCache){
                System.out.println("更新操作清空缓存;");
                removeCache();
            }
            clearCache("删除商品分类");
            return true;
        }
        return false;
    }

    @Override
    public List<ShopCategoryParam> findByTree() {
        String key = keyPrefix + "find_tree_all_1";
        Object objs = getCache(key);
        if (null == objs) {
            List<ShopCategoryParam> adapter = bo().adapter(CategoryUtils.reorganize(shopCategoryMapper.selectByTree()));
            saveCache(key, adapter);
            return adapter;
        }
        return (List<ShopCategoryParam>) objs;
    }

    @Override
    public List<ShopCategoryParam> findAndroidByRand(int limit) {
        return bo().adapter(shopCategoryMapper.selectAndroidByRand(limit));
    }
}
