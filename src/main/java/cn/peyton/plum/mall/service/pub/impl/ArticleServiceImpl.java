package cn.peyton.plum.mall.service.pub.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.RealizeService;
import cn.peyton.plum.mall.bo.ArticleBo;
import cn.peyton.plum.mall.mapper.pub.ArticleMapper;
import cn.peyton.plum.mall.param.pub.ArticleParam;
import cn.peyton.plum.mall.pojo.pub.Article;
import cn.peyton.plum.mall.service.pub.ArticleService;
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
public class ArticleServiceImpl extends RealizeService<Long, Article, ArticleParam>
        implements ArticleService {
    @Resource
    private ArticleMapper articleMapper;

    @Override
    public BaseConvertBo<Article, ArticleParam> bo() {
        return new ArticleBo();
    }

    @Override
    public IBaseMapper<Long, Article> mapper() {
        return articleMapper;
    }

    public ArticleServiceImpl () {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }
}
