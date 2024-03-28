package cn.peyton.plum.mall.controller.pc.manager.pub;

import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.inf.controller.IController;
import cn.peyton.plum.core.inf.controller.RealizeController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.core.utils.base.CtrlUtils;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.mall.param.pub.AdvertParam;
import cn.peyton.plum.mall.service.pub.AdvertService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h3> 广告信息 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
@RestController
@RequestMapping("/pc/advert")
public class AdvertController extends RealizeController
        implements IController<Long,  AdvertParam> {

    @Resource
    private AdvertService advertService;

    @Token
    @Valid
    @PostMapping("/manager/search")
    @Override
    public JSONResult<?> list(Query query) {
        AdvertParam _param = new AdvertParam();
        _param.setTitle(query.getKeyword());
        // 其他处理判断
        return page(_param, new PageQuery(query.getPageNo()), advertService,true);
    }

    @Token
    @Valid
    @PostMapping("/manager/create")
    @Override
    public JSONResult<?> create(AdvertParam record) {
        record.setSrc(new CtrlUtils().convertImgPath(record.getSrc()));
        return handle(record, null,false, advertService, TIP_ADVERT,CREATE);
    }

    @Token
    @Valid
    @PostMapping("/manager/edit")
    @Override
    public JSONResult<?> edit(AdvertParam record) {
        record.setSrc(new CtrlUtils().convertImgPath(record.getSrc()));
        return handle(record, null, true, advertService, TIP_ADVERT, UPDATE);
    }

    @Token
    @Valid
    @PostMapping("/manager/delete")
    @Override
    public JSONResult<?> delete(@NotBlank(message = "广告 ID 不能为空;") @Min(value = 1,message = "Id最小值为1")Long id) {
        return handle(advertService.upDelete(id), TIP_ADVERT, DELETE);
    }
}
