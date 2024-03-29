package cn.peyton.plum.mall.controller.pc.manager.pub;

import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.inf.controller.IController;
import cn.peyton.plum.core.inf.controller.RealizeController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.mall.param.pub.NoticeCategoryParam;
import cn.peyton.plum.mall.service.pub.NoticeCategoryService;
import cn.peyton.plum.mall.service.pub.NoticeService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <h3> 公告类型 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
@RestController
@RequestMapping("/pc/noticecate")
public class NoticeCategoryController extends RealizeController
        implements IController<Integer, NoticeCategoryParam> {

    @Resource
    private NoticeCategoryService noticeCategoryService;
    @Resource
    private NoticeService noticeService;

    @Token
    @PostMapping("/manager/select")
    public JSONResult<?> findBySelect(){
        List<NoticeCategoryParam> res = noticeCategoryService.findBySelect();
        if (null != res && res.size() > 0) {
            return JSONResult.success(res);
        }
        return page(new NoticeCategoryParam(),
                new PageQuery(1,ORDER_BY_FILED,false),noticeCategoryService,true);
    }

    @Token
    @Valid
    @PostMapping("/manager/search")
    @Override
    public JSONResult<?> list(Query query) {
        NoticeCategoryParam _record = new NoticeCategoryParam();
        _record.setName(query.getKeyword());
        return page(_record,new PageQuery(query.getPageNo()),noticeCategoryService,true);
    }

    @Token
    @Valid
    @PostMapping("/manager/create")
    @Override
    public JSONResult<?> create(NoticeCategoryParam param) {
        NoticeCategoryParam _repeat = new NoticeCategoryParam();
        _repeat.setName(param.getName());
        return handle(param, _repeat,false, noticeCategoryService, TIP_NOTICE_CATEGORY,CREATE);
    }

    @Token
    @Valid
    @PostMapping("/manager/edit")
    public JSONResult<?> edit(NoticeCategoryParam param) {
        NoticeCategoryParam _repeat = new NoticeCategoryParam();
        _repeat.setName(param.getName());
        _repeat.setId(param.getId());
        return handle(param, _repeat, true, noticeCategoryService, TIP_NOTICE_CATEGORY, UPDATE);
    }

    @Token
    @PostMapping("/manager/delete")
    @Valid
    public JSONResult<?> delete(@Min(value = 1,message = "最小值为1") Integer id) {
        if (noticeService.isNoticeCategory(id)){
            return JSONResult.fail(JOIN_DATA + DELETE);
        }
        return delete(id, noticeCategoryService, TIP_NOTICE_CATEGORY);
    }

}
