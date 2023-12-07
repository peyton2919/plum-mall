package cn.peyton.plum.mall.controller.pc.manager.product;

import cn.peyton.plum.core.anno.resolver.RequestMultiple;
import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.inf.controller.IBasePCController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.FormData;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.mall.controller.base.PcController;
import cn.peyton.plum.mall.param.product.ShopProductSkuDetailParam;
import cn.peyton.plum.mall.service.product.ShopProductSkuDetailService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h3> 商品规格详细 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
@RestController
@RequestMapping("/pc/productskudetail")
public class ShopProductSkuDetailController extends PcController<ShopProductSkuDetailParam>
        implements IBasePCController<Long,ShopProductSkuDetailParam> {

    @Resource
    private ShopProductSkuDetailService shopProductSkuDetailService;

    // 多规格 添加|更新 MODEL判断{MODEL=true 更新 | MODEL=false 新增}
    // 参数: ShopProductSkuDetailParam集合、skus{规格集合转成字符串}、bool{更新|新增}
    @Token
    @Valid
    @PostMapping("/manager/multi")
    public JSONResult<?> multi(@RequestMultiple FormData<ShopProductSkuDetailParam> data) {
        // 多规格逻辑处理
        if (null == data || null == data.getObjs() || null == data.getStr()) {
            return JSONResult.fail("提交的数据有异常,请重新提交;");
        }
        if(data.getBool()){

            if (shopProductSkuDetailService.batchEdit(data.getObjs(), data.getStr())) {
                return JSONResult.success("批量更新商品规格成功;");
            }
        }else {
            if(shopProductSkuDetailService.batchCreate(data.getObjs(),data.getStr())){
                return JSONResult.success("批量添加商品规格成功;");
            }
        }

        System.out.println(data);
        return JSONResult.fail("批量添加商品规格失败;");
    }

    @Override
    public JSONResult<?> all(String keyword, Integer pageNo) {
        return null;
    }

    @Override
    public JSONResult<?> search(Query query) {
        return null;
    }

    @Override
    public JSONResult<?> create(ShopProductSkuDetailParam record) {
        return null;
    }

    @Override
    public JSONResult<?> edit(ShopProductSkuDetailParam record) {
        return null;
    }

    @Override
    public JSONResult<?> delete(Long id) {
        return null;
    }
}
