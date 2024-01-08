package cn.peyton.plum.mall.mapper.sys;

import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.mapper.IUserMapper;
import cn.peyton.plum.mall.pojo.sys.User;
import org.apache.ibatis.annotations.Update;


/**
 * <h3> 系统用户 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public interface UserMapper extends IBaseMapper<Long, User>, IUserMapper<User> {
    /**
     * <h>更新状态</h>
     * @param id 主键Id
     * @param status 状态值 1 可用 0 禁用
     * @return 受影响行数 > 0 成功
     */
    @Update("update sys_user set status=#{status} where id=#{id} and is_del = 1")
    int upStatus(Long id, Integer status);

}
