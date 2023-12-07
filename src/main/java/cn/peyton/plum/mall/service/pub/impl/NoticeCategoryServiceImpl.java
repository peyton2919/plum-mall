package cn.peyton.plum.mall.service.pub.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
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

    public NoticeCategoryServiceImpl() {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }

    @Override
    public List<NoticeCategoryParam> findBySelect() {
        String key = keyPrefix + "find_select_all";
        if (enabledCache){
            Object list = cache.get(key);
            if (null != list) {
                System.out.printf("从缓存获取到对象: key= %s;\n",key);
                return (List<NoticeCategoryParam>)list;
            }
        }
        List<NoticeCategoryParam> pList = initBo().adapter(noticeCategoryMapper.selectByAll());

        if (null != pList && pList.size() > 0 && enabledCache) {
            System.out.printf("添加对象到缓存: key= %s;\n",key);
            cache.put(key,pList);
        }
        return pList;
    }
}
