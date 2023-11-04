package cn.peyton.plum.mall.controller;

import cn.peyton.plum.mall.service.ShopProductReplyService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h3> 商品评论 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
@RestController
public class ShopProductReplyController {

	@Resource
	private ShopProductReplyService shopProductReplyService;

}
