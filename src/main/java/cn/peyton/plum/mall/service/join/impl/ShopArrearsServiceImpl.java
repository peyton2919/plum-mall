package cn.peyton.plum.mall.service.join.impl;

import cn.peyton.plum.core.err.GlobalException;
import cn.peyton.plum.core.err.TransactionalException;
import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.PageResult;
import cn.peyton.plum.core.utils.DateUtils;
import cn.peyton.plum.mall.bo.ShopArrearsBo;
import cn.peyton.plum.mall.mapper.join.ShopArrearPoolMapper;
import cn.peyton.plum.mall.mapper.join.ShopArrearsMapper;
import cn.peyton.plum.mall.param.join.ShopArrearsParam;
import cn.peyton.plum.mall.pojo.join.ShopArrearPool;
import cn.peyton.plum.mall.pojo.join.ShopArrears;
import cn.peyton.plum.mall.service.join.ShopArrearsService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <h3> 欠款信息 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年01月16日 21:12:27
 * @version 1.0.0
 * </pre>
*/
@Service("shopArrearsService")
public class ShopArrearsServiceImpl  extends AbstractRealizeService<Long, ShopArrears, ShopArrearsParam> implements ShopArrearsService {
	@Resource
	private ShopArrearsMapper shopArrearsMapper;
	@Resource
	private ShopArrearPoolMapper shopArrearPoolMapper;

	@Override
	public BaseConvertBo<ShopArrears, ShopArrearsParam> initBo() {
		return new ShopArrearsBo();
	}

	@Override
	public IBaseMapper<Long, ShopArrears> initMapper() {
		return shopArrearsMapper;
	}

	public ShopArrearsServiceImpl(){
		// 开启缓存
		enabledCache = true;
		//设置缓存 key 的前缀
		keyPrefix = this.getClass().getName();
	}

	@Override
	public PageResult<ShopArrearsParam> findMulti(Long memberId, Integer status, Integer repayType, BigDecimal debt,
												  BigDecimal actualPayment, PageQuery page, String timeInterval, String mode) {
		String key = keyPrefix + createKey(null, page, true) + createKeyObjs(memberId, status, repayType, debt, actualPayment, timeInterval, mode);
		if (enabledCache) {
			Object obj = cache.get(key);
			if (null != obj) {
				return (PageResult<ShopArrearsParam>) obj;
			}
		}
		List<ShopArrears> list = shopArrearsMapper.selectMulti(memberId, status, repayType, debt, actualPayment, page, timeInterval, mode);
		if (null != list && list.size() > 0) {
			int rows = shopArrearsMapper.countMulti(memberId, status, repayType, debt, actualPayment, page, timeInterval, mode);
			if (rows < 1) {
				throw new GlobalException("查找记录总行数出错了");
			}
			PageResult<ShopArrearsParam> result = new PageResult<>();
			result.setData(initBo().adapter(list));
			result.setTotalRows(rows);
			if(enabledCache){
				System.out.println("查找数据,添加数据到缓存; key = " + key);
				cache.put(key,result);
			}
			return result;
		}
		return null;
	}

	@Override
	@Transactional
	public boolean joinCreate(ShopArrearsParam param) {
		// 新增欠款
		if (null == param.getCreateTime() || "".equals(param.getCreateTime())) {
			param.setCreateTime(DateUtils.timestampToStrDate(new Date()));
		}
		int res = shopArrearsMapper.insertSelective(param.convert());
		if (res == 0) {
			throw new TransactionalException("新增欠款出错了...");
		}
		boolean isEdit = true;
		//更新 欠款汇总
		ShopArrearPool _sap = shopArrearPoolMapper.selectByMemberId(param.getMemberId());
		// 计算当前用户欠款与还款金额
		Map<String, BigDecimal> map = shopArrearsMapper.calcArrears(param.getMemberId());

		if (null == _sap) { // 新增
			_sap = new ShopArrearPool();
			_sap.setMemberId(param.getMemberId());
			_sap.setCreateTime(DateUtils.dateToTimestamp());
			isEdit = false;
		}

		if (null != map) {
			_sap.setTotal(map.get("total"));
			BigDecimal total = map.get("total");
			BigDecimal payCount = map.get("payCount");
			BigDecimal balance = (null != total && null != payCount) ? total.subtract(payCount) : total;
			if (null != balance && balance.doubleValue() == 0.00) {
				_sap.setStatus(1);
			}
			_sap.setBalance(balance);
		}

		if (!isEdit) { // 新增
			res  =  shopArrearPoolMapper.insertSelective(_sap);

		}else { // 更新
			res  = shopArrearPoolMapper.updateSelective(_sap);
		}
		if (res > 0) {
			if (enabledCache) {
				System.out.println("新增操作清空缓存;");
				removeCache();
			}
			return true;
		}
		throw new TransactionalException("新增欠款出错了...");
	}

	@Override
	public List<ShopArrearsParam> findByMemberId(long memberId, Integer status) {
		List<ShopArrears> arrears = shopArrearsMapper.selectByMemberId(memberId, status);
		if (null != arrears) {
			return initBo().adapter(arrears);
		}
		return null;
	}
}
