package cn.peyton.plum.mall.controller.pc.manager.sys;

import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.inf.controller.IBasePCController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.mall.controller.base.PcController;
import cn.peyton.plum.mall.param.sys.SettingParam;
import cn.peyton.plum.mall.service.sys.SettingService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h3> 系统设置 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
@RestController
@RequestMapping("/pc/setting")
public class SettingController extends PcController<SettingParam>
        implements IBasePCController<Long, SettingParam> {

    @Resource
    private SettingService settingService;

    @Override
    public JSONResult<?> list(Query query) {
        return null;
    }

    @Override
    public JSONResult<?> create(SettingParam record) {
        return null;
    }
    @Token
    @Valid
    @PostMapping("/manager/edit")
    @Override
    public JSONResult<?> edit(SettingParam record) {
        return baseHandleEdit(record, null, settingService, "系统",UPDATE);
    }

    @Override
    public JSONResult<?> delete(Long id) {
        return null;
    }
    @Token
    @PostMapping("/manager/one")
    public JSONResult<?> one() {
        return JSONResult.success(settingService.findById(1));
    }


}
