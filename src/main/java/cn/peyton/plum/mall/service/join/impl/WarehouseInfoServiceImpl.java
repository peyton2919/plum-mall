package cn.peyton.plum.mall.service.join.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.RealizeService;
import cn.peyton.plum.mall.bo.WarehouseInfoBo;
import cn.peyton.plum.mall.mapper.join.WarehouseInfoMapper;
import cn.peyton.plum.mall.param.join.WarehouseInfoParam;
import cn.peyton.plum.mall.pojo.join.WarehouseInfo;
import cn.peyton.plum.mall.service.join.WarehouseInfoService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

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
public class WarehouseInfoServiceImpl extends RealizeService<Integer, WarehouseInfo, WarehouseInfoParam> implements WarehouseInfoService {
    @Resource
    private WarehouseInfoMapper warehouseInfoMapper;

    @Override
    public BaseConvertBo<WarehouseInfo, WarehouseInfoParam> bo() {
        return new WarehouseInfoBo();
    }

    @Override
    public IBaseMapper<Integer, WarehouseInfo> mapper() {
        return warehouseInfoMapper;
    }
    public WarehouseInfoServiceImpl() {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }


    @Override
    public List<WarehouseInfoParam> findByDownList() {
        String key = keyPrefix + "_202312251535";
        Object objs = getCache(key);
        if (null == objs) {
            List<WarehouseInfoParam> res = bo().adapter(warehouseInfoMapper.selectByDownList());
            saveCache(key, res);
            return res;
        }
        return (List<WarehouseInfoParam>) objs;
    }
}
