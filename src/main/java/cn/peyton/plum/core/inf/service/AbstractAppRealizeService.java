package cn.peyton.plum.core.inf.service;

import cn.peyton.plum.core.anno.timestamp.AutoWriteTimestamp;
import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.page.PageQuery;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h4>app 局部实现 service 类</h4>
 * <pre>
 *     1. 这个类是数据层 T(POJO) 类, 视图层 P(Param) ;
 *          需要 T->P , P->T的转化, 需要创建相关 BO 类,并继承 BaseConvertBo 实现;
 *     2. mapper 层 必需继承 IBaseMapper 接口；
 *     3. service 层方法可以继承这个抽象类, controller 层可以直接调用以下方法:
 *        1). add   添加对象 =>{带 ID 对象}
 *        2). update 更新对象 =>{true 表示 成功, 否则 取 false}
 *        3). delete 删除对象 =>{true 表示 成功, 否则 取 false}
 *        4). isRename 判断是否重名 =>{true 表示 重名, 否则 取 false}
 *        5). upStatus 更新状态 =>{true 表示 成功, 否则 取 false}
 *        6). findById  根据 ID 查找对象 =>{对象}
 *        7). findByAllOrKeyword 根据 关键字 分页查找对象集合 =>{对象集合}
 *        8). findByObj     根据 对象 分页查找对象集合 =>{集合}
 *        9). count 根据关键字查找相应总条数 =>{总条数}
 * </pre>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.core.inf.service.AbstractAppService
 * @date 2023年10月27日 8:18
 * @version 1.0.0
 * </pre>
 */
@Service
public abstract class AbstractAppRealizeService<K,T,P> {

    private BaseConvertBo<T,P> bo;

    private IBaseMapper<K, T> mapper;



    public AbstractAppRealizeService(){
    }

    /**
     * <h4>初始化对象的 BO 类</h4>
     * @return 对象BO类
     */
    public abstract BaseConvertBo<T, P> initRecordBo();

    /**
     * <h4>初始化对象的 BO 类</h4>
     * @return 对象BO类
     */
    public abstract IBaseMapper<K, T> initRecordMapper();

    /**
     * <h4>添加对象</h4>
     * <pre>
     *     判断 P 对象 为 null 表示添加失败
     * </pre>
     * @param param 对象
     * @return 添加成功返回带 ID 对象, 否则返回 null
     */
    @AutoWriteTimestamp
    public P add(P param) {

        T recoed = initRecordBo().convert(param);
        int result = initRecordMapper().insertSelective(recoed);
        if (result > 0) {
            param = initRecordBo().compat(recoed);
            return  param;
        }
        return null;
    }
    /**
     * <h4>更新 对象[根据属性是否有值 更新]</h4>
     * @param param 对象
     * @return true 表示 成功, 否则 取 false
     */
    public Boolean update(P param) {

        return mapper.updateByPrimaryKeySelective(bo.convert(param)) > 0 ? true : false;
    }
    /**
     * <h4>根据 ID 删除 T对象</h4>
     * @param id 对象ID
     * @return true 表示 成功, 否则 取 false
     */
    public Boolean delete(K id) {

        return mapper.deleteByPrimaryKey(id) > 0 ? true : false;
    }
    /**
     * <h4>判断是否重名</h4>
     * @param param 对象
     * @return true 表示 重名, 否则 取 false
     */
    public Boolean isRename(P param) {

        return mapper.isRename(bo.convert(param)) > 0 ? true : false;
    }
    /**
     * <h4>根据 ID 查找 T对象</h4>
     * @param id 对象ID
     * @return 对象
     */
    public P findById(K id) {
        return bo.compat(mapper.selectByPrimaryKey(id));
    }
    /**
     * <h4>分页查询(全部或关键字模糊查找)</h4>
     * @param keyword 关键字, 当keyword = null 时为全部查询
     * @param page 分页对象
     * @return 对象集合
     */
    public List<P> findByAllOrKeyword(String keyword, PageQuery page) {

        return bo.adapter(mapper.selectByAllOrKeyword(keyword,page));
    }
    /**
     * <h4>根据对象条件查找</h4>
     * @param param 对象
     * @param page 分页对象
     * @return 对象集合
     */
    public List<P> findByObj(P param, PageQuery page) {

        return bo.adapter(mapper.selectByObj(bo.convert(param),page));
    }
    /**
     * <h4>查找全部数量(全部或关键字模糊查找)</h4>
     * @param keyword 关键字, 当keyword = null 时为全部查询
     * @return 总条数
     */
    public Integer count(String keyword) {
        return mapper.count(keyword);
    }
    /**
     * <h4>更新状态</h4>
     * @param id 主键
     * @param status 状态值
     * @return true 表示 成功, 否则 取 false
     */
    public Boolean upStatus(K id, Integer status) {
        return mapper.upStatus(id, status) > 0 ? true : false;
    }

}
