package cn.peyton.plum.core.inf.service;

import cn.peyton.plum.core.anno.timestamp.AutoWriteTimestamp;
import cn.peyton.plum.core.cache.LocalCache;
import cn.peyton.plum.core.err.TransactionalException;
import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.PageResult;
import cn.peyton.plum.core.page.PageResultAdapter;
import cn.peyton.plum.core.utils.LogUtils;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.util.List;

/**
 * <h4>service 实现类</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.core.inf.service.
 * @date 2024年03月27日 20:05
 * @version 1.0.0
 * </pre>
 */
public abstract class RealizeService<K, T, P> {

    /**
     * <h4>添加对象</h4>
     * <pre>
     *     判断 P 对象 为 null 表示添加失败
     * </pre>
     * @param record 对象
     * @return 添加成功返回带 ID 对象, 否则返回 null
     */
    @AutoWriteTimestamp
    @Transactional(rollbackFor = {TransactionalException.class})
    public P insert(P record) {
        T tmp = bo().convert(record);
        int result = mapper().insertSelective(tmp);
        if (result > 0) {
            if (enabledCache) {
                System.out.println("添加对象操作,清空缓存");
                LogUtils.info("添加对象操作,清空缓存");
                removeCache();
            }
            return bo().compat(tmp);
        }
        return null;
    }

    /**
     * <h4>更新 对象[根据属性是否有值 更新]</h4>
     * @param record 对象
     * @return true 表示 成功, 否则 取 false
     */
    @AutoWriteTimestamp("updateTime")
    @Transactional(rollbackFor = {TransactionalException.class})
    public Boolean update(P record) {
        int result = mapper().updateSelective(bo().convert(record));
        if (result > 0) {
            if (enabledCache) {
                System.out.println("更新对象操作,清空缓存");
                LogUtils.info("更新对象操作,清空缓存");
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
    @Transactional(rollbackFor = {TransactionalException.class})
    public Boolean delete(K id) {
        int result = mapper().deleteByPrimaryKey(id);
        if (result > 0) {
            if(enabledCache){
                System.out.println("删除对象操作,清空缓存");
                LogUtils.info("删除对象操作,清空缓存");
                removeCache();
            }
            return true;
        }
        return false;
    }

    /**
     * <h4>根据 ID 查找 T对象</h4>
     * @param id 对象ID
     * @return 对象
     */
    public P findById(K id) {
        String key = keyPrefix + "_2919_" + id;
        if(enabledCache){
            Object obj = cache.get(key);
            if(null != obj){
                System.out.printf("从缓存获取到对象: key= %s;\n",key);
                LogUtils.info("从缓存获取到对象: key= ",key);
                return (P) obj;
            }
        }
        T record = mapper().selectByPrimaryKey(id);

        if (null != record) {
            P param = bo().compat(record);
            if (enabledCache) {
                System.out.printf("添加对象到缓存: key= %s;\n",key);
                LogUtils.info("添加对象到缓存: key= ",key);
                cache.put(key, param);
            }
            return param;
        }
        return null;
    }


    public List<P> list(P record, PageQuery page, boolean isLike) {
        return list(record, page, null, isLike);
    }


    public List<P> list(P record, PageQuery page, String key, boolean isLike) {

        String tKey = (null == key) ? keywords(record, page, isLike) : keywords(record, page, key, isLike);
        if (enabledCache){
            Object list = cache.get(tKey);
            if (null != list) {
                System.out.printf("从缓存获取到对象: key= %s;\n",tKey);
                LogUtils.info("从缓存获取到对象: key= ",tKey);
                return (List<P>)list;
            }
        }

        T tmp = bo().convert(record);

        List<T> result = (isLike) ? mapper().selectByLikeAndObj(tmp, page) : mapper().selectByObj(tmp, page);

        if (null != result) {
            List<P> pList = bo().adapter(result);
            if (enabledCache) {
                System.out.println("查找到数据添加到缓存; key=" + tKey);
                LogUtils.info("添加对象到缓存: key= ",tKey);
                cache.put(key,pList);
            }
            return pList;
        }

        return null;
    }


    public PageResult<?> page(P record, PageQuery page, boolean isLike) {
        return page(record, page, null, isLike);
    }


    public PageResult<?> page(P record, PageQuery page, String key, boolean isLike) {
        String tKey = (null == key) ? keywords(record, page, isLike) : keywords(record, page, key, isLike);
        if(enabledCache){
            Object list = cache.get(tKey);
            if (null != list) {
                System.out.printf("从缓存获取到对象: key= %s;\n",tKey);
                LogUtils.info("从缓存获取到对象: key= ",tKey);
                return (PageResult<?>)list;
            }
        }
        // adaptByList 模糊条件查找
        // adapt 条件查找
        PageResult<?> result = isLike ? PageResultAdapter.adaptByLike(mapper(), page, bo().convert(record), bo()) :
                PageResultAdapter.adapt(mapper(), page, bo().convert(record), bo());

        if (null != result && result.isSuccess && enabledCache) {
            System.out.printf("添加对象到缓存: key= %s;\n",tKey);
            LogUtils.info("添加对象到缓存: key= ",tKey);
            cache.put(key,result);
        }
        return result;
    }



    // ----------------------------------------- 总数|判断重复 ----------------------------------------- //
    /**
     * <h4>查找全部数量(全部或关键字模糊查找)</h4>
     * @param param 关键字, 当 param = null 时为全部查询
     * @param isLike true like 查找
     * @return 总条数
     */
    public int count(P param,boolean isLike) {
        String key = keywords(param, null, null, isLike);
        if (enabledCache){
            Object obj = cache.get(key);
            if (null != obj) {
                System.out.printf("从缓存获取到对象: key= %s;\n",key);
                LogUtils.info("从缓存获取到对象: key= ",key);
                return Integer.parseInt(obj.toString());
            }
        }
        int result = (isLike) ? mapper().countByLike(bo().convert(param)) : mapper().count(bo().convert(param));
        if (result > 0 && enabledCache) {
            System.out.printf("添加对象到缓存: key= %s;\n",key);
            LogUtils.info("添加对象到缓存: key= ",key);
            cache.put(key, result);
        }
        return result;
    }

    /**
     * <h4>判断是否重名</h4>
     * @param param 对象
     * @return true 表示 重名, 否则 取 false
     */
    public Boolean repeat(P param) {
        return mapper().repeat(bo().convert(param)) > 0;
    }

    // ----------------------------------------- 总数|判断重复 ----------------------------------------- //


    // ----------------------------------------- 需要实现的方法 ----------------------------------------- //
    /**
     * <h4>初始化对象的 BO 类</h4>
     * @return 对象BO类
     */
    public abstract BaseConvertBo<T, P> bo();

    /**
     * <h4>初始化对象的 BO 类</h4>
     * @return 对象BO类
     */
    public abstract IBaseMapper<K, T> mapper();
    // ----------------------------------------- 需要实现的方法 ----------------------------------------- //

    // ----------------------------------------- 构造函数 ----------------------------------------- //
    /**
     * <h4>无参构造</h4>
     */
    public RealizeService() {
        if (null == cache) {cache = LocalCache.getInstance();}
    }
    // ----------------------------------------- 构造函数 ----------------------------------------- //

    /** 缓存 key 前缀 推荐用 类的全名 */
    protected String keyPrefix = "";

    /**
     * <h4>获取 key 的后缀</h4>
     * @param param 对象
     * @return key的后缀字段
     */
    protected void keywords(Object param, StringBuffer sb){
        if(null != param){
            Field[] declaredFields = param.getClass().getDeclaredFields();
            for (Field field : declaredFields) {
                try {
                    field.setAccessible(true);
                    Object obj = field.get(param);
                    String _tn = field.getGenericType().getTypeName();

                    if (null == _tn || "".equals(_tn)) { continue;}

                    if(_tn.contains("List")){
                        if(null != obj && !"".equals(obj)){
                            List<?> list =( List<?>)obj;
                            if (null != list && list.size() > 0) {
                                for (int i = 0; i < list.size(); i++) {
                                    keywords(list.get(i),sb);
                                }
                            }
                        }
                    }else if(_tn.contains("cn.peyton")){
                        if(null != obj && !"".equals(obj)){
                            keywords(obj,sb);}
                    }else {
                        if(null != obj && !"".equals(obj)){sb.append(obj);}
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     * <h4>创建 缓存 key 值</h4>
     * @param param 对象
     * @param page 分页对象
     * @param isLike true like 查找
     * @return 字符串
     */
    protected String keywords(P param, PageQuery page, Boolean isLike){
        return keywords(param, page, null, isLike);
    }

    /**
     * <h4>创建 缓存 key 值</h4>
     *
     * @param param  对象
     * @param page   分页对象
     * @param key    缓存区分key{用在扩展查找}
     * @param isLike true like 查找
     * @return 字符串
     */
    protected String keywords(P param, PageQuery page, String key, Boolean isLike) {
        StringBuffer sb = new StringBuffer(keyPrefix);
        sb.append("_list_");
        if (null != page) {
            sb.append(page.getPageNo());
            sb.append("_");
            sb.append(page.getPageSize());
            sb.append("_");
            sb.append(page.getOrderColumnName());
            sb.append("_");
            sb.append(page.getOrderMode());
            sb.append(page.getEnablePaging() ? "_1" : "_0");
        }
        if (isLike) {
            sb.append("_like_");
        }
        keywords(param, sb);
        if (null != key) {
            sb.append("_" + key);
        }
        return sb.toString();
    }

    /**
     * <h4>创建 缓存 key 值</h4>
     * @param objs 多个字段拼接
     * @return 字符串
     */
    protected StringBuffer keywords(Object... objs){
        StringBuffer sb = new StringBuffer();
        for (Object o : objs) {
            sb.append("_" + o);
        }
        return sb;
    }


    // ----------------------------------------- 缓存 操作  ----------------------------------------- //
    /** 申明缓存 */
    protected LocalCache cache = null;
    /** 是否激活缓存 默认为 false */
    protected  boolean enabledCache = false;
    /**
     * <h4>移除全部缓存</h4>
     */
    protected void removeCache() {
        if (null != cache){cache.removeAll();}
    }
    // ----------------------------------------- 缓存 操作  ----------------------------------------- //

    // ----------------------------------------- 私有 方法  ----------------------------------------- //

    /**
     * <h4>保存缓存</h4>
     * @param key 缓存 key 值
     * @return 对象
     */
    protected Object getCache(String key) {
        if(enabledCache){
            Object list = cache.get(key);
            if (null != list) {
                System.out.printf("从缓存获取到对象: key= %s;\n",key);
                LogUtils.info("从缓存获取到对象: key= ",key);
                return list;
            }
        }
        return null;
    }

    /**
     * <h4>获取 缓存</h4>
     * @param key  缓存 key 值
     * @param obj 对象
     */
    protected void saveCache(String key, Object obj) {
        if (null != obj && enabledCache) {
            System.out.printf("添加对象到缓存: key= %s;\n", key);
            LogUtils.info("添加对象到缓存: key= ", key);
            cache.put(key, obj);
        }
    }

    /**
     * <h4>获取 缓存</h4>
     * @param key  缓存 key 值
     * @param obj 对象
     * @param isSuccess PageResult 默认为true,没找到数据可以设置为 false
     */
    protected void saveCache(String key, Object obj,boolean isSuccess) {
        if (null != obj && enabledCache&& isSuccess) {
            System.out.printf("添加对象到缓存: key= %s;\n", key);
            LogUtils.info("添加对象到缓存: key= ", key);
            cache.put(key, obj);
        }
    }

    /**
     * <h4>清空 缓存</h4>
     * @param tip 提示名
     */
    protected void clearCache(String tip) {
        if (enabledCache) {
            System.out.printf("%s 操作清空缓存;\n",tip);
            LogUtils.info(tip + "操作清空缓存");
            removeCache();
        }
    }
    // ----------------------------------------- 私有 方法  ----------------------------------------- //

}
