package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.mall.service.ShopCartService;
import cn.peyton.plum.mall.mapper.ShopCartMapper;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;

/**
 * <h3> 购物车 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
@Service("shopCartService")
public class ShopCartServiceImpl implements ShopCartService {
	@Resource
	private ShopCartMapper shopCartMapper;

}
