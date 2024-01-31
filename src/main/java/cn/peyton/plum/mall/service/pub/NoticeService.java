package cn.peyton.plum.mall.service.pub;

import cn.peyton.plum.core.inf.service.IBaseService;
import cn.peyton.plum.mall.param.pub.NoticeParam;
import cn.peyton.plum.mall.pojo.pub.Notice;

/**
 * <h3> 公告 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
public interface NoticeService extends IBaseService<Long, Notice, NoticeParam> {
    /**
     * <h4>判断有没有关联分类</h4>
     * @param cateId 分类Id
     * @return 有关联为 true
     */
    Boolean isNoticeCategory(Integer cateId);

}
