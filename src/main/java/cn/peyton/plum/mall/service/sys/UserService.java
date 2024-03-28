package cn.peyton.plum.mall.service.sys;

import cn.peyton.plum.core.inf.service.base.IRealizeService;
import cn.peyton.plum.core.inf.service.base.IStatusService;
import cn.peyton.plum.core.inf.service.base.IUserService;
import cn.peyton.plum.mall.param.sys.UserParam;
import cn.peyton.plum.mall.pojo.sys.User;

/**
 * <h3> 系统用户 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
public interface UserService extends IStatusService<Long>, IUserService<UserParam>, IRealizeService<Long, User, UserParam> {

    /**
     * <h4>用户注册</h4>
     * @param param 用户传参对象
     * @return 用户传参对象
     */
    UserParam reg(UserParam param);

    /**
     * <h4>联合查找</h4>
     * @param shareId 用户Id
     * @param shareType 用户类型
     * @return
     */
    UserParam findJoinById(Long shareId, Integer shareType);


}
