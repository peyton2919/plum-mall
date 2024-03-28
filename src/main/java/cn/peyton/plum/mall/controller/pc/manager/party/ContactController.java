package cn.peyton.plum.mall.controller.pc.manager.party;

import cn.peyton.plum.core.anno.resolver.RequestMultiple;
import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.inf.controller.IController;
import cn.peyton.plum.core.inf.controller.RealizeController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.core.validator.Regulation;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.mall.param.party.ContactParam;
import cn.peyton.plum.mall.service.party.ContactService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <h3>通讯录 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年01月11日 20:51:29
 * @version 1.0.0
 * </pre>
*/
@RestController
@RequestMapping("/pc/contact")
public class ContactController extends RealizeController
		implements IController<Integer, ContactParam> {

	@Resource
	private ContactService contactService;

	// intValue:groupId
	@Token
	@Valid
	@PostMapping("/manager/search")
	@Override
	public JSONResult<?> list(Query query) {
		if (null == query || null == query.getIntValue() || query.getIntValue() < 1) {
			return JSONResult.fail(ERROR);
		}
		ContactParam _param = new ContactParam();
		_param.setGroupId(query.getIntValue());
		// 其他处理判断
		return page(_param, new PageQuery(query.getPageNo()), contactService,true);
	}

	//
	@Token
	@PostMapping("/manager/findkeyword")
	public JSONResult<?> findBykeyword(String keyword,
		  @NotBlank(message = "页码 不能为空;") @Min(value = 1,message = "最小值为1")Integer pageNo) {
		ContactParam _param = new ContactParam();
		if (Regulation.regex(Regulation.REGEX_INT ,keyword)){
			_param.setPhone(keyword);
		} else {
			_param.setName(keyword);
		}

		// 其他处理判断
		return page(_param, new PageQuery(pageNo), contactService,true);
	}

	@Token
	@Valid(ignore = {"contactGroup","createTime"})
	@PostMapping("/manager/create")
	@Override
	public JSONResult<?> create(@RequestMultiple ContactParam record) {
		// 判断电话正确性
		if (null == record || null == record.getPhone() || "".equals(record.getPhone())) {
			return JSONResult.fail(ERROR);
		}
		if(!regexp(record.getPhone())){
			return JSONResult.fail(TELPHONE + INCORRECT);
		}
		return handle(record, null,false, contactService, TIP_CONTACT,CREATE);
	}

	@Token
	@Valid(ignore = {"contactGroup","createTime"})
	@PostMapping("/manager/edit")
	@Override
	public JSONResult<?> edit(@RequestMultiple ContactParam record) {
		// 判断电话正确性
		if (null == record || null == record.getPhone() || "".equals(record.getPhone())) {
			return JSONResult.fail(ERROR);
		}
		if(!regexp(record.getPhone())){
			return JSONResult.fail(TELPHONE + INCORRECT);
		}
		return handle(record, null, true, contactService, TIP_CONTACT, UPDATE);
	}

	@Token
	@PostMapping("/manager/repeat")
	public JSONResult<?> repeat(ContactParam record) {
		if (contactService.repeat(record)) {
			return JSONResult.fail(REPEAT);
		}
		return JSONResult.success();
	}

	@Token
	@Valid
	@PostMapping("/manager/delete")
	@Override
	public JSONResult<?> delete(@NotBlank(message = "Id 不能为空;") @Min(value = 1,message = "Id最小为值1")Integer id) {

		return delete(id, contactService, TIP_CONTACT);
	}

	/**
	 * <h4>验证手机号码</h4>
	 * @param phone 拼接手机号码
	 * @return 验证通过为 true 没通过为 false
	 */
	private boolean regexp(String phone) {
		if(null == phone || "".equals(phone)){
			return true;
		}
		String[] splits = phone.split(",");
		Pattern pattern;
		Matcher matcher;
		for (String s : splits) {
			pattern = Pattern.compile(Regulation.REGEX_TEL_PHONE);
			matcher = pattern.matcher(s.trim());
			if (matcher.matches()) {
				return true;
			}
		}
		return false;

	}
}
