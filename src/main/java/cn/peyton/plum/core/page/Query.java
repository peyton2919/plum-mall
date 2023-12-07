package cn.peyton.plum.core.page;

import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * <h4>查找列表条件对象</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.core.page.
 * @date 2023年11月28日 10:54
 * @version 1.0.0
 * </pre>
 */
public class Query<P> implements Serializable {
    /** 关键字 */
    private String keyword;
    /** 标签 */
    private String tab;
    /** 条件类型 */
    private String type;
    /** 简单值 */
    private String simpleValue;
    /** 复杂(多选)值 */
    private String complexValue;
    /** int 值 */
    private Integer intValue;
    /** long 值 */
    private Long longValue;
    /** double 值 */
    private Double doubleValue;
    /** 分页 页码数 */
    @NotBlank(message = "Id 不能为空;")
    @Min(value = 1,message = "最小为1")
    private Integer pageNo;
    /** 扩展对象 */
    private P record;
    /** 扩展数据 */
    private Object data;

    /**
     * @return 关键字
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * @param keyword 关键字
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /**
     * @return 标签
     */
    public String getTab() {
        return tab;
    }

    /**
     * @param tab 标签
     */
    public void setTab(String tab) {
        this.tab = tab;
    }

    /**
     * @return 条件类型
     */
    public String getType() {
        return type;
    }

    /**
     * @param type 条件类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return 简单值
     */
    public String getSimpleValue() {
        return simpleValue;
    }

    /**
     * @param simpleValue 简单值
     */
    public void setSimpleValue(String simpleValue) {
        this.simpleValue = simpleValue;
    }

    /**
     * @return 复杂(多选)值
     */
    public String getComplexValue() {
        return complexValue;
    }

    /**
     * @param complexValue 复杂(多选)值
     */
    public void setComplexValue(String complexValue) {
        this.complexValue = complexValue;
    }

    /**
     * @return int 值
     */
    public Integer getIntValue() {
        return intValue;
    }

    /**
     * @param intValue int 值
     */
    public void setIntValue(Integer intValue) {
        this.intValue = intValue;
    }

    /**
     * @return long 值
     */
    public Long getLongValue() {
        return longValue;
    }

    /**
     * @param longValue long 值
     */
    public void setLongValue(Long longValue) {
        this.longValue = longValue;
    }

    /**
     * @return double 值
     */
    public Double getDoubleValue() {
        return doubleValue;
    }

    /**
     * @param doubleValue double 值
     */
    public void setDoubleValue(Double doubleValue) {
        this.doubleValue = doubleValue;
    }

    /**
     * @return 分页 页码数
     */
    public Integer getPageNo() {
        return pageNo;
    }

    /**
     * @param pageNo 分页 页码数
     */
    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * @return 扩展对象
     */
    public P getRecord() {
        return record;
    }

    /**
     * @param record 扩展对象
     */
    public void setRecord(P record) {
        this.record = record;
    }

    /**
     *
     * @return 扩展数据
     */
    public Object getData() {
        return data;
    }

    /**
     *
     * @param data 扩展数据
     */
    public void setData(Object data) {
        this.data = data;
    }
}
