package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.product.ShopStorageDetailParam;
import cn.peyton.plum.mall.pojo.product.ShopStorageDetail;

/**
 * <h3> 商品入库明细 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年12月29日 20:47:02
 * @version 1.0.0
 * </pre>
*/
public class ShopStorageDetailBo  extends BaseConvertBo<ShopStorageDetail, ShopStorageDetailParam> {

	@Override
	public ShopStorageDetailParam compat(ShopStorageDetail info){ 
		return new ShopStorageDetailParam().compat(info); 
	}

	@Override
	public ShopStorageDetail convert(ShopStorageDetailParam info){ 
		return info.convert(); 
	}
}
