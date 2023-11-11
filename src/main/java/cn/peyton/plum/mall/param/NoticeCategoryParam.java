package cn.peyton.plum.mall.param;


import cn.peyton.plum.mall.pojo.NoticeCategory;

import java.io.Serializable;

/**
 * <h3> 公告类型 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:24
 * @version 1.0.0
 * </pre>
 */
public class NoticeCategoryParam implements Serializable {
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
     * <h4>对象转成NoticeCategory对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,name,seq]
     * </pre>
     */
    public NoticeCategory convert() {
        NoticeCategory noticeCategory = new NoticeCategory();
        noticeCategory.setId(id);
        noticeCategory.setName(name);
        noticeCategory.setSeq(seq);
        return noticeCategory;
    }

    /**
     * <h4>NoticeCategory对象转成NoticeCategoryParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,name,seq]
     * </pre>
     */
    public NoticeCategoryParam compat(NoticeCategory noticeCategory) {
        if (null == noticeCategory) {
            return new NoticeCategoryParam();
        }
        this.setId(noticeCategory.getId());
        this.setName(noticeCategory.getName());
        this.setSeq(noticeCategory.getSeq());
        return this;
    }
}
