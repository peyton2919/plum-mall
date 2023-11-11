package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractAppRealizeService;
import cn.peyton.plum.mall.bo.SupplierLogBo;
import cn.peyton.plum.mall.mapper.SupplierLogMapper;
import cn.peyton.plum.mall.param.SupplierLogParam;
import cn.peyton.plum.mall.pojo.SupplierLog;
import cn.peyton.plum.mall.service.SupplierLogService;
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
public class SupplierLogServiceImpl extends AbstractAppRealizeService<Long, SupplierLog, SupplierLogParam> implements SupplierLogService {
    @Resource
    private SupplierLogMapper supplierLogMapper;

    @Override
    public BaseConvertBo<SupplierLog, SupplierLogParam> initBo() {
        return new SupplierLogBo();
    }

    @Override
    public IBaseMapper<Long, SupplierLog> initMapper() {
        return supplierLogMapper;
    }

}
