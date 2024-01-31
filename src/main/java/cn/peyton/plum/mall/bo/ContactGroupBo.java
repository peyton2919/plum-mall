package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.party.ContactGroupParam;
import cn.peyton.plum.mall.pojo.party.ContactGroup;

/**
 * <h3> 通讯录分组 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年01月11日 20:51:40
 * @version 1.0.0
 * </pre>
*/
public class ContactGroupBo  extends BaseConvertBo<ContactGroup, ContactGroupParam> {

	@Override
	public ContactGroupParam compat(ContactGroup info){ 
		return new ContactGroupParam().compat(info); 
	}

	@Override
	public ContactGroup convert(ContactGroupParam info){ 
		return info.convert(); 
	}
}
