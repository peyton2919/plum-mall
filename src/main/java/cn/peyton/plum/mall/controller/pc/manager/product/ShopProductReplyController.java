package cn.peyton.plum.mall.controller.pc.manager.product;

import cn.peyton.plum.core.anno.resolver.RequestMultiple;
import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.inf.controller.IBasePCController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.mall.controller.base.PcController;
import cn.peyton.plum.mall.param.product.ShopProductReplyParam;
import cn.peyton.plum.mall.service.product.ShopProductReplyService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h3> 商品评论 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
@RestController
@RequestMapping("/pc/productreply")
public class ShopProductReplyController extends PcController<ShopProductReplyParam>
        implements IBasePCController<Long, ShopProductReplyParam> {

    @Resource
    private ShopProductReplyService shopProductReplyService;

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

        // 其他处理判断
        return baseFindBykeywordAll(new ShopProductReplyParam(), new PageQuery(query.getPageNo()), shopProductReplyService,null);
    }

    @Token
    @Valid
    @PostMapping("/manager/create")
    @Override
    public JSONResult<?> create(@RequestMultiple ShopProductReplyParam record) {

        return baseCreate(record, null, shopProductReplyService, "评论");
    }

    @Token
    @Valid
    @PostMapping("/manager/edit")
    @Override
    public JSONResult<?> edit(@RequestMultiple ShopProductReplyParam record) {
        return baseEdit(record, null, shopProductReplyService, "评论",UPDATE);
    }
    @Token
    @Valid
    @PostMapping("/manager/delete")
    @Override
    public JSONResult<?> delete(@NotBlank(message = "Id 不能为空;") @Min(value = 1,message = "最小为1")Long id) {
        if(shopProductReplyService.updateIsDel(id)){
            return JSONResult.success("评论删除成功");
        }
        return JSONResult.fail("评论删除失败;");
    }


}
