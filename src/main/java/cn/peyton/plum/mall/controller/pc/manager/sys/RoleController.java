package cn.peyton.plum.mall.controller.pc.manager.sys;

import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.inf.controller.IBasePCController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.FormData;
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
    String TIP_NAME = "角色";

    @Resource
    private RoleService roleService;
    @Resource
    private RoleMenuService roleMenuService;

    //@Token
    //@Valid
    //@PostMapping("/manager/all")
    //public JSONResult<?> all(String keyword, @NotBlank(message = "pageNo 不能为空;")
    //        @Min(message = "当前页码要大于0的数！")Integer pageNo) {
    //    PageQuery _page = new PageQuery(pageNo);
    //    RoleParam _param = new RoleParam();
    //    _param.setName(keyword);
    //    return baseFindBykeywordAll(_param, _page, roleService,null);
    //}

    @Token
    @Valid
    @PostMapping("/manager/search")
    @Override
    public JSONResult<?> list(Query query) {
        RoleParam _param = new RoleParam();
        _param.setName(query.getKeyword());
        return baseHandleList(_param,new PageQuery(query.getPageNo()),roleService,null);
    }

    @Token
    @Valid
    @PostMapping("/manager/create")
    @Override
    public JSONResult<?> create(RoleParam param) {
        initProps(param);
        RoleParam _repeat = new RoleParam();
        _repeat.setName(param.getName());
        return baseHandleCreate(param, _repeat, roleService, TIP_NAME);
    }

    @Token
    @Valid
    @PostMapping("/manager/edit")
    @Override
    public JSONResult<?> edit(RoleParam param) {
        initProps(param);
        if (null != param.getId() && param.getId() == 1L) {
            return JSONResult.fail("角色为超级管理员,不能被修改!!!");
        }
        RoleParam _repeat = new RoleParam();
        _repeat.setName(param.getName());
        _repeat.setId(param.getId());
        return baseHandleEdit(param, _repeat, roleService, TIP_NAME);
    }

    @Token
    @Valid
    @PostMapping("/manager/upstatus")
    public JSONResult<?> editStatus(@NotBlank(message = "角色 ID 不能为空;")@Min(message = "要大于0的数！")long id,
                  @Size(min = 0,max = 1) Integer status) {
        if (id == 1L) {
            return JSONResult.fail("角色为超级管理员,状态不能被修改!!!");
        }
        RoleParam _param = new RoleParam();
        _param.setStatus(status);
        _param.setId(id);
        return baseHandleEdit(_param, null, roleService, TIP_NAME);
    }

    @Token
    @Valid
    @PostMapping("/manager/delete")
    @Override
    public JSONResult<?> delete(@NotBlank(message = "角色 ID 不能为空;")@Min(value = 1,message = "最小值为1") Long id) {
        if (id == 1L) {
            return JSONResult.fail("角色为超级管理员,不能被删除!!!");
        }
        RoleParam _param = new RoleParam();
        _param.setIsDel(0);
        _param.setId(id);
        return baseHandleEdit(_param, null, roleService, null);
    }

    // @Min(value = 1,message = "最小值为1") Long id,
    // 配置权限
    @Token
    @Valid
    @PostMapping("/manager/rules")
    public JSONResult<?> rules(@RequestMultiple FormData data) {
        Long id = data.getKeyLong();
        if (null == id || id < 1) {
            JSONResult.fail("角色 ID 不能为空;");
        }
        if (id == 1L) {
            return JSONResult.fail("角色为超级管理员,无需权限配置!!!");
        }
        List<Long> ids = data.getLongs();
        if (null == ids || ids.size() == 0) {
            JSONResult.fail("没有选择权限信息;");
        }
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
        return JSONResult.fail("菜单规则添加失败");
    }



    @Override
    public void initProps(RoleParam param) {
        param.setIsDel(null);
    }

}
