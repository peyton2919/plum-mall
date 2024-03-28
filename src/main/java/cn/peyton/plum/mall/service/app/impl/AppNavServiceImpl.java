package cn.peyton.plum.mall.service.app.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.RealizeService;
import cn.peyton.plum.mall.bo.AppNavBo;
import cn.peyton.plum.mall.mapper.app.AppNavMapper;
import cn.peyton.plum.mall.param.app.AppNavParam;
import cn.peyton.plum.mall.pojo.app.AppNav;
import cn.peyton.plum.mall.service.app.AppNavService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h3> App 导航 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年01月19日 22:24:38
 * @version 1.0.0
 * </pre>
*/
@Service("appNavService")
public class AppNavServiceImpl  extends RealizeService<Integer, AppNav, AppNavParam> implements AppNavService {

	private String TABLE_NAME = "tb_app_nav";
	@Resource
	private AppNavMapper appNavMapper;

	@Override
	public BaseConvertBo<AppNav, cn.peyton.plum.mall.param.app.AppNavParam> bo() {
		return new AppNavBo();
	}

	@Override
	public IBaseMapper<Integer, AppNav> mapper() {
		return appNavMapper;
	}

	public AppNavServiceImpl(){
		// 开启缓存
		enabledCache = true;
		//设置缓存 key 的前缀
		keyPrefix = this.getClass().getName();
	}

	@Override
	public Boolean upStatus(Integer id, Integer status) {
		int res = appNavMapper.updateStatus(TABLE_NAME,id,status);
		if (res > 0) {
			clearCache("App Nav 更新状态");
			return true;
		}
		return false;
	}

	@Override
	public List<AppNavParam> findAndroidByList(Integer limit) {
		return bo().adapter(appNavMapper.selectAndroidByList(limit));
	}
}
