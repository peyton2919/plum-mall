package cn.peyton.plum.mall.mapper.party;

import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.mall.pojo.party.ShareBind;

import java.util.List;

/**
 * <h3> 第三方用户绑定信息{用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)} Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public interface ShareBindMapper extends IBaseMapper<Long, ShareBind> {

    /**
     * <h4>根据主键Id和类型查找到对象</h4>
     * @param shareId 主键Id
     * @param shareType 类型 {用户类型 默认: 0 会员、1 顾客 2 供应商、3 用户 4 员工 5 超级管理员}
     * @return
     */
    List<ShareBind> selectByShareId(Long shareId, Integer shareType);
    // ==================================== new create method ==================================== //


}
