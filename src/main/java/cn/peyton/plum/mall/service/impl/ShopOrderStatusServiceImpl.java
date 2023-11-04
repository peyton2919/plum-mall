package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.mall.service.ShopOrderStatusService;
import cn.peyton.plum.mall.mapper.ShopOrderStatusMapper;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;

/**
 * <h3> 订单操作记录 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
@Service("shopOrderStatusService")
public class ShopOrderStatusServiceImpl implements ShopOrderStatusService {
	@Resource
	private ShopOrderStatusMapper shopOrderStatusMapper;

}