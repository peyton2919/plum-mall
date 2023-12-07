package cn.peyton.plum.mall.service.product.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.mall.bo.ShopCategoryBo;
import cn.peyton.plum.mall.mapper.product.ShopCategoryMapper;
import cn.peyton.plum.mall.param.product.ShopCategoryParam;
import cn.peyton.plum.mall.pojo.product.ShopCategory;
import cn.peyton.plum.mall.service.product.ShopCategoryService;
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
public class ShopCategoryServiceImpl extends AbstractRealizeService<Integer, ShopCategory, ShopCategoryParam> implements ShopCategoryService {
    @Resource
    private ShopCategoryMapper shopCategoryMapper;

    @Override
    public BaseConvertBo<ShopCategory, ShopCategoryParam> initBo() {
        return new ShopCategoryBo();
    }

    @Override
    public IBaseMapper<Integer, ShopCategory> initMapper() {
        return shopCategoryMapper;
    }

    public ShopCategoryServiceImpl () {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }

    @Override
    public List<ShopCategoryParam> select(ShopCategoryParam param, PageQuery page) {
        String key = keyPrefix + "select_all_2311282020";
        if(enabledCache){
            Object list = cache.get(key);
            if (null != list) {
                System.out.printf("从缓存获取到对象: key= %s;\n",key);
                return (List<ShopCategoryParam>)list;
            }
        }
        List<ShopCategoryParam> pList = initBo().adapter(shopCategoryMapper.selectByObj(new ShopCategoryBo().convert(param), page));
        if (null != pList && pList.size() > 0 && enabledCache) {
            System.out.printf("添加对象到缓存: key= %s;\n",key);
            cache.put(key,pList);
        }
        return pList;
    }

    @Override
    public Boolean updateShow(Integer id, Integer isShow) {
        int res = shopCategoryMapper.updateShow(id, isShow);
        if (res > 0) {
            if(enabledCache){
                System.out.println("更新操作清空缓存;");
                removeCache();
            }
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateDelete(Integer id) {
        int res = shopCategoryMapper.updateDelete(id);
        if (res > 0) {
            if(enabledCache){
                System.out.println("更新操作清空缓存;");
                removeCache();
            }
            return true;
        }
        return false;
    }
}
