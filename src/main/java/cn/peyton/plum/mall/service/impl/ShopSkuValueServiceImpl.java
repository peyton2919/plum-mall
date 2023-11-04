package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.mall.mapper.ShopSkuValueMapper;
import cn.peyton.plum.mall.param.ShopSkuValueParam;
import cn.peyton.plum.mall.pojo.ShopSkuValue;
import cn.peyton.plum.mall.service.ShopSkuValueService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h3> 商品规格 值表 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
@Service("shopSkuValueService")
public class ShopSkuValueServiceImpl implements ShopSkuValueService {

	@Resource
	private ShopSkuValueMapper shopSkuValueMapper;

	@Override
	public ShopSkuValueParam add(ShopSkuValueParam param) {
		ShopSkuValue record = param.convert();
		int result = shopSkuValueMapper.insertSelective(record);
		if (result > 0) {
			return param.compat(record);
		}
		return param;
	}

	@Override
	public Boolean update(ShopSkuValueParam record) {
		return null;
	}

	@Override
	public Boolean upStatus(Long id, Integer status) {
		return null;
	}

	@Override
	public Boolean delete(Long id) {
		return null;
	}

	@Override
	public Boolean isRename(ShopSkuValueParam record) {
		return null;
	}

	@Override
	public ShopSkuValueParam findById(Long id) {
		return null;
	}

	@Override
	public List<ShopSkuValueParam> findByAllOrKeyword(String keyword, PageQuery page) {
		return null;
	}

	@Override
	public List<ShopSkuValueParam> findByObj(ShopSkuValueParam record, PageQuery page) {
		return null;
	}

	@Override
	public Integer count(String keyword) {
		return null;
	}
}
