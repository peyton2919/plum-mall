package cn.peyton.plum.mall.service.sys.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.RealizeService;
import cn.peyton.plum.mall.bo.SettingBo;
import cn.peyton.plum.mall.mapper.sys.SettingMapper;
import cn.peyton.plum.mall.param.sys.SettingParam;
import cn.peyton.plum.mall.pojo.sys.Setting;
import cn.peyton.plum.mall.service.sys.SettingService;
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
public class SettingServiceImpl extends RealizeService<Integer, Setting, SettingParam> implements SettingService {
    @Resource
    private SettingMapper settingMapper;

    @Override
    public BaseConvertBo<Setting, SettingParam> bo() {
        return new SettingBo();
    }

    @Override
    public IBaseMapper<Integer, Setting> mapper() {
        return settingMapper;
    }

    public SettingServiceImpl() {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }
}
