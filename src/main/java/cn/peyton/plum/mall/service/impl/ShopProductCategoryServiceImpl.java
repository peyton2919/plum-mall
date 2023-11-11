package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractAppRealizeService;
import cn.peyton.plum.mall.bo.ShopProductCategoryBo;
import cn.peyton.plum.mall.mapper.ShopProductCategoryMapper;
import cn.peyton.plum.mall.param.ShopProductCategoryParam;
import cn.peyton.plum.mall.pojo.ShopProductCategory;
import cn.peyton.plum.mall.service.ShopProductCategoryService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 商品与商品分类关联 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("shopProductCategoryService")
public class ShopProductCategoryServiceImpl extends AbstractAppRealizeService<Long, ShopProductCategory, ShopProductCategoryParam> implements ShopProductCategoryService {
    @Resource
    private ShopProductCategoryMapper shopProductCategoryMapper;

    @Override
    public BaseConvertBo<ShopProductCategory, ShopProductCategoryParam> initBo() {
        return new ShopProductCategoryBo();
    }

    @Override
    public IBaseMapper<Long, ShopProductCategory> initMapper() {
        return shopProductCategoryMapper;
    }

}
