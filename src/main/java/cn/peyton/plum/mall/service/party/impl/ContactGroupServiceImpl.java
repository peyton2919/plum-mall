package cn.peyton.plum.mall.service.party.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.RealizeService;
import cn.peyton.plum.mall.bo.ContactGroupBo;
import cn.peyton.plum.mall.mapper.party.ContactGroupMapper;
import cn.peyton.plum.mall.param.party.ContactGroupParam;
import cn.peyton.plum.mall.pojo.party.ContactGroup;
import cn.peyton.plum.mall.service.party.ContactGroupService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 通讯录分组 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年01月11日 20:51:40
 * @version 1.0.0
 * </pre>
*/
@Service("contactGroupService")
public class ContactGroupServiceImpl  extends RealizeService<Integer, ContactGroup, ContactGroupParam> implements ContactGroupService {
	@Resource
	private ContactGroupMapper contactGroupMapper;

	@Override
	public BaseConvertBo<ContactGroup, ContactGroupParam> bo() {
		return new ContactGroupBo();
	}

	@Override
	public IBaseMapper<Integer, ContactGroup> mapper() {
		return contactGroupMapper;
	}

	public ContactGroupServiceImpl(){
		// 开启缓存
		enabledCache = true;
		//设置缓存 key 的前缀
		keyPrefix = this.getClass().getName();
	}

}
