package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractAppRealizeService;
import cn.peyton.plum.mall.bo.WarehouseInfoBo;
import cn.peyton.plum.mall.mapper.WarehouseInfoMapper;
import cn.peyton.plum.mall.param.WarehouseInfoParam;
import cn.peyton.plum.mall.pojo.WarehouseInfo;
import cn.peyton.plum.mall.service.WarehouseInfoService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 仓库信息 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:53
 * @version 1.0.0
 * </pre>
 */
@Service("warehouseInfoService")
public class WarehouseInfoServiceImpl extends AbstractAppRealizeService<Integer, WarehouseInfo, WarehouseInfoParam> implements WarehouseInfoService {
    @Resource
    private WarehouseInfoMapper warehouseInfoMapper;

    @Override
    public BaseConvertBo<WarehouseInfo, WarehouseInfoParam> initBo() {
        return new WarehouseInfoBo();
    }

    @Override
    public IBaseMapper<Integer, WarehouseInfo> initMapper() {
        return warehouseInfoMapper;
    }

}
