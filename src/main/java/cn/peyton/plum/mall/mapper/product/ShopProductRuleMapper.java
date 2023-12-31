package cn.peyton.plum.mall.mapper.product;

import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.mall.pojo.product.ShopProductRule;

import java.util.List;

/**
 * <h3> 商品规格--(规则) Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public interface ShopProductRuleMapper extends IBaseMapper<Integer, ShopProductRule> {

    /**
     * <h4>批量删除</h4>
     * @param ids
     * @return
     */
    int batchDelete(List<Integer> ids);
    // ==================================== new create method ==================================== //


}
