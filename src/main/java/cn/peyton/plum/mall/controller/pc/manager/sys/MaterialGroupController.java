package cn.peyton.plum.mall.controller.pc.manager.sys;

import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.inf.controller.IController;
import cn.peyton.plum.core.inf.controller.RealizeController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.mall.param.sys.MaterialGroupParam;
import cn.peyton.plum.mall.param.sys.UserParam;
import cn.peyton.plum.mall.service.sys.MaterialGroupService;
import cn.peyton.plum.mall.service.sys.MaterialService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h3> 素材分组 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
@RestController
@RequestMapping("/pc/mategroup")
public class MaterialGroupController extends RealizeController
        implements IController<Long, MaterialGroupParam> {


    @Resource
    private MaterialGroupService materialGroupService;
    @Resource
    private MaterialService materialService;
    @Valid
    @Token
    @PostMapping("/all")
    public JSONResult<?> all(String keyword,@NotBlank(message = "pageNo 不能为空;") @Min(message = "当前页码要大于0的数！") Integer pageNo) {
        return page(new MaterialGroupParam(), new PageQuery(pageNo, ORDER_BY_FILED), materialGroupService, true);
    }

    @Valid
    @Token
    @PostMapping("/manager/search")
    @Override
    public JSONResult<?> list(Query query) {
        return page(new MaterialGroupParam(), new PageQuery(query.getPageNo(), ORDER_BY_FILED), materialGroupService, true);
    }

    @Token
    @Valid
    @PostMapping("/manager/create")
    @Override
    public JSONResult<?> create(MaterialGroupParam record) {
        UserParam _user = getToken(new UserParam());
        record.setCreateId(_user.getId());
        record.setCreateType(_user.getUserType());

        MaterialGroupParam _repeat = new MaterialGroupParam();
        _repeat.setName(record.getName());
        return handle(record, _repeat, false, materialGroupService, TIP_MATERIAL_GROUP, CREATE);
    }


    @Token
    @PostMapping("/manager/edit")
    @Valid
    public JSONResult<?> edit(MaterialGroupParam param) {
        UserParam _user = getToken(new UserParam());
        param.setCreateId(null);
        param.setCreateType(null);

        MaterialGroupParam _repeat = new MaterialGroupParam();
        _repeat.setName(param.getName());
        _repeat.setId(param.getId());
        return handle(param, _repeat, true, materialGroupService, TIP_MATERIAL_GROUP, UPDATE);
    }

    @Token
    @PostMapping("/manager/delete")
    @Valid
    public JSONResult<?> delete(@Min(value = 1, message = "最小值为1") Long id) {
        if (materialService.joinGroup(id)) {
            return JSONResult.fail("与素材库有关联,不能直接删除。");
        }
        return delete(id, materialGroupService, TIP_MATERIAL_GROUP);
    }
}
