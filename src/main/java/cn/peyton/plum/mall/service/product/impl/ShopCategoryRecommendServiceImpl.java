package cn.peyton.plum.mall.service.product.impl;

import cn.peyton.plum.core.err.TransactionalException;
import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.RealizeService;
import cn.peyton.plum.mall.bo.ShopCategoryRecommendBo;
import cn.peyton.plum.mall.mapper.product.ShopCategoryRecommendMapper;
import cn.peyton.plum.mall.param.product.ShopCategoryRecommendParam;
import cn.peyton.plum.mall.pojo.product.ShopCategoryRecommend;
import cn.peyton.plum.mall.service.product.ShopCategoryRecommendService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <h3> 商品分类推荐 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年12月09日 19:33:21
 * @version 1.0.0
 * </pre>
*/
@Service("shopCategoryRecommendService")
public class ShopCategoryRecommendServiceImpl extends RealizeService<Long, ShopCategoryRecommend, ShopCategoryRecommendParam> implements ShopCategoryRecommendService {
	@Resource
	private ShopCategoryRecommendMapper shopCategoryRecommendMapper;

	@Override
	public BaseConvertBo<ShopCategoryRecommend, ShopCategoryRecommendParam> bo() {
		return new ShopCategoryRecommendBo();
	}

	@Override
	public IBaseMapper<Long, ShopCategoryRecommend> mapper() {
		return shopCategoryRecommendMapper;
	}

	public ShopCategoryRecommendServiceImpl(){
		// 开启缓存
		enabledCache = true;
		//设置缓存 key 的前缀
		keyPrefix = this.getClass().getName();
	}

	@Override
	public ShopCategoryRecommendParam findByCategoryId(Integer categoryId) {
		ShopCategoryRecommend res = shopCategoryRecommendMapper.selectByCategoryId(categoryId);
		return (null == res) ?null: new ShopCategoryRecommendBo().compat(res);
	}

	@Override
	@Transactional(rollbackFor = {TransactionalException.class})
	public Boolean batchCreate(List<ShopCategoryRecommendParam> list) {
		int res = 0;
		shopCategoryRecommendMapper.deleteByJoinId(null, list.get(0).getCategoryId());
		res = shopCategoryRecommendMapper.batchInsert(bo().reverse(list));
		if (res > 0) {
			clearCache("批量新增商品分类推荐");
			return true;
		}
		return false;
	}

	@Override
	public Boolean deleteByJoinId(Long productId, Integer categoryId) {
		int res = shopCategoryRecommendMapper.deleteByJoinId(productId,categoryId);
		if (res > 0) {
			clearCache("删除商品分类推荐");
			return true;
		}
		return false;
	}
}
