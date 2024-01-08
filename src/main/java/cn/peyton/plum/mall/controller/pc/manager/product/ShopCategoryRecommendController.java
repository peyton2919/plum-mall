package cn.peyton.plum.mall.controller.pc.manager.product;

import cn.peyton.plum.core.anno.resolver.RequestMultiple;
import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.inf.controller.IBasePCController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.FormData;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.core.utils.DateUtils;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.mall.controller.base.PcController;
import cn.peyton.plum.mall.param.product.ShopCategoryRecommendParam;
import cn.peyton.plum.mall.service.product.ShopCategoryRecommendService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <h3> 商品分类推荐 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年12月09日 19:39:49
 * @version 1.0.0
 * </pre>
*/
@RestController
@RequestMapping("/pc/categoryrecommend")
public class ShopCategoryRecommendController extends PcController<ShopCategoryRecommendParam>
        implements IBasePCController<Long, ShopCategoryRecommendParam> {

	@Resource
	private ShopCategoryRecommendService shopCategoryRecommendService;

	public JSONResult<?> all(String keyword, Integer pageNo) {
		return null;
	}

	@Override
	public JSONResult<?> list(Query query) {
		return null;
	}

	@Override
	public JSONResult<?> create(ShopCategoryRecommendParam record) {
		return null;
	}

	@Override
	public JSONResult<?> edit(ShopCategoryRecommendParam record) {
		return null;
	}

	@Override
	public JSONResult<?> delete(Long id) {
		return null;
	}

	// 删除分类推荐
	@Token
	@Valid
	@PostMapping("/manager/delete")
	public JSONResult<?> joinDelete(@NotBlank(message = "Id 不能为空;") @Min(value = 1,message = "最小为1")Long productId,
				@NotBlank(message = "Id 不能为空;") @Min(value = 1,message = "最小为1")Integer categoryId) {

		return baseHandle(shopCategoryRecommendService.deleteByJoinId(productId, categoryId), DATA, DELETE);
	}

	//category_id 分类Id,cover 商品封面,create_time 创建时间,product_id 商品Id,id,name 商品名称,seq 排序,
	// 查找 分类-推荐列表
	@Token
	@Valid
	@PostMapping("/manager/product")
	public JSONResult<?> findProduct(@NotBlank(message = "Id 不能为空;") @Min(value = 1,message = "最小为1")Integer id) {
		ShopCategoryRecommendParam res = shopCategoryRecommendService.findByCategoryId(id);

		return JSONResult.success((null == res)? new ShopCategoryRecommendParam():res);
	}

	@Token
	@Valid
	@PostMapping("/manager/connect")
	public JSONResult<?> connect(@RequestMultiple FormData data) {
		Integer categoryId = data.getKeyInt();
		List<Long> longs = data.getLongs();
		if (categoryId < 1 || null == longs || longs.size() < 1) {
			return JSONResult.fail("没有关联数据");
		}
		List<ShopCategoryRecommendParam> _params = new ArrayList<>();
		ShopCategoryRecommendParam _p = null;
		for (int i = 0; i < longs.size(); i++) {
			_p = new ShopCategoryRecommendParam();
			_p.setCategoryId(categoryId);
			_p.setProductId(longs.get(i));
			_p.setSeq(Short.parseShort("0"));
			_p.setCreateTime(DateUtils.dateToTimestamp(new Date()));
			_params.add(_p);
		}
		if (shopCategoryRecommendService.batchCreate(_params)) {
			return JSONResult.success("推荐商品关联成功");
		}
		return JSONResult.fail("推荐商品关联失败");
	}
}
