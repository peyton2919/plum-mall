package cn.peyton.plum.mall.controller.pc.manager.join;

import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.inf.controller.IController;
import cn.peyton.plum.core.inf.controller.RealizeController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.core.utils.base.CtrlUtils;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.mall.param.join.BrandParam;
import cn.peyton.plum.mall.service.join.BrandService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
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
public class BrandController extends RealizeController
    implements IController<Long, BrandParam> {


    @Resource
    private BrandService brandService;

    // 查找 条件为 空 或者 keyword 品牌名称、地区 area 或 供应商Id
    // query {keyword,longValue,simpleValue,pageNo}
    @Token
    @Valid
    @PostMapping("/manager/search")
    @Override
    public JSONResult<?> list(Query query) {
        BrandParam _param = new BrandParam();
        _param.setName(query.getKeyword());
        _param.setSupId(query.getLongValue());
        _param.setArea(query.getSimpleValue());
        return page(_param, new PageQuery(query.getPageNo(), ORDER_BY_FILED), brandService,true);
    }

    @Token
    @Valid(ignore = {"supplier","createTime"})
    @PostMapping("/manager/create")
    @Override
    public JSONResult<?> create(BrandParam record) {
        BrandParam _repeat = new BrandParam();
        _repeat.setName(record.getName());
        // 完整路径转成 简单路径
        record.setLogo(new CtrlUtils().convertImgPath(record.getLogo()));
        return handle(record, _repeat,false, brandService, TIP_BRAND,CREATE);
    }

    @Token
    @Valid(ignore = {"supplier","createTime"})
    @PostMapping("/manager/edit")
    @Override
    public JSONResult<?> edit(BrandParam record) {
        // 判断重名 _repeat 为空不做重名判断
        BrandParam _repeat = new BrandParam();
        _repeat.setId(record.getId());
        _repeat.setName(record.getName());
        record.setLogo(new CtrlUtils().convertImgPath(record.getLogo()));
        return handle(record, _repeat, true, brandService, TIP_BRAND, UPDATE);
    }
    @Token
    @Valid
    @PostMapping("/manager/delete")
    @Override
    public JSONResult<?> delete(@NotBlank(message = "品牌Id 不能为空;") @Min(value = 1,message = "最小为1")Long id) {

        //return delete(brandService.upDelete(id), TIP_BRAND);
        return delete(id, brandService, TIP_BRAND);
    }
    @Token
    @Valid
    @PostMapping("/manager/one")
    public JSONResult<?> one(@NotBlank(message = "品牌Id 不能为空;") @Min(value = 1,message = "最小为1")Long id) {
        return JSONResult.success(brandService.findById(id));
    }

    // 下拉框
    @Token
    @PostMapping("/manager/down")
    public JSONResult<?> down(){
        return JSONResult.success(brandService.findByDownList());
    }


}
