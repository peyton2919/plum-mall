package cn.peyton.plum.mall.service.party.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.RealizeService;
import cn.peyton.plum.mall.bo.SupplierInfoBo;
import cn.peyton.plum.mall.mapper.party.SupplierInfoMapper;
import cn.peyton.plum.mall.mapper.party.SupplierMapper;
import cn.peyton.plum.mall.param.party.SupplierInfoParam;
import cn.peyton.plum.mall.pojo.party.SupplierInfo;
import cn.peyton.plum.mall.service.party.SupplierInfoService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <h3> 供应商基础信息 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:53
 * @version 1.0.0
 * </pre>
 */
@Service("supplierInfoService")
public class SupplierInfoServiceImpl extends RealizeService<Long, SupplierInfo, SupplierInfoParam> implements SupplierInfoService {
    @Resource
    private SupplierInfoMapper supplierInfoMapper;
    @Resource
    private SupplierMapper supplierMapper;
    @Override
    public BaseConvertBo<SupplierInfo, SupplierInfoParam> bo() {
        return new SupplierInfoBo();
    }

    @Override
    public IBaseMapper<Long, SupplierInfo> mapper() {
        return supplierInfoMapper;
    }

    public SupplierInfoServiceImpl () {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }

    @Override
    @Transactional
    public Boolean createJoin(SupplierInfoParam param,Long id) {
        SupplierInfo result = param.convert();
        int res = supplierInfoMapper.insertSelective(result);
        if (res > 0) {
            res = supplierMapper.updateInfo(id, result.getId());
            if (res > 0) {
               clearCache("更新供应商信息");
            }
            return true;
        }
        return false;
    }
}
