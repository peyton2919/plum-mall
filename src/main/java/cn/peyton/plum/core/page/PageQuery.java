package cn.peyton.plum.core.page;

import cn.peyton.plum.core.validator.constraints.Min;

import java.io.Serializable;

/**
 * <h3>分页查询 实体类</h3>
 * <pre>
 *     PageQuery page:
 *     limit #{page.offset},#{page.pageSize}
 * </pre>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 14:26
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public final class PageQuery implements Serializable {
    /**
     * 当前 页码
     */
    @Min(value = 1, message = "当前页码不合法")
    private int pageNo = 1;
    /**
     * 每页大小
     */
    @Min(value = 1, message = "每页展示数量不合法")
    private int pageSize = 10;
    /**
     * 偏移量 {当前页 * 每页大小}
     */
    private int offset;
    /** 排序列字段名称(数据库的字段) */
    private String orderByColumuName;
    /** 排序方式 [ASC|DESC] */
    private String orderByMode="ASC";

    /**
     * 无参构造函数
     */
    public PageQuery() {
    }

    /**
     * 构造函数
     *
     * @param pageNo 当前页数
     */
    public PageQuery(int pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * 构造函数
     * @param pageNo   当前页数
     * @param pageSize 每页大小
     */
    public PageQuery(int pageNo, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    /**
     * 构造函数
     * @param pageNo   当前页数
     * @param orderByColumuName 排序列字段名称(数据库的字段)
     */
    public PageQuery(int pageNo, String orderByColumuName) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.orderByColumuName = orderByColumuName;
        this.orderByMode = orderByMode;
    }

    /**
     * 构造函数
     * @param pageNo   当前页数
     * @param orderByColumuName 排序列字段名称(数据库的字段)
     * @param orderByMode 排序方式 [ASC|DESC]
     */
    public PageQuery(int pageNo,String orderByColumuName,String orderByMode) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.orderByColumuName = orderByColumuName;
        this.orderByMode = orderByMode;
    }

    /**
     * 构造函数
     * @param pageNo   当前页数
     * @param pageSize 每页大小
     * @param orderByColumuName 排序列字段名称(数据库的字段)
     * @param orderByMode 排序方式 [ASC|DESC]
     */
    public PageQuery(int pageNo, int pageSize,String orderByColumuName,String orderByMode) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.orderByColumuName = orderByColumuName;
        this.orderByMode = orderByMode;
    }


    /**
     * @return 当前 页码
     */
    public int getPageNo() {
        return pageNo;
    }

    /**
     * @param pageNo 当前 页码
     */
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * @return 每页大小
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize 每页大小
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * @return 偏移量 {当前页 * 每页大小}
     */
    public int getOffset() {
        return (pageNo - 1) * pageSize;
    }

    /**
     * @param offset 偏移量 {当前页 * 每页大小}
     */
    public void setOffset(int offset) {
        this.offset = offset;
    }

    /**
     * @return 排序列字段名称(数据库的字段)
     */
    public String getOrderByColumuName() {
        return orderByColumuName;
    }

    /**
     * @param orderByColumuName 排序列字段名称(数据库的字段)
     */
    public void setOrderByColumuName(String orderByColumuName) {
        this.orderByColumuName = orderByColumuName;
    }

    /**
     * @return 排序方式 [ASC|DESC]
     */
    public String getOrderByMode() {
        return orderByMode;
    }

    /**
     * @param orderByMode 排序方式 [ASC|DESC]
     */
    public void setOrderByMode(String orderByMode) {
        this.orderByMode = orderByMode;
    }

    public interface PROS{
        /** 升序 */
        String ASC = "ASC";
        /** 降序 */
        String DESC = "DESC";

    }
}


