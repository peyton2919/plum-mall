package cn.peyton.plum.mall.controller.pc.manager.party;

import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.inf.controller.IController;
import cn.peyton.plum.core.inf.controller.RealizeController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.mall.param.party.ContactGroupParam;
import cn.peyton.plum.mall.service.party.ContactGroupService;
import cn.peyton.plum.mall.service.party.ContactService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h3> 通讯录分组 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年01月11日 20:51:40
 * @version 1.0.0
 * </pre>
*/
@RestController
@RequestMapping("/pc/contactgroup")
public class ContactGroupController extends RealizeController
		implements IController<Integer, ContactGroupParam> {

	@Resource
	private ContactGroupService contactGroupService;
	@Resource
	private ContactService contactService;

	@Token
	@Valid
	@PostMapping("/manager/search")
	@Override
	public JSONResult<?> list(Query query) {
		ContactGroupParam _param = new ContactGroupParam();
		_param.setName(query.getKeyword());
		// 其他处理判断
		return page(_param, new PageQuery(query.getPageNo(), ORDER_BY_FILED), contactGroupService, true);
	}

	@Token
	@Valid
	@PostMapping("/manager/create")
	@Override
	public JSONResult<?> create(ContactGroupParam record) {
		ContactGroupParam _param = new ContactGroupParam();
		_param.setName(record.getName());
		return handle(record, _param, false, contactGroupService, TIP_GROUP, CREATE);
	}

	@Token
	@Valid
	@PostMapping("/manager/edit")
	@Override
	public JSONResult<?> edit(ContactGroupParam record) {
		ContactGroupParam _param = new ContactGroupParam();
		_param.setName(record.getName());
		_param.setId(record.getId());
		return handle(record, _param, true, contactGroupService, TIP_GROUP, UPDATE);
	}

	@Token
	@Valid
	@PostMapping("/manager/delete")
	@Override
	public JSONResult<?> delete(@NotBlank(message = "Id 不能为空;") @Min(value = 1,message = "最小为1")Integer id) {
		if(contactService.isContactGroup(id)){
			return JSONResult.fail(JOIN_DATA + DELETE);
		}
		return delete(id, contactGroupService, TIP_GROUP);
	}
}
