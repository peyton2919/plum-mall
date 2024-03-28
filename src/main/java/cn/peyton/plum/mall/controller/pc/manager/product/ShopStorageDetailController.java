package cn.peyton.plum.mall.controller.pc.manager.product;

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
import cn.peyton.plum.mall.param.product.ShopStorageDetailParam;
import cn.peyton.plum.mall.service.product.ShopStorageDetailService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h3> 商品入库明细 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年12月29日 20:47:02
 * @version 1.0.0
 * </pre>
*/
@RestController
@RequestMapping("/pc/storagedetail")
public class ShopStorageDetailController extends RealizeController
		implements IController<Long,  ShopStorageDetailParam> {

	@Resource
	private ShopStorageDetailService shopStorageDetailService;

	// Long stockId, PageQuery page, Integer startTime, Integer endTime
	// longValue pageNo,keyword{startTime,endTime}
	@Token
	@Valid
	@PostMapping("/manager/search")
	@Override
	public JSONResult<?> list(Query query) {
		Long stockId = query.getLongValue();
		if (null == stockId || stockId < 1) {
			return JSONResult.fail(PARAM + ERROR_SIMPLE);
		}

		int[] times = new CtrlUtils().convertStrToBetweenIntArray(query.getKeyword());
		return page(shopStorageDetailService.findByStockId(stockId, new PageQuery(query.getPageNo()), times[0], times[1]));
	}

	@Token
	@Valid
	@PostMapping("/manager/create")
	public JSONResult<?> joinCreate(@NotBlank(message = "商品规格明细Id不能为空") @Min(value = 1,message = "商品规格明细Id最小值为1") Long psdId,
		@NotBlank(message = "数量不能为空") @Min(value = 1,message = "数量最小值为1")Integer quantity) {

		return handle(shopStorageDetailService.joinCreate(psdId, quantity), TIP_SHOP_STOCK, CREATE);
	}

	//Boolean joinEdit(Long id, Long psdId, Long stockId, Integer quantity);
	@Token
	@Valid
	@PostMapping("/manager/edit")
	public JSONResult<?> joinEidt(@NotBlank(message = "入库Id不能为空") @Min(value = 1,message = "入库Id最小值为1") Long id,
			@NotBlank(message = "商品规格明细Id不能为空") @Min(value = 1,message = "商品规格明细Id最小值为1") Long psdId,
			@NotBlank(message = "库存Id不能为空") @Min(value = 1,message = "库存Id最小值为1") Long stockId,
			@NotBlank(message = "数量不能为空") @Min(value = 1,message = "数量最小值为1")Integer quantity) {

		return handle(shopStorageDetailService.joinEdit(id, psdId, stockId, quantity), TIP_SHOP_STOCK, MODIFY);
	}

	@Override
	public JSONResult<?> create(ShopStorageDetailParam record) {
		return null;
	}

	@Override
	public JSONResult<?> edit(ShopStorageDetailParam record) {
		return null;
	}

	@Override
	public JSONResult<?> delete(Long id) {
		return null;
	}
}
