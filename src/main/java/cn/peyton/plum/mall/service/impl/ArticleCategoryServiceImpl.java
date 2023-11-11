package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractAppRealizeService;
import cn.peyton.plum.mall.bo.ArticleCategoryBo;
import cn.peyton.plum.mall.param.ArticleCategoryParam;
import cn.peyton.plum.mall.pojo.ArticleCategory;
import cn.peyton.plum.mall.service.ArticleCategoryService;
import cn.peyton.plum.mall.mapper.ArticleCategoryMapper;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;

/**
 * <h3> 文章类型 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
@Service("articleCategoryService")
public class ArticleCategoryServiceImpl extends AbstractAppRealizeService<Integer, ArticleCategory, ArticleCategoryParam>
        implements ArticleCategoryService {
    @Resource
    private ArticleCategoryMapper articleCategoryMapper;

    @Override
    public BaseConvertBo<ArticleCategory, ArticleCategoryParam> initBo() {
        return new ArticleCategoryBo();
    }

    @Override
    public IBaseMapper<Integer, ArticleCategory> initMapper() {
        return articleCategoryMapper;
    }
}
