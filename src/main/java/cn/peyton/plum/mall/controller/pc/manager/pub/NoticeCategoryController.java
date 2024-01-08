package cn.peyton.plum.mall.controller.pc.manager.pub;

import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.inf.controller.IBasePCController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.mall.controller.base.PcController;
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
public class NoticeCategoryController extends PcController<NoticeCategoryParam>
        implements IBasePCController<Integer, NoticeCategoryParam> {
    String TIP_NAME = "公告分类";
    @Resource
    private NoticeCategoryService noticeCategoryService;
    @Resource
    private NoticeService noticeService;

    @Token
    @Valid
    @PostMapping("/manager/all")
    public JSONResult<?> all(String keyword,  @NotBlank(message = "pageNo 不能为空;")
            @Min(message = "当前页码要大于0的数！")Integer pageNo) {

        return baseHandleList(new NoticeCategoryParam(),new PageQuery(pageNo,"seq"),noticeCategoryService,null);
    }
    @Token
    @PostMapping("/manager/select")
    public JSONResult<?> findBySelect(){
        List<NoticeCategoryParam> res = noticeCategoryService.findBySelect();
        if (null != res && res.size() > 0) {
            return JSONResult.success(res);
        }
        return baseHandleList(new NoticeCategoryParam(),
                new PageQuery(1,"seq",false),noticeCategoryService,null);
    }

    @Token
    @Valid
    @PostMapping("/manager/keywordall")
    public JSONResult<?> findBykeywordAll(String keyword, @Min(message = "当前页码要大于0的数！")Integer pageNo) {
        NoticeCategoryParam _record = new NoticeCategoryParam();
        _record.setName(keyword);
        return baseHandleList(_record,new PageQuery(pageNo,"seq"),noticeCategoryService,null);
    }


    @Override
    public JSONResult<?> list(Query query) {
        return null;
    }

    @Token
    @Valid
    @PostMapping("/manager/create")
    @Override
    public JSONResult<?> create(NoticeCategoryParam param) {
        NoticeCategoryParam _repeat = new NoticeCategoryParam();
        _repeat.setName(param.getName());
        return baseHandleCreate(param, _repeat, noticeCategoryService, TIP_NAME);
    }

    @Token
    @Valid
    @PostMapping("/manager/edit")
    public JSONResult<?> edit(NoticeCategoryParam param) {
        NoticeCategoryParam _repeat = new NoticeCategoryParam();
        _repeat.setName(param.getName());
        _repeat.setId(param.getId());
        return baseHandleEdit(param, _repeat, noticeCategoryService, TIP_NAME);
    }

    @Token
    @PostMapping("/manager/delete")
    @Valid
    public JSONResult<?> delete(@Min(value = 1,message = "最小值为1") Integer id) {
        if (noticeService.joinGroup(id)){
            return JSONResult.fail("与公告信息有关联,不能直接删除。");
        }
        return baseHandleDelete(id, noticeCategoryService, TIP_NAME);
    }

}
