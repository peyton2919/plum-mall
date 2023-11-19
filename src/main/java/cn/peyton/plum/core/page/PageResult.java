package cn.peyton.plum.core.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <h3>分页展示返回类</h3>
 * <pre>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 14:27
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @version 1.0.0
 * </pre>
 */
public final class PageResult<P> implements Serializable {
    /** 数据获取到数据,默认为true,没找到数据可以设置为 false 返回,程序继续运行时判断 */
    public Boolean isSuccess = true;
    /**
     * 返回数据 集合
     */
    private List<P> data = new ArrayList<P>();
    /**
     * 总条数
     */
    private int totalRows = 0;
    /** 总页数 */
    private int totalPages = 0;

    /**
     * 当前页码 ,默认1
     */
    private int currentPage = 1;
    /**
     * 每页记录数,默认10
     */
    private int pageRecorders = 10;

    /**
     * 参数属性(多个参数属性用','隔开)
     */
    private String paramPros;
    /**
     * 参数值(多个参数值用','隔开)
     */
    private Object paramValues;

    //================================== Constructor =======================================//

    /**
     * <h4>构造函数</h4>
     */
    public PageResult() {
    }

    /**
     * <h4>构造函数</h4>
     * @param isSuccess 数据获取到数据,默认为true,没找到数据可以设置为 false 返回,程序继续运行时判断
     */
    public PageResult(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }


    /**
     * <h4>构造函数</h4>
     * @param data  返回数据 集合
     * @param totalRows 总条数
     */
    public PageResult(List<P> data, int totalRows) {
        this.data = data;
        this.totalRows = totalRows;
    }

    /**
     * <h4>构造函数</h4>
     * @param data  返回数据 集合
     * @param totalRows 总条数
     * @param currentPage 当前页码 ,默认1
     */
    public PageResult(List<P> data, int totalRows,int currentPage) {
        this.data = data;
        this.totalRows = totalRows;
        this.currentPage = currentPage;
    }

    /**
     * <h4>构造函数</h4>
     * @param data  返回数据 集合
     * @param totalRows 总条数
     * @param currentPage 当前页码 ,默认1
     * @param pageRecorders 每页记录数,默认10
     */
    public PageResult(List<P> data, int totalRows,int currentPage,int pageRecorders) {
        this.data = data;
        this.totalRows = totalRows;
        this.currentPage = currentPage;
        this.pageRecorders = pageRecorders;
    }

    /**
     * <h4>赋值</h4>
     *
     * @param data  数据
     * @param total 总条数
     */
    public void set(List<P> data, int total) {
        this.data = data;
        this.totalRows = total;
    }


    /**
     * <h4>构造函数</h4>
     * @param data  返回数据 集合
     * @param totalRows 总条数
     * @param currentPage 当前页码 ,默认1
     * @param pageRecorders 每页记录数,默认10
     * @param paramPros 参数属性(多个参数属性用','隔开)
     * @param paramValues 参数值(多个参数值用','隔开)
     */
    public PageResult(List<P> data, int totalRows,int currentPage,int pageRecorders,
                      String paramPros,String paramValues) {
        this.data = data;
        this.totalRows = totalRows;
        this.currentPage = currentPage;
        this.pageRecorders = pageRecorders;
        this.paramPros = paramPros;
        this.paramValues = paramValues;
    }

    //================================== GET AND SET =======================================//

    /**
     * @return 返回数据 集合
     */
    public List<P> getData() {
        return data;
    }

    /**
     * @param data 返回数据 集合
     */
    public void setData(List<P> data) {
        this.data = data;
    }

    /**
     * @return 总条数
     */
    public int getTotalRows() {
        return totalRows;
    }

    /**
     * @param totalRows 总条数
     */
    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    /**
     * @return 获取总页数
     */
    public int getTotalPages() {
        if (this.totalRows <= 0 || this.pageRecorders <= 0) {return 0;}
        return (totalRows / pageRecorders) + (totalRows % pageRecorders > 0 ? 1 : 0);
    }

    /**
     * @return 当前页码
     */
    public int getCurrentPage() {
        return currentPage;
    }

    /**
     * @param currentPage 当前页码
     */
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * @return 每页记录数,默认10
     */
    public int getPageRecorders() {
        return pageRecorders;
    }

    /**
     * @param pageRecorders 每页记录数,默认10
     */
    public void setPageRecorders(int pageRecorders) {
        this.pageRecorders = pageRecorders;
    }

    /**
     * @return 参数属性(多个参数属性用','隔开)
     */
    public String getParamPros() {
        return paramPros;
    }

    /**
     * @param paramPros 参数属性(多个参数属性用','隔开)
     */
    public void setParamPros(String paramPros) {
        this.paramPros = paramPros;
    }

    /**
     * @return 参数值(多个参数值用','隔开)
     */
    public Object getParamValues() {
        return paramValues;
    }

    /**
     * @param paramValues 参数值(多个参数值用','隔开)
     */
    public void setParamValues(Object paramValues) {
        this.paramValues = paramValues;
    }

}
