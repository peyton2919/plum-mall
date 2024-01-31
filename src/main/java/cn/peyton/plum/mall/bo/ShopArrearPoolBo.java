package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.join.ShopArrearPoolParam;
import cn.peyton.plum.mall.pojo.join.ShopArrearPool;

/**
 * <h3> 欠款汇总 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年01月30日 11:33:43
 * @version 1.0.0
 * </pre>
*/
public class ShopArrearPoolBo  extends BaseConvertBo<ShopArrearPool, ShopArrearPoolParam> {

	@Override
	public ShopArrearPoolParam compat(ShopArrearPool info){ 
		return new ShopArrearPoolParam().compat(info); 
	}

	@Override
	public ShopArrearPool convert(ShopArrearPoolParam info){ 
		return info.convert(); 
	}
}
