package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.party.UserAddressParam;

/**
 * <h3> 用户地址{用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)} 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
*/
public class UserAddressBo  extends BaseConvertBo<cn.peyton.plum.mall.pojo.party.UserAddress, UserAddressParam> {

	@Override
	public UserAddressParam compat(cn.peyton.plum.mall.pojo.party.UserAddress info){
		return new UserAddressParam().compat(info);
	}

	@Override
	public cn.peyton.plum.mall.pojo.party.UserAddress convert(UserAddressParam info){
		return info.convert(); 
	}
}
