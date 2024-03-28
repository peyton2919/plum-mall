package cn.peyton.plum.mall.service.sys.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.RealizeService;
import cn.peyton.plum.mall.bo.SupplierLogBo;
import cn.peyton.plum.mall.mapper.sys.SupplierLogMapper;
import cn.peyton.plum.mall.param.sys.SupplierLogParam;
import cn.peyton.plum.mall.pojo.sys.SupplierLog;
import cn.peyton.plum.mall.service.sys.SupplierLogService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 供应商日志 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("supplierLogService")
public class SupplierLogServiceImpl extends RealizeService<Long, SupplierLog, SupplierLogParam> implements SupplierLogService {
    @Resource
    private SupplierLogMapper supplierLogMapper;

    @Override
    public BaseConvertBo<SupplierLog, SupplierLogParam> bo() {
        return new SupplierLogBo();
    }

    @Override
    public IBaseMapper<Long, SupplierLog> mapper() {
        return supplierLogMapper;
    }

    public SupplierLogServiceImpl () {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }
}
