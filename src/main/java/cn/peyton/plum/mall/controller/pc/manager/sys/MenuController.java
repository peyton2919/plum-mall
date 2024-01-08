package cn.peyton.plum.mall.controller.pc.manager.sys;

import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.inf.controller.IBasePCController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.PageResult;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.core.validator.constraints.Size;
import cn.peyton.plum.mall.controller.base.PcController;
import cn.peyton.plum.mall.param.sys.MenuParam;
import cn.peyton.plum.mall.service.sys.MenuService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <h3> 菜单 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
@RestController
@RequestMapping("/pc/menu")
public class MenuController extends PcController<MenuParam>
        implements IBasePCController<Long, MenuParam> {

    @Resource
    private MenuService menuService;

    @PostMapping("/manager/tree")
    public JSONResult<?> findByTree(){
        List<MenuParam> result = menuService.findByTree();
        if (null != result) {
            return JSONResult.success(DATA_LOADING_SUCCESS,result);
        }
        return JSONResult.fail(JSONResult.Props.NO_DATA,NO_DATA);
    }

    @Override
    public JSONResult<?> list(Query query) {
        return null;
    }

    @Token
    @Valid
    @PostMapping("/manager/create")
    @Override
    public JSONResult<?> create(MenuParam record) {
        return baseHandleCreate(record, new MenuParam(null,record.getPid(),record.getName()),menuService, TIP_MENU);
    }


    @Token
    @Valid
    @PostMapping("/manager/edit")
    public JSONResult<?> edit(MenuParam param) {
        return baseHandleEdit(param,new MenuParam(param.getId(),param.getPid(),param.getName()), menuService, TIP_MENU);
    }

    @Token
    @Valid
    @PostMapping("/manager/delete")
    public JSONResult<?> delete(@NotBlank (message = "菜单Id不能为空") @Min(value = 1,message = "最小值为1") Long id) {
        return baseHandleDelete(id, menuService, TIP_MENU);
    }

    @Token
    @Valid
    @PostMapping("/manager/upstatus")
    public JSONResult<?> editStatus(@NotBlank(message = "菜单Id不能为空") @Min(message = "要大于0的数！")long id,
                                        @Size(min = 0,max = 1) Integer status){
        return baseHandle(menuService.upStatus(id, status), STATUS);
    }


    @GetMapping("/findall")
    public JSONResult<?> findAll(){
        return JSONResult.success(menuService.findMenuListByShareIdAndType(1L,2));
    }

    @PostMapping("/manager/allkeyword")
    public JSONResult<?> findAllByKeyword(String keyword, @Min(message = "当前页码要大于0的数！")Integer pageNo) {
        MenuParam _param = new MenuParam();
        _param.setName(keyword);
        PageResult<?> result = menuService.likeByPage(_param, new PageQuery(pageNo,ORDER_BY_FILED));
        if (result.isSuccess){
            return JSONResult.success(DATA_LOADING_SUCCESS,result);
        }
        return JSONResult.fail(JSONResult.Props.NO_DATA,NO_DATA);
    }

}
