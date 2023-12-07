package cn.peyton.plum.mall.controller.pc.manager.sys;

import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.inf.controller.IBasePCController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.core.anno.resolver.RequestMultiple;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.core.validator.constraints.Size;
import cn.peyton.plum.mall.controller.base.PcController;
import cn.peyton.plum.mall.param.sys.RoleMenuParam;
import cn.peyton.plum.mall.param.sys.RoleParam;
import cn.peyton.plum.mall.service.sys.RoleMenuService;
import cn.peyton.plum.mall.service.sys.RoleService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3> 角色 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
@RestController
@RequestMapping("/pc/role")
@CrossOrigin(origins = "*")
public class RoleController extends PcController<RoleParam>
        implements IBasePCController<Long, RoleParam> {
    String TIP_NAME = "公告";

    @Resource
    private RoleService roleService;
    @Resource
    private RoleMenuService roleMenuService;

    /**
     * <h4>分页查找</h4>
     * @param keyword 关键字
     * @param pageNo 分页数
     * @return
     */
    @Token
    @Valid
    @PostMapping("/manager/all")
    @Override
    public JSONResult<?> all(String keyword, @NotBlank(message = "pageNo 不能为空;")
            @Min(message = "当前页码要大于0的数！")Integer pageNo) {
        PageQuery _page = new PageQuery(pageNo);
        RoleParam _param = new RoleParam();
        _param.setName(keyword);
        return baseFindBykeywordAll(_param, _page, roleService);
    }

    @Token
    @Valid
    @PostMapping("/manager/search")
    @Override
    public JSONResult<?> search(Query query) {
        RoleParam _param = new RoleParam();
        _param.setName(query.getKeyword());
        return baseFindBykeywordAll(_param,new PageQuery(query.getPageNo()),roleService);
    }

    @Token
    @Valid
    @PostMapping("/manager/create")
    @Override
    public JSONResult<?> create(RoleParam param) {
        initProps(param);
        RoleParam _repeat = new RoleParam();
        _repeat.setName(param.getName());
        return baseCreate(param, _repeat, roleService, TIP_NAME);
    }

    @Token
    @Valid
    @PostMapping("/manager/edit")
    @Override
    public JSONResult<?> edit(RoleParam param) {
        initProps(param);
        RoleParam _repeat = new RoleParam();
        _repeat.setName(param.getName());
        _repeat.setId(param.getId());
        return baseEdit(param, _repeat, roleService, TIP_NAME);
    }

    @Token
    @Valid
    @PostMapping("/manager/upstatus")
    public JSONResult<?> editStatus(@Min(message = "要大于0的数！")long id,
                  @Size(min = 0,max = 1) Integer status) {
        RoleParam _param = new RoleParam();
        _param.setStatus(status);
        _param.setId(id);
        return baseEdit(_param, null, roleService, TIP_NAME);
    }

    @Token
    @Valid
    @PostMapping("/manager/delete")
    @Override
    public JSONResult<?> delete(@Min(value = 1,message = "最小值为1") Long id) {
        RoleParam _param = new RoleParam();
        _param.setIsDel(0);
        _param.setId(id);
        return baseEdit(_param, null, roleService, null);
    }

    // @Min(value = 1,message = "最小值为1") Long id,
    @Token
    @Valid
    @PostMapping("/manager/rules")
    public JSONResult<?> rules(@Min(value = 1, message = "最小值为1") @RequestMultiple("id") Long id, @RequestMultiple("ids") Long[] ids) {
        if (null != ids && ids.length > 0) {
            List<RoleMenuParam> _lists = new ArrayList<>();
            RoleMenuParam _param = null;
            for (Long _menuId : ids) {
                _param = new RoleMenuParam();
                _param.setRoleId(id);
                _param.setMenuId(_menuId);
                _lists.add(_param);
            }
            if (roleMenuService.batchAdd(_lists)) {
                return JSONResult.success("菜单规则添加成功");
            }
        }
        return JSONResult.fail("菜单规则添加失败");
    }



    @Override
    public void initProps(RoleParam param) {
        param.setIsDel(null);
    }

}
