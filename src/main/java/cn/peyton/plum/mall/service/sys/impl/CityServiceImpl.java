package cn.peyton.plum.mall.service.sys.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
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
public class CityServiceImpl  extends AbstractRealizeService<Integer, City, CityParam> implements CityService {
	private String TABLE_NAME = "sys_city";
	@Resource
	private CityMapper cityMapper;

	@Override
	public BaseConvertBo<City, CityParam> initBo() {
		return new CityBo();
	}

	@Override
	public IBaseMapper<Integer, City> initMapper() {
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
		if (enabledCache){
			Object list = cache.get(key);
			if (null != list) {
				System.out.printf("从缓存获取到对象: key= %s;\n",key);
				return (List<CityParam>)list;
			}
		}
		List<CityParam> pList = initBo().adapter(CityUtils.reorganize(cityMapper.selectByTree(),0));

		if (null != pList && pList.size() > 0 && enabledCache) {
			System.out.printf("添加对象到缓存: key= %s;\n",key);
			cache.put(key,pList);
		}
		return pList;
	}

	@Override
	public List<CityParam> findByPid(Integer pid,Integer status) {
		String key = keyPrefix + "_find_pid_" + pid + status;
		if (enabledCache){
			Object list = cache.get(key);
			if (null != list) {
				System.out.printf("从缓存获取到对象: key= %s;\n",key);
				return (List<CityParam>)list;
			}
		}
		List<CityParam> pList = initBo().adapter(cityMapper.selectByPid(pid, status));
		if (null != pList && pList.size() > 0 && enabledCache) {
			System.out.printf("添加对象到缓存: key= %s;\n",key);
			cache.put(key,pList);
		}
		return pList;
	}

	@Override
	public List<CityParam> findByDown(Integer level) {
		String key = keyPrefix + "_find_down_" + level;
		if (enabledCache){
			Object list = cache.get(key);
			if (null != list) {
				System.out.printf("从缓存获取到对象: key= %s;\n",key);
				return (List<CityParam>)list;
			}
		}
		List<CityParam> pList = initBo().adapter(CityUtils.reorganize(cityMapper.selectByDown(level),0));
		if (null != pList && pList.size() > 0 && enabledCache) {
			System.out.printf("添加对象到缓存: key= %s;\n",key);
			cache.put(key,pList);
		}
		return pList;
	}

	@Override
	public Boolean upStatus(Integer id, Integer status) {
		int res = cityMapper.updateStatus(TABLE_NAME, id, status);
		if (res > 0) {
			if (enabledCache) {
				System.out.println("更新操作,清空缓存");
				removeCache();
			}
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
			if (enabledCache) {
				System.out.println("批量更新操作,清空缓存");
				removeCache();
			}
			return true;
		}
		return false;
	}
}
