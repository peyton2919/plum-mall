package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.join.ShopRepaymentParam;
import cn.peyton.plum.mall.pojo.join.ShopRepayment;

/**
 * <h3> 还款信息 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年02月06日 22:33:46
 * @version 1.0.0
 * </pre>
*/
public class ShopRepaymentBo  extends BaseConvertBo<ShopRepayment, ShopRepaymentParam> {

	@Override
	public ShopRepaymentParam compat(ShopRepayment info){ 
		return new ShopRepaymentParam().compat(info); 
	}

	@Override
	public ShopRepayment convert(ShopRepaymentParam info){ 
		return info.convert(); 
	}
}
