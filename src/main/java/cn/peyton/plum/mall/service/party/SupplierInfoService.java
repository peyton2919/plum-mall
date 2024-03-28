package cn.peyton.plum.mall.service.party;

import cn.peyton.plum.core.inf.service.base.IRealizeService;
import cn.peyton.plum.mall.param.party.SupplierInfoParam;
import cn.peyton.plum.mall.pojo.party.SupplierInfo;

/**
 * <h3> 供应商基础信息 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:53
 * @version 1.0.0
 * </pre>
 */
public interface SupplierInfoService extends IRealizeService<Long, SupplierInfo, SupplierInfoParam> {

    /**
     * <h4>创建 供应商基础信息</h4>
     * @param param 供应商基础信息 对象
     * @param id 供应商Id
     * @return 成功 true
     */
    Boolean createJoin(SupplierInfoParam param,Long id);
}
