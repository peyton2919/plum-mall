package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.mall.bo.SupplierBo;
import cn.peyton.plum.mall.mapper.SupplierMapper;
import cn.peyton.plum.mall.param.SupplierParam;
import cn.peyton.plum.mall.pojo.Supplier;
import cn.peyton.plum.mall.service.SupplierService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 供应商信息 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:53
 * @version 1.0.0
 * </pre>
 */
@Service("supplierService")
public class SupplierServiceImpl extends AbstractRealizeService<Long, Supplier, SupplierParam> implements SupplierService {
    @Resource
    private SupplierMapper supplierMapper;

    @Override
    public BaseConvertBo<Supplier, SupplierParam> initBo() {
        return new SupplierBo();
    }

    @Override
    public IBaseMapper<Long, Supplier> initMapper() {
        return supplierMapper;
    }

}
