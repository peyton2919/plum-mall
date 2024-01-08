package cn.peyton.plum.mall.controller.base;

import cn.peyton.plum.core.inf.service.IBaseService;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.PageResult;
import cn.peyton.plum.core.utils.DateUtils;
import cn.peyton.plum.core.utils.HttpServletRequestUtils;
import cn.peyton.plum.core.utils.TokenUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

/**
 * <h4>controller 层 公共 增删改查 方法</h4>
 * <pre>
 *     方法：
 *     1. initProps 初始化对象
 *     2. saveToken 保存 Token
 *     3. handleToken 获取 Token
 *     4. verifyToken 验证 Token 是否合法
 *     5. baseHandleCreate 基础 添加 Param 对象
 *     6. baseHandleEdit 基础 编辑|更新 Param 对象
 *     7. baseHandleDelete 基础 删除 对象
 *     8. baseHandleList 基础模糊查找
 *     9. baseFindByAll 基础查找
 *     10. baseFindListBykeywordAll 基础模糊集合查找
 *     11. baseFindListByAll 基础集合查找
 * </pre>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.mall.controller.base.
 * @date 2023年11月11日 18:56
 * @version 1.0.0
 * </pre>
 */
@Controller
@CrossOrigin(origins = "*")
public class PcController<P> implements IBaseController,ITipMessages,IValidMessages {
    /**
     * Token 过期时间 1 天
     */
    protected long expireTime = 24 * 60 * 60 * 1000L;

    /**
     * <h4>初始化对象</h4>
     *
     * @param param
     */
    public void initProps(P param) { }

    /**
     * <h4>保存 Token</h4>
     *
     * @param record 要保存的对象
     * @return 对象转换成加密后的字符串
     */
    protected String saveToken(P record) {
        return new TokenUtils<P>().sign(KEY_TOKEN, record, expireTime);
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
            return new TokenUtils<P>().getObject(KEY_TOKEN, _tokenValue, record);
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

    /**
     * <h>赋值转换</h>
     *
     * @param record
     * @return
     */
    protected P assign(P record) {
        return record;
    }

    /**
     * <h4>基础 添加 Param 对象</h4>
     *
     * @param param   添加 对象
     * @param repeat  判断重复 对象
     * @param service 添加 对应服务层
     * @param tip     提示名称 (类的中文名称)
     * @param <K>     主键类型
     * @param <T>     POJO 对象
     * @param <P>     Param 对象
     * @return JSONResult {success:成功(返回含Id的对象),fail:失败}
     */
    public <K, T, P> JSONResult<?> baseHandleCreate(P param, P repeat, IBaseService<K, T, P> service, String... tip) {
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
        P res = service.add(param);
        if (null != res) {
            return JSONResult.success((len > 1) ? _msg.append(SUCCESS).toString() : (_msg + ADD + SUCCESS), res);
        }
        return JSONResult.fail((len > 1)  ? _msg.append(FAIL).toString() : (_msg + ADD + FAIL));
    }

    /**
     * <h4>基础 编辑|更新 Param 对象</h4>
     *
     * @param param   编辑|更新 对象
     * @param repeat  判断重复 对象
     * @param service 编辑|更新 对应服务层
     * @param tip     []提示名称 (类的中文名称) | tip = null 表示更新删除操作(更新字段)
     * @param <K>     主键类型
     * @param <T>     POJO 对象
     * @param <P>     Param 对象
     * @return JSONResult {success:成功,fail:失败}
     */
    public <K, T, P> JSONResult<?> baseHandleEdit(P param, P repeat, IBaseService<K, T, P> service, String... tip) {
        StringBuffer _msg = new StringBuffer();
        int len = 0;
        if (null != tip) {
            len = tip.length;
            for (String t : tip) {
                _msg.append(t);
            }
        }
        if (null != repeat) {
            if (service.repeat(repeat)) {
                return JSONResult.fail(REPEAT);
            }
        }
        if (service.update(param)) {
            return JSONResult.success((len > 1) ? _msg.append(SUCCESS).toString() : (_msg + UPDATE + SUCCESS));
        }
        return JSONResult.fail((len > 1) ? _msg.append(FAIL).toString() : (_msg + UPDATE + FAIL));
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
    public <K, T, P> JSONResult<?> baseHandleDelete(K id, IBaseService<K, T, P> service, String tip) {
        if (service.delete(id)) {
            return JSONResult.success(tip + DELETE + SUCCESS);
        }
        return JSONResult.fail(tip + DELETE + FAIL);
    }

    /**
     * <h4> 基础方法操作 {设置is_del = 0 镜像删除}</h4>
     *
     * @param res 更新完成后返回 成功与失败
     * @param tip 提示名称
     * @return JSONResult 对象
     */
    public JSONResult<?> baseHandle(Boolean res, String... tip) {
        StringBuffer sb = new StringBuffer();
        if (null != tip) {
            for (String t : tip) {
                sb.append(t);
            }
        }
        if (res) {
            return JSONResult.success(sb.append(SUCCESS).toString());
        }
        return JSONResult.fail(sb.append(FAIL).toString());
    }

    /**
     * <h4>基础 模糊 查找</h4>
     * <pre>分页查找 返回 PageResult<?> 集合</pre>
     * @param param   查找 对象
     * @param page    分页对象
     * @param service 查找 对象 对应服务层
     * @param expand 返回到前端 的扩展数据对象 可以为空
     * @param <K>     主键类型
     * @param <T>     POJO 对象
     * @param <P>     Param 对象
     * @return JSONResult {data:PageResult, success:成功,fail:失败}
     */
    public <K, T, P> JSONResult<?> baseHandleList(P param, PageQuery page, IBaseService<K, T, P> service, Object expand) {
        return baseHandleList(param, page, service, expand, null);
    }

    /**
     * <h4>基础 模糊 查找</h4>
     * <pre>分页查找 返回 PageResult<?> 集合</pre>
     * @param param   查找 对象
     * @param page    分页对象
     * @param service 查找 对象 对应服务层
     * @param expand 返回到前端 的扩展数据对象
     * @param key 缓存区分key{用在扩展查找}
     * @param <K>     主键类型
     * @param <T>     POJO 对象
     * @param <P>     Param 对象
     * @return JSONResult {data:PageResult, success:成功,fail:失败}
     */
    public <K, T, P> JSONResult<?> baseHandleList(P param, PageQuery page, IBaseService<K, T, P> service, Object expand, String key) {
        PageResult<?> result = service.likeByPage(param, page, key);
        if (result.isSuccess) {
            result.setExpand(expand);
            return JSONResult.success(DATA_LOADING_SUCCESS, result);
        }
        return JSONResult.fail(expand, NO_DATA, JSONResult.Props.NO_DATA);
    }

    /**
     * <h4>基础 模糊 查找</h4>
     * <pre>分页查找 返回 List<p> 集合</pre>
     * @param param   查找 对象
     * @param page    分页对象
     * @param service 查找 对象 对应服务层
     * @param <K>     主键类型
     * @param <T>     POJO 对象
     * @param <P>     Param 对象
     * @return JSONResult {data:List<P>, success:成功,fail:失败}
     */
    public <K, T, P> JSONResult<?> baseHandleList (P param, PageQuery page, IBaseService<K, T, P> service) {
        List<P> result = service.like(param, page);
        if (null != result) {
            return JSONResult.success(result);
        }
        return JSONResult.fail(JSONResult.Props.NO_DATA, NO_DATA);
    }

    /**
     * <h4>基础 查找</h4>
     * <pre>分页查找 返回 PageResult<?> 集合</pre>
     * @param param   查找 对象
     * @param page    分页对象
     * @param service 查找 对象 对应服务层
     * @param <K>     主键类型
     * @param <T>     POJO 对象
     * @param <P>     Param 对象
     * @return JSONResult {data:PageResult, success:成功,fail:失败}
     */
    public <K, T, P> JSONResult<?> baseHandleListPageReulst(P param, PageQuery page, IBaseService<K, T, P> service) {
        PageResult<?> result = service.listByPage(param, page);
        if (result.isSuccess) {
            return JSONResult.success(result);
        }
        return JSONResult.fail(JSONResult.Props.NO_DATA, NO_DATA);
    }

    /**
     * <h4>基础 查找</h4>
     * <pre>分页查找 返回 List<p> 集合</pre>
     * @param param   查找 对象
     * @param page    分页对象
     * @param service 查找 对象 对应服务层
     * @param <K>     主键类型
     * @param <T>     POJO 对象
     * @param <P>     Param 对象
     * @return JSONResult {data:List<P>, success:成功,fail:失败}
     */
    public <K, T, P> JSONResult<?> baseHandleListSimple(P param, PageQuery page, IBaseService<K, T, P> service) {
        List<P> result = service.list(param, page);
        if (null != result) {
            return JSONResult.success(result);
        }
        return JSONResult.fail(JSONResult.Props.NO_DATA, NO_DATA);
    }


    /**
     * <h4>图片完整路径 转成 简单路径{储放在数据库}</h4>
     * <pre>
     *     替换网站图片根路径
     * </pre>
     * @param path 完整图片地址
     * @return 转换成以 `/images...` 开头字符串
     */
    public String convertImgPath(String path) {
        return (null != path && (!"".equals(path))) ? path.replace(HttpServletRequestUtils.getSiteRootPath(), "") : "";
    }

    /**
     * <h>字符串转成时间格式</h>
     * <pre>
     *     用在时间之间的查找
     *     字符串格式为{"2022-01-01 12:12:00,2022-01-08 15:00:00"} 或 {"2022-01-01 12:12:00"}
     * </pre>
     * @param str
     * @return
     */
    public Integer[] convertStrToBetweenIntArray(String str) {
        Integer[] times = new Integer[2];
        if (null != str && !"".equals(str)) {
            String[] strs = str.split(",");
            try {
                for (int i = 0; i < strs.length; i++) {
                    if (i == 2) { break;}
                    times[i] = DateUtils.dateToTimestamp(strs[i]);
                }
            } catch (Exception e) {

            }
        }
        return times;
    }

    /**
     * <h4>字符串转数组</h4>
     *
     * @param operate 字符串
     * @return
     */
    public String[] convertStrToArr(String operate) {
        return operate.split(",");
    }

    /**
     * <h4>数组转字符串</h4>
     *
     * @param opearate 数组
     * @return
     */
    public String convertArrToStr(String[] opearate) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < opearate.length; i++) {
            sb.append(opearate[i]);
            if ((opearate.length - 1 != i)) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

}
