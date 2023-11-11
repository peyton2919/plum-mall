package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.ArticleCategoryParam;
import cn.peyton.plum.mall.pojo.ArticleCategory;

/**
 * <h4>文章类型 数据转换类</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.mall.bo.ArticleCategoryBo
 * @date 2023年11月10日 16:56
 * @version 1.0.0
 * </pre>
 */
public class ArticleCategoryBo extends BaseConvertBo<ArticleCategory, ArticleCategoryParam> {
    @Override
    public ArticleCategoryParam compat(ArticleCategory info) {
        return new ArticleCategoryParam().compat(info);
    }

    @Override
    public ArticleCategory convert(ArticleCategoryParam info) {
        return info.convert();
    }
}
