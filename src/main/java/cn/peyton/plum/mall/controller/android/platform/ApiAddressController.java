package cn.peyton.plum.mall.controller.android.platform;

import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.inf.controller.RealizeController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.mall.param.party.MemberParam;
import cn.peyton.plum.mall.param.party.UserAddressParam;
import cn.peyton.plum.mall.service.party.UserAddressService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h4>用户地址 API controller</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.mall.controller.android.platform.
 * @date 2024年01月27日 14:09
 * @version 1.0.0
 * </pre>
 */
@RestController
@RequestMapping("/api/address")
public class ApiAddressController extends RealizeController {
    @Resource
    private UserAddressService userAddressService;

    @Valid
    @Token
    @PostMapping("/list")
    public JSONResult<?> list( @NotBlank(message = "页码 不能为空;") @Min(value = 1,message = "最小值为1")Integer pageNo) {
        MemberParam member = (MemberParam) getToken(new MemberParam());

        return list(userAddressService.findAndroidByShareId(member.getId(),member.getUserType(),new PageQuery(pageNo)), null);
    }

    @Token
    @Valid
    @PostMapping("/create")
    public JSONResult<?> create(UserAddressParam record) {
        MemberParam member = (MemberParam) getToken(new MemberParam());
        record.setShareId(member.getId());
        record.setShareType(member.getUserType());
        updateLastUsedTime(record);
        return handle(record, null,false, userAddressService, TIP_USER_ADDRESS,CREATE);
    }

    @Token
    @Valid
    @PostMapping("/edit")
    public JSONResult<?> edit(UserAddressParam record) {
        MemberParam member = (MemberParam) getToken(new MemberParam());
        record.setShareId(member.getId());
        record.setShareType(member.getUserType());
        updateLastUsedTime(record);
        return handle(record, null,true, userAddressService, TIP_USER_ADDRESS,UPDATE);
    }

    @Token
    @Valid
    @PostMapping("/delete")
    public JSONResult<?> delete(@NotBlank(message = "Id 不能为空;") @Min(value = 1,message = "最小值为1")Long id) {
        return delete(id,userAddressService,TIP_USER_ADDRESS);
    }


    private void updateLastUsedTime(UserAddressParam record) {
        if (null != record.getLastUsedTime() && !"".equals(record.getLastUsedTime())) {
            userAddressService.upLastUsedTimeNullByShareId(record.getShareId(),record.getShareType());
        }
    }
}
