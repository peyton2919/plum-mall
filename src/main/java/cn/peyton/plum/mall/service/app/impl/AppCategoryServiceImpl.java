package cn.peyton.plum.mall.service.app.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.mall.bo.AppCategoryBo;
import cn.peyton.plum.mall.mapper.app.AppCategoryMapper;
import cn.peyton.plum.mall.pojo.app.AppCategory;
import cn.peyton.plum.mall.service.app.AppCategoryService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h3> App 分类 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年01月19日 22:43:53
 * @version 1.0.0
 * </pre>
*/
@Service("appCategoryService")
public class AppCategoryServiceImpl  extends AbstractRealizeService<Integer, AppCategory, cn.peyton.plum.mall.param.app.AppCategoryParam> implements AppCategoryService {
	private String TABLE_NAME = "tb_app_category";

	@Resource
	private AppCategoryMapper appCategoryMapper;

	@Override
	public BaseConvertBo<AppCategory, cn.peyton.plum.mall.param.app.AppCategoryParam> initBo() {
		return new AppCategoryBo();
	}

	@Override
	public IBaseMapper<Integer, AppCategory> initMapper() {
		return appCategoryMapper;
	}

	public AppCategoryServiceImpl(){
		// 开启缓存
		enabledCache = true;
		//设置缓存 key 的前缀
		keyPrefix = this.getClass().getName();
	}

	@Override
	public Boolean upStatus(Integer id, Integer status) {
		int res = appCategoryMapper.updateStatus(TABLE_NAME,id,status);
		if (res > 0) {
			if(enabledCache){
				System.out.println("更新状态操作清空缓存");
				removeCache();
			}
			return true;
		}
		return false;
	}

	@Override
	public List<cn.peyton.plum.mall.param.app.AppCategoryParam> findByTabBars() {
		String key = keyPrefix + "_find_tab_bars_202401201457";
		if (enabledCache) {
			Object obj = cache.get(key);
			if (null != obj) {
				System.out.println("从缓存中获取数据, key = " + key);
				return (List<cn.peyton.plum.mall.param.app.AppCategoryParam>) obj;
			}
		}
		List<AppCategory> result = appCategoryMapper.selectByTabBars();
		if (null == result) {
			return null;
		}
		List<cn.peyton.plum.mall.param.app.AppCategoryParam> adapter = initBo().adapter(result);
		if (enabledCache) {
			System.out.println("查找到数据,保存到缓存, key =" + key);
			cache.put(key,adapter);
		}
		return adapter;
	}
}
