package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.ArticleParam;
import cn.peyton.plum.mall.pojo.Article;

/**
 * <h4>文章 数据转换类</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.mall.bo.ArticleBo
 * @date 2023年11月10日 16:59
 * @version 1.0.0
 * </pre>
 */
public class ArticleBo extends BaseConvertBo<Article, ArticleParam> {
    @Override
    public ArticleParam compat(Article info) {
        return new ArticleParam().compat(info);
    }

    @Override
    public Article convert(ArticleParam info) {
        return info.convert();
    }
}
