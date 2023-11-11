package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.NoticeCategoryParam;
import cn.peyton.plum.mall.pojo.NoticeCategory;

/**
 * <h3> 公告类型 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class NoticeCategoryBo extends BaseConvertBo<NoticeCategory, NoticeCategoryParam> {

    @Override
    public NoticeCategoryParam compat(NoticeCategory info) {
        return new NoticeCategoryParam().compat(info);
    }

    @Override
    public NoticeCategory convert(NoticeCategoryParam info) {
        return info.convert();
    }
}
