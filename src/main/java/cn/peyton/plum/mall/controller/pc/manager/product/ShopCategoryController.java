package cn.peyton.plum.mall.controller.pc.manager.product;

import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.inf.controller.IBasePCController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.core.validator.constraints.Size;
import cn.peyton.plum.mall.controller.base.PcController;
import cn.peyton.plum.mall.param.product.ShopCategoryParam;
import cn.peyton.plum.mall.service.product.ShopCategoryService;
import cn.peyton.plum.mall.service.product.ShopProductCategoryService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <h3> 商品分类 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
@RestController
@RequestMapping("/pc/category")
public class ShopCategoryController  extends PcController<ShopCategoryParam>
        implements IBasePCController<Integer, ShopCategoryParam> {
    String TIP_NAME = "商品分类";

    @Resource
    private ShopCategoryService shopCategoryService;
    @Resource
    private ShopProductCategoryService shopProductCategoryService;

    @Token
    @Valid
    @PostMapping("/manager/all")
    @Override
    public JSONResult<?> all(String keyword,
             @NotBlank(message = "Id 不能为空;") @Min(value = 1,message = "最小为1")Integer pageNo) {
        return null;
    }
    @Token
    @Valid
    @PostMapping("/manager/search")
    @Override
    public JSONResult<?> search(Query query) {
        //ShopCategoryParam _param = new ShopCategoryParam();
        //_param.setName(query.getKeyword());
        //return baseFindBykeywordAll(_param,new PageQuery(query.getPageNo(),ORDER_BY_FILED),shopCategoryService);
        List<ShopCategoryParam> res = shopCategoryService.findByTree();
        if (null == res) {
            return JSONResult.fail("没找到数据");
        }
        return JSONResult.success(res);
    }

    @Token
    @PostMapping("/manager/select")
    public JSONResult<?> select(){

        return JSONResult.success("商品分类数据加载成功", shopCategoryService.findByOutside());
    }
    @Token
    @PostMapping("/manager/selectinner")
    public JSONResult<?> selectInner(){
        return JSONResult.success("商品分类数据加载成功", shopCategoryService.findByInner());
    }
    @Token
    @Valid
    @PostMapping("/manager/create")
    @Override
    public JSONResult<?> create(ShopCategoryParam record) {
        ShopCategoryParam _repeat = new ShopCategoryParam();
        _repeat.setName(record.getName());
        _repeat.setPid((null != record.getPid())?record.getPid():0);
        return baseCreate(record, _repeat, shopCategoryService, TIP_NAME);
    }
    @Token
    @Valid
    @PostMapping("/manager/edit")
    @Override
    public JSONResult<?> edit(ShopCategoryParam record) {
        ShopCategoryParam _repeat = new ShopCategoryParam();
        _repeat.setName(record.getName());
        _repeat.setPid((null != record.getPid())?record.getPid():0);
        _repeat.setId(record.getId());
        return baseEdit(record, _repeat, shopCategoryService, TIP_NAME,UPDATE);
    }
    @Token
    @Valid
    @PostMapping("/manager/delete")
    @Override
    public JSONResult<?> delete(@NotBlank(message = "Id 不能为空;") @Min(value = 1,message = "最小为1")Integer id) {
        //ShopCategoryParam record = new ShopCategoryParam();
        //record.setId(id);
        //return baseEdit(record, null, shopCategoryService, TIP_NAME,DELETE);
        if (shopCategoryService.updateDelete(id)) {
            return JSONResult.success("分类删除成功;");
        }
        return JSONResult.fail("分类删除失败;");
    }

    @Token
    @Valid
    @PostMapping("/manager/upstatus")
    public JSONResult<?> editStatus(@NotBlank(message = "Id 不能为空;") @Min(message = "要大于0的数！")Integer id,
                                    @NotBlank(message = "Id 不能为空;")  @Size(min = 0,max = 1) Integer isShow){
        if (shopCategoryService.updateShow(id, isShow)) {
            return JSONResult.success("更新成功;");
        }
        return JSONResult.fail("更新失败;");
    }

}
