package cn.peyton.plum.mall.controller;

import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.mall.param.ShopSkuValueParam;
import cn.peyton.plum.mall.service.ShopSkuValueService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h3> 商品规格 值表 Controller 类</h3>
 * extends AbstractAppRealizeService<Long, ShopSkuValue, ShopSkuValueParam>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
@RestController
public class ShopSkuValueController  {

	@Resource
	private ShopSkuValueService shopSkuValueService;


	@GetMapping("/svTest")
	public JSONResult svTest(){
		ShopSkuValueParam param = new ShopSkuValueParam();
		param.setSeq(100);
		param.setSkuValue("黑色");
		param.setSkuId(1L);
		shopSkuValueService.add(param);
		return JSONResult.success(param);
	}

}
