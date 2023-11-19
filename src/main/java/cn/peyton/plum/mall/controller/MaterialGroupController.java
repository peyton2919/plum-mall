package cn.peyton.plum.mall.controller;

import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.PageResult;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.mall.controller.base.PcController;
import cn.peyton.plum.mall.param.MaterialGroupParam;
import cn.peyton.plum.mall.param.UserParam;
import cn.peyton.plum.mall.service.MaterialGroupService;
import cn.peyton.plum.mall.service.MaterialService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "*")
public class MaterialGroupController extends PcController<MaterialGroupParam> {

    @Resource
    private MaterialGroupService materialGroupService;
    @Resource
    private MaterialService materialService;

    @Token
    @PostMapping("/all")
    public JSONResult<?> getAll(Integer pageNo) {
        PageQuery page = new PageQuery(pageNo);
        PageResult<?> result = materialGroupService.findAll(new MaterialGroupParam(), page);
        if(result.isSuccess){
            return JSONResult.success(result);
        }
        return JSONResult.fail("没找到数据...");
    }
    @Token
    @PostMapping("/manager/add")
    @Valid
    public JSONResult<?> add(MaterialGroupParam param) {
        UserParam _user = handleToken(new UserParam());
        param.setCreateId(_user.getId());
        param.setCreateType(_user.getUserType());
        // 判断重名
        if(materialGroupService.isRename(param)){
            return JSONResult.fail("相册分组名称重名,请重新输入");
        }
        MaterialGroupParam res = materialGroupService.add(param);
        if (null == res) {
            return JSONResult.fail("相册分组名称添加错误");
        }
        return JSONResult.success(res);
    }
    @Token
    @PostMapping("/manager/edit")
    @Valid
    public JSONResult<?> edit(MaterialGroupParam param) {
        UserParam _user = handleToken(new UserParam());
        param.setCreateId(_user.getId());
        if(materialGroupService.isRename(param)){
            return JSONResult.fail("修改的名称与原来名称相同,不需要修改。");
        }
        Long _tId = param.getId();
        param.setId(null);
        if(materialGroupService.isRename(param)){
            return JSONResult.fail("修改的名称重名,请重新输入。");
        }
        param.setId(_tId);
        if (materialGroupService.update(param)) {
            return JSONResult.success("素材分组修改成功。");
        }
        return JSONResult.fail("素材分组修改失败。");
    }
    @Token
    @PostMapping("/manager/delete")
    @Valid
    public JSONResult<?> delete(@Min(value = 1,message = "最小值为1") Long id) {

        if (materialService.joinGroup(id)){
            JSONResult.fail("与素材库有关联,不能直接删除。");
        }
        if (materialGroupService.delete(id)) {
            return JSONResult.success("素材分组删除成功。");
        }
        return JSONResult.fail("素材分组删除失败。");
    }



}
