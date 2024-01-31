package cn.peyton.plum.mall.controller.pc.manager.app;

import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.inf.controller.IBasePCController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.core.validator.constraints.Size;
import cn.peyton.plum.mall.controller.base.PcController;
import cn.peyton.plum.mall.param.app.AppCategoryParam;
import cn.peyton.plum.mall.service.app.AppCategoryService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h3> App 分类 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年01月20日 09:24:43
 * @version 1.0.0
 * </pre>
*/
@RestController
@RequestMapping("/pc/appcategory")
public class AppCategoryController extends PcController<AppCategoryParam>
		implements IBasePCController<Integer, AppCategoryParam> {

	@Resource
	private AppCategoryService appCategoryService;

	@Token
	@Valid
	@PostMapping("/manager/search")
	@Override
	public JSONResult<?> list(Query query) {
		AppCategoryParam _param = new AppCategoryParam();

		_param.setName(query.getKeyword());
		// 其他处理判断
		return baseHandleList(_param, new PageQuery(query.getPageNo(), ORDER_BY_FILED), appCategoryService,null);
	}

	@Token
	@Valid
	@PostMapping("/manager/create")
	@Override
	public JSONResult<?> create(AppCategoryParam record) {
		AppCategoryParam _repeat = new AppCategoryParam();
		_repeat.setName(record.getName());
		return baseHandleCreate(record, _repeat, appCategoryService, TIP_APP_CATEGORY);
	}

	@Token
	@Valid
	@PostMapping("/manager/edit")
	@Override
	public JSONResult<?> edit(AppCategoryParam record) {
		AppCategoryParam _repeat = new AppCategoryParam();
		_repeat.setId(record.getId());
		_repeat.setName(record.getName());
		return baseHandleEdit(record, _repeat, appCategoryService, TIP_APP_CATEGORY,UPDATE);
	}

	@Token
	@Valid
	@PostMapping("/manager/delete")
	@Override
	public JSONResult<?> delete(@NotBlank(message = "APP分类Id 不能为空;") @Min(value = 1,message = "最小值为1")Integer id) {
		return baseHandleDelete(id,appCategoryService,TIP_APP_CATEGORY);
	}

	@Token
	@Valid
	@PostMapping("/manager/upstatus")
	public JSONResult<?> updateStatus(@NotBlank(message = "Id 不能为空;") @Min(value = 1,message = "最小为1")Integer id,
			  @Size (min = 0,max = 1) @NotBlank(message = "状态 不能为空;")Integer status) {
		AppCategoryParam _param = new AppCategoryParam();
		_param.setId(id);
		_param.setStatus(status);
		//return baseHandleEdit(_param,null,appCategoryService,TIP_APP_CATEGORY,STATUS);
		return baseHandle(appCategoryService.upStatus(id, status), TIP_APP_CATEGORY, STATUS, UPDATE);
	}
}
