package cn.peyton.plum.mall.controller.pc.manager.sys;

import cn.peyton.plum.core.inf.controller.IBasePCController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.mall.controller.base.PcController;
import cn.peyton.plum.mall.param.sys.AreaAllParam;
import cn.peyton.plum.mall.service.sys.AreaAllService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h3> 城市 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/pc/areaall")
public class AreaAllController extends PcController<AreaAllParam> implements IBasePCController<Integer,AreaAllParam> {

    @Resource
    private AreaAllService areaAllService;

    @Override
    public JSONResult<?> all(String keyword, Integer pageNo) {
        return null;
    }

    @Override
    public JSONResult<?> search(Query query) {
        return null;
    }

    @Override
    public JSONResult<?> create(AreaAllParam record) {
        return null;
    }

    @Override
    public JSONResult<?> edit(AreaAllParam record) {
        return null;
    }

    @Override
    public JSONResult<?> delete(Integer id) {
        return null;
    }
}
