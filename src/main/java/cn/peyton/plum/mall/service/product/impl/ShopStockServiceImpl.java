package cn.peyton.plum.mall.service.product.impl;

import cn.peyton.plum.core.err.TransactionalException;
import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.RealizeService;
import cn.peyton.plum.mall.bo.ShopStockBo;
import cn.peyton.plum.mall.mapper.product.ShopProductSkuDetailMapper;
import cn.peyton.plum.mall.mapper.product.ShopStockMapper;
import cn.peyton.plum.mall.param.product.ShopStockParam;
import cn.peyton.plum.mall.pojo.product.ShopStock;
import cn.peyton.plum.mall.service.product.ShopStockService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <h3> 商品库存汇总 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年12月29日 20:46:35
 * @version 1.0.0
 * </pre>
*/
@Service("shopStockService")
public class ShopStockServiceImpl  extends RealizeService<Long, ShopStock, ShopStockParam> implements ShopStockService {
	@Resource
	private ShopStockMapper shopStockMapper;
	@Resource
	private ShopProductSkuDetailMapper shopProductSkuDetailMapper;

	@Override
	public BaseConvertBo<ShopStock,ShopStockParam> bo() {
		return new ShopStockBo();
	}

	@Override
	public IBaseMapper<Long, ShopStock> mapper() {
		return shopStockMapper;
	}

	public ShopStockServiceImpl(){
		// 开启缓存
		enabledCache = true;
		//设置缓存 key 的前缀
		keyPrefix = this.getClass().getName();
	}

	@Override
	public List<ShopStockParam> findByIds(List<Long> ids) {
		return bo().adapter(shopStockMapper.selectByIds(ids));
	}

	@Override
	@Transactional
	public Boolean joinEdit(ShopStockParam record, Long psdId, Integer warehouseId, String warehouseExplain) {
		int res = shopStockMapper.updateSelective(record.convert());
		if (res > 0) {
			if (shopProductSkuDetailMapper.updateWarehouse(psdId, warehouseId, warehouseExplain) > 0) {
				clearCache("更新仓库");
				return true;
			}else {
				throw new TransactionalException("[ShopStockServiceImpl-{joinEdit}] 事务回滚");
			}
		}
		return false;
	}

	@Override
	public Boolean updateMinStock(Long id, Integer minStock) {
		int res = shopStockMapper.updateMinStock(id, minStock);
		if (res > 0) {
			clearCache("更新仓库");
			return true;
		}
		return false;
	}

	@Override
	public Boolean updateIsShow(Long id, Integer isShow) {
		int res = shopStockMapper.updateIsShow(id, isShow);
		if (res > 0) {
			clearCache("更新仓库");
			return true;
		}
		return false;
	}
}
