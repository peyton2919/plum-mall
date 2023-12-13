package cn.peyton.plum.mall.controller.base;

import cn.peyton.plum.core.inf.service.IBaseService;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.PageResult;
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
 *     5. baseCreate 基础 添加 Param 对象
 *     6. baseEdit 基础 编辑|更新 Param 对象
 *     7. baseDelete 基础 删除 对象
 *     8. baseFindBykeywordAll 基础模糊查找
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
public class PcController<P> implements IBaseController{
    /** Token 过期时间 1 天 */
    protected long expireTime = 24 * 60 * 60 * 1000L;

    /**
     * <h4>初始化对象</h4>
     * @param param
     */
    public void initProps(P param) { }

    /**
     * <h4>保存 Token</h4>
     * @param record 要保存的对象
     * @return 对象转换成加密后的字符串
     */
    protected String saveToken(P record) {
        return new TokenUtils<P>().sign(KEY_TOKEN, record, expireTime);
    }

    /**
     * <h4>获取 Token</h4>
     * @param record 保存token内的对象
     * @return null 表示 非法 token
     * @param <P>
     */
    protected <P> P handleToken(P record){
        String _tokenValue = HttpServletRequestUtils.getRequest().getHeader(ACCESS_TOKEN);
        if (null != _tokenValue){
            return new TokenUtils<P>().getObject(KEY_TOKEN, _tokenValue, record);
        }
        return null;
    }

    /**
     * <h4>验证 Token 是否合法</h4>
     * @return 返回 true 表示 没被篡改 ; false 表示 被篡改过;
     * @param <P>
     */
    protected <P> Boolean verifyToken(){
        String _tokenValue = HttpServletRequestUtils.getRequest().getHeader(ACCESS_TOKEN);
        if (null != _tokenValue){
            return new TokenUtils<P>().verify(_tokenValue);
        }
        return false;
    }

    /**
     * <h4>基础 添加 Param 对象</h4>
     * @param param 添加 对象
     * @param repeat 判断重复 对象
     * @param service 添加 对应服务层
     * @param tip 提示名称 (类的中文名称)
     * @return JSONResult {success:成功(返回含Id的对象),fail:失败}
     * @param <K> 主键类型
     * @param <T> POJO 对象
     * @param <P> Param 对象
     */
    public <K,T,P> JSONResult<?> baseCreate(P param,P repeat, IBaseService<K,T,P> service,String tip) {
        if (null != repeat) {
            if (service.repeat(repeat)) {
                return JSONResult.fail("已重复,请重新输入");
            }
        }
        P res = service.add(param);
        if(null != res){
            return JSONResult.success((tip + "添加成功;"), res);
        }
        return JSONResult.fail(tip + "添加失败;");
    }

    /**
     * <h4>基础 编辑|更新 Param 对象</h4>
     *
     * @param param   编辑|更新 对象
     * @param repeat 判断重复 对象
     * @param service 编辑|更新 对应服务层
     * @param tip     []提示名称 (类的中文名称) | tip = null 表示更新删除操作(更新字段)
     * @param <K>     主键类型
     * @param <T>     POJO 对象
     * @param <P>     Param 对象
     * @return JSONResult {success:成功,fail:失败}
     */
    public <K, T, P> JSONResult<?> baseEdit(P param, P repeat, IBaseService<K, T, P> service, String ...tip) {
        StringBuffer _msg = new StringBuffer();
        if (null != tip && tip.length > 0) {
            for (int i = 0; i < tip.length; i++) {
                _msg.append(tip[i]);
            }
        }
        if (null != repeat) {
            if (service.repeat(repeat)) {
                return JSONResult.fail("已重复,请重新输入");
            }
        }
        if (service.update(param)) {
            return JSONResult.success((tip != null) ? _msg.append(SUCCESS).toString() : null);
        }
        return JSONResult.fail((null != tip)?_msg.append(FAIL).toString():null);
    }

    /**
     * <h4>基础 删除 对象</h4>
     * @param id 对象 主键
     * @param service 编辑|更新 对应服务层
     * @param tip 提示名称 (类的中文名称)
     * @return JSONResult {success:成功,fail:失败}
     * @param <K> 主键类型
     * @param <T> POJO 对象
     * @param <P> Param 对象
     */
    public <K,T,P> JSONResult<?> baseDelete(K id, IBaseService<K,T,P> service,String tip) {
        if (service.delete(id)) {
            return JSONResult.success(tip + "删除成功;");
        }
        return JSONResult.fail(tip + "删除失败;");
    }

    /**
     * <h4>基础模糊查找</h4>
     * @param param 查找 对象
     * @param page 分页对象
     * @param service 查找 对象 对应服务层
     * @return JSONResult {data:PageResult, success:成功,fail:失败}
     * @param <K> 主键类型
     * @param <T> POJO 对象
     * @param <P> Param 对象
     */
    public <K,T,P> JSONResult<?> baseFindBykeywordAll(P param, PageQuery page, IBaseService<K,T,P> service,Object expand) {
        PageResult<?> result = service.findAllByLike(param, page);
        if (result.isSuccess){
            result.setExpand(expand);
            return JSONResult.success("数据加载成功;",result);
        }
        return JSONResult.fail(expand, NO_DATA, JSONResult.Props.NO_DATA);
    }


    /**
     * <h4>基础查找</h4>
     * @param param 查找 对象
     * @param page 分页对象
     * @param service 查找 对象 对应服务层
     * @return JSONResult {data:PageResult, success:成功,fail:失败}
     * @param <K> 主键类型
     * @param <T> POJO 对象
     * @param <P> Param 对象
     */
    public <K,T,P> JSONResult<?> baseFindByAll(P param, PageQuery page, IBaseService<K,T,P> service) {
        PageResult<?> result = service.findAll(param, page);
        if (result.isSuccess){
            return JSONResult.success(result);
        }
        return JSONResult.fail(JSONResult.Props.NO_DATA,NO_DATA);
    }

    /**
     * <h4>基础模糊集合查找</h4>
     * @param param 查找 对象
     * @param page 分页对象
     * @param service 查找 对象 对应服务层
     * @return JSONResult {data:List<P>, success:成功,fail:失败}
     * @param <K> 主键类型
     * @param <T> POJO 对象
     * @param <P> Param 对象
     */
    public <K,T,P> JSONResult<?> baseFindListBykeywordAll(P param, PageQuery page, IBaseService<K,T,P> service) {
        List<P> result = service.findByLikeAndObj(param,page);
        if (null != result) {
            return JSONResult.success(result);
        }
        return JSONResult.fail(JSONResult.Props.NO_DATA,NO_DATA);
    }

    /**
     * <h4>基础集合查找</h4>
     * @param param 查找 对象
     * @param page 分页对象
     * @param service 查找 对象 对应服务层
     * @return JSONResult {data:List<P>, success:成功,fail:失败}
     * @param <K> 主键类型
     * @param <T> POJO 对象
     * @param <P> Param 对象
     */
    public <K,T,P> JSONResult<?> baseFindListByAll(P param, PageQuery page, IBaseService<K,T,P> service) {
        List<P> result = service.findByObj(param,page);
        if (null != result){
            return JSONResult.success(result);
        }
        return JSONResult.fail(JSONResult.Props.NO_DATA,NO_DATA);
    }

    /**
     * <h4>字符串转数组</h4>
     * @param operate 字符串
     * @return
     */
    public String[] toArr(String operate) {
        return operate.split(",");
    }

    /**
     * <h4>数组转字符串</h4>
     * @param opearate 数组
     * @return
     */
    public String toStr(String[] opearate) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < opearate.length; i++) {
            sb.append(opearate[i]);
            if ((opearate.length - 1 != i)) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    /** 没找到数据... */
    protected String NO_DATA = "没找到数据...";

    protected String SUCCESS = "成功";
    protected String FAIL = "失败";
    protected  String UPDATE ="更新";
    protected String CREATE = "创建";
    protected String DELETE = "删除";
    protected String ADD = "增加";
    protected String EDIT = "编辑";
    protected String MODIFY = "修改";
}
