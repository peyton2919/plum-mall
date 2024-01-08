package cn.peyton.plum.mall.controller.pc.manager.party;

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
import cn.peyton.plum.mall.param.party.MemberLevelParam;
import cn.peyton.plum.mall.service.party.MemberLevelService;
import cn.peyton.plum.mall.service.party.MemberService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h3> 会员等级 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
@RestController
@RequestMapping("/pc/memberlevel")
public class MemberLevelController extends PcController<MemberLevelParam>
        implements IBasePCController<Integer, MemberLevelParam> {

    @Resource
    private MemberLevelService memberLevelService;
    @Resource
    private MemberService memberService;

    // keyword
    @Token
    @Valid
    @PostMapping("/manager/search")
    @Override
    public JSONResult<?> list(Query query) {

        return baseHandleList(new MemberLevelParam(), new PageQuery(query.getPageNo(), ORDER_BY_FILED), memberLevelService, null);
    }

    @Token
    @Valid
    @PostMapping("/manager/create")
    @Override
    public JSONResult<?> create(MemberLevelParam record) {
        MemberLevelParam _repeat = new MemberLevelParam();
        _repeat.setName(record.getName());
        return baseHandleCreate(record, _repeat, memberLevelService, TIP_MEMBER_LEVEL);
    }

    @Token
    @Valid
    @PostMapping("/manager/edit")
    @Override
    public JSONResult<?> edit(MemberLevelParam record) {
        MemberLevelParam _repeat = new MemberLevelParam();
        _repeat.setId(record.getId());
        _repeat.setName(record.getName());
        return baseHandleEdit(record, _repeat, memberLevelService, TIP_MEMBER_LEVEL,UPDATE);
    }

    @Token
    @Valid
    @PostMapping("/manager/delete")
    @Override
    public JSONResult<?> delete(@NotBlank(message = "Id 不能为空;")
                                    @Min(value = 1,message = "最小为1")Integer id) {
        // 判断
        if (memberService.isMemberLevel(id)) {
            return JSONResult.fail("等级关联会员信息,无法删除;如需要删除先清除相应的数据");
        }
        return baseHandleDelete(id, memberLevelService, TIP_MEMBER_LEVEL);
    }

    @Token
    @Valid
    @PostMapping("/manager/upstatus")
    public JSONResult<?> updateStatus(@NotBlank(message = "Id 不能为空;")
                                      @Min(value = 1,message = "最小为1")Integer id,
                                      @NotBlank(message = "status 不能为空;") @Size(min = 0,max = 1) Integer status) {
        if (memberService.isMemberLevel(id)) {
            return JSONResult.fail("等级关联会员信息,无法禁用;如需要禁用先清除相应的数据");
        }
        MemberLevelParam _param = new MemberLevelParam();
        _param.setId(id);
        _param.setStatus(status);
        return baseHandleEdit(_param,null,memberLevelService,"会员等级状态更新");
    }

    // 下拉框
    @Token
    @Valid
    @PostMapping("/manager/down")
    public JSONResult<?> down(){
        return JSONResult.success(memberLevelService.findByDownList());
    }
}
