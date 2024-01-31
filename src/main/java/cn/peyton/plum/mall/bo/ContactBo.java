package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.party.ContactParam;
import cn.peyton.plum.mall.pojo.party.Contact;

/**
 * <h3> 通讯录 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年01月11日 20:51:29
 * @version 1.0.0
 * </pre>
*/
public class ContactBo  extends BaseConvertBo<Contact, ContactParam> {

	@Override
	public ContactParam compat(Contact info){ 
		return new ContactParam().compat(info); 
	}

	@Override
	public Contact convert(ContactParam info){ 
		return info.convert(); 
	}
}
