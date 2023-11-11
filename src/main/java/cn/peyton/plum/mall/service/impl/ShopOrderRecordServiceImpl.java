package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractAppRealizeService;
import cn.peyton.plum.mall.bo.ShopOrderRecordBo;
import cn.peyton.plum.mall.mapper.ShopOrderRecordMapper;
import cn.peyton.plum.mall.param.ShopOrderRecordParam;
import cn.peyton.plum.mall.pojo.ShopOrderRecord;
import cn.peyton.plum.mall.service.ShopOrderRecordService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 订单操作记录 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("shopOrderRecordService")
public class ShopOrderRecordServiceImpl extends AbstractAppRealizeService<Long, ShopOrderRecord, ShopOrderRecordParam> implements ShopOrderRecordService {
    @Resource
    private ShopOrderRecordMapper shopOrderRecordMapper;

    @Override
    public BaseConvertBo<ShopOrderRecord, ShopOrderRecordParam> initBo() {
        return new ShopOrderRecordBo();
    }

    @Override
    public IBaseMapper<Long, ShopOrderRecord> initMapper() {
        return shopOrderRecordMapper;
    }

}
