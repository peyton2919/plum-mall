package cn.peyton.plum.mall.service.pub;

import cn.peyton.plum.core.inf.service.IBaseService;
import cn.peyton.plum.mall.param.pub.NoticeCategoryParam;
import cn.peyton.plum.mall.pojo.pub.NoticeCategory;

import java.util.List;

/**
 * <h3> 公告类型 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
public interface NoticeCategoryService extends IBaseService<Integer, NoticeCategory, NoticeCategoryParam> {
    /**
     * <h4>下拉框选择</h4>
     * @return
     */
    List<NoticeCategoryParam> findBySelect();
}
