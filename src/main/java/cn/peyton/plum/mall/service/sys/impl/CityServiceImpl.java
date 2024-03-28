package cn.peyton.plum.mall.service.sys.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.RealizeService;
import cn.peyton.plum.mall.bo.CityBo;
import cn.peyton.plum.mall.mapper.sys.CityMapper;
import cn.peyton.plum.mall.param.sys.CityParam;
import cn.peyton.plum.mall.pojo.sys.City;
import cn.peyton.plum.mall.service.sys.CityService;
import cn.peyton.plum.mall.utils.CityUtils;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h3> 城市 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年12月01日 19:03:49
 * @version 1.0.0
 * </pre>
*/
@Service("cityService")
public class CityServiceImpl  extends RealizeService<Integer, City, CityParam> implements CityService {
	private String TABLE_NAME = "sys_city";
	@Resource
	private CityMapper cityMapper;

	@Override
	public BaseConvertBo<City, CityParam> bo() {
		return new CityBo();
	}

	@Override
	public IBaseMapper<Integer, City> mapper() {
		return cityMapper;
	}

	public CityServiceImpl(){
		// 开启缓存
		enabledCache = true;
		//设置缓存 key 的前缀
		keyPrefix = this.getClass().getName();
	}

	@Override
	public List<CityParam> findByTree() {
		String key = keyPrefix + "_find_tree_all_202401071748";
		Object objs = getCache(key);
		if (null == objs) {
			List<CityParam> adapter = bo().adapter(CityUtils.reorganize(cityMapper.selectByTree(),0));
			saveCache(key, adapter);
			return adapter;
		}
		return (List<CityParam>) objs;
	}

	@Override
	public List<CityParam> findByPid(Integer pid,Integer status) {
		String key = keyPrefix + "_find_pid_" + pid + status;
		Object objs = getCache(key);
		if (null == objs) {
			List<CityParam> adapter = bo().adapter(cityMapper.selectByPid(pid, status));
			saveCache(key, adapter);
			return adapter;
		}
		return (List<CityParam>) objs;
	}

	@Override
	public List<CityParam> findByDown(Integer level) {
		String key = keyPrefix + "_find_down_" + level;
		Object objs = getCache(key);
		if (null == objs) {
			List<CityParam> adapter = bo().adapter(CityUtils.reorganize(cityMapper.selectByDown(level),0));
			saveCache(key, adapter);
			return adapter;
		}
		return (List<CityParam>) objs;
	}

	@Override
	public Boolean upStatus(Integer id, Integer status) {
		int res = cityMapper.updateStatus(TABLE_NAME, id, status);
		if (res > 0) {
			clearCache("更新城市状态");
			return true;
		}
		return false;
	}

	@Override
	public List<Integer> findLevel1(Integer pid) {

		return cityMapper.selectLevel1(pid);
	}

	@Override
	public List<Integer> findLevel2(Integer pid) {
		return cityMapper.selectLevel2(pid);
	}

	@Override
	public Boolean batchUpdate(List<Integer> ids, Integer status) {
		int res = cityMapper.batchUpdate(ids, status);
		if (res > 0) {
			clearCache("批量更新城市");
			return true;
		}
		return false;
	}
}
