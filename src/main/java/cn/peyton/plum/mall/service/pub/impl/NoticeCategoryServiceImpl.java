package cn.peyton.plum.mall.service.pub.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.RealizeService;
import cn.peyton.plum.mall.bo.NoticeCategoryBo;
import cn.peyton.plum.mall.mapper.pub.NoticeCategoryMapper;
import cn.peyton.plum.mall.param.pub.NoticeCategoryParam;
import cn.peyton.plum.mall.pojo.pub.NoticeCategory;
import cn.peyton.plum.mall.service.pub.NoticeCategoryService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

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
public class NoticeCategoryServiceImpl extends RealizeService<Integer, NoticeCategory, NoticeCategoryParam> implements NoticeCategoryService {
    @Resource
    private NoticeCategoryMapper noticeCategoryMapper;

    @Override
    public BaseConvertBo<NoticeCategory, NoticeCategoryParam> bo() {
        return new NoticeCategoryBo();
    }

    @Override
    public IBaseMapper<Integer, NoticeCategory> mapper() {
        return noticeCategoryMapper;
    }

    public NoticeCategoryServiceImpl() {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }

    @Override
    public List<NoticeCategoryParam> findBySelect() {
        String key = keyPrefix + "find_select_all";
        Object objs = getCache(key);
        if (null == objs) {
            List<NoticeCategoryParam> adapter = bo().adapter(noticeCategoryMapper.selectByAll());
            saveCache(key, adapter);
            return adapter;
        }
        return (List<NoticeCategoryParam>) objs;
    }
}
