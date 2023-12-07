package cn.peyton.plum.mall.service.product;

import cn.peyton.plum.core.inf.service.IBaseService;
import cn.peyton.plum.mall.param.product.ShopProductRuleParam;
import cn.peyton.plum.mall.pojo.product.ShopProductRule;

import java.util.List;

/**
 * <h3> 商品规格--(规则) Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
public interface ShopProductRuleService extends IBaseService<Integer, ShopProductRule, ShopProductRuleParam> {
    /**
     * <h4>批量删除</h4>
     * @param ids 主键id 集合
     * @return 删除成功 true
     */
    Boolean batchDelete(List<Integer> ids);
}
