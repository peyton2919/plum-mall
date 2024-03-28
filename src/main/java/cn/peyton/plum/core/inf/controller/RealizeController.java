package cn.peyton.plum.core.inf.controller;

import cn.peyton.plum.core.inf.service.base.IRealizeService;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.PageResult;
import cn.peyton.plum.core.page.ResponseStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <h4>controller 实现类</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.core.inf.controller.
 * @date 2024年02月28日 9:38
 * @version 1.0.0
 * </pre>
 */
@Controller
@CrossOrigin(origins = "*")
public abstract class RealizeController extends CommonController implements IBaseController, ITipMessages {

    /**
     * <h4>基础 添加|更新 Param 对象方法</h4>
     *
     * @param param   添加 对象
     * @param repeat  判断重复 对象
     * @param mode true 更新| false 新增
     * @param service 添加 对应服务层
     * @param tip     提示名称 (类的中文名称)
     * @param <K>     主键类型
     * @param <T>     POJO 对象
     * @param <P>     Param 对象
     * @return JSONResult {success:成功(返回含Id的对象),fail:失败}
     */
    public  <K, T, P> JSONResult<?> handle(P param, P repeat, boolean mode, IRealizeService<K, T, P> service, String... tip) {
        if (null != repeat) {
            if (service.repeat(repeat)) {return JSONResult.fail(REPEAT);}
        }

        StringBuffer _msg = new StringBuffer();
        int len = 0;
        if (null != tip) {
            len = tip.length;
            for (String t : tip) {
                _msg.append(t);
            }
        }

        P res = null;
        boolean bool = false;
        if(mode){ // 更新
            bool = service.update(param);
            if(bool){
                res = param;
            }
        }else{ // 新增
            res = service.insert(param);
            if (null != res) {
                bool = true;
            }
        }

        if (bool) {
            return JSONResult.success(_msg.append(SUCCESS).toString(), res);
        }
        return JSONResult.fail(_msg.append(FAIL).toString());
    }

    /**
     * <h4>单个 对象查找</h4>
     * @param param 返回对象
     * @param expand 需要返回的扩展对象
     * @return
     */
    public <P> JSONResult<?> handle(P param, Object expand) {
        if (null != param) {
            return JSONResult.success(DATA_LOADING_SUCCESS, param, expand);
        }
        return JSONResult.success(NO_DATA, null, expand, JSONResult.Props.NO_DATA);
    }

    /**
     * <h4> 基础方法操作</h4>
     * @param res 方法返回 成功与失败
     * @param tip 提示名称
     * @return JSONResult 对象
     */
    public JSONResult<?> handle(boolean res, String... tip) {

        return handle(res, null, tip);
    }

    /**
     * <h4>返回处理对象</h4>
     * @param res true 成功 false 失败
     * @param expand 扩展对象
     * @param tip 提示信息集合
     * @return
     */
    public JSONResult<?> handle(boolean res,Object expand,String... tip){
        StringBuffer _msg = new StringBuffer();
        int len = 0;
        if (null != tip) {
            len = tip.length;
            for (String t : tip) {
                _msg.append(t);
            }
        }
        if(res){
            return JSONResult.success(_msg.append(SUCCESS).toString(),null,expand);
        }
        return JSONResult.fail(expand, _msg.append(FAIL).toString(), ResponseStatus.FAIL.getCode());
    }


    /**
     * <h4>基础 删除 对象</h4>
     *
     * @param id      对象 主键
     * @param service 编辑|更新 对应服务层
     * @param tip     提示名称 (类的中文名称)
     * @param <K>     主键类型
     * @param <T>     POJO 对象
     * @param <P>     Param 对象
     * @return JSONResult {success:成功,fail:失败}
     */
    public <K, T, P> JSONResult<?> delete(K id, IRealizeService<K, T, P> service, String tip) {
        if (service.delete(id)) {
            return JSONResult.success(tip + DELETE + SUCCESS);
        }
        return JSONResult.fail(tip + DELETE + FAIL);
    }

    /**
     * <h4>列表查找</h4>
     * @param list 返回对象集合
     * @return
     */
    public <P> JSONResult<?> list(List<P> list) {
        if (null != list && list.size() > 0) {
            return JSONResult.success(DATA_LOADING_SUCCESS,list,null);
        }
        return JSONResult.success(NO_DATA, new ArrayList<>(), null, JSONResult.Props.NO_DATA);
    }

    /**
     * <h4>列表查找</h4>
     * @param list 返回对象集合
     * @param expand 需要返回的扩展对象
     * @return
     */
    public <P> JSONResult<?> list(List<P> list, Object expand) {
        if (null != list && list.size() > 0) {
            return JSONResult.success(DATA_LOADING_SUCCESS,list,expand);
        }
        return JSONResult.success(NO_DATA, new ArrayList<>(), expand, JSONResult.Props.NO_DATA);
    }

    /**
     * <h4>基础 模糊 查找</h4>
     * <pre>分页查找 返回 List<?> 集合</pre>
     * @param param   查找 对象
     * @param page    分页对象
     * @param service 查找 对象 对应服务层
     * @param isLike true like 查找
     * @param <K>     主键类型
     * @param <T>     POJO 对象
     * @param <P>     Param 对象
     * @return JSONResult {data: list集合, success:成功,fail:失败}
     */
    public <K, T, P> JSONResult<?> list(P param, PageQuery page, IRealizeService<K, T, P> service,boolean isLike) {

        return list(param, page, service, null, null, isLike);
    }

    /**
     * <h4>基础 [模糊] 查找</h4>
     * <pre>分页查找 返回 List<?> 集合</pre>
     * @param param   查找 对象
     * @param page    分页对象
     * @param service 查找 对象 对应服务层
     * @param expand 返回到前端 的扩展数据对象
     * @param isLike true like 查找
     * @param <K>     主键类型
     * @param <T>     POJO 对象
     * @param <P>     Param 对象
     * @return JSONResult {data: list集合, success:成功,fail:失败}
     */
    public <K, T, P> JSONResult<?> list(P param, PageQuery page, IRealizeService<K, T, P> service, Object expand,boolean isLike) {

        return list(param, page, service, null, null, isLike);
    }

    /**
     * <h4>基础 [模糊] 查找</h4>
     * <pre>分页查找 返回 List<?> 集合</pre>
     * @param param   查找 对象
     * @param page    分页对象
     * @param service 查找 对象 对应服务层
     * @param expand 返回到前端 的扩展数据对象
     * @param key 缓存区分key{用在扩展查找}
     * @param isLike true like 查找
     * @param <K>     主键类型
     * @param <T>     POJO 对象
     * @param <P>     Param 对象
     * @return JSONResult {data: list集合, success:成功,fail:失败}
     */
    public <K, T, P> JSONResult<?> list(P param, PageQuery page, IRealizeService<K, T, P> service, Object expand, String key, boolean isLike) {

        List<?> result = service.list(param, page, key, isLike);
        if (null != result) {
            return JSONResult.success(DATA_LOADING_SUCCESS, result, expand);
        }
        return JSONResult.success(NO_DATA, new ArrayList<>(), expand, JSONResult.Props.NO_DATA);
    }

    /**
     * <h4>基础 模糊 查找</h4>
     * @param result 返回 PageResult 对象
     * @return JSONResult {data:PageResult, success:成功,fail:失败}
     */
    public JSONResult<?> page(PageResult<?> result) {
        if (result.isSuccess) {
            return JSONResult.success(DATA_LOADING_SUCCESS, result, null);
        }
        return JSONResult.success(NO_DATA, new ArrayList<>(), null, JSONResult.Props.NO_DATA);
    }

    /**
     * <h4>基础 模糊 查找</h4>
     * @param result 返回 PageResult 对象
     * @param expand 返回到前端 的扩展数据对象
     * @return JSONResult {data:PageResult, success:成功,fail:失败}
     */
    public JSONResult<?> page(PageResult<?> result, Object expand) {
        if (result.isSuccess) {
            return JSONResult.success(DATA_LOADING_SUCCESS, result,expand);
        }
        return JSONResult.success(NO_DATA, new ArrayList<>(), expand, JSONResult.Props.NO_DATA);
    }

    /**
     * <h4>基础 模糊 查找</h4>
     * <pre>分页查找 返回 PageResult<?> 集合</pre>
     * @param param   查找 对象
     * @param page    分页对象
     * @param service 查找 对象 对应服务层
     * @param isLike true like 查找
     * @param <K>     主键类型
     * @param <T>     POJO 对象
     * @param <P>     Param 对象
     * @return JSONResult {data:PageResult, success:成功,fail:失败}
     */
    public <K, T, P> JSONResult<?> page(P param, PageQuery page, IRealizeService<K, T, P> service,boolean isLike) {
        return page(param, page, service, null, null, isLike);
    }

    /**
     * <h4>基础 [模糊] 查找</h4>
     * <pre>分页查找 返回 PageResult<?> 集合</pre>
     * @param param   查找 对象
     * @param page    分页对象
     * @param service 查找 对象 对应服务层
     * @param expand 返回到前端 的扩展数据对象
     * @param isLike true like 查找
     * @param <K>     主键类型
     * @param <T>     POJO 对象
     * @param <P>     Param 对象
     * @return JSONResult {data:PageResult, success:成功,fail:失败}
     */
    public <K, T, P> JSONResult<?> page(P param, PageQuery page, IRealizeService<K, T, P> service, Object expand,boolean isLike) {

        return page(param, page, service, null, null, isLike);
    }

    /**
     * <h4>基础 [模糊] 查找</h4>
     * <pre>分页查找 返回 PageResult<?> 集合</pre>
     * @param param   查找 对象
     * @param page    分页对象
     * @param service 查找 对象 对应服务层
     * @param expand 返回到前端 的扩展数据对象
     * @param key 缓存区分key{用在扩展查找}
     *
     * @param <K>     主键类型
     * @param <T>     POJO 对象
     * @param <P>     Param 对象
     * @return JSONResult {data:PageResult, success:成功,fail:失败}
     */
    public <K, T, P> JSONResult<?> page(P param, PageQuery page, IRealizeService<K, T, P> service, Object expand, String key, boolean isLike) {

        PageResult<?> result = service.page(param, page, key, isLike);
        if (result.isSuccess) {
            return JSONResult.success(DATA_LOADING_SUCCESS, result,expand);
        }
        return JSONResult.success(NO_DATA, new ArrayList<>(), expand, JSONResult.Props.NO_DATA);
    }


    /**
     * <h4>根据 ID 查找 对象</h4>
     * @param id 主键
     * @param service 查找 对象 对应服务层
     * @param expand 返回到前端 的扩展数据对象
     * @return 对象
     * @param <K> 主键类型
     * @param <T> POJO 对象
     * @param <P> Param 对象
     */
    public <K, T, P> JSONResult<?> one(K id, IRealizeService<K, T, P> service, Object expand) {
        P result = service.findById(id);
        if (null != result) {
            return JSONResult.success(DATA_LOADING_SUCCESS, result,expand);
        }
        return JSONResult.fail(expand, NO_DATA, JSONResult.Props.NO_DATA);
    }

    /**
     * <h4>返回查找对象</h4>
     * @param result 查找到对象
     * @param expand 返回到前端 的扩展数据对象
     * @return 对象
     * @param <P> Param 对象
     */
    public <P> JSONResult<?> one(P result, Object expand) {
        if (null != result) {
            return JSONResult.success(DATA_LOADING_SUCCESS, result,expand);
        }
        return JSONResult.fail(expand, NO_DATA, JSONResult.Props.NO_DATA);
    }

    /**
     * <h4>返回 map 集合对象</h4>
     * @param map 查找到数据添加到map
     * @return
     */
    public JSONResult<?> map(Map<String,Object> map) {
        if (null != map) {
            return JSONResult.success(map);
        }
        return JSONResult.fail(JSONResult.Props.NO_DATA, NO_DATA);
    }


    public <K, T, P> JSONResult<?> search() {
        return null;
    }



    //String REPEAT = "已有重复记录,请重新输入";
    //String DATA_LOADING_SUCCESS = "数据加载成功";
    //String NO_DATA = "没找到相关数据";
    //String SUCCESS = "成功";
    //String FAIL = "失败";
    //String UPDATE = "更新";
    //String CREATE = "新增";
    //String DELETE = "删除";
    //String ADD = "添加";
    //String EDIT = "编辑";
    //String MODIFY = "修改";
    //String DETAIL = "详情";
    //String BATCH = "批量";
    //String OPERATE = "操作";
    //String RESTORE = "恢复";
    //String SUBMIT = "提交";
    //String UPLOAD = "上传";
}
