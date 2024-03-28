package cn.peyton.plum.mall.service.join.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.RealizeService;
import cn.peyton.plum.mall.bo.ShopArrearPoolBo;
import cn.peyton.plum.mall.mapper.join.ShopArrearPoolMapper;
import cn.peyton.plum.mall.param.join.ShopArrearPoolParam;
import cn.peyton.plum.mall.pojo.join.ShopArrearPool;
import cn.peyton.plum.mall.service.join.ShopArrearPoolService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * <h3> 欠款汇总 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年01月30日 11:33:43
 * @version 1.0.0
 * </pre>
*/
@Service("shopArrearPoolService")
public class ShopArrearPoolServiceImpl extends RealizeService<Long, ShopArrearPool, ShopArrearPoolParam>
		implements ShopArrearPoolService {
	@Resource
	private ShopArrearPoolMapper shopArrearPoolMapper;

	@Override
	public BaseConvertBo<ShopArrearPool, ShopArrearPoolParam> bo() {
		return new ShopArrearPoolBo();
	}

	@Override
	public IBaseMapper<Long, ShopArrearPool> mapper() {
		return shopArrearPoolMapper;
	}

	public ShopArrearPoolServiceImpl(){
		// 开启缓存
		enabledCache = true;
		//设置缓存 key 的前缀
		keyPrefix = this.getClass().getName();
	}

	@Override
	public BigDecimal calcBalance() {
		return shopArrearPoolMapper.calcBalance();
	}
}
