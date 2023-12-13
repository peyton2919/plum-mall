package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.product.ShopCategoryRecommendParam;
import cn.peyton.plum.mall.pojo.product.ShopCategoryRecommend;

/**
 * <h3> 商品分类推荐 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年12月09日 19:33:21
 * @version 1.0.0
 * </pre>
*/
public class ShopCategoryRecommendBo  extends BaseConvertBo<ShopCategoryRecommend, ShopCategoryRecommendParam> {

	@Override
	public ShopCategoryRecommendParam compat(ShopCategoryRecommend info){ 
		return new ShopCategoryRecommendParam().compat(info); 
	}

	@Override
	public ShopCategoryRecommend convert(ShopCategoryRecommendParam info){ 
		return info.convert(); 
	}
}
