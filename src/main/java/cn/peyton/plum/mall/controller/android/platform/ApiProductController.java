package cn.peyton.plum.mall.controller.android.platform;

import cn.peyton.plum.core.err.ValidationException;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.mall.controller.base.AndroidController;
import cn.peyton.plum.mall.dto.ProductDto;
import cn.peyton.plum.mall.param.product.ShopProductParam;
import cn.peyton.plum.mall.param.product.ShopProductReplyParam;
import cn.peyton.plum.mall.service.product.ShopProductReplyService;
import cn.peyton.plum.mall.service.product.ShopProductService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * <h4></h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.mall.controller.android.platform.
 * @date 2024年01月20日 23:03
 * @version 1.0.0
 * </pre>
 */
@RestController
@RequestMapping("/api/product")
public class ApiProductController extends AndroidController {

    @Resource
    private ShopProductService shopProductService;
    @Resource
    private ShopProductReplyService shopProductReplyService;

    @Valid
    @PostMapping("/one")
    public JSONResult<?> one(@NotBlank(message = "Id 不能为空;") @Min(value = 1,message = "最小值为1")Long id) {
        ShopProductParam _res = shopProductService.findById(id);
        // 该商品的评论 hotComments
        // 热门推荐 hotList

        if (null == _res) {
            return JSONResult.fail(NO_DATA);
        }
        if (null != _res.getProductSkus() && _res.getProductSkus().size() > 0) {
            int size = _res.getProductSkus().size();
            for (int i = 0; i < size; i++) {
                _res.getProductSkus().get(i).setCostPrice(new BigDecimal(0));
            }
        }
        return JSONResult.success(_res);
    }
    // tab {'','sale_counnt','min_price'} 标签
    // type {'asc','desc'} 排序
    // keyword 关键字
    // compleValue {'between','>'} 筛选
    // simpleValue 条件
    // pageNo
    @Valid
    @PostMapping("/search")
    public JSONResult<?> search(ProductDto dto) {
        PageQuery page = new PageQuery(dto.getPageNo());
        convert(dto,page);
        if ("categoryId".equals(dto.getType())) {
            if (null == dto.getCategoryId() || dto.getCategoryId() < 1) {
                return JSONResult.fail(JSONResult.Props.NO_DATA,"商品分类Id参数错误");
            }
        }
        if ("brandId".equals(dto.getType())) {
            if (null == dto.getBrandId() || dto.getBrandId() < 1) {
                return JSONResult.fail(JSONResult.Props.NO_DATA,"品牌Id参数错误");
            }
        }
        return handleList(shopProductService.findAndroidByMulti(dto, page), null);
    }


    @Valid
    @PostMapping("/comments")
    public JSONResult<?> comments(@NotBlank(message = "Id 不能为空;") @Min(value = 1,message = "最小值为1")Long id,
                  @NotBlank(message = "当前页码不能为空;") @Min(value = 1,message = "最小值为1")Integer pageNo,String tab) {
        //return JSONResult.success(shopProductReplyService.findByProductId(id, new PageQuery(pageNo)));
        ShopProductReplyParam _param = new ShopProductReplyParam();
        _param.setProductId(id);
        int total = shopProductReplyService.countByProductId(id);
        BigDecimal bigDecimal = shopProductService.findProductByGoodRate(id);
        String expand = "{\"total\":"+total+",\"goodRate\":" + bigDecimal + "}";
        //return list(_param, new PageQuery(pageNo), shopProductReplyService, expand, null);
        return handleList(shopProductReplyService.findByProductId(id, new PageQuery(pageNo), tab), expand);
    }

    /**
     * <h4>对象转换</h4>
     * @param dto
     * @param page
     */
    private void convert(ProductDto dto, PageQuery page) {
        dto.setTab((!"all".equals(dto.getTab()))? dto.getTab() : "seq");

        if("desc".equals(dto.getOrderBy())){
            page.setOrderMode("DESC");
        }else {
            page.setOrderMode("ASC");
        }
        if ("between".equals(dto.getRule())) {
            if (null == dto.getCondition()) {
                throw new ValidationException("筛选条件参数错误");
            }
            dto.setRule("bt");
            String[] strs = dto.getCondition().split(",");
            try {
                dto.setMin(Integer.parseInt(strs[0]));
                dto.setMax(Integer.parseInt(strs[1]));
            } catch (Exception e) {
                throw new ValidationException("筛选条件参数错误");
            }
        }else if(">".equals(dto.getRule())){
            try {
                dto.setRule("gt");
                dto.setMin(Integer.parseInt(dto.getCondition()));
            } catch (Exception e) {
                throw new ValidationException("筛选条件参数错误");
            }
        }

        try {
            if ("categoryId".equals(dto.getType())) {
                dto.setCategoryId(Integer.parseInt(dto.getKeyword()));
            }else if("brandId".equals(dto.getType())) {
                dto.setBrandId(Long.parseLong(dto.getKeyword()));
            }

        }catch (Exception e) {
            throw new ValidationException("筛选条件参数错误");
        }
    }

}
