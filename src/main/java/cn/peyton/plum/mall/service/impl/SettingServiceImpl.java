package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.mall.bo.SettingBo;
import cn.peyton.plum.mall.mapper.SettingMapper;
import cn.peyton.plum.mall.param.SettingParam;
import cn.peyton.plum.mall.pojo.Setting;
import cn.peyton.plum.mall.service.SettingService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 系统设置 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("settingService")
public class SettingServiceImpl extends AbstractRealizeService<Integer, Setting, SettingParam> implements SettingService {
    @Resource
    private SettingMapper settingMapper;

    @Override
    public BaseConvertBo<Setting, SettingParam> initBo() {
        return new SettingBo();
    }

    @Override
    public IBaseMapper<Integer, Setting> initMapper() {
        return settingMapper;
    }

}
