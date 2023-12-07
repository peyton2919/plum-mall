package cn.peyton.plum.mall.param.pub;


import cn.peyton.plum.mall.pojo.pub.ArticleCategory;

import java.io.Serializable;

/**
 * <h3> 文章类型 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:24
 * @version 1.0.0
 * </pre>
 */
public class ArticleCategoryParam implements Serializable {
    /**
     *
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 排序取值范围0~9999，默认为0; 按大到小排序
     */
    private Short seq;

    //================================== Constructor =======================================//

    //================================== Method =======================================//


    //================================== PREFIX_GET AND PREFIX_SET =======================================//

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return 名称
     */
    public String getName() {
        return name;
    }

    /**
     * @param seq 排序取值范围0~9999，默认为0; 按大到小排序
     */
    public void setSeq(Short seq) {
        this.seq = seq;
    }

    /**
     * @return 排序取值范围0~9999，默认为0; 按大到小排序
     */
    public Short getSeq() {
        return seq;
    }

    /**
     * <h4>对象转成ArticleCategory对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,name,seq]
     * </pre>
     */
    public ArticleCategory convert() {
        ArticleCategory articleCategory = new ArticleCategory();
        articleCategory.setId(id);
        articleCategory.setName(name);
        articleCategory.setSeq(seq);
        return articleCategory;
    }

    /**
     * <h4>ArticleCategory对象转成ArticleCategoryParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,name,seq]
     * </pre>
     */
    public ArticleCategoryParam compat(ArticleCategory articleCategory) {
        if (null == articleCategory) {
            return new ArticleCategoryParam();
        }
        this.setId(articleCategory.getId());
        this.setName(articleCategory.getName());
        this.setSeq(articleCategory.getSeq());
        return this;
    }
}
