package cn.peyton.plum.mall.service.app;

import cn.peyton.plum.core.inf.service.base.IRealizeService;
import cn.peyton.plum.core.inf.service.base.IStatusService;
import cn.peyton.plum.mall.param.app.AppCategoryParam;
import cn.peyton.plum.mall.pojo.app.AppCategory;

import java.util.List;

/**
 * <h3> App 分类 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年01月19日 22:43:53
 * @version 1.0.0
 * </pre>
*/
public interface AppCategoryService extends IStatusService<Integer>, IRealizeService<Integer, AppCategory, AppCategoryParam> {


    /**
     * <h4>获取tabbars集合</h4>
     * @return
     */
    List<AppCategoryParam> findByTabBars();
}
