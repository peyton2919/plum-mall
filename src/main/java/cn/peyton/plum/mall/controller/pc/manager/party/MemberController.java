package cn.peyton.plum.mall.controller.pc.manager.party;

import cn.peyton.plum.core.anno.resolver.RequestMultiple;
import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.cipher.BaseCipher;
import cn.peyton.plum.core.inf.controller.IBasePCController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.mall.controller.base.PcController;
import cn.peyton.plum.mall.param.party.MemberLevelParam;
import cn.peyton.plum.mall.param.party.MemberParam;
import cn.peyton.plum.mall.service.party.MemberLevelService;
import cn.peyton.plum.mall.service.party.MemberService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h3> 会员 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
@RestController
@RequestMapping("/pc/member")
public class MemberController extends PcController<MemberParam>
        implements IBasePCController<Long, MemberParam> {
    /** MD5 加密 key */
    private final static String KEY_PASSWORD_ENCODER = "member_controller_password_202312112140";
    @Resource
    private MemberService memberService;
    @Resource
    private MemberLevelService memberLevelService;

    @Override
    public JSONResult<?> all(String keyword, Integer pageNo) {
        return null;
    }

    @Token
    @Valid
    @PostMapping("/manager/search")
    @Override
    public JSONResult<?> search(Query query) {
        MemberParam _param = new MemberParam();
        _param.setUsername(query.getKeyword());
        if (null != query.getIntValue()) {
            MemberLevelParam _mlp = new MemberLevelParam();
            _mlp.setId(query.getIntValue());
            _param.setMemberLevel(_mlp);
        }

        return baseFindBykeywordAll(_param, new PageQuery(query.getPageNo()), memberService,memberLevelService.select(0));
    }

    @Token
    @Valid
    @PostMapping("/manager/create")
    @Override
    public JSONResult<?> create(@RequestMultiple MemberParam record) {
        if (null == record.getMemberLevel().getId() || record.getMemberLevel().getId() <= 0) {
            return JSONResult.fail("请选择会员等级");
        }
        MemberParam _repeat = new MemberParam();
        _repeat.setUsername(record.getUsername());
        record.setPwd(BaseCipher.encoderMD5(record.getPwd(),KEY_PASSWORD_ENCODER));
        return baseCreate(record, _repeat, memberService, "会员");
    }

    @Token
    @Valid(ignore = {"pwd","confirmPwd","name"})
    @PostMapping("/manager/edit")
    @Override
    public JSONResult<?> edit(@RequestMultiple MemberParam record) {
        if (null == record.getMemberLevel().getId() || record.getMemberLevel().getId() <= 0) {
            return JSONResult.fail("请选择会员等级");
        }
        MemberParam _repeat = new MemberParam();
        _repeat.setId(record.getId());
        _repeat.setUsername(record.getUsername());
        return baseEdit(record, _repeat, memberService, "会员",UPDATE);
    }
    @Token
    @Valid
    @PostMapping("/manager/delete")
    @Override
    public JSONResult<?> delete(@NotBlank(message = "Id 不能为空;")
                                    @Min(value = 1,message = "最小为1")Long id) {
        if(memberService.editDelete(id)){
            return JSONResult.success("会员删除成功;");
        }
        return JSONResult.fail("会员删除失败;");
    }

    @Token
    @PostMapping("/manager/upstatus")
    @Valid
    public JSONResult<?> updateStatus(@NotBlank(message = "Id 不能为空;")
                                      @Min(value = 1,message = "最小为1")Long id,
                                      @NotBlank(message = "status 不能为空;")Integer status) {

        if(memberService.editStatus(id,status)){
            return JSONResult.success("会员状态更新成功;");
        }
        return JSONResult.fail("会员状态更新失败;");
    }
}
