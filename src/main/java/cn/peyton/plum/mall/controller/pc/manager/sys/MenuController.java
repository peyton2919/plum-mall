package cn.peyton.plum.mall.controller.pc.manager.sys;

import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.inf.controller.IBasePCController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.PageResult;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.Min;
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
@CrossOrigin(origins = "*")
public class MenuController extends PcController<MenuParam>
        implements IBasePCController<Long, MenuParam> {
    private String TIP_NAME = "菜单";

    @Resource
    private MenuService menuService;

    @PostMapping("/manager/tree")
    public JSONResult<?> findByTree(){
        List<MenuParam> result = menuService.findByTree();
        if (null != result) {
            return JSONResult.success("数据加载成功",result);
        }
        return JSONResult.fail(JSONResult.Props.NO_DATA,"没找到数据");
    }

    @Override
    public JSONResult<?> all(String keyword, Integer pageNo) {
        return null;
    }

    @Override
    public JSONResult<?> search(Query query) {
        return null;
    }
    @Token
    @Valid
    @PostMapping("/manager/create")
    @Override
    public JSONResult<?> create(MenuParam record) {
        return baseCreate(record, new MenuParam(null,record.getPid(),record.getName()),menuService, TIP_NAME);
    }


    @Token
    @Valid
    @PostMapping("/manager/edit")
    public JSONResult<?> edit(MenuParam param) {
        return baseEdit(param,new MenuParam(param.getId(),param.getPid(),param.getName()), menuService, TIP_NAME);
    }

    @Token
    @PostMapping("/manager/delete")
    @Valid
    public JSONResult<?> delete(@Min(value = 1,message = "最小值为1") Long id) {
        return baseDelete(id, menuService, TIP_NAME);
    }

    @Token
    @PostMapping("/manager/upstatus")
    public JSONResult<?> editStatus(@Min(message = "要大于0的数！")long id,
                                        @Size(min = 0,max = 1) Integer status){
        MenuParam _param = new MenuParam();
        _param.setId(id);
        _param.setStatus(status);
        return baseEdit(_param, null, menuService, "状态");
    }


    @GetMapping("/findall")
    public JSONResult<?> findAll(){
        return JSONResult.success(menuService.findMenuListByShareIdAndType(1L,2));
    }

    @PostMapping("/manager/allkeyword")
    public JSONResult<?> findAllByKeyword(String keyword, @Min(message = "当前页码要大于0的数！")Integer pageNo) {
        MenuParam _param = new MenuParam();
        _param.setName(keyword);
        PageResult<?> result = menuService.findAllByLike(_param, new PageQuery(pageNo,"seq"));
        if (result.isSuccess){
            return JSONResult.success("数据加载成功",result);
        }
        return JSONResult.fail(JSONResult.Props.NO_DATA,"没找到数据");
    }

}
