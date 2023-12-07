package cn.peyton.plum.mall.controller.pc.manager.join;

import cn.peyton.plum.core.inf.controller.IBasePCController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.mall.controller.base.PcController;
import cn.peyton.plum.mall.param.join.BrandParam;
import cn.peyton.plum.mall.service.join.BrandService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h3> 品牌 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
@RestController
@RequestMapping("/pc/brand")
public class BrandController extends PcController<BrandParam>
    implements IBasePCController<Long, BrandParam> {

    @Resource
    private BrandService brandService;

    @Override
    public JSONResult<?> all(String keyword, Integer pageNo) {
        return null;
    }

    @Override
    public JSONResult<?> search(Query query) {
        return null;
    }

    @Override
    public JSONResult<?> create(BrandParam record) {
        return null;
    }

    @Override
    public JSONResult<?> edit(BrandParam record) {
        return null;
    }

    @Override
    public JSONResult<?> delete(Long id) {
        return null;
    }

    @Override
    public void initProps(BrandParam record) {

    }
}
