package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.party.DistributionSettingParam;
import cn.peyton.plum.mall.pojo.party.DistributionSetting;

/**
 * <h4></h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.mall.bo.DistributionSettingBo
 * @date 2023年11月11日 9:55
 * @version 1.0.0
 * </pre>
 */
public class DistributionSettingBo extends BaseConvertBo<DistributionSetting, DistributionSettingParam> {
    @Override
    public DistributionSettingParam compat(DistributionSetting info) {
        return new DistributionSettingParam().compat(info);
    }

    @Override
    public DistributionSetting convert(DistributionSettingParam info) {
        return info.convert();
    }
}
