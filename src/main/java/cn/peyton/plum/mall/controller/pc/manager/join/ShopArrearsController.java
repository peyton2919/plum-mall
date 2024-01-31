package cn.peyton.plum.mall.controller.pc.manager.join;


import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.inf.controller.IBasePCController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.mall.controller.base.PcController;
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
 * @date 2024年01月16日 21:12:27
 * @version 1.0.0
 * </pre>
*/
@RestController
@RequestMapping("/pc/arrears")
public class ShopArrearsController extends PcController<ShopArrearsParam>
		implements IBasePCController<Long,  ShopArrearsParam> {

	@Resource
	private ShopArrearsService shopArrearsService;

	// memberId 客户Id,  repayType 还款方式: 0 微信 1 支付宝 2 转账 3 现金 4 其他, debt 欠款金额, actualPayment 实际付款金额 , page 分页,
	// timeInterval 查找时段{今天 7天 1个月 6个月 1年}, mode 查找方向 {欠款 | 还款}, status 状态 0 未清 1 已清,

	@Override
	public JSONResult<?> list(Query<ShopArrearsParam> query) {
		return null;
	}

	@Token
	@Valid(ignore = {"member","updateTime","repayDebt","isMulti","repayType"})
	@PostMapping("/manager/create")
	@Override
	public JSONResult<?> create(ShopArrearsParam record) {
		//return baseHandleCreate(record, null, shopArrearsService, TIP_ARREARS);
		return baseHandle(shopArrearsService.joinCreate(record), TIP_ARREARS,CREATE);
	}

	@Token
	@Valid
	@PostMapping("/manager/edit")
	@Override
	public JSONResult<?> edit(ShopArrearsParam record) {
		return baseHandleEdit(record, null, shopArrearsService, TIP_ARREARS,UPDATE);
	}

	@Override
	public JSONResult<?> delete(Long id) {
		return null;
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
		return JSONResult.success(shopArrearsService.findMulti(query.getMemberId(), 0, query.getRepayType(), query.getDebt(),query.getActualPayment(),page,null,null));
	}

	@Token
	@Valid
	@PostMapping("/manager/memberid")
	public JSONResult<?> findBymemberId(@NotBlank(message = "会员ID 不能为空;") @Min(value = 1,message = "最小值为1")Long memberId) {

		return baseHandleList(shopArrearsService.findByMemberId(memberId, STATUS_0), null);
	}


}
