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
    private Integer pageNo = 1;
    /**
     * 每页显示记录数
     */
    @Min(value = 1, message = "每页展示数量不合法")
    private Integer pageSize = 10;
    /**
     * 偏移量 {当前页 * 每页显示记录数}
     */
    private Integer offset;
    /** 排序列字段名称(数据库的字段) */
    private String orderColumnName;
    /** 排序方式 [ASC|DESC] */
    private String orderMode ="DESC";
    /**
     * 启用分页默认 true 分页查找; 设 false 查找全部不做分页查找
     */
    private Boolean enablePaging = true;


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
    public PageQuery(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public PageQuery(Boolean enablePaging){
        this.enablePaging = enablePaging;
    }

    /**
     * 构造函数
     * @param pageNo   当前页数
     * @param pageSize 每页显示记录数
     */
    public PageQuery(Integer pageNo, Integer pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    /**
     * 构造函数
     * @param pageNo   当前页数
     * @param orderColumnName 排序列字段名称(数据库的字段)
     */
    public PageQuery(Integer pageNo, String orderColumnName) {
        this.pageNo = pageNo;
        this.orderColumnName = orderColumnName;
    }

    /**
     * 构造函数
     * @param pageNo   当前页数
     * @param orderColumnName 排序列字段名称(数据库的字段)
     * @param enablePaging 启用分页默认 true 分页查找; 设 false 查找全部不做分页查找
     */
    public PageQuery(Integer pageNo, String orderColumnName, Boolean enablePaging) {
        this.pageNo = pageNo;
        this.orderColumnName = orderColumnName;
        this.enablePaging = enablePaging;
    }

    /**
     * 构造函数
     * @param pageNo   当前页数
     * @param orderColumnName 排序列字段名称(数据库的字段)
     * @param orderMode 排序方式 [ASC|DESC]
     */
    public PageQuery(Integer pageNo, String orderColumnName, String orderMode) {
        this.pageNo = pageNo;
        this.orderColumnName = orderColumnName;
        this.orderMode = orderMode;
    }

    /**
     * 构造函数
     * @param pageNo   当前页数
     * @param pageSize 每页显示记录数
     * @param orderColumnName 排序列字段名称(数据库的字段)
     * @param orderMode 排序方式 [ASC|DESC]
     */
    public PageQuery(Integer pageNo, Integer pageSize, String orderColumnName, String orderMode) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.orderColumnName = orderColumnName;
        this.orderMode = orderMode;
    }


    /**
     * @return 当前 页码
     */
    public Integer getPageNo() {
        return pageNo;
    }

    /**
     * @param pageNo 当前 页码
     */
    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * @return 每页显示记录数
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize 每页显示记录数
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * @return 偏移量 {当前页 * 每页显示记录数}
     */
    public Integer getOffset() {
        return (pageNo - 1) * pageSize;
    }

    /**
     * @param offset 偏移量 {当前页 * 每页显示记录数}
     */
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    /**
     * @return 排序列字段名称(数据库的字段)
     */
    public String getOrderColumnName() {
        return orderColumnName;
    }

    /**
     * @param orderColumnName 排序列字段名称(数据库的字段)
     */
    public void setOrderColumnName(String orderColumnName) {
        this.orderColumnName = orderColumnName;
    }

    /**
     * @return 排序方式 [ASC|DESC]
     */
    public String getOrderMode() {
        return orderMode;
    }

    /**
     * @param orderMode 排序方式 [ASC|DESC]
     */
    public void setOrderMode(String orderMode) {
        this.orderMode = orderMode;
    }

    /**
     * @return 启用分页默认 true 分页查找; 设 false 查找全部不做分页查找
     */
    public Boolean getEnablePaging() {
        return enablePaging;
    }

    /**
     * @param enablePaging 启用分页默认 true 分页查找; 设 false 查找全部不做分页查找
     */
    public void setEnablePaging(Boolean enablePaging) {
        this.enablePaging = enablePaging;
    }

    public interface PROS{
        /** 升序 */
        String ASC = "ASC";
        /** 降序 */
        String DESC = "DESC";

    }
}


