package cn.peyton.plum.mall.controller.base;

import cn.peyton.plum.core.inf.controller.CommonController;
import cn.peyton.plum.core.inf.controller.IBaseController;
import cn.peyton.plum.core.inf.controller.ITipMessages;
import cn.peyton.plum.core.inf.service.base.IRealizeService;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.ResponseStatus;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h4></h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.mall.controller.base.
 * @date 2024年01月19日 20:36
 * @version 1.0.0
 * </pre>
 */
@Controller
@CrossOrigin(origins = "*")
public class AndroidController<K,P> extends CommonController implements IBaseController, ITipMessages {



    /**
     * <h4>根据主键 获取对象</h4>
     * @param id 主键
     * @param service 对象服务层对象
     * @param expand 需要返回的扩展数据
     * @return 对象
     */
    public JSONResult<?> one(K id, IRealizeService<K, T,P> service, Object expand) {
        P result = service.findById(id);
        if (null != result) {
            return JSONResult.success(DATA_LOADING_SUCCESS, result, expand);
        }
        return JSONResult.success(NO_DATA, null, expand, JSONResult.Props.NO_DATA);
    }

    /**
     * <h4>根据对象 查找集合</h4>
     * @param param 对象
     * @param page 分页对象
     * @param service 服务层对象
     * @param expand 需要返回的扩展对象
     * @param key 区分的key值
     * @return
     */
    public JSONResult<?> list(P param, PageQuery page, IRealizeService<K, T, P> service, Object expand, String key) {
        List<P> result = service.list(param, page,key,true);
        if (null != result) {
            return JSONResult.success(DATA_LOADING_SUCCESS,result,expand);
        }
        return JSONResult.success(NO_DATA, new ArrayList<>(), expand, JSONResult.Props.NO_DATA);
    }

    /**
     * <h4>列表查找</h4>
     * @param list 返回对象集合
     * @param expand 需要返回的扩展对象
     * @return
     */
    public JSONResult<?> handleList(List<P> list, Object expand) {
        if (null != list && list.size() > 0) {
            return JSONResult.success(DATA_LOADING_SUCCESS,list,expand);
        }
        return JSONResult.success(NO_DATA, new ArrayList<>(), expand, JSONResult.Props.NO_DATA);
    }

    /**
     * <h4>单个 对象查找</h4>
     * @param param 返回对象
     * @param expand 需要返回的扩展对象
     * @return
     */
    public JSONResult<?> handelOne(P param, Object expand) {
        if (null != param) {
            return JSONResult.success(DATA_LOADING_SUCCESS, param, expand);
        }
        return JSONResult.success(NO_DATA, null, expand, JSONResult.Props.NO_DATA);
    }

    /**
     * <h4>多个 对象查找</h4>
     * @param map 返回对象
     * @param expand 需要返回的扩展对象
     * @return
     */
    public JSONResult<?> handelMulti(Map<String,?> map, Object expand) {
        if (null != map) {
            return JSONResult.success(DATA_LOADING_SUCCESS, map, expand);
        }
        return JSONResult.success(NO_DATA, new HashMap<>(), expand, JSONResult.Props.NO_DATA);
    }

    /**
     * <h4>新增|更新对象</h4>
     * @param param 添加|更新 对象
     * @param repeat 判断重复 对象
     * @param service 对应服务层
     * @param mode 操作方法 false 添加对象 true 更新对象
     * @param tip 提示名称 (类的中文名称)
     * @return
     */
    public JSONResult<?> handleObject(P param, P repeat, IRealizeService<K, T, P> service, Boolean mode,String... tip) {
        if (null != repeat) {
            if (service.repeat(repeat)) {
                return JSONResult.fail(REPEAT);
            }
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
        if(mode){
            bool = service.update(param);
            if(bool){
                res = param;
            }
        }else{
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
     * <h4>返回处理对象</h4>
     * @param bool true 成功 false 失败
     * @param expand 扩展对象
     * @param tip 提示信息集合
     * @return
     */
    public JSONResult<?> handle(boolean bool,Object expand,String... tip){
        StringBuffer _msg = new StringBuffer();
        int len = 0;
        if (null != tip) {
            len = tip.length;
            for (String t : tip) {
                _msg.append(t);
            }
        }
        if(bool){
            return JSONResult.success(_msg.append(SUCCESS).toString(),null,expand);
        }
        return JSONResult.fail(expand, _msg.append(FAIL).toString(), ResponseStatus.FAIL.getCode());
    }

    /**
     * <h4>删除 对象</h4>
     * @param id 对象 主键
     * @param service 编辑|更新 对应服务层
     * @param tip 提示名称 (类的中文名称)
     * @return
     */
    public JSONResult<?> handleDelete(K id, IRealizeService<K, T, P> service, String tip) {
        if (service.delete(id)) {
            return JSONResult.success(tip + DELETE + SUCCESS);
        }
        return JSONResult.fail(tip + DELETE + FAIL);
    }



}
