package cn.peyton.plum.core.inf.service;

import cn.peyton.plum.core.anno.timestamp.AutoWriteTimestamp;
import cn.peyton.plum.core.cache.LocalCache;
import cn.peyton.plum.core.err.GlobalException;
import cn.peyton.plum.core.err.ValidationException;
import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.PageResult;
import cn.peyton.plum.core.page.PageResultAdapter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
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
 *     4. 如需要开启缓存,在子类的空构造要初始化 enabledCache 和 keyPrefix; 推荐以下二行写法
 *        enabledCache = true;
 *        keyPrefix = this.getClass().getName();
 *
 *     5. 事务 默认: Propagation.REQUIRED
 *      Propagation.REQUIRED 支持当前事务,假设当前没有事务,就新建一个事务;
 *      Propagation.SUPPORTS 支持当前事务,假设当前没有事务,就以非事务方式运行;
 *      Propagation.MANDATORY 支持当前事务,假设当前没有事务,就抛出异常;
 *      Propagation.REQUIRES_NEW 新建事务,假设当前存在事务,把当前事务挂起;
 *      Propagation.NOT_SUPPORTED 以非事务方式运行操作,假设当前存在事务,就把当前事务挂起;
 *      Propagation.NEVER 以非事务方式运行,假设当前存在事务,则抛出异常;
 *      Propagation.NESTED 如果当前存在事务,则在嵌套事务内执行;则执行与REQUIRED类似的操作;
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
@Transactional(rollbackFor = {ValidationException.class, GlobalException.class, RuntimeException.class, Exception.class},
    propagation = Propagation.REQUIRED)
public abstract class AbstractRealizeService<K, T, P> implements IBaseService<K, T, P> {

    /**
     * <h4>添加对象</h4>
     * <pre>
     *     判断 P 对象 为 null 表示添加失败
     * </pre>
     *
     * @param param 对象
     * @return 添加成功返回带 ID 对象, 否则返回 null
     */
    @AutoWriteTimestamp
    public P add(P param) {
        T record = initBo().convert(param);
        int result = initMapper().insertSelective(record);
        if (result > 0) {
            if (enabledCache) {
                System.out.println("添加对象操作,清空缓存");
                removeCache();
            }
            return initBo().compat(record);
        }
        return null;
    }

    /**
     * <h4>更新 对象[根据属性是否有值 更新]</h4>
     *
     * @param param 对象
     * @return true 表示 成功, 否则 取 false
     */
    @AutoWriteTimestamp("updateTime")
    public Boolean update(P param) {
        int result = initMapper().updateSelective(initBo().convert(param));
        if (result > 0) {
            if (enabledCache) {
                System.out.println("更新对象操作,清空缓存");
                removeCache();
            }
            return true;
        }
        return false;
    }

    /**
     * <h4>根据 ID 删除 T对象</h4>
     * @param id 对象ID
     * @return true 表示 成功, 否则 取 false
     */
    @Transactional(rollbackFor={RuntimeException.class,Exception.class})
    public Boolean delete(K id) {
        int result = initMapper().deleteByPrimaryKey(id);
        if (result > 0) {
            if(enabledCache){
                System.out.println("删除对象操作,清空缓存");
                removeCache();
            }
            return true;
        }
        return false;
    }

    /**
     * <h4>判断是否重名</h4>
     * @param param 对象
     * @return true 表示 重名, 否则 取 false
     */
    public Boolean repeat(P param) {
        return initMapper().repeat(initBo().convert(param)) > 0;
    }

    /**
     * <h4>根据 ID 查找 T对象</h4>
     * @param id 对象ID
     * @return 对象
     */
    public P findById(K id) {
        String key = keyPrefix + id;
        if(enabledCache){
            Object obj = cache.get(key);
            if(null != obj){
                System.out.printf("从缓存获取到对象: key= %s;\n",key);
                return (P) obj;
            }
        }
        P param = initBo().compat(initMapper().selectByPrimaryKey(id));
        if (null != param && enabledCache) {
            System.out.printf("添加对象到缓存: key= %s;\n",key);
            cache.put(key,param);
        }
        return param;
    }

    /**
     * <h4>分页查询(模糊查找)</h4>
     * @param param 关键字, 当 param = null 时为全部查询
     * @param page  分页对象
     * @return 对象集合
     */
    public List<P> findByLikeAndObj(P param, PageQuery page) {
        String key = createKey(param,page,true);
        if (enabledCache){
            Object list = cache.get(key);
            if (null != list) {
                System.out.printf("从缓存获取到对象: key= %s;\n",key);
                return (List<P>)list;
            }
        }
        List<P> pList = initBo().adapter(initMapper().selectByLiekAndObj(initBo().convert(param), page));
        if (null != pList && pList.size() > 0 && enabledCache) {
            System.out.printf("添加对象到缓存: key= %s;\n",key);
            cache.put(key,pList);
        }
        return pList;
    }

    /**
     * <h4>分页查询(模糊查找)</h4>
     * @param param 关键字, 当 param = null 时为全部查询
     * @param page  分页对象
     * @return 对象集合
     */
    public PageResult<?> findAllByLike(P param, PageQuery page) {
        return getPageResult(param, page, true, createKey(param,page,true));
    }

    /**
     * <h4>根据对象条件查找</h4>
     * @param param 对象
     * @param page  分页对象
     * @return 对象集合
     */
    public PageResult<?> findAll(P param, PageQuery page) {
        return getPageResult(param, page, false, createKey(param,page,false));
    }

    /**
     * <h4>根据对象条件查找</h4>
     * @param param 对象
     * @param page  分页对象
     * @return 对象集合
     */
    public List<P> findByObj(P param, PageQuery page) {
        String key = createKey(param,page,false);
        if (enabledCache){
            Object list = cache.get(key);
            if (null != list) {
                System.out.printf("从缓存获取到对象: key= %s;\n",key);
                return (List<P>)list;
            }
        }
        List<P> pList = initBo().adapter(initMapper().selectByObj(initBo().convert(param), page));

        if (null != pList && pList.size() > 0 && enabledCache) {
            System.out.printf("添加对象到缓存: key= %s;\n",key);
            cache.put(key,pList);
        }
        return pList;
    }

    /**
     * <h4>查找全部数量(全部或关键字模糊查找)</h4>
     * @param param 关键字, 当 param = null 时为全部查询
     * @return 总条数
     */
    public Integer countByLike(P param) {
        String key = createKey(param,null,true);
        if (enabledCache){
            Object obj = cache.get(key);
            if (null != obj) {
                System.out.printf("从缓存获取到对象: key= %s;\n",key);
                return (Integer) obj;
            }
        }
        Integer result = initMapper().countByLike(initBo().convert(param));
        if (result > 0 && enabledCache) {
            System.out.printf("添加对象到缓存: key= %s;\n",key);
            cache.put(key, result);
        }
        return result;
    }

    /**
     * <h4>查找全部数量(全部或关键字模糊查找)</h4>
     * @param param 关键字, 当 param = null 时为全部查询
     * @return 总条数
     */
    public Integer count(P param) {
        String key = createKey(param,null,false);
        if (enabledCache){
            Object obj = cache.get(key);
            if (null != obj) {
                System.out.printf("从缓存获取到对象: key= %s;\n",key);
                return (Integer) obj;
            }
        }
        Integer result = initMapper().count(initBo().convert(param));
        if (result > 0 && enabledCache) {
            System.out.printf("添加对象到缓存: key= %s;\n",key);
            cache.put(key, result);
        }
        return result;
    }

    // -----------------------------------------   构造与抽象方法 开始   ----------------------------------------- //
    /**
     * 构造函数
     */
    public AbstractRealizeService() {
        if (null == cache) {
            cache = LocalCache.getInstance();
        }
    }

    /**
     * <h4>初始化对象的 BO 类</h4>
     * @return 对象BO类
     */
    public abstract BaseConvertBo<T, P> initBo();

    /**
     * <h4>初始化对象的 BO 类</h4>
     * @return 对象BO类
     */
    public abstract IBaseMapper<K, T> initMapper();

    // -----------------------------------------   构造与抽象方法 结束   ----------------------------------------- //
    
    // -----------------------------------------   protected 方法 开始   ----------------------------------------- //
    protected LocalCache cache = null;
    /** 是否激活缓存 默认为 false */
    protected  boolean enabledCache = false;
    /** 缓存 key 前缀 推荐用 类的全名 */
    protected String keyPrefix = "";

    /**
     * <h4>移除全部缓存</h4>
     */
    protected void removeCache() {
        if (null != cache){
            cache.removeAll();
        }
    }

    /**
     * <h4>创建 缓存 key 值</h4>
     * @param param 对象
     * @param page 分页对象
     * @param isLike true like 查找
     * @return 字符串
     */
    private String createKey(P param,PageQuery page,Boolean isLike){
        StringBuffer sb = new StringBuffer(keyPrefix);
        sb.append("_list_");
        if(null != param){
            sb.append(page.getPageNo());
            sb.append("_");
            sb.append(page.getPageSize());
            sb.append("_");
            sb.append(page.getOrderByColumuName());
            sb.append("_");
            sb.append(page.getOrderByMode());
        }
        if(isLike){
            sb.append("_like_");
        }
        sb.append(getKeySuffix(param));
        return sb.toString();
    }
    // -----------------------------------------   protected 方法 结束   ----------------------------------------- //

    // -----------------------------------------   private 方法 开始   ----------------------------------------- //
    /**
     * <h4>根据对象条件查找</h4>
     * @param param 对象
     * @param page  分页对象
     * @param isLike  true 为 like 查找
     * @param key  分页对象
     * @return 对象集合
     */
    private PageResult<?> getPageResult(P param, PageQuery page,Boolean isLike,String key) {
        if(enabledCache){
            Object list = cache.get(key);
            if (null != list) {
                System.out.printf("从缓存获取到对象: key= %s;\n",key);
                return (PageResult<?>)list;
            }
        }
        PageResult<?> result = isLike?PageResultAdapter.adaptByLike(initMapper(), page, initBo().convert(param), initBo()):
                PageResultAdapter.adapt(initMapper(), page, initBo().convert(param), initBo());
        if (null != result && result.isSuccess && enabledCache) {
            System.out.printf("添加对象到缓存: key= %s;\n",key);
            cache.put(key,result);
        }
        return result;
    }

    /**
     * <h4>获取 key 的后缀</h4>
     * @param param 对象
     * @return key的后缀字段
     */
    public StringBuffer getKeySuffix(P param){
        Field[] fields = param.getClass().getDeclaredFields();
        StringBuffer sb = new StringBuffer();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object obj = field.get(param);
                if(null != obj && !"".equals(obj)){
                    sb.append(obj);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return sb;
    }
    // -----------------------------------------   private 方法 结束   ----------------------------------------- //
}
