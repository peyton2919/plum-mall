package cn.peyton.plum.mall.mapper.party;

import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.mall.pojo.party.UserAddress;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <h3> 用户地址{用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)} Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public interface UserAddressMapper extends IBaseMapper<Long, UserAddress> {
    /**
     * <h4>根据主键Id和类型查找到对象</h4>
     * @param shareId 主键Id
     * @param shareType 类型 {用户类型 默认: 0 会员、1 顾客 2 供应商、3 用户 4 员工 5 超级管理员}
     * @return 对象集合
     */
    List<UserAddress> selectByShareId(Long shareId, Integer shareType);

    /**
     * <h4>更新最后一次使用时间</h4>
     * @param id 主键Id
     * @param lastUsedTime 最后使用时间
     * @return 受影响的行数 > 0 成功
     */
    @Update("update tb_user_address set last_used_time=#{lastUsedTime} where id=#{id}")
    int upLastUsedTime(Long id, Integer lastUsedTime);
    // ==================================== new create method ==================================== //


}
