package cn.peyton.plum.core.page;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.utils.base.Lists;

import java.io.Serializable;
import java.util.List;

/**
 * <h3>封装 返回对象适配器 类</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.beans.ResultAdapter.java
 * @createDate: 2018/9/15 9:40
 * @version: 1.0.0
 * </pre>
 */
public final class PageResultAdapter<K,T,P> implements Serializable {

    public PageResultAdapter() {
    }

    /**
     * <h4>查找 全部 对象集合的适配器</h4>
     *
     * @param mapper        查找 全部对象Mapper接口
     * @param page          分页对象
     * @param baseConvertBo 实现基础BO对象
     * @param <T>           需要操作对象
     * @return PageResult对象
     */
    //public static <T> PageResult<T> adapt(IBaseMapper mapper, PageQuery page, String keyword, BaseConvertBo baseConvertBo) {
    //    PageResult<T> result = new PageResult<T>();
    //    int count = mapper.count(keyword);
    //    if (count > 0) {
    //        result.setTotal(count);
    //        result.setData(baseConvertBo.adapter(mapper.selectByAllOrKeyword(keyword, page)));
    //    }
    //    return result;
    //}

    /**
     * <h4>根据对象条件查找</h4>
     * @param mapper 查找 全部对象Mapper接口 {IBaseMapper}
     * @param page 分页对象
     * @param record 需要操作对象
     * @param baseConvertBo 实现基础BO对象
     * @return PageResultc对象
     * @param <K> 主键类型
     * @param <T> POJO对象
     * @param <P> Param对象
     */
    public static <K, T, P> PageResult<?> adapt(IBaseMapper<K, T> mapper, PageQuery page,
                                                T record, BaseConvertBo<T, P> baseConvertBo) {
        List<T> tList = mapper.selectByObj(record, page);
        if (null != tList && tList.size() > 0) {
            int count = mapper.count(record);
            return new PageResult<>(baseConvertBo.adapter(tList),count,page.getPageNo(),page.getPageSize());
        }
        return new PageResult<>(false);
    }
    /**
     * <h4>根据对象条件查找</h4>
     * @param mapper 查找 全部对象Mapper接口 {IBaseMapper}
     * @param page 分页对象
     * @param record 需要操作对象
     * @param baseConvertBo 实现基础BO对象
     * @return PageResultc对象
     * @param <K> 主键类型
     * @param <T> POJO对象
     * @param <P> Param对象
     */
    public static <K, T, P> PageResult<?> adaptByLike(IBaseMapper<K, T> mapper, PageQuery page,
                                                T record, BaseConvertBo<T, P> baseConvertBo) {
        List<T> tList = mapper.selectByLikeAndObj(record, page);
        if (null != tList && tList.size() > 0) {
            int count = mapper.countByLike(record);
            return new PageResult<>(baseConvertBo.adapter(tList),count,page.getPageNo(),page.getPageSize());
        }
        return new PageResult<>(false);
    }

    /**
     * <h4>封装数据</h4>
     *
     * @param data  对象集合
     * @param count 条数
     * @param <T>   需要操作对象
     * @return
     */
    public static <T> PageResult<T> adapt(List<T> data, Integer count) {
        PageResult<T> result = new PageResult<T>();
        if (Lists.isNotEmptyList(data)) {
            result.setData(data);
            result.setTotalRows(count);
        }
        return result;
    }

    /**
     * <h4>返回一个空的PageResult</h4>s
     * @param <T> 需要操作对象
     * @return
     */
    public static <T> PageResult<T> empty() {
        return new PageResult<T>();
    }


}
