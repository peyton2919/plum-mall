package cn.peyton.plum.mall.controller.pc.manager.product;

import cn.peyton.plum.core.anno.resolver.RequestMultiple;
import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.inf.controller.IController;
import cn.peyton.plum.core.inf.controller.RealizeController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.NotBlank;
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
public class ShopProductReplyController extends RealizeController
        implements IController<Long, ShopProductReplyParam> {

    @Resource
    private ShopProductReplyService shopProductReplyService;

    @Token
    @Valid
    @PostMapping("/manager/all")
    public JSONResult<?> all(String keyword,
             @NotBlank(message = "Id 不能为空;") @Min(value = 1,message = "最小为1")Integer pageNo) {
        return null;
    }

    @Token
    @Valid
    @PostMapping("/manager/search")
    @Override
    public JSONResult<?> list(Query query) {

        // 其他处理判断
        return page(new ShopProductReplyParam(), new PageQuery(query.getPageNo()), shopProductReplyService,true);
    }

    @Token
    @Valid
    @PostMapping("/manager/create")
    @Override
    public JSONResult<?> create(@RequestMultiple ShopProductReplyParam record) {

        return handle(record, null, false,shopProductReplyService, TIP_COMMENT,CREATE);
    }

    @Token
    @Valid
    @PostMapping("/manager/edit")
    @Override
    public JSONResult<?> edit(@RequestMultiple ShopProductReplyParam record) {
        return handle(record, null, true, shopProductReplyService, TIP_COMMENT, UPDATE);
    }
    @Token
    @Valid
    @PostMapping("/manager/delete")
    @Override
    public JSONResult<?> delete(@NotBlank(message = "Id 不能为空;") @Min(value = 1,message = "Id最小值为1")Long id) {

        return handle(shopProductReplyService.updateIsDel(id), TIP_COMMENT, DELETE);
    }

    @Token
    @Valid
    @PostMapping("/manager/review")
    public JSONResult<?> review(@NotBlank(message = "Id 不能为空;") @Min(value = 1,message = "Id最小值为1")Long id,
                @NotBlank(message = "回复内容 不能为空;") String content) {

        return handle(shopProductReplyService.updateReview(id, content), TIP_COMMENT, TIP_REPLY);
    }
}
