package cn.peyton.plum.mall.controller.pc.manager.app;


import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.inf.controller.IController;
import cn.peyton.plum.core.inf.controller.RealizeController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.core.utils.base.CtrlUtils;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.core.validator.constraints.Size;
import cn.peyton.plum.mall.param.app.AppNavParam;
import cn.peyton.plum.mall.service.app.AppNavService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h3> App 导航 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年01月20日 09:24:55
 * @version 1.0.0
 * </pre>
*/
@RestController
@RequestMapping("/pc/appnav")
public class AppNavController extends RealizeController
		implements IController<Integer, AppNavParam> {

	@Resource
	private AppNavService appNavService;

	@Token
	@Valid
	@PostMapping("/manager/search")
	@Override
	public JSONResult<?> list(Query query) {
		AppNavParam _param = new AppNavParam();

		_param.setTitle(query.getKeyword());
		// 其他处理判断
		return page(_param, new PageQuery(query.getPageNo(), ORDER_BY_FILED), appNavService,true);
	}

	@Token
	@Valid
	@PostMapping("/manager/create")
	@Override
	public JSONResult<?> create(AppNavParam record) {
		AppNavParam _repeat = new AppNavParam();
		_repeat.setSrc(new CtrlUtils().convertImgPath(_repeat.getSrc()));
		_repeat.setTitle(record.getTitle());
		return handle(record, _repeat,false, appNavService, TIP_APP_NAV,CREATE);
	}

	@Token
	@Valid
	@PostMapping("/manager/edit")
	@Override
	public JSONResult<?> edit(AppNavParam record) {
		AppNavParam _repeat = new AppNavParam();
		_repeat.setId(record.getId());
		_repeat.setTitle(record.getTitle());
		_repeat.setSrc(new CtrlUtils().convertImgPath(_repeat.getSrc()));
		return handle(record, _repeat,true, appNavService, TIP_APP_NAV,UPDATE);
	}

	@Token
	@Valid
	@PostMapping("/manager/delete")
	@Override
	public JSONResult<?> delete(@NotBlank(message = "APP分类Id 不能为空;") @Min(value = 1,message = "最小值为1")Integer id) {
		return delete(id,appNavService,TIP_APP_NAV);
	}

	@Token
	@Valid
	@PostMapping("/manager/upstatus")
	public JSONResult<?> updateStatus(@NotBlank(message = "Id 不能为空;") @Min(value = 1,message = "最小为1")Integer id,
									  @Size(min = 0,max = 1) @NotBlank(message = "状态 不能为空;")Integer status) {
		AppNavParam _param = new AppNavParam();
		_param.setId(id);
		_param.setStatus(status);
		return handle(appNavService.upStatus(id, status), TIP_APP_NAV, STATUS, UPDATE);
	}
}
