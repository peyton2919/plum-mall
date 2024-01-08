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
import cn.peyton.plum.mall.param.party.UserAddressParam;
import cn.peyton.plum.mall.service.party.UserAddressService;
import com.alibaba.fastjson.JSON;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h3> 用户地址{用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)} Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
@RestController
@RequestMapping("/pc/address")
public class UserAddressController extends PcController<UserAddressParam>
        implements IBasePCController<Long, UserAddressParam> {

    @Resource
    private UserAddressService userAddressService;

    // 数据打包成 json 格式 null province city address name phone
    @Token
    @Valid
    @PostMapping("/manager/search")
    @Override
    public JSONResult<?> list(Query query) {
        UserAddressParam _param = new UserAddressParam();
        if (null != query.getComplexValue()) {
            _param = JSON.parseObject(query.getComplexValue(), UserAddressParam.class);
        }
        return baseHandleList(_param, new PageQuery(query.getPageNo()), userAddressService,null);
    }

    @Token
    @Valid
    @PostMapping("/manager/create")
    @Override
    public JSONResult<?> create(UserAddressParam record) {

        return baseHandleCreate(record, assign(record), userAddressService, TIP_USER_ADDRESS);
    }

    @Token
    @Valid
    @PostMapping("/manager/edit")
    @Override
    public JSONResult<?> edit(UserAddressParam record) {

        return baseHandleEdit(record, assign(record), userAddressService, TIP_USER_ADDRESS,UPDATE);
    }

    @Token
    @Valid
    @PostMapping("/manager/delete")
    @Override
    public JSONResult<?> delete(@NotBlank(message = "Id 不能为空;") @Min(value = 1,message = "最小为1")Long id) {

        return baseHandleDelete(id,userAddressService, TIP_USER_ADDRESS);
    }

    @Token
    @Valid
    @PostMapping("/manager/single")
    public JSONResult<?> singleList(@NotBlank(message = "Id 不能为空;") @Min(value = 1,message = "最小为1")Long shareId,
            @NotBlank(message = "类型不能为空;") @Size(min=0,max = 5) Integer shareType){

        return JSONResult.success(userAddressService.findByShareId(shareId, shareType));
    }

    // 赋值
    @Override
    protected UserAddressParam assign(UserAddressParam record) {
        UserAddressParam _repeat = new UserAddressParam();
        _repeat.setShareId(record.getShareId());
        _repeat.setShareType(record.getShareType());
        _repeat.setProvince(record.getProvince());
        _repeat.setCity(record.getCity());
        _repeat.setDistrict(record.getDistrict());
        _repeat.setAddress(record.getAddress());
        _repeat.setName(record.getName());
        if (null != record.getId() && record.getId() > 0) {
            _repeat.setId(record.getId());
        }
        return _repeat;
    }
}
