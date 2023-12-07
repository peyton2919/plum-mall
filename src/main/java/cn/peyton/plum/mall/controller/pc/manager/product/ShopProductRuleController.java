package cn.peyton.plum.mall.controller.pc.manager.product;

import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.inf.controller.IBasePCController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.core.anno.resolver.RequestMultiple;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.Size;
import cn.peyton.plum.mall.controller.base.PcController;
import cn.peyton.plum.mall.param.product.ShopProductRuleParam;
import cn.peyton.plum.mall.service.product.ShopProductRuleService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <h3> 商品规格--(规则) Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
@RestController
@RequestMapping("/pc/skus")
@CrossOrigin(origins = "*")
public class ShopProductRuleController extends PcController<ShopProductRuleParam>
        implements IBasePCController<Integer,ShopProductRuleParam> {
    String TIP_NAME = "规则";
    @Resource
    private ShopProductRuleService shopProductRuleService;

    @Token
    @Valid
    @PostMapping("/manager/all")
    @Override
    public JSONResult<?> all(String keyword,  @Min(message = "当前页码要大于0的数!")Integer pageNo) {
        PageQuery _page = new PageQuery(pageNo,"hot");
        ShopProductRuleParam _param = new ShopProductRuleParam();
        _param.setRuleName(keyword);
        return baseFindBykeywordAll(_param,_page,shopProductRuleService);
    }

    @Token
    @Valid
    @PostMapping("/manager/search")
    @Override
    public JSONResult<?> search(Query query) {
        PageQuery _page = new PageQuery(query.getPageNo(),"hot");
        ShopProductRuleParam _param = new ShopProductRuleParam();
        _param.setRuleName(query.getKeyword());
        return baseFindBykeywordAll(_param,_page,shopProductRuleService);
    }

    @Token
    @Valid
    @PostMapping("/manager/create")
    @Override
    public JSONResult<?> create(ShopProductRuleParam record) {
        initProps(record);
        ShopProductRuleParam _repeat = new ShopProductRuleParam();
        _repeat.setRuleName(record.getRuleName());
        return baseCreate(record, _repeat, shopProductRuleService, TIP_NAME);
    }
    @Token
    @Valid
    @PostMapping("/manager/edit")
    @Override
    public JSONResult<?> edit(ShopProductRuleParam record) {
        initProps(record);
        ShopProductRuleParam _repeat = new ShopProductRuleParam();
        _repeat.setRuleName(record.getRuleName());
        _repeat.setId(record.getId());
        return baseEdit(record, _repeat, shopProductRuleService, TIP_NAME);
    }

    @Token
    @Valid
    @PostMapping("/manager/upstatus")
    public JSONResult<?> editStatus(@Min(message = "要大于0的数！")Integer id,
                                    @Size(min = 0,max = 1) Integer status) {
        ShopProductRuleParam _param = new ShopProductRuleParam();
        _param.setStatus(status);
        _param.setId(id);
        return baseEdit(_param, null, shopProductRuleService, TIP_NAME);
    }

    @Override
    public JSONResult<?> delete(Integer id) {
        return null;
    }

    @Token
    @Valid
    @PostMapping("/manager/delete")
    public JSONResult<?> batchDelete(@RequestMultiple List<Integer> ids) {
        if(shopProductRuleService.batchDelete(ids)){
            return JSONResult.success("批量删除规格成功");
        }
        return JSONResult.fail("批量删除规格失败");
    }


    @Override
    public void initProps(ShopProductRuleParam param) {
        param.setIsDel(null);
    }


}

