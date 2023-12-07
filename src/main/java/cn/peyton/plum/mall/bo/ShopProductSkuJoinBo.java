package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.product.ShopProductSkuJoinParam;
import cn.peyton.plum.mall.pojo.product.ShopProductSkuJoin;

/**
 * <h3> 商品规格联系{用来关联商品与规格;辅助作用} 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年12月01日 15:52:45
 * @version 1.0.0
 * </pre>
*/
public class ShopProductSkuJoinBo  extends BaseConvertBo<ShopProductSkuJoin, ShopProductSkuJoinParam> {

	@Override
	public ShopProductSkuJoinParam compat(ShopProductSkuJoin info){ 
		return new ShopProductSkuJoinParam().compat(info); 
	}

	@Override
	public ShopProductSkuJoin convert(ShopProductSkuJoinParam info){ 
		return info.convert(); 
	}
}
