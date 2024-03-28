package cn.peyton.plum.mall.service.app;

import cn.peyton.plum.core.inf.service.base.IRealizeService;
import cn.peyton.plum.core.inf.service.base.IStatusService;
import cn.peyton.plum.mall.param.app.AppNavParam;
import cn.peyton.plum.mall.pojo.app.AppNav;

import java.util.List;

/**
 * <h3> App 导航 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年01月19日 22:24:38
 * @version 1.0.0
 * </pre>
*/
public interface AppNavService extends IStatusService<Integer>, IRealizeService<Integer, AppNav, AppNavParam> {

    /**
     * <h4>查找导航栏</h4>
     * @param limit 需要返回记录行数
     * @return 对象集合
     */
    List<AppNavParam> findAndroidByList(Integer limit);
}
