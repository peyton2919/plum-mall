package cn.peyton.plum.mall.service.product.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.PageResult;
import cn.peyton.plum.mall.bo.ShopProductSkuJoinBo;
import cn.peyton.plum.mall.mapper.product.ShopProductSkuJoinMapper;
import cn.peyton.plum.mall.param.product.ShopProductSkuJoinParam;
import cn.peyton.plum.mall.pojo.product.ShopProductSkuJoin;
import cn.peyton.plum.mall.service.product.ShopProductSkuJoinService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h3> 商品规格联系{用来关联商品与规格;辅助作用} Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年12月01日 15:52:45
 * @version 1.0.0
 * </pre>
*/
@Service("shopProductSkuJoinService")
public class ShopProductSkuJoinServiceImpl  extends AbstractRealizeService<Long, ShopProductSkuJoin, ShopProductSkuJoinParam> implements ShopProductSkuJoinService {
	@Resource
	private ShopProductSkuJoinMapper shopProductSkuJoinMapper;

	@Override
	public BaseConvertBo<ShopProductSkuJoin, ShopProductSkuJoinParam> initBo() {
		return new ShopProductSkuJoinBo();
	}

	@Override
	public IBaseMapper<Long, ShopProductSkuJoin> initMapper() {
		return shopProductSkuJoinMapper;
	}

	public ShopProductSkuJoinServiceImpl(){
		// 开启缓存
		enabledCache = true;
		//设置缓存 key 的前缀
		keyPrefix = this.getClass().getName();
	}

	@Override
	public ShopProductSkuJoinParam add(ShopProductSkuJoinParam record) {
		return null;
	}

	@Override
	public Boolean update(ShopProductSkuJoinParam record) {
		return null;
	}

	@Override
	public Boolean delete(Long id) {
		return null;
	}

	@Override
	public Boolean repeat(ShopProductSkuJoinParam record) {
		return null;
	}

	@Override
	public ShopProductSkuJoinParam findById(Long id) {
		return null;
	}

	@Override
	public List<ShopProductSkuJoinParam> findByLikeAndObj(ShopProductSkuJoinParam record, PageQuery page) {
		return null;
	}

	@Override
	public PageResult<?> findAllByLike(ShopProductSkuJoinParam record, PageQuery page) {
		return null;
	}

	@Override
	public List<ShopProductSkuJoinParam> findByObj(ShopProductSkuJoinParam record, PageQuery page) {
		return null;
	}

	@Override
	public PageResult<?> findAll(ShopProductSkuJoinParam record, PageQuery page) {
		return null;
	}

	@Override
	public Integer countByLike(ShopProductSkuJoinParam record) {
		return null;
	}

	@Override
	public Integer count(ShopProductSkuJoinParam record) {
		return null;
	}
}
