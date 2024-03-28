package cn.peyton.plum.mall.controller.pc.manager.join;

import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.inf.controller.IController;
import cn.peyton.plum.core.inf.controller.RealizeController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.mall.param.join.ShopArrearPoolParam;
import cn.peyton.plum.mall.service.join.ShopArrearPoolService;
import cn.peyton.plum.mall.service.party.MemberService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h3> 欠款汇总 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年01月30日 11:33:43
 * @version 1.0.0
 * </pre>
*/
@RestController
@RequestMapping("/pc/arrearpool")
public class ShopArrearPoolController extends RealizeController
		implements IController<Long, ShopArrearPoolParam> {

	@Resource
	private ShopArrearPoolService shopArrearPoolService;
	@Resource
	private MemberService memberService;

	@Token
	@Valid
	@PostMapping("/manager/search")
	@Override
	public JSONResult<?> list(Query query) {
		ShopArrearPoolParam _param = new ShopArrearPoolParam();
		_param.setStatus(STATUS_0);
		return page(_param, new PageQuery(query.getPageNo()), shopArrearPoolService, shopArrearPoolService.calcBalance(), true);
	}

	@Override
	public JSONResult<?> create(ShopArrearPoolParam record) {
		return null;
	}

	@Override
	public JSONResult<?> edit(ShopArrearPoolParam record) {
		return null;
	}

	@Override
	public JSONResult<?> delete(Long id) {
		return null;
	}
}
