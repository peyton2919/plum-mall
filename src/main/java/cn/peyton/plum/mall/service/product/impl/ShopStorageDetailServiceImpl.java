package cn.peyton.plum.mall.service.product.impl;

import cn.peyton.plum.core.err.TransactionalException;
import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.PageResult;
import cn.peyton.plum.core.utils.DateUtils;
import cn.peyton.plum.mall.bo.ShopStorageDetailBo;
import cn.peyton.plum.mall.mapper.product.ShopProductSkuDetailMapper;
import cn.peyton.plum.mall.mapper.product.ShopStockMapper;
import cn.peyton.plum.mall.mapper.product.ShopStorageDetailMapper;
import cn.peyton.plum.mall.param.product.ShopStorageDetailParam;
import cn.peyton.plum.mall.pojo.product.ShopStock;
import cn.peyton.plum.mall.pojo.product.ShopStorageDetail;
import cn.peyton.plum.mall.service.product.ShopStorageDetailService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <h3> 商品入库明细 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年12月29日 20:47:02
 * @version 1.0.0
 * </pre>
*/
@Service("shopStorageDetailService")
public class ShopStorageDetailServiceImpl  extends AbstractRealizeService<Long, ShopStorageDetail, ShopStorageDetailParam> implements ShopStorageDetailService {
	@Resource
	private ShopStorageDetailMapper shopStorageDetailMapper;
	@Resource
	private ShopStockMapper shopStockMapper;
	@Resource
	private ShopProductSkuDetailMapper shopProductSkuDetailMapper;

	@Override
	public BaseConvertBo<ShopStorageDetail, ShopStorageDetailParam> initBo() {
		return new ShopStorageDetailBo();
	}

	@Override
	public IBaseMapper<Long, ShopStorageDetail> initMapper() {
		return shopStorageDetailMapper;
	}

	public ShopStorageDetailServiceImpl(){
		// 开启缓存
		enabledCache = true;
		//设置缓存 key 的前缀
		keyPrefix = this.getClass().getName();
	}

	@Override
	public Integer storageTotal(Long stockId) {
		return shopStorageDetailMapper.storageTotal(stockId);
	}

	@Override
	public PageResult<ShopStorageDetailParam> findByStockId(Long stockId, PageQuery page, Integer startTime, Integer endTime) {
		PageResult<ShopStorageDetailParam> result = new PageResult<>();
		List<ShopStorageDetail> shopStorageDetails = shopStorageDetailMapper.selectByStockId(stockId, page, startTime, endTime);
		if (null != shopStorageDetails && shopStorageDetails.size() > 0) {
			result.setData(new ShopStorageDetailBo().adapter(shopStorageDetails));
			result.setTotalRows(shopStorageDetailMapper.countByStockId(stockId, startTime, endTime));
			return result;
		}
		result.isSuccess = false;
		return result;
	}

	@Override
	@Transactional
	public Boolean joinCreate(Long psdId, Integer quantity) {
		ShopStorageDetail ssd = new ShopStorageDetail();
		ShopStock _ss = shopStockMapper.isExist(psdId);
		if (null == _ss) {  // 新增
			ShopStock _r = new ShopStock();
			_r.setPsdId(psdId);
			shopStockMapper.insertSelective(_r);
			if (null == _r.getId() || _r.getId() < 1) {
				throw new TransactionalException("[{ShopStorageDetailServiceImpl}-{joinCreate}] 新增入库出现了异常");
			}
			// 更新 商品规格明细中 库存Id
			if (shopProductSkuDetailMapper.updateStockId(psdId, _r.getId()) == 0) {
				throw new TransactionalException("[{ShopStorageDetailServiceImpl}-{joinCreate}] 新增入库出现了异常");
			}
			ssd.setStockId(_r.getId());
		}else {
			ssd.setStockId(_ss.getId());
		}
		ssd.setCreateTime(DateUtils.dateToTimestamp());
		ssd.setQuantity(quantity);
		int res = shopStorageDetailMapper.insertSelective(ssd);
		if (res > 0) {
			if (shopStockMapper.updateTotal(ssd.getStockId()) > 0) {
				if (enabledCache) {
					System.out.println("[更新操作,清空缓存");
					removeCache();
				}
				return true;
			}
		}
		if (res < 1) {
			throw new TransactionalException("[{ShopStorageDetailServiceImpl}-{joinCreate}] 新增入库出现了异常");
		}
		return false;
	}

	@Override
	public Boolean joinEdit(Long id, Long psdId, Long stockId, Integer quantity) {

		// 获取数量
		Integer _q = shopStorageDetailMapper.selectQuantityById(id);
		if (quantity >= _q) {
			if (shopStockMapper.isDeduction(psdId, (quantity - _q)) == 0) {
				return false;
			}
		}
		ShopStorageDetail _ssd = new ShopStorageDetail();
		_ssd.setId(id);
		_ssd.setQuantity(quantity);
		if (shopStorageDetailMapper.updateSelective(_ssd) > 0 && shopStockMapper.updateTotal(stockId) > 0) {

			if (enabledCache) {
				System.out.println("修改操作,清空缓存");
				removeCache();
			}
			return true;
		}else {
			throw new TransactionalException("[{ShopStorageDetailServiceImpl}-{joinEdit}] 修改入库出现了异常");
		}

	}
}
