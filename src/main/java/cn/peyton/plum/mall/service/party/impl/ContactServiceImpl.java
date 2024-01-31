package cn.peyton.plum.mall.service.party.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.mall.bo.ContactBo;
import cn.peyton.plum.mall.mapper.party.ContactMapper;
import cn.peyton.plum.mall.param.party.ContactParam;
import cn.peyton.plum.mall.pojo.party.Contact;
import cn.peyton.plum.mall.service.party.ContactService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 通讯录 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年01月11日 20:51:29
 * @version 1.0.0
 * </pre>
*/
@Service("contactService")
public class ContactServiceImpl  extends AbstractRealizeService<Integer, Contact, ContactParam> implements ContactService {
	@Resource
	private ContactMapper contactMapper;

	@Override
	public BaseConvertBo<Contact, ContactParam> initBo() {
		return new ContactBo();
	}

	@Override
	public IBaseMapper<Integer, Contact> initMapper() {
		return contactMapper;
	}

	public ContactServiceImpl(){
		// 开启缓存
		enabledCache = true;
		//设置缓存 key 的前缀
		keyPrefix = this.getClass().getName();
	}

	@Override
	public Boolean isContactGroup(Integer groupId) {
		return contactMapper.isContactGroup(groupId) > 0;
	}

}
