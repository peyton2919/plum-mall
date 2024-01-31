package cn.peyton.plum.mall.service.pub.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.mall.bo.NoticeBo;
import cn.peyton.plum.mall.mapper.pub.NoticeMapper;
import cn.peyton.plum.mall.param.pub.NoticeParam;
import cn.peyton.plum.mall.pojo.pub.Notice;
import cn.peyton.plum.mall.service.pub.NoticeService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 公告 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("noticeService")
public class NoticeServiceImpl extends AbstractRealizeService<Long, Notice, NoticeParam> implements NoticeService {
    @Resource
    private NoticeMapper noticeMapper;

    @Override
    public BaseConvertBo<Notice, NoticeParam> initBo() {
        return new NoticeBo();
    }

    @Override
    public IBaseMapper<Long, Notice> initMapper() {
        return noticeMapper;
    }

    public NoticeServiceImpl() {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }

    @Override
    public Boolean isNoticeCategory(Integer cateId) {
        return noticeMapper.isNoticeCategory(cateId) > 0;
    }
}
