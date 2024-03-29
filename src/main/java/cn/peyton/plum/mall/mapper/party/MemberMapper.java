package cn.peyton.plum.mall.mapper.party;

import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.mapper.IUserMapper;
import cn.peyton.plum.mall.pojo.party.Member;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <h3> 会员 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public interface MemberMapper extends IBaseMapper<Long, Member>, IUserMapper<Member> {
    /**
     * <h4>根据 会员等级Id 查找 </h4>
     * @param levelId 会员等级Id
     * @return 返回 > 0 表示 会员与等级有关联
     */
    int isMemberLevel(Integer levelId);

    /**
     * <h4>删除会员</h4>
     * @param id 会员Id
     * @return 受影响的行数 > 0 成功
     */
    //int updateDeleteStatus(Long id);

    /**
     * <h4>根据Id 查找 简单对象</h4>
     * <pre>
     *     `id`,`username`,`avatar`,`nickname`,`phone`,`email`,`loc`,`sex`,`birthday`,create_time`
     * </pre>
     * @param id 会员Id
     * @return 会员对象
     */
    Member selectSimpleById(Long id);
    /**
     * <h4>根据Id 查找 简单对象</h4>
     * <pre>
     *     `id`,`username`,`avatar`,`nickname`,`phone`,`email`,`level_id`
     * </pre>
     * @param id 会员Id
     * @return 会员对象
     */
    Member selectByForeignKey(Long id);
    /**
     * <h4>根据Id 查找 简单对象</h4>
     * <pre>
     *     `id`,`username`,`avatar`,`nickname`,`phone`,`email`
     * </pre>
     * @param id 会员Id
     * @return 会员对象
     */
    Member selectJoinById(Long id);

    /**
     * <h4>下拉框查找</h4>
     * <pre>
     *     `id`,`username`,`avatar`,`nickname`,`phone`,`email`,`level_id`
     *     用于下拉框使用
     * </pre>
     * @return 会员对象集合
     */
    List<Member> selectByDownList();

    // ==================================== new create method ==================================== //
    /**
     * <h>更新状态</h>
     * @param id 主键Id
     * @param status 状态值 1 可用 0 禁用
     * @return 受影响行数 > 0 成功
     */
    @Update("update tb_member set status=#{status} where id=#{id} and is_del = 1")
    int upStatus(Long id, Integer status);

}
