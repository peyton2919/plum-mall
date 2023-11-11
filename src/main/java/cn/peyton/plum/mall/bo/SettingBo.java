package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.SettingParam;
import cn.peyton.plum.mall.pojo.Setting;

/**
 * <h3> 系统设置 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class SettingBo extends BaseConvertBo<Setting, SettingParam> {

    @Override
    public SettingParam compat(Setting info) {
        return new SettingParam().compat(info);
    }

    @Override
    public Setting convert(SettingParam info) {
        return info.convert();
    }
}
