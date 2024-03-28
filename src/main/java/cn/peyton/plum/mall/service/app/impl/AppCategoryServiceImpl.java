package cn.peyton.plum.mall.service.app.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.RealizeService;
import cn.peyton.plum.mall.bo.AppCategoryBo;
import cn.peyton.plum.mall.mapper.app.AppCategoryMapper;
import cn.peyton.plum.mall.param.app.AppCategoryParam;
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
public class AppCategoryServiceImpl  extends RealizeService<Integer, AppCategory, AppCategoryParam> implements AppCategoryService {
	private String TABLE_NAME = "tb_app_category";

	@Resource
	private AppCategoryMapper appCategoryMapper;

	@Override
	public BaseConvertBo<AppCategory, AppCategoryParam> bo() {
		return new AppCategoryBo();
	}

	@Override
	public IBaseMapper<Integer, AppCategory> mapper() {
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

			clearCache("App Category 更新状态");
			return true;
		}
		return false;
	}

	@Override
	public List<AppCategoryParam> findByTabBars() {
		String key = keyPrefix + "_find_tab_bars_202401201457";

		if (null == getCache(key)) {
			List<AppCategoryParam> adapter = bo().adapter(appCategoryMapper.selectByTabBars());
			saveCache(key, adapter);
			return adapter;
		}
		return (List<AppCategoryParam>) getCache(key);
	}
}
