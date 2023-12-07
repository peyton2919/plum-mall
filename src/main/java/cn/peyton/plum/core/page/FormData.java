package cn.peyton.plum.core.page;

import java.io.Serializable;
import java.util.List;

/**
 * <h4>表单对象</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.core.page.
 * @date 2023年11月29日 8:00
 * @version 1.0.0
 * </pre>
 */
public class FormData<P> implements Serializable {
    /**
     * int 主键
     */
    private Integer keyInt = -1;
    /** long 主键 */
    private Long keyLong = -1L;
    /** str 主键 */
    private String str;
    /** long 集合 */
    private List<Long> longs;
    /** int 集合 */
    private List<Integer> ints;
    /** string 集合 */
    private List<String> strs;
    /** 对象 集合 */
    private  List<P> objs;
    /** P 对象 */
    private P record;
    /** 状态值 */
    private Integer status;
    /** 数据 */
    private Object data;
    /** 布尔值 */
    private Boolean bool;



    /**
     * @return int 主键
     */
    public Integer getKeyInt() {
        return keyInt;
    }

    /**
     * @param keyInt int 主键
     */
    public void setKeyInt(Integer keyInt) {
        this.keyInt = keyInt;
    }

    /**
     * @return long 主键
     */
    public Long getKeyLong() {
        return keyLong;
    }
    /**
     * @param keyLong long 主键
     */
    public void setKeyLong(Long keyLong) {
        this.keyLong = keyLong;
    }

    /**
     * @return str 主键
     */
    public String getStr() {
        return str;
    }

    /**
     * @param str str 主键
     */
    public void setStr(String str) {
        this.str = str;
    }

    /**
     * @return  long集合
     */
    public List<Long> getLongs() {
        return longs;
    }
    /**
     * @param longs  long集合
     */
    public void setLongs(List<Long> longs) {
        this.longs = longs;
    }
    /**
     * @return  int集合
     */
    public List<Integer> getInts() {
        return ints;
    }
    /**
     * @param ints  int集合
     */
    public void setInts(List<Integer> ints) {
        this.ints = ints;
    }
    /**
     * @return String集合
     */
    public List<String> getStrs() {
        return strs;
    }
    /**
     * @param strs String集合
     */
    public void setStrs(List<String> strs) {
        this.strs = strs;
    }

    /**
     * @return 对象 集合
     */
    public List<P> getObjs() {
        return objs;
    }

    /**
     * @param objs 对象 集合
     */
    public void setObjs(List<P> objs) {
        this.objs = objs;
    }

    /**
     * @return 状态值
     */
    public Integer getStatus() {
        return status;
    }
    /**
     * @param status 状态值
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return 数据
     */
    public Object getData() {
        return data;
    }

    /**
     * @param data 数据
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * @return  P 对象
     */
    public P getRecord() {
        return record;
    }

    /**
     * @param record  P 对象
     */
    public void setRecord(P record) {
        this.record = record;
    }

    /**
     * @return 布尔值
     */
    public Boolean getBool() {
        return bool;
    }

    /**
     * @param bool 布尔值
     */
    public void setBool(Boolean bool) {
        this.bool = bool;
    }
}
