package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.pojo.product.ShopStock;

/**
 * <h3> 商品库存汇总 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年12月29日 20:46:35
 * @version 1.0.0
 * </pre>
*/
public class ShopStockBo  extends BaseConvertBo<ShopStock, cn.peyton.plum.mall.param.product.ShopStockParam> {

	@Override
	public cn.peyton.plum.mall.param.product.ShopStockParam compat(ShopStock info){
		return new cn.peyton.plum.mall.param.product.ShopStockParam().compat(info);
	}

	@Override
	public ShopStock convert(cn.peyton.plum.mall.param.product.ShopStockParam info){
		return info.convert(); 
	}
}
