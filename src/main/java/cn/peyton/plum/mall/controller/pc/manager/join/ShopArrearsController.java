package cn.peyton.plum.mall.controller.pc.manager.join;

import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.inf.controller.IController;
import cn.peyton.plum.core.inf.controller.RealizeController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.mall.param.join.ShopArrearsParam;
import cn.peyton.plum.mall.service.join.ShopArrearsService;
import cn.peyton.plum.mall.vo.ArrearVo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h3> 欠款信息 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年02月06日 22:33:31
 * @version 1.0.0
 * </pre>
*/
@RestController
@RequestMapping("/pc/arrears")
public class ShopArrearsController extends RealizeController
		implements IController<Long, ShopArrearsParam> {

	@Resource
	private ShopArrearsService shopArrearsService;

	@Override
	public JSONResult<?> list(Query<ShopArrearsParam> query) {
		return null;
	}

	@Token
	@Valid(ignore = {"shopRepayments",})
	@PostMapping("/manager/create")
	@Override
	public JSONResult<?> create(ShopArrearsParam record) {
		return handle(shopArrearsService.joinCreate(record), TIP_ARREARS,CREATE);
	}

	@Override
	public JSONResult<?> edit(ShopArrearsParam record) {
		return null;
	}

	@Override
	public JSONResult<?> delete(Long id) {
		return null;
	}

	// memberId,oid,status,money,create_time[startTime,endTime]
	@Token
	@Valid
	@PostMapping("/manager/multi")
	public JSONResult<?> multi(ArrearVo query) {
		PageQuery page = new PageQuery();
		page.setPageNo(query.getPageNo());
		if(null != query.getLimit()){
			page.setPageSize(query.getLimit());
		}
		initParam(query);
		return JSONResult.success(shopArrearsService.findMulti(query,page));
	}

	@Token
	@Valid
	@PostMapping("/manager/search")
	public JSONResult<?> search(ArrearVo query) {
		PageQuery page = new PageQuery();
		page.setPageNo(query.getPageNo());
		if(null != query.getLimit()){
			page.setPageSize(query.getLimit());
		}
		initParam(query);
		return JSONResult.success(shopArrearsService.findJoin(query,page));
	}

	@Token
	@Valid
	@PostMapping("/manager/memberid")
	public JSONResult<?> findBymemberId(@NotBlank(message = "会员ID 不能为空;") @Min(value = 1,message = "最小值为1")Long memberId) {

		return list(shopArrearsService.findByMemberId(memberId, STATUS_0), null);
	}

	private void initParam(ArrearVo query){
		if(null != query.getRepayType() && query.getRepayType() == -1){
			query.setRepayType(null);
		}
		if ("all".equals(query.getTimeInterval())) {
			query.setTimeInterval(null);
		}
	}

}
