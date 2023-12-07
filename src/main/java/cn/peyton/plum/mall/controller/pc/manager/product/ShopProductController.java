package cn.peyton.plum.mall.controller.pc.manager.product;

import cn.peyton.plum.core.anno.resolver.RequestMultiple;
import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.inf.controller.IBasePCController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.FormData;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.core.utils.LogUtils;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.mall.controller.base.PcController;
import cn.peyton.plum.mall.param.product.ShopProductParam;
import cn.peyton.plum.mall.param.product.ShopProductSkuDetailParam;
import cn.peyton.plum.mall.param.product.ShopSkuParam;
import cn.peyton.plum.mall.service.product.ShopProductService;
import com.alibaba.fastjson.JSONObject;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <h3> 商品信息 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
@RestController
@RequestMapping("/pc/product")
public class ShopProductController extends PcController<ShopProductParam>
        implements IBasePCController<Long,ShopProductParam> {

    @Resource
    private ShopProductService shopProductService;

    @Token
    @Valid
    @PostMapping("/manager/all")
    @Override
    public JSONResult<?> all(String keyword, @Min(message = "当前页码要大于0的数!")Integer pageNo) {
        PageQuery _page = new PageQuery(pageNo,"seq");
        ShopProductParam _param = new ShopProductParam();
        _param.setName(keyword);
        return baseFindBykeywordAll(_param,_page,shopProductService);
    }

    @Token
    @Valid
    @PostMapping("/manager/search")
    @Override
    public JSONResult<?> search(Query query) {
        if (null == query) {
            return JSONResult.fail("条件异常;");
        }
        ShopProductParam _param = new ShopProductParam();
        if ("delete".equals(query.getTab())) {
            _param.setName(query.getKeyword());
            _param.setIsDel(IS_DEL_0);
        }else {
            _param.setIsDel(IS_DEL_1);
        }


        return baseFindBykeywordAll(_param,new PageQuery(query.getPageNo(),ORDER_BY_FILED),shopProductService);
    }

    // 单规格
    @Token
    @Valid
    @PostMapping("/manager/single")
    public JSONResult<?> single(@RequestMultiple FormData<ShopProductSkuDetailParam> data) {
        // todo 单规格逻辑处理
        return null;
    }


    @Token
    @Valid
    @PostMapping("/manager/create")
    @Override
    public JSONResult<?> create(ShopProductParam record) {
        initProps(record);
        return baseCreate(record, null, shopProductService, record.getName());
    }

    @Token
    @Valid
    @PostMapping("/manager/edit")
    @Override
    public JSONResult<?> edit(ShopProductParam record) {
        if (shopProductService.update(record)) {
            return JSONResult.success("修改成功;");
        }
        return JSONResult.fail("修改失败;");
    }

    @Override
    public JSONResult<?> delete(Long id) {
        return null;
    }

    @Token
    @Valid
    @PostMapping("/manager/delete")
    public JSONResult<?> batchDelete(@RequestMultiple FormData data) {
        if(shopProductService.batchDelete(data.getLongs())){
            return JSONResult.success("批量删除商品成功;");
        }
        return JSONResult.fail("批量删除商品失败;");
    }

    //批量恢复商品
    @Token
    @Valid
    @PostMapping("/manager/restore")
    public JSONResult<?> restore(@RequestMultiple FormData data) {
        if(shopProductService.batchRestore(data.getLongs())){
            return JSONResult.success("批量恢复商品成功;");
        }
        return JSONResult.fail("批量恢复商品失败;");
    }

    //彻底删除商品
    @Token
    @Valid
    @PostMapping("/manager/destroy")
    public JSONResult<?> destroy(@RequestMultiple FormData data) {
        // todo
        //if(shopProductService.batchRestore(data.getLongs())){
        //    return JSONResult.success("批量恢复商品成功;");
        //}
        return JSONResult.fail("批量恢复商品失败;");
    }

    // 批量上|下架商品
    @Token
    @Valid
    @PostMapping("/manager/upisshow")
    public JSONResult<?> batchIsShow(FormData data) {
        String _msg = "批量操作";
        try {
            List<Long> ids = data.getLongs();
            Integer isShow = data.getStatus();
            _msg = isShow == 0 ? "批量下架" : "批量上架";
            if(shopProductService.batchIsShow(ids,isShow)){
                return JSONResult.success( _msg + SUCCESS);
            }
        } catch (Exception e) {
            LogUtils.error(e.getMessage());
        }
        return JSONResult.fail(_msg+FAIL);
    }

    @Token
    @Valid
    @PostMapping("/manager/one")
    public JSONResult<?> one(@NotBlank(message = "Id 不能为空;") @Min(value = 1,message = "最小为1")Long id,String type) {
        ShopProductParam _param = null;
       if("slideshow".equals(type)){
           _param = shopProductService.selectBySlideshow(id);
       }else if ("explain".equals(type)){
           _param = shopProductService.selectByExplain(id);
        }else {
           _param = shopProductService.findById(id);
       }
        if (null != _param) {
            if (null != _param.getSkus() && _param.getSpecType() == 1) {
                _param.setShopSkus(JSONObject.parseArray(_param.getSkus(), ShopSkuParam.class));
            }
            return JSONResult.success("商品加载成功", _param);
        }
        return JSONResult.fail("没找到相应的商品");
    }

    @Override
    public void initProps(ShopProductParam param) {
        param.setBrowse(null);
        param.setFicti(null);
        param.setIsShow(1);
        param.setIsHot(0);
        param.setIsBenefit(0);
        param.setIsBest(null);
        param.setIsNew(null);
        param.setPostage(null);
        param.setIsDel(null);
        param.setIsGood(null);
        param.setIsSub(null);
        param.setIsIntegral(null);
        param.setIsCheck(null);
    }
}
