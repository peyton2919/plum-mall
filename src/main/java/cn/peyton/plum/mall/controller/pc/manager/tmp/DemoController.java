package cn.peyton.plum.mall.controller.pc.manager.tmp;

import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.inf.controller.IBasePCController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.mall.controller.base.PcController;
import cn.peyton.plum.mall.param.join.BrandParam;
import cn.peyton.plum.mall.service.join.BrandService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h4>Demo controller 范例</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.mall.controller.pc.tmp.
 * @date 2023年11月28日 11:51
 * @version 1.0.0
 * </pre>
 */
@RestController
@RequestMapping("/pc/demo")
public class DemoController extends PcController<BrandParam>
        implements IBasePCController<Long, BrandParam> {
    private String TIP_NAME = "品牌";
    @Resource
    private BrandService brandService;

    @Token
    @Valid
    @PostMapping("/manager/all")
    public JSONResult<?> all(String keyword,
         @NotBlank(message = "页码 不能为空;") @Min(value = 1,message = "最小为1")Integer pageNo) {

        return null;
    }

    @Token
    @Valid
    @PostMapping("/manager/search")
    @Override
    public JSONResult<?> list(Query query) {

        BrandParam _param = new BrandParam();

        _param.setName(query.getKeyword());
        // 其他处理判断
        return baseHandleList(_param, new PageQuery(query.getPageNo(), ORDER_BY_FILED), brandService,null);
    }

    @Token
    @Valid
    @PostMapping("/manager/create")
    @Override
    public JSONResult<?> create(BrandParam record) {
        // 添加对象逻辑处理
        // ...
        // 判断重名 _repeat 为空不做重名判断
        BrandParam _repeat = new BrandParam();
        _repeat.setName(record.getName());
        return baseHandleCreate(record, _repeat, brandService, TIP_NAME);
    }

    @Token
    @Valid
    @PostMapping("/manager/edit")
    @Override
    public JSONResult<?> edit(BrandParam record) {
        initProps(record);
        // 判断重名 _repeat 为空不做重名判断
        BrandParam _repeat = new BrandParam();
        _repeat.setId(record.getId());
        _repeat.setName(record.getName());
        return baseHandleEdit(record, _repeat, brandService, TIP_NAME,UPDATE);
    }

    @Token
    @Valid
    @PostMapping("/manager/delete")
    @Override
    public JSONResult<?> delete(@NotBlank(message = "Id 不能为空;") @Min(value = 1,message = "最小为1")Long id) {
        return baseHandleDelete(id,brandService,"品牌");
    }

    @Token
    @Valid
    @PostMapping("/manager/upstatus")
    public JSONResult<?> updateStatus(@NotBlank(message = "Id 不能为空;")
            @Min(value = 1,message = "最小为1")Long id,
            @NotBlank(message = "status 不能为空;")Integer status) {
        BrandParam _param = new BrandParam();
        _param.setId(id);
        return baseHandleEdit(_param,null,brandService,"品牌",DELETE);
    }

    @Token
    @Valid
    @PostMapping("/manager/updelete")
    public JSONResult<?> updelete(@NotBlank(message = "品牌Id 不能为空;") @Min(value = 1,message = "最小为1")Long id) {

        return baseHandle(brandService.upDelete(id), TIP_NAME);
    }

    // 下拉框
    @Token
    @PostMapping("/manager/down")
    public JSONResult<?> down(){
        return JSONResult.success(brandService.findByDownList());
    }
}
