package cn.peyton.plum.core.inf.service;

import cn.peyton.plum.core.anno.timestamp.AutoWriteTimestamp;
import cn.peyton.plum.core.cache.LocalCache;
import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.PageResult;
import cn.peyton.plum.core.page.PageResultAdapter;
import org.springframework.stereotype.Service;

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
public abstract class AbstractRealizeService<K, T, P> implements IBaseService<K, T, P> {
    protected LocalCache cache = null;

    /** 是否激活缓存 默认为 false */
    protected  boolean enabledCache = false;
    /** 缓存 key 前缀 推荐用 类的全名 */
    protected String keyPrefix = "";

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
            if (enabledCache){
                System.out.println("添加对象操作,清空缓存");
                removeCache();
            }
            return initBo().compat(record);
        }
        return null;
    }

    /**
     * <h4>更新 对象[根据属性是否有值 更新]</h4>
     * @param param 对象
     * @return true 表示 成功, 否则 取 false
     */
    @AutoWriteTimestamp("updateTime")
    public Boolean update(P param) {
        int result = initMapper().updateSelective(initBo().convert(param));
        if (result>0){
            if (enabledCache){
                System.out.println("更新对象操作,清空缓存");
                removeCache();
            }
            return true;
        }
        return false;
    }

    /**
     * <h4>根据 ID 删除 T对象</h4>
     *
     * @param id 对象ID
     * @return true 表示 成功, 否则 取 false
     */
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
    public Boolean isRename(P param) {

        return initMapper().isRename(initBo().convert(param)) > 0;
    }

    /**
     * <h4>根据 ID 查找 T对象</h4>
     *
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
        String key = keyPrefix + "-list-" + page.getPageNo() + getKeySuffix(param) + "like";
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
        String key = keyPrefix + "-list-" + page.getPageNo() + getKeySuffix(param) + "like";
        return getPageResult(param, page, true, key);
    }
    /**
     * <h4>根据对象条件查找</h4>
     * @param param 对象
     * @param page  分页对象
     * @return 对象集合
     */
    public PageResult<?> findAll(P param, PageQuery page) {
        String key = keyPrefix + "-list-" + page.getPageNo() + getKeySuffix(param);
        return getPageResult(param, page, false, key);
    }

    /**
     * <h4>根据对象条件查找</h4>
     * @param param 对象
     * @param page  分页对象
     * @return 对象集合
     */
    public List<P> findByObj(P param, PageQuery page) {
        String key = keyPrefix + "-list-" + page.getPageNo() + getKeySuffix(param);
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
        String key = keyPrefix + "-list-" + getKeySuffix(param) + "like";
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
        String key = keyPrefix + "-list-" + getKeySuffix(param);
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

    /**
     * <h4>移除全部缓存</h4>
     */
    protected void removeCache() {
        if (null != cache){
            cache.removeAll();
        }
    }

    /**
     * <h4>获取 key 的后缀</h4>
     * @param param 对象
     * @return key的后缀字段
     */
    protected StringBuffer getKeySuffix(P param){
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
        PageResult<?> result = isLike?PageResultAdapter.adapt(initMapper(), page, initBo().convert(param), initBo()):
                PageResultAdapter.adapt(initMapper(), page, initBo().convert(param), initBo());
        if (null != result && result.isSuccess && enabledCache) {
            System.out.printf("添加对象到缓存: key= %s;\n",key);
            cache.put(key,result);
        }
        return result;
    }

}
