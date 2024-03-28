package cn.peyton.plum.mall.service.join.impl;

import cn.peyton.plum.core.err.GlobalException;
import cn.peyton.plum.core.err.TransactionalException;
import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.RealizeService;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.PageResult;
import cn.peyton.plum.core.utils.DateUtils;
import cn.peyton.plum.mall.DO.ArrearDo;
import cn.peyton.plum.mall.bo.ShopArrearsBo;
import cn.peyton.plum.mall.mapper.join.ShopArrearPoolMapper;
import cn.peyton.plum.mall.mapper.join.ShopArrearsMapper;
import cn.peyton.plum.mall.mapper.join.ShopRepaymentMapper;
import cn.peyton.plum.mall.param.join.ShopArrearsParam;
import cn.peyton.plum.mall.pojo.join.ShopArrearPool;
import cn.peyton.plum.mall.pojo.join.ShopArrears;
import cn.peyton.plum.mall.service.join.ShopArrearsService;
import cn.peyton.plum.mall.vo.ArrearVo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * <h3> 欠款信息 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年02月06日 22:33:31
 * @version 1.0.0
 * </pre>
*/
@Service("shopArrearsService")
public class ShopArrearsServiceImpl extends RealizeService<Long, ShopArrears, ShopArrearsParam> implements ShopArrearsService {
	@Resource
	private ShopArrearsMapper shopArrearsMapper;
	@Resource
	private ShopArrearPoolMapper shopArrearPoolMapper;
	@Resource
	private ShopRepaymentMapper shopRepaymentMapper;

	@Override
	public BaseConvertBo<ShopArrears, ShopArrearsParam> bo() {
		return new ShopArrearsBo();
	}

	@Override
	public IBaseMapper<Long, ShopArrears> mapper() {
		return shopArrearsMapper;
	}

	public ShopArrearsServiceImpl(){
		// 开启缓存
		enabledCache = true;
		//设置缓存 key 的前缀
		keyPrefix = this.getClass().getName();
	}

	@Override
	public PageResult<ShopArrearsParam> findMulti(ArrearVo vo, PageQuery page) {
		StringBuffer sb = new StringBuffer();
		keywords(vo, sb);
		String key = keyPrefix + sb + keywords(null, page, true) + "_202402111253";

		Object objs = getCache(key);
		if (null == objs) {
			ArrearDo arrearDo = ArrearVoToDo.convert(vo);
			List<ShopArrears> list = shopArrearsMapper.selectMulti(arrearDo, page);
			if (null != list && list.size() > 0) {
				int rows = shopArrearsMapper.countMulti(arrearDo);
				if (rows < 1) {throw new GlobalException("查找记录总行数出错了");}

				PageResult<ShopArrearsParam> result = new PageResult<>();
				result.setData(bo().adapter(list));
				result.setTotalRows(rows);

				saveCache(key,result);
				return result;
			}
		}
		return (PageResult<ShopArrearsParam>) objs;
	}


	@Override
	public PageResult<ShopArrearsParam> findJoin(ArrearVo vo, PageQuery page) {
		StringBuffer sb = new StringBuffer();
		keywords(vo,sb);
		String key = keyPrefix + sb + keywords(null, page, true)+"_202402090959";

		Object objs = getCache(key);
		if (null == objs) {
			ArrearDo arrearDo = ArrearVoToDo.convert(vo);
			List<ShopArrears> list = shopArrearsMapper.selectByJoin(arrearDo, page);
			if (null != list && list.size() > 0) {
				int rows = shopArrearsMapper.countJoin(arrearDo);

				if (rows < 1) {throw new GlobalException("查找记录总行数出错了");}
				PageResult<ShopArrearsParam> result = new PageResult<>();
				result.setData(bo().adapter(list));
				result.setTotalRows(rows);
				saveCache(key,result);
				return result;
			}
		}
		return (PageResult<ShopArrearsParam>) objs;
	}

	@Override
	@Transactional
	public boolean joinCreate(ShopArrearsParam param) {
		if (null == param.getCreateTime() || "".equals(param.getCreateTime())) {
			param.setCreateTime(DateUtils.timestampToStrDate(new Date()));
		}
		// 新增欠款
		int res = shopArrearsMapper.insertSelective(param.convert());
		if (res == 0) {
			throw new TransactionalException("新增欠款出错了...");
		}
		boolean isEdit = true;
		//更新 欠款汇总
		ShopArrearPool _sap = shopArrearPoolMapper.selectByMemberId(param.getMemberId());

		if (null == _sap) { // 新增
			_sap = new ShopArrearPool();
			_sap.setMemberId(param.getMemberId());
			_sap.setTotal(param.getMoney());
			_sap.setCreateTime(DateUtils.dateToTimestamp());
			_sap.setStatus(0);
			_sap.setBalance(param.getMoney());
			isEdit = false;
		}else{
			// 计算当前用户欠款与还款金额
			_sap.setStatus(0);
			BigDecimal total = shopArrearsMapper.calcMoney(param.getMemberId(), 0);
			BigDecimal payCount = shopRepaymentMapper.calcMoney(param.getMemberId(), 0);
			BigDecimal balance = (null != total && null != payCount) ? total.subtract(payCount) : total;
			if (null != balance && balance.doubleValue() == 0.00) {
				_sap.setStatus(1);
			}
			_sap.setTotal(total);
			_sap.setBalance(balance);
		}

		// 新增 | 更新
		res = (!isEdit) ? shopArrearPoolMapper.insertSelective(_sap) : shopArrearPoolMapper.updateSelective(_sap);

		if (res > 0) {
			clearCache("新增");
			return true;
		}
		throw new TransactionalException("新增欠款出错了...");
	}

	@Override
	public List<ShopArrearsParam> findByMemberId(long memberId, Integer status) {
		String key = keyPrefix + "_find_member_id_20240227_" + memberId + status;

		Object objs = getCache(key);
		if (null == objs) {
			List<ShopArrears> arrears = shopArrearsMapper.selectByMemberId(memberId, status);
			if (null != arrears) {
				List<ShopArrearsParam> adapter = bo().adapter(arrears);

				saveCache(key,adapter);
				return adapter;
			}
		}
		return (List<ShopArrearsParam>) objs;

	}

}
