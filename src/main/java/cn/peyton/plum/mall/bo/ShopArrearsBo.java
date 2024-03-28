package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.join.ShopArrearsParam;
import cn.peyton.plum.mall.pojo.join.ShopArrears;

/**
 * <h3> 欠款信息 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年02月06日 22:33:31
 * @version 1.0.0
 * </pre>
*/
public class ShopArrearsBo  extends BaseConvertBo<ShopArrears, ShopArrearsParam> {

	@Override
	public ShopArrearsParam compat(ShopArrears info){ 
		return new ShopArrearsParam().compat(info); 
	}

	@Override
	public ShopArrears convert(ShopArrearsParam info){ 
		return info.convert(); 
	}
}
