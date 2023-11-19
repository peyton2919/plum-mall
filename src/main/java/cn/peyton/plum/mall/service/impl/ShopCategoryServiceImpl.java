package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.mall.bo.ShopCategoryBo;
import cn.peyton.plum.mall.mapper.ShopCategoryMapper;
import cn.peyton.plum.mall.param.ShopCategoryParam;
import cn.peyton.plum.mall.pojo.ShopCategory;
import cn.peyton.plum.mall.service.ShopCategoryService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

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

}
