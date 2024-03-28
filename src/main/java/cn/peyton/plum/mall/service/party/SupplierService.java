package cn.peyton.plum.mall.service.party;

import cn.peyton.plum.core.inf.service.base.*;
import cn.peyton.plum.mall.param.party.SupplierParam;
import cn.peyton.plum.mall.pojo.party.Supplier;

/**
 * <h3> 供应商信息 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:53
 * @version 1.0.0
 * </pre>
 */
public interface SupplierService extends IStatusService<Long>, IDeleteService<Long>, IDownListService<SupplierParam>,
        IRealizeService<Long, Supplier, SupplierParam>, IUserService<SupplierParam> {

    /**
     * <h4>更新供应商基础信息Id</h4>
     * @param id 供应商Id
     * @param infoId 供应商基础信息Id
     * @return 受影响行数 > 0 成功
     */
    Boolean updateInfo(Long id, Long infoId);
}
