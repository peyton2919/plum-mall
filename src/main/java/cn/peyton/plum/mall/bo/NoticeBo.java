package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.pub.NoticeParam;
import cn.peyton.plum.mall.pojo.pub.Notice;

/**
 * <h3> 公告 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class NoticeBo extends BaseConvertBo<Notice, NoticeParam> {

    @Override
    public NoticeParam compat(Notice info) {
        return new NoticeParam().compat(info);
    }

    @Override
    public Notice convert(NoticeParam info) {
        return info.convert();
    }
}
