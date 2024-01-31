package cn.peyton.plum.mall.controller.pc.manager.pub;

import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.inf.controller.IBasePCController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.core.validator.constraints.Size;
import cn.peyton.plum.mall.controller.base.PcController;
import cn.peyton.plum.mall.param.pub.NoticeParam;
import cn.peyton.plum.mall.param.sys.UserParam;
import cn.peyton.plum.mall.service.pub.NoticeCategoryService;
import cn.peyton.plum.mall.service.pub.NoticeService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h3> 公告 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
@RestController
@RequestMapping("/pc/notice")
public class NoticeController extends PcController<NoticeParam>
        implements IBasePCController<Long,NoticeParam> {

    @Resource
    private NoticeService noticeService;
    @Resource
    private NoticeCategoryService noticeCategoryService;

    @Token
    @Valid
    @PostMapping("/manager/all")
    public JSONResult<?> all(String keyword, @Min(message = "当前页码要大于0的数！")Integer pageNo) {
        NoticeParam _param = new NoticeParam();
        _param.setTitle(keyword);

        return baseHandleList(_param, new PageQuery(pageNo, ORDER_BY_FILED),
                noticeService, null);
    }

    @Token
    @Valid
    @Override
    @PostMapping("/manager/search")
    public JSONResult<?> list(Query query) {
        if (null == query || null == query.getIntValue() || query.getIntValue() < 1) {
            return JSONResult.fail(ERROR);
        }
        NoticeParam _param = new NoticeParam();
        _param.setTitle(query.getKeyword());
        _param.setCategoryId(query.getIntValue());

        return baseHandleList(_param, new PageQuery(query.getPageNo(), ORDER_BY_FILED),
                noticeService, null);
    }

    @Token
    @PostMapping("/manager/findkeyword")
    public JSONResult<?> findBykeyword(String keyword,
                                       @NotBlank(message = "页码 不能为空;") @Min(value = 1,message = "最小值为1")Integer pageNo) {
        NoticeParam _param = new NoticeParam();
        _param.setTitle(keyword);

        // 其他处理判断
        return baseHandleList(_param, new PageQuery(pageNo), noticeService,null);
    }

    @Token
    @Valid
    @PostMapping("/manager/create")
    @Override
    public JSONResult<?> create(NoticeParam param) {
        UserParam _user = handleToken(new UserParam());
        param.setCreateId(_user.getId());
        param.setCreateType(_user.getUserType());
        NoticeParam _repeat = new NoticeParam();
        _repeat.setTitle(param.getTitle());
        return baseHandleCreate(param, _repeat, noticeService, TIP_NOTICE);
    }

    @Token
    @Valid
    @PostMapping("/manager/edit")
    @Override
    public JSONResult<?> edit(NoticeParam param) {
       initProps(param);
        NoticeParam _repeat = new NoticeParam();
        _repeat.setId(param.getId());
       _repeat.setTitle(param.getTitle());
        return baseHandleEdit(param, _repeat, noticeService, TIP_NOTICE);
    }

    @Token
    @PostMapping("/manager/delete")
    @Valid
    @Override
    public JSONResult<?> delete(@Min(value = 1,message = "最小值为1") Long id) {
        NoticeParam _param = new NoticeParam();
        _param.setId(id);
        _param.setIsDel(IS_DEL_0);
        return baseHandleEdit(_param, null, noticeService, TIP_NOTICE + DELETE);
    }

    /**
     *
     * @param keyword
     * @param type 类型 0 分类 1 标题 2 内容
     * @param pageNo
     * @return
     */
    @Token
    @Valid
    @PostMapping("/manager/keywordall")
    public JSONResult<?> findByKeyword(String keyword,
                                       @Size(min=0,max = 2) Integer type,
                                       @Min(message = "当前页码要大于0的数！")Integer pageNo) {
        PageQuery _page = new PageQuery(pageNo,"seq");
        NoticeParam _param = null;
        if(null == keyword){
            _param = new NoticeParam();
        }
        if (type == 0){
            _param = new NoticeParam();
            _param.setCategoryId(Integer.parseInt(keyword));
            return baseHandleListPageReulst(_param, _page, noticeService);
        }else{
            if(type == 1){
                _param = new NoticeParam();
                _param.setTitle(keyword);
            }else if(type == 2){
                _param = new NoticeParam();
                _param.setContent(keyword);
            }
        }
        return baseHandleList(_param, _page, noticeService,null);
    }


    @Override
    public void initProps(NoticeParam param) {
        param.setCreateType(null);
        param.setCreateId(null);
        param.setIsDel(USABLE);
    }
}
