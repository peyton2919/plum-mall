package cn.peyton.plum.mall.controller.base;

import cn.peyton.plum.core.inf.service.IBaseService;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.utils.HttpServletRequestUtils;
import cn.peyton.plum.core.utils.TokenUtils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

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
public class AndroidController<K,P> extends CommonController implements IBaseController,ITipMessages {
    /**
     * Token 过期时间 1 天
     */
    protected long expireTime = 24 * 60 * 60 * 1000L;


    /**
     * <h4>根据主键 获取对象</h4>
     * @param id 主键
     * @param service 对象服务层对象
     * @param expand 需要返回的扩展数据
     * @return 对象
     */
    public JSONResult<?> one(K id, IBaseService<K, T,P> service, Object expand) {
        P result = service.findById(id);
        if (null != result) {
            return JSONResult.success(DATA_LOADING_SUCCESS, result, expand);
        }
        return JSONResult.fail(expand, NO_DATA, JSONResult.Props.NO_DATA);
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
    public JSONResult<?> list(P param, PageQuery page, IBaseService<K, T, P> service, Object expand, String key) {
        List<P> result = service.like(param, page,key);
        if (null != result) {
            return JSONResult.success(DATA_LOADING_SUCCESS,result,expand);
        }
        return JSONResult.fail(expand, NO_DATA, JSONResult.Props.NO_DATA);
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
        return JSONResult.fail(expand, NO_DATA, JSONResult.Props.NO_DATA);
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
        return JSONResult.fail(expand, NO_DATA, JSONResult.Props.NO_DATA);
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
        return JSONResult.fail(expand, NO_DATA, JSONResult.Props.NO_DATA);
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
    public JSONResult<?> handleObject(P param, P repeat, IBaseService<K, T, P> service, Boolean mode,String... tip) {
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
        }else{
            res = service.add(param);
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
     * <h4>删除 对象</h4>
     * @param id 对象 主键
     * @param service 编辑|更新 对应服务层
     * @param tip 提示名称 (类的中文名称)
     * @return
     */
    public JSONResult<?> handleDelete(K id, IBaseService<K, T, P> service, String tip) {
        if (service.delete(id)) {
            return JSONResult.success(tip + DELETE + SUCCESS);
        }
        return JSONResult.fail(tip + DELETE + FAIL);
    }

    /**
     * <h4>保存 Token</h4>
     *
     * @param record 要保存的对象
     * @return 对象转换成加密后的字符串
     */
    protected String saveToken(P record) {
        return new TokenUtils<P>().sign(KEY_TOKEN_ANDROID, record, expireTime);
    }

    /**
     * <h4>获取 Token</h4>
     *
     * @param record 保存token内的对象
     * @param <P>
     * @return null 表示 非法 token
     */
    protected <P> P handleToken(P record) {
        String _tokenValue = HttpServletRequestUtils.getRequest().getHeader(ACCESS_TOKEN);
        if (null != _tokenValue) {
            return new TokenUtils<P>().getObject(KEY_TOKEN_ANDROID, _tokenValue, record);
        }
        return null;
    }

    /**
     * <h4>验证 Token 是否合法</h4>
     *
     * @param <P>
     * @return 返回 true 表示 没被篡改 ; false 表示 被篡改过;
     */
    protected <P> Boolean verifyToken() {
        String _tokenValue = HttpServletRequestUtils.getRequest().getHeader(ACCESS_TOKEN);
        if (null != _tokenValue) {
            return new TokenUtils<P>().verify(_tokenValue);
        }
        return false;
    }

    protected String getSiteRootPath(String simplePath) {
        return HttpServletRequestUtils.getSiteRootPath() + simplePath;
    }

    /**
     * <h>赋值转换</h>
     *
     * @param record
     * @return
     */
    protected P assign(P record) {
        return record;
    }

}
