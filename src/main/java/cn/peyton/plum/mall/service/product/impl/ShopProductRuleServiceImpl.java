package cn.peyton.plum.mall.service.product.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.RealizeService;
import cn.peyton.plum.mall.bo.ShopProductRuleBo;
import cn.peyton.plum.mall.mapper.product.ShopProductRuleMapper;
import cn.peyton.plum.mall.param.product.ShopProductRuleParam;
import cn.peyton.plum.mall.pojo.product.ShopProductRule;
import cn.peyton.plum.mall.service.product.ShopProductRuleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h3> 商品规格--(规则) Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("shopProductRuleService")
public class ShopProductRuleServiceImpl extends RealizeService<Integer, ShopProductRule, ShopProductRuleParam> implements ShopProductRuleService {
    @Resource
    private ShopProductRuleMapper shopProductRuleMapper;

    @Override
    public BaseConvertBo<ShopProductRule, ShopProductRuleParam> bo() {
        return new ShopProductRuleBo();
    }

    @Override
    public IBaseMapper<Integer, ShopProductRule> mapper() {
        return shopProductRuleMapper;
    }

    public ShopProductRuleServiceImpl() {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }

    @Override
    public Boolean batchDelete(List<Integer> ids) {
        int res = shopProductRuleMapper.batchDelete(ids);
        if (res > 0) {
            clearCache("删除商品规格");
            return true;
        }
        return false;
    }
}
