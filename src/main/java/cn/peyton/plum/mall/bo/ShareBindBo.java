package cn.peyton.plum.mall.bo;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.mall.param.party.ShareBindParam;
import cn.peyton.plum.mall.pojo.party.ShareBind;

/**
 * <h3> 第三方用户绑定信息{用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)} 数据转换 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:07:14
 * @version 1.0.0
 * </pre>
 */
public class ShareBindBo extends BaseConvertBo<ShareBind, ShareBindParam> {

    @Override
    public ShareBindParam compat(ShareBind info) {
        return new ShareBindParam().compat(info);
    }

    @Override
    public ShareBind convert(ShareBindParam info) {
        return info.convert();
    }
}
