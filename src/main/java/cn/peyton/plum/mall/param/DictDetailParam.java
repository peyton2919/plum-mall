package cn.peyton.plum.mall.param;


import cn.peyton.plum.mall.pojo.DictDetail;

import java.io.Serializable;

/**
 * <h3> 数据字典详情 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:24
 * @version 1.0.0
 * </pre>
 */
public class DictDetailParam implements Serializable {
    /**
     *
     */
    private Long id;
    /**
     * 字典id
     */
    private Long dictId;
    /**
     * 字典标签
     */
    private String label;
    /**
     * 字典值
     */
    private String dictValue;
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
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * @param dictId 字典id
     */
    public void setDictId(Long dictId) {
        this.dictId = dictId;
    }

    /**
     * @return 字典id
     */
    public Long getDictId() {
        return dictId;
    }

    /**
     * @param label 字典标签
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return 字典标签
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param dictValue 字典值
     */
    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    /**
     * @return 字典值
     */
    public String getDictValue() {
        return dictValue;
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
     * <h4>对象转成DictDetail对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,dictId,label,dictValue,seq]
     * </pre>
     */
    public DictDetail convert() {
        DictDetail dictDetail = new DictDetail();
        dictDetail.setId(id);
        dictDetail.setDictId(dictId);
        dictDetail.setLabel(label);
        dictDetail.setDictValue(dictValue);
        dictDetail.setSeq(seq);
        return dictDetail;
    }

    /**
     * <h4>DictDetail对象转成DictDetailParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,dictId,label,dictValue,seq]
     * </pre>
     */
    public DictDetailParam compat(DictDetail dictDetail) {
        if (null == dictDetail) {
            return new DictDetailParam();
        }
        this.setId(dictDetail.getId());
        this.setDictId(dictDetail.getDictId());
        this.setLabel(dictDetail.getLabel());
        this.setDictValue(dictDetail.getDictValue());
        this.setSeq(dictDetail.getSeq());
        return this;
    }
}
