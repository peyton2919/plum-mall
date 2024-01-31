package cn.peyton.plum.mall.service.party;

import cn.peyton.plum.core.inf.service.IBaseService;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.mall.param.party.UserAddressParam;

import java.util.List;

/**
 * <h3> 用户地址{用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)} Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:53
 * @version 1.0.0
 * </pre>
 */
public interface UserAddressService extends IBaseService<Long, cn.peyton.plum.mall.pojo.party.UserAddress, UserAddressParam> {


    /**
     * <h4>根据主键Id和类型查找到对象</h4>
     * @param shareId 主键Id
     * @param shareType 类型 {用户类型 默认: 0 会员、1 顾客 2 供应商、3 用户 4 员工 5 超级管理员}
     * @return 对象集合
     */
    List<UserAddressParam> findByShareId(Long shareId, Integer shareType);

    /**
     * <h4>更新最后一次使用时间</h4>
     * @param id 主键Id
     * @param lastUsedTime 最后使用时间
     * @return 受影响的行数 > 0 成功
     */
    boolean upLastUsedTime(Long id, Integer lastUsedTime);

    /**
     * <h4>根据主键Id和类型查找到对象</h4>
     * @param shareId 主键Id
     * @param shareType 类型 {用户类型 默认: 0 会员、1 顾客 2 供应商、3 用户 4 员工 5 超级管理员}
     * @param page 分页对象
     * @return 对象集合
     */
    List<UserAddressParam> findAndroidByShareId(Long shareId, Integer shareType, PageQuery page);
}
