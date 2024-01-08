package cn.peyton.plum.mall.controller.pc.manager.party;

import cn.peyton.plum.core.inf.controller.IBasePCController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.mall.controller.base.PcController;
import cn.peyton.plum.mall.param.party.ShareBindParam;
import cn.peyton.plum.mall.service.party.ShareBindService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h3> 第三方用户绑定信息{用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)} Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
@RestController
@RequestMapping("/pc/sharebind")
public class ShareBindController extends PcController<ShareBindParam>
        implements IBasePCController<Long, ShareBindParam> {

    @Resource
    private ShareBindService shareBindService;

    @Override
    public JSONResult<?> list(Query query) {
        return null;
    }

    @Override
    public JSONResult<?> create(ShareBindParam record) {
        return null;
    }

    @Override
    public JSONResult<?> edit(ShareBindParam record) {
        return null;
    }

    @Override
    public JSONResult<?> delete(Long id) {
        return null;
    }
}
