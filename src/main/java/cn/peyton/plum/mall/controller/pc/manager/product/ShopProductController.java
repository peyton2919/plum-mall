package cn.peyton.plum.mall.controller.pc.manager.product;

import cn.peyton.plum.core.anno.resolver.RequestMultiple;
import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.inf.controller.IController;
import cn.peyton.plum.core.inf.controller.RealizeController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.FormData;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.core.utils.HttpServletRequestUtils;
import cn.peyton.plum.core.utils.LogUtils;
import cn.peyton.plum.core.utils.base.CtrlUtils;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.mall.param.product.ProductSingle;
import cn.peyton.plum.mall.param.product.ShopProductParam;
import cn.peyton.plum.mall.param.product.ShopSkuParam;
import cn.peyton.plum.mall.param.sys.UserParam;
import cn.peyton.plum.mall.service.product.ShopProductService;
import com.alibaba.fastjson.JSON;
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
public class ShopProductController extends RealizeController
        implements IController<Long,ShopProductParam> {

    @Resource
    private ShopProductService shopProductService;

    // 1. 查找商品列表
    // tab：all全部，checking审核中，saling出售中，off已下架，delete回收站，hot 热卖, best 精品, new 新品, good 推荐
    @Token
    @Valid
    @PostMapping("/manager/search")
    @Override
    public JSONResult<?> list(Query query) {
        System.out.println(HttpServletRequestUtils.getSiteRootPath());
        if (null == query) {
            return JSONResult.fail(ERROR);
        }
        ShopProductParam _param = new ShopProductParam();
        _param.setTitle(query.getKeyword());
        String key = "all";
        if ("delete".equals(query.getTab())) {  // 回收站
            _param.setIsDel(IS_DEL_0);
            key = "delete";
        }else {
            _param.setIsDel(IS_DEL_1);
            if ("checking".equals(query.getTab())) { //审核中
                key = "checking";
                _param.setIsCheck(0);
            } else if ("off".equals(query.getTab())) { // 已下架
                key = "off";
                _param.setIsShow(0);
            } else if ("saling".equals(query.getTab())) { // 出售中
                key = "saling";
                _param.setIsCheck(1);
                _param.setIsShow(1);
            } else if ("hot".equals(query.getTab())) { // 是否热卖, 默认 0 不是 1 是
                key = "hot";
                _param.setIsHot(1);
            }
            else if ("best".equals(query.getTab())) { // 是否精品, 默认 0 不是 1 是
                key = "best";
                _param.setIsBest(1);
            }
            else if ("new".equals(query.getTab())) { // 是否是新品, 默认 0 不是 1 是
                key = "new";
                _param.setIsNew(1);
            }
            else if ("good".equals(query.getTab())) { // 是否优品推荐, 默认 0 不是 1 是
                key = "good";
                _param.setIsGood(1);
            }
        }

        return page(_param, new PageQuery(query.getPageNo(), ORDER_BY_FILED), shopProductService, null, key, true);
    }

    // 单规格 specType, skus
    @Token
    @Valid
    //@PostMapping("/manager/single")
    public JSONResult<?> single(ProductSingle product) {
        // todo 单规格逻辑处理
        String operate = shopProductService.findByOperate(product.getId());
        String[] strs = new CtrlUtils().convertStrToArr(operate);
        strs[0] = "1";
        product.setOperate(new CtrlUtils().convertArrToStr(strs));
        return handle(convert(product), null, false, shopProductService, "单规格设置");
    }

    // 审核
    @Token
    @Valid
    @PostMapping("/manager/check")
    public JSONResult<?> verify(@NotBlank(message = "商品 Id 不能为空;") @Min(value = 1,message = "最小为1")Long id) {

        String operate = shopProductService.findByOperate(id);
        if (null == operate || "".equals(operate)) {
            return JSONResult.fail(ERROR);
        }
        String [] _tmp = operate.split(",");
        if("0".equals(_tmp[0])){ // 规格
            return JSONResult.fail("商品 [规格] 未设置!");
        }else if("0".equals(_tmp[1])){ // 轮播图
            return JSONResult.fail("商品 [轮播图] 未设置!");
        }else if("0".equals(_tmp[2])){ // 详情
            return JSONResult.fail("商品 [详情] 未设置!");
        }

        return handle(shopProductService.updateCheck(id), TIP_PRODUCT, VERIFY);
    }

    // 3. 新增商品
    @Token
    @Valid(ignore = {"price","minPrice","categories","slideshows","productSkus","shopSkus","brand"})
    @PostMapping("/manager/create")
    @Override
    public JSONResult<?> create(@RequestMultiple ShopProductParam record) {
        if (null == record || null == record.getCategories() || record.getCategories().size() == 0) {
            return JSONResult.fail(SELECT + TIP_PRODUCT + CATEGORY);
        }
        props(record);
        record.setOperate("0,0,0");
        record.setCover(new CtrlUtils().convertImgPath(record.getCover()));
        return handle(shopProductService.createAndBatchCategories(record), TIP_PRODUCT, CREATE);
    }

    // 4. 修改商品
    @Token
    @Valid(ignore = {"price","minPrice","categories","slideshows","productSkus","shopSkus","brand"})
    @PostMapping("/manager/edit")
    @Override
    public JSONResult<?> edit(@RequestMultiple ShopProductParam record) {
        if (record.getCategories().size() == 0) {
            return JSONResult.fail(SELECT + TIP_PRODUCT + CATEGORY);
        }
        props(record);
        record.setCover(new CtrlUtils().convertImgPath(record.getCover()));
        return handle(shopProductService.updateAndBatchCategories(record), TIP_PRODUCT, MODIFY);
    }

    //  5. 更新商品详情
    @Token
    @PostMapping("/manager/editexplain")
    public JSONResult<?> editExplain(@RequestMultiple ShopProductParam record) {
        if (null == record || null == record.getId() || null == record.getExplain() || "".equals(record.getExplain())) {
            return JSONResult.fail(OPERATE + PARAM + NULL);
        }

        return handle(shopProductService.updateExplain(record), TIP_PRODUCT, DETAIL, MODIFY);
    }

    // 6. 删除||批量删除 商品
    @Token
    @Valid
    @PostMapping("/manager/delete")
    public JSONResult<?> batchDelete(@RequestMultiple FormData data) {
        if (null == data || null == data.getLongs() || data.getLongs().size() == 0) {
            return JSONResult.fail(MSG);
        }
        return handle(shopProductService.batchDelete(data.getLongs()), TIP_PRODUCT, BATCH, DELETE);
    }

    // 7. 批量恢复商品
    @Token
    @Valid
    @PostMapping("/manager/restore")
    public JSONResult<?> restore(@RequestMultiple FormData data) {
        if (null == data || null == data.getLongs() || data.getLongs().size() == 0) {
            return JSONResult.fail(MSG);
        }
        return handle(shopProductService.batchRestore(data.getLongs()), TIP_PRODUCT, BATCH, RESTORE);
    }

    // 8. 彻底删除商品
    @Token
    @Valid
    @PostMapping("/manager/destroy")
    public JSONResult<?> destroy(@RequestMultiple FormData data) {
        // todo 需要超级管理员权限
        UserParam _user = getToken(new UserParam());
        if (_user.getRoleParam().getId() != 1) {
            return JSONResult.fail("彻底删除商品信息，需要超级管理员权限；");
        }

        if (null == data || null == data.getLongs() || data.getLongs().size() == 0) {
            return JSONResult.fail(MSG);
        }
        return handle(shopProductService.destroy(data.getLongs()), TIP_PRODUCT, BATCH, DELETE);
    }

    // 2. 批量上|下架商品
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
        return JSONResult.fail(_msg + FAIL);
    }

    // 9. 查找商品(多类型)
    @Token
    @Valid
    @PostMapping("/manager/one")
    public JSONResult<?> one(@NotBlank(message = "商品 Id 不能为空;") @Min(value = 1,message = "Id 最小值为1")Long id, String type) {
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

    @Token
    @Valid
    @PostMapping("/manager/recommend")
    public JSONResult<?> recommend(@NotBlank(message = "分类 Id 不能为空;") @Min(value = 1,message = "最小值为1")Integer categoryId) {

        return list(shopProductService.findByIdAndJoin(categoryId), null);
        //todo
    }

    public void props(ShopProductParam param) {
        param.setIsDel(null);
        param.setIsCheck(null);
        param.setIsSub(null);
    }

    private ShopProductParam convert(ProductSingle single) {
        if(null == single) return null;
        ShopProductParam param = new ShopProductParam();
        param.setId(single.getId());
        param.setSpecType(single.getSpecType());
        param.setMinPrice(single.getMinPrice());
        param.setPrice(single.getPrice());
        param.setOperate(single.getOperate());
        param.setSkus(JSON.toJSONString(single));
        return param;
    }

    @Override
    public JSONResult<?> delete(Long id) {
        return null;
    }

}
