package cn.peyton.plum.mall.service.sys.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.RealizeService;
import cn.peyton.plum.mall.bo.ShopCanvasBo;
import cn.peyton.plum.mall.mapper.pub.ShopCanvasMapper;
import cn.peyton.plum.mall.param.pub.ShopCanvasParam;
import cn.peyton.plum.mall.pojo.pub.ShopCanvas;
import cn.peyton.plum.mall.service.pub.ShopCanvasService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 画布信息 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("shopCanvasService")
public class ShopCanvasServiceImpl extends RealizeService<Long, ShopCanvas, ShopCanvasParam> implements ShopCanvasService {
    @Resource
    private ShopCanvasMapper shopCanvasMapper;

    @Override
    public BaseConvertBo<ShopCanvas, ShopCanvasParam> bo() {
        return new ShopCanvasBo();
    }

    @Override
    public IBaseMapper<Long, ShopCanvas> mapper() {
        return shopCanvasMapper;
    }

    public ShopCanvasServiceImpl () {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }
}
