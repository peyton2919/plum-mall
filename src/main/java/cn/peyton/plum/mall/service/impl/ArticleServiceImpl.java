package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractAppRealizeService;
import cn.peyton.plum.mall.bo.ArticleBo;
import cn.peyton.plum.mall.mapper.ArticleMapper;
import cn.peyton.plum.mall.param.ArticleParam;
import cn.peyton.plum.mall.pojo.Article;
import cn.peyton.plum.mall.service.ArticleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 文章 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
@Service("articleService")
public class ArticleServiceImpl extends AbstractAppRealizeService<Long, Article, ArticleParam>
        implements ArticleService {
    @Resource
    private ArticleMapper articleMapper;

    @Override
    public BaseConvertBo<Article, ArticleParam> initBo() {
        return new ArticleBo();
    }

    @Override
    public IBaseMapper<Long, Article> initMapper() {
        return articleMapper;
    }
}
