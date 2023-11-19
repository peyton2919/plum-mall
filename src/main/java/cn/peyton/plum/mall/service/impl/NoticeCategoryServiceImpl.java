package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.mall.bo.NoticeCategoryBo;
import cn.peyton.plum.mall.mapper.NoticeCategoryMapper;
import cn.peyton.plum.mall.param.NoticeCategoryParam;
import cn.peyton.plum.mall.pojo.NoticeCategory;
import cn.peyton.plum.mall.service.NoticeCategoryService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 公告类型 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("noticeCategoryService")
public class NoticeCategoryServiceImpl extends AbstractRealizeService<Integer, NoticeCategory, NoticeCategoryParam> implements NoticeCategoryService {
    @Resource
    private NoticeCategoryMapper noticeCategoryMapper;

    @Override
    public BaseConvertBo<NoticeCategory, NoticeCategoryParam> initBo() {
        return new NoticeCategoryBo();
    }

    @Override
    public IBaseMapper<Integer, NoticeCategory> initMapper() {
        return noticeCategoryMapper;
    }

}
