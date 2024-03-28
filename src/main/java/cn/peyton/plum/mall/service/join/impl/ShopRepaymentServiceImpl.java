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
import cn.peyton.plum.mall.bo.ShopRepaymentBo;
import cn.peyton.plum.mall.mapper.join.ShopArrearPoolMapper;
import cn.peyton.plum.mall.mapper.join.ShopArrearsMapper;
import cn.peyton.plum.mall.mapper.join.ShopRepaymentMapper;
import cn.peyton.plum.mall.param.join.ShopArrearsParam;
import cn.peyton.plum.mall.param.join.ShopRepaymentParam;
import cn.peyton.plum.mall.pojo.join.ShopArrearPool;
import cn.peyton.plum.mall.pojo.join.ShopRepayment;
import cn.peyton.plum.mall.service.join.ShopRepaymentService;
import cn.peyton.plum.mall.vo.ArrearVo;
import com.alibaba.fastjson2.JSON;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <h3> 还款信息 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年02月06日 22:33:46
 * @version 1.0.0
 * </pre>
*/
@Service("shopRepaymentService")
public class ShopRepaymentServiceImpl  extends RealizeService<Long, ShopRepayment, ShopRepaymentParam> implements ShopRepaymentService {
	@Resource
	private ShopRepaymentMapper shopRepaymentMapper;
	@Resource
	private ShopArrearPoolMapper shopArrearPoolMapper;
	@Resource
	private ShopArrearsMapper shopArrearsMapper;

	@Override
	public BaseConvertBo<ShopRepayment, ShopRepaymentParam> bo() {
		return new ShopRepaymentBo();
	}

	@Override
	public IBaseMapper<Long, ShopRepayment> mapper() {
		return shopRepaymentMapper;
	}

	public ShopRepaymentServiceImpl(){
		// 开启缓存
		enabledCache = true;
		//设置缓存 key 的前缀
		keyPrefix = this.getClass().getName();
	}

	@Override
	public List<ShopRepaymentParam> findByMemberId(Long memberId, Integer status) {
		String key = keyPrefix + "_find_member_id_20240225_" + memberId + status;

		Object objs = getCache(key);
		if (null == objs) {
			List<ShopRepayment> srp = shopRepaymentMapper.selectByMemberId(memberId, status);
			if (null != srp) {
				List<ShopRepaymentParam> adapter = bo().adapter(srp);
				saveCache(key, adapter);
				return adapter;
			}
		}
		return (List<ShopRepaymentParam>) objs;

	}

	@Override
	public PageResult<ShopRepaymentParam> findMulti(ArrearVo vo, PageQuery page) {
		StringBuffer sb = new StringBuffer();
		keywords(vo, sb);
		String key = keyPrefix + sb + keywords(null, page, true) + "_202402111258";
		Object objs = getCache(key);

		if (null == objs) {
			ArrearDo arrearDo = ArrearVoToDo.convert(vo);
			List<ShopRepayment> list = shopRepaymentMapper.selectMulti(arrearDo,page);
			if (null != list && list.size() > 0) {
				int rows = shopRepaymentMapper.countMulti(arrearDo);
				if (rows < 1) {
					throw new GlobalException("查找记录总行数出错了");
				}
				PageResult<ShopRepaymentParam> result = new PageResult<>();
				result.setData(bo().adapter(list));
				result.setTotalRows(rows);
				saveCache(key, result);
				return result;
			}
		}
		return (PageResult<ShopRepaymentParam>) objs;
	}

	@Override
	@Transactional(rollbackFor = {TransactionalException.class})
	public boolean joinCreate(ShopRepaymentParam param) {
		List<Long> arrearIds = null;
		List<ShopArrearsParam> _saps = new ArrayList<>();
		boolean multi = false;  // 单一还款; true 关联还款
		if (null != param.getObj() && !"".equals(param.getObj())) {
			_saps = JSON.parseArray(param.getObj(), ShopArrearsParam.class);
			if (null != _saps && _saps.size() > 0) {
				arrearIds = new ArrayList<>();
				for (ShopArrearsParam _p : _saps) {
					arrearIds.add(_p.getId());
				}
				multi = true;
			}else {
				throw new TransactionalException("新增还款出错了...");
			}
		}
		if (null == param.getCreateTime() || "".equals(param.getCreateTime())) {
			param.setCreateTime(DateUtils.timestampToStrDate(new Date()));
		}
		// 1. 新增还款
		ShopRepayment sr = param.convert();

		if (shopRepaymentMapper.insertSelective(sr) == 0) {
			throw new TransactionalException("新增还款出错了...");
		}

		if (multi) {
			int len = _saps.size();
			for (int i = 0; i < len; i++) {
				_saps.get(i).setRepId(sr.getId());
			}
			String obj = JSON.toJSONString(_saps);
			//
			if (shopRepaymentMapper.upObj(sr.getId(), obj) == 0) {
				throw new TransactionalException("新增还款出错了...");
			}
		}

		// 2. 更新欠款表 status = 1; 同时更新 还款与欠款为 1
		//BigDecimal existBalance = shopRepaymentMapper.existStatus(param.getArrearId());
		if (param.getStatus() == 1) {
			if(!multi){  // 单一
				if (shopRepaymentMapper.upRepaymentStatus(param.getArrearId()) == 0) {
					throw new TransactionalException("新增还款更新还款状态时出错了...");
				}
				if (shopArrearsMapper.updateStatus("tb_shop_arrears", param.getArrearId(), 1) == 0) {
					throw new TransactionalException("新增还款更新欠款状态时出错了...");
				}
			}else {
				//	更新 欠款表 还款信息
				if (shopRepaymentMapper.batchUpdate(arrearIds) == 0) {
					throw new TransactionalException("新增还款更新还款状态时出错了...");
				}

				if (shopArrearsMapper.batchUpdate(arrearIds, sr.getId()) == 0) {
					throw new TransactionalException("新增还款更新欠款状态时出错了...");
				}
			}

			// 更新 汇总表
			if (shopArrearPoolMapper.updateArrearTotal(param.getMemberId()) == 0) {
				throw new TransactionalException("新增还款更新欠款总额时出错了...");
			}
		}

		// 3. 更新欠款汇总表
		// 更新 欠款汇总
		ShopArrearPool _sap = shopArrearPoolMapper.selectByMemberId(param.getMemberId());
		if(null == _sap){
			throw new TransactionalException("新增还款出错了...");
		}
		// 计算当前用户还款金额
		BigDecimal payCount = shopRepaymentMapper.calcMoney(param.getMemberId(), 0);

		// 计算当前用户欠款余额
		BigDecimal balance = (null != _sap.getTotal() && null != payCount) ? _sap.getTotal().subtract(payCount) : _sap.getTotal();
		// 当用户欠款余额为0 时，更新状态值 为 1
		if (null == balance || balance.doubleValue() == 0.00) {
			_sap.setTotal(new BigDecimal(0));
			_sap.setBalance(new BigDecimal(0));
			_sap.setStatus(1);
			_sap.setCreateTime(null);
		}else {
			_sap.setBalance(balance);
			_sap.setCreateTime(null);
			_sap.setTotal(null);
		}
		// 更新 欠款汇总表
		int res = shopArrearPoolMapper.updateSelective(_sap);
		if (res == 0) {
			throw new TransactionalException("新增还款出错了...");
		}

		if (res > 0) {
			clearCache("新增还款");
			return true;
		}
		throw new TransactionalException("更新还款出错了...");
	}

	@Override
	public PageResult<ShopRepaymentParam> findJoin(ArrearVo vo, PageQuery page) {
		StringBuffer sb = new StringBuffer();
		keywords(vo,sb);
		String key = keyPrefix + sb + keywords(null, page, true) + "_202402091018";
		Object objs = getCache(key);
		if (null == objs) {
			ArrearDo arrearDo = ArrearVoToDo.convert(vo);
			List<ShopRepayment> list = shopRepaymentMapper.selectByJoin(arrearDo, page);
			if (null != list && list.size() > 0) {
				int rows = shopRepaymentMapper.countJoin(arrearDo);
				if (rows < 1) {
					throw new GlobalException("查找记录总行数出错了");
				}
				PageResult<ShopRepaymentParam> result = new PageResult<>();
				result.setData(bo().adapter(list));
				result.setTotalRows(rows);
				saveCache(key, result);
				return result;
			}
		}
		return (PageResult<ShopRepaymentParam>) objs;
	}
}
