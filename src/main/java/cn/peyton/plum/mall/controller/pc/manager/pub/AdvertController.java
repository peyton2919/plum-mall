package cn.peyton.plum.mall.controller.pc.manager.pub;

import cn.peyton.plum.core.inf.controller.IBasePCController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.mall.controller.base.PcController;
import cn.peyton.plum.mall.param.pub.AdvertParam;
import cn.peyton.plum.mall.service.pub.AdvertService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h3> 广告信息 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
@RestController
@RequestMapping("/pc/advert")
public class AdvertController extends PcController<AdvertParam> implements IBasePCController<Long,AdvertParam> {

    @Resource
    private AdvertService advertService;


    @Override
    public JSONResult<?> list(Query query) {
        return null;
    }

    @Override
    public JSONResult<?> create(AdvertParam record) {
        return null;
    }

    @Override
    public JSONResult<?> edit(AdvertParam record) {
        return null;
    }

    @Override
    public JSONResult<?> delete(Long id) {
        return null;
    }
}
