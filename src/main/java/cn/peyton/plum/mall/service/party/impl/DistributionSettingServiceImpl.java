package cn.peyton.plum.mall.service.party.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.mall.bo.DistributionSettingBo;
import cn.peyton.plum.mall.mapper.party.DistributionSettingMapper;
import cn.peyton.plum.mall.param.party.DistributionSettingParam;
import cn.peyton.plum.mall.pojo.party.DistributionSetting;
import cn.peyton.plum.mall.service.party.DistributionSettingService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 分销设置 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("distributionSettingService")
public class DistributionSettingServiceImpl extends AbstractRealizeService<Long, DistributionSetting, DistributionSettingParam> implements DistributionSettingService {
    @Resource
    private DistributionSettingMapper distributionSettingMapper;

    @Override
    public BaseConvertBo<DistributionSetting, DistributionSettingParam> initBo() {
        return new DistributionSettingBo();
    }

    @Override
    public IBaseMapper<Long, DistributionSetting> initMapper() {
        return distributionSettingMapper;
    }

    public DistributionSettingServiceImpl() {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }
}
