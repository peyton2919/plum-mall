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

    @Resource
    private ShopCategoryService shopCategoryService;

    // 查找 列表
    @Token
    @Valid(ignore = {"pageNo"})
    @PostMapping("/manager/search")
    @Override
    public JSONResult<?> list(Query query) {
        List<ShopCategoryParam> res = shopCategoryService.findByTree();
        if (null == res) {
            return JSONResult.fail("没找到数据");
        }
        return JSONResult.success(res);
    }

    // 下拉框 查找
    @Token
    @PostMapping("/manager/select")
    public JSONResult<?> select(){
        return JSONResult.success("商品分类数据加载成功", shopCategoryService.findByOutside());
    }

    // 下拉框 内部 使用 pid = 0
    @Token
    @PostMapping("/manager/selectinner")
    public JSONResult<?> selectInner(){
        return JSONResult.success("商品分类数据加载成功", shopCategoryService.findByInner());
    }

    // 添加分类
    @Token
    @Valid
    @PostMapping("/manager/create")
    @Override
    public JSONResult<?> create(ShopCategoryParam record) {
        ShopCategoryParam _repeat = new ShopCategoryParam();
        _repeat.setName(record.getName());
        _repeat.setPid((null != record.getPid())?record.getPid():0);
        return baseHandleCreate(record, _repeat, shopCategoryService, TIP_SHOP_CATEGROY);
    }

    // 修改分类
    @Token
    @Valid
    @PostMapping("/manager/edit")
    @Override
    public JSONResult<?> edit(ShopCategoryParam record) {
        Boolean child = false;
        if (shopCategoryService.isChildren(record.getId())||
                shopCategoryService.isRecommend(record.getId())) {
            child = true;
        }
        if (child){
            if (null != record.getSeq() && record.getSeq() >= 0) {
                if (shopCategoryService.updateSeq(record.getId(), record.getSeq())) {
                    return JSONResult.success(UPDATE + SORT + SEMICOLON + DATA + JOIN_DATA + DELETE);
                }

            }
            return JSONResult.fail(DATA + JOIN_DATA + DELETE);
        }

        ShopCategoryParam _repeat = new ShopCategoryParam();
        _repeat.setName(record.getName());
        _repeat.setPid((null != record.getPid())?record.getPid():0);
        _repeat.setId(record.getId());
        return baseHandleEdit(record, _repeat, shopCategoryService, TIP_SHOP_CATEGROY,UPDATE);
    }

    // 删除分类
    @Token
    @Valid
    @PostMapping("/manager/delete")
    @Override
    public JSONResult<?> delete(@NotBlank(message = "Id 不能为空;") @Min(value = 1,message = "最小为1")Integer id) {
        if (shopCategoryService.isChildren(id)) {
            return JSONResult.fail("有关联子类,先删除相关子类;");
        }
        if (shopCategoryService.isRecommend(id)) {
            return JSONResult.fail("有关联的推荐产品,先删除相关的推荐产品;");
        }
        return baseHandle(shopCategoryService.upDelete(id), TIP_SHOP_CATEGROY,DELETE);
    }

    // 修改分类状态
    @Token
    @Valid
    @PostMapping("/manager/upstatus")
    public JSONResult<?> editStatus(@NotBlank(message = "Id 不能为空;") @Min(message = "要大于0的数！")Integer id,
                                    @NotBlank(message = "是否推荐不能为空;")  @Size(min = 0,max = 1) Integer isShow){
        if (shopCategoryService.isRecommend(id)) {
            return JSONResult.fail("有关联的推荐产品,先删除相关的推荐产品;");
        }
        String msg = (isShow == 1) ? "推荐更新" : "移除推荐";
        return baseHandle(shopCategoryService.updateShow(id,isShow),msg);
    }

}
