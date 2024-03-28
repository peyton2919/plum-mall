package cn.peyton.plum.mall.controller.pc.manager.product;

import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.inf.controller.IController;
import cn.peyton.plum.core.inf.controller.RealizeController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.core.validator.constraints.Size;
import cn.peyton.plum.mall.param.product.ShopStockParam;
import cn.peyton.plum.mall.service.product.ShopStockService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h3> 商品库存汇总 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年12月29日 20:46:35
 * @version 1.0.0
 * </pre>
*/
@RestController
@RequestMapping("/pc/shopstock")
public class ShopStockController extends RealizeController
		implements IController<Long, ShopStockParam> {

	@Resource
	private ShopStockService shopStockService;

	// 更新是否显示库存
	@Token
	@Valid
	@PostMapping("/manager/upisshow")
	public JSONResult<?> upIsShow(@NotBlank(message = "库存Id不能为空") @Min(value = 1,message = "库存Id最小值为1") Long id,
			@NotBlank(message = "是否显示不能为空") @Size(min = 0, max = 1) Integer isShow) {
		return handle(shopStockService.updateIsShow(id,isShow), TIP_SHOP_STOCK,OPERATE,UPDATE);
	}

	// 更新库存预警
	@Token
	@Valid
	@PostMapping("/manager/upminstock")
	public JSONResult<?> upMinStock(@NotBlank(message = "库存Id不能为空") @Min(value = 1,message = "库存Id最小值为1") Long id,
								  @NotBlank(message = "库存预警不能为空") @Size(min = 0, max = 1) Integer minStock) {
		return handle(shopStockService.updateMinStock(id, minStock), TIP_SHOP_STOCK, OPERATE, UPDATE);
	}

	// 更新库存 record{id,isShow,minStock}, keyInt:warehouseId,str: warehouseExplain,keyLong:psdId

	@Override
	public JSONResult<?> list(Query<ShopStockParam> query) {
		return null;
	}

	@Override
	public JSONResult<?> create(ShopStockParam record) {
		return null;
	}

	// 更新库存预警 editStock id 主键,isShow 是否显示库存,minStock  库存预警
	@Token
	@Valid
	@PostMapping("/manager/edit")
	@Override
	public JSONResult<?> edit(ShopStockParam record) {

		return handle(record, null, true, shopStockService, TIP_SHOP_STOCK, UPDATE);
	}

	@Override
	public JSONResult<?> delete(Long id) {
		return null;
	}
}
